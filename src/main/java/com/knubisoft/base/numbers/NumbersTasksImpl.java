package com.knubisoft.base.numbers;

import java.math.BigInteger;

public class NumbersTasksImpl implements NumbersTasks {

    @Override
    public void swapTwoNumbersWithoutUsingTemporaryVariable(int firstNumber, int secondNumber) {
        firstNumber  = firstNumber + secondNumber;
        secondNumber = firstNumber - secondNumber;
        firstNumber = firstNumber - secondNumber;


    }

    @Override
    public boolean isUglyInt(int number) {

        if (number < 1) return false;

        int temp;
        do {
            temp = number;
            if (number % 2 == 0) number /= 2;
            if (number % 3 == 0) number /= 3;
            if (number % 5 == 0) number /= 5;
        } while (temp != number);

        return number == 1;
    }

    @Override
    public int addDigits(int number) {

        while(number > 9){
            int res =0;
            while(number > 0){
                res += number%10;
                number /= 10;
            }
            number = res;
        }

        return number;

//        return number - 9 * ((number - 1) /9);
    }

    @Override
    public boolean isHarshadNumber(int number) throws ArithmeticException {
        int sum =0;
        for (int i = number; i >0 ; i/=10) {


            sum += i % 10;
        }
        return (number % sum ==0);
    }

    @Override
    public boolean isPrime(int number) {
//        boolean primeOrNot = false;
//        for (int i = 2; i <= number ; ++i) {
//            if (number %i ==0)
//                primeOrNot =true;
//            break;
//        }
////        if (!primeOrNot)
////            System.out.println(number + " is a prime");
////        else
////            System.out.println(number + " is not prime");
//        return !primeOrNot;
        if (number <= 1)
            return false;

            // Check if number is 2
        else if (number == 2)
            return true;

            // Check if n is a multiple of 2
        else if (number % 2 == 0)
            return false;

        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(number); i += 2)
        {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    @Override
    public boolean isArmstrongNumber(int number) {
        return false;
    }

    @Override
    public BigInteger factorial(int number) {
        return BigInteger.ZERO;
    }

    @Override
    public boolean palindrome(int number) {
        return false;
    }

    @Override
    public boolean isAutomorphic(int number) {
        return false;
    }
}
