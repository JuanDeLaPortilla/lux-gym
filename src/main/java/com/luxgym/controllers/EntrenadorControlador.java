package com.luxgym.controllers;

import com.luxgym.dao.EntrenadorDAO;
import com.luxgym.dao.EspecialidadDAO;
import com.luxgym.dao.HorarioDAO;
import com.luxgym.dao.UsuarioDAO;
import com.luxgym.models.Entrenador;
import com.luxgym.models.Especialidad;
import com.luxgym.models.Horario;
import com.luxgym.models.Usuario;
import com.luxgym.util.DatabaseConnection;
import com.luxgym.views.AdminPanel;
import com.luxgym.views.EntrenadorVista;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EntrenadorControlador implements MouseListener {

    private EntrenadorVista vista = new EntrenadorVista();
    private DefaultTableModel modeloTabla = new DefaultTableModel();
    private DefaultComboBoxModel modeloJComboUsuario = new DefaultComboBoxModel();
    private DefaultComboBoxModel modeloJComboHorario = new DefaultComboBoxModel();
    private DefaultComboBoxModel modeloJComboEspecialidad = new DefaultComboBoxModel();

    //DAO
    private EntrenadorDAO entrenadorDAO = new EntrenadorDAO();
    private HorarioDAO horarioDAO = new HorarioDAO();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private EspecialidadDAO especialidadDAO = new EspecialidadDAO();

    public EntrenadorControlador(EntrenadorVista vista) throws SQLException, ClassNotFoundException {
        this.vista = vista;
        this.vista.agregarBtnTxt.addMouseListener(this);
        this.vista.buscarBtnTxt.addMouseListener(this);
        this.vista.deleteBtnTxt.addMouseListener(this);
        this.vista.updateBtnTxt.addMouseListener(this);
        this.vista.exitTxt.addMouseListener(this);
        listar(vista.tableEntrenador);
        listarUsuarios(vista.jComboBoxUser);
        listarHorarios(vista.jComboBoxHorario);
        listarEspecialidades(vista.jComboBoxEspecialidad);

        vista.jComboBoxUser.setSelectedIndex(-1);
        vista.jComboBoxHorario.setSelectedIndex(-1);
        vista.jComboBoxEspecialidad.setSelectedIndex(-1);
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
            if (vista.jComboBoxUser.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Porfavor Seleccione un Usuario", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (vista.jComboBoxEspecialidad.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Porfavor Seleccione una Especialidad", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (vista.jComboBoxHorario.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Porfavor Seleccione un Horario", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Se rescatan los datos
            //Se busca el id del usuario en la bd
            Usuario usuario = usuarioDAO.findByName(String.valueOf(vista.jComboBoxUser.getSelectedItem()));

            //Se busca el id de la especialidad en la bd
            Especialidad especialidad = especialidadDAO.findByName(String.valueOf(vista.jComboBoxEspecialidad.getSelectedItem()));

            //Se busca el horario en la bd con el id
            Horario horario = horarioDAO.findById(Integer.parseInt(String.valueOf(vista.jComboBoxHorario.getSelectedItem())));

            //Se crea el Modelo
            Entrenador entrenador = new Entrenador(usuario, horario, especialidad);

            //Se envian los datos a la base de datos con el DAO
            entrenadorDAO.add(entrenador);

            //Mensaje de Exito
            JOptionPane.showMessageDialog(null, "Entrenador Registrado con Éxito ", "REGISTRO EXITOSO", JOptionPane.INFORMATION_MESSAGE);

            //Se limpian los campos y actualiza la tabla
            accionPorDefecto();
        } catch (SQLException | ClassNotFoundException e) {
            DatabaseConnection.throwErrorMessage(e);
        }
    }

    private void actualizar() {
        try {
            //Comprobacion de Campos
            if ("".equals(vista.txtIdEntrenador.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Id", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (vista.jComboBoxUser.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Porfavor Seleccione un Usuario", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (vista.jComboBoxEspecialidad.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Porfavor Seleccione una Especialidad", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (vista.jComboBoxHorario.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Porfavor Seleccione un Horario", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Se rescatan los datos
            Integer id = Integer.parseInt(vista.txtIdEntrenador.getText());

            //Se busca el id del usuario en la bd
            Usuario usuario = usuarioDAO.findByName(String.valueOf(vista.jComboBoxUser.getSelectedItem()));

            //Se busca el id de la especialidad en la bd
            Especialidad especialidad = especialidadDAO.findByName(String.valueOf(vista.jComboBoxEspecialidad.getSelectedItem()));

            //Se busca el horario en la bd con el id
            Horario horario = horarioDAO.findById(Integer.parseInt(String.valueOf(vista.jComboBoxHorario.getSelectedItem())));

            //Se crea el Modelo
            Entrenador entrenador = new Entrenador(id, usuario, horario, especialidad);

            //Se envian los datos a la base de datos con el DAO
            entrenadorDAO.add(entrenador);

            //Se envian los datos a la base de datos con el DAO
            entrenadorDAO.add(entrenador);

            //Mensaje de Exito
            JOptionPane.showMessageDialog(null, "Entrenador Actualizado con Éxito ", "ACTUALIZACIÓN EXITOSA", JOptionPane.INFORMATION_MESSAGE);

            //Se limpian los campos y actualiza la tabla
            accionPorDefecto();
        } catch (SQLException | ClassNotFoundException e) {
            DatabaseConnection.throwErrorMessage(e);
        }
    }

    private void buscar() {
        try {
            //Comprobacion de Campos
            if ("".equals(vista.txtIdEntrenador.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Id", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Se rescatan los datos
            Integer id = Integer.parseInt(vista.txtIdEntrenador.getText());

            //Se busca el modeloTabla en la base de datos con el DAO
            Entrenador entrenador = entrenadorDAO.findById(id);

            //Se muestran los datos
            JOptionPane.showMessageDialog(null, entrenador.toString(), "DATOS DEL ENTRENADOR " + entrenador.getId(), JOptionPane.INFORMATION_MESSAGE);

            //Se limpian los campos y actualiza la tabla
            accionPorDefecto();
        } catch (SQLException | ClassNotFoundException e) {
            DatabaseConnection.throwErrorMessage(e);
        }
    }

    private void eliminar() {
        try {
            //Comprobacion de Campos
            if ("".equals(vista.txtIdEntrenador.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Id", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Se rescatan los datos
            Integer id = Integer.parseInt(vista.txtIdEntrenador.getText());

            //Se elimina el modeloTabla de la base de datos con el DAO
            entrenadorDAO.delete(id);

            //Mensaje de Exito
            JOptionPane.showMessageDialog(null, "Entrenador Eliminado con Éxito", "ELIMINACIÓN EXITOSA", JOptionPane.INFORMATION_MESSAGE);

            //Se limpian los campos y actualiza la tabla
            accionPorDefecto();
        } catch (SQLException | ClassNotFoundException e) {
            DatabaseConnection.throwErrorMessage(e);
        }
    }

    private void accionPorDefecto() throws SQLException, ClassNotFoundException {
        limpiarCampos();
        limpiarTabla();
        listar(vista.tableEntrenador);
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

    private void listarUsuarios(JComboBox combox) throws SQLException, ClassNotFoundException {
        modeloJComboUsuario = (DefaultComboBoxModel) combox.getModel();
        List<Usuario> lista = usuarioDAO.findAll();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNivel().getId() == 2) {
                modeloJComboUsuario.addElement(lista.get(i).getApellido());
            }
        }
        vista.jComboBoxUser.setModel(modeloJComboUsuario);
    }

    private void listarHorarios(JComboBox combox) throws SQLException, ClassNotFoundException {
        modeloJComboHorario = (DefaultComboBoxModel) combox.getModel();
        List<Horario> lista = horarioDAO.findAll();
        for (int i = 0; i < lista.size(); i++) {
            modeloJComboHorario.addElement(lista.get(i).getId());
        }
        vista.jComboBoxHorario.setModel(modeloJComboHorario);
    }

    private void listarEspecialidades(JComboBox combox) throws SQLException, ClassNotFoundException {
        modeloJComboEspecialidad = (DefaultComboBoxModel) combox.getModel();
        List<Especialidad> lista = especialidadDAO.findAll();
        for (int i = 0; i < lista.size(); i++) {
            modeloJComboEspecialidad.addElement(lista.get(i).getDescripcion());
        }
        vista.jComboBoxEspecialidad.setModel(modeloJComboEspecialidad);
    }

    private void limpiarTabla() {
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            modeloTabla.removeRow(i);
            i--;
        }
    }

    private void limpiarCampos() {
        vista.txtIdEntrenador.setText("");
        vista.jComboBoxUser.setSelectedIndex(-1);
        vista.jComboBoxHorario.setSelectedIndex(-1);
        vista.jComboBoxEspecialidad.setSelectedIndex(-1);
    }

}
