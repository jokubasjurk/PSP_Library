package lt.mif.vu;

import lt.mif.vu.domain.ValidationRule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneNumberValidatorTest {
    private static final PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();

    @Test
    public void validatesPhoneNumberDoesNotThrow() {
        String phoneNumber = "+37062587458";
        phoneNumberValidator.validate(phoneNumber);
    }

    @Test
    public void normalizesPhoneNumber() {
        String phoneNumber = "862587458";
        phoneNumberValidator.normalizePhoneNumber(phoneNumber);
        assertEquals("+37062587458", phoneNumber);
    }

    @Test
    public void checksCustomValidationRuleDoesNotThrow() {
        String phoneNumber = "1111";
        PhoneNumberValidator customPhoneNumberValidator = new PhoneNumberValidator(new ValidationRule("11", 4));
        customPhoneNumberValidator.validate(phoneNumber);
    }
}
