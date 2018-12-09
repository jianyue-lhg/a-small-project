package com.syb.hometeacher;

import java.sql.*;

public class testJdbc {
    private static final String URL = "jdbc:mysql://localhost:3306/home_teacher?useSSL=false&serverTimezone=GMT";
    private static final String NAME = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {

        Connection conn = null;
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获得数据库的连接
            conn = DriverManager.getConnection(URL, NAME, PASSWORD);
            //3.通过数据库的连接操作数据库，实现增删改查
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from test");
            while (rs.next()) {//如果对象中有数据，就会循环打印出来
                System.out.println(rs.getInt("uid") + " " + rs.getString("uname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
