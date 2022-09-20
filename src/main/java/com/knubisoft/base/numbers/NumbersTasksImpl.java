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
        if (number == 0) {
            return false;
        }
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

        else if (number == 2)
            return true;

        else if (number % 2 == 0)
            return false;

        for (int i = 3; i <= Math.sqrt(number); i += 2)
        {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    @Override
    public boolean isArmstrongNumber(int number) {
        String[] strArray = Integer.toString(number).split("");
        int pow = strArray.length;

        int result = 0;

        for (String s : strArray) {
            result += Math.pow(Integer.parseInt(s), pow);
        }
        return number == result;
    }


    @Override
    public BigInteger factorial(int number) {
//        int res = 1, i;
//        for (i=2; i<=number; i++)
//            res *= i;

//        return BigInteger.valueOf(res);
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= number; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

    @Override
    public boolean palindrome(int number) {
        int reverseNum = 0;
        int tempOriginal = number;

        while (tempOriginal > 0) {

            int lastDigit = tempOriginal % 10;
            reverseNum = reverseNum * 10 + lastDigit;
            tempOriginal = tempOriginal / 10;
        }

        if (number == reverseNum) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isAutomorphic(int number) {
        int c=0, sqr = number*number;
        int temp =number;  //copying num

        //countint digits of num
        while(temp>0){
            c++;
            temp=temp/10;
        }

        int lastSquareDigits = (int) (sqr%(Math.pow(10,c)));

        if(number == lastSquareDigits)
            return true;
        else
            return false;

    }
}
