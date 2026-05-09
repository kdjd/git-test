package com.kdjd.test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateTest {


    public static void main(String[] args) {
        String d = "2017-06-15T00:00:00.000+08:00";


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String s = ZonedDateTime.parse(d).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        System.out.println(s);

        Date dateA = new Date();
        Date dateC = new Date();

        Date dateB = dateA;

        System.out.println(dateA.after(dateB));
        System.out.println(dateA.after(dateC));
        System.out.println(dateA.getTime());
        System.out.println(dateB.getTime());
        System.out.println(dateC.getTime());


        LocalDate start = LocalDate.of(2025,12,7);
        LocalDate end = LocalDate.of(2025,12,27);
        Period between = Period.between(start, end);
        System.out.println("中国"+between);

        start = LocalDate.of(2025,12,12);
        end = LocalDate.of(2026,1,5);
        between = Period.between(start, end);
        System.out.println("工商"+between);

        start = LocalDate.of(2025,12,17);
        end = LocalDate.of(2026,1,4);
        between = Period.between(start, end);
        System.out.println("招商"+between);

        start = LocalDate.of(2025,12,18);
        end = LocalDate.of(2026,1,12);
        between = Period.between(start, end);
        System.out.println("农业"+between);

        start = LocalDate.of(2025,12,19);
        end = LocalDate.of(2026,1,7);
        between = Period.between(start, end);
        System.out.println("中信"+ between);

    }
}
