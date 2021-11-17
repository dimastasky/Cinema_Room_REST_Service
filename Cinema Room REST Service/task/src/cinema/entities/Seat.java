package cinema.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
public class Seat {

    @NonNull
    private int row;

    @NonNull
    private int column;

    @NonNull
    private int price;

    @JsonIgnore
    @Setter
    private boolean isTaken = false;

    @JsonIgnore
    private final String token = new Token().toString();


    public String bookSeat() {
        setTaken(true);
        return String.format("{\n" +
                        "    \"token\": \"%s\",\n" +
                        "    \"ticket\": {\n" +
                        "        \"row\": %s,\n" +
                        "        \"column\": %s,\n" +
                        "        \"price\": %s\n" +
                        "    }\n" +
                        "}",
                getToken(), getRow(), getColumn(), getPrice());
    }

    public String returnSeat() {
        setTaken(false);
        return String.format("{\n" +
                        "    \"returned_ticket\": {\n" +
                        "        \"row\": %s,\n" +
                        "        \"column\": %s,\n" +
                        "        \"price\": %s\n" +
                        "    }\n" +
                        "}",
                getRow(),getColumn(),getPrice());
    }


}
