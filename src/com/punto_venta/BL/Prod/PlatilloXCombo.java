/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punto_venta.BL.Producto;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author krisa
 */
public class Combo {

    private ArrayList<Producto> v_productos;
    private double v_precio;
    private String v_descripcion;

    public Combo(ArrayList<Producto> v_productos, String v_descripcion) {
        this.v_productos = v_productos;
        this.v_descripcion = v_descripcion;
    }

    public double price_calculator() {
        double v_acumulator = 0;
        for (int i = 0; i < v_productos.size(); i++) {
            v_acumulator += v_productos.get(i).getV_precio();
        }
        double v_disc = 0.15;//como no dice que cantidad de descuento ni que regla de negocio sigue para registrar los combos cree un desc del 15%
        double v_temp=v_acumulator * v_disc;
        double v_prec = v_acumulator - v_temp;
        return v_prec;
    }

    public ArrayList<Producto> getV_productos() {
        return v_productos;
    }

    public void setV_productos(ArrayList<Producto> v_productos) {
        this.v_productos = v_productos;
    }

    public double getV_precio() {
        return v_precio;
    }

    public void setV_precio() {
        this.v_precio = price_calculator();
    }

    public String getV_descripcion() {
        return v_descripcion;
    }

    public void setV_descripcion(String v_descripcion) {
        this.v_descripcion = v_descripcion;
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
        final Combo other = (Combo) obj;
        if (Double.doubleToLongBits(this.v_precio) != Double.doubleToLongBits(other.v_precio)) {
            return false;
        }
        if (!Objects.equals(this.v_descripcion, other.v_descripcion)) {
            return false;
        }
        if (!Objects.equals(this.v_productos, other.v_productos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Combo{" + " productos = " + v_productos + ", precio = " + v_precio + ", descripcion = " + v_descripcion + '}';
    }

}
