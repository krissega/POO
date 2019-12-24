/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tupuntodeventa.BL.Usuarios;

import com.tupuntodeventa.BL.DAO.DAO;
import com.tupuntodeventa.BL.Direccion.Direccion;
import com.tupuntodeventa.BL.Direccion.DireccionDAO;

import java.math.BigDecimal;
import java.sql.*;
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
    private final String USUARIO_ID = "SELECT * FROM usuarios WHERE Id = ?";
    private final String VERIFICAR_ADMIN = "SELECT Id FROM usuarios WHERE Rol = 0";
    private final String VERIFICAR_IDENTIFICACION = "SELECT Id from usuarios WHERE Identificacion = ?";
    private final String REGISTRAR_USUARIO = "INSERT INTO usuarios (NombreUsuario, Clave, Correo, NombrePila, " +
            "Apellido, SegundoApellido, FechaNac, Genero, Identificacion, Telefono, Rol, NombrePuesto, SalarioBase, " +
            "Bonificacion, SalarioNeto, FechaContrato) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public UsuarioDAO() {
        super();
    }

    public List<Usuario> buscarTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = buscarTodosPs(conn);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setV_ID(rs.getInt("Id"));
                usuario.setGenero(rs.getString("Genero"));
                usuario.setV_correo("Correo");
                usuario.setV_usuario(rs.getString("NombreUsuario"));
                usuario.setIdentificacion(rs.getString("Identificacion"));
                usuario.setV_fechanac(rs.getDate("FechaNac").toLocalDate());
                usuario.setV_edad(Usuario.age_calculator(usuario.getV_fechanac()));
                usuario.setV_nombre_pila(rs.getString("nombre"));
                
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
    
    public Usuario autenticar(String nombreUsuario, String clave) {
        try (Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = autenticarPs(conn, nombreUsuario, clave);
                ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                Usuario usuario = null;
                switch (rs.getInt("Rol")) {
                    case 0:
                        usuario = new Administrador(
                                0,
                                rs.getInt("Id"),
                                rs.getString("Correo"),
                                null,
                                rs.getString("NombreUsuario"),
                                rs.getString("NombrePila"),
                                rs.getString("Apellido"),
                                rs.getString("SegundoApellido"),
                                rs.getDate("FechaNac").toLocalDate(),
                                rs.getString("Genero"),
                                rs.getString("Telefono"),
                                rs.getString("Identificacion"));
                        usuario.setV_edad(Usuario.age_calculator(usuario.getV_fechanac()));
                    break;
                    case 1:
                        usuario = new Empleado();
                        usuario.setV_rol(1);
                        usuario.setV_ID(rs.getInt("Id"));
                        usuario.setGenero(rs.getString("Genero"));
                        usuario.setIdentificacion(rs.getString("Identificacion"));
                        usuario.setV_correo(rs.getString("Correo"));
                        usuario.setV_fechanac(rs.getDate("FechaNac").toLocalDate());
                        usuario.setV_edad(Usuario.age_calculator(usuario.getV_fechanac()));
                        usuario.setV_nombre_pila(rs.getString("NombrePila"));
                        usuario.setV_usuario(rs.getString("NombreUsuario"));
                        usuario.setV_apellido(rs.getString("Apellido"));
                        usuario.setV_segundo_apellido(rs.getString("SegundoApellido"));
                        usuario.setV_telefono("Telefono");
                        ((Empleado) usuario).setV_puesto(rs.getString("NombrePuesto"));
                        ((Empleado) usuario).setV_salbase(rs.getInt("SalarioBase"));
                        ((Empleado) usuario).setV_bonus(rs.getDouble("Bonificacion"));
                        ((Empleado) usuario).setV_netsal(rs.getInt("SalarioNeto"));
                        ((Empleado) usuario).setV_inicia(rs.getDate("FechaContrato").toLocalDate());
                        break;
                    case 2:
                        DireccionDAO direccionDAO = new DireccionDAO();
                        int idUsuario = rs.getInt("Id");
                        usuario = new Cliente(direccionDAO.buscarDireccionesUsuario(idUsuario),
                                2, idUsuario, rs.getString("Correo"),
                                    null, rs.getString("NombreUsuario"),
                                rs.getString("NombrePila"), rs.getString("Apellido"),
                                rs.getString("SegundoApellido"), rs.getDate("FechaNac").toLocalDate(),
                                rs.getString("Genero"), rs.getString("Telefono"), rs.getString("Identificacion"));
//                        usuario.setIdentificacion(rs.getString("Identificacion"));
                    break;
                }
                return usuario;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private PreparedStatement autenticarPs(Connection conn, String nombreUsuario, String clave) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(LOGIN);
        ps.setString(1, nombreUsuario);
        ps.setString(2, clave);
        return ps;
    }

    public boolean verificarIdentificacion(String identificacion) {
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = verificarIdentificacionPs(conn, identificacion);
             ResultSet rs = ps.executeQuery()) {
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private PreparedStatement verificarIdentificacionPs(Connection conn, String identificacion) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(VERIFICAR_IDENTIFICACION);
        ps.setString(1, identificacion);
        return ps;
    }

    public boolean verificarAdmin() {
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = verificarAdminPs(conn);
             ResultSet rs = ps.executeQuery()) {
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private PreparedStatement verificarAdminPs(Connection conn) throws SQLException {
        return conn.prepareStatement(VERIFICAR_ADMIN);
    }

    public boolean registrarUsuario(Usuario nuevoUsuario) {
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = registrarUsuarioPs(conn, nuevoUsuario)) {
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // usar para clientes
    public boolean registrarCliente(Cliente nuevoUsuario, Direccion direccion) {
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = registrarUsuarioPs(conn, nuevoUsuario)) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                DireccionDAO direccionDAO = new DireccionDAO();
                return direccionDAO.registrarDireccion(rs.getInt(1), direccion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public PreparedStatement registrarUsuarioPs(Connection conn, Usuario nuevoUsuario) throws SQLException {
        int i = 1;
        PreparedStatement ps = conn.prepareStatement(REGISTRAR_USUARIO);
        ps.setString(i++, nuevoUsuario.getV_usuario());
        ps.setString(i++, nuevoUsuario.getV_pass());
        ps.setString(i++, nuevoUsuario.getV_correo());
        ps.setString(i++, nuevoUsuario.getV_nombre_pila());
        ps.setString(i++, nuevoUsuario.getV_apellido());
        ps.setString(i++, nuevoUsuario.getV_segundo_apellido());
        ps.setDate(i++, Date.valueOf(nuevoUsuario.getV_fechanac()));
        ps.setString(i++, nuevoUsuario.getGenero());
        ps.setString(i++, nuevoUsuario.getIdentificacion());
        ps.setString(i++, nuevoUsuario.getV_telefono()); 
        ps.setInt(i++, nuevoUsuario.getV_key_type());

        if (nuevoUsuario instanceof Empleado) {
            Empleado nuevoEmpleado = (Empleado) nuevoUsuario;
            ps.setString(i++, nuevoEmpleado.getV_puesto());
            ps.setBigDecimal(i++, new BigDecimal(nuevoEmpleado.getV_salbase()));
            ps.setBigDecimal(i++, BigDecimal.valueOf(nuevoEmpleado.getV_bonus()));
            ps.setBigDecimal(i++, new BigDecimal(nuevoEmpleado.getV_netsal()));
            ps.setDate(i, Date.valueOf(nuevoEmpleado.getV_inicia()));
        } else {
            ps.setNull(i++, Types.VARCHAR);
            ps.setNull(i++, Types.DECIMAL);
            ps.setNull(i++, Types.DECIMAL);
            ps.setNull(i++, Types.DECIMAL);
            ps.setNull(i, Types.DATE);
        }

        return ps;
    }

    public Usuario getUsuario(int id) {
        Usuario usuario = null;
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = getUsuarioPs(conn, id);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setV_ID(id);
                usuario.setGenero(rs.getString("Genero"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    private PreparedStatement getUsuarioPs(Connection conn, int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(USUARIO_ID);
        ps.setInt(1, id);
        return ps;
    }
}

