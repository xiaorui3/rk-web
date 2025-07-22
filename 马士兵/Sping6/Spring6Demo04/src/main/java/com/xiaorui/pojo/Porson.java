package com.xiaorui.pojo;

public class Porson {
    public Student getStudent(){
        return new Student("小王", 18);
    }

    @Override
    public String toString() {
        return "Porson{}";
    }
}
