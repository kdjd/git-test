package com.kdjd.json;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author HeHuan
 */
public class DataDTO<T> {
    private Integer total;
    private Integer pageSize;
    private Integer pageNo;
    private List<T> list;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void addToList(T t) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        this.list.add(t);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DataDTO.class.getSimpleName() + "[", "]")
                .add("total=" + total)
                .add("pageSize=" + pageSize)
                .add("pageNo=" + pageNo)
                .add("list=" + list)
                .toString();
    }
}
