package com.my;

public class TestClass {
    public static String v = "Some val";

    {
        System.out.println("!!! Non");
    }

    static {
        System.out.println("!!! static");
    }

    public void a() {
        System.out.println("!!! a is called");
    }
}
