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
public class MysqlDaoFactory {
    
    public MysqlDaoFactory() {
    }


    public IAdministradorDao getAdministradorDao() {
        return new MysqlAdministradorDao();
    }

    public IAeropuertoDao getAeropuertoDao() {
        return new MysqlAeropuertoDao();
    }

    public IUsuarioDao getUsuarioDao() { return new MysqlUsuarioDao(); }

    public ITripulanteDao getTripulanteDao() {
        return new MysqlTripulanteDao();
    }

    public ITripulacionDao getTripulacionDao() {
        return new MysqlTripulacionDao();
    }

    public IAerolineaDao getAerolineaDao() {
        return new MysqlAerolineaDao();
    }

    public IGatesDao getGatesDao() {
        return new MysqlGatesDao();
    }

    public IAvionDao getAvionDao() {
        return new MysqlAvionDao();
    }

    public IVuelosDao getVuelosDao() {
        return new MysqlVuelosDao();
    }

    @Override
    public IPaisDao getPaisDao() {
        return new MysqlPaisDao();
    }
}
