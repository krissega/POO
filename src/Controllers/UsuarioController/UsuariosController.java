/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.UsuarioController;

import com.tupuntodeventa.BL.Usuarios.Administrador;
import com.tupuntodeventa.BL.Usuarios.Cliente;
import com.tupuntodeventa.BL.Usuarios.Empleado;
import com.tupuntodeventa.BL.Usuarios.Usuario;
import com.tupuntodeventa.BL.Usuarios.UsuarioDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author krisa
 */
public class UsuariosController {
  UsuarioDAO log = null;


//******************************USUARIO ADMINISTRADOR, REGISTRA,VALIDAR*************************************************************************    
public boolean registrar_Admin(int v_rol, int v_ID, String v_correo, String v_pass, String v_usuario, String v_nombre, LocalDate v_fechanac, String genero, String v_telefono){
Administrador admin = new Administrador (v_rol, v_ID, v_correo, v_pass, v_usuario, v_nombre, v_fechanac, genero, v_telefono);
if (log.buscarTodos().contains(admin)){
    return false;
}else log.registrarUsuario(admin);
return true;
}

public boolean validarAdmin(){
return log.verificarAdmin();
}
    
//******************************USUARIO CLIENTE, REGISTRAR,BUSCAR,LISTAR*************************************************************************    
public boolean registrarCliente(String v_direcciones, int v_rol, int v_ID, String v_correo, String v_pass, String v_usuario, String v_nombre, LocalDate v_fechanac, String genero, String v_telefono){
Cliente cli= new Cliente (v_direcciones,v_rol, v_ID, v_correo, v_pass, v_usuario, v_nombre, v_fechanac, genero, v_telefono);

List <Usuario> temp =listarUsuarios();
if (temp.contains(cli)){
    return false;
}else log.registrarUsuario(cli);
return true;



}    


public boolean registrarEmpleado(String v_puesto, int v_salbase, double v_bonus, int v_netsal, LocalDate v_inicia, int v_rol, int v_ID, String v_correo, String v_pass, String v_usuario, String v_nombre, LocalDate v_fechanac, String genero, String v_telefono){
    Empleado emp = new Empleado (v_puesto,v_salbase,v_bonus,v_netsal, v_inicia, v_rol, v_ID, v_correo, v_pass, v_usuario, v_nombre, v_fechanac,genero,v_telefono);

    List <Usuario> temp =listarUsuarios();
if (temp.contains(emp)){
    return false;
}else log.registrarUsuario(emp);
return true;
    
    
    
    
}
public List<Usuario> listarUsuarios(){
    List<Usuario> all= log.buscarTodos();  
    return all;
}
    
// necesito arreglarlo para me me devuelva el rol !!
public boolean  IniciarSesion(String usuario,String pass){
    return log.autenticar(usuario, pass);
}





}
