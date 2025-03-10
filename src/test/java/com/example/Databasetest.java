package com.example;

import java.sql.Connection;
import java.sql.SQLException;

public class Databasetest {
    public static void main(String[] args) {
        // Test database connection
        try (Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Connection established successfully!");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
