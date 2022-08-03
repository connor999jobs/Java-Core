package com.knubisoft.base.string;

import com.ctc.wstx.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
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
        StringBuilder builder = new StringBuilder(original);
        int index = (int) (builder.length() / 2);
        builder.insert(index, toInsert);
        return builder.toString();

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
//        StringBuilder sb = new StringBuilder(str);
//        sb.deleteCharAt(charToRemove);
        String s= StringUtils.remove(str,charToRemove);
        return s;


    }

    @Override
    public String toCamelCase(String str) {
//         String regex = "([^a-zA-Z']+)'*\\1*";
//         String[] split = str.split(regex);
//         StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < split.length; i++) {
//            if (i == 0) {
//                sb.append(split[i]);
//            } else if (split[i].length()>0){
//                sb.append(split[i].replaceFirst(split[i].substring(0, 1), split[i].substring(0, 1).toUpperCase()));
//            }
        // return new String(sb);
//        }
        StringBuilder sb = new StringBuilder();
        Boolean nextC = false;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))){
                char t = str.charAt(i);

                if (nextC) t = Character.toUpperCase(t);
                sb.append(t);
                nextC = false;
            }
            else {
                nextC =true;
            }

        }
        return sb.toString();
    }

    @Override
    public String getCountRepeatableString(String str) {
        return null;
    }

    @Override
    public String sortStringCharactersAsc(String str) {
        char [] arr= str.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
}
