package com.knubisoft.base.string;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTasksImpl implements StringTasks {

    @Override
    public String reverseString(String original) {
        if (original == null) {
            throw new IllegalArgumentException();
        }
        StringBuffer stringBuffer = new StringBuffer(original);
        stringBuffer.reverse();
        return String.valueOf(stringBuffer);
    }

    @Override
    public String insertStringInMiddle(String original, String toInsert) {
        if (original == null || toInsert == null || original.length() == 0 || toInsert.length() == 0) {
            throw new IllegalArgumentException();
        }
//        char chars[] = new char[original.length() + toInsert.length()];
//        for (int i = 0; i < toInsert.length(); i++) {
//            chars[i] = original.charAt(i - toInsert.length());
//        }
//        String newString = new String(chars);
        StringBuilder builder = new StringBuilder(original);
        int index = (int) (builder.length() / 2);
        builder.insert(index, toInsert);
        return builder.toString();

    }

    @Override
    public String insertSymbolInString(String original, char toInsert, int position) {
        if (original == null || position > original.length() || original.length() == 0 || position < 0) {
            throw new IllegalArgumentException();
        }
//        String newString = new String();
//        for (int i = 0; i < original.length(); i++) {
//            newString += original.charAt(position);
//
//            if (i == position){
//                newString += toInsert;
//            }
//        }

        //second method
//        String newString = original.substring(0, position)
//                + toInsert
//                + original.substring(position );
//        return newString;

        // third method
        StringBuffer newString = new StringBuffer(original);
        newString.insert(position, toInsert);
        return newString.toString();
    }

    @Override
    public String appendToString(StringBuilder original, String toAppend) {
        if (original == null || toAppend == null || original.length() == 0) {
            throw new NoSuchElementException();
        }
        StringBuffer sb = new StringBuffer();
        sb.append(original);
        sb.append(toAppend);
        String result = sb.toString();
        return result;
    }

    @Override
    public boolean isPalindrome(String palindrome) {
        if (palindrome == null) {
            throw new RuntimeException();
        }
        String clean = palindrome.replaceAll("\\s+", "").toLowerCase();
        int length = clean.length();
        int forward = 0;
        int backward = length - 1;
        while (backward > forward) {
            char forwardChar = clean.charAt(forward++);
            char backwardChar = clean.charAt(backward--);
            if (forwardChar != backwardChar)
                return false;
        }
        return true;
    }

    @Override
    public boolean hasLowerCase(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (str.equals(str.toLowerCase())){
            return true;
        }
        return false;
    }

    @Override
    public String uniqueCharacters(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        String temp = "";
        for (int i = 0; i < str.length(); i++){
            char current = str.charAt(i);
            if (temp.indexOf(current) < 0){
                temp = temp + current;
            } else {
                temp = temp.replace(String.valueOf(current), "");
            }
        }

        return temp ;

    }

    @Override
    public String removeAllCharacters(String str, char charToRemove) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        String s= StringUtils.remove(str,charToRemove);
        return s;


    }

    @Override
    public String toCamelCase(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException();
        }
        boolean flag = false;
        StringBuilder builder = new StringBuilder();
        for (String value: str.split("")) {
            if (builder.length() == 0) {
                builder.append(value.toLowerCase());
                continue;
            }
            if (value.matches("[-_\\s]")) {
                flag = true;
                continue;
            }
            if (flag ) {
                builder.append(value.toUpperCase());
                flag = false;
            }
            else {
                builder.append(value);
            }
        }
        return builder.toString();
    }

    @Override
    public String getCountRepeatableString(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if(str.isEmpty()) return "";
        String[] split = str.split("");
        StringBuilder builder = new StringBuilder();
        int count;
        for (int i = 0; i < split.length; i++) {
            count = 1;
            for (int j = i; j < split.length; j++) {
                if (split[i].equals(split[j])) {
                    if (count > 9) {
                        count = 1;
                    }
                    builder.append(count);
                    count++;
                }
            }
        }
        return builder.toString();
    }

    @Override
    public String sortStringCharactersAsc(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        char [] arr= str.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
}
