package com.kdjd.test;

import ch.qos.logback.core.testUtil.RandomUtil;
import org.apache.commons.lang3.RandomUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ForTest {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        list.forEach(o -> {
            try {
                int i1 = RandomUtils.nextInt(10, 20);
                Thread.sleep(i1);
                System.out.println(o);
            } catch (Exception ignored) {
            }
        });

    }
}
