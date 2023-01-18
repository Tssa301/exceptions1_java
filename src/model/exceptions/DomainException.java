package model.exceptions;

public class DomainException extends RuntimeException {

    //Allows instantiating the custom exception by passing a message.
    public DomainException(String msg){
        super(msg);
    }
}
