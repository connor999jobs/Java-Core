package com.knubisoft.base.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateTasksImpl implements DateTasks {

    @Override
    public String add1Day(String date) {
        return LocalDate.parse(date).plusDays(1).toString();

    }

    @Override
    public int getMonthFromDate(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("EEE, dd MMM yyyy"));
        int month = localDate.getMonthValue();

        return month;
    }

    @Override
    public String findBiggestDate(String date1, String date2, String date3)   {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String result = null;
        try {
            Date newDate = format.parse(date1);
            Date newDate2 = format.parse(date2);
            Date newDate3 = format.parse(date3);


            if (newDate.before(newDate2) && newDate.before(newDate3)){
                result = String.valueOf(newDate);
            } else if (newDate2.before(newDate) && newDate2.before(newDate3)){
                result = String.valueOf(newDate2);
            } else if (newDate3.before(newDate) && newDate3.before(newDate2)){
                result = String.valueOf(newDate3);
            }
        } catch (ParseException e){
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public String getLastDayOfTheMonth(String date) {
        LocalDate lastDayOfMonth = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                .with(TemporalAdjusters.lastDayOfMonth());
           return String.valueOf(lastDayOfMonth);

    }

    @Override
    public String sumTimes(String time1, String time2) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date d1 = dateFormat.parse(time1);
        Date d2 = dateFormat.parse(time2);
        long sum = d1.getTime() + d2.getTime();
        String d3 = dateFormat.format(new Date(sum));


        return d3;
    }

    @Override
    public String getDateAfter2Weeks(String date) {
        LocalDate localDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate twoWeeks =  localDate.plus(2, ChronoUnit.WEEKS);
        return String.valueOf(twoWeeks);
    }

    @Override
    public long getNumberOfDaysBetweenTwoDates(String date1, String date2) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate firstDate = LocalDate.parse(date1,formatter);
        LocalDate secondDate = LocalDate.parse(date2,formatter);
        long days = ChronoUnit.DAYS.between(firstDate,secondDate);
            return days;

        }


    @Override
    public String[] getTheNextAndPreviousFriday(String date) {
        LocalDate localDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        ArrayList<String> arrayList = new ArrayList<String>();
        String nextFriday = String.valueOf(localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
        String previousFriday = String.valueOf(localDate.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY)));
        arrayList.add(nextFriday);
        arrayList.add(previousFriday);
        return arrayList.toArray(new String[0]);
    }

    @Override
    public int getNumberOfMonthsRemainingInTheYear(String date) {
        LocalDate localDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate lastDayInYear = localDate.with(TemporalAdjusters.lastDayOfYear());
        Period period = localDate.until(lastDayInYear);
        return period.getMonths();
    }
}
