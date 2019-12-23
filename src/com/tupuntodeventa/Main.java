/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tupuntodeventa;

import com.tupuntodeventa.BL.Usuarios.Administrador;
import com.tupuntodeventa.BL.Usuarios.Usuario;
import com.tupuntodeventa.UI.RegistroUsuarioUI;

import java.util.Scanner;

/**
 *
 * @author krisa
 */
public class Main {
    public static void main(String[] args) {
        iniciarBD();
        // menú
        System.out.println("Bienvenido a la aplicacion de punto de venta.");
        Scanner scanner = new Scanner(System.in);
        if (!Administrador.verificarAdmin()) {
            System.out.println("No hay un usuario administrador. Por favor indique un nuevo usuario administrador.");
            RegistroUsuarioUI registroUsuarioUI = new RegistroUsuarioUI(scanner, true);
            registroUsuarioUI.mostrar();
        }

        System.out.println();
        System.out.println("Ingrese un nombre de usuario:");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Ingrese la clave:");
        String clave = scanner.nextLine();
        Usuario usuario = Usuario.autenticar(nombreUsuario, clave);
        if (usuario == null) {
            do {
                System.out.println("Nombre de usuario o clave incorrecta");
                System.out.println("Ingrese un nombre de usuario:");
                nombreUsuario = scanner.nextLine();
                System.out.println("Ingrese la clave:");
                clave = scanner.nextLine();
                usuario = Usuario.autenticar(nombreUsuario, clave);
            } while (usuario == null);
        }

        // el usuario obtenido tendra un rol
        // menú por permisos
        int opcion = 0;
        int rol = usuario.getV_rol();

        switch (rol) {
            case 0:
                // menú administrador
                while (opcion != 7) {
                    System.out.println("Ingrese una opcion de menú (1-7):");
                    System.out.println("1. Registrar empleado");
                    System.out.println("2. Registrar cliente");
                    System.out.println("3. Listar usuarios");
                    System.out.println("4. Registrar producto/combo");
                    System.out.println("5. Listar productos");
                    System.out.println("6. Generar cupones");
                    System.out.println("7. Salir");
                    opcion = scanner.nextInt();

                    switch (opcion) {
                        case 1:

                        break;
                        case 7:
                            System.out.println("Hasta luego!");
                        break;
                        default:
                            System.out.println("Opción inválida.");
                    }
                }
            break;
            case 1:
            break;
        }
    }

    private static void iniciarBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
