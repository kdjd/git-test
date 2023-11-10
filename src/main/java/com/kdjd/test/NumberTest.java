package com.kdjd.test;

public class NumberTest {

    public static void main(String[] args) {
        String a = "123";
        String b = "123.123";


        try {
            System.out.println(Integer.parseInt(a));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        try {
            System.out.println(Long.parseLong(a));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        try {
            System.out.println(Float.parseFloat(a));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        try {
            System.out.println(Double.parseDouble(a));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        try {
            System.out.println(Integer.parseInt(b));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        try {
            System.out.println(Long.parseLong(b));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        try {
            System.out.println(Float.parseFloat(b));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        try {
            System.out.println(Double.parseDouble(b));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
