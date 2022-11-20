package model.exceptions;

public class InvalidExpression extends RuntimeException {
    private String message;

    public InvalidExpression(String message) {
        this.message = message;
    }

    public InvalidExpression(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public InvalidExpression(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }

    public InvalidExpression(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }

    public InvalidExpression(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
    }
}
