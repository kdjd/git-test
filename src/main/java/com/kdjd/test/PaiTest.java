package com.kdjd.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PaiTest {

    public static void main(String[] args) {
        BigDecimal p = new BigDecimal(3);
        for (int i = 1; i < 10000000; i++) {
            double a = i * 2;
            double b = a + 1;
            double c = b + 1;
            BigDecimal d = new BigDecimal(4).divide(new BigDecimal(a * b * c), 100, RoundingMode.HALF_UP);
            if (i % 2 != 0) {
                p = p.add(d);
            } else {
                p = p.subtract(d);
            }
        }

        System.out.println(p);
    }
}
