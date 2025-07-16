package 马士兵.JDBC.JDBCTest01.src;


import 马士兵.JDBC.JDBCTest01.entity.TestDemo06_Obj;

import java.sql.*;
import java.util.ArrayList;

public class TestDemo06 {
    public static String driver="com.mysql.cj.jdbc.Driver";
    public static String url="jdbc:mysql://localhost:3306/jbdc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    public static String user="root";
    public static String password="20041123zZ@";

    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet=null;
        ArrayList<TestDemo06_Obj> arr=new ArrayList<>();
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            statement = conn.createStatement();
            String sql="select * from jbdc.emp";
            resultSet= statement.executeQuery(sql);
            for (int i=1;resultSet.next();i++){
                int empno = resultSet.getInt("empno");
                String ename = resultSet.getString("ename");
                String job = resultSet.getString("job");
                int mgr = resultSet.getInt("mgr");
                Date hiredate = resultSet.getDate("hiredate");
                int sal = resultSet.getInt("sal");
                int comm = resultSet.getInt("comm");
                int deptno = resultSet.getInt("deptno");
                System.out.println(empno+" "+ename+" "+job+" "+mgr+" "+hiredate+" "+ sal+" "+ comm+" "+deptno);
                arr.add(new TestDemo06_Obj(empno,ename,job,mgr,hiredate,sal,comm,deptno));
            }
            System.out.println(resultSet.toString());
            //int i = statement.executeUpdate(sql);
            //System.out.println(i);
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

        System.out.println("============================================================");
        new Print<TestDemo06_Obj>().Println(arr);


    }
}

