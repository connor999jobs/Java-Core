package com.knubisoft.base.numbers;

public class NumbersTest extends NumbersTasksImpl{

    public static int isUgly(int n ){
        if (n==1)
            return 1;
        if (n<=0)
            return 0;
        if (n % 2 == 0) {
            return (isUgly(n / 2));
        }
        if (n % 3 == 0) {
            return (isUgly(n / 3));
        }
        if (n % 5 == 0) {
            return (isUgly(n / 5));
        }
        return 0;
    }



    public static void main(String[] args) {
        NumbersTest numbersTest = new NumbersTest();
        System.out.println(numbersTest.isPrime(11));

//
//        int fff = isUgly(17);
//        if (fff==1)
//            System.out.println("+");
//        else
//            System.out.println("-");
//        int a = 5;
//        int b = 7;
//        System.out.println(a);
//        System.out.println(b);
//
//        a = a +b;
//        b = a - b;
//        a = a -b;
//
//        System.out.println("E");
//        System.out.println(a);
//        System.out.println(b);



    }
}
