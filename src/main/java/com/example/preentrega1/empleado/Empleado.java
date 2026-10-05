package com.example.preentrega1.empleado;

import com.example.preentrega1.rol.Rol;

public class Empleado {
    private int legajo;
    private String nombre;
    private String apellido;
    private String cuil;
    private Rol rol;
    private String email;

    public Empleado() {
    }

    public Empleado(int legajo, String nombre, String apellido, String cuil) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuil = cuil;
        generarEmail();
    }

    private void generarEmail() {
        if (nombre == null || nombre.isBlank() || apellido == null || apellido.isBlank()) {
            this.email = null;
            return;
        }
        this.email = (nombre.charAt(0) + apellido + "@mail.com").toLowerCase();
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        generarEmail();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
        generarEmail();
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public String getNombreCompleto() {
        return apellido + ", " + nombre;
    }

    @Override
    public String toString() {
        String nombreRol = (rol == null) ? "Sin rol" : rol.getNombre();
        return "Empleado [Legajo: " + legajo + " | " + getNombreCompleto()
                + " | CUIL: " + cuil + " | " + email + " | Rol: " + nombreRol + "]";
    }
}
