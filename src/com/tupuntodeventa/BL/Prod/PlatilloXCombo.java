/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tupuntodeventa.BL.Prod;

/**
 *
 * @author krisa
 */
public class PlatilloXCombo {

    private int id;
    private int platilloId;
    private int comboId;
    
    public PlatilloXCombo(int id, int platilloId, int comboId) {
        this(platilloId, comboId);
        this.id = id;
    }

    public PlatilloXCombo(int platilloId, int comboId) {
        this.platilloId = platilloId;
        this.comboId = comboId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlatilloId() {
        return platilloId;
    }

    public void setPlatilloId(int platilloId) {
        this.platilloId = platilloId;
    }

    public int getComboId() {
        return comboId;
    }

    public void setComboId(int comboId) {
        this.comboId = comboId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        hash = 71 * hash + this.platilloId;
        hash = 71 * hash + this.comboId;
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
        if (this.id != other.id) {
            return false;
        }
        if (this.platilloId != other.platilloId) {
            return false;
        }
        if (this.comboId != other.comboId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PlatilloXCombo{" + "id=" + id + ", platilloId=" + platilloId + ", comboId=" + comboId + '}';
    }
    
}
