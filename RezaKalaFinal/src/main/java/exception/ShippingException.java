package exception;

public class ShippingException extends RuntimeException {
    ShippingException(String message) {
        super("Shipping Exception: " + message);
    }
}