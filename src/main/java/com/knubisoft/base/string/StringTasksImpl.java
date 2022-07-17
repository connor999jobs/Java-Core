package com.knubisoft.base.string;

import com.ctc.wstx.util.StringUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTasksImpl implements StringTasks {

    @Override
    public String reverseString(String original) {
        StringBuffer stringBuffer = new StringBuffer(original);
        stringBuffer.reverse();
        return String.valueOf(stringBuffer);
    }

    @Override
    public String insertStringInMiddle(String original, String toInsert) {
//        char chars[] = new char[original.length() + toInsert.length()];
//        for (int i = 0; i < toInsert.length(); i++) {
//            chars[i] = original.charAt(i - toInsert.length());
//        }
//        String newString = new String(chars);
//        return newString;

        return null;
    }

    @Override
    public String insertSymbolInString(String original, char toInsert, int position) {
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
        StringBuffer sb = new StringBuffer();
        sb.append(original);
        sb.append(toAppend);
        String result = sb.toString();
        return result;
    }

    @Override
    public boolean isPalindrome(String palindrome) {
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
        if (str.equals(str.toLowerCase())){
            return true;
        }
        return false;
    }

    @Override
    public String uniqueCharacters(String str) {

        String uniq = new String(str);
        for (int i = 0; i < uniq.length(); i++) {
            for (int j = i +1; j < uniq.length() ; j++) {
                if (uniq.charAt(i) == uniq.charAt(j))
                    return uniq;
            }
            
        }
        return str;
    }

    @Override
    public String removeAllCharacters(String str, char charToRemove) {
//        StringBuilder sb = new StringBuilder(str);
//        sb.deleteCharAt(charToRemove);
        String s= StringUtils.remove(str,charToRemove);
        return s;


    }

    @Override
    public String toCamelCase(String str) {
        return null;
    }

    @Override
    public String getCountRepeatableString(String str) {
        return null;
    }

    @Override
    public String sortStringCharactersAsc(String str) {
        return null;
    }
}
