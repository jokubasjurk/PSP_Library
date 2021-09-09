package lt.mif.vu.exception;

public class IllegalEmailCharactersException extends Exception {
    public IllegalEmailCharactersException() {
        super("Email contains illegal characters");
    }
}
