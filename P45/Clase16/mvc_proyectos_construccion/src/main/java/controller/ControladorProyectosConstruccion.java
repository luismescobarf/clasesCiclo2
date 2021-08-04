package controller;

import model.vo.Lider;
import model.dao.LiderDao;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorProyectosConstruccion {
    
    private final LiderDao liderDao;

    public ControladorProyectosConstruccion(){
        this.liderDao = new LiderDao();
    }

    public ArrayList<Lider> consultarTodosLideres() throws SQLException {
        return this.liderDao.consultarTodos();
    }
    
    
}
