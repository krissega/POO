/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tupuntodeventa.BL.Prod;

import com.tupuntodeventa.BL.DAO.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author krisa
 */
public class PlatilloDAO extends DAO {
    private final String BUSCAR_TODOS = "SELECT * FROM Platillos";
    private final String BUSCAR_PLATILLOS = "SELECT * FROM Platillos WHERE Id IN "; // VA A RECIBIR VARIOS IDS DE PLATILLOS
    private final String BUSCAR_COMBO = "SELECT *  FROM Combos WHERE ID_COMBO = ?";
    private final String REGISTRAR_PLATILLO = "INSERT INTO Platillos (nombre, Precio, Descripcion) VALUES (?, ?, ?)";
    
    //BUSCA TODOS LOS PLATILLOS DE LA TABLA Y LOS DEVUELVE EN UNA LISTA
    
    public List<Platillo> buscarTodos() {
        List<Platillo> v_listap = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = buscarTodosPs(conn);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Platillo v_platillo = new Platillo();
                v_platillo.setV_ID(rs.getInt("Id"));
                v_platillo.setV_nombre(rs.getString("nombre"));
                v_platillo.setV_descripcion(rs.getString("descripcion"));
                v_platillo.setV_precio(rs.getDouble("precio"));
                
                v_listap.add(v_platillo);
            }
        } catch (SQLException ex) {
          
        }
        
        return v_listap;
    }
    
    private PreparedStatement buscarTodosPs(Connection conn) throws SQLException {
        return conn.prepareStatement(BUSCAR_TODOS);
    }

    public ArrayList<Platillo> buscarPlatillos(Connection conn, ArrayList<Integer> idsPlatillos) {
        ArrayList<Platillo> platillos = new ArrayList<>();
        try (PreparedStatement ps = buscarPlatillosPs(conn, idsPlatillos);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Platillo platillo = new Platillo();
                platillo.setV_ID(rs.getInt("Id"));
                platillo.setV_precio(rs.getDouble("Precio"));
                platillo.setV_descripcion(rs.getString("Descripcion"));
                platillo.setV_nombre("Nombre");

                platillos.add(platillo);
            }
        } catch (SQLException e) {

        }

        return platillos;
    }

    private PreparedStatement buscarPlatillosPs(Connection conn, ArrayList<Integer> idsPlatillos) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(BUSCAR_PLATILLOS + inSQLPlaceholders(idsPlatillos.size()));
        for (int i = 1; i <= idsPlatillos.size(); i++) {
            ps.setInt(i, idsPlatillos.get(i - 1));
        }
        return ps;
    }

    public boolean registrarPlatillo(Platillo v_nuevop) {
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = registrarPlatilloPs(conn, v_nuevop)) {
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PlatilloDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
  
    public PreparedStatement registrarPlatilloPs(Connection conn, Platillo  v_platillo) throws SQLException {
        int i = 1;
        PreparedStatement ps = conn.prepareStatement(REGISTRAR_PLATILLO, Statement.RETURN_GENERATED_KEYS);
        ps.setString(i++,v_platillo.getV_nombre());
        ps.setDouble(i++,v_platillo.getV_precio());
        ps.setString(i++,v_platillo.getV_descripcion());
      

     

        return ps;
    }
    
}
