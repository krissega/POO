/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punto_venta.DL;

/**
 *
 * @author krisa
 */
public class Conector {
    

    private static AccesoBD conectorBD = null;

    public static AccesoBD getConnector() throws Exception{
        if(conectorBD == null) {
            DBConnection confData = new DBConnection();
            /*conectorBD = new AccesoBD("com.mysql.cj.jdbc.Driver",
                    "jdbc:mysql://localhost/laboratorio?autoReconnect=true&useSSL=false",
                    confData.getUsername(), confData.getPassword());*/
            conectorBD = new AccesoBD("com.mysql.cj.jdbc.Driver",
                    confData.getConnectionString(),
                    confData.getUsername(), confData.getPassword());
        }
        return conectorBD;
    }


}
