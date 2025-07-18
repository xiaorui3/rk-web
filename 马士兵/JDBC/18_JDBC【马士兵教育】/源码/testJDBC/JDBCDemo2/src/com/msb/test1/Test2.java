package com.msb.test1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: Ma HaiYang
 * @Description: MircoMessage:Mark_7001
 */
public class Test2 {
    public static void main(String[] args) {
        Properties properties=new Properties();
        InputStream inputStream = Test2.class.getResourceAsStream("/jdbc.properties");// 指向字节码根路径下的一个文件的IO流
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String property = properties.getProperty("driver");
        System.out.println(property);


    }
}
