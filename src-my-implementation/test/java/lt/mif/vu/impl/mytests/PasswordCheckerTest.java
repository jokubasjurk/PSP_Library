package lt.mif.vu.impl.mytests;

import lt.mif.vu.impl.PasswordChecker;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class PasswordCheckerTest {

    private static final PasswordChecker passwordChecker = new PasswordChecker();

    @Test
    public void failsWithSingleCustomSpecialCharacter() {
        passwordChecker.setSpecialCharacters(Collections.singletonList('!'));
        assertFalse(passwordChecker.isPasswordValid("petrauskas@", 5));
    }

    @Test
    public void succeedsWithCustomSpecialCharacters() {
        passwordChecker.setSpecialCharacters(Arrays.asList('<','>'));
        assertFalse(passwordChecker.isPasswordValid("petr<auskas", 5));
        assertFalse(passwordChecker.isPasswordValid("petr>auskas", 5));
    }
}