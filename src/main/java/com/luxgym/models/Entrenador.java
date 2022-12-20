package com.luxgym.models;

public class Entrenador {
    private Integer id;
    private Usuario usuario;
    private Horario horario;
    private Especialidad especialidad;

    public Entrenador(Integer id, Usuario usuario, Horario horario, Especialidad especialidad) {
        this.id = id;
        this.usuario = usuario;
        this.horario = horario;
        this.especialidad = especialidad;
    }

    public Entrenador(Usuario usuario, Horario horario, Especialidad especialidad) {
        this.usuario = usuario;
        this.horario = horario;
        this.especialidad = especialidad;
    }

    public Entrenador() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Datos del Entrenador\n");
        sb.append("\nID: ").append(this.id);
        sb.append("\nNombre: ").append(this.usuario.getNombre());
        sb.append("\nApellido: ").append(this.usuario.getApellido());
        sb.append("\nHorario: ").append(this.horario.getDia().getDescripcion()).append(" a las ").append(this.horario.getHora());
        sb.append("\nEspecialidad: ").append(this.especialidad.getDescripcion());
        return sb.toString();
    }
}
