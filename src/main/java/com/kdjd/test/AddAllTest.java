package com.kdjd.test;

import javax.activation.MimetypesFileTypeMap;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AddAllTest {

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<String>(){{
            add("a");
            add("b");
            add("c");
        }};

        List<String> list2 = new ArrayList<String>(){{
            add("1");
            add("2");
            add("3");
        }};

        List<String> collect = list2.stream().filter(o -> Objects.equals(o, "0")).collect(Collectors.toList());

        System.out.println(new Date());


    }
}
