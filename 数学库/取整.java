package java代码.数学库;

import java.util.Scanner;

public class 取整 {
    /**
     * 方法	说明
     * static double ceil(double a)	返回大于或等于 a 的最小整数
     * static double floor(double a)	返回小于或等于 a 的最大整数
     * static double rint(double a)	返回最接近 a 的整数值，如果有两个同样接近的整数，则结果取偶数
     * static int round(float a)	将参数加上 1/2 后返回与参数最近的整数
     * static long round(double a)	将参数加上 1/2 后返回与参数最近的整数，然后强制转换为长整型
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        double num = input.nextDouble();
        System.out.println("大于或等于 "+ num +" 的最小整数：" + Math.ceil(num));
        System.out.println("小于或等于 "+ num +" 的最大整数：" + Math.floor(num));
        System.out.println("将 "+ num +" 加上 0.5 之后最接近的整数：" + Math.round(num));
        System.out.println("最接近 "+num+" 的整数：" + Math.rint(num));
    }
    /**
     * 请输入一个数字：
     * 99.01
     * 大于或等于 99.01 的最小整数：100.0
     * 小于或等于 99.01 的最大整数：99.0
     * 将 99.01 加上 0.5 之后最接近的整数：100
     * 最接近 99.01 的整数：99.0
     */
}
