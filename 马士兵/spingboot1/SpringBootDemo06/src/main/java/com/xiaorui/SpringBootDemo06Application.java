package com.xiaorui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiaorui.mapper")
public class SpringBootDemo06Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo06Application.class, args);



    }

}
