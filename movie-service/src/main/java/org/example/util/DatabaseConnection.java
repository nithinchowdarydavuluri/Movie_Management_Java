package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection implements  DBConnection{
    private static final DatabaseConnection inst = new DatabaseConnection();
    private  static String url = DatabaseConfig.get("mysql.url");
    private  static String user = DatabaseConfig.get("mysql.user");
    private  static String password = DatabaseConfig.get("mysql.password");


    public static DatabaseConnection getInstance(){
        return  inst;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url,user,password);
    }

}
