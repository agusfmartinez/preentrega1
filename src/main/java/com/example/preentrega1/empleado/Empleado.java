package com.example.preentrega1.empleado;
import com.example.preentrega1.rol.Rol;

public class Empleado {
    private int legajo;
    private String nombre;
    private String apellido;
    private String cuil;
    private Rol rol;
    private String email;

    public Empleado(int legajo, String nombre, String apellido, String cuil) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuil = cuil;

        char c = nombre.charAt(0);

        this.email = (c + apellido + "@mail.com").toLowerCase();
    }

    public int getLegajo() {
        return legajo;
    }

    public String getCuil() {
        return cuil;
    }

    public Rol getRol() {
        return rol;
    }

    public String getEmail() {
        return email;
    }

    public String getNombreCompleto() {
        return apellido + ", " + nombre;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        String nombreRol = (rol == null) ? "Sin rol" : rol.getNombre();
        return "Empleado [Legajo: " + legajo + " | " + getNombreCompleto()
                + " | CUIL: " + cuil + " | " + email + " | Rol: " + nombreRol + "]";
    }
}
