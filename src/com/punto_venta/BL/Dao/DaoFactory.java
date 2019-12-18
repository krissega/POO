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
public abstract class DaoFactory {
   
    
    
     public static final int MYSQL = 1;
    public static final int SQLSERVER = 2;
    public static final int ORACLE = 3;

    public static DaoFactory getDaoFactory(int factory) {
        switch (factory) {
            case MYSQL:
                return new MysqlDaoFactory();
            case SQLSERVER:
                return new SqlServerDaoFactory();
            case ORACLE:
                return new OracleDaoFactory();
            default:
                return null;

        }
    }

    
    public abstract Administrador_Dao getAdministradorDao();
    public abstract Cliente_Dao getClienteDao();
    public abstract Empleado_Dao getEmpleadoDao();
    public abstract Usuario_Dao getUsuarioDao();
    public abstract Producto_Dao getProductoDao();
    public abstract Puesto_Dao getPuestoDao();
    public abstract Orden_Dao getOrdenDao();
    public abstract Cupon_Dao getCuponDao();
    
  
    
}
