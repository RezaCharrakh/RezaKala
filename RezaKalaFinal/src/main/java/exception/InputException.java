package exception;

public class InputException extends RuntimeException {
    public InputException(String message) {
        super("Input Exception: " + message);
    }
}
