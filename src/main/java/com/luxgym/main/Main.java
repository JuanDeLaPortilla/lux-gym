package com.luxgym.main;

import com.luxgym.controllers.LoginControlador;
import com.luxgym.util.DatabaseConnection;
import com.luxgym.views.Login;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            Login login = new Login();
            LoginControlador loginControlador = new LoginControlador(login);
            login.setVisible(true);
        } catch (SQLException | ClassNotFoundException ex) {
            DatabaseConnection.throwErrorMessage(ex);
        }
    }
}
