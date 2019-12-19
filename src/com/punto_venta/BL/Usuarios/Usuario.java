/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punto_venta.BL.Usuario;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Objects;




/**
 *
 * @author krisa
 */
public class Usuario {
    private String v_key_type;
    private int v_ID;
    private String v_correo;
    private String v_pass;
    private String v_usuario;
    private String [] v_nombre = new String[3]; //como pide los nombres separados de sus apellidos se hace con un arreglo de string para cada uno 
    private LocalDate v_fechanac;
    private int v_edad;
    private String genero;
    private int v_telefono;
    private String identificacion;

    public Usuario() {
    }

    public Usuario(String v_key_type,int v_ID, String v_correo, String v_pass, String v_usuario, String[] v_nombre, LocalDate v_fechanac, String genero, int v_telefono) {
        this.v_key_type = v_key_type;
        this.v_ID = v_ID;
        this.v_correo = v_correo;
        this.v_pass = v_pass;
        this.v_usuario = v_usuario;
        this.v_nombre = v_nombre;
        this.v_fechanac = v_fechanac;
        this.v_edad = age_calculator(v_fechanac);
        this.genero = genero;
        this.v_telefono = v_telefono;
    }
    
    
    public static int age_calculator(LocalDate v_fechanac){
    LocalDate v_today= LocalDate.now();                        
    long v_years= ChronoUnit.YEARS.between(v_fechanac,v_today);
    return  Math.toIntExact(v_years);
    }



    public String getV_key_type() {
        return v_key_type;
    }

    public void setV_key_type(String v_key_type) {
        this.v_correo = v_key_type;
    }



    public int getV_ID() {
        return v_ID;
    }

    public void setV_ID(int v_ID) {
        this.v_ID = v_ID;
    }

    public String getV_correo() {
        return v_correo;
    }

    public void setV_correo(String v_correo) {
        this.v_correo = v_correo;
    }

    public String getV_pass() {
        return v_pass;
    }

    public void setV_pass(String v_pass) {
        this.v_pass = v_pass;
    }

    public String getV_usuario() {
        return v_usuario;
    }

    public void setV_usuario(String v_usuario) {
        this.v_usuario = v_usuario;
    }

    public String[] getV_nombre() {
        return v_nombre;
    }

    public void setV_nombre(String[] v_nombre) {
        this.v_nombre = v_nombre;
    }

    public LocalDate getV_fechanac() {
        return v_fechanac;
    }

    public void setV_fechanac(LocalDate v_fechanac) {
        this.v_fechanac = v_fechanac;
    }

    public int getV_edad() {
        return v_edad;
    }

    public void setV_edad(int v_edad) {
        this.v_edad = v_edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getV_telefono() {
        return v_telefono;
    }

    public void setV_telefono(int v_telefono) {
        this.v_telefono = v_telefono;
    }
    
    public String getIdentificacion() {
        return identificacion;
    }
    
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.v_key_type);
        hash = 89 * hash + this.v_ID;
        hash = 89 * hash + Objects.hashCode(this.v_correo);
        hash = 89 * hash + Objects.hashCode(this.v_pass);
        hash = 89 * hash + Objects.hashCode(this.v_usuario);
        hash = 89 * hash + Arrays.deepHashCode(this.v_nombre);
        hash = 89 * hash + Objects.hashCode(this.v_fechanac);
        hash = 89 * hash + this.v_edad;
        hash = 89 * hash + Objects.hashCode(this.genero);
        hash = 89 * hash + this.v_telefono;
        hash = 89 * hash + Objects.hashCode(this.identificacion);
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
        final Usuario other = (Usuario) obj;
        if (this.v_ID != other.v_ID) {
            return false;
        }
        if (this.v_edad != other.v_edad) {
            return false;
        }
        if (this.v_telefono != other.v_telefono) {
            return false;
        }
        if (!Objects.equals(this.v_key_type, other.v_key_type)) {
            return false;
        }
        if (!Objects.equals(this.v_correo, other.v_correo)) {
            return false;
        }
        if (!Objects.equals(this.v_pass, other.v_pass)) {
            return false;
        }
        if (!Objects.equals(this.v_usuario, other.v_usuario)) {
            return false;
        }
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        if (!Objects.equals(this.identificacion, other.identificacion)) {
            return false;
        }
        if (!Arrays.deepEquals(this.v_nombre, other.v_nombre)) {
            return false;
        }
        if (!Objects.equals(this.v_fechanac, other.v_fechanac)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{Tipo de Usuario "+ v_key_type+ "ID =" + v_ID + ", correo =" + v_correo + ", pass =" + v_pass + ", Nombre de usuario=" + v_usuario + ", nombre completo =" + v_nombre + ", fecha de nacimiento =" + v_fechanac + ", edad = " + v_edad + ", genero = " + genero + ", telefono = " + v_telefono + ", identificacion = " + identificacion + '}';
    }
    

   
    
    
    
    
    
    
    
}
