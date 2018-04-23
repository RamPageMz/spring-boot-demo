package com.example.demo.criteria;

import org.springframework.util.Assert;

import java.io.Serializable;

public class UserCriteria implements Serializable {

    private static final long serialID=1L;

    private String name;

    public UserCriteria(){

    }

    public UserCriteria(String name){
        Assert.notNull(name,"Name must be not null");
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
