package 马士兵.JDBC.JDBCTest01.src;


import java.sql.*;

public class TestDemo04 {
    public static String driver="com.mysql.cj.jdbc.Driver";
    public static String url="jdbc:mysql://localhost:3306/jbdc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    public static String user="root";
    public static String password="20041123zZ@";

    public static void main(String[] args) {
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement statement = conn.createStatement();
        String sql="insert into dept values (55,'教学部','北京')";
        int i = statement.executeUpdate(sql);
        System.out.println(i);
        statement.close();
        conn.close();

    }
}

