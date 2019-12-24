/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tupuntodeventa;

import Controllers.UsuarioController.UsuariosController;
import IntermedioUI.UsuariosUI;
import com.tupuntodeventa.BL.Usuarios.Administrador;
import com.tupuntodeventa.BL.Usuarios.Usuario;
import java.io.IOException;

import java.util.Scanner;

/**
 *
 * @author krisa
 */
public class Main {
    public static void main(String[] args) throws IOException {
        UsuariosController log;
        UsuariosUI k =new UsuariosUI();
        iniciarBD();
        // menú
        System.out.println("Bienvenido a la aplicacion de punto de venta.");
        Scanner scanner = new Scanner(System.in);
        if (!Administrador.verificarAdmin()) {
            System.out.println("No hay un usuario administrador. Por favor indique un nuevo usuario administrador.");
           k.registrarAdministrador();
        } 
        System.out.println();
        System.out.println("Ingrese un nombre de usuario:");
        String v_nombreUsuario = scanner.nextLine();
        System.out.println("Ingrese la clave:");
        String v_clave = scanner.nextLine();
        k.iniciarSesion(v_nombreUsuario, v_clave);
        
    }

    private static void iniciarBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
