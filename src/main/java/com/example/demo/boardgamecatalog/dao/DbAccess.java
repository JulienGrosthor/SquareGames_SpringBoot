package com.example.demo.boardgamecatalog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbAccess {
    private static final String URL = "jdbc:mysql://localhost:3306/square_games";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection connection;

    private DbAccess() { } // Constructeur privé pour empêcher l'instanciation

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
}
