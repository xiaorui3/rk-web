package 马士兵.JDBC.JDBCTest01.src;


import java.sql.*;

public class TestDemo03 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //String url="jdbc:mysql://localhost:3306/jbdc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
        String url="jdbc:mysql://localhost:3306/jbdc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        String user="root";
        String pw="20041123zZ@";
        Connection conn = DriverManager.getConnection(url, user, pw);

        Statement statement = conn.createStatement();
        String sql="insert into dept values (54,'教学部','北京')";
        int i = statement.executeUpdate(sql);
        System.out.println(i);
        statement.close();
        conn.close();

    }
}

