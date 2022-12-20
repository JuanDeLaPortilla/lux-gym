package com.luxgym.dao;

import com.luxgym.models.Dia;
import com.luxgym.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiaDAO implements DAO<Dia> {

    private final DatabaseConnection con = new DatabaseConnection();
    private final Connection cn = con.getConnection();

    @Override
    public List<Dia> findAll() throws SQLException, ClassNotFoundException {
        List<Dia> dias = new ArrayList<>();
        try ( Statement stmt = cn.createStatement();  ResultSet rs = stmt.executeQuery("SELECT * from dias_horario")) {
            while (rs.next()) {
                Dia dia = getDia(rs);
                dias.add(dia);
            }
        }
        return dias;
    }

    @Override
    public Dia findById(int id) throws SQLException, ClassNotFoundException {
        Dia dia = new Dia();
        try ( PreparedStatement stmt = cn.prepareStatement("SELECT * from dias_horario where dia_id=?")) {
            stmt.setInt(1, id);
            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    dia = getDia(rs);
                }
            }
        }
        return dia;
    }

    @Override
    public Dia findByName(String name) throws SQLException, ClassNotFoundException {
        Dia dia = new Dia();
        try ( PreparedStatement stmt = cn.prepareStatement("SELECT * from dias_horario where dia_descripcion=?")) {
            stmt.setString(1, name);
            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    dia = getDia(rs);
                }
            }
        }
        return dia;
    }

    @Override
    public void add(Dia dia) throws SQLException, ClassNotFoundException {
        String sql;
        if (dia.getId() != null && dia.getId() > 0) {
            sql = "update dias_horario set dia_descripcion=? where dia_id=?";
        } else {
            sql = "insert into dias_horario (dia_descripcion) values (?)";
        }

        try ( PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, dia.getDescripcion());
            if (dia.getId() != null && dia.getId() > 0) {
                pst.setInt(2, dia.getId());
            }
            pst.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException, ClassNotFoundException {
        try ( PreparedStatement stmt = cn.prepareStatement("delete from dias_horario where dia_id=?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private Dia getDia(ResultSet rs) throws SQLException {
        Dia d = new Dia();
        d.setId(rs.getInt("dia_id"));
        d.setDescripcion(rs.getString("dia_descripcion"));
        return d;
    }
}
