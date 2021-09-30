package lt.mif.vu.impl;

import java.util.Arrays;
import java.util.List;

import static lt.mif.vu.impl.constants.Constants.DEFAULT_SPECIAL_CHARACTERS;

public class EmailValidator {

    private List<Character> specialCharacters;

    public EmailValidator() {
        this.specialCharacters = DEFAULT_SPECIAL_CHARACTERS;
    }

    public EmailValidator(List<Character> specialCharacters) {
        this.specialCharacters = specialCharacters;
    }

    public void setSpecialCharacters(List<Character> specialCharacters) {
        this.specialCharacters = specialCharacters;
    }

    public boolean isEmailValid(String email) {
        if (hasValidEmailFormat(email)) {
            return emailHasLegalCharactersOnly(email) && isDomainValid(getDomain(email));
        }
        return false;
    }

    private boolean hasValidEmailFormat(String email) {
        return email != null
                && email.contains(".")
                && email.chars().filter(c -> c == '@').count() == 1
                && email.indexOf("@") != 0
                && email.indexOf("@") != email.length() - 1
                && email.length() > email.indexOf("@");
    }

    private String getDomain(String email) {
        return email.substring(email.indexOf('@') + 1);
    }

    private boolean emailHasLegalCharactersOnly(String emailPart) {
        return specialCharacters.stream().noneMatch(character -> character != '@' && emailPart.contains(character.toString()));
    }

    private boolean isDomainValid(String domain) {
        List<String> subdomains = Arrays.asList(domain.split("\\."));
        return domain.length() >= 2 && domain.length() <= 253 && subdomains.stream()
                .noneMatch(s -> s.length() < 2
                        || (s.charAt(0) == '-' || s.charAt(s.length() - 1) == '-'))
                && (long) subdomains.size() > domain.chars().filter(c -> c == '.').count();
    }
}