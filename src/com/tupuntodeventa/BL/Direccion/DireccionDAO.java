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

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DireccionDAO extends DAO {

    private final String INSERTAR_DIRECCION = "INSERT INTO direcciones (DireccionExacta, Canton, Distrito, Provincia, " +
            "Distancia, UsuarioId) VALUES (?, ?, ?, ?, ?, ?)";
    private final String BUSCAR_DIRECCIONES_USUARIO = "SELECT * FROM direcciones WHERE UsuarioId = ?";

    public DireccionDAO() {
        super();
    }

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

    public ArrayList<Direccion> buscarDireccionesUsuario(int idUsuario) {
        ArrayList<Direccion> direcciones = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = buscarDireccionesUsuariops(conn, idUsuario);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Direccion direccion = new Direccion();
                direccion.setId(rs.getInt("Id"));
                direccion.setCanton(rs.getString("Canton"));
                direccion.setDireccionExacta(rs.getString("DireccionExacta"));
                direccion.setDistancia(rs.getInt("Distancia"));
                direccion.setDistrito(rs.getString("Distrito"));
                direccion.setProvincia(rs.getString("Provincia"));
                direccion.setUsuarioId(idUsuario);

                direcciones.add(direccion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return direcciones;
    }

    private PreparedStatement buscarDireccionesUsuariops(Connection conn, int idUsuario) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(BUSCAR_DIRECCIONES_USUARIO);
        ps.setInt(1, idUsuario);
        return ps;
    }
}
