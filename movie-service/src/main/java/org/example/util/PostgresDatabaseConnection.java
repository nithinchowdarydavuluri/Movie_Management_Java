package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDatabaseConnection implements DBConnection{

    private static final PostgresDatabaseConnection instance =
            new PostgresDatabaseConnection();

    private static final String URL =
            "jdbc:postgresql://postgres:5432/Ticker_app";

    private static final String USER = "postgres";

    private static final String PASSWORD = "postgres123";

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