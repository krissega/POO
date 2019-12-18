/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punto_venta.BL.Puesto;

import java.util.ArrayList;

/**
 *
 * @author krisa
 */
public interface Puesto_Dao {
    public String add() throws Exception;
    public ArrayList<Puesto> get() throws Exception;
    public boolean exists() throws Exception;
    public Puesto getById(int id) throws Exception;
    public String deleteById(int id)throws Exception;    



}
