/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punto_venta.BL.Puestos;

import java.util.Objects;

/**
 *
 * @author krisa
 */
public class Puesto {
    
    private String v_ID;
    private String v_puesto;
    private String v_describ;

    public Puesto(String v_ID, String v_puesto, String v_describ) {
        this.v_ID = v_ID;
        this.v_puesto = v_puesto;
        this.v_describ = v_describ;
    }

    public String getV_ID() {
        return v_ID;
    }

    public void setV_ID(String v_ID) {
        this.v_ID = v_ID;
    }

    public String getV_puesto() {
        return v_puesto;
    }

    public void setV_puesto(String v_puesto) {
        this.v_puesto = v_puesto;
    }

    public String getV_describ() {
        return v_describ;
    }

    public void setV_describ(String v_describ) {
        this.v_describ = v_describ;
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
        final Puesto other = (Puesto) obj;
        if (!Objects.equals(this.v_ID, other.v_ID)) {
            return false;
        }
        if (!Objects.equals(this.v_puesto, other.v_puesto)) {
            return false;
        }
        if (!Objects.equals(this.v_describ, other.v_describ)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Puesto{" + "ID = " + v_ID + ", nombre del puesto = " + v_puesto + ", descripcion = " + v_describ + '}';
    }
    
    
    
    
    
}
