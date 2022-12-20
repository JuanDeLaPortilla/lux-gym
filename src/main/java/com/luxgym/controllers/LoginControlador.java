package com.luxgym.controllers;

import com.luxgym.dao.UsuarioDAO;
import com.luxgym.models.Usuario;
import com.luxgym.util.DatabaseConnection;
import com.luxgym.views.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginControlador implements MouseListener {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private Login vista = new Login();

    public LoginControlador(Login vista) throws SQLException, ClassNotFoundException {
        this.vista = vista;
        this.vista.loginBtnTxt.addMouseListener(this);
        this.vista.signUpBtnTxt.addMouseListener(this);
        this.vista.exitTxt.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            if (e.getSource() == vista.loginBtnTxt) {
                validar();
            }
            if (e.getSource() == vista.signUpBtnTxt) {
                SignUp signUp = new SignUp();
                SignUpControlador controlador = new SignUpControlador(signUp);
                signUp.setVisible(true);
                vista.dispose();
            }
            if (e.getSource() == vista.exitTxt) {
                int input = JOptionPane.showConfirmDialog(null, "¿Está seguro de que quiere salir?", "SALIR", JOptionPane.YES_NO_OPTION);
                if (input == 0) {
                    System.exit(0);
                }
            }
        } catch (SQLException | ClassNotFoundException exception) {
            DatabaseConnection.throwErrorMessage(exception);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void validar() throws SQLException, ClassNotFoundException {
        //Se comprueba que los campos no esten vacios
        if ("".equals(vista.correoTxt.getText()) || "ejemplo@gmail.com".equals(vista.correoTxt.getText())) {
            JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Correo Electróncio", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if ("".equals(String.valueOf(vista.passTxt.getPassword())) || "********".equals(String.valueOf(vista.passTxt.getPassword()))) {
            JOptionPane.showMessageDialog(null, "Porfavor Ingrese una Contraseña", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //Se rescatan los datos
        String correo = vista.correoTxt.getText();
        String pass = String.valueOf(vista.passTxt.getPassword());

        //Se busca el usuario en el modelo
        Usuario usuario = usuarioDAO.login(correo, pass);

        try {//Se comprueba que el usario no este vacio
            if (usuario.getNivel().getId() == 1) {//Si el usuario es cliente
                UserPanel userPanel = new UserPanel(usuario);
                UserControlador userControlador = new UserControlador(userPanel);
                userPanel.setVisible(true);
                vista.dispose();
                return;
            }

            if (usuario.getNivel().getId() == 3) {//Si el usuario es admin
                AdminPanel adminPanel = new AdminPanel();
                AdminControlador adminControlador = new AdminControlador(adminPanel);
                adminPanel.setVisible(true);
                vista.dispose();
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Correo o Contraseña Incorrecta", "CAMPO INCORRECTO", JOptionPane.WARNING_MESSAGE);
        }
    }
}
