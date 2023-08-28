package com.kdjd.test;

public class A002 {

    private static final String[] num = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

    private static final String[] unit = {"", "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            String str = convert2cn(i);
            System.out.println(str);
        }
    }

    public static String convert2cn(int src) {
        if (src == 0) {
            return num[src];
        }
        StringBuilder dst = new StringBuilder();
        int count = 0;
        while (src > 0) {
            dst.insert(0, (num[src % 10] + unit[count]));
            src = src / 10;
            count++;
        }
        return dst.toString().replaceAll("零[千百十]", "零").replaceAll("零+万", "万")
                .replaceAll("零+亿", "亿").replaceAll("亿万", "亿零")
                .replaceAll("零+", "零").replaceAll("零$", "")
                .replaceAll("^一十", "十");
    }

}
