/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntermedioUI;

import Controllers.UsuarioController.UsuariosController;
import static java.lang.System.in;
import java.util.ArrayList;

/**
 *
 * @author krisa
 */
public class UsuariosUI {
    
   UsuariosController  log;
    public void MenuGeneral (){//DEBE DE RECIBIR EL ROL DESPUES DE INICIO DE SESION , NECESITO DEVOLVER CON EL QUERY
        int Rol=0;  // DEBE DE nicioSesion();
        switch(Rol){
        
            case 1:
        System.out.println("Bienvenido al sistema Punto Venta, ingrese la opcion deseada  ");
        System.out.println("1.  Registrar Empleado ");
        System.out.println("2.  Listar Usuarios ");
        System.out.println("3.  Registrar Producto ");
        System.out.println("4.  Listar Producto ");
        System.out.println("5.  Registrar Puesto ");
        System.out.println("6.  Listar Puestos ");
        System.out.println("7.  Registrar Cupones ");
        System.out.println("8.  Salir");
        
        break;
        
            case 2:
        System.out.println("Bienvenido al sistema Punto Venta, ingrese la opcion deseada   ");
        System.out.println("1.  Registrar Orden ");
        System.out.println("8.  Salir");
        
        break;
        
        
            case 3:
               
        System.out.println("Bienvenido al sistema Punto Venta, ingrese la opcion deseada   ");
        System.out.println("1.  Nuestros Productos ");
        System.out.println("1.  Registrar Orden ");
        System.out.println("8.  Salir");
        break;
        
        }
  
        
       }
    
    public void MenuCliente(){
    }
    
    public void MenuEmpleado(){
    }
    
    
        public static void imprimirMen() {
        System.out.println("1.  Registrar Empleados ");
        System.out.println("2.  Registrar Profesores ");
        System.out.println("3.  Registrar Carrera ");
        System.out.println("4.  Listar Carreras ");
        System.out.println("5.  Registrar Cursos ");
        System.out.println("6.  Listar Cursos ");
        System.out.println("7.  Registrar Laboratorio");
        System.out.println("8.  Listar Laboratorios ");
        System.out.println("9.  Eliminar Laboratorio ");
        System.out.println("10.  Salir ");

    }

  

  public int leerOpcion() throws java.io.IOException {

        System.out.print("Seleccione su opcion : ");
        int opcion = Integer.parseInt(in.readLine());
        return opcion;
    }

    public boolean ejecutarOpcionMenu(int pdato) throws java.io.IOException {
        boolean salir=false;
        switch (pdato) {
            case 1:
            case 10:
                 salir=true;
            default:
                System.out.println("LA OPCION INGRESADA ES INAVLIDA, FAVOR INGRESAR UNA OPCION DEL MENU ");

        }
     return salir;
    }
    
    
}
