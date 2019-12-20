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
    private String v_nombrec;
    private LocalDateTime v_fecha;
    private ArrayList<Combo> v_combos;
    private ArrayList<Platillo> v_prods;
    private double v_total;

    public Orden(String v_tipo, String v_nombrec, LocalDateTime v_fecha, ArrayList<Combo> v_combos, ArrayList<Platillo> v_prods, double v_total) {
        this.v_tipo = v_tipo;
        this.v_nombrec = v_nombrec;
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

    public String getV_nombrec() {
        return v_nombrec;
    }

    public void setV_nombrec(String v_nombrec) {
        this.v_nombrec = v_nombrec;
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
        final Orden other = (Orden) obj;
        if (Double.doubleToLongBits(this.v_total) != Double.doubleToLongBits(other.v_total)) {
            return false;
        }
        if (!Objects.equals(this.v_tipo, other.v_tipo)) {
            return false;
        }
        if (!Objects.equals(this.v_nombrec, other.v_nombrec)) {
            return false;
        }
        if (!Objects.equals(this.v_fecha, other.v_fecha)) {
            return false;
        }
        if (!Objects.equals(this.v_combos, other.v_combos)) {
            return false;
        }
        if (!Objects.equals(this.v_prods, other.v_prods)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Orden{" + "v_tipo=" + v_tipo + ", v_nombrec=" + v_nombrec + ", v_fecha=" + v_fecha + ", v_combos=" + v_combos + ", v_prods=" + v_prods + ", v_total=" + v_total + '}';
    }

}
