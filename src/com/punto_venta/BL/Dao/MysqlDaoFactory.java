/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punto_venta.BL.Dao;

import com.punto_venta.BL.Administrador.Administrador_Dao;
import com.punto_venta.BL.Cliente.Cliente_Dao;
import com.punto_venta.BL.Cupon.Cupon_Dao;
import com.punto_venta.BL.Empleado.Empleado_Dao;
import com.punto_venta.BL.Orden.Orden_Dao;
import com.punto_venta.BL.Producto.Producto_Dao;
import com.punto_venta.BL.Puesto.Puesto_Dao;
import com.punto_venta.BL.Usuario.Usuario_Dao;

/**
 *
 * @author krisa
 */
public class MysqlDaoFactory  extends DaoFactory{
    MysqlDaoFactory() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }


    public Administrador_Dao getAdministradorDao(){
        return new MysqlAdministradorDao();
    };
    
    public abstract Cliente_Dao getClienteDao();
    public abstract Empleado_Dao getEmpleadoDao();
    public abstract Usuario_Dao getUsuarioDao();
    public abstract Producto_Dao getProductoDao();
    public abstract Puesto_Dao getPuestoDao();
    public abstract Orden_Dao getOrdenDao();
    public abstract Cupon_Dao getCuponDao();

}
