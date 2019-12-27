package com.tupuntodeventa.BL.Prod;

import com.tupuntodeventa.BL.DAO.DAO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComboDAO extends DAO {

    private final String BUSCAR_TODOS = "SELECT * FROM combos";
    private final String BUSCAR_COMBOS = "SELECT * FROM Combos WHERE Id IN "; // VA A RECIBIR VARIOS IDS DE COMBOS
    private final String REGISTRAR_COMBO = "INSERT INTO combos (Nombre, precio) VALUES (?, ?)";
    private final String REGISTRAR_CONTENIDO_COMBO = "INSERT INTO platillosxcombos (PlatilloId, ComboId) VALUES(?,?)";

    public List<Combo> buscarTodos() {
        List<Combo> v_listac = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = buscarTodosPs(conn);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Combo v_combo = new Combo();
                v_combo.setId(rs.getInt("Id"));
                v_combo.setNombre(rs.getString("nombre"));
                v_combo.setPrecio(rs.getDouble("precio"));

                v_listac.add(v_combo);
            }
        } catch (SQLException ex) {

        }

        return v_listac;
    }

    private PreparedStatement buscarTodosPs(Connection conn) throws SQLException {
        return conn.prepareStatement(BUSCAR_TODOS);
    }

    public ArrayList<Combo> buscarCombos(ArrayList<Integer> idsCombos) {
        ArrayList<Combo> combos = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = buscarCombosPs(conn, idsCombos);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Combo combo = new Combo();
                combo.setId(rs.getInt("Id"));
                combo.setPrecio(rs.getDouble("Precio"));
                combo.setNombre("Nombre");

                combos.add(combo);
            }
        } catch (SQLException e) {

        }

        return combos;
    }
    
    public ArrayList<Combo> buscarCombos(Connection conn, ArrayList<Integer> idsCombos) {
        ArrayList<Combo> combos = new ArrayList<>();
        try (PreparedStatement ps = buscarCombosPs(conn, idsCombos);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Combo combo = new Combo();
                combo.setId(rs.getInt("Id"));
                combo.setPrecio(rs.getDouble("Precio"));
                combo.setNombre("Nombre");

                combos.add(combo);
            }
        } catch (SQLException e) {

        }

        return combos;
    }

    private PreparedStatement buscarCombosPs(Connection conn, ArrayList<Integer> ids) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(BUSCAR_COMBOS + inSQLPlaceholders(ids.size()));
        for (int i = 1; i <= ids.size(); i++) {
            ps.setInt(i, ids.get(i - 1));
        }
        return ps;
    }

    public boolean registrarCombo(Combo nuevoCombo) {
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = registrarComboPs(conn, nuevoCombo)) {
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private PreparedStatement registrarComboPs(Connection conn, Combo combo) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(REGISTRAR_COMBO);
        ps.setString(1, combo.getNombre());
        ps.setBigDecimal(2, BigDecimal.valueOf(combo.getPrecio()));
        return ps;
    }

    public boolean registrarContenidoCombo(int idCombo, ArrayList<Platillo> listaPlatillos) {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement ps = null;
            for (Platillo platillo : listaPlatillos) {
                ps = registrarContenidoComboPs(conn, idCombo, platillo);
                ps.addBatch();
            }
            return ps != null && ps.executeBatch().length > 0;
        } catch (SQLException e) {

        }

        return false;
    }

    private PreparedStatement registrarContenidoComboPs(Connection conn, int idCombo, Platillo platillo) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(REGISTRAR_CONTENIDO_COMBO);
        ps.setInt(platillo.getV_ID(), idCombo);
        return ps;
    }
}
