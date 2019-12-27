/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.UsuarioController;

import com.tupuntodeventa.BL.Direccion.Direccion;
import com.tupuntodeventa.BL.Puestos.Puesto;
import com.tupuntodeventa.BL.Usuarios.Administrador;
import com.tupuntodeventa.BL.Usuarios.Cliente;
import com.tupuntodeventa.BL.Usuarios.Empleado;
import com.tupuntodeventa.BL.Usuarios.Usuario;
import com.tupuntodeventa.BL.Usuarios.UsuarioDAO;
import com.tupuntodeventa.BL.Puestos.PuestoDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author krisa
 */
public class UsuariosController {

    UsuarioDAO log = new UsuarioDAO();
    PuestoDAO plog = new  PuestoDAO();

//******************************USUARIO ADMINISTRADOR, REGISTRA,VALIDAR*************************************************************************    
    public boolean registrar_Admin(int v_rol, int v_ID, String v_correo, String v_pass, String v_usuario, String v_nombre, String v_apellido, String v_segundoapellido, LocalDate v_fechanac, String genero, String v_telefono, String identificacion) {
        Administrador admin = new Administrador(v_rol, v_ID, v_correo, v_pass, v_usuario, v_nombre, v_apellido, v_segundoapellido, v_fechanac, genero, v_telefono, identificacion);
        int flag = admin.getV_edad();
        if (log.buscarTodos().contains(admin)||flag<18) {
            return false;
        } else {
            log.registrarUsuario(admin);
        }
        return true;
    }

    public boolean validarAdmin() {
        return log.verificarAdmin();
    }

//******************************USUARIO CLIENTE, REGISTRAR,BUSCAR,LISTAR*************************************************************************    
    public Direccion registrar_direccion(String direccionExacta, String canton, String distrito, String provincia, int distancia, int usuarioId) {
        Direccion dir = new Direccion(direccionExacta, canton, distrito, provincia, distancia, usuarioId);
        return dir;
    }

    public boolean registrarCliente(String direccionExacta, String canton, String distrito, String provincia, int distancia, int usuarioId, int v_rol, int v_ID, String v_correo, String v_pass, String v_usuario, String v_nombre, String v_apellido, String v_segundoapellido, LocalDate v_fechanac, String genero, String v_telefono, String identificacion) {
        ArrayList<Direccion> v_direcciones = new ArrayList<>();
        Direccion v_1 = new Direccion(direccionExacta, canton, distrito, provincia, distancia, usuarioId);
        v_direcciones.add(v_1);
        Cliente cli = new Cliente(v_direcciones, v_rol, v_ID, v_correo, v_pass, v_usuario, v_nombre, v_apellido, v_segundoapellido, v_fechanac, genero, v_telefono, identificacion);
        List<Usuario> temp = listarUsuarios();
        if (temp.contains(cli)||cli.getV_edad()<15) {
            return false;
        } else {
            log.registrarCliente(cli, v_1);
        }
        return true;
    }

    public boolean registrarEmpleado(String v_puesto, int v_salbase, double v_bonus, LocalDate v_inicia, int v_rol, int v_ID, String v_correo, String v_pass, String v_usuario, String v_nombre, String v_apellido, String v_segundoapellido, LocalDate v_fechanac, String genero, String v_telefono, String identificacion) {
        int v_netsal = v_salbase + (int) v_bonus;
        Empleado emp = new Empleado(v_puesto, v_salbase, v_bonus, v_netsal, v_inicia, v_rol, v_ID, v_correo, v_pass, v_usuario, v_nombre, v_apellido, v_segundoapellido, v_fechanac, genero, v_telefono, identificacion);

        List<Usuario> temp = listarUsuarios();
        if (temp.contains(emp)) {
            return false;
        } else {
            log.registrarUsuario(emp);
        }
        return true;
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> all = log.buscarTodos();
        return all;
    }

// Devuelve un usuario!!
    public Usuario IniciarSesion(String usuario, String pass) {
        return log.autenticar(usuario, pass);
    }
    
    
 public boolean registrarPuesto(String puesto, String descrip){
     Puesto p = new Puesto (puesto,descrip);
     return plog.registrarPuesto(p);
 
 
 }   

 public List<Puesto>listarPuestos(){
 List<Puesto>all = plog.buscarTodos();
 return all;
 }
 

public List<String> listarNombreUsuarios() {
        List<Usuario> temp = log.buscarTodos();
        List<String>all = new ArrayList<>();
        for (int i=0;i<temp.size();i++){
            all.add(temp.get(i).getV_usuario());
        }
        
        
        return all;
    }



}
