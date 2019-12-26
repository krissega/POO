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

    CuponDao log =  new CuponDao ();

    public boolean registrarCupon() {
        LocalDate expira = LocalDate.now();
        int id = 0;
        double desc = 0.15;
        boolean usado = false;
        boolean done = false;
        //SE NECESITA PREGUNTAR SI NUNCA SE HAN REGISTRADO CUPONES, ENTONCES SI ES 0 SE REGISTRAN 50NPOR PRIMERA VEZ SI NO VA A APLICAR LA VALIDACION DE LA ERS DEL EXAMEN 
        int cupones=log.buscarTodos().size();
        if (cupones ==0){
         for (int i = 0; i <= 50; i++) {
                Cupon c = new Cupon(expira.plusDays(i),id + i, desc, usado);
                c.setV_codigo();
                done = log.registrarCupon(c);
            }
        }else{ 
        int c_usados = log.buscarUsados(true).size();
        //pregunta que no existan cupones sin utilizar deben estar todos utilizados 
        if (c_usados == 50) {
            //Crea de un solo 50 cupones, cada vez que registre cupones los debera de crear de 50 en 50
            for (int i = 0; i <=50; i++) {
                Cupon c = new Cupon(expira.plusDays(i),id + i, desc, usado);
                c.setV_codigo();
                done = log.registrarCupon(c);
            }
        }
        }
        return done;
    }

    public List<Cupon> listar() {
        List<Cupon> all = log.buscarTodos();
        return all;
    }

    public List<Cupon> listaUsados() {

        List<Cupon> usados = log.buscarUsados(true);

        return usados;
    }

}
