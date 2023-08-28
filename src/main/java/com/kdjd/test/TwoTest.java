package com.kdjd.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TwoTest {

    public static void main(String[] args) {
        long currentTime = System.currentTimeMillis();
        Map<Integer, Integer> map = new HashMap<>(20000000);
        Random random = new Random();
        do {
            int i = random.nextInt();

            map.put(i < 0 ? -i : i, i);
        } while (map.size() <= 20000000);
        System.out.println("花费时间:" + (System.currentTimeMillis() - currentTime) / 1000);
    }
}
