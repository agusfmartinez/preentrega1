package com.example.preentrega1;
import com.example.preentrega1.empleado.Empleado;
import com.example.preentrega1.empleado.EmpleadoNoEncontrado;
import com.example.preentrega1.empleado.EmpleadoService;
import com.example.preentrega1.rol.Rol;
import com.example.preentrega1.rol.RolNoEncontrado;
import com.example.preentrega1.rol.RolService;
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
            System.out.println("7. Eliminar empleado");
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

                if (nombre.isBlank()) {
                    System.out.println("El nombre no puede estar vacío.");
                    continue;
                }

                rolService.agregar(nombre);

            } else if (opcion == 2) {

                rolService.listar();

            } else if (opcion == 3) {

                System.out.print("Legajo: ");
                if (!sc.hasNextInt()) {
                    System.out.println("El legajo debe ser un número entero.");
                    sc.next();
                    continue;
                }
                int legajo = sc.nextInt();
                sc.nextLine();

                if (legajo <= 0) {
                    System.out.println("El legajo debe ser mayor a cero.");
                    continue;
                }

                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                if (nombre.isBlank()) {
                    System.out.println("El nombre no puede estar vacío.");
                    continue;
                }

                System.out.print("Apellido: ");
                String apellido = sc.nextLine();
                if (apellido.isBlank()) {
                    System.out.println("El apellido no puede estar vacío.");
                    continue;
                }

                System.out.print("CUIL (11 dígitos): ");
                String cuil = sc.nextLine();
                if (!cuil.matches("\\d{11}")) {
                    System.out.println("El CUIL debe tener 11 dígitos numéricos.");
                    continue;
                }

                empleadoService.agregar(legajo, nombre, apellido, cuil);

            } else if (opcion == 4) {

                empleadoService.listar();

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
                    Empleado e = empleadoService.buscarPorLegajo(legajo);
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
                    Rol rol = rolService.buscarPorId(idRol);
                    empleadoService.asignarRol(legajo, rol);
                } catch (RolNoEncontrado | EmpleadoNoEncontrado ex) {
                    System.out.println(ex.getMessage());
                }

            } else if (opcion == 7) {

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
                } catch (EmpleadoNoEncontrado ex) {
                    System.out.println(ex.getMessage());
                }

            } else if (opcion != 0) {
                System.out.println("Opción no válida. Elegí entre 0 y 7.");
            }
        }

        System.out.println("Cerrando...");
        sc.close();
    }
}
