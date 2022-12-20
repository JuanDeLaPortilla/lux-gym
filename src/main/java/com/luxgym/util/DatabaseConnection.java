package com.luxgym.util;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    Connection connection;

    public Connection getConnection() {
        try {
            String db = "jdbc:mysql://localhost:3306/luxgym_db?allowMultiQueries=true";
            connection = DriverManager.getConnection(db, "root", "");
            return connection;
        } catch (SQLException e) {
            throwExceptionMessage(e);
        }
        return null;
    }

    private static void throwExceptionMessage(SQLException e) {
        JOptionPane.showMessageDialog(null, e.toString(), "CÓDIGO DE ERROR: " + e.getErrorCode(), JOptionPane.WARNING_MESSAGE);
    }

    public static void throwErrorMessage(Exception e) {
        JOptionPane.showMessageDialog(null, e.toString(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }
}
