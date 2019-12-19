/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punto_venta.BL.Ord;

import java.util.ArrayList;

/**
 *
 * @author krisa
 */
public interface Orden_Dao {
    
   public String add() throws Exception;
    public ArrayList<Orden> get() throws Exception;
    public boolean exists() throws Exception;
    public Orden getById(int id) throws Exception;
    public String deleteById(int id)throws Exception;



}
