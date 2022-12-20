package com.luxgym.models;

public class Nivel {
    private Integer id;
    private String descripcion;

    public Nivel(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Nivel(String descripcion) {
        this.descripcion = descripcion;
    }

    public Nivel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Datos del Nivel");
        sb.append("\nID: ").append(this.id);
        sb.append("\nDescripción: ").append(this.descripcion);
        return sb.toString();
    }
}
