package com.knubisoft.base.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class DateTasksImpl implements DateTasks {

    @Override
    public String add1Day(String date) {
        return LocalDate.parse(date).plusDays(1).toString();

    }

    @Override
    public int getMonthFromDate(String date) throws ParseException {
        Date formatter = new SimpleDateFormat("EEE, dd MMM yyyy", Locale.ENGLISH).parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(formatter);
        return cal.get(Calendar.MONTH) + 1;
    }

    @Override
    public String findBiggestDate(String date1, String date2, String date3)   {
        LocalDateTime first = LocalDateTime.parse(date1.replace(" ", "T"));
        LocalDateTime second = LocalDateTime.parse(date2.replace(" ", "T"));
        LocalDateTime third = LocalDateTime.parse(date3.replace(" ", "T"));
        List<LocalDateTime> res = new ArrayList<>();
        res.add(first);
        res.add(second);
        res.add(third);
        Collections.sort(res);
        LocalDateTime date = res.get(res.size() - 1);
        String s = String.valueOf(date);
        s = s.replace("T", " ");
        return s;
    }

    @Override
    public String getLastDayOfTheMonth(String date) {
        LocalDate lastDayOfMonth = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                .with(TemporalAdjusters.lastDayOfMonth());
        return String.valueOf(lastDayOfMonth);

    }

    @Override
    public String sumTimes(String time1, String time2)  {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = dateFormat.parse(time1);
            d2 = dateFormat.parse(time2);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
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
