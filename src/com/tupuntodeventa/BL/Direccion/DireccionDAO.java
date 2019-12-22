/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tupuntodeventa.BL.Direccion;

/**
 *
 * @author krisa
 */
import com.tupuntodeventa.BL.DAO.DAO;
import com.tupuntodeventa.BL.Usuarios.UsuarioDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DireccionDAO extends DAO {

    private final String INSERTAR_DIRECCION = "INSERT INTO direcciones (DireccionExacta, Canton, Distrito, Provincia, " +
            "Distancia, UsuarioId) VALUES (?, ?, ?, ?, ?, ?)";

    public boolean registrarDireccion(int usuarioId, Direccion direccion) {
        try (Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = insertarDireccionPs(conn, usuarioId, direccion)) {
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    private PreparedStatement insertarDireccionPs(Connection conn, int usuarioId, Direccion direccion) throws SQLException {
        int i = 1;
        PreparedStatement ps = conn.prepareStatement(INSERTAR_DIRECCION);
        ps.setString(i++, direccion.getDireccionExacta());
        ps.setString(i++, direccion.getCanton());
        ps.setString(i++, direccion.getDistrito());
        ps.setString(i++, direccion.getProvincia());
        ps.setInt(i++, direccion.getDistancia());
        ps.setInt(i, usuarioId);
        return ps;
    }
}
