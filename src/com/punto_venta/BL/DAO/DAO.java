/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punto_venta.BL.DAO;

/**
 *
 * @author krisa
 */
public abstract class DAO {
    protected String url = "jdbc:mysql://localhost:3306/mundial?serverTimezone=CST&verifyServerCertificate=false&useSSL=true";
    protected String user = "root";
    protected String pass = "root";
}
