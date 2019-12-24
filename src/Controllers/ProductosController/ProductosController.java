/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.ProductosController;

import com.tupuntodeventa.BL.Prod.ComboDao;
import com.tupuntodeventa.BL.Prod.Platillo;
import com.tupuntodeventa.BL.Prod.PlatilloDAO;

import java.util.List;

/**
 *
 * @author krisa
 */
public class ProductosController {
    
    PlatilloDAO log;
    ComboDao cob;    
    public boolean registrarPlatillo(int v_ID, String v_nombre, String v_descripcion, double v_precio){
        Platillo p = new Platillo(v_ID, v_nombre,v_descripcion, v_precio);
        log.registrarPlatillo(p);
        return true;
    }
    
    
    public List <Platillo> listarP(){
    List <Platillo> all = log.buscarTodos();
    return all;
    }
       
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
