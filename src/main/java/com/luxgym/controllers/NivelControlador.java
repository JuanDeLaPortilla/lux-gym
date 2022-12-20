package com.luxgym.controllers;

import com.luxgym.dao.NivelDAO;
import com.luxgym.models.Nivel;
import com.luxgym.util.DatabaseConnection;
import com.luxgym.views.AdminPanel;
import com.luxgym.views.NivelVista;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NivelControlador implements MouseListener {

    private NivelDAO nivelDAO = new NivelDAO();
    private NivelVista vista = new NivelVista();
    private DefaultTableModel modelo = new DefaultTableModel();

    public NivelControlador(NivelVista vista) throws SQLException, ClassNotFoundException {
        this.vista = vista;
        this.vista.agregarBtnTxt.addMouseListener(this);
        this.vista.buscarBtnTxt.addMouseListener(this);
        this.vista.deleteBtnTxt.addMouseListener(this);
        this.vista.updateBtnTxt.addMouseListener(this);
        this.vista.exitTxt.addMouseListener(this);
        listar(vista.tableNivel);
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
        if(e.getSource() == vista.exitTxt){
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
            if ("".equals(vista.txtDescripcion.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese una Descripción", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Se rescatan los datos
            String descripcion = vista.txtDescripcion.getText();

            //Se crea el Modelo
            Nivel nivel = new Nivel(descripcion);

            //Se envian los datos a la base de datos con el DAO
            nivelDAO.add(nivel);

            //Mensaje de Exito
            JOptionPane.showMessageDialog(null, "Nivel Registrado con Éxito ", "REGISTRO EXITOSO", JOptionPane.INFORMATION_MESSAGE);

            //Se limpian los campos y actualiza la tabla
            accionPorDefecto();
        } catch (SQLException | ClassNotFoundException e) {
            DatabaseConnection.throwErrorMessage(e);
        }
    }

    private void actualizar() {
        try {
            //Comprobacion de Campos
            if ("".equals(vista.txtIdNivel.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Id", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if ("".equals(vista.txtDescripcion.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese una Descripción", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Se rescatan los datos
            Integer id = Integer.parseInt(vista.txtIdNivel.getText());
            String descripcion = vista.txtDescripcion.getText();

            //Se crea el Modelo
            Nivel nivel = new Nivel(id,descripcion);

            //Se envian los datos a la base de datos con el DAO
            nivelDAO.add(nivel);

            //Mensaje de Exito
            JOptionPane.showMessageDialog(null, "Nivel Actualizado con Éxito ", "ACTUALIZACIÓN EXITOSA", JOptionPane.INFORMATION_MESSAGE);

            //Se limpian los campos y actualiza la tabla
            accionPorDefecto();
        } catch (SQLException | ClassNotFoundException e) {
            DatabaseConnection.throwErrorMessage(e);
        }
    }

    private void buscar() {
        try {
            //Comprobacion de Campos
            if ("".equals(vista.txtIdNivel.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Id", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Se rescatan los datos
            Integer id = Integer.parseInt(vista.txtIdNivel.getText());

            //Se busca el modelo en la base de datos con el DAO
            Nivel nivel = nivelDAO.findById(id);

            //Se muestran los datos
            JOptionPane.showMessageDialog(null, nivel.toString(), "DATOS DEL NIVEL " + nivel.getId(), JOptionPane.INFORMATION_MESSAGE);

            //Se limpian los campos y actualiza la tabla
            accionPorDefecto();
        } catch (SQLException | ClassNotFoundException e) {
            DatabaseConnection.throwErrorMessage(e);
        }
    }

    private void eliminar() {
        try {
            //Comprobacion de Campos
            if ("".equals(vista.txtIdNivel.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Id", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Se rescatan los datos
            Integer id = Integer.parseInt(vista.txtIdNivel.getText());

            //Se elimina el modelo de la base de datos con el DAO
            nivelDAO.delete(id);

            //Mensaje de Exito
            JOptionPane.showMessageDialog(null, "Nivel Eliminado con Éxito", "ELIMINACIÓN EXITOSA", JOptionPane.INFORMATION_MESSAGE);

            //Se limpian los campos y actualiza la tabla
            accionPorDefecto();
        } catch (SQLException | ClassNotFoundException e) {
            DatabaseConnection.throwErrorMessage(e);
        }
    }

    private void accionPorDefecto() throws SQLException, ClassNotFoundException {
        limpiarCampos();
        limpiarTabla();
        listar(vista.tableNivel);
    }

    private void listar(JTable tabla) throws SQLException, ClassNotFoundException {
        modelo = (DefaultTableModel) tabla.getModel();
        List<Nivel> lista = nivelDAO.findAll();
        Object[] object = new Object[2];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId();
            object[1] = lista.get(i).getDescripcion();
            modelo.addRow(object);
        }
        vista.tableNivel.setModel(modelo);
    }

    private void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i--;
        }
    }

    private void limpiarCampos() {
        vista.txtIdNivel.setText("");
        vista.txtDescripcion.setText("");
    }
}
