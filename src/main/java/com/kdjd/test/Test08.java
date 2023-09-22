package com.kdjd.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test08 {

    public static void main(String[] args) {
        Tea a = new Tea("01","green");
        Tea b = new Tea("02","red");
        Tea c = new Tea("03","red");

        List<Tea> list = new ArrayList<Tea>(){{add(a);add(b);add(c);}};

        Map<String, Tea> collect = list.stream().collect(Collectors.toMap(Tea::getType, Function.identity()));


    }

    static class Tea {
        private String id;
        private String type;

        public Tea() {
        }

        public Tea(String id, String type) {
            this.id = id;
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
