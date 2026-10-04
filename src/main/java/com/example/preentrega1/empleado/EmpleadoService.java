package com.example.preentrega1.empleado;
import com.example.preentrega1.exception.EmpleadoNoEncontrado;
import com.example.preentrega1.rol.Rol;
import com.example.preentrega1.util.Validador;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoService {

    private List<Empleado> empleados = new ArrayList<>();

    // CREATE
    public Empleado guardar(Empleado e) {
        Validador.validarLegajo(e.getLegajo());
        Validador.validarNombre(e.getNombre());
        Validador.validarApellido(e.getApellido());
        Validador.validarCuil(e.getCuil());

        if (existeLegajo(e.getLegajo())) {
            throw new IllegalArgumentException("Ya existe un empleado con legajo " + e.getLegajo() + ".");
        }

        empleados.add(e);
        return e;
    }

    // READ
    public List<Empleado> listarTodos() {
        return empleados;
    }

    public Empleado obtenerPorLegajo(int legajo) {
        return empleados.stream()
                .filter(e -> e.getLegajo() == legajo)
                .findFirst()
                .orElseThrow(() -> new EmpleadoNoEncontrado(legajo));
    }

    // UPDATE: el legajo no se modifica, solo nombre, apellido y CUIL
    public Empleado actualizar(int legajo, Empleado datos) {
        Empleado e = obtenerPorLegajo(legajo);

        Validador.validarNombre(datos.getNombre());
        Validador.validarApellido(datos.getApellido());
        Validador.validarCuil(datos.getCuil());

        e.setNombre(datos.getNombre());
        e.setApellido(datos.getApellido());
        e.setCuil(datos.getCuil());

        return e;
    }

    public Empleado asignarRol(int legajo, Rol rol) {
        Empleado e = obtenerPorLegajo(legajo);
        e.setRol(rol);
        return e;
    }

    // DELETE
    public void eliminar(int legajo) {
        Empleado e = obtenerPorLegajo(legajo);
        empleados.remove(e);
    }

    private boolean existeLegajo(int legajo) {
        return empleados.stream().anyMatch(e -> e.getLegajo() == legajo);
    }
}
