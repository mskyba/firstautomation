package check;

public class WrongPasswordException extends RuntimeException {
    private String info;

    public WrongPasswordException() {
        info = "Incorrect password";
    }

    public WrongPasswordException(String message) {
        super(message);
        info = message;
    }

    @Override
    public String toString() {
        return "check.WrongLoginException: " + info;
    }
}

