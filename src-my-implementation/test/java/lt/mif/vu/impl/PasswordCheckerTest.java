package lt.mif.vu.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordCheckerTest {

    @Test
    public void testPasswordWithNoUppercaseLetters() {
        PasswordChecker passwordChecker = new PasswordChecker();
        boolean containsUpperCase = passwordChecker.isPasswordValid("petrauskas", 5);
        assertFalse(containsUpperCase);
    }

    @Test
    public void testPasswordWithNoSpecialSymbols() {
        PasswordChecker passwordChecker = new PasswordChecker();
        boolean containsSpecialSymbol = passwordChecker.isPasswordValid("petrauskAs", 5);
        assertFalse(containsSpecialSymbol);
    }

    @Test
    public void testPasswordTooShort() {
        PasswordChecker passwordChecker = new PasswordChecker();
        boolean isValidLength = passwordChecker.isPasswordValid("petrauskas", 15);
        assertFalse(isValidLength);
    }

    @Test
    public void testCorrectPassword() {
        PasswordChecker passwordChecker = new PasswordChecker();
        boolean isCorrect = passwordChecker.isPasswordValid("Petrauskas!123", 5);
        assertTrue(isCorrect);
    }
}