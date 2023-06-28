package exception;

public class InvalidEmail extends InputException {
    public InvalidEmail() {
            super("Invalid Email!");
    }
    InvalidEmail(String message) {
        super(message);
    }

}
