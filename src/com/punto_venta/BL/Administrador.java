/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punto_venta.BL;

import java.time.LocalDate;

/**
 *
 * @author krisa
 */
public class Administrador extends Usuario   {

public Administrador(String v_key_type, int v_ID, String v_correo, String v_pass, String v_usuario, String[] v_nombre, LocalDate v_fechanac, String genero, int v_telefono) {
        super(v_key_type, v_ID, v_correo, v_pass, v_usuario, v_nombre, v_fechanac, genero, v_telefono);
    }

    
}
