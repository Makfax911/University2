package com.example.University2.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler {
  static   Connection dbConnection;

    public static Connection getDbConnection()
            throws ClassNotFoundException, SQLException {


        System.out.println("Connecting to a selected database...");
        dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/university", "root", "root1");
        System.out.println("Connected database successfully...");

        return dbConnection;
    }

}
