package com.luxgym.models;

public class Matricula {

    private Integer id;
    private Usuario usuario;
    private Entrenador entrenador;

    public Matricula(Integer id, Usuario usuario, Entrenador entrenador) {
        this.id = id;
        this.usuario = usuario;
        this.entrenador = entrenador;
    }

    public Matricula(Usuario usuario, Entrenador entrenador) {
        this.usuario = usuario;
        this.entrenador = entrenador;
    }

    public Matricula() {
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

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Datos de la Matricula");
        sb.append("\nID: ").append(this.id).append("\n");
        sb.append("\nID del Cliente: ").append(this.usuario.getId());
        sb.append("\nNombre del Cliente: ")
                .append(this.usuario.getNombre()).append(" ")
                .append(this.usuario.getApellido()).append("\n");
        sb.append("\nID del Entrenador: ").append(this.entrenador.getId());
        sb.append("\nNombre del Entrenador: ")
                .append(this.entrenador.getUsuario().getNombre()).append(" ")
                .append(this.entrenador.getUsuario().getApellido());
        return sb.toString();
    }
}
