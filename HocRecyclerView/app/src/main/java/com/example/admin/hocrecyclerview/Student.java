package com.example.admin.hocrecyclerview;

/**
 * Created by ADMIN on 9/4/2017.
 */

public class Student {
    public String name;
    public String lop;

    public Student() {
    }

    public Student(String name, String lop) {
        this.name = name;
        this.lop = lop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
}
