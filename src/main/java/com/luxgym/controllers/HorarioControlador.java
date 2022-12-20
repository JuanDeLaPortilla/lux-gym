package com.luxgym.controllers;

import com.luxgym.dao.DiaDAO;
import com.luxgym.dao.HorarioDAO;
import com.luxgym.models.Dia;
import com.luxgym.models.Horario;
import com.luxgym.util.DatabaseConnection;
import com.luxgym.views.AdminPanel;
import com.luxgym.views.HorarioVista;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HorarioControlador implements MouseListener {

    private HorarioDAO horarioDAO = new HorarioDAO();
    private DiaDAO diaDAO = new DiaDAO();
    private HorarioVista vista = new HorarioVista();
    private DefaultTableModel modeloTabla = new DefaultTableModel();
    private DefaultComboBoxModel modeloJComboBox = new DefaultComboBoxModel();

    public HorarioControlador(HorarioVista vista) throws SQLException, ClassNotFoundException {
        this.vista = vista;
        this.vista.agregarBtnTxt.addMouseListener(this);
        this.vista.buscarBtnTxt.addMouseListener(this);
        this.vista.deleteBtnTxt.addMouseListener(this);
        this.vista.updateBtnTxt.addMouseListener(this);
        this.vista.exitTxt.addMouseListener(this);
        listar(vista.tableHorario);
        listarDias(vista.jComboBox1);
        vista.jComboBox1.setSelectedIndex(-1);
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
            if (vista.jComboBox1.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Porfavor Selecciones un Día", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if ("".equals(vista.txtHora.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese una Hora", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if ("".equals(vista.txtMinutos.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese Minutos", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Se rescatan los datos
            //Se busca el id del dia en la bd
            Dia dia = diaDAO.findByName(String.valueOf(vista.jComboBox1.getSelectedItem()));

            //Se crea la hora a partir del input
            int horaInt = Integer.parseInt(vista.txtHora.getText());
            int minutosInt = Integer.parseInt(vista.txtMinutos.getText());
            LocalTime hora = LocalTime.of(horaInt, minutosInt, 0);

            //Se crea el Modelo
            Horario horario = new Horario(dia, hora);

            //Se envian los datos a la base de datos con el DAO
            horarioDAO.add(horario);

            //Mensaje de Exito
            JOptionPane.showMessageDialog(null, "Horario Registrado con Éxito ", "REGISTRO EXITOSO", JOptionPane.INFORMATION_MESSAGE);

            //Se limpian los campos y actualiza la tabla
            accionPorDefecto();
        } catch (SQLException | ClassNotFoundException e) {
            DatabaseConnection.throwErrorMessage(e);
        }
    }

    private void actualizar() {
        try {
            //Comprobacion de Campos
            if ("".equals(vista.txtIdHorario.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Id", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (vista.jComboBox1.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Porfavor Selecciones un Día", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if ("".equals(vista.txtHora.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese una Hora", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if ("".equals(vista.txtMinutos.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese Minutos", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Se rescatan los datos
            Integer id = Integer.parseInt(vista.txtIdHorario.getText());

            //Se busca el id del dia en la bd
            Dia dia = diaDAO.findByName(String.valueOf(vista.jComboBox1.getSelectedItem()));

            //Se crea la hora a partir del input
            int horaInt = Integer.parseInt(vista.txtHora.getText());
            int minutosInt = Integer.parseInt(vista.txtMinutos.getText());
            LocalTime hora = LocalTime.of(horaInt, minutosInt, 0);

            //Se crea el Modelo
            Horario horario = new Horario(id, dia, hora);

            //Se envian los datos a la base de datos con el DAO
            horarioDAO.add(horario);

            //Mensaje de Exito
            JOptionPane.showMessageDialog(null, "Horario Actualizado con Éxito ", "ACTUALIZACIÓN EXITOSA", JOptionPane.INFORMATION_MESSAGE);

            //Se limpian los campos y actualiza la tabla
            accionPorDefecto();
        } catch (SQLException | ClassNotFoundException e) {
            DatabaseConnection.throwErrorMessage(e);
        }
    }

    private void buscar() {
        try {
            //Comprobacion de Campos
            if ("".equals(vista.txtIdHorario.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Id", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Se rescatan los datos
            Integer id = Integer.parseInt(vista.txtIdHorario.getText());

            //Se busca el modeloTabla en la base de datos con el DAO
            Horario horario = horarioDAO.findById(id);

            //Se muestran los datos
            JOptionPane.showMessageDialog(null, horario.toString(), "DATOS DEL HORARIO " + horario.getId(), JOptionPane.INFORMATION_MESSAGE);

            //Se limpian los campos y actualiza la tabla
            accionPorDefecto();
        } catch (SQLException | ClassNotFoundException e) {
            DatabaseConnection.throwErrorMessage(e);
        }
    }

    private void eliminar() {
        try {
            //Comprobacion de Campos
            if ("".equals(vista.txtIdHorario.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Id", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Se rescatan los datos
            Integer id = Integer.parseInt(vista.txtIdHorario.getText());

            //Se elimina el modeloTabla de la base de datos con el DAO
            horarioDAO.delete(id);

            //Mensaje de Exito
            JOptionPane.showMessageDialog(null, "Horario Eliminado con Éxito", "ELIMINACIÓN EXITOSA", JOptionPane.INFORMATION_MESSAGE);

            //Se limpian los campos y actualiza la tabla
            accionPorDefecto();
        } catch (SQLException | ClassNotFoundException e) {
            DatabaseConnection.throwErrorMessage(e);
        }
    }

    private void accionPorDefecto() throws SQLException, ClassNotFoundException {
        limpiarCampos();
        limpiarTabla();
        listar(vista.tableHorario);
    }

    private void listar(JTable tabla) throws SQLException, ClassNotFoundException {
        modeloTabla = (DefaultTableModel) tabla.getModel();
        List<Horario> lista = horarioDAO.findAll();
        Object[] object = new Object[3];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId();
            object[1] = lista.get(i).getDia().getDescripcion();
            object[2] = lista.get(i).getHora();
            modeloTabla.addRow(object);
        }
        vista.tableHorario.setModel(modeloTabla);
    }

    private void listarDias(JComboBox combox) throws SQLException, ClassNotFoundException {
        modeloJComboBox = (DefaultComboBoxModel) combox.getModel();
        List<Dia> lista = diaDAO.findAll();
        for (int i = 0; i < lista.size(); i++) {
            modeloJComboBox.addElement(lista.get(i).getDescripcion());
        }
        vista.jComboBox1.setModel(modeloJComboBox);
    }

    private void limpiarTabla() {
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            modeloTabla.removeRow(i);
            i--;
        }
    }

    private void limpiarCampos() {
        vista.txtIdHorario.setText("");
        vista.txtHora.setText("");
        vista.txtMinutos.setText("");
        vista.jComboBox1.setSelectedIndex(-1);
    }

}
