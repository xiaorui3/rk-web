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

    @Override
    public boolean deleteByDeptno(int deptno) {
        int i = 0;
        Connection connection=null;
        PreparedStatement preparedStatement =null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,user,password);
            String sql="delete from jbdc.dept where deptno=?";
            preparedStatement = connection.prepareStatement(sql);
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {

            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean addByDeptno(Dept dept) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int i;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);

            String sql = "insert into jdbc.dept values (?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, dept.getDeptno());
            preparedStatement.setString(2, dept.getDname());
            preparedStatement.setString(3, dept.getLoc());
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
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
        if (i > 0) {
            return true;
        }
        return false;
    }
}
