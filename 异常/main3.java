package 异常;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main3 {
    public static void main(String[] args) {
        ArrayList<g> arr=new ArrayList<>();
        boolean extracted = extracted();
        if (extracted) {
            Scanner sc=new Scanner(System.in);
            g g1=new g();
            System.out.println("请录入姓名:");
            boolean a1=true;
            while (a1){
                String name=sc.next();
                a1=g1.setName(name);
                if(!a1){
                    System.out.println("姓名录入失败!");
                    System.out.println("请录入姓名:");
                }
                a1=!a1;
            }
            System.out.println("请录入年龄:");
            a1=true;
            while (a1){
                String age= sc.next();
                a1=g1.setAge(age);
                if(!a1){
                    System.out.println("请录入年龄:");
                }
                a1=!a1;
            }
            arr.add(g1);
            System.out.println(arr);
        }
        else{
            System.out.println("已经停止录入信息");
        }
    }

    private static boolean extracted() {
        Scanner sc=new Scanner(System.in);
        System.out.println("是否开始录入信息?");
        System.out.println("是   否");
        String bool= sc.next();
        if(bool.equals("是")){
            return true;
        }
        else if(bool.equals("否")){
            return false;
        }
        else{
            System.out.println("输入有误");
            System.out.println("错误日志如下");
            Exception e=new RuntimeException();
            e.printStackTrace();
            return false;
        }
    }
}
