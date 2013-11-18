package com.dani.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {

    public Validador() {
    }

    public Boolean validarNIF(String input) {
        if (input.length() == 8) {
            try {
                Integer.parseInt(input);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        } else if (input.length() == 9) {
            try {
                Integer.parseInt(input.substring(0, 8));
                if (input.substring(8, 9).matches("\\p{L}") || input.substring(8, 9).matches("\\p{Lu}"))
                    return true;
                else
                    return false;
            } catch (NumberFormatException e) {
                return false;
            }

        }
        return false;

    }

    public Boolean validarCIF(String input) {
        if (input.length() == 9) {
            if (input.substring(0, 1).matches("\\p{L}") || input.substring(0, 1).matches("\\p{Lu}")) {
                try {
                    Integer.parseInt(input.substring(1, 8));
                } catch (NumberFormatException e) {
                    return false;
                }
                if (input.substring(8, 9).matches("\\p{L}") || input.substring(8, 9).matches("\\p{Lu}") || input.matches(".*\\d.*")) {
                    return true;
                }
            }
        }
        return false;
    }

    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * Validate given email with regular expression.
     *
     * @param email email for validation
     * @return true valid email, otherwise false
     */
    public boolean validateEmail(String email) {

        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);

        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }

}

