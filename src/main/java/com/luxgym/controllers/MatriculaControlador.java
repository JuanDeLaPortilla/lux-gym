package com.luxgym.controllers;

import com.luxgym.dao.EntrenadorDAO;
import com.luxgym.dao.MatriculaDAO;
import com.luxgym.dao.UsuarioDAO;
import com.luxgym.models.Entrenador;
import com.luxgym.models.Matricula;
import com.luxgym.models.Usuario;
import com.luxgym.util.DatabaseConnection;
import com.luxgym.views.AdminPanel;
import com.luxgym.views.MatriculaVista;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MatriculaControlador implements MouseListener {

    private MatriculaVista vista = new MatriculaVista();
    private DefaultTableModel modeloTabla = new DefaultTableModel();
    private DefaultComboBoxModel modeloJComboUsuario = new DefaultComboBoxModel();
    private DefaultComboBoxModel modeloJComboEntrenador = new DefaultComboBoxModel();

    //DAO
    private EntrenadorDAO entrenadorDAO = new EntrenadorDAO();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private MatriculaDAO matriculaDAO = new MatriculaDAO();

    public MatriculaControlador(MatriculaVista vista) throws SQLException, ClassNotFoundException {
        this.vista = vista;
        this.vista.agregarBtnTxt.addMouseListener(this);
        this.vista.buscarBtnTxt.addMouseListener(this);
        this.vista.deleteBtnTxt.addMouseListener(this);
        this.vista.updateBtnTxt.addMouseListener(this);
        this.vista.exitTxt.addMouseListener(this);
        listar(vista.tableEntrenadorUsuario);
        listarUsuarios(vista.jComboBoxUser);
        listarEntrenadores(vista.jComboBoxEntrenador);

        vista.jComboBoxUser.setSelectedIndex(-1);
        vista.jComboBoxEntrenador.setSelectedIndex(-1);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.agregarBtnTxt) {
            agregar();
        }
        if (e.getSource() == vista.buscarBtnTxt) {
            buscar();
        }
        if (e.getSource() == vista.updateBtnTxt) {
            actualizar();
        }
        if (e.getSource() == vista.deleteBtnTxt) {
            eliminar();
        }
        if (e.getSource() == vista.exitTxt) {
            try {
                AdminPanel adminPanel = new AdminPanel();
                AdminControlador adminControlador = new AdminControlador(adminPanel);
                adminPanel.setVisible(true);
                vista.dispose();
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
            if (vista.jComboBoxEntrenador.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Porfavor Seleccione un Entrenador", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (vista.jComboBoxUser.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Porfavor Seleccione un Usuario", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Se rescatan los datos
            //Se busca el id del usuario en la bd
            Usuario usuario = usuarioDAO.findByName(String.valueOf(vista.jComboBoxUser.getSelectedItem()));

            //Se busca el id del entrenador en la bd
            Entrenador entrenador = entrenadorDAO.findByName(String.valueOf(vista.jComboBoxEntrenador.getSelectedItem()));

            //Se crea el Modelo
            Matricula matricula = new Matricula(usuario, entrenador);

            //Se envian los datos a la base de datos con el DAO
            matriculaDAO.add(matricula);

            //Mensaje de Exito
            JOptionPane.showMessageDialog(null, "Matricula Registrada con Éxito ", "REGISTRO EXITOSO", JOptionPane.INFORMATION_MESSAGE);

            //Se limpian los campos y actualiza la tabla
            accionPorDefecto();
        } catch (SQLException | ClassNotFoundException e) {
            DatabaseConnection.throwErrorMessage(e);
        }
    }

    private void actualizar() {
        try {
            //Comprobacion de Campos
            if ("".equals(vista.txtIdMatricula.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Id", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (vista.jComboBoxEntrenador.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Porfavor Seleccione un Entrenador", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (vista.jComboBoxUser.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Porfavor Seleccione un Usuario", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Se rescatan los datos
            //Se busca el id del usuario en la bd
            Usuario usuario = usuarioDAO.findByName(String.valueOf(vista.jComboBoxUser.getSelectedItem()));

            //Se busca el id del entrenador en la bd
            Entrenador entrenador = entrenadorDAO.findByName(String.valueOf(vista.jComboBoxEntrenador.getSelectedItem()));

            //Se crea el Modelo
            Matricula matricula = new Matricula(usuario, entrenador);

            //Se envian los datos a la base de datos con el DAO
            matriculaDAO.add(matricula);
            //Mensaje de Exito
            JOptionPane.showMessageDialog(null, "Matricula Actualizada con Éxito ", "ACTUALIZACIÓN EXITOSA", JOptionPane.INFORMATION_MESSAGE);

            //Se limpian los campos y actualiza la tabla
            accionPorDefecto();
        } catch (SQLException | ClassNotFoundException e) {
            DatabaseConnection.throwErrorMessage(e);
        }
    }

    private void buscar() {
        try {
            //Comprobacion de Campos
            if ("".equals(vista.txtIdMatricula.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Id", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Se rescatan los datos
            Integer id = Integer.parseInt(vista.txtIdMatricula.getText());

            //Se busca el modeloTabla en la base de datos con el DAO
            Matricula matricula = matriculaDAO.findById(id);

            //Se muestran los datos
            JOptionPane.showMessageDialog(null, matricula.toString(), "DATOS DE LA MATRICULA " + matricula.getId(), JOptionPane.INFORMATION_MESSAGE);

            //Se limpian los campos y actualiza la tabla
            accionPorDefecto();
        } catch (SQLException | ClassNotFoundException e) {
            DatabaseConnection.throwErrorMessage(e);
        }
    }

    private void eliminar() {
        try {
            //Comprobacion de Campos
            if ("".equals(vista.txtIdMatricula.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Id", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Se rescatan los datos
            Integer id = Integer.parseInt(vista.txtIdMatricula.getText());

            //Se elimina el modeloTabla de la base de datos con el DAO
            matriculaDAO.delete(id);

            //Mensaje de Exito
            JOptionPane.showMessageDialog(null, "Matricula Eliminada con Éxito", "ELIMINACIÓN EXITOSA", JOptionPane.INFORMATION_MESSAGE);

            //Se limpian los campos y actualiza la tabla
            accionPorDefecto();
        } catch (SQLException | ClassNotFoundException e) {
            DatabaseConnection.throwErrorMessage(e);
        }
    }

    private void accionPorDefecto() throws SQLException, ClassNotFoundException {
        limpiarCampos();
        limpiarTabla();
        listar(vista.tableEntrenadorUsuario);
    }

    private void listar(JTable tabla) throws SQLException, ClassNotFoundException {
        modeloTabla = (DefaultTableModel) tabla.getModel();
        List<Matricula> lista = matriculaDAO.findAll();
        Object[] object = new Object[7];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId();
            object[1] = lista.get(i).getEntrenador().getId();
            object[2] = lista.get(i).getEntrenador().getUsuario().getNombre();
            object[3] = lista.get(i).getEntrenador().getUsuario().getApellido();
            object[4] = lista.get(i).getUsuario().getId();
            object[5] = lista.get(i).getUsuario().getNombre();
            object[6] = lista.get(i).getUsuario().getApellido();
            modeloTabla.addRow(object);
        }
        vista.tableEntrenadorUsuario.setModel(modeloTabla);
    }

    private void listarUsuarios(JComboBox combox) throws SQLException, ClassNotFoundException {
        modeloJComboUsuario = (DefaultComboBoxModel) combox.getModel();
        List<Usuario> lista = usuarioDAO.findAll();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNivel().getId() != 2) {
                modeloJComboUsuario.addElement(lista.get(i).getApellido());
            }
        }
        vista.jComboBoxUser.setModel(modeloJComboUsuario);
    }

    private void listarEntrenadores(JComboBox combox) throws SQLException, ClassNotFoundException {
        modeloJComboEntrenador = (DefaultComboBoxModel) combox.getModel();
        List<Usuario> lista = usuarioDAO.findAll();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNivel().getId() == 2) {
                modeloJComboEntrenador.addElement(lista.get(i).getApellido());
            }
        }
        vista.jComboBoxEntrenador.setModel(modeloJComboEntrenador);
    }

    private void limpiarTabla() {
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            modeloTabla.removeRow(i);
            i--;
        }
    }

    private void limpiarCampos() {
        vista.txtIdMatricula.setText("");
        vista.jComboBoxUser.setSelectedIndex(-1);
        vista.jComboBoxEntrenador.setSelectedIndex(-1);
    }

}
