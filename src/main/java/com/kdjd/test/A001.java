package com.kdjd.test;

public class A001 {

    public static void main(String[] args) {

        String s = "hello";

        int i = s.hashCode() << 2;

        int j = s.hashCode() >> 2;

        System.out.println(i);

        System.out.println(j);

    }
}
