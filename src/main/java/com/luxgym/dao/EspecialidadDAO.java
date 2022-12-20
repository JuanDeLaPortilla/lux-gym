package com.luxgym.dao;

import com.luxgym.models.Especialidad;
import com.luxgym.models.Especialidad;
import com.luxgym.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadDAO implements DAO<Especialidad> {

    private final DatabaseConnection con = new DatabaseConnection();
    private final Connection cn = con.getConnection();

    @Override
    public List<Especialidad> findAll() throws SQLException, ClassNotFoundException {
        List<Especialidad> especialidades = new ArrayList<>();
        try ( Statement stmt = cn.createStatement();  ResultSet rs = stmt.executeQuery("SELECT * from especialidades")) {
            while (rs.next()) {
                Especialidad especialidad = getEspecialidad(rs);
                especialidades.add(especialidad);
            }
        }
        return especialidades;
    }

    @Override
    public Especialidad findById(int id) throws SQLException, ClassNotFoundException {
        Especialidad especialidad = new Especialidad();
        try ( PreparedStatement stmt = cn.prepareStatement("SELECT * from especialidades where especialidad_id=?")) {
            stmt.setInt(1, id);
            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    especialidad = getEspecialidad(rs);
                }
            }
        }
        return especialidad;
    }

    @Override
    public Especialidad findByName(String name) throws SQLException, ClassNotFoundException {
        Especialidad especialidad = new Especialidad();
        try ( PreparedStatement stmt = cn.prepareStatement("SELECT * from especialidades where especialidad_descripcion=?")) {
            stmt.setString(1, name);
            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    especialidad = getEspecialidad(rs);
                }
            }
        }
        return especialidad;
    }

    @Override
    public void add(Especialidad especialidad) throws SQLException, ClassNotFoundException {
        String sql;
        if (especialidad.getId() != null && especialidad.getId() > 0) {
            sql = "update especialidades set especialidad_descripcion=? where especialidad_id=?";
        } else {
            sql = "insert into especialidades (especialidad_descripcion) values (?)";
        }

        try ( PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, especialidad.getDescripcion());
            if (especialidad.getId() != null && especialidad.getId() > 0) {
                pst.setInt(2, especialidad.getId());
            }
            pst.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException, ClassNotFoundException {
        try ( PreparedStatement stmt = cn.prepareStatement("delete from especialidades where especialidad_id=?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private Especialidad getEspecialidad(ResultSet rs) throws SQLException {
        Especialidad e = new Especialidad();
        e.setId(rs.getInt("especialidad_id"));
        e.setDescripcion(rs.getString("especialidad_descripcion"));
        return e;
    }
}
