package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDatabaseConnection implements DBConnection{

    private static final PostgresDatabaseConnection instance =
            new PostgresDatabaseConnection();

    private static final String URL = DatabaseConfig.get("postgresql.url");

    private static final String USER = DatabaseConfig.get("postgresql.user");

    private static final String PASSWORD = DatabaseConfig.get("postgresql.password");

    private PostgresDatabaseConnection() {
    }

    public static PostgresDatabaseConnection getInstance() {
        return instance;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}