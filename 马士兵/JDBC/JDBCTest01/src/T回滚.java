package 马士兵.JDBC.JDBCTest01.src;

import java.sql.*;

public class T回滚 {
    public static String driver="com.mysql.cj.jdbc.Driver";
    public static String url="jdbc:mysql://localhost:3306/jbdc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    public static String user="root";
    public static String password="20041123zZ@";
    public static void main(String[] args) {


    }


    public static void getAccount(int n1,int money,int n2){
        Connection conn=null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,password);
            conn.setAutoCommit(false);
            String sql="update jbdc.account set money=money-? where aid=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,money);
            preparedStatement.setInt(2,n1);
            preparedStatement.executeUpdate();

            preparedStatement.setInt(1,money);
            preparedStatement.setInt(2,n2);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null) {
                    conn.commit();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
