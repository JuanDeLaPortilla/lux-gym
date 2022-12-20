package com.luxgym.dao;

import com.luxgym.models.Entrenador;
import com.luxgym.models.Matricula;
import com.luxgym.models.Usuario;
import com.luxgym.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO implements DAO<Matricula> {

    private final DatabaseConnection con = new DatabaseConnection();
    private final Connection cn = con.getConnection();

    @Override
    public List<Matricula> findAll() throws SQLException, ClassNotFoundException {
        List<Matricula> matriculas = new ArrayList<>();
        try ( Statement stmt = cn.createStatement();  ResultSet rs = stmt.executeQuery("SELECT m.*,\n" +
                "       u.usuario_nombre,\n" +
                "       u.usuario_apellido,\n" +
                "       ue.usuario_nombre   as entrenador_nombre,\n" +
                "       ue.usuario_apellido as entrenador_apellido\n" +
                "from matricula m\n" +
                "         inner join usuarios u on m.usuario_id = u.usuario_id\n" +
                "         inner join entrenadores e on m.entrenador_id = e.entrenador_id\n" +
                "         inner join usuarios ue on e.usuario_id = ue.usuario_id")) {
            while (rs.next()) {
                Matricula matricula = getMatricula(rs);
                matriculas.add(matricula);
            }
        }
        return matriculas;
    }

    @Override
    public Matricula findById(int id) throws SQLException, ClassNotFoundException {
        Matricula matricula = new Matricula();
        try ( PreparedStatement stmt = cn.prepareStatement("SELECT m.*,\n" +
                "       u.usuario_nombre,\n" +
                "       u.usuario_apellido,\n" +
                "       ue.usuario_nombre   as entrenador_nombre,\n" +
                "       ue.usuario_apellido as entrenador_apellido\n" +
                "from matricula m\n" +
                "         inner join usuarios u on m.usuario_id = u.usuario_id\n" +
                "         inner join entrenadores e on m.entrenador_id = e.entrenador_id\n" +
                "         inner join usuarios ue on e.usuario_id = ue.usuario_id" +
                " where matricula_id=?")) {
            stmt.setInt(1, id);
            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    matricula = getMatricula(rs);
                }
            }
        }
        return matricula;
    }

    @Override
    public Matricula findByName(String name) throws SQLException, ClassNotFoundException {
        Matricula matricula = new Matricula();
        return matricula;
    }

    @Override
    public void add(Matricula matricula) throws SQLException, ClassNotFoundException {
        String sql;
        if (matricula.getId() != null && matricula.getId() > 0) {
            sql = "update matricula set usuario_id=?,entrenador_id=? where matricula_id=?";
        } else {
            sql = "insert into matricula (usuario_id, entrenador_id) values (?,?)";
        }

        try ( PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, matricula.getUsuario().getId());
            pst.setInt(2, matricula.getEntrenador().getId());
            if (matricula.getId() != null && matricula.getId() > 0) {
                pst.setInt(3, matricula.getId());
            }
            pst.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException, ClassNotFoundException {
        try ( PreparedStatement stmt = cn.prepareStatement("delete from matricula where matricula_id=?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private Matricula getMatricula(ResultSet rs) throws SQLException {
        Matricula m = new Matricula();
        Usuario u = new Usuario();
        Usuario ue = new Usuario();
        Entrenador e = new Entrenador();

        m.setId(rs.getInt("matricula_id"));
        u.setId(rs.getInt("usuario_id"));
        e.setId(rs.getInt("entrenador_id"));
        u.setNombre(rs.getString("usuario_nombre"));
        u.setApellido(rs.getString("usuario_apellido"));
        ue.setNombre(rs.getString("entrenador_nombre"));
        ue.setApellido(rs.getString("entrenador_apellido"));
        e.setUsuario(ue);
        m.setUsuario(u);
        m.setEntrenador(e);
        return m;
    }
}
