/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tupuntodeventa.BL.Direccion;

import java.util.Objects;

public class Direccion {

    private int id;
    private String direccionExacta;
    private String canton;
    private String distrito;
    private String provincia;
    private int distancia;
    private int usuarioId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccionExacta() {
        return direccionExacta;
    }

    public void setDireccionExacta(String direccionExacta) {
        this.direccionExacta = direccionExacta;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direccion direccion = (Direccion) o;
        return id == direccion.id &&
                distancia == direccion.distancia &&
                usuarioId == direccion.usuarioId &&
                Objects.equals(direccionExacta, direccion.direccionExacta) &&
                Objects.equals(canton, direccion.canton) &&
                Objects.equals(distrito, direccion.distrito) &&
                Objects.equals(provincia, direccion.provincia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, direccionExacta, canton, distrito, provincia, distancia, usuarioId);
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", direccionExacta='" + direccionExacta + '\'' +
                ", canton='" + canton + '\'' +
                ", distrito='" + distrito + '\'' +
                ", provincia='" + provincia + '\'' +
                ", distancia=" + distancia +
                ", usuarioId=" + usuarioId +
                '}';
    }
}
