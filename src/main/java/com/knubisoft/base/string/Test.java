package com.knubisoft.base.string;

public class Test {
    public static void main(String[] args) {

        String str = "My name is Gustavo";
        System.out.println(str);
        char charToRemove = 'a';

        System.out.println();

        StringBuilder sb = new StringBuilder(str);
        sb.deleteCharAt(charToRemove);
        System.out.println(sb);


    }
}
