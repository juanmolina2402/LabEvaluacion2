package com.example.labevaluacion.model;

public class Encuestados {
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String nombre;
    private int edad;
    private int masculino;
    private int femenino;
    private int otro;

    public String getPlato() {
        return plato;
    }

    public void setPlato(String plato) {
        this.plato = plato;
    }

    private String plato;

    public Encuestados(String nombre, String plato) {
        this.nombre = nombre;
        this.plato = plato;
    }

    @Override
    public String toString() {
        return "Encuestado: " + this.nombre;
    }
}
