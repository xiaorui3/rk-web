package com.xiaorui.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Porson2 {
    @Value("11")
    private int age;
    @Value("xiaorui")
    private String name;

    @Override
    public String toString() {
        return "Porson2{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
