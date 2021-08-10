package controller;

import model.vo.MaterialNacional;
import model.dao.MaterialNacionalDao;

import model.vo.ProyectoRankeadoCompras;
import model.dao.ProyectoRankeadoComprasDao;

import model.vo.CargoAsignacion;
import model.dao.CargoAsignacionDao;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorRequerimientosReto4 {
    
    private final MaterialNacionalDao materialNacionalDao;
    private final ProyectoRankeadoComprasDao proyectoRankeadoComprasDao;
    private final CargoAsignacionDao cargoAsignacionDao;

    public ControladorRequerimientosReto4(){
        this.materialNacionalDao = new MaterialNacionalDao();
        this.proyectoRankeadoComprasDao = new ProyectoRankeadoComprasDao();
        this.cargoAsignacionDao = new CargoAsignacionDao();
    }

    public ArrayList<MaterialNacional> consultarMaterialesNacionalesComprados() throws SQLException {
        return this.materialNacionalDao.topMaterialesNacionales();
    }

    public ArrayList<ProyectoRankeadoCompras> consultarProyectosComprasGranito() throws SQLException {
        return this.proyectoRankeadoComprasDao.topProyectosComprasGranito();
    }

    public ArrayList<CargoAsignacion> consultarCargosMenosAsignados() throws SQLException {
        return this.cargoAsignacionDao.cargosMenosAsignados();
    }    
    
    
}
