package com.kdjd.test;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Test10 {

    public static void main(String[] args) {
       /* String[] split = "1,3,5,7,8,9,10".split(",");
        Integer currentStep = 10;
        List<String> list = Arrays.asList(split);
        int idx = list.indexOf(String.valueOf(currentStep))+1;
        if (Objects.equals(idx, list.size())) {
            System.out.println("null");
        } else {
            String s = list.get(idx );
            System.out.println(s);
        }


        int pre = list.indexOf(String.valueOf(currentStep));
        System.out.println(list.get(pre-1));*/

        String[] a = "1,2,3,4,5,6".split(",");
        String[] b = "7,8,9,0".split(",");

        //List<String> names = new ArrayList<>( Arrays.asList(a));
        //names.addAll(Arrays.asList(b));
        //
        //System.out.println(JSONObject.toJSON(names));
        String ac = "1,2,3,10";
        List<String> strings = new ArrayList<>(Arrays.asList(ac.split(",")));
        System.out.println(strings.lastIndexOf("10"));

    }


}
