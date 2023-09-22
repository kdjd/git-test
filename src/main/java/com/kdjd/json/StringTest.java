package com.kdjd.json;

import java.util.ArrayList;
import java.util.List;

public class StringTest {

    public static void main(String[] args) {
        String test = "{" +
                //"    \"pageNo\": 1," +
                //"    \"pageSize\": 20," +
                //"    \"taskId\": \"temp_301230caa5534d0d9de6f9c020936019\"," +
                //"    \"name\": \"黑名单布控\"," +
                //"    \"beginTime\": \"2017-06-15T01:00:00.000+08:00\"," +
                //"    \"endTime\": \"2017-06-15T01:00:00.000+08:00\"" +
                "}";

        System.out.println(test);
        System.out.println(test.trim());

        test = " 1 2l 3  4 5   ";

        System.out.println(test + "|");
        System.out.println(test.trim() + "|");

        String reverse = new StringBuilder(test).reverse().toString();
        System.out.println(reverse);
        reverse = new StringBuilder(reverse).reverse().toString();
        System.out.println(reverse);

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        String join = String.join("-", list);
        System.out.println(join);
    }
}
