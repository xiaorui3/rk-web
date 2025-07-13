package 布卡.基础.ZY.ZY7_11;

import java.util.Scanner;

public class zy8 {
    public static void main(String[] args) {
        //Server: SQL
        String[] users={"zhangsan","lisi","wangwu","zhaoliu"};
        String[] pwds={"333","444","555","666"};


        //Client:
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name=sc.next();
        System.out.println("请输入密码：");
        String pwd=sc.next();

        boolean flagName=false;
        boolean flagPwd=false;
        for(int i=0;i<users.length;i++){
            if(name.equals(users[i])){
                if (pwd.equals(pwds[i])){
                    //System.out.println("登录成功");
                    flagName=true;
                    flagPwd=true;
                    break;
                }else{
                    //System.out.println("密码错误");
                    flagName=true;
                }
            }else{
                //System.out.println("用户名不存在");

            }
        }
        if (flagName){
            if (flagPwd){
                System.out.println("登录成功");
            }else{
                System.out.println("密码错误");
            }
        }else{
            System.out.println("用户名不存在");
        }
    }
}
