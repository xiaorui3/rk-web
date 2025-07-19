package com.msb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class MyConnectionPool {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/jbdc?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static String user = "root";
    private static String password = "20041123zZ@";
    private static LinkedList<Connection> pool;
    private static int initSize=5;
    private static int maxSize=10;
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        pool=new LinkedList<Connection>();
        for (int i = 0; i < initSize; i++) {
            Connection connection = initConnection();
            if (null!=connection){
                pool.add(connection);
            }
        }
    }
    private static Connection initConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //公有申请资源
    public static Connection getConnection(){
        Connection conn=null;
        if (!pool.isEmpty()){
            conn = pool.removeFirst();//移除集合中的第一个元素
        }else{
            conn=initConnection();
        }
        return conn;
    }
    //公有还资源
    public static void returnConnection(Connection conn){
        if (null!=conn){
            try {
                if (!conn.isClosed()){
                    try {
                        conn.setAutoCommit(true);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    if (pool.size()<10){
                        pool.addLast(conn);
                    }else{
                        try {
                            if (conn != null) {
                                conn.close();
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }else{
                    System.out.println(conn+"已被关闭");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

}
