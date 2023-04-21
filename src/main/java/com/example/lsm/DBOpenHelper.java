package com.example.lsm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOpenHelper {
    private final static String driver = "com.mysql.jdbc.Driver";
    private final static String url = "jdbc:mysql://10.99.125.141/ditie?useUnicode=true&characterEncoding=UTF-8";
   public static String db_user = "root";
    public static String db_pass = "hzl02096";
    public static Connection getConn () {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");//加载驱动
            conn = DriverManager.getConnection(url, db_user, db_pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void close (Statement state, Connection conn) {
        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close (ResultSet rs, Statement state, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws SQLException {
    }
}


