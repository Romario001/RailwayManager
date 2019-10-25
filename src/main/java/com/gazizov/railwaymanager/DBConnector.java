package com.gazizov.railwaymanager;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 24.10.2019
 *
 * @author Roman Gazizov
 */
public class DBConnector {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&serverTimezone=UTC";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Driver driver;
try {
    driver = new com.mysql.cj.jdbc.Driver();
} catch (SQLException e) {
    System.out.println("Error occurs when driver is created");
    return;
}

try {
    DriverManager.registerDriver(driver);
} catch (SQLException e) {
    System.out.println("Cannot register driver");
    return;
}
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            System.out.println("code...");
        } catch (SQLException e) {
            System.out.println("Connection is failed");
            return;
        }
        finally {
            if (connection != null) {connection.close();}
        }

    }
}
