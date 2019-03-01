package com.src.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/library";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    public Connection getConnection() throws ClassNotFoundException {
        Connection conn = null;
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Connecting to a selected database...");
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Connected database successfully...");
        return conn;
    }
}
