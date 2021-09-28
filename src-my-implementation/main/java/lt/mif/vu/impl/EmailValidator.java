package lt.mif.vu.impl;

import java.util.Arrays;
import java.util.List;

import static lt.mif.vu.impl.constants.Constants.DEFAULT_SPECIAL_CHARACTERS;

public class EmailValidator {

    public boolean isEmailValid(String email) {
        if (hasValidEmailFormat(email)) {
            return emailHasLegalCharactersOnly(email) && isDomainValid(getDomain(email));
        }
        return false;
    }

    private boolean hasValidEmailFormat(String email) {
        return email != null
                && email.contains("@")
                && email.contains(".")
                && email.chars().filter(c -> c == '@').count() == 1
                && email.indexOf("@") != 0
                && email.indexOf("@") != email.length() - 1
                && email.length() >= email.indexOf("@") + 1;
    }

    private String getDomain(String email) {
        return email.substring(email.indexOf('@') + 1);
    }

    private boolean emailHasLegalCharactersOnly(String emailPart) {
        return DEFAULT_SPECIAL_CHARACTERS.stream().noneMatch(character -> character != '@' && emailPart.contains(character.toString()));
    }

    private boolean isDomainValid(String domain) {
        List<String> subdomains = Arrays.asList(domain.split("\\."));
        boolean domainInvalid = subdomains.stream()
                .anyMatch(s -> s.length() < 2 ||
                        (s.contains("-") && (s.indexOf("-") == 0 || s.indexOf("-") == s.length() - 1)));
        if (!domainInvalid) {
            domainInvalid = (long) subdomains.size() <= domain.chars().filter(c -> c == '.').count();
        }
        if (!domainInvalid) {
            domainInvalid = domain.length() < 2 || domain.length() > 253;
        }
        return !domainInvalid;
    }
}