package com.kdjd.test;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateTest2 {


    public static void main(String[] args) throws ParseException {
        // 2025-12-23 20:29:17
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2025);
        cal.set(Calendar.MONTH, 12);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 20);
        cal.set(Calendar.SECOND, 29);
        cal.set(Calendar.MILLISECOND, 17);



        System.out.println(timeout(new Date()));

        System.out.println(timeout(cal.getTime()));

    }

    private static boolean timeout(Date now ) {

        String startStr = "8";

        String endStr = "20";
        int startHour;
        int endHour;
        try {
            startHour = Integer.parseInt(startStr);
            endHour = Integer.parseInt(endStr);
            if (startHour > endHour) {
                startHour = 8;
                endHour = 20;
            }
        } catch (Exception e) {
            startHour = 8;
            endHour = 20;
        }


        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, startHour);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date start = cal.getTime();

        cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, endHour);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date end = cal.getTime();

        return now.before(start) || now.after(end);
    }

}
