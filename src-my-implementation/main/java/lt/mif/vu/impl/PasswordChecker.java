package lt.mif.vu.impl;

import java.util.List;

import static lt.mif.vu.impl.constants.Constants.DEFAULT_SPECIAL_CHARACTERS;

public class PasswordChecker {

    private List<Character> specialCharacters;

    public PasswordChecker() {
        this.specialCharacters = DEFAULT_SPECIAL_CHARACTERS;
    }

    public PasswordChecker(List<Character> specialCharacters) {
        this.specialCharacters = specialCharacters;
    }

    public void setSpecialCharacters(List<Character> specialCharacters) {
        this.specialCharacters = specialCharacters;
    }

    public boolean isPasswordValid(String password, int length) {
        if (password == null) {
            return false;
        }
        return isPasswordLengthValid(password, length)
                && passwordContainsUppercaseCharacter(password)
                && passwordContainsSpecialCharacters(password);
    }

    private boolean isPasswordLengthValid(String password, int length) {
        return password.length() >= length;
    }

    private boolean passwordContainsUppercaseCharacter(String password) {
        return password.chars().anyMatch(Character::isUpperCase);
    }

    private boolean passwordContainsSpecialCharacters(String password) {
        return specialCharacters.stream().anyMatch(character -> password.contains(character.toString()));
    }
}
