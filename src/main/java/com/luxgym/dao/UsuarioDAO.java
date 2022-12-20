package com.luxgym.dao;

import com.luxgym.models.Nivel;
import com.luxgym.models.Usuario;
import com.luxgym.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements DAO<Usuario> {

    private final DatabaseConnection con = new DatabaseConnection();
    private final Connection cn = con.getConnection();

    @Override
    public List<Usuario> findAll() throws SQLException, ClassNotFoundException {
        List<Usuario> usuarios = new ArrayList<>();
        try ( Statement stmt = cn.createStatement();  ResultSet rs = stmt.executeQuery("SELECT u.*, nu.nivel_descripcion from usuarios u inner join niveles_usuario nu on u.nivel_id = nu.nivel_id")) {
            while (rs.next()) {
                Usuario usuario = getUsuario(rs);
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    @Override
    public Usuario findById(int id) throws SQLException, ClassNotFoundException {
        Usuario usuario = null;
        try ( PreparedStatement stmt = cn.prepareStatement("SELECT u.*, nu.nivel_descripcion from usuarios u inner join niveles_usuario nu on u.nivel_id = nu.nivel_id where u.usuario_id=?")) {
            stmt.setInt(1, id);
            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    usuario = getUsuario(rs);
                }
            }
        }
        return usuario;
    }

    @Override
    public Usuario findByName(String name) throws SQLException, ClassNotFoundException {
        Usuario usuario = null;
        try ( PreparedStatement stmt = cn.prepareStatement("SELECT u.*, nu.nivel_descripcion from usuarios u inner join niveles_usuario nu on u.nivel_id = nu.nivel_id where u.usuario_apellido=?")) {
            stmt.setString(1, name);
            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    usuario = getUsuario(rs);
                }
            }
        }
        return usuario;
    }

    @Override
    public void add(Usuario usuario) throws SQLException, ClassNotFoundException {
        String sql;
        if (usuario.getId() != null && usuario.getId() > 0) {
            sql = "update usuarios set nivel_id=?, usuario_nombre=?, usuario_apellido=?, usuario_correo=?, usuario_contrasena=? where usuario_id=?";
        } else {
            sql = "insert into usuarios (nivel_id, usuario_nombre, usuario_apellido, usuario_correo, usuario_contrasena) values (?,?,?,?,?)";
        }

        try ( PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, usuario.getNivel().getId());
            pst.setString(2, usuario.getNombre());
            pst.setString(3, usuario.getApellido());
            pst.setString(4, usuario.getCorreo());
            pst.setString(5, usuario.getContrasena());
            if (usuario.getId() != null && usuario.getId() > 0) {
                pst.setInt(6, usuario.getId());
            }
            pst.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException, ClassNotFoundException {
        try ( PreparedStatement stmt = cn.prepareStatement("delete from usuarios where usuario_id=?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public Usuario login(String correo, String contrasena) throws SQLException, ClassNotFoundException {
        Usuario usuario = null;
        PreparedStatement pst;
        ResultSet rs = null;

        try {
            String vsql = "select u.*, nu.nivel_descripcion from usuarios u inner join niveles_usuario nu on u.nivel_id = nu.nivel_id where usuario_correo=? and usuario_contrasena=?";
            pst = cn.prepareStatement(vsql);
            pst.setString(1, correo);
            pst.setString(2, contrasena);
            rs = pst.executeQuery();
            if (rs.next()) {
                usuario = getUsuario(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    private Usuario getUsuario(ResultSet rs) throws SQLException {
        Usuario u = new Usuario();
        Nivel n = new Nivel();

        u.setId(rs.getInt("usuario_id"));
        n.setId(rs.getInt("nivel_id"));
        u.setNombre(rs.getString("usuario_nombre"));
        u.setApellido(rs.getString("usuario_apellido"));
        u.setCorreo(rs.getString("usuario_correo"));
        u.setContrasena(rs.getString("usuario_contrasena"));
        n.setDescripcion(rs.getString("nivel_descripcion"));

        u.setNivel(n);
        return u;
    }
}
