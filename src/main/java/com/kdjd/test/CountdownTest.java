package com.kdjd.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CountdownTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountdownTest.class);

    public static void main(String[] args) {
        boolean flag = true;

        long start = System.currentTimeMillis();

        Calendar fp = Calendar.getInstance();
        fp.set(Calendar.HOUR_OF_DAY, 18);
        fp.set(Calendar.MINUTE, 0);
        fp.set(Calendar.SECOND, 0);
        fp.set(Calendar.MILLISECOND, 0);
        LOGGER.info("{}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS").format(fp.getTime()));
        long finishLine = fp.getTime().getTime();

        while (flag) {
            long now = new Date().getTime();
            long diff = finishLine - now;

            if (diff < 0) {
                flag = false;
            } else {
                long hour = diff / (1000 * 60 * 60);
                if (hour > 0) {
                    LOGGER.info("{} hours", hour);
                } else {
                    long min = diff / (1000 * 60);
                    if (min > 0) {
                        LOGGER.info("{} mins", hour);
                    } else {
                        long second = diff / 1000;
                        LOGGER.info("{} seconds", second);
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception ignored) {
                }
            }
        }
    }

}
