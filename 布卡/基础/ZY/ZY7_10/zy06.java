package 布卡.基础.ZY.ZY7_10;

import java.util.Scanner;

public class zy06 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int day=sc.nextInt();
        if (day>=1 && day<=5){
            System.out.println("工作日");
        }else if(day==6 || day==7){
            System.out.println("休息日");
        }else{
            System.out.println("输入错误");
        }
    }
}
