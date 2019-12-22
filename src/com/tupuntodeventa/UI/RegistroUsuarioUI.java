package com.tupuntodeventa.UI;


import com.tupuntodeventa.BL.Usuarios.Administrador;
import com.tupuntodeventa.BL.Usuarios.UsuarioDAO;

import java.time.LocalDate;
import java.util.Scanner;

public class RegistroUsuarioUI extends UIPadre {

    private Scanner scanner;
    private boolean admin;
    private UsuarioDAO usuarioDAO;

    public RegistroUsuarioUI(Scanner scanner, boolean admin) {
        this.scanner = scanner;
        this.admin = admin;
        this.usuarioDAO = new UsuarioDAO();
    }

    @Override
    public void mostrar() {
        System.out.println("Por favor ingrese una identificacion:");
        String identificacion = scanner.nextLine();
        if (usuarioDAO.verificarIdentificacion(identificacion)) {
            do {
                System.out.println("Ya existe un usuario con esa identificacion. Por favor ingrese otra identificacion.");
                identificacion = scanner.nextLine();
            } while (usuarioDAO.verificarIdentificacion(identificacion));
        }
        continuarRegistro(identificacion, admin);
    }

    private void continuarRegistro(String identificacion, boolean esadmin) {
        // asumir que si no hay rol = 0 es porque vamos con un admin, o sea primera vez
        int rol = 0;
        if (!esadmin) {
            System.out.println("Ingrese el tipo de usuario a crear (Empleado = 1, Cliente = 2");
            rol = scanner.nextInt();
        }

        System.out.println("Ingrese un nombre de usuario:");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Ingrese la clave de usuario:");
        String clave = scanner.nextLine();
        System.out.println("Ingrese el correo de usuario:");
        String correo = scanner.nextLine();
        System.out.println("Ingrese el nombre de pila:");
        String nombrePila = scanner.nextLine();
        System.out.println("Ingrese el apellido:");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese el segundo apellido:");
        String segundoApellido = scanner.nextLine();
        System.out.println("Ingrese la fecha de nacimiento con formato AAAA-MM-DD");
        LocalDate fechaNac = LocalDate.parse(scanner.nextLine());
        System.out.println("Ingrese el genero del usuario (M o F)");
        String genero = scanner.nextLine();
        System.out.println("Ingrese el telefono del usuario:");
        String telefono = scanner.nextLine();

        switch (rol) {
            case 0:
                // admin
                Administrador admin = new Administrador(rol, 0, correo,
                        clave, nombreUsuario, nombrePila, apellido, segundoApellido, fechaNac,
                        genero, telefono);
                admin.setIdentificacion(identificacion);
                usuarioDAO.registrarUsuario(admin);
                break;
            case 1:
                // empleado
                System.out.println(); // TODO: Continuar acá

                break;
            case 2:
                // cliente
                break;
            default:
                System.out.println("Rol invalido.");
        }
    }
}
