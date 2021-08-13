package com.empire.sitpoly.retrofit;

public class Example {

    private String name;
    private String dept;
    private String rollNo;

    public Example(String name, String dept, String rollNo) {
        this.name = name;
        this.dept = dept;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
}
