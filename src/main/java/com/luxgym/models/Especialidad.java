package com.luxgym.models;

public class Especialidad {
    private Integer id;
    private String descripcion;

    public Especialidad() {
    }

    public Especialidad(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Especialidad(String descripcion) {
        this.descripcion = descripcion;
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
        sb.append("Datos de la Especialidad\n ");
        sb.append("\nID: ").append(this.id);
        sb.append("\nDescripción: ").append(this.descripcion);
        return sb.toString();
    }
}
