package check;

public class WrongLoginException extends RuntimeException {
    private String info;

    public WrongLoginException() {
        info = "Incorrect login";
    }

    public WrongLoginException(String message) {
        super(message);
        info = message;
    }

    @Override
    public String toString() {
        return "check.WrongLoginException: " + info;
    }
}

