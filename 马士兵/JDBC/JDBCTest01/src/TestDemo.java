package 马士兵.JDBC.JDBCTest01.src;

import java.sql.*;

public class TestDemo {
    public static void main(String[] args) throws SQLException {
        //加载驱动
        Driver driver =new com.mysql.cj.jdbc.Driver();
        //注册驱动
        DriverManager.registerDriver(driver);
        //获得链接
        String url="jdbc:mysql://localhost:3306/jbdc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        Connection connection = DriverManager.getConnection(url,"root","20041123zZ@");
        //获得语句
        Statement statement = connection.createStatement();
        //执行SQL
        String sql="insert into dept values (50,'教学部','北京')";
        /*
        * insert delete update 都是调用statement.executeUpdate
        * */
        int i = statement.executeUpdate(sql);
        System.out.println("影响的行数："+i);

        statement.close();
        connection.close();
        //释放资源

    }
}
