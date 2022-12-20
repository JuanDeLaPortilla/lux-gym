package com.luxgym.dao;

import com.luxgym.models.Nivel;
import com.luxgym.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NivelDAO implements DAO<Nivel> {

    private final DatabaseConnection con = new DatabaseConnection();
    private final Connection cn = con.getConnection();

    @Override
    public List<Nivel> findAll() throws SQLException, ClassNotFoundException {
        List<Nivel> niveles = new ArrayList<>();
        try ( Statement stmt = cn.createStatement();  ResultSet rs = stmt.executeQuery("SELECT * from niveles_usuario")) {
            while (rs.next()) {
                Nivel nivel = getNivel(rs);
                niveles.add(nivel);
            }
        }
        return niveles;
    }

    @Override
    public Nivel findById(int id) throws SQLException, ClassNotFoundException {
        Nivel nivel = new Nivel();
        try ( PreparedStatement stmt = cn.prepareStatement("SELECT * from niveles_usuario where nivel_id=?")) {
            stmt.setInt(1, id);
            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    nivel = getNivel(rs);
                }
            }
        }
        return nivel;
    }

    @Override
    public Nivel findByName(String name) throws SQLException, ClassNotFoundException {
        Nivel nivel = new Nivel();
        try ( PreparedStatement stmt = cn.prepareStatement("SELECT * from niveles_usuario where nivel_descripcion=?")) {
            stmt.setString(1, name);
            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    nivel = getNivel(rs);
                }
            }
        }
        return nivel;
    }

    @Override
    public void add(Nivel nivel) throws SQLException, ClassNotFoundException {
        String sql;
        if (nivel.getId() != null && nivel.getId() > 0) {
            sql = "update niveles_usuario set nivel_descripcion=? where nivel_id=?";
        } else {
            sql = "insert into niveles_usuario (nivel_descripcion) values (?)";
        }

        try ( PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, nivel.getDescripcion());
            if (nivel.getId() != null && nivel.getId() > 0) {
                pst.setInt(2, nivel.getId());
            }
            pst.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException, ClassNotFoundException {
        try ( PreparedStatement stmt = cn.prepareStatement("delete from niveles_usuario where nivel_id=?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private Nivel getNivel(ResultSet rs) throws SQLException {
        Nivel n = new Nivel();
        n.setId(rs.getInt("nivel_id"));
        n.setDescripcion(rs.getString("nivel_descripcion"));
        return n;
    }
}
