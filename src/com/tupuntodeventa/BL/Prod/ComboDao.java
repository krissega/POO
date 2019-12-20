package com.tupuntodeventa.BL.Prod;

import com.tupuntodeventa.BL.DAO.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ComboDao extends DAO {

    private final String BUSCAR_COMBOS = "SELECT * FROM Combos WHERE Id IN "; // VA A RECIBIR VARIOS IDS DE COMBOS

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
}
