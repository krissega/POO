/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.ProductosController;

import com.tupuntodeventa.BL.Prod.Combo;
import com.tupuntodeventa.BL.Prod.ComboDAO;
import com.tupuntodeventa.BL.Prod.Platillo;
import com.tupuntodeventa.BL.Prod.PlatilloDAO;

import java.util.List;

/**
 *
 * @author krisa
 */
public class ProductosController {
    
    PlatilloDAO log = new PlatilloDAO();
    ComboDAO cob = new ComboDAO();    
    public boolean registrarPlatillo(String v_nombre, String v_descripcion, double v_precio){
        Platillo p = new Platillo(v_nombre,v_descripcion, v_precio);
        log.registrarPlatillo(p);
        return true;
    }
    
    
    public List <Platillo> listarP(){
    List <Platillo> all = log.buscarTodos();
    return all;
    }
    
    
    public List <Combo> listarC(){
    List <Combo> all = cob.buscarTodos();
    return all;
    }
    
    
       
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
