package cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ticketAlreadyPurchased extends RuntimeException{
    public ticketAlreadyPurchased() {
        super("\"error\": \"The ticket has been already purchased!\"");
    }
}