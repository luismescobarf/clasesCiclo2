package controller;

import java.sql.SQLException;
import java.util.ArrayList;

//Model

//Requerimiento 3
import model.vo.BancoRankeadoAreaPromedio;
import model.dao.BancoRankeadoAreaPromedioDao;
//Requerimiento 1
import model.vo.ProyectoRankeadoCompras;
import model.dao.ProyectoRankeadoComprasDao;


public class ControladorRequerimientosReto4 {

    //Alojar objetos del modelo
    private final ProyectoRankeadoComprasDao proyectoRankeadoComprasDao;
    private final BancoRankeadoAreaPromedioDao bancoRankeadoAreaPromedioDao;

    //Constructor
    public ControladorRequerimientosReto4(){
        //Instanciamos los DAO      
        this.proyectoRankeadoComprasDao = new ProyectoRankeadoComprasDao();
        this.bancoRankeadoAreaPromedioDao = new BancoRankeadoAreaPromedioDao();        
    }

    //Cada requerimiento solicitado -> Casos de Uso    
    
    //Requerimiento 1 Reto3/Reto4
    public ArrayList<ProyectoRankeadoCompras> consultarProyectosCompras10() throws SQLException{
        return this.proyectoRankeadoComprasDao.rankingProyectosComprasDescendente10();
    }    

    //Requerimiento 3 Reto3/Reto4
    public ArrayList<BancoRankeadoAreaPromedio>  consultarBancosRankeadosAreaPromedio() throws SQLException{
        return this.bancoRankeadoAreaPromedioDao.rankingBancosAreaPromedioDescendente();
    }

    
}
