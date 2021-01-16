package Franciscobusleiman.recipes.recipes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NumberFormatsException extends RuntimeException{

    public NumberFormatsException(){
        super();
    }

    public NumberFormatsException(String message){
        super(message);
    }

    public NumberFormatsException(String message, Throwable cause){
        super(message, cause);
    }
}
