/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tupuntodeventa.BL.Puestos;

import com.tupuntodeventa.BL.DAO.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author krisa
 */
public class PuestoDAO extends DAO {
    private final String BUSCAR_TODOS = "SELECT * FROM puestos";
   // private final String BUSCAR_PUESTO = "SELECT * FROM Puestos  WHERE Id IN "; // VA A RECIBIR VARIOS IDS DE COMBOS
    private final String REGISTRAR_PUESTO = "INSERT INTO puestos (Nombre, descripcion) VALUES (?, ?)";


    
    public List<Puesto> buscarTodos() {
        List<Puesto> v_lista = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = buscarTodosPs(conn);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Puesto v_puesto = new Puesto();
                v_puesto.setV_puesto(rs.getString("nombre"));
                v_puesto.setV_describ(rs.getString("descripcion"));

                v_lista.add(v_puesto);
            }
        } catch (SQLException ex) {

        }

        return v_lista;
    }

    private PreparedStatement buscarTodosPs(Connection conn) throws SQLException {
        return conn.prepareStatement(BUSCAR_TODOS);
    }

    public boolean registrarPuesto(Puesto nuevo) {
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = registrarPuestoPs(conn, nuevo)) {
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private PreparedStatement registrarPuestoPs(Connection conn, Puesto nuevo) throws SQLException {
        int i = 1;
        PreparedStatement ps = conn.prepareStatement(REGISTRAR_PUESTO);
        ps.setString(i++,nuevo.getV_puesto());
        ps.setString(i++,nuevo.getV_describ());
        return ps;
    }

}
