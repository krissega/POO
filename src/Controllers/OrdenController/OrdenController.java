/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.OrdenController;

import com.tupuntodeventa.BL.Ord.Orden;
import com.tupuntodeventa.BL.Ord.OrdenDAO;
import com.tupuntodeventa.BL.Prod.Combo;
import com.tupuntodeventa.BL.Prod.ComboDAO;
import com.tupuntodeventa.BL.Prod.Platillo;
import com.tupuntodeventa.BL.Prod.PlatilloDAO;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author krisa
 */
public class OrdenController {

    OrdenDAO log = new OrdenDAO();
    PlatilloDAO p = new PlatilloDAO();
    ComboDAO c = new ComboDAO();

    public void datosOrden(String tipo, int usuario, int cliente, ArrayList<Integer> ids_c, ArrayList<Integer> ids_p) {
        LocalDateTime fecha = LocalDateTime.now();
        ArrayList<Platillo> lista_p = null;
        ArrayList<Combo> lista_c = null;
        if (ids_p != null) {
            lista_p = p.buscarPlatillos(ids_p);
        } else if (ids_c != null) {
            lista_c = c.buscarCombos(ids_c);
        }
        registrarOrden(tipo, usuario, cliente, fecha, lista_c, lista_p);

    }

    public void registrarOrden(String v_tipo, int v_usuarioId, int v_clienteId, LocalDateTime v_fecha, ArrayList<Combo> v_combos, ArrayList<Platillo> v_prods) {
        double totalOrden = 0;
        if (v_combos != null) {//funcion parecidad al sum de sql un exito verdad profe ?
            for(int i=0;i<v_combos.size();i++){
            totalOrden+=  v_combos.get(i).getPrecio();
            }
        } else if (v_prods != null) {
            for(int j=0;j<v_prods.size();j++){
            totalOrden+=  v_prods.get(j).getV_precio();
            }
        }
        Orden temp = new Orden(v_tipo, v_usuarioId, v_clienteId, v_fecha, v_combos, v_prods, totalOrden);
        int clave = log.registrarOrden(temp);
        registrarContenido(clave, v_combos, v_prods);
        
        mostrarOrden(clave);
    }

    public boolean registrarContenido(int ids, ArrayList<Combo> comb, ArrayList<Platillo> plat) {

        boolean done = false;
        if (plat != null) {
            for (int i = 0; i < plat.size(); i++) {
                done = log.guardarContenidoOrden(ids, ids, plat.get(i).getV_ID());
            }
        } else if (comb != null) {
            for (int i = 0; i < comb.size(); i++) {
                done = log.guardarContenidoOrden(ids, ids, comb.get(i).getId());
            }
        }
        return done;
    }

    public void mostrarOrden(int id) {
        Orden ord = log.buscarOrden(id);
        System.out.println(ord);
    }

}
