package com.lzx.Entity;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ronin on 2018/2/6.
 */
public class Mate implements Serializable{


    /** 主键id */
    private int id;


    /** 姓名 */
    private String name;


    /** 年龄 */
    private int age;


    private Date brithday;


    public Mate() {
    }

    public Mate(Integer id, String name, int age, Date brithday) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.brithday = brithday;
    }

    public Mate(String name, int age, Date brithday) {
        this.name = name;
        this.age = age;
        this.brithday = brithday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }
}
