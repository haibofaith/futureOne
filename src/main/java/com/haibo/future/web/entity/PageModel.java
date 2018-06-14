package com.haibo.future.web.entity;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable{
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageModel{" +
                "list=" + list +
                '}';
    }
}
