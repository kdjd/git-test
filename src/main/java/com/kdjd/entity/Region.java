package com.kdjd.entity;

/**
 * 区域
 *
 * @author HeHuan
 */
public class Region {

    /**
     * 区域编码（长度1-255位）
     */
    private String indexCode;
    /**
     * 名称（长度1-255位）
     */
    private String name;
    /**
     * 父区域编码（长度1-255位）
     */
    private String parentIndexCode;
    /**
     * 树编号（非必填）
     */
    private String treeCode;
}
