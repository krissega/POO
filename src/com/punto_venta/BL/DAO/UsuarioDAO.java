/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punto_venta.BL.DAO;

import com.punto_venta.BL.Usuario;
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
public class UsuarioDAO extends DAO {
    
    private final String BUSCAR_TODOS = "SELECT * FROM usuarios";
    private final String LOGIN = "SELECT * FROM usuarios WHERE NombreUsuario = ? AND Clave = ?";
    
    public List<Usuario> buscarTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = buscarTodosPs(conn);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setV_ID(rs.getInt("Id"));
                usuario.setV_key_type(rs.getString("Rol"));
                usuario.setGenero(rs.getString("Genero"));
                usuario.setV_correo("Correo");
                usuario.setV_usuario(rs.getString("NombreUsuario"));
                usuario.setIdentificacion(rs.getString("Identificacion"));
                usuario.setV_fechanac(rs.getDate("FechaNac").toLocalDate());
                usuario.setV_edad(Usuario.age_calculator(usuario.getV_fechanac()));
                usuario.setV_nombre(new String[] { rs.getString("NombrePila"), rs.getString("Apellido"), rs.getString("SegundoApellido") });
                
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuarios;
    }
    
    private PreparedStatement buscarTodosPs(Connection conn) throws SQLException {
        return conn.prepareStatement(BUSCAR_TODOS);
    }
    
    public boolean autenticar(String nombreUsuario, String clave) {
        try (Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = autenticarPs(conn, nombreUsuario, clave);
                ResultSet rs = ps.executeQuery()) {
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private PreparedStatement autenticarPs(Connection conn, String nombreUsuario, String clave) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(LOGIN);
        ps.setString(1, nombreUsuario);
        ps.setString(2, clave);
        return ps;
    }
}
