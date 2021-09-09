package lt.mif.vu;

import lt.mif.vu.exception.IllegalEmailCharactersException;
import lt.mif.vu.exception.InvalidEmailDomainException;
import lt.mif.vu.exception.InvalidEmailFormatException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailValidatorTest {
    private static final IEmailValidator emailValidator = new EmailValidator();

    @Test
    public void validatesEmailDoesNotThrow() {
        String email = "eta@eta.lt";
        emailValidator.validate(email);
    }

    @Test
    public void validatesEmailThrowsIllegalCharactersException() {
        String email = "%##@eta.lt";
        assertThrows(IllegalEmailCharactersException.class, () -> emailValidator.validate(email));
    }

    @Test
    public void validatesEmailDomainThrowsInvalidEmailDomainException() {
        String email = "eta@.00";
        assertThrows(InvalidEmailDomainException.class, () -> emailValidator.validate(email));
    }
    @Test
    public void validatesEmailAtSignThrowsInvalidEmailFormatException() {
        String email = "eta";
        assertThrows(InvalidEmailFormatException.class, () -> emailValidator.validate(email));
    }
}
