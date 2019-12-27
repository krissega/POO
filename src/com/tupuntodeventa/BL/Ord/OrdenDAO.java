/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tupuntodeventa.BL.Ord;

import com.tupuntodeventa.BL.DAO.DAO;
import com.tupuntodeventa.BL.Prod.Combo;
import com.tupuntodeventa.BL.Prod.ComboDAO;
import com.tupuntodeventa.BL.Prod.Platillo;
import com.tupuntodeventa.BL.Prod.PlatilloDAO;
import com.tupuntodeventa.BL.Usuarios.UsuarioDAO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author krisa
 */
public class OrdenDAO extends DAO {

    private final String BUSCAR_TODOS = "SELECT * FROM ordenes";
    private final String BUSCAR_ORDEN ="SELECT * FROM ordenes WHERE id = ?";
    private final String BUSCAR_CONTENIDO = "SELECT * FROM ordencontenido WHERE IdOrden = ?";
    private final String REGISTRAR_ORDEN = "INSERT INTO Ordenes (IdUsuario, IdCliente, TipoOrden, Fecha, Precio) " +
            "VALUES (?, ?, ?, ?, ?)";
    private final String REGISTRAR_CONTENIDO = "INSERT INTO ordencontenido (TipoContenido, IdContenido, IdOrden) VALUES(?,?,?)";


    public Orden  buscarOrden (int id) {
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = buscarOrdenPs(conn, id);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                Orden v_orden = new Orden();
                v_orden.setV_fecha(rs.getTimestamp("Fecha").toLocalDateTime());
                v_orden.setV_usuarioId(rs.getInt("IdUsuario"));
                v_orden.setV_clienteId(rs.getInt("IdCliente"));
                v_orden.setV_tipo(rs.getInt("TipoOrden") == 1 ? "Platillos" : "Combo");
                v_orden.setV_total(rs.getDouble("Precio"));

                if (rs.getInt("TipoOrden") == 1) {
                    // de platillos
                    v_orden.setV_prods(buscarContenidoPlatillo(conn, id));
                } else { //combos
                    v_orden.setV_combos(buscarContenidoCombo(conn, id));
                }
                
                return v_orden;
            }
        } catch (SQLException ex) {

        }

        return null;
    }

    private PreparedStatement buscarOrdenPs(Connection conn, int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(BUSCAR_ORDEN);
        ps.setInt(1, id);
        return ps;
    }

    public List<Orden> buscarTodos() {
        List<Orden> v_listap = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = buscarTodosPs(conn);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Orden v_orden = new Orden();
                v_orden.setV_fecha(rs.getTimestamp("Fecha").toLocalDateTime());
                v_orden.setV_usuarioId(rs.getInt("IdUsuario"));
                v_orden.setV_clienteId(rs.getInt("IdCliente"));
                v_orden.setV_tipo(rs.getInt("TipoOrden") == 1 ? "Platillos" : "Combo");
                v_orden.setV_total(rs.getDouble("Precio"));

                if (rs.getInt("TipoOrden") == 1) {
                    // de platillos
                    v_orden.setV_prods(buscarContenidoPlatillo(conn, rs.getInt("Id")));
                } else { //combos
                    v_orden.setV_combos(buscarContenidoCombo(conn, rs.getInt("Id")));
                }

                v_listap.add(v_orden);
            }
        } catch (SQLException ex) {

        }

        return v_listap;
    }

    private ArrayList<Combo> buscarContenidoCombo(Connection conn, int id) {
        ArrayList<Combo> listaCombos = new ArrayList<>();
        ArrayList<Integer> idsCombos = new ArrayList<>();
        try (PreparedStatement ps = buscarContenidoPs(conn, id);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                idsCombos.add(rs.getInt("IdContenido"));
            }

            if (!idsCombos.isEmpty()) {
                ComboDAO comboDao = new ComboDAO();
                listaCombos = comboDao.buscarCombos(conn, idsCombos);
            }
        } catch (SQLException ex) {

        }

        return listaCombos;
    }

    private PreparedStatement buscarTodosPs(Connection conn) throws SQLException {
        return conn.prepareStatement(BUSCAR_TODOS);
    }

    private ArrayList<Platillo> buscarContenidoPlatillo(Connection conn, int idOrden) {
        ArrayList<Platillo> listaPlatillos = new ArrayList<>();
        ArrayList<Integer> idsPlatillos = new ArrayList<>();
        try (PreparedStatement ps = buscarContenidoPs(conn, idOrden);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                idsPlatillos.add(rs.getInt("IdContenido"));
            }

            if (!idsPlatillos.isEmpty()) {
                PlatilloDAO platilloDao = new PlatilloDAO();
                listaPlatillos = platilloDao.buscarPlatillos(conn, idsPlatillos);
            }
        } catch (SQLException ex) {

        }

        return listaPlatillos;
    }

    private PreparedStatement buscarContenidoPs(Connection conn, int idOrden) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(BUSCAR_CONTENIDO);
        ps.setInt(1, idOrden);
        return ps;
    }

    public int registrarOrden(Orden v_nuevo) {
        ResultSet rs = null;
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = registrarOrdenPs(conn, v_nuevo)) {
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdenDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrdenDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }

    private PreparedStatement registrarOrdenPs(Connection conn, Orden v_orden) throws SQLException {
        int i = 1;

        PreparedStatement ps = conn.prepareStatement(REGISTRAR_ORDEN, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(i++, v_orden.getV_usuarioId());
        ps.setInt(i++, v_orden.getV_clienteId());
        ps.setInt(i++, Integer.parseInt(v_orden.getV_tipo()));
        ps.setTimestamp(i++, Timestamp.valueOf(v_orden.getV_fecha()));
        ps.setDouble(i, v_orden.getV_total());

        return ps;
    }

    public boolean guardarContenidoOrden(int idContenido, int tipoContenido, int idOrden) {
        try (Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = guardarContenidoOrdenPs(conn, idContenido, tipoContenido, idOrden)) {
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    private PreparedStatement guardarContenidoOrdenPs(Connection conn, int idContenido, int tipoContenido, int idOrden) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(REGISTRAR_CONTENIDO);
        ps.setInt(1, idContenido);
        ps.setInt(2, tipoContenido);
        ps.setInt(3, idOrden);
        return ps;
    }
}
