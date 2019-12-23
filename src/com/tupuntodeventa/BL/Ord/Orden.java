/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tupuntodeventa.BL.Ord;

import com.tupuntodeventa.BL.Prod.Combo;
import com.tupuntodeventa.BL.Prod.Platillo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author krisa
 */
public class Orden {

    private String v_tipo;
    private int v_usuarioId;
    private int v_clienteId;
    private LocalDateTime v_fecha;
    private ArrayList<Combo> v_combos;
    private ArrayList<Platillo> v_prods;
    private double v_total;

    public Orden(String v_tipo, int v_usuarioId, int v_clienteId, LocalDateTime v_fecha, ArrayList<Combo> v_combos, ArrayList<Platillo> v_prods, double v_total) {
        this.v_tipo = v_tipo;
        this.v_usuarioId = v_usuarioId;
        this.v_clienteId = v_clienteId;
        this.v_fecha = v_fecha;
        this.v_combos = v_combos;
        this.v_prods = v_prods;
        this.v_total = v_total;
    }

    public Orden() {
    }
/*
    public double price_calculator() {
        double v_acumulator = 0;
        if (v_prods.size() < 1) {
            for (int i = 0; i < v_combos.size(); i++) {
                v_acumulator += v_combos.get(i).getV_precio();
            }

        } else {

            for (int i = 0; i < v_prods.size(); i++) {
                v_acumulator += v_prods.get(i).getV_precio();
            }

        }
        return v_acumulator;
    }

 */

    public String getV_tipo() {
        return v_tipo;
    }

    public void setV_tipo(String v_tipo) {
        this.v_tipo = v_tipo;
    }

    public int getV_usuarioId() {
        return v_usuarioId;
    }

    public void setV_usuarioId(int v_usuarioId) {
        this.v_usuarioId = v_usuarioId;
    }

    public int getV_clienteId() {
        return v_clienteId;
    }

    public void setV_clienteId(int v_clienteId) {
        this.v_clienteId = v_clienteId;
    }

    public LocalDateTime getV_fecha() {
        return v_fecha;
    }

    public void setV_fecha(LocalDateTime v_fecha) {
        this.v_fecha = v_fecha;
    }

    public ArrayList<Combo> getV_combos() {
        return v_combos;
    }

    public void setV_combos(ArrayList<Combo> v_combos) {
        this.v_combos = v_combos;
    }

    public ArrayList<Platillo> getV_prods() {
        return v_prods;
    }

    public void setV_prods(ArrayList<Platillo> v_prods) {
        this.v_prods = v_prods;
    }

    public double getV_total() {
        return v_total;
    }

    public void setV_total(double v_total) {
        this.v_total = v_total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orden orden = (Orden) o;
        return v_usuarioId == orden.v_usuarioId &&
                v_clienteId == orden.v_clienteId &&
                Double.compare(orden.v_total, v_total) == 0 &&
                Objects.equals(v_tipo, orden.v_tipo) &&
                Objects.equals(v_fecha, orden.v_fecha) &&
                Objects.equals(v_combos, orden.v_combos) &&
                Objects.equals(v_prods, orden.v_prods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v_tipo, v_usuarioId, v_clienteId, v_fecha, v_combos, v_prods, v_total);
    }

    @Override
    public String toString() {
        return "Orden{" +
                "v_tipo='" + v_tipo + '\'' +
                ", v_usuarioId=" + v_usuarioId +
                ", v_clienteId=" + v_clienteId +
                ", v_fecha=" + v_fecha +
                ", v_combos=" + v_combos +
                ", v_prods=" + v_prods +
                ", v_total=" + v_total +
                '}';
    }

}
