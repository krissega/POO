/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntermedioUI;

import Controllers.CuponController.CuponController;
import Controllers.UsuarioController.UsuariosController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author krisa
 */
public class UsuariosUI {
    ProductosUI p = new ProductosUI();
    OrdenUI o = new  OrdenUI();
    UsuariosController  log = new UsuariosController ();
    CuponController c = new CuponController();
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

   
    public void iniciarSesion(String u, String p) throws IOException{
     if (log.IniciarSesion(u,p) == null) {
            do {
                System.out.println("Nombre de usuario o clave incorrecta");
                System.out.println("Ingrese un nombre de usuario: ");
                u = in.readLine();
                System.out.println("Ingrese la clave:");
                p = in.readLine();
            
                
            } while (log.IniciarSesion(u,p) == null);
        }
        
     int rol= log.IniciarSesion(u, p).getV_rol();
    
        MenuAfterLogin(rol);
    } 
 
    public void MenuAfterLogin (int rol) throws IOException{//DEBE DE RECIBIR EL ROL DESPUES DE INICIO DE SESION , NECESITO DEVOLVER CON EL QUERY
        
        int v_option=0;
        switch(rol){
        
            case 0:
                
        do{
        System.out.println("Bienvenido al sistema Punto Venta, ingrese la opcion deseada  ");
        System.out.println("1.  Registrar Empleado ");
        System.out.println("2.  Registrar Cliente ");
        System.out.println("3.  Listar Usuarios ");
        System.out.println("4.  Registrar Producto ");
        System.out.println("5.  Listar Productos ");
        System.out.println("6.  Registrar Puesto ");
        System.out.println("7.  Listar Puestos ");
        System.out.println("8.  Registrar Cupones ");
        System.out.println("9.  Listar Cupones  ");
        System.out.println("10.  Salir");
        v_option=Integer.parseInt(in.readLine());
          ejecutarOpcion(v_option);
        }while (v_option != 10);
        
        
        break;
        
            case 1:
        System.out.println("Bienvenido al sistema Punto Venta, el perfil de empleado se encuentra en mantenimiento, gracias por su paciencia    ");
        break;
        
        case 2:
        System.out.println("Bienvenido al sistema Punto Venta, ingrese la opcion deseada   ");
        System.out.println("5.  Nuestros Productos ");
        System.out.println("11.  Registrar Orden ");
        System.out.println("10.  Salir");
         v_option=Integer.parseInt(in.readLine());
        break;
        
        }
  
        ejecutarOpcion(v_option);
        
    }
    
    ////////EJECUCION DE LA OPCION INGRESADA 
      
   public void ejecutarOpcion(int v_opcion) throws java.io.IOException {
    switch(v_opcion){
        case 1:
            registrarEmpleado();
            break;
            
             case 2:
                 registrarCliente();
            break;
             case 3:
                 listarUsuarios();
            break;
             case 4:
                 p.RegistrarProducto();
            break;
             case 5:
                 p.listar_Productos();
            break;
             case 6:
                 registrarPuesto();
            break;
             case 7:
                 listarPuestos();
            break;
             case 8:
                 crearCupones();
            break;
             case 9:
                listarCupones();
                 break;
            case 10:
            break;
             case 11:
                 o.registrarOrden();
            break;
             default:
                 break;
    
    
    
    
  }    
       
    
    
   
}
    
    
    
    
 public void registrarAdministrador()throws IOException{
 
   int v_rol=0;
    System.out.println("Ingrese su numero de ID ");
   String identificacion =in.readLine();
    System.out.println("Ingrese su correo ");
    String v_correo=in.readLine();
    System.out.println("Ingrese su contrasena  ");
    String v_pass = in.readLine() ;
    System.out.println("Ingrese su nombre de usuario  ");
    String v_usuario = in.readLine();
   System.out.println("Ingrese su  Nombre ");
    String v_nombre = in.readLine();
    System.out.println("Ingrese su  Primer Apellido ");
    String v_apellido  = in.readLine();
    System.out.println("Ingrese su  Segundo Apellido ");
    String v_segundo_apellido = in.readLine();
    System.out.println("Ingrese su  fecha de nacimiento en el siguiente formato YYYY-MM-DD ");
    LocalDate v_fechanac  = LocalDate.parse(in.readLine());
    System.out.println("Ingrese su   genero ");
    String genero  = in.readLine();
    System.out.println("Ingrese su  numero telefonico ");
    String v_telefono  = in.readLine();
    if(log.registrar_Admin(v_rol, 0, v_correo, v_pass, v_usuario, v_nombre, v_apellido, v_segundo_apellido, v_fechanac, genero, v_telefono, identificacion)){
    out.print("Administrador Registrado con exito");
    }else  out.print("Algo salio mal ");
}       
        
public void registrarEmpleado()throws IOException{
   int v_rol=1;
    System.out.println("Ingrese el numero de ID ");
   String identificacion =in.readLine();
    System.out.println("Ingrese el  correo ");
    String v_correo=in.readLine();
    System.out.println("Ingrese la  contrasena  ");
    String v_pass = in.readLine() ;
    System.out.println("Ingrese el  nombre de usuario  ");
    String v_usuario = in.readLine();
   System.out.println("Ingrese el  Nombre ");
    String v_nombre = in.readLine();
    System.out.println("Ingrese el   Primer Apellido ");
    String v_apellido  = in.readLine();
    System.out.println("Ingrese el  Segundo Apellido ");
    String v_segundo_apellido = in.readLine();
    System.out.println("Ingrese la  fecha de nacimiento en el siguiente formato DD-MM-YYYY ");
    LocalDate v_fechanac  = LocalDate.parse(in.readLine());
    System.out.println("Ingrese el   genero ");
    String genero  = in.readLine();
    System.out.println("Ingrese el  numero telefonico ");
    String v_telefono  = in.readLine();
  //datos del salario del empleado 
    System.out.println("Ingrese la fecha de inicio de contrato en el siguiente formato DD-MM-YYYY ");
    LocalDate v_inicio  = LocalDate.parse(in.readLine());
    System.out.println("Ingrese el  puesto ");
    String v_puesto  = in.readLine();
    System.out.println("Ingrese el salario base ");
    int  v_base   =Integer.parseInt(in.readLine());
    System.out.println("Ingrese el bono");
    double v_bono  =Double.parseDouble(in.readLine());
  if(log.registrarEmpleado(v_puesto, v_base, v_bono, v_inicio, v_rol, 0, v_correo, v_pass, v_usuario, v_nombre, v_apellido, v_segundo_apellido, v_fechanac, genero, v_telefono, identificacion)){
    out.print("Empleado registrado con exito");
    } else out.print("Algo salio mal ");

}

 public void registrarCliente()throws IOException{
 
   int v_rol=0;
    System.out.println("Ingrese el  numero de ID ");
   String identificacion =in.readLine();
    System.out.println("Ingrese el correo ");
    String v_correo=in.readLine();
    System.out.println("Ingrese la  contrasena  ");
    String v_pass = in.readLine() ;
    System.out.println("Ingrese el  nombre de usuario  ");
    String v_usuario = in.readLine();
   System.out.println("Ingrese el Nombre ");
    String v_nombre = in.readLine();
    System.out.println("Ingrese el   Primer Apellido ");
    String v_apellido  = in.readLine();
    System.out.println("Ingrese el  Segundo Apellido ");
    String v_segundo_apellido = in.readLine();
    System.out.println("Ingrese la  fecha de nacimiento en el siguiente formato DD-MM-YYYY ");
    LocalDate v_fechanac  = LocalDate.parse(in.readLine());
    System.out.println("Ingrese el   genero ");
    String genero  = in.readLine();
    System.out.println("Ingrese el  numero telefonico ");
    String v_telefono  = in.readLine();
 ////////ESPACIO PARA LOS DATOS DE DIRECCION
   System.out.println("Ingrese la direccion exacta  ");
    String v_exacta = in.readLine();
    System.out.println("Ingrese el  canton ");
    String v_canton  = in.readLine();
    System.out.println("Ingrese la provincia ");
    String v_provincia  = in.readLine();
    System.out.println("Ingrese el distrito  ");
    String v_distrito= in.readLine();
    System.out.println("Ingrese la distancia ");
    int v_dist = Integer.parseInt(in.readLine());
  
    if(log.registrarCliente(v_exacta, v_canton, v_distrito, v_provincia, v_dist, 0, v_rol, 0, v_correo, v_pass, v_usuario, v_nombre, v_apellido, v_segundo_apellido, v_fechanac, genero, v_telefono, identificacion)){
    out.print("Registrado con exito");
    }else  out.print("Algo salio mal ");

 }

 
//Imprime solamente los nombres Usuario, no muestra toda la informacion del mismo 
public void listarUsuarios(){
    List <String> all= log.listarNombreUsuarios();
out.println("Los usuarios registrados hasta el momento son :  ");
    for (int i =0; i<all.size();i++){
    out.println(all.get(i));
}
}        

/////////////Funciones del registro de puestos 

public void registrarPuesto() throws IOException{
out.println("Ingrese el nombre del puesto a registrar ");
String v_puesto = in.readLine();
out.println("Ingrese la descripcion del puesto");
String v_descrip = in.readLine();
if (log.registrarPuesto(v_puesto, v_descrip)){
    out.print("Registrado con exito");
}else  out.print("Algo salio mal ");

}

public void listarPuestos(){
out.println("Los puestos  registrados hasta el momento son :  ");
    for (int i =0; i<log.listarPuestos().size();i++){
    out.println(log.listarPuestos().get(i).getV_puesto());
}
} 

public void crearCupones(){
    out.println("EL sistema automaticamente crea 50 cupones cada vez que utilice este metodo, no permitira que cree mas cupones hasta que todos los cupones sean utilizados ");
    if (c.registrarCupon()){
    out.println("Cupones creados con exito");
    listarCupones();
}else out.println("Se deben de utilizar todos los cupones registrados antes de crear nuevo, el total de cupones utilizados  son "+c.listaUsados().size());
    
}


public void listarCupones(){
out.print("Cupones registrados  :  ");
    for (int i =0; i<c.listar().size();i++){
    out.println(c.listar().get(i).getV_id()+" "+c.listar().get(i).getV_codigo()+" "+"Expira el : "+c.listar().get(i).getV_expira());
}

}




} 





