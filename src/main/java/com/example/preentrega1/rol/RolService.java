package com.example.preentrega1.rol;
import java.util.ArrayList;

public class RolService {

    private ArrayList<Rol> roles = new ArrayList<>();

    public void agregar(String nombre) {
        Rol nuevo = new Rol(nombre);
        roles.add(nuevo);
        System.out.println("Rol agregado: " + nuevo);
    }

    public void listar() {
        if (roles.isEmpty()) {
            System.out.println("No hay roles cargados.");
            return;
        }
        System.out.println("\n--- Listado de roles ---");
        roles.forEach(System.out::println);
    }

    public Rol buscarPorId(int id) {
        return roles.stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RolNoEncontrado(id));
    }
}
