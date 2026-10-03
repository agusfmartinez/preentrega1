package com.example.preentrega1.empleado;
import com.example.preentrega1.rol.Rol;
import java.util.ArrayList;

public class EmpleadoService {

    private ArrayList<Empleado> empleados = new ArrayList<>();

    public void agregar(int legajo, String nombre, String apellido, String cuil) {
        if (existeLegajo(legajo)) {
            System.out.println("Ya existe un empleado con legajo " + legajo + ".");
            return;
        }
        Empleado nuevo = new Empleado(legajo, nombre, apellido, cuil);
        empleados.add(nuevo);
        System.out.println("Empleado agregado: " + nuevo);
    }

    public void listar() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados cargados.");
            return;
        }
        System.out.println("\n--- Listado de empleados ---");
        empleados.forEach(System.out::println);
    }

    public Empleado buscarPorLegajo(int legajo) {
        return empleados.stream()
                .filter(e -> e.getLegajo() == legajo)
                .findFirst()
                .orElseThrow(() -> new EmpleadoNoEncontrado(legajo));
    }

    public void asignarRol(int legajo, Rol rol) {
        Empleado e = buscarPorLegajo(legajo);
        e.setRol(rol);
        System.out.println("Rol " + rol.getNombre() + " asignado a " + e.getNombreCompleto());
    }

    public void eliminar(int legajo) {
        Empleado e = buscarPorLegajo(legajo);
        empleados.remove(e);
        System.out.println("Empleado eliminado: " + e.getNombreCompleto());
    }

    private boolean existeLegajo(int legajo) {
        return empleados.stream().anyMatch(e -> e.getLegajo() == legajo);
    }
}
