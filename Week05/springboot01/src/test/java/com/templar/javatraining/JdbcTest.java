package com.templar.javatraining;

import lombok.Data;
import lombok.ToString;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTest {

    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private String querySql = "select * from user";

    @Test
    public void testStatement() {
        JdbcTest tester = new JdbcTest();
        List<User> userList = new ArrayList<User>();
        try {
            tester.createConnection();
            String execSql = querySql + " where id = 1";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(execSql);
            while (resultSet.next()) {
                User user = new User();
                user.setId((Integer) resultSet.getObject("id"));
                user.setName(resultSet.getString("name"));
                userList.add(user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                closeResouce();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("statement-UserList: " + userList);
    }

    @Test
    public void testPreparedStatement() {
        JdbcTest tester = new JdbcTest();
        List<User> userList = new ArrayList<User>();
        try {
            tester.createConnection();
            String execSql = querySql + " where id = ?";
            preparedStatement = connection.prepareStatement(execSql);
            preparedStatement.setInt(1, 1);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId((Integer) resultSet.getObject("id"));
                user.setName(resultSet.getString("name"));
                userList.add(user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                closeResouce();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("preparedStatement-UserList: " + userList);
    }

    @Data
    @ToString
    class User {
        private int id;
        private String name;
    }

    private void createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
    }

    private void closeResouce() throws SQLException {
        if (null != resultSet) {
            resultSet.close();
        }
        if (null != statement) {
            statement.close();
        }
        if (null != preparedStatement) {
            preparedStatement.close();
        }
        if (null != connection) {
            connection.close();
        }
    }

}
