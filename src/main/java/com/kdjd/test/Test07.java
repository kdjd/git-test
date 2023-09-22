package com.kdjd.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class Test07 {

    public static void main(String[] args) {
        /*
        String str = "/uploadPath/upload/2021/09/29/0aacc5c05dc6519b0fc1b3e9f57645f6.apk";

        String prefix = str.substring(0, str.lastIndexOf("/"));
        prefix = str.substring(0, prefix.lastIndexOf("/"));
        prefix = str.substring(0, prefix.lastIndexOf("/"));
        prefix = str.substring(0, prefix.lastIndexOf("/") + 1);
        String suffix = str.substring(str.lastIndexOf("."));
        System.out.println(str);
        String stringBuffer = prefix + "app-name" + suffix;
        System.out.println(stringBuffer);
        */

        int ixx = 22;
        //System.out.println(ixx%16);
        //System.out.println(ixx/16);

        List<String> numberList = new ArrayList<>();

        for (int i1 = 0; i1 < ixx; i1++) {
            numberList.add(i1 + "");
        }

        int cycle = numberList.size() / 16;

        for (int i = 0; i <= cycle; i++) {
            List<String> numbers;
            if ((i + 1) * 16 > numberList.size()) {
                numbers = numberList.subList(i * 16, numberList.size());
            } else {
                numbers = numberList.subList(i * 16, (i + 1) * 16);
            }

            System.out.println(JSON.toJSONString(numbers));
        }


    }
}
