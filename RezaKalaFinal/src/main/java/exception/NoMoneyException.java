package exception;

public class NoMoneyException extends ShippingException {
    public NoMoneyException() {
        super("No money exception!");
    }
    NoMoneyException(String message) {
        super(message);
    }
}
