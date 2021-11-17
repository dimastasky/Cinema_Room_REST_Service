package cinema.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Cinema {

    @JsonProperty("total_rows")
    private int totalRows;

    @JsonProperty("total_columns")
    private int totalColumns;

    @JsonProperty("available_seats")
    @Getter
    private Seat[] seats;

    public Cinema() {
        Seat[] seatArray = new Seat[81];
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                int price = i <= 4 ? 10 : 8;
                Seat s = new Seat(i,j, price);
                seatArray[(i - 1) * 9 + j-1] = s;
            }
        }

        totalRows = 9;
        totalColumns = 9;
        seats = seatArray;
    }

    @JsonIgnore
    public int getArrayPosition(int row, int column) {
        return (row-1)*9 + column-1;
    }

    @JsonIgnore
    public Optional<Seat> findSeat(Token token) {
        return Arrays.stream(seats)
                .filter(x -> x.getToken().equals(token.toString()))
                .findFirst();
    }

    @JsonIgnore
    public List<Seat> getTakenSeats() {
        return Arrays.stream(seats).filter(Seat::isTaken).collect(Collectors.toList());
    }

    @JsonIgnore
    public int getNumOfAvailableSeats() {
        return seats.length - getTakenSeats().size();
    }

    @JsonIgnore
    public int getNumOfPurchasedTickets() {
        return getTakenSeats().size();
    }

    @JsonIgnore
    public int getIncome() {
        return getTakenSeats().stream().mapToInt(Seat::getPrice).sum();
    }

    @JsonIgnore
    public String getStats() {
        return String.format("{\n" +
                "    \"current_income\": %s,\n" +
                "    \"number_of_available_seats\": %s,\n" +
                "    \"number_of_purchased_tickets\": %s\n" +
                "}", getIncome(), getNumOfAvailableSeats(), getNumOfPurchasedTickets());
    }

}
