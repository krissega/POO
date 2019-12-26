/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntermedioUI;

import Controllers.ProductosController.ProductosController;
import static IntermedioUI.UsuariosUI.in;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.time.LocalDate;

/**
 *
 * @author krisa
 */
public class ProductosUI {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    ProductosController log = new ProductosController();

    public void RegistrarProducto() throws IOException {

        out.println("Que tipo de producto desea registrar ? Indique 0 para platillo, o bien 1 para combo  ");
        int v_op = Integer.parseInt(in.readLine());
        switch (v_op) {
            case 0:
                out.println("Usted eligio la opcion de registrar platillo  ");
                registrarPlatillo();
                break;

            case 1:
                out.println("Usted eligio la opcion de registrar Combo  ");
                registrarCombo();
                break;

            default:
                out.println("El valor ingresa es invalido ");

        }
    }
    
    
    public void listar_Productos(){
    out.println("Los productos se listaran de la siguiente manera, primero los platillos, luego los combos ");
    Listar_Platillos();
    Listar_Combos();
    }
    

 
       public void registrarPlatillo() throws IOException {
        out.println("Ingrese el nombre ");
        String v_nombre = in.readLine();
        out.println("Ingrese la descripcion ");
        String v_descripcion = in.readLine();
        out.println("Ingrese el precio ");
        double v_precio = Double.parseDouble(in.readLine());
        log.registrarPlatillo(v_nombre, v_descripcion, v_precio);

    }

  public void Listar_Platillos() {

        out.println("Los Platillos registrados hasta el momento son :  ");
        for (int i = 0; i < log.listarP().size(); i++) {
            out.println(log.listarP().get(i).getV_nombre() + "  " + log.listarP().get(i).getV_precio());
        }

    }
    
    public void registrarCombo() throws IOException {
        out.println("Usted eligio la opcion de registrar Combo  ");
        out.println("Ingrese el identificador del combo ");
        int c_id = Integer.parseInt(in.readLine());
        out.println("Ingrese el nombre ");
        String c_nombre = in.readLine();
        out.println("Ingrese el precio ");
        double c_precio = Double.parseDouble(in.readLine());
        //log.registrarCombo(c_id,c_nombre,c_precio);

    }
    
     public void Listar_Combos() {

        out.println("Los Combos registrados hasta el momento son :  ");
        for (int i = 0; i < log.listarC().size(); i++) {
            out.print(log.listarC().get(i).getNombre() + "  " + log.listarC().get(i).getPrecio());
        }

    }
    
 







}
