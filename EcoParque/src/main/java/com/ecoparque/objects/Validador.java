package com.ecoparque.objects;

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
                return input.substring(8, 9).matches("\\p{L}") || input.substring(8, 9).matches("\\p{Lu}");
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


    public boolean validateEmail(String email) {

        Pattern pattern = Pattern.compile(PATTERN_EMAIL);

        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }

}

