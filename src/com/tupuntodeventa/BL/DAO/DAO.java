/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tupuntodeventa.BL.DAO;

import java.util.StringJoiner;

/**
 *
 * @author krisa
 */
public class DAO {

    protected String url = "jdbc:mysql://localhost:3306/puntoventa?serverTimezone=CST&verifyServerCertificate=false&useSSL=true";
    protected String user = "root";
    protected String pass = "root";

    protected String inSQLPlaceholders(int tamano) {
        StringJoiner joiner = new StringJoiner(",", "(", ")");
        for (int i = 0; i < tamano; i++) {
            joiner.add("?");
        }

        return joiner.toString();
    }
}
