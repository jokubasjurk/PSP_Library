package lt.mif.vu.impl;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailValidatorTest {

    @Test
    public void testEmailWithNoAtSymbol() {
        EmailValidator emailValidator = new EmailValidator();
        String testEmail = "aivarasgmail.com";
        assertFalse(emailValidator.isEmailValid(testEmail));
    }

    @Test
    public void testEmailWithNoInvalidSymbol() {
        EmailValidator emailValidator = new EmailValidator();
        String testEmail = "aivaras@outlook.com";
        assertTrue(emailValidator.isEmailValid(testEmail));
    }

    @Test
    public void testEmailWithCorrectDomain() {
        EmailValidator emailValidator = new EmailValidator();
        String testEmail = "aivaras@gmail.com";
        assertTrue(emailValidator.isEmailValid(testEmail));
    }

    @Test
    public void testEmailWithWrongDomain() {
        EmailValidator emailValidator = new EmailValidator();
        String testEmail = "aivaras@uuuuuuuuu.com";
        assertTrue(emailValidator.isEmailValid(testEmail));
    }

    @Test
    public void testEmailWithInvalidSymbol() {
        EmailValidator emailValidator = new EmailValidator();
        String testEmail = "aivaras@<><>.com";
        assertFalse(emailValidator.isEmailValid(testEmail));
    }
}