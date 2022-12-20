package com.luxgym.dao;

import com.luxgym.models.Dia;
import com.luxgym.models.Horario;
import com.luxgym.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HorarioDAO implements DAO<Horario> {

    private final DatabaseConnection con = new DatabaseConnection();
    private final Connection cn = con.getConnection();

    @Override
    public List<Horario> findAll() throws SQLException, ClassNotFoundException {
        List<Horario> horarios = new ArrayList<>();
        try ( Statement stmt = cn.createStatement();  ResultSet rs = stmt.executeQuery("SELECT h.*,dh.dia_descripcion from horarios h inner join dias_horario dh on h.dia_id = dh.dia_id")) {
            while (rs.next()) {
                Horario horario = getHorario(rs);
                horarios.add(horario);
            }
        }
        return horarios;
    }

    @Override
    public Horario findById(int id) throws SQLException, ClassNotFoundException {
        Horario horario = new Horario();
        try ( PreparedStatement stmt = cn.prepareStatement("SELECT h.*,dh.dia_descripcion from horarios h inner join dias_horario dh on h.dia_id = dh.dia_id where horario_id=?")) {
            stmt.setInt(1, id);
            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    horario = getHorario(rs);
                }
            }
        }
        return horario;
    }

    @Override
    public Horario findByName(String name) throws SQLException, ClassNotFoundException {
        Horario horario = new Horario();
        return horario;
    }

    @Override
    public void add(Horario horario) throws SQLException, ClassNotFoundException {
        String sql;
        if (horario.getId() != null && horario.getId() > 0) {
            sql = "update horarios set dia_id=?,horario_hora=? where horario_id=?";
        } else {
            sql = "insert into horarios (dia_id, horario_hora) values (?,?)";
        }

        try ( PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, horario.getDia().getId());
            pst.setTime(2, Time.valueOf(horario.getHora()));
            if (horario.getId() != null && horario.getId() > 0) {
                pst.setInt(3, horario.getId());
            }
            pst.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException, ClassNotFoundException {
        try ( PreparedStatement stmt = cn.prepareStatement("delete from horarios where horario_id=?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private Horario getHorario(ResultSet rs) throws SQLException {
        Horario h = new Horario();
        Dia d = new Dia();
        h.setId(rs.getInt("horario_id"));
        d.setId(rs.getInt("dia_id"));
        h.setHora(rs.getTime("horario_hora").toLocalTime());
        d.setDescripcion(rs.getString("dia_descripcion"));
        h.setDia(d);
        return h;
    }
}
