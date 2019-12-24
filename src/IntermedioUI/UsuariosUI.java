/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntermedioUI;

import Controllers.UsuarioController.UsuariosController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.time.LocalDate;

/**
 *
 * @author krisa
 */
public class UsuariosUI {
    
    UsuariosController  log = new UsuariosController ();
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
 
    public void MenuAfterLogin (int rol){//DEBE DE RECIBIR EL ROL DESPUES DE INICIO DE SESION , NECESITO DEVOLVER CON EL QUERY
        
        switch(rol){
        
            case 0:
        System.out.println("Bienvenido al sistema Punto Venta, ingrese la opcion deseada  ");
        System.out.println("1.  Registrar Empleado ");
        System.out.println("2.  Registrar Cliente ");
        System.out.println("3.  Listar Usuarios ");
        System.out.println("4.  Registrar Producto ");
        System.out.println("5.  Listar Producto ");
        System.out.println("6.  Registrar Puesto ");
        System.out.println("7.  Listar Puestos ");
        System.out.println("8.  Registrar Cupones ");
        System.out.println("9.  Listar Cupones  ");
        System.out.println("10.  Salir");
         
        
        break;
        
            case 1:
        System.out.println("Bienvenido al sistema Punto Venta, el perfil de empleado se encuentra en mantenimiento, gracias por su comprension   ");
        break;
        
        case 2:
        System.out.println("Bienvenido al sistema Punto Venta, ingrese la opcion deseada   ");
        System.out.println("5.  Nuestros Productos ");
        System.out.println("11.  Registrar Orden ");
        System.out.println("10.  Salir");
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
    } out.print("Algo salio mal ");

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
    } out.print("Algo salio mal ");

 }

 
//Imprime solamente los nombres Usuario, no muestra toda la informacion del mismo 
public void listarUsuarios(){
out.print("Los usuarios registrados hasta el momento son :  ");
    for (int i =0; i<log.listarUsuarios().size();i++){
    out.print(log.listarUsuarios().get(i).getV_usuario());
}
}        
 




public boolean ejecutarOpcion(int pdato) throws java.io.IOException {
        boolean salir=false;
        return salir;
    }
    
    
}
