package com.kdjd.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BTest {

    public static void main(String[] args) {
        LocalDate d = LocalDate.now(); // 当前日期
        LocalTime t = LocalTime.now(); // 当前时间
        LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间
        System.out.println(d); // 严格按照ISO 8601格式打印
        System.out.println(t); // 严格按照ISO 8601格式打印
        System.out.println(dt); // 严格按照ISO 8601格式打印

        dt = LocalDateTime.now(); // 当前日期和时间
        d = dt.toLocalDate(); // 转换到当前日期
        t = dt.toLocalTime(); // 转换到当前时间

        System.out.println(d); // 严格按照ISO 8601格式打印
        System.out.println(t); // 严格按照ISO 8601格式打印
        System.out.println(dt); // 严格按照ISO 8601格式打印

        // 自定义格式化:
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));

        // 用自定义格式解析:
        LocalDateTime dt2 = LocalDateTime.parse("2019/11/30 15:16:17", dtf);
        System.out.println(dt2);
    }

    public List<TPdfFile> handleBL(List<TPdfFile> list) {
        TPdfFile BLBR = null;

        Iterator<TPdfFile> iterator = list.iterator();
        while (iterator.hasNext()) {
            TPdfFile next = iterator.next();
            String pageKey = next.getPageKey();
            if ("BLBR".equalsIgnoreCase(pageKey)) {
                if (BLBR == null) {
                    BLBR = next;
                } else {
                    if (next.getCreateTime().after(BLBR.getCreateTime())) {
                        BLBR = next;
                    }
                    iterator.remove();
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            TPdfFile t = list.get(i);
            if ("BLBR".equalsIgnoreCase(t.getPageKey())) {
                list.set(i, BLBR);
            }
        }
        return list;
    }

    class TPdfFile {

        private String pageKey;

        private Date createTime;


        public String getPageKey() {
            return pageKey;
        }

        public void setPageKey(String pageKey) {
            this.pageKey = pageKey;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }
    }

}
