/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.punto_venta.BL.Dao;

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

    //Daos
    public abstract IAdministradorDao getAdministradorDao();
    public abstract IAeropuertoDao getAeropuertoDao();
    public abstract IUsuarioDao getUsuarioDao();
    public abstract ITripulanteDao getTripulanteDao();
    public abstract ITripulacionDao getTripulacionDao();
    public abstract IAerolineaDao getAerolineaDao();
    public abstract IGatesDao getGatesDao();
    public abstract IAvionDao getAvionDao();
    public abstract IVuelosDao getVuelosDao();
    public abstract IPaisDao getPaisDao();
    
}
