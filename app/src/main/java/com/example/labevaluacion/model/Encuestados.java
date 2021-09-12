package com.example.labevaluacion.model;

public class Encuestados {
    private String nombre;
    private int edad;
    private int masculino;
    private int femenino;
    private int otro;

    public Encuestados(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Encuestado: " + this.nombre;
    }
}
