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
public class AccesoBD {
    private Connection conn = null;
    private Statement stmt = null;

    public AccesoBD(String driver,String url, String user, String passwod) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        conn = DriverManager.getConnection(url,user,passwod);
        stmt = conn.createStatement();
    }

    // Se usa para Inseret, Update, Delete
    public void ejecutarSql(String query) throws Exception {
        stmt.executeUpdate(query);
    }

    // Este se usa para los select
    public ResultSet ejecutarQuery(String query) throws Exception {
        ResultSet rs = null;
        rs = stmt.executeQuery(query);
        return rs;
    }
}
