/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.CuponController;

import com.tupuntodeventa.BL.Cup.Cupon;
import com.tupuntodeventa.BL.Cup.CuponDao;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author krisa
 */
public class CuponController {
 
       CuponDao log;
    
    public boolean registrarCupon(LocalDate v_expira, int v_id, double v_descuento, boolean v_usado){
        if (log.buscarUsados().size()==50){
        Cupon c = new Cupon(v_expira,v_id, v_descuento, v_usado);
        log.registrarCupon(c);
        return true;
        
        }else 
            return false;
    }
    
    public List <Cupon> listar(){
    List <Cupon> all = log.buscarTodos();
    return all;
    }
    
    
    public List<Cupon> listaUsados(){
    
    List<Cupon> usados =log.buscarUsados();
    
    return usados;
    }
    
    
}
