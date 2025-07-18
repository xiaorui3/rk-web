package com.msb.test1;

import org.apache.log4j.Logger;

/**
 * @Author: Ma HaiYang
 * @Description: MircoMessage:Mark_7001
 */
public class TestLog4j {
    public static void main(String[] args) {
        // 1字符串一般传入一个类的全路径名
        // 2传入一个类的字节码 其实就是根据类的字节码自动获取类的全路径名

        Logger logger=Logger.getLogger(TestLog4j.class);

        logger.fatal("fatal message");
        logger.error("error message");
        logger.warn("warn message");
        logger.info("info message");
        logger.debug("debug message");

        // 打印异常信息
        try {
            int i =1/0;
        } catch (Exception e) {

            logger.warn("程序捕获到了异常",e);
        }


    }

}
