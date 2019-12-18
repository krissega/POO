/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punto_venta.DL;

import java.beans.Statement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author krisa
 */
public class DBConnection {
    
    static final String ARCHIVO_CREDENCIALES = "CREDENCIALES_DB.txt";
    private String username;
    private String password;
    private String database;
    private String server;
    private String connString;

    public DBConnection() {
        getConnectionData();
    }

    private void getConnectionData(){
        try {
            File file = new File(getArchivoCredenciales()); 
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;

            while ((st = br.readLine()) != null){
                String linea = st;
                String[] parts = linea.split(",");
                setUsername(parts[0]);
                setPassword(parts[1]);
                setDatabase(parts[2]);
                setServer(parts[3]);
            }
        }catch (Exception e){

        }
    }

    public String getConnectionString(){
        String tempString = "jdbc:mysql://"+getServer()+"/"+getDatabase()+"?autoReconnect=true&useSSL=false";
        //String tempString = "jdbc:mysql://"+getServer()+"/"+getDatabase()+"?user="+getUsername()+"&password="+getPassword()+"&serverTimezone=UTC";
        return tempString;
    }

    private Statement getConnection(){
        Connection conn = null;
        Statement stmt = null;


        try {
            conn = DriverManager.getConnection(getConnectionString());
            stmt = (Statement) conn.createStatement();


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return stmt;
    }

    public void getQueryArray(String query, String[] responseFields){
        ResultSet rs = null;
        Statement stmt = getConnection();
        try {
            rs = stmt.executeQuery;
            //deeberia retornar el resultset para recorrerlo en otro metodo
            while(rs.next())
            {
                for(int i = 0; i < responseFields.length; i++){
                    System.out.println( rs.getString(responseFields[i]));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                System.out.println("hola");
                stmt.getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static String getArchivoCredenciales() {
        return ARCHIVO_CREDENCIALES;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getConnString() {
        return connString;
    }

    public void setConnString(String connString) {
        this.connString = connString;
    }
}
