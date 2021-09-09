package lt.mif.vu;

import java.util.Collections;
import java.util.List;

public class PasswordChecker implements IPasswordChecker {
    private List<Character> specialCharacters = Collections.emptyList();

    public PasswordChecker() {

    }

    public PasswordChecker(List<Character> specialCharacters) {
        this.specialCharacters = specialCharacters;
    }

    @Override
    public void validate(String password) {
        validatePasswordLength(password);
        validatePasswordUppercase(password);
        validatePasswordSpecialCharacters(password);
    }

    private void validatePasswordSpecialCharacters(String password) {
    }

    private void validatePasswordLength(String password) {

    }

    private void validatePasswordUppercase(String password) {

    }
}
