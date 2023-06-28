package exception;

public class InvalidPhoneNumber extends InputException {
    public InvalidPhoneNumber() {
        super("Invalid Phone number!");
    }
    InvalidPhoneNumber(String message) {
        super(message);
    }
}
