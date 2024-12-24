package com.example.demo.boardgamecatalog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbAccess {

    private static Connection connection;

    private DbAccess() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/mysql";
                String username = "root";
                String password = "root";

                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to connect to database", e);
            }
        }
        return connection;
    }
}
