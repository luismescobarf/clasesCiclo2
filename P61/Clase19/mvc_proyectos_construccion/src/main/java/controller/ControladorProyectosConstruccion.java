package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.BancoRankeadoAreaPromedio;
//Model
import model.vo.Lider;
import model.dao.BancoRankeadoAreaPromedioDao;
import model.dao.LiderDao;

public class ControladorProyectosConstruccion {

    //Alojar instancias de clases del modelo
    private final LiderDao liderDao;
    private final BancoRankeadoAreaPromedioDao bancoRankeadoAreaPromedioDao;

    //Constructor
    public ControladorProyectosConstruccion(){
        this.liderDao = new LiderDao();
        this.bancoRankeadoAreaPromedioDao = new BancoRankeadoAreaPromedioDao();
    }

    //Cada requerimiento solicitado -> Casos de Uso

    //Requerimiento 1 -> Listar todos los líderes
    public ArrayList<Lider> consultarTodosLideres() throws SQLException{
        return this.liderDao.consultarTodos();
    }

    //Requerimiento 10 -> Mostrar las compras que se realizan en diciembre

    //Requerimiento 3 Reto3/Reto4
    public ArrayList<BancoRankeadoAreaPromedio> requerimiento3() throws SQLException{
        return this.bancoRankeadoAreaPromedioDao.consultarBancosAreaPromedioDesc();
    }

    
}
