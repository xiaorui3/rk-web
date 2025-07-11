package 布卡.基础.ZY.ZY7_10;

import java.util.Scanner;

public class zy07 {
    public static void main(String[] args) {
        System.out.println("请输入一个数字");
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();

        switch (score / 10) {
            case 10:
                System.out.println("优秀");
                break;
            case 9:
                System.out.println("优秀");
                break;
            case 8:
                System.out.println("良好");
                break;
            case 7:
                System.out.println("中等");
                break;
            case 6:
                System.out.println("及格");
                break;
            default:
                if (score >= 0 && score < 60) {
                    System.out.println("不及格");
                } else {
                    System.out.println("输入错误");
                }
            }


        int day = sc.nextInt();

        switch (day) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("工作日");
                break;
            case 6:
            case 7:
                System.out.println("休息日");
                break;
            default:
                System.out.println("输入错误");
        }


    }
}
