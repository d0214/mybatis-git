package com.aaa.dc.entity;

import java.io.Serializable;

public class student implements Serializable {
    private int id;
    private String name;
    private int age;
    private String dizhi;

    public student(){}

    public student(int id, String name, int age, String dizhi) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dizhi = dizhi;
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

    public String getDizhi() {
        return dizhi;
    }

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dizhi='" + dizhi + '\'' +
                '}';
    }
}
