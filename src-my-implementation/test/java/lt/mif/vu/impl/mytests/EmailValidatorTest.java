package lt.mif.vu.impl.mytests;

import lt.mif.vu.impl.EmailValidator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class EmailValidatorTest {

    private static final EmailValidator emailValidator = new EmailValidator();

    @Test
    public void failsWithCustomSpecialCharacters() {
        emailValidator.setSpecialCharacters(Arrays.asList('\"','{','}'));
        assertFalse(emailValidator.isEmailValid("testas@test\".com"));
        assertFalse(emailValidator.isEmailValid("testas@test{.com"));
        assertFalse(emailValidator.isEmailValid("testas@test}.com"));
    }

    @Test
    public void failsWithInvalidSubDomains() {
        assertFalse(emailValidator.isEmailValid("test@testas.c.o.m"));
    }

    @Test
    public void failsWithIncorrectFormat() {
        assertFalse(emailValidator.isEmailValid("test@testas..com"));
    }
}