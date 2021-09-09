package lt.mif.vu.exception;

public class InvalidEmailDomainException extends Exception {
    public InvalidEmailDomainException() {
        super("Email has invalid domain");
    }
}
