/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tupuntodeventa;

import com.tupuntodeventa.BL.Usuarios.Administrador;
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
    }

    private static void iniciarBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
