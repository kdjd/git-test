package com.kdjd.test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTest {


    public static void main(String[] args) {
        String d = "2017-06-15T00:00:00.000+08:00";


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String s = ZonedDateTime.parse(d).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));


        System.out.println(s);

    }
}
