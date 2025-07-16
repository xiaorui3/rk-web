package 马士兵.JDBC.JDBCTest01.src;

import 马士兵.JDBC.JDBCTest01.entity.Account;
import 马士兵.JDBC.JDBCTest01.entity.TestDemo06_Obj;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TestDemo07注入攻击 {
    public static String driver="com.mysql.cj.jdbc.Driver";
    public static String url="jdbc:mysql://localhost:3306/jbdc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    public static String user="root";
    public static String password="20041123zZ@";
    public static Account getAccount(String n,String pwd){
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet=null;
        Account acc=null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            //statement = conn.createStatement();
            String sql="select * from jbdc.account where username= ? and passwowrd= ?";
            //resultSet= statement.executeQuery(sql);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,n);
            preparedStatement.setString(2,pwd);
            resultSet = preparedStatement.executeQuery();
            for (int i=1;resultSet.next();i++){
                Integer aid = resultSet.getInt("aid");
                String username = resultSet.getString("username");
                String password1 = resultSet.getString("passwowrd");
                Double money = resultSet.getDouble("money");
                acc=new Account(aid,username,password1,money);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null!=resultSet){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (null!=statement){
                try {

                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return acc;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String next = sc.next();
        String next1 = sc.next();
        Account zhangsan = getAccount(next, next1);
        System.out.println(null!=zhangsan?"登陆成功":"登陆失败");
        System.out.println(zhangsan);
    }
}
