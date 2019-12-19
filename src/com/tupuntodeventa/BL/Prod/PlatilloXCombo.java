/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tupuntodeventa.BL.Prod;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author krisa
 */
public class PlatilloXCombo {

    private ArrayList<Platillo> v_productos;
    private double v_precio;
    private String v_nombre;

    public PlatilloXCombo(ArrayList<Platillo> v_productos, String v_descripcion) {
        this.v_productos = v_productos;
        this.v_nombre = v_descripcion;
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

    public ArrayList<Platillo> getV_productos() {
        return v_productos;
    }

    public void setV_productos(ArrayList<Platillo> v_productos) {
        this.v_productos = v_productos;
    }

    public double getV_precio() {
        return v_precio;
    }

    public void setV_precio() {
        this.v_precio = price_calculator();
    }

    public String getV_nombre() {
        return v_nombre;
    }

    public void setV_nombre(String v_nombre) {
        this.v_nombre = v_nombre;
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
        final PlatilloXCombo other = (PlatilloXCombo) obj;
        if (Double.doubleToLongBits(this.v_precio) != Double.doubleToLongBits(other.v_precio)) {
            return false;
        }
        if (!Objects.equals(this.v_nombre, other.v_nombre)) {
            return false;
        }
        if (!Objects.equals(this.v_productos, other.v_productos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Combo{" + " productos = " + v_productos + ", precio = " + v_precio + ", descripcion = " + v_nombre + '}';
    }

}
