package com.luxgym.controllers;

import com.luxgym.dao.NivelDAO;
import com.luxgym.dao.UsuarioDAO;
import com.luxgym.models.Nivel;
import com.luxgym.models.Usuario;
import com.luxgym.util.DatabaseConnection;
import com.luxgym.views.AdminPanel;
import com.luxgym.views.UsuariosVista;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UsuariosControlador implements MouseListener {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private NivelDAO nivelDAO = new NivelDAO();
    private UsuariosVista vista = new UsuariosVista();
    private DefaultTableModel modeloTabla = new DefaultTableModel();
    private DefaultComboBoxModel modeloJComboBox = new DefaultComboBoxModel();

    public UsuariosControlador(UsuariosVista vista) throws SQLException, ClassNotFoundException {
        this.vista = vista;
        this.vista.agregarBtnTxt.addMouseListener(this);
        this.vista.buscarBtnTxt.addMouseListener(this);
        this.vista.deleteBtnTxt.addMouseListener(this);
        this.vista.updateBtnTxt.addMouseListener(this);
        this.vista.exitTxt.addMouseListener(this);
        listar(vista.tableUsuario);
        listarNiveles(vista.jComboBox1);
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
            if ("".equals(vista.txtNombre.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Nombre", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if ("".equals(vista.txtApellido.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Apellido", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if ("".equals(vista.txtCorreo.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Correo", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if ("".equals(vista.txtPass.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese una Contraseña", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (vista.jComboBox1.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Porfavor Selecciones un Nivel", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Se rescatan los datos
            String nombre = vista.txtNombre.getText();
            String apellido = vista.txtApellido.getText();
            String correo = vista.txtCorreo.getText();
            String contrasena = vista.txtPass.getText();

            //Se busca el id del nivel en la bd
            Nivel nivel = nivelDAO.findByName(String.valueOf(vista.jComboBox1.getSelectedItem()));

            //Se crea el Modelo
            Usuario usuario = new Usuario(nivel, nombre, apellido, correo, contrasena);

            //Se envian los datos a la base de datos con el DAO
            usuarioDAO.add(usuario);

            //Mensaje de Exito
            JOptionPane.showMessageDialog(null, "Usuario Registrado con Éxito ", "REGISTRO EXITOSO", JOptionPane.INFORMATION_MESSAGE);

            //Se limpian los campos y actualiza la tabla
            accionPorDefecto();
        } catch (SQLException | ClassNotFoundException e) {
            DatabaseConnection.throwErrorMessage(e);
        }
    }

    private void actualizar() {
        try {
            //Comprobacion de Campos
            if ("".equals(vista.txtIdUsuario.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Id", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if ("".equals(vista.txtNombre.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Nombre", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if ("".equals(vista.txtApellido.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Apellido", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if ("".equals(vista.txtCorreo.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Correo", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if ("".equals(vista.txtPass.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese una Contraseña", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (vista.jComboBox1.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Porfavor Selecciones un Día", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Se rescatan los datos
            Integer id = Integer.parseInt(vista.txtIdUsuario.getText());
            String nombre = vista.txtNombre.getText();
            String apellido = vista.txtApellido.getText();
            String correo = vista.txtCorreo.getText();
            String contrasena = vista.txtPass.getText();

            //Se busca el id del nivel en la bd
            Nivel nivel = nivelDAO.findByName(String.valueOf(vista.jComboBox1.getSelectedItem()));

            //Se crea el Modelo
            Usuario usuario = new Usuario(id,nivel, nombre, apellido, correo, contrasena);

            //Se envian los datos a la base de datos con el DAO
            usuarioDAO.add(usuario);

            //Mensaje de Exito
            JOptionPane.showMessageDialog(null, "Usuario Actualizado con Éxito ", "ACTUALIZACIÓN EXITOSA", JOptionPane.INFORMATION_MESSAGE);

            //Se limpian los campos y actualiza la tabla
            accionPorDefecto();
        } catch (SQLException | ClassNotFoundException e) {
            DatabaseConnection.throwErrorMessage(e);
        }
    }

    private void buscar() {
        try {
            //Comprobacion de Campos
            if ("".equals(vista.txtIdUsuario.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Id", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Se rescatan los datos
            Integer id = Integer.parseInt(vista.txtIdUsuario.getText());

            //Se busca el modelo en la base de datos con el DAO
            Usuario usuario = usuarioDAO.findById(id);

            //Se muestran los datos
            JOptionPane.showMessageDialog(null, usuario.toString(), "DATOS DEL USUARIO " + usuario.getId(), JOptionPane.INFORMATION_MESSAGE);

            //Se limpian los campos y actualiza la tabla
            accionPorDefecto();
        } catch (SQLException | ClassNotFoundException e) {
            DatabaseConnection.throwErrorMessage(e);
        }
    }

    private void eliminar() {
        try {
            //Comprobacion de Campos
            if ("".equals(vista.txtIdUsuario.getText())) {
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese un Id", "CAMPO INCOMPLETO", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //Se rescatan los datos
            Integer id = Integer.parseInt(vista.txtIdUsuario.getText());

            //Se elimina el modelo de la base de datos con el DAO
            usuarioDAO.delete(id);

            //Mensaje de Exito
            JOptionPane.showMessageDialog(null, "Usuario Eliminado con Éxito", "ELIMINACIÓN EXITOSA", JOptionPane.INFORMATION_MESSAGE);

            //Se limpian los campos y actualiza la tabla
            accionPorDefecto();
        } catch (SQLException | ClassNotFoundException e) {
            DatabaseConnection.throwErrorMessage(e);
        }
    }

    private void accionPorDefecto() throws SQLException, ClassNotFoundException {
        limpiarCampos();
        limpiarTabla();
        listar(vista.tableUsuario);
    }

    private void listar(JTable tabla) throws SQLException, ClassNotFoundException {
        modeloTabla = (DefaultTableModel) tabla.getModel();
        List<Usuario> lista = usuarioDAO.findAll();
        Object[] object = new Object[6];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId();
            object[1] = lista.get(i).getNombre();
            object[2] = lista.get(i).getApellido();
            object[3] = lista.get(i).getCorreo();
            object[4] = lista.get(i).getContrasena();
            object[5] = lista.get(i).getNivel().getDescripcion();
            modeloTabla.addRow(object);
        }
        vista.tableUsuario.setModel(modeloTabla);
    }

    private void listarNiveles(JComboBox combox) throws SQLException, ClassNotFoundException {
        modeloJComboBox = (DefaultComboBoxModel) combox.getModel();
        List<Nivel> lista = nivelDAO.findAll();
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
        vista.txtIdUsuario.setText("");
        vista.txtNombre.setText("");
        vista.txtApellido.setText("");
        vista.txtCorreo.setText("");
        vista.txtPass.setText("");
        vista.jComboBox1.setSelectedIndex(-1);
    }
}
