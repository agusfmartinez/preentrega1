package com.example.preentrega1.rol;

public class Rol {

    private static int contadorId = 1;

    private int id;
    private String nombre;

    public Rol(String nombre) {
        this.id = contadorId++;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Rol [ID: " + id + " | " + nombre + "]";
    }
}
