package model.exceptions;

public class BadType extends RuntimeException {
    private String messsage;

    public BadType(String messsage) {
        this.messsage = messsage;
    }

    public BadType(String message, String messsage) {
        super(message);
        this.messsage = messsage;
    }

    public BadType(String message, Throwable cause, String messsage) {
        super(message, cause);
        this.messsage = messsage;
    }

    public BadType(Throwable cause, String messsage) {
        super(cause);
        this.messsage = messsage;
    }

    public BadType(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String messsage) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.messsage = messsage;
    }
}
