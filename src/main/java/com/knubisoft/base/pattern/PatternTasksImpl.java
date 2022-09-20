package com.knubisoft.base.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTasksImpl implements PatternTasks {

    @Override
    public boolean haveSetOfCharacters(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException();
        }
        return text.matches("^[\\w]+$");
    }

    @Override
    public String matchByCharacters(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }
        if (text.matches("pq*?"))
            return "Found a match!";
        else
            return "Not matched!";
    }

    @Override
    public String matchStartAndEnd(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }
        Pattern pattern = Pattern.compile("\\Bg\\B");
        Matcher m = pattern.matcher(text);

        if (m.find())
            return "Found a match!";
        else
            return "Not matched!";
    }

    @Override
    public String matchIpAddress(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException();
        }
        return text.replaceAll("(?<=^|\\.)0+(?!\\.|$)","");
    }

    @Override
    public String matchVowels(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException();
        }
        String result = text.replaceAll("(?i)[aeiou]", "");
        return result;
    }

    @Override
    public boolean validatePIN(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException();
        }
        return text.matches("\\d{4}|\\d{6}|\\d{8}");
    }

    @Override
    public String divideDigit(int digit) {
        String num = Integer.toString(digit);
        int len = num.length();
        if(len < 4) {
            return num;
        }

        return divideDigit(Integer.parseInt(num.substring(0, len-3))) + '#' + num.substring(len-3);
    }

    @Override
    public String removeAllNonAlphanumericCharacters(String text) {
        return text.replaceAll("(?i)[^A-Z]", "");

    }

    @Override
    public boolean validatePhoneNumber(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException();
        }

        return text.matches("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}");
    }

    @Override
    public String getLastVowelsByConstraint(String text, int n) {
        if (text == null || text.isBlank() || n < 1 || text.length() < n) {
            throw new RuntimeException();
        }
        String s = text.replaceAll("(?i)[^aeiou]", "");
        int l = s.length();
        return (n > s.length()) ? "Number of vowels mismatch!!!" : s.substring(s.length() - n);
    }

    @Override
    public boolean isMathematicalExpression(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException();
        }
        return text.matches("((?:(?:^|[-+_*/])(?:\\s*-?\\d+(\\.\\d+)?(?:[eE][+-]?\\d+)?\\s*))+$)");

    }

    @Override
    public String insertDash(String text) {
        return text.replaceAll("(?<=[A-Z])(?=[a-z])", "-");
    }
}
