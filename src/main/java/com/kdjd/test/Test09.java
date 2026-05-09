package com.kdjd.test;

import java.util.UUID;

public class Test09 {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        //for (int i = 0; i < 10; i++) {
        //    long idWithTime = getId(i, l);
        //    System.out.println(idWithTime);
        //    System.out.println("id:" + i + ",time:" + l);
        //    System.out.println(parse(idWithTime));
        //}
        int i = 10000;
        l = 32503651199000L;
        long idWithTime = getId(i, l);
        System.out.println(idWithTime);
        System.out.println("id:" + i + ",time:" + l);
        System.out.println(parse(idWithTime));

        String upperCase = UUID.randomUUID().toString().toUpperCase();
        System.out.println(upperCase);
    }

    private static long getId(Integer id, Long time) {
        long l = time << 16;
        return Long.parseLong(String.valueOf(l + id));
    }

    private static String parse(long l) {
        return "id:" + (l & 0xFF) + ",time:" + (l >> 16);
    }

}
