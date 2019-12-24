package com.tupuntodeventa.BL.Prod;

import java.util.ArrayList;
import java.util.Objects;

public class Combo {
    private int id;
    private String nombre;
    private double precio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public double price_calculator(ArrayList<Platillo> v_productos) {
        double v_acumulator = 0;
        for (int i = 0; i < v_productos.size(); i++) {
            v_acumulator += v_productos.get(i).getV_precio();
        }
        double v_disc = 0.15;//como no dice que cantidad de descuento ni que regla de negocio sigue para registrar los combos cree un desc del 15%
        double v_temp=v_acumulator * v_disc;
        double v_prec = v_acumulator - v_temp;
        return v_prec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Combo combo = (Combo) o;
        return id == combo.id &&
                Double.compare(combo.precio, precio) == 0 &&
                Objects.equals(nombre, combo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, precio);
    }

    @Override
    public String toString() {
        return "Combo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
