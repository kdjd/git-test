package com.kdjd.test;

import com.kdjd.json.User;

import java.util.Objects;

public class ObjectTest {
    public static void main(String[] args) {
        System.out.println(Objects.deepEquals("b", "b"));

        System.out.println(Objects.deepEquals(
                new User("xm", 18, 1L), new User("xm", 18, 1L)));
        System.out.println(Objects.equals(
                new User("xm", 18, 1L), new User("xm", 18, 1L)));


    }
}
