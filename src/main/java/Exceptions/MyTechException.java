package Exceptions;

public class MyTechException extends Exception {
    public MyTechException(String message, Exception cause)  {
        super(message, cause);
    }

    public MyTechException(String message) {
        super(message);
    }

    public MyTechException(Exception exception){
        super(exception);
    }


}
