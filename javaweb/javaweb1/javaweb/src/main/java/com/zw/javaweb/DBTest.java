package com.zw.javaweb;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBTest {
    public void test() {
        DataSource dataSource = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            //sql语句
            String sql = "update account set balance=balance-100 where id=1";
            String sql2 = "update account set balance=balance+100 where id=2";

            connection.setAutoCommit(false);//事务开始
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();//执行第一个sql
            //int i = 1 / 0;//抛出异常
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();//执行sql2
            //提交事务
            connection.commit();
        } catch (SQLException e) {
            //进行事务回滚，默认回滚到事务开始的地方
            System.out.println("发生异常，撤销执行的sql");
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            if (null != preparedStatement) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (null != connection) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
