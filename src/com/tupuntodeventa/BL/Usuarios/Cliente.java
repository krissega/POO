/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tupuntodeventa.BL.Usuarios;

import com.tupuntodeventa.BL.Direccion.Direccion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author krisa
 */
public class Cliente extends Usuario {
    
    private ArrayList<Direccion> v_direcciones;// como no se cuantas direcciones va a tener le pondre un maximo de 10

    public Cliente(ArrayList<Direccion> v_direcciones, int v_rol, int v_ID, String v_correo, String v_pass, String v_usuario,
                   String v_nombre, String v_apellido, String v_segundo_apellido, LocalDate v_fechanac, String genero, String v_telefono, String identificacion) {
        super(v_rol, v_ID, v_correo, v_pass, v_usuario, v_nombre, v_apellido, v_segundo_apellido, v_fechanac, genero, v_telefono, identificacion);
        this.v_direcciones = v_direcciones;
    }

    public ArrayList<Direccion> getV_direcciones() {
        return v_direcciones;
    }

    public void setV_direcciones(ArrayList<Direccion> v_direcciones) {
        this.v_direcciones = v_direcciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(v_direcciones, cliente.v_direcciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), v_direcciones);
    }

    @Override
    public String toString() {
        return super.toString()+"Cliente{" + "Direcciones registradas  = " + v_direcciones + '}';
    }
    
    
}
