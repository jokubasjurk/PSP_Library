package lt.mif.vu;

import lt.mif.vu.exception.InvalidPasswordFormatException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PasswordCheckerTest {

    private static final PasswordChecker passwordChecker = new PasswordChecker();

    @Test
    public void validatesPasswordDoesNotThrow() {
        String password = "Test123$";
        passwordChecker.validate(password);
    }

    @Test
    public void validatesPasswordThrowsInvalidPasswordFormatException() {
        String password = "test#";
        assertThrows(InvalidPasswordFormatException.class, () -> passwordChecker.validate(password));
    }

    @Test
    public void validatesPasswordForSpecialCharactersThrowsInvalidPasswordFormatException() {
        String password = "Test123";
        assertThrows(InvalidPasswordFormatException.class, () -> passwordChecker.validate(password));
    }
}
