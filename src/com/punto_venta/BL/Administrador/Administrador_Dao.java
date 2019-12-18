/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punto_venta.BL.Administrador;
import java.util.ArrayList;

/**
 *
 * @author krisa
 */
public interface Administrador_Dao {

    public String add(Administrador adm) throws Exception;
    public Administrador get() throws Exception;
    public boolean exists() throws Exception;
    public Administrador getById(int id) throws Exception;
    public String deleteById(int id)throws Exception;
}
