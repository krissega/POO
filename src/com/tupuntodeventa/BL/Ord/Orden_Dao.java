/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tupuntodeventa.BL.Ord;

import com.punto_venta.BL.DAO.DAO;
import com.punto_venta.BL.Prod.Platillo;
import com.punto_venta.BL.Prod.PlatilloDao;
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
public class Orden_Dao extends DAO {
    
private final String BUSCAR_TODOS = "SELECT * FROM Platillos";
    private final String BUSCAR_COMBO = "SELECT *  FROM Combos WHERE ID_COMBO = ?";
    private final String REGISTRAR_ORDEN  = "INSERT INTO Ordenes () VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String REGISTRAR_COMBO="INSERT INTO PlatillosXCombo VALUES(??,?,?,?)";
    
    
    
    //BUSCA TODOS LOS PLATILLOS DE LA TABLA Y LOS DEVUELVE EN UNA LISTA
    
    public List<Orden> buscarTodos() {
        List<Orden> v_listap = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = buscarTodosPs(conn);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Orden v_orden = new Orden  ();
           
                
                v_listap.add(v_orden );
            }
        } catch (SQLException ex) {
          
        }
        
        return v_listap;
    }
    
    private PreparedStatement buscarTodosPs(Connection conn) throws SQLException {
        return conn.prepareStatement(BUSCAR_TODOS);
    }
    
  
    public boolean registrarOrden(Orden v_nuevo) {
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = registrarOrdenPs(conn, v_nuevo)) {
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PlatilloDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
  
    public PreparedStatement registrarOrdenPs(Connection conn, Orden  v_orden) throws SQLException {
        int i = 0;
        
        PreparedStatement ps = conn.prepareStatement(REGISTRAR_ORDEN, Statement.RETURN_GENERATED_KEYS);
        ps.setString(i++,v_orden.getV_nombrec());
      

     

        return ps;
    }




}
