package com.kdjd.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author HeHuan
 */
public class ThereTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int count = 12500000;
        System.out.println("start to add");
        for (int i = 0; i < count; i++) {
            list.add("idx:" + i);
        }

        System.out.println("get");
        long startAt = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i).toUpperCase();
        }
        System.out.println(System.currentTimeMillis() - startAt);

        System.out.println("forEach");
        startAt = System.currentTimeMillis();
        list.forEach(o -> {
            String str = o.toUpperCase();
            //System.out.println(str);
        });
        System.out.println(System.currentTimeMillis() - startAt);

        System.out.println("for item");
        startAt = System.currentTimeMillis();
        for (String s : list) {
            String str = s.toUpperCase();
        }
        System.out.println(System.currentTimeMillis() - startAt);

        System.out.println("iterator");
        startAt = System.currentTimeMillis();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next().toUpperCase();
        }
        System.out.println(System.currentTimeMillis() - startAt);

    }


}
