package com.msb.test2;

import com.msb.entity.Account;
import com.msb.entity.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Ma HaiYang
 * @Description: MircoMessage:Mark_7001
 */
public class TestInjection {
    private static String driver ="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
    private static String user="root";
    private static String password="root";

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("请输入用户名");
        String username=sc.next();
        System.out.println("请输入密码");
        String pwd =sc.next();


        Account account = getAccount(username, pwd);
        System.out.println(null!= account?"登录成功":"登录失败");
        sc.close();
    }


    public static Account getAccount(String username,String pwd){
        Connection connection = null;
        Statement statement=null;
        ResultSet resultSet=null;

        Account account =null;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user,password);
            statement = connection.createStatement();
            String sql="select * from account where username ='"+username+"' and password ='"+pwd+"'";
            System.out.println(sql);
            resultSet = statement.executeQuery(sql);


            while(resultSet.next()){
                int aid = resultSet.getInt("aid");
                String usernamea = resultSet.getString("username");
                String pwda = resultSet.getString("password");
                double money = resultSet.getDouble("money");
                account=new Account(aid,usernamea,pwda,money);
                System.out.println(account);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != resultSet){
                try {
                    resultSet.close();
                } catch (SQLException e) {e.printStackTrace();

                }

            }
            if(null != statement){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(null != connection){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return account;

    }
}
