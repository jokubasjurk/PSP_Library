package lt.mif.vu.exception;

public class InvalidPasswordFormatException extends Exception {
    public InvalidPasswordFormatException() {
        super("Invalid password format");
    }
}
