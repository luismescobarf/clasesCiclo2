package controller;

import java.sql.SQLException;
import java.util.ArrayList;

//Model
import model.vo.Lider;
import model.dao.LiderDao;

public class ControladorProyectosConstruccion {

    //Alojar instancias de clases del modelo
    private final LiderDao liderDao;

    //Constructor
    public ControladorProyectosConstruccion(){
        this.liderDao = new LiderDao();
    }

    //Cada requerimiento solicitado -> Casos de Uso

    //Requerimiento 1 -> Listar todos los líderes
    public ArrayList<Lider> consultarTodosLideres() throws SQLException{
        return this.liderDao.consultarTodos();
    }

    //Requerimiento 10 -> Mostrar las compras que se realizan en diciembre
    
}
