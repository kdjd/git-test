package com.kdjd.test;

public class Test01 {

    public static void main(String[] args) {
        String str = "/uploadPath/upload/2021/09/29/0aacc5c05dc6519b0fc1b3e9f57645f6.apk";

        String prefix = str.substring(0, str.lastIndexOf("/"));
        prefix = str.substring(0, prefix.lastIndexOf("/"));
        prefix = str.substring(0, prefix.lastIndexOf("/"));
        prefix = str.substring(0, prefix.lastIndexOf("/") + 1);
        String suffix = str.substring(str.lastIndexOf("."));
        System.out.println(str);
        String stringBuffer = prefix + "app-name" + suffix;
        System.out.println(stringBuffer);
    }
}
