package lt.mif.vu.impl.mytests;

import lt.mif.vu.impl.PhoneNumberValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneNumberValidatorTest {

    @Test
    public void testSameCountryAndAreaCodeConvert() {
        PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator("+370", "+370", 11);
        assertEquals(phoneNumberValidator.getConvertedPhoneNumber("+37064824587"), "+37064824587");
    }

    @Test
    public void testCountryCode() {
        PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator("+011", "5", 5);
        assertEquals(phoneNumberValidator.getConvertedPhoneNumber("51"), "+0111");
    }

    @Test
    public void failsWithInvalidLength() {
        PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator("+011", "5", 5);
        assertFalse(phoneNumberValidator.isValidPhoneNumber("5155"));
    }
}
