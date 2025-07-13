package java代码.异常;

import java.util.Scanner;

public class tryatch语句 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------学生信息录入---------------");
        String name = ""; // 获取学生姓名
        int age = 0; // 获取学生年龄
        String sex = ""; // 获取学生性别
        try {
            System.out.println("请输入学生姓名：");
            name = scanner.next();
            System.out.println("请输入学生年龄：");
            age = scanner.nextInt();
            System.out.println("请输入学生性别：");
            sex = scanner.next();
        } catch (Exception e) {
            e.printStackTrace();
/**
 *  printStackTrace() 方法：指出异常的类型、性质、栈层次及出现在程序中的
 *             位置（关于 printStackTrace 方法的使用可参考《Java的异常跟踪栈》一节）。
 *             getMessage() 方法：输出错误的性质。
 *             toString() 方法：给出异常的类型与性质。
 */
            System.out.println("输入有误！");
        }
        System.out.println("姓名：" + name);
        System.out.println("年龄：" + age);
    }
}
