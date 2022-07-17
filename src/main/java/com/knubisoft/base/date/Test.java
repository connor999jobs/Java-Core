package com.knubisoft.base.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Test extends DateTasksImpl{
    public static void main(String[] args) throws ParseException {
        Test test = new Test();
        String date = "2022-07-12";
//        String date1 = "2022-07-12 10-30-30";
//        String date2 = "2022-07-12 16-38-35";
////        System.out.println("New date: " + test.add1Day(date));
        System.out.println("Month : " + test.getMonthFromDate(date));
//
//        System.out.println("The biggest data is: " + test.findBiggestDate(date,date1,date2));

//        String date = "2022-07-12";
//        System.out.println("End " + test.getLastDayOfTheMonth(date));

//        String date1 = " 03:30:00 ";
//        String date = "04:00:00";
//
//
//        System.out.println("Summ " + test.sumTimes(date1,date) );

//        String date = "2022-07-12";
//        System.out.println("Old Date: " + date + "\nNew Date: " + test.getDateAfter2Weeks(date));

//        String date1 = "2022-07-12";
//        String date2 = "2022-07-11";
//        System.out.println("Diff: " + test.getNumberOfDaysBetweenTwoDates(date2,date1));

//        String date1 = "2022-07-12";
//        System.out.println(Arrays.toString(test.getTheNextAndPreviousFriday(date1)));

//        String date1 = "2022-07-12";
//        System.out.println("Days left: " + test.getNumberOfMonthsRemainingInTheYear(date1));
    }
}
