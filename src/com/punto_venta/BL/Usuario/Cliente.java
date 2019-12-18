/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punto_venta.BL.Usuario;

import java.time.LocalDate;
import java.util.Arrays;

/**
 *
 * @author krisa
 */
public class Cliente extends Usuario {
    
    String [] v_direcciones;// como no se cuantas direcciones va a tener le pondre un maximo de 10 

    public Cliente(String[] v_direcciones, String v_key_type, int v_ID, String v_correo, String v_pass, String v_usuario, String[] v_nombre, LocalDate v_fechanac, String genero, int v_telefono) {
        super(v_key_type, v_ID, v_correo, v_pass, v_usuario, v_nombre, v_fechanac, genero, v_telefono);
        this.v_direcciones = v_direcciones;
    }

    public String[] getV_direcciones() {
        return v_direcciones;
    }

    public void setV_direcciones(String[] v_direcciones) {
        this.v_direcciones = v_direcciones;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Arrays.deepEquals(this.v_direcciones, other.v_direcciones)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString()+"Cliente{" + "Direcciones registradas  = " + v_direcciones + '}';
    }
    
    
}
