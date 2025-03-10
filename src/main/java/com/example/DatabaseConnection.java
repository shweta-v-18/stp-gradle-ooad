package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // MySQL database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/stock-trading-platform";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mysql";

    // Static block to explicitly load MySQL JDBC driver
    static {
        try {
            // Load the MySQL driver explicitly
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Handle the exception if the driver is not found
        }
    }

    // Method to get a database connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
