package 马士兵.JDBC.JDBCTest01.src;

import 马士兵.JDBC.JDBCTest01.entity.Account;

import java.sql.*;
import java.util.Arrays;

public class TestDemo08批处理 {
    public static String driver="com.mysql.cj.jdbc.Driver";
    public static String url="jdbc:mysql://localhost:3306/jbdc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    public static String user="root";
    public static String password="20041123zZ@";
    public static void main(String[] args) {
        for (int i = 3195; i < 3196; i++) {
            getAccount(String.valueOf(i),String.valueOf(i),i);
            //getAccount(i);
            System.out.println(i);
        }
    }


    public static void getAccount(String n, String pwd,int money){
        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            //statement = conn.createStatement();
            String sql="insert into jbdc.account values (null,?,?,?)";
            //String sql="delete from jbdc.emp where DEPTNO=?";

            //resultSet= statement.executeQuery(sql);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            for (int i = 0; i < 10000; i++) {
                preparedStatement.setString(1,n);
                preparedStatement.setString(2,pwd);
                preparedStatement.setString(3, String.valueOf(money));
                preparedStatement.addBatch();
                if (i%1000==0){
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                }
            }
            //System.out.println(Arrays.toString(preparedStatement.executeBatch()));
            int[] ints = preparedStatement.executeBatch();
            preparedStatement.clearBatch();
            for (int i:ints){
                System.out.print(i+" ");
            }

            //preparedStatement.setString(3, String.valueOf(money));
            //int resultSet = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    }
    public static void getAccount(int n){
        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            //statement = conn.createStatement();
            //String sql="insert into jbdc.account values (null,?,?,?)";
            String sql="delete from jbdc.account where aid=?";

            //resultSet= statement.executeQuery(sql);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(n));
            //preparedStatement.setString(1,n);
            //preparedStatement.setString(2,pwd);
            //preparedStatement.setString(3, String.valueOf(money));
            int resultSet = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    }
}
