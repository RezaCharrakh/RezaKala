package exception;

public class InStockException extends ShippingException {
    public InStockException() {
        super("In stock exception exception!");
    }
    InStockException(String message) {
        super(message);
    }
}
