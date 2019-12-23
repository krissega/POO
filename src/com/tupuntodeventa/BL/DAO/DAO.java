/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tupuntodeventa.BL.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.StringJoiner;

/**
 *
 * @author krisa
 */
public class DAO {

    protected String url;
    protected String user;
    protected String pass;


    public DAO() {
        File propFile = new File("src/com/tupuntodeventa/propiedades/accesobd.properties");
        if (propFile.exists()) {
            try (InputStream input = new FileInputStream(propFile)) {
                Properties properties = new Properties();
                properties.load(input);

                url = properties.getProperty("bd.url");
                user = properties.getProperty("bd.user");
                pass = properties.getProperty("bd.pass");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected String inSQLPlaceholders(int tamano) {
        StringJoiner joiner = new StringJoiner(",", "(", ")");
        for (int i = 0; i < tamano; i++) {
            joiner.add("?");
        }

        return joiner.toString();
    }
}
