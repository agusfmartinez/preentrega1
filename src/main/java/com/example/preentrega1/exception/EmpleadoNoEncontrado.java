package com.example.preentrega1.exception;

public class EmpleadoNoEncontrado extends RuntimeException {

    public EmpleadoNoEncontrado(int legajo) {
        super("No se encontró ningún empleado con legajo: " + legajo);
    }
}
