/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.CuponController;

import com.tupuntodeventa.BL.Cup.Cupon;
import com.tupuntodeventa.BL.Cup.CuponDao;
import com.tupuntodeventa.BL.Ord.OrdenDAO;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author krisa
 */
public class CuponController {
 
       CuponDao log;
    
    public boolean registrarCupon(LocalDate v_expira, int v_id, double v_descuento, boolean v_usado){
        Cupon c = new Cupon(v_expira,v_id, v_descuento, v_usado);
        log.registrarCupon(c);
        return true;
    }
    
    public List <Cupon> listar(){
    List <Cupon> all = log.buscarTodos();
    return all;
    }
    
    
    
    
    
}
