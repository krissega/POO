/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntermedioUI;

import Controllers.OrdenController.OrdenController;
import Controllers.ProductosController.ProductosController;
import com.tupuntodeventa.BL.Usuarios.Usuario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 *
 * @author krisa
 */
public class OrdenUI {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
      ProductosController log = new ProductosController();
      OrdenController o = new OrdenController();
      ProductosUI p = new ProductosUI();
      
      public void registrarOrden(Usuario u)throws IOException{
     ArrayList<Integer>productos = new ArrayList<>();
     ArrayList<Integer>combos = null; 
        int id = u.getV_ID();//usuario
        int salir = -1 ;
        int id_platillo= -1;
        String tipo ="1";
        
     
        while(salir != 0) {
            p.Listar_Platillos();
            
            out.println("ingrese el id del  platillos que desea agregar");
            id_platillo =Integer.parseInt(in.readLine());
           
            productos.add(id_platillo);
            out.println(" SU ORDEN CONSISTE DE:");
            for (Integer idp : productos) {
                out.println(idp + " ");
            }
            out.println("Desea salir? para salir ingrese 0");
             salir=Integer.parseInt(in.readLine());
            
        
        }  o.datosOrden(tipo,id,id, combos, productos);
    
    
    
    }
    
   
    
    
}
