package com.kdjd.test;

import java.text.ParseException;

public class Test04 {

    public static void main(String[] args) throws ParseException {
        TDept sfsDept = new TDept(132L, "大寺司法所管理三组");
        TDept qxDept = new TDept(15L, "天津市西青区社区矫正管理支队");

        String qxDeptName = (qxDept == null || sfsDept.getPkId().equals(qxDept.getPkId())) ? sfsDept.getDeptName() :
                (qxDept.getDeptName() + (sfsDept.getDeptName().replace(qxDept.getDeptName().replace("司法局", "").replace("社区矫正管理支队", ""), "")));

        System.out.println(qxDeptName);

    }


}