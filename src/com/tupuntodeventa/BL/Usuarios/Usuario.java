/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tupuntodeventa.BL.Usuarios;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;


/**
 * @author krisa
 */
public class Usuario {
    private int v_rol;
    private int v_ID;
    private String v_correo;
    private String v_pass;
    private String v_usuario;
    private String v_nombre_pila;
    private String v_apellido;
    private String v_segundo_apellido;
    private LocalDate v_fechanac;
    private int v_edad;
    private String genero;
    private String v_telefono;
    private String identificacion;

    public Usuario() {
    }

    public Usuario(int v_rol, int v_ID, String v_correo, String v_pass, String v_usuario, String v_nombre_pila, String v_apellido, String v_segundo_apellido,
                   LocalDate v_fechanac, String genero, String v_telefono) {
        this.v_rol = v_rol;
        this.v_ID = v_ID;
        this.v_correo = v_correo;
        this.v_pass = v_pass;
        this.v_usuario = v_usuario;
        this.v_nombre_pila = v_nombre_pila;
        this.v_apellido = v_apellido;
        this.v_segundo_apellido = v_segundo_apellido;
        this.v_fechanac = v_fechanac;
        this.v_edad = age_calculator(v_fechanac);
        this.genero = genero;
        this.v_telefono = v_telefono;
    }


    public static int age_calculator(LocalDate v_fechanac) {
        LocalDate v_today = LocalDate.now();
        long v_years = ChronoUnit.YEARS.between(v_fechanac, v_today);
        return Math.toIntExact(v_years);
    }


    public int getV_key_type() {
        return v_rol;
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

    public String getV_nombre_pila() {
        return v_nombre_pila;
    }

    public void setV_nombre_pila(String v_nombre_pila) {
        this.v_nombre_pila = v_nombre_pila;
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

    public String getV_telefono() {
        return v_telefono;
    }

    public void setV_telefono(String v_telefono) {
        this.v_telefono = v_telefono;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getV_rol() {
        return v_rol;
    }

    public void setV_rol(int v_rol) {
        this.v_rol = v_rol;
    }

    public String getV_apellido() {
        return v_apellido;
    }

    public void setV_apellido(String v_apellido) {
        this.v_apellido = v_apellido;
    }

    public String getV_segundo_apellido() {
        return v_segundo_apellido;
    }

    public void setV_segundo_apellido(String v_segundo_apellido) {
        this.v_segundo_apellido = v_segundo_apellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return v_rol == usuario.v_rol &&
                v_ID == usuario.v_ID &&
                v_edad == usuario.v_edad &&
                Objects.equals(v_correo, usuario.v_correo) &&
                Objects.equals(v_pass, usuario.v_pass) &&
                Objects.equals(v_usuario, usuario.v_usuario) &&
                Objects.equals(v_nombre_pila, usuario.v_nombre_pila) &&
                Objects.equals(v_apellido, usuario.v_apellido) &&
                Objects.equals(v_segundo_apellido, usuario.v_segundo_apellido) &&
                Objects.equals(v_fechanac, usuario.v_fechanac) &&
                Objects.equals(genero, usuario.genero) &&
                Objects.equals(v_telefono, usuario.v_telefono) &&
                Objects.equals(identificacion, usuario.identificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v_rol, v_ID, v_correo, v_pass, v_usuario, v_nombre_pila, v_apellido, v_segundo_apellido, v_fechanac, v_edad, genero, v_telefono, identificacion);
    }

    @Override
    public String toString() {
        return "Usuario{Tipo de Usuario " + v_rol + "ID =" + v_ID + ", correo =" + v_correo + ", pass =" + v_pass + ", Nombre de usuario=" + v_usuario + ", nombre completo =" + v_nombre_pila + ", fecha de nacimiento =" + v_fechanac + ", edad = " + v_edad + ", genero = " + genero + ", telefono = " + v_telefono + ", identificacion = " + identificacion + '}';
    }


}
