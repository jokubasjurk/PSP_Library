package lt.mif.vu.impl;

public class PhoneNumberValidator {

    private static final String LT_COUNTRY_CODE = "+370";
    private static final String LT_AREA_CODE = "8";
    private static final int LT_PHONE_LENGTH = 11;
    private String countryCode;
    private String areaCode;
    private int length;

    public PhoneNumberValidator() {
        this(LT_COUNTRY_CODE, LT_AREA_CODE, LT_PHONE_LENGTH);
    }

    public PhoneNumberValidator(String countryCode, String areaCode, int length) {
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.length = length;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public void setLength(int length) {
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
        if (convertedNumber.contains("+")) {
            convertedNumber = convertedNumber.substring(1);
        }
        return convertedNumber.length() == length;
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