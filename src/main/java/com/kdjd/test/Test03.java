package com.kdjd.test;

public class Test03 {

    public static void main(String[] args) {
        //String a = "2022-04-16";
        //String b = "2022-04-26";
        //String c = "2022-04-28";
        //
        //System.out.println(a.compareTo(b));
        //System.out.println(a.compareTo(c));
        //System.out.println(c.compareTo(b));
        //
        //System.out.println(a.hashCode());
        //System.out.println(b.hashCode());
        //System.out.println(c.hashCode());
        //
        //
        //System.out.println(Short.MAX_VALUE);
        //System.out.println(Integer.MAX_VALUE);
        //System.out.println(Long.MAX_VALUE);
        //
        //System.out.println(Short.MIN_VALUE);
        //System.out.println(Integer.MIN_VALUE);
        //System.out.println(Long.MIN_VALUE);
        
        
        String sql = "insert into t values ('a',1,'c'd')";

        String s = processEscape(sql);
        
        System.out.println(s);

    }
    private static final char ESCAPE_CHAR = '\\';

    private static final int TARGET_STRING_LENGTH = 2;

    public static String processEscape(String sql) {
        int firstIndex = -1;
        if ((sql == null) || ((firstIndex = sql.indexOf(ESCAPE_CHAR)) == -1)) {
            return sql;
        } else {
            int lastIndex = sql.lastIndexOf(ESCAPE_CHAR, sql.length() - 2) + TARGET_STRING_LENGTH;
            StringBuilder sb = new StringBuilder(sql);
            for (int i = firstIndex; i < lastIndex; i ++) {
                if (sb.charAt(i) == '\\') {
                    if (i + 1 < lastIndex
                            && sb.charAt(i + 1) == '\'') {
                        //replace
                        sb.setCharAt(i, '\'');
                    }
                    //roll over
                    i ++;
                }
            }
            return sb.toString();
        }
    }
}
