package lt.mif.vu;

import java.util.Collections;
import java.util.List;

public class EmailValidator implements IEmailValidator {
    private List<Character> illegalCharacters = Collections.emptyList();

    public EmailValidator() {
    }

    @Override
    public void validate(String email) {
        checkEmailAtSignExists(email);
        checkEmailSpecialCharacters(email);
        checkEmailDomain(email);
    }

    private void checkEmailAtSignExists(String email) {

    }

    private void checkEmailSpecialCharacters(String email) {

    }

    private void checkEmailDomain(String email) {

    }
}
