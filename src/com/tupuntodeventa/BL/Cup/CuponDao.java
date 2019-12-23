/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tupuntodeventa.BL.Cup;

import com.tupuntodeventa.BL.DAO.DAO;
import com.tupuntodeventa.BL.Prod.PlatilloDao;

import java.sql.Connection;
import java.sql.Date;
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
 * @author krisa
 */
public class CuponDao extends DAO {

    private final String BUSCAR_TODOS = "SELECT * FROM cupones";
    private final String BUSCAR_CUPON = "SELECT *  AS cupon FROM cupones WHERE ID = ?";
    private final String REGISTRAR_CUPON = "INSERT INTO cupones  (Id, FechaExpiracion,Utilizado, Codigo,Porcentaje) VALUES (?, ?, ?, ?, ?)";


    //BUSCA TODOS LOS PLATILLOS DE LA TABLA Y LOS DEVUELVE EN UNA LISTA

    public List<Cupon> buscarTodos() {
        List<Cupon> v_lista = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = buscarTodosPs(conn);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cupon v_cupon = new Cupon();
                v_cupon.setV_id(rs.getInt("Id"));
                v_cupon.setV_expira(rs.getDate("FechaExpiracion").toLocalDate());
                v_cupon.setV_usado(rs.getBoolean("Utilizado"));
                v_cupon.setV_codigoBD(rs.getString("Codigo"));
                v_cupon.setV_descuento(rs.getDouble("Porcentaje"));

                v_lista.add(v_cupon);
            }
        } catch (SQLException ex) {

        }

        return v_lista;
    }

    private PreparedStatement buscarTodosPs(Connection conn) throws SQLException {
        return conn.prepareStatement(BUSCAR_TODOS);
    }


    public boolean registrarCupon(Cupon v_nuevo) {
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = registrarCuponPs(conn, v_nuevo)) {
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PlatilloDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public PreparedStatement registrarCuponPs(Connection conn, Cupon v_nuevo) throws SQLException {
        int i = 1;
        PreparedStatement ps = conn.prepareStatement(REGISTRAR_CUPON, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(i++, v_nuevo.getV_id());
        ps.setDate(i++, Date.valueOf(v_nuevo.getV_expira()));
        ps.setBoolean(i++, v_nuevo.getV_usado());
        ps.setString(i++, v_nuevo.getV_codigo());
        ps.setDouble(i, v_nuevo.getV_descuento());


        return ps;
    }


}
