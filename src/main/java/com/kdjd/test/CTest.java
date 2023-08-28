package com.kdjd.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CTest {

    public static void main(String[] args) {

        for (int i = 1; i <= 12; i++) {
            test(2023, i);
        }

    }

    public static String test(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        // 设置月份
        cal.set(Calendar.MONTH, month);
        // 获取某月最小天数
        int firstDay = cal.getMinimum(Calendar.DATE);
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
        return null;
    }

    public static String getLastDayOfMonth(int month) {
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR, 2000);
        // 设置月份
        cal.set(Calendar.MONTH, month - 1);
        // 获取某月最大天数
        int lastDay = 0;
        //2月的平年瑞年天数
        if (month == 2) {
            lastDay = cal.getLeastMaximum(Calendar.DAY_OF_MONTH);
        } else {
            lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        }
        // 设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime()) + " 23:59:59";
        System.out.println(lastDayOfMonth);
        return lastDayOfMonth;
    }

}
