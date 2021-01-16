package com.polinayantsen.hibernatedemo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

    public static void main(String[] args) {
        final String JDBC_URL = "jdbc:mysql://localhost:3306/hb_many_to_many?useSSL=false&serverTimezone=UTC";
        final String USER = "hbstudent";
        final String PASSWORD = "hbstudent";
        try {
            System.out.println(">> Connecting to database: " + JDBC_URL);
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println(">> Connection successful!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
