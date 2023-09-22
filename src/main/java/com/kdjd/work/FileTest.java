package com.kdjd.work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author HeHuan
 */
public class FileTest {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\kdjdl\\Desktop\\true.txt");
        Set<String> set = new HashSet<>();

        InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        line = br.readLine();
        while (line != null) {
            line = br.readLine();
            if (line == null || line.length() == 0) {
                continue;
            }
            int start = line.lastIndexOf("-") + 1;
            int end = line.length() - 1;
            set.add(line.substring(start, end));
        }

        StringBuffer sb = new StringBuffer();
        sb.append("(");
        set.forEach(o -> {
            sb.append("'").append(o).append("',");
        });
        sb.append(")");
        System.out.println(sb);
    }
}
