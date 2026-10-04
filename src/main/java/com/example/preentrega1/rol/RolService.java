package com.example.preentrega1.rol;
import com.example.preentrega1.exception.RolNoEncontrado;
import com.example.preentrega1.util.Validador;
import java.util.ArrayList;
import java.util.List;

public class RolService {

    private List<Rol> roles = new ArrayList<>();

    public Rol guardar(Rol rol) {
        Validador.validarNombre(rol.getNombre());
        roles.add(rol);
        return rol;
    }

    public List<Rol> listarTodos() {
        return roles;
    }

    public Rol obtenerPorId(int id) {
        return roles.stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RolNoEncontrado(id));
    }
}
