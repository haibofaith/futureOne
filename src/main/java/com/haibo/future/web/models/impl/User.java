package com.haibo.future.web.models.impl;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
    private String name;
    private Date date;

    public User() {
    }

    public User(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
