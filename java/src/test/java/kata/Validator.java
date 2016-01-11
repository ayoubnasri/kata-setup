package kata;

import java.util.List;

interface Validator {
    void validate(String password, List<String> errors);

    String validate(String password);

    public final class LetterValidator implements Validator {
        @Override
        public void validate(String password, List<String> errors) {
            if (!containsLetter(password))
                errors.add("Password must contain a letter");
        }

        @Override
        public String validate(String password) {
            return containsLetter(password) ? "" : "Password must contain a letter";
        }


        private boolean containsLetter(String password) {
            return password.matches(".*[a-zA-Z].*");
        }


    }

    public class DigitValidator implements Validator {

        @Override
        public void validate(String password, List<String> errors) {
            if (!password.matches(".*\\d.*"))
                errors.add("Password needs to contain atleast one digit");
        }

        @Override
        public String validate(String password) {
            return password.matches(".*\\d.*") ? "" : "Password needs to contain atleast one digit";
        }

    }

    public class SpecialCharValidator implements Validator {

        @Override
        public void validate(String password, List<String> errors) {
            if (!containsSpecialCharacter(password))
                errors.add("Password needs to contain atleast one special character");
        }

        @Override
        public String validate(String password) {
            return containsSpecialCharacter(password) ? "" : "Password needs to contain atleast one special character";
        }

        private boolean containsSpecialCharacter(String password) {
            return password.matches(".*[\\.!?].*");
        }


    }

    public final class LengthValidator implements Validator {
        private int length;

        public LengthValidator(int length) {
            this.length = length;
        }

        public void validate(String password, List<String> errors) {
            if (password.length() < length)
                errors.add("Password needs to be " + length + " chars long");

        }

        @Override
        public String validate(String password) {
            return password.length() < length ? "Password needs to be " + length + " chars long" : "";
        }
    }
}