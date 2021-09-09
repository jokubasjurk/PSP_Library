package lt.mif.vu.exception;

public class InvalidEmailFormatException extends Exception {
    public InvalidEmailFormatException() {
        super("Email is missing @ sign");
    }
}
