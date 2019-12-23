/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tupuntodeventa.BL.Usuarios;

import java.time.LocalDate;

/**
 * @author krisa
 */
public class Administrador extends Usuario {

    public Administrador(int v_rol, int v_ID, String v_correo, String v_pass, String v_usuario, String v_nombre, String v_apellido, String v_segundo_apellido,
                         LocalDate v_fechanac, String genero, String v_telefono) {
        super(v_rol, v_ID, v_correo, v_pass, v_usuario, v_nombre, v_apellido, v_segundo_apellido, v_fechanac, genero, v_telefono);
    }

    public static boolean verificarAdmin() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.verificarAdmin();
    }
}
