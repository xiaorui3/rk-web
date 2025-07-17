package com.msb.dao.impl;

import com.msb.dao.DeptDao;
import com.msb.pojo.Dept;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {
    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/jbdc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    public static String user = "root";
    public static String password = "20041123zZ@";
    @Override
    public List<Dept> findAll() {
        List<Dept> arr =new ArrayList<>();
        Connection connection =null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,user,password);
            String sql="select * from jbdc.dept";
            preparedStatement= connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Dept dept =new Dept();
                dept.setDeptno(resultSet.getInt("deptno"));
                dept.setDname(resultSet.getString("dname"));
                dept.setLoc(resultSet.getString("loc"));
                arr.add(dept);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }



        return arr;
    }
}
