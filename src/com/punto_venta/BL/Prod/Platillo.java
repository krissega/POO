/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punto_venta.BL.Producto;

import java.util.Objects;

/**
 *
 * @author krisa
 */
public class Producto {
    private int v_ID; 
    private String v_nombre;
    private String v_descripcion;
    private double v_precio;

    public Producto(int v_ID, String v_nombre, String v_descripcion, double v_precio) {
        this.v_ID = v_ID;
        this.v_nombre = v_nombre;
        this.v_descripcion = v_descripcion;
        this.v_precio = v_precio;
    }

    public int getV_ID() {
        return v_ID;
    }

    public void setV_ID(int v_ID) {
        this.v_ID = v_ID;
    }

    public String getV_nombre() {
        return v_nombre;
    }

    public void setV_nombre(String v_nombre) {
        this.v_nombre = v_nombre;
    }

    public String getV_descripcion() {
        return v_descripcion;
    }

    public void setV_descripcion(String v_descripcion) {
        this.v_descripcion = v_descripcion;
    }

    public double getV_precio() {
        return v_precio;
    }

    public void setV_precio(double v_precio) {
        this.v_precio = v_precio;
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
        final Producto other = (Producto) obj;
        if (this.v_ID != other.v_ID) {
            return false;
        }
        if (Double.doubleToLongBits(this.v_precio) != Double.doubleToLongBits(other.v_precio)) {
            return false;
        }
        if (!Objects.equals(this.v_nombre, other.v_nombre)) {
            return false;
        }
        if (!Objects.equals(this.v_descripcion, other.v_descripcion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + " ID = " + v_ID + ", nombre = " + v_nombre + ", descripcion = " + v_descripcion + ", precio = " + v_precio + '}';
    }
    
    
     
}
