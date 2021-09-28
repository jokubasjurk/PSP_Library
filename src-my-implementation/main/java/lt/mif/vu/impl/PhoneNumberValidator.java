package lt.mif.vu.impl;

public class PhoneNumberValidator {

    private final String countryCode;
    private final String areaCode;
    private final int length;

    public PhoneNumberValidator() {
        this("+370", "8", 11);
    }

    public PhoneNumberValidator(String countryCode, String areaCode, int length) {
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.length = length;
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return false;
        }
        String convertedNumber = getConvertedPhoneNumber(phoneNumber);
        return isValidLength(convertedNumber) && containsOnlyDigits(convertedNumber);
    }

    private boolean isValidLength(String convertedNumber) {
        String tempNumber = convertedNumber;
        if (convertedNumber.contains("+")) {
            tempNumber = convertedNumber.substring(1);
        }
        return tempNumber.length() == length;
    }

    public boolean containsOnlyDigits(String phoneNumber) {
        if (phoneNumber.indexOf("+") == 0) {
            phoneNumber = phoneNumber.substring(1);
        }
        return phoneNumber.chars().allMatch(Character::isDigit);
    }

    public String getConvertedPhoneNumber(String phoneNumber) {
        return phoneNumber == null || phoneNumber.startsWith(countryCode)
                ? phoneNumber
                : countryCode + phoneNumber.substring(areaCode.length());
    }
}