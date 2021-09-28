package lt.mif.vu.impl
        ;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneNumberValidatorTest {
    @Test
    public void testPhoneNumberPrefix() {
        PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator("+370", "8", 11);
        String phoneNumber = "861234567";
        String fixedNumber = phoneNumberValidator.getConvertedPhoneNumber(phoneNumber);
        assertEquals(fixedNumber, "+37061234567");
    }

    @Test
    public void testPhoneNumberWithInvalidSymbols() {
        PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator("+370", "8", 11);;
        boolean isValid = phoneNumberValidator.isValidPhoneNumber("8x61234567");
        assertFalse(isValid);
    }

    @Test
    public void testPhoneNumberCorrect() {
        PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator("+370", "8", 11);;
        boolean isValid = phoneNumberValidator.isValidPhoneNumber("+37061234567");
        assertTrue(isValid);
    }
}
