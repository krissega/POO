package com.punto_venta.BL.Cup;

import java.time.LocalDate;
import java.util.Objects;

public class Cupon{

private LocalDate v_expira;
private int v_id;
private String v_codigo;
private double v_descuento;
private boolean v_usado;

    public Cupon(LocalDate v_expira, int v_id, double v_descuento, boolean v_usado) {
        this.v_expira = v_expira;
        this.v_id = v_id;
        this.v_descuento = v_descuento;
        this.v_usado = v_usado;
    }

    public Cupon(){}
    
    
    
    //AGREGAR CUERPO DE LA CLASE 
    public String randomCode(){
    return "";
     }
    
    
    
    
    public LocalDate getV_expira() {
        return v_expira;
    }

    public void setV_expira(LocalDate v_expira) {
        this.v_expira = v_expira;
    }

    public int getV_id() {
        return v_id;
    }

    public void setV_id(int v_id) {
        this.v_id = v_id;
    }

    public String getV_codigo() {
        return v_codigo;
    }

    public void setV_codigo() {
        this.v_codigo=randomCode();
    }

    
     public void setV_codigoBD(String data) {
        this.v_codigo=data;
    }
    
    
    public double getV_descuento() {
        return v_descuento;
    }

    public void setV_descuento(double v_descuento) {
        this.v_descuento = v_descuento;
    }

    public boolean getV_usado() {
        return v_usado;
    }

    public void setV_usado(boolean v_usado) {
        this.v_usado = v_usado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Cupon other = (Cupon) obj;
        if (this.v_id != other.v_id) {
            return false;
        }
        if (Double.doubleToLongBits(this.v_descuento) != Double.doubleToLongBits(other.v_descuento)) {
            return false;
        }
        if (this.v_usado != other.v_usado) {
            return false;
        }
        if (!Objects.equals(this.v_codigo, other.v_codigo)) {
            return false;
        }
        if (!Objects.equals(this.v_expira, other.v_expira)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cupon{" + "v_expira=" + v_expira + ", v_id=" + v_id + ", v_codigo=" + v_codigo + ", v_descuento=" + v_descuento + ", v_usado=" + v_usado + '}';
    }

  




















}