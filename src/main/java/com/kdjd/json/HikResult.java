package com.kdjd.json;

import java.util.StringJoiner;

/**
 * 海康平台返回数据类
 *
 * @author HeHuan
 */
public class HikResult<T> {

    private String code;
    private String msg;
    private DataDTO<T> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataDTO<T> getData() {
        return data;
    }

    public void setData(DataDTO<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", HikResult.class.getSimpleName() + "[", "]")
                .add("code='" + code + "'")
                .add("msg='" + msg + "'")
                .add("data=" + data)
                .toString();
    }
}
