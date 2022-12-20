package com.luxgym.models;

import java.time.LocalTime;

public class Horario {
    private Integer id;
    private Dia dia;
    private LocalTime hora;

    public Horario(Integer id, Dia dia, LocalTime hora) {
        this.id = id;
        this.dia = dia;
        this.hora = hora;
    }

    public Horario(Dia dia, LocalTime hora) {
        this.dia = dia;
        this.hora = hora;
    }

    public Horario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Datos del Horario");
        sb.append("\nID: ").append(this.id);
        sb.append("\nDia: ").append(this.dia.getDescripcion());
        sb.append("\nHora: ").append(this.hora);
        return sb.toString();
    }
}
