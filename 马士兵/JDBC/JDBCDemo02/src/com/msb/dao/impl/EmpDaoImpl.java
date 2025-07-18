package com.msb.dao.impl;

import com.msb.dao.EmpDao;
import com.msb.pojo.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/jbdc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    public static String user = "root";
    public static String password = "20041123zZ@";

    @Override
    public int addEmp(Emp emp) {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Emp> arr = new ArrayList<>();
        int i = 0;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            String sql = "insert into jbdc.emp  values (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, emp.getEmpno());
            preparedStatement.setString(2, emp.getEname());
            preparedStatement.setString(3, emp.getJob());
            preparedStatement.setInt(4, emp.getMgr());
            preparedStatement.setObject(5, emp.getHiredate());
            preparedStatement.setObject(6, emp.getSal());
            preparedStatement.setObject(7, emp.getComm());
            preparedStatement.setObject(8, emp.getDeptno());
            i = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != resultSet) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (null != statement) {
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
        return i;
    }

    @Override
    public int deleteByEmpno(int empno) {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Emp> arr = new ArrayList<>();
        int i = 0;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            String sql = "delete from jbdc.emp where empno=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, empno);
            i = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != resultSet) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (null != statement) {
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
        return i;
    }

    @Override
    public List<Emp> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Emp> arr = new ArrayList<>();
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            String sql = "select * from jbdc.emp";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Emp e = new Emp();
                e.setEmpno(resultSet.getInt("empno"));
                e.setEname(resultSet.getString("ename"));
                e.setJob(resultSet.getString("job"));
                e.setMgr(resultSet.getInt("mgr"));
                e.setHiredate(resultSet.getDate("hiredate"));
                e.setSal(resultSet.getInt("sal"));
                e.setComm(resultSet.getInt("comm"));
                e.setDeptno(resultSet.getInt("deptno"));
                arr.add(e);
            }

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
        return arr;
    }
}
