/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punto_venta.BL.Cupon;

import java.util.ArrayList;

/**
 *
 * @author krisa
 */
public interface Cupon_Dao {
    public String add() throws Exception;
    public ArrayList<Cupon> get() throws Exception;
    public boolean exists() throws Exception;
    public Cupon getById(int id) throws Exception;
    public String deleteById(int id)throws Exception;
}
