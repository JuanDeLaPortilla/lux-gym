package com.luxgym.controllers;

import com.luxgym.dao.*;
import com.luxgym.models.*;
import com.luxgym.util.DatabaseConnection;
import com.luxgym.views.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class SignUpControlador implements MouseListener {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private SignUp vista = new SignUp();

    public SignUpControlador(SignUp vista) throws SQLException, ClassNotFoundException {
        this.vista = vista;
        this.vista.registrarBtnTxt.addMouseListener(this);
        this.vista.exitTxt.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.registrarBtnTxt) {
            agregar();
        }
        if (e.getSource() == vista.exitTxt) {
            try {
                int input = JOptionPane.showConfirmDialog(null, "¿Está seguro de que quiere volver al Inicio?", "SALIR", JOptionPane.YES_NO_OPTION);
                if (input == 0) {
                    Login login = new Login();
                    LoginControlador loginControlador = new LoginControlador(login);
                    login.setVisible(true);
                    vista.dispose();
                }
            } catch (SQLException | ClassNotFoundException ex) {
                DatabaseConnection.throwErrorMessage(ex);
            }
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

    private void agregar() {
        try {
            //Comprobacion de Campos
            if ("Ingrese su nombre".equals(vista.txtNombre.getText()) || vista.txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Nombre", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if ("Ingrese su apellido".equals(vista.txtApellido.getText()) || vista.txtApellido.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Apellido", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if ("Ingrese su correo electrónico".equals(vista.txtCorreo.getText()) || vista.txtCorreo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Correo", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if ("********".equals(String.valueOf(vista.txtPass.getPassword())) || (String.valueOf(vista.txtPass.getPassword()).isEmpty())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese una Contraseña", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Se rescatan los datos
            String nombre = vista.txtNombre.getText();
            String apellido = vista.txtApellido.getText();
            String correo = vista.txtCorreo.getText();
            String contrasena = (String.valueOf(vista.txtPass.getPassword()));

            //Se crea el nivel
            Nivel nivel = new Nivel();
            nivel.setId(1);

            //Se crea el Modelo
            Usuario usuario = new Usuario(nivel, nombre, apellido, correo, contrasena);

            //Se envian los datos a la base de datos con el DAO
            usuarioDAO.add(usuario);

            //Mensaje de Exito
            JOptionPane.showMessageDialog(null, "Se Ha Registrado con Éxito ", "REGISTRO EXITOSO", JOptionPane.INFORMATION_MESSAGE);

            //Se Reenvia al Login
            Login login = new Login();
            LoginControlador loginControlador = new LoginControlador(login);
            login.setVisible(true);
            vista.dispose();
        } catch (SQLException | ClassNotFoundException e) {
            DatabaseConnection.throwErrorMessage(e);
        }
    }
}
