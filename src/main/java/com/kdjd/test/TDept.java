package com.kdjd.test;


import java.io.Serializable;

public class TDept implements Serializable {

    private Long pkId;

    private String deptName;

    public TDept() {
    }

    public TDept(Long pkId, String deptName) {
        this.pkId = pkId;
        this.deptName = deptName;
    }

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}