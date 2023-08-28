package com.kdjd.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HeHuan
 */
public class ZyfjTest {

    public static void main(String[] args) {
        List<Long> res = new ArrayList<>();
        //Random random = new Random();
        long l = 2424908;
        zyfj(l, res, new ArrayList<>());
        res.remove(l);
        res.forEach(System.out::println);

        //long n = 100000000L;
        //for (long i = 1; i < n + 1; i++) {
        //    res = new ArrayList<>();
        //    zyfj(i, res);
        //    if (res.size() == 0) {
        //        System.out.println(i);
        //    }
        //}

    }

    private static void zyfj(long l, List<Long> res, List<Long> temp) {
        boolean flag = false;
        for (long i = 2; i < l; i++) {
            if (l % i == 0) {
                res.add(i);
                zyfj(l / i, res, temp);
                flag = true;
                break;
            }
        }
        if (!flag) {
            res.add(l);
        }

    }
}
