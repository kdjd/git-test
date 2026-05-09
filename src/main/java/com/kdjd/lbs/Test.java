package com.kdjd.lbs;

import java.io.*;
import java.util.*;

/**
 * @author zhanglei
 * @version v1.0
 * @Description: TODO
 * @date 20242024/5/2713:34
 */
public class Test {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\Document\\cdkj\\2026021001.txt");

        Reader reader = new FileReader(file);

        BufferedReader br = new BufferedReader(reader);

        String date = "";

        List<String> phones = new ArrayList<String>();
        List<String> sqls = new ArrayList<String>();
        String line = null;

        int i = 0;
        while((line = br.readLine()) != null){
            line = line.trim();
            StringBuilder sb = new StringBuilder();
            if(line.startsWith("--")){
                date = line.substring(2,line.length());
                System.out.println("--------------------------:" + date);
            }else{
//                if(!phones.contains(line)) {
//                    System.out.println(++i);
                    phones.add(line);
                    sb.append(date).append("@@INSERT INTO t_lbs_reverse_order(MOBILE_PHONE, ORDER_START_TIME, ORDER_TYPE, LBS_TYPE, DEL_FLAG, vstatus, source_data,ACCEPT_TIME) values ('")
                            .append(line).append("', '").append(date).append("',1,2,0,0,'手动导入','").append(date).append("');");
                    sqls.add(sb.toString());
//                    System.out.println(sb.toString());
                    System.out.println(sb.toString().substring(12, sb.toString().length()));
//                }else{
//                    System.out.println(line);
//                }
            }

        }

//        Collections.sort(sqls, (s1, s2) -> s2.compareTo(s1));
//
////        sqls.forEach(System.out::println);
//
//        for(String str:sqls){
//            System.out.println(str.substring(12, str.length()));
//        }
    }
}
