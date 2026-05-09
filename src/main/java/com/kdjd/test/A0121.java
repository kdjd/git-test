package com.kdjd.test;

import org.apache.commons.lang3.StringUtils;

import javax.activation.MimetypesFileTypeMap;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class A0121 {

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 80; i++) {
            String key = i+1+"";

            System.out.println( (i +1) + "===" +EnumArchiveCoverPageKey.getPageKey(key));
        }

    }
}


