package com.zw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        test1();
    }

    private static void test1() {
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/testdb1";
            // 连接数据库
            Connection connection = DriverManager.getConnection(url, "root", "root");
//            connection.setAutoCommit(false);
            String sql = "insert into user (name,age)values ('hello',1)";
            Statement statement = connection.createStatement();

            // 执行
            statement.execute(sql);

            statement.close();
            connection.close();

//            connection.commit();
//            connection.rollback();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}