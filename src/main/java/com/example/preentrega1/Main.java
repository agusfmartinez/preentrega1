package com.example.preentrega1;

import com.example.preentrega1.empleado.Empleado;
import com.example.preentrega1.exception.EmpleadoNoEncontrado;
import com.example.preentrega1.empleado.EmpleadoService;
import com.example.preentrega1.rol.Rol;
import com.example.preentrega1.exception.RolNoEncontrado;
import com.example.preentrega1.rol.RolService;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmpleadoService empleadoService = new EmpleadoService();
        RolService rolService = new RolService();
        int opcion = -1;

        System.out.println("=== Gestión de Empleados ===");

        while (opcion != 0) {

            System.out.println("\nAcciones:");
            System.out.println("1. Agregar rol");
            System.out.println("2. Listar roles");
            System.out.println("3. Agregar empleado");
            System.out.println("4. Listar empleados");
            System.out.println("5. Buscar empleado por legajo");
            System.out.println("6. Asignar rol a empleado");
            System.out.println("7. Actualizar empleado");
            System.out.println("8. Eliminar empleado");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            if (!sc.hasNextInt()) {
                System.out.println("Ingresá un número válido.");
                sc.next();
                continue;
            }

            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {

                System.out.print("Nombre del rol: ");
                String nombre = sc.nextLine();

                try {
                    Rol rol = rolService.guardar(new Rol(nombre));
                    System.out.println("Rol agregado: " + rol);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }

            } else if (opcion == 2) {

                List<Rol> roles = rolService.listarTodos();
                if (roles.isEmpty()) {
                    System.out.println("No hay roles cargados.");
                } else {
                    System.out.println("\n--- Listado de roles ---");
                    roles.forEach(System.out::println);
                }

            } else if (opcion == 3) {

                System.out.print("Legajo: ");
                if (!sc.hasNextInt()) {
                    System.out.println("El legajo debe ser un número entero.");
                    sc.next();
                    continue;
                }
                int legajo = sc.nextInt();
                sc.nextLine();

                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Apellido: ");
                String apellido = sc.nextLine();
                System.out.print("CUIL (11 dígitos): ");
                String cuil = sc.nextLine();

                try {
                    Empleado e = empleadoService.guardar(new Empleado(legajo, nombre, apellido, cuil));
                    System.out.println("Empleado agregado: " + e);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }

            } else if (opcion == 4) {

                List<Empleado> empleados = empleadoService.listarTodos();
                if (empleados.isEmpty()) {
                    System.out.println("No hay empleados cargados.");
                } else {
                    System.out.println("\n--- Listado de empleados ---");
                    empleados.forEach(System.out::println);
                }

            } else if (opcion == 5) {

                System.out.print("Legajo a buscar: ");
                if (!sc.hasNextInt()) {
                    System.out.println("Ingresá un legajo válido.");
                    sc.next();
                    continue;
                }
                int legajo = sc.nextInt();
                sc.nextLine();

                try {
                    Empleado e = empleadoService.obtenerPorLegajo(legajo);
                    System.out.println("Encontrado: " + e);
                } catch (EmpleadoNoEncontrado ex) {
                    System.out.println(ex.getMessage());
                }

            } else if (opcion == 6) {

                System.out.print("Legajo del empleado: ");
                if (!sc.hasNextInt()) {
                    System.out.println("Ingresá un legajo válido.");
                    sc.next();
                    continue;
                }
                int legajo = sc.nextInt();

                System.out.print("ID del rol: ");
                if (!sc.hasNextInt()) {
                    System.out.println("Ingresá un ID válido.");
                    sc.next();
                    continue;
                }
                int idRol = sc.nextInt();
                sc.nextLine();

                try {
                    Rol rol = rolService.obtenerPorId(idRol);
                    Empleado e = empleadoService.asignarRol(legajo, rol);
                    System.out.println("Rol " + rol.getNombre() + " asignado a " + e.getNombreCompleto());
                } catch (RolNoEncontrado | EmpleadoNoEncontrado ex) {
                    System.out.println(ex.getMessage());
                }

            } else if (opcion == 7) {

                System.out.print("Legajo a actualizar: ");
                if (!sc.hasNextInt()) {
                    System.out.println("Ingresá un legajo válido.");
                    sc.next();
                    continue;
                }
                int legajo = sc.nextInt();
                sc.nextLine();

                // Constructor vacío + setters: armamos el objeto con los datos nuevos
                Empleado datos = new Empleado();

                System.out.print("Nuevo nombre: ");
                datos.setNombre(sc.nextLine());
                System.out.print("Nuevo apellido: ");
                datos.setApellido(sc.nextLine());
                System.out.print("Nuevo CUIL (11 dígitos): ");
                datos.setCuil(sc.nextLine());

                try {
                    Empleado e = empleadoService.actualizar(legajo, datos);
                    System.out.println("Empleado actualizado: " + e);
                } catch (EmpleadoNoEncontrado | IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }

            } else if (opcion == 8) {

                System.out.print("Legajo a eliminar: ");
                if (!sc.hasNextInt()) {
                    System.out.println("Ingresá un legajo válido.");
                    sc.next();
                    continue;
                }
                int legajo = sc.nextInt();
                sc.nextLine();

                try {
                    empleadoService.eliminar(legajo);
                    System.out.println("Empleado con legajo " + legajo + " eliminado.");
                } catch (EmpleadoNoEncontrado ex) {
                    System.out.println(ex.getMessage());
                }

            } else if (opcion != 0) {
                System.out.println("Opción no válida. Elegí entre 0 y 8.");
            }
        }

        System.out.println("Cerrando...");
        sc.close();
    }
}
