package com.codegnan.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/vehicledb";
    private static final String USER = "root";
    private static final String PASSWORD = "Hari@2003";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("DB Connection Failed", e);
        }
    }
}
