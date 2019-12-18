/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punto_venta.BL.Empleado;

import com.punto_venta.BL.Usuario.Usuario;
import java.util.ArrayList;

/**
 *
 * @author krisa
 */
public interface Empleado_Dao {
    
   public String add() throws Exception;
    public ArrayList<Usuario> get() throws Exception;
    public boolean exists() throws Exception;
    public Usuario getById(int id) throws Exception;
    public String deleteById(int id)throws Exception;


}
