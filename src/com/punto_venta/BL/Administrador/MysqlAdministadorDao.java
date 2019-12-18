/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punto_venta.BL.Administrador;

import java.util.ArrayList;

/**
 *
 * @author krisa
 */
public class MysqlAdministadorDao implements Administrador_Dao{
 
 @Override
 public String add(Administrador administrador)throws Exception {
       String sql;
       /* String[] v_temp = administrador.getV_nombre();
        String v_n= v_temp[0];
        String v_p1= v_temp[1];
        String v= v_temp[2];
        */
       
        try {
            sql = "INSERT INTO usuarios (key,id,correo,pass,usuario,nombre,fechanac,edad,genero,telefono) " +
                    "VALUES( " +
                    "'"+administrador.getV_key_type() +"', "+
                    "'"+administrador.getV_ID()+"', "+
                    "'"+administrador.getV_correo() +"', "+
                    "'"+administrador.getV_pass() +"', "+
                    "'"+administrador.getV_usuario()+"', "+
                    "'"+administrador.getV_nombre()+"', "+// el nombre
                    "'"+administrador.getV_fechanac()+"', "+
                    "'"+administrador.getV_edad()+"', "+
                    "'"+administrador.getGenero()+"', "+
                    "'"+administrador.getV_telefono()+"', "+"');";
                     System.out.println(sql);
            Conector.getConnector().ejecutarSql(sql);
        }catch (Exception ex){
            throw ex;
        }
        return "Administrador agregado con exito.";
    }




    public Administrador get()  {

            Administrador v_admin;
            String sql;
            try{
                ResultSet rs = null;
                Administrador administrador = null;
                sql = "select key,id,correo,pass,usuario,nombre, fecha_nacimiento, floor(TIMESTAMPDIFF(MONTH, fecha_nacimiento, CURDATE())/12) AS age,edad,genero,telefono" +
                        " from usuarios where tipo_usuarios_id = admin;";
                rs = Conector.getConnector().ejecutarQuery(sql);

                
                                    v_admin= new Administrador(
                                    rs.getInt("key"),
                                    rs.getInt("id"),
                                    rs.getString("correo"),
                                    rs.getString("pass"),
                                    rs.getString("usuario"),
                                    rs.getString("nombre"),
                                    rs.getDate("fecha_nacimiento").toLocalDate(),
                                    rs.getInt("age"),
                                    rs.getString("genero"),
                                    rs.getString("telefono")
                                   
                            );
                  

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return v_admin;

    }

    @Override
    public boolean exists() throws Exception {
        String sql;
        try{
            ResultSet rs = null;
            Administrador administrador = null;
            sql = "Select usuario as administrador\n" +
                    "from usuarios \n" +
                    "where usuarios.key = admin;";

            rs = Conector.getConnector().ejecutarQuery(sql);
            if(rs.next()){
                if(Integer.parseInt(rs.getString("administrador")) > 0){
                    return true;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }






    @Override
    public Administrador getById(int id) throws Exception {
       Administrador administrador = null;
        String sql;
        try{
            ResultSet rs = null;
            sql = "select key,id,correo,pass,usuario,nombre, fecha_nacimiento, floor(TIMESTAMPDIFF(MONTH, fecha_nacimiento, CURDATE())/12) AS age,edad,genero,telefono" +
                    " from usuarios where id = "+id+";";
            rs = Conector.getConnector().ejecutarQuery(sql);
            Administrador v_ad;
            while(rs.next()){
                           
                          v_ad= new Administrador(
                                    rs.getInt("key"),
                                    rs.getInt("id"),
                                    rs.getString("correo"),
                                    rs.getString("pass"),
                                    rs.getString("usuario"),
                                    rs.getString("nombre"),
                                    rs.getDate("fecha_nacimiento").toLocalDate(),
                                    rs.getInt("age"),
                                    rs.getString("genero"),
                                    rs.getString("telefono")
                                   
                            );
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v_ad;
    }



    @Override
    public String deleteById(int idDB) throws Exception {
        String sql;
        try {
            sql = "DELETE FROM aeropuertos WHERE id_usuario_admin = "+idDB+";";
            Conector.getConnector().ejecutarSql(sql);
            sql = "DELETE FROM usuarios WHERE id = "+idDB+";";
            System.out.println(sql);
            Conector.getConnector().ejecutarSql(sql);
        }catch (Exception ex){
            throw ex;
        }
        return "Administrador eliminado con exito.";
    }

   



    
}
