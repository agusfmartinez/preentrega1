package com.example.preentrega1.empleado;

public class EmpleadoNoEncontrado extends RuntimeException {

    public EmpleadoNoEncontrado(int legajo) {
        super("No se encontró ningún empleado con legajo: " + legajo);
    }
}
