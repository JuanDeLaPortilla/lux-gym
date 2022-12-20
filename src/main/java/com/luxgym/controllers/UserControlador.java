package com.luxgym.controllers;

import com.luxgym.dao.*;
import com.luxgym.models.*;
import com.luxgym.util.DatabaseConnection;
import com.luxgym.views.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserControlador implements MouseListener {

    private Usuario usuario = new Usuario();
    private UserPanel vista = new UserPanel(usuario);
    private DefaultTableModel modeloTabla = new DefaultTableModel();
    private DefaultComboBoxModel modeloJComboEntrenador = new DefaultComboBoxModel();

    //DAO
    private EntrenadorDAO entrenadorDAO = new EntrenadorDAO();
    private MatriculaDAO matriculaDAO = new MatriculaDAO();

    public UserControlador(UserPanel vista) throws SQLException, ClassNotFoundException {
        this.vista = vista;
        this.vista.matriculaBtnTxt.addMouseListener(this);
        this.vista.exitTxt.addMouseListener(this);
        listar(vista.tableEntrenador);
        listarEntrenadores(vista.cboEntrenador);
        limpiarCampos();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.matriculaBtnTxt) {
            int input = JOptionPane.showConfirmDialog(null, "Al presionar este botón usted confirma su matricula y entiende que no hay forma de cancelarla", "CONFIRMACIÓN", JOptionPane.YES_NO_OPTION);
            if (input == 0) {
                matricular();
            }
        }
        if (e.getSource() == vista.exitTxt) {
            try {
                int input = JOptionPane.showConfirmDialog(null, "¿Está seguro de que quiere salir?", "SALIR", JOptionPane.YES_NO_OPTION);
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

    private void matricular() {
        try {
            //Comprobacion de Campos
            if (vista.cboEntrenador.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Porfavor Seleccione un Entrenador", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Se busca el id del entrenador en la bd
            Entrenador entrenador = entrenadorDAO.findById(Integer.parseInt(String.valueOf(vista.cboEntrenador.getSelectedItem())));

            //Se crea el Modelo
            Matricula matricula = new Matricula(vista.getUsuario(), entrenador);

            //Se envian los datos a la base de datos con el DAO
            matriculaDAO.add(matricula);

            //Mensaje de Exito
            JOptionPane.showMessageDialog(null, "Su Matricula Registrada con Éxito ", "REGISTRO EXITOSO", JOptionPane.INFORMATION_MESSAGE);

            //Se limpian los campos y actualiza la tabla
            limpiarCampos();
        } catch (SQLException | ClassNotFoundException e) {
            DatabaseConnection.throwErrorMessage(e);
        }
    }

    private void listar(JTable tabla) throws SQLException, ClassNotFoundException {
        modeloTabla = (DefaultTableModel) tabla.getModel();
        List<Entrenador> lista = entrenadorDAO.findAll();
        Object[] object = new Object[6];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId();
            object[1] = lista.get(i).getUsuario().getNombre();
            object[2] = lista.get(i).getUsuario().getApellido();
            object[3] = lista.get(i).getHorario().getDia().getDescripcion();
            object[4] = lista.get(i).getHorario().getHora();
            object[5] = lista.get(i).getEspecialidad().getDescripcion();
            modeloTabla.addRow(object);
        }
        vista.tableEntrenador.setModel(modeloTabla);
    }

    private void listarEntrenadores(JComboBox combox) throws SQLException, ClassNotFoundException {
        modeloJComboEntrenador = (DefaultComboBoxModel) combox.getModel();
        List<Entrenador> lista = entrenadorDAO.findAll();
        for (int i = 0; i < lista.size(); i++) {
            modeloJComboEntrenador.addElement(lista.get(i).getId());
        }
        vista.cboEntrenador.setModel(modeloJComboEntrenador);
    }

    private void limpiarCampos() {
        vista.cboEntrenador.setSelectedIndex(-1);
    }
}
