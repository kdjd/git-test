package com.kdjd.test;

import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class A0030127 {

    public static void main(String[] args) {

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR,2023);
        cal.set(Calendar.MONTH,1);
        cal.set(Calendar.DATE,29);

        System.out.println(format.format(cal.getTime()));

        cal.add(Calendar.YEAR,1);
        System.out.println(format.format(cal.getTime()));




    }
}
