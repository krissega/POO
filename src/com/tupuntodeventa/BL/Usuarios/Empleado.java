/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tupuntodeventa.BL.Usuarios;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author krisa
 */
public class Empleado extends Usuario {
    private String v_puesto;
    private int v_salbase;
    private double v_bonus;
    private int  v_netsal;
    private LocalDate v_inicia;

    public Empleado() {
     
    }
    public Empleado(String v_puesto, int v_salbase, double v_bonus, int v_netsal, LocalDate v_inicia, int v_rol,
                    int v_ID, String v_correo, String v_pass, String v_usuario, String v_nombre, String v_apellido, String v_segundo_apellido,
                    LocalDate v_fechanac, String genero, String v_telefono, String identificacion) {
        super(v_rol, v_ID, v_correo, v_pass, v_usuario, v_nombre, v_apellido, v_segundo_apellido, v_fechanac, genero, v_telefono, identificacion);
        this.v_puesto = v_puesto;
        this.v_salbase = v_salbase;
        this.v_bonus = v_bonus;
        this.v_netsal = v_netsal;
        this.v_inicia = v_inicia;
    }

    public String   getV_puesto() {
        return v_puesto;
    }

    public void setV_puesto(String v_puesto) {
        this.v_puesto = v_puesto;
    }

    public int getV_salbase() {
        return v_salbase;
    }

    public void setV_salbase(int v_salbase) {
        this.v_salbase = v_salbase;
    }

    public double getV_bonus() {
        return v_bonus;
    }

    public void setV_bonus(double v_bonus) {
        this.v_bonus = v_bonus;
    }

    public int getV_netsal() {
        return v_netsal;
    }

    public void setV_netsal(int v_netsal) {
        this.v_netsal = v_netsal;
    }

    public LocalDate getV_inicia() {
        return v_inicia;
    }

    public void setV_inicia(LocalDate v_inicia) {
        this.v_inicia = v_inicia;
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
        final Empleado other = (Empleado) obj;
        if (this.v_salbase != other.v_salbase) {
            return false;
        }
        if (Double.doubleToLongBits(this.v_bonus) != Double.doubleToLongBits(other.v_bonus)) {
            return false;
        }
        if (this.v_netsal != other.v_netsal) {
            return false;
        }
        if (!Objects.equals(this.v_puesto, other.v_puesto)) {
            return false;
        }
        if (!Objects.equals(this.v_inicia, other.v_inicia)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString()+ "Empleado{" + " puesto = " + v_puesto + ", salario base  = " + v_salbase + ", bonificacion = " + v_bonus + ", salario neto = " + v_netsal + ", Fecha de Inicio de contrato = " + v_inicia + '}';
    }
    
    
    
    
    
    
    
}
