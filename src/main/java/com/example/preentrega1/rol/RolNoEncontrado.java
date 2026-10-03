package com.example.preentrega1.rol;

public class RolNoEncontrado extends RuntimeException {

    public RolNoEncontrado(int id) {
        super("No se encontró ningún rol con ID: " + id);
    }
}
