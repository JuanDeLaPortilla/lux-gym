package com.luxgym.dao;

import com.luxgym.models.*;
import com.luxgym.models.Entrenador;
import com.luxgym.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntrenadorDAO implements DAO<Entrenador> {

    private final DatabaseConnection con = new DatabaseConnection();
    private final Connection cn = con.getConnection();

    @Override
    public List<Entrenador> findAll() throws SQLException, ClassNotFoundException {
        List<Entrenador> entrenadores = new ArrayList<>();
        try ( Statement stmt = cn.createStatement();  ResultSet rs = stmt.executeQuery("SELECT en.*,\n"
                + "       u.usuario_nombre,\n"
                + "       u.usuario_apellido,\n"
                + "       h.dia_id,\n"
                + "       horario_hora,\n"
                + "       e.especialidad_descripcion,\n"
                + "       dh.dia_descripcion\n"
                + "from entrenadores en\n"
                + "         inner join especialidades e on en.especialidad_id = e.especialidad_id\n"
                + "         inner join horarios h on en.horario_id = h.horario_id\n"
                + "         inner join usuarios u on en.usuario_id = u.usuario_id\n"
                + "         inner join dias_horario dh on h.dia_id = dh.dia_id")) {
            while (rs.next()) {
                Entrenador entrenador = getEntrenador(rs);
                entrenadores.add(entrenador);
            }
        }
        return entrenadores;
    }

    @Override
    public Entrenador findById(int id) throws SQLException, ClassNotFoundException {
        Entrenador entrenador = null;
        try ( PreparedStatement stmt = cn.prepareStatement("SELECT en.*,\n"
                + "       u.usuario_nombre,\n"
                + "       u.usuario_apellido,\n"
                + "       h.dia_id,\n"
                + "       horario_hora,\n"
                + "       e.especialidad_descripcion,\n"
                + "       dh.dia_descripcion\n"
                + "from entrenadores en\n"
                + "         inner join especialidades e on en.especialidad_id = e.especialidad_id\n"
                + "         inner join horarios h on en.horario_id = h.horario_id\n"
                + "         inner join usuarios u on en.usuario_id = u.usuario_id\n"
                + "         inner join dias_horario dh on h.dia_id = dh.dia_id\n"
                + "where entrenador_id=?")) {
            stmt.setInt(1, id);
            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    entrenador = getEntrenador(rs);
                }
            }
        }
        return entrenador;
    }

    @Override
    public Entrenador findByName(String name) throws SQLException, ClassNotFoundException {
        Entrenador entrenador = null;
        try ( PreparedStatement stmt = cn.prepareStatement("SELECT en.*,\n"
                + "       u.usuario_nombre,\n"
                + "       u.usuario_apellido,\n"
                + "       h.dia_id,\n"
                + "       horario_hora,\n"
                + "       e.especialidad_descripcion,\n"
                + "       dh.dia_descripcion\n"
                + "from entrenadores en\n"
                + "         inner join especialidades e on en.especialidad_id = e.especialidad_id\n"
                + "         inner join horarios h on en.horario_id = h.horario_id\n"
                + "         inner join usuarios u on en.usuario_id = u.usuario_id\n"
                + "         inner join dias_horario dh on h.dia_id = dh.dia_id\n"
                + "where u.usuario_apellido=?")) {
            stmt.setString(1, name);
            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    entrenador = getEntrenador(rs);
                }
            }
        }
        return entrenador;
    }

    @Override
    public void add(Entrenador entrenador) throws SQLException, ClassNotFoundException {
        String sql;
        if (entrenador.getId() != null && entrenador.getId() > 0) {
            sql = "update entrenadores set usuario_id=?,horario_id=?,especialidad_id=? where entrenador_id=?";
        } else {
            sql = "insert into entrenadores (usuario_id, horario_id, especialidad_id) values (?,?,?)";
        }

        try ( PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, entrenador.getUsuario().getId());
            pst.setInt(2, entrenador.getHorario().getId());
            pst.setInt(3, entrenador.getEspecialidad().getId());
            if (entrenador.getId() != null && entrenador.getId() > 0) {
                pst.setInt(4, entrenador.getId());
            }
            pst.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException, ClassNotFoundException {
        try ( PreparedStatement stmt = cn.prepareStatement("delete from entrenadores where entrenador_id=?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private Entrenador getEntrenador(ResultSet rs) throws SQLException {
        Entrenador e = new Entrenador();
        Usuario u = new Usuario();
        Especialidad es = new Especialidad();
        Horario h = new Horario();
        Dia d = new Dia();

        e.setId(rs.getInt("entrenador_id"));
        u.setId(rs.getInt("usuario_id"));
        h.setId(rs.getInt("horario_id"));
        es.setId(rs.getInt("especialidad_id"));
        u.setNombre(rs.getString("usuario_nombre"));
        u.setApellido(rs.getString("usuario_apellido"));
        d.setId(rs.getInt("dia_id"));
        h.setHora(rs.getTime("horario_hora").toLocalTime());
        es.setDescripcion(rs.getString("especialidad_descripcion"));
        d.setDescripcion(rs.getString("dia_descripcion"));
        h.setDia(d);

        e.setEspecialidad(es);
        e.setHorario(h);
        e.setUsuario(u);
        return e;
    }
}
