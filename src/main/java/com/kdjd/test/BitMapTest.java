package com.kdjd.test;

public class BitMapTest {

    public static void main(String[] args) {
        int size = 20000000;
        byte[] bits = new byte[getIndex(size) + 1];

    }

    private static int getIndex(int size) {
        return size >> 3;
    }
}
