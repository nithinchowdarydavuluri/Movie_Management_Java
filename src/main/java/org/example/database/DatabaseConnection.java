package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final DatabaseConnection inst = new DatabaseConnection();
    private  static String url = "jdbc:mysql://mysql:3306/Ticker_app";
    private  static String user = "root";
    private  static String password = "Kritter@1";


    public static DatabaseConnection getInstance(){
        return  inst;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url,user,password);
    }

}
