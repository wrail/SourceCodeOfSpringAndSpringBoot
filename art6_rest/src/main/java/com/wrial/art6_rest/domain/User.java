package com.wrial.art6_rest.domain;
/*
 * @Author  Wrial
 * @Date Created in 14:01 2019/7/23
 * @Description
 */

public class User {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Integer id;
    private String name;
}
