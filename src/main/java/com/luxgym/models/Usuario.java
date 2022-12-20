package com.luxgym.models;

public class Usuario {
    private Integer id;
    private Nivel nivel;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;

    public Usuario(Integer id, Nivel nivel, String nombre, String apellido, String correo, String contrasena) {
        this.id = id;
        this.nivel = nivel;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Usuario(Nivel nivel, String nombre, String apellido, String correo, String contrasena) {
        this.nivel = nivel;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Datos del ").append(this.nivel.getDescripcion()).append("\n");
        sb.append("\nID: ").append(this.id);
        sb.append("\nNombre: ").append(this.nombre);
        sb.append("\nApellido: ").append(this.apellido);
        sb.append("\nCorreo: ").append(this.correo);
        sb.append("\nContraseña: ").append(this.contrasena);
        return sb.toString();
    }
}
