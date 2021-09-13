package lt.mif.vu;

import lt.mif.vu.domain.ValidationRule;

public class PhoneNumberValidator implements IPhoneNumberValidator {

    private ValidationRule validationRule;

    public PhoneNumberValidator() {

    }

    public PhoneNumberValidator(ValidationRule validationRule) {
        this.validationRule = validationRule;
    }

    @Override
    public void validate(String phoneNumber) {

    }

    private void validateOnlyNumbers(String phoneNumber) {

    }

    private void normalizePhoneNumber(String phoneNumber) {

    }

}
