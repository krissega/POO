/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punto_venta.BL.Prod;

import com.punto_venta.BL.DAO.DAO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author krisa
 */
public class PlatilloDao extends DAO {
    private final String BUSCAR_TODOS = "SELECT * FROM Platillos";
    private final String BUSCAR_COMBO = "SELECT *  FROM Combos WHERE ID_COMBO = ?";
    private final String REGISTRAR_PLATILLO = "INSERT INTO Platillos () VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String REGISTRAR_COMBO="INSERT INTO PlatillosXCombo VALUES(??,?,?,?)";
    
    
    
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
    
  
    public boolean registrarPlatillo(Platillo v_nuevop) {
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = registrarPlatilloPs(conn, v_nuevop)) {
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PlatilloDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
  
    public PreparedStatement registrarPlatilloPs(Connection conn, Platillo  v_platillo) throws SQLException {
        int i = 0;
        PreparedStatement ps = conn.prepareStatement(REGISTRAR_PLATILLO, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(i++,v_platillo.getV_ID());
        ps.setString(i++,v_platillo.getV_nombre());
        ps.setString(i++,v_platillo.getV_descripcion());
        ps.setDouble(i++,v_platillo.getV_precio());

     

        return ps;
    }
    
}
