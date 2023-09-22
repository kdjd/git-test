package com.kdjd.test;

import java.util.ArrayList;
import java.util.List;

public class WmsTest {

    public static void main(String[] args) {
        for (int i = 1; i <= 10000; i++) {
            if (i % 10000 == 0) {
                System.out.println("当前进度：" + i);
            }
            List<Integer> ints = new ArrayList<>();
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    ints.add(j);
                }
            }
            long sum = ints.stream().reduce(Integer::sum).orElse(0);
            if (sum == i) {
                System.out.println("完美数：" + i);
            }
        }
    }
}
