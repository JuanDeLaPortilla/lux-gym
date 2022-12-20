package com.luxgym.controllers;

import com.luxgym.util.DatabaseConnection;
import com.luxgym.views.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AdminControlador implements MouseListener {

    private AdminPanel vista = new AdminPanel();

    public AdminControlador(AdminPanel vista) throws SQLException, ClassNotFoundException {
        this.vista = vista;
        this.vista.entrenadoresBtnTxt.addMouseListener(this);
        this.vista.especialidadesBtnTxt.addMouseListener(this);
        this.vista.horariosBtnTxt.addMouseListener(this);
        this.vista.matriculasBtnTxt.addMouseListener(this);
        this.vista.nivelesBtnTxt.addMouseListener(this);
        this.vista.usuariosBtnTxt.addMouseListener(this);
        this.vista.exitTxt.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            if (e.getSource() == vista.entrenadoresBtnTxt) {
                EntrenadorVista entrenadorVista = new EntrenadorVista();
                EntrenadorControlador entrenadorControlador = new EntrenadorControlador(entrenadorVista);
                entrenadorVista.setVisible(true);
                vista.dispose();
            }
            if (e.getSource() == vista.especialidadesBtnTxt) {
                EspecialidadVista especialidadVista = new EspecialidadVista();
                EspecialidadControlador especialidadControlador = new EspecialidadControlador(especialidadVista);
                especialidadVista.setVisible(true);
                vista.dispose();
            }
            if (e.getSource() == vista.horariosBtnTxt) {
                HorarioVista horarioVista = new HorarioVista();
                HorarioControlador horarioControlador = new HorarioControlador(horarioVista);
                horarioVista.setVisible(true);
                vista.dispose();
            }
            if (e.getSource() == vista.matriculasBtnTxt) {
                MatriculaVista matriculaVista = new MatriculaVista();
                MatriculaControlador matriculasControlador = new MatriculaControlador(matriculaVista);
                matriculaVista.setVisible(true);
                vista.dispose();
            }
            if (e.getSource() == vista.nivelesBtnTxt) {
                NivelVista nivelVista = new NivelVista();
                NivelControlador nivelControlador = new NivelControlador(nivelVista);
                nivelVista.setVisible(true);
                vista.dispose();
            }
            if (e.getSource() == vista.usuariosBtnTxt) {
                UsuariosVista usuarioVista = new UsuariosVista();
                UsuariosControlador usuarioControlador = new UsuariosControlador(usuarioVista);
                usuarioVista.setVisible(true);
                vista.dispose();
            }
            if (e.getSource() == vista.exitTxt) {
                int input = JOptionPane.showConfirmDialog(null, "¿Está seguro de que quiere salir?", "SALIR", JOptionPane.YES_NO_OPTION);
                if (input == 0) {
                    Login login = new Login();
                    LoginControlador loginControlador = new LoginControlador(login);
                    login.setVisible(true);
                    vista.dispose();
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
}
