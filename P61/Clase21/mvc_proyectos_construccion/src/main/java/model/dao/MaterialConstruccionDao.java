package model.dao;

import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.JDBCUtilities;
import model.vo.MaterialConstruccion;

public class MaterialConstruccionDao {

    //Consultar todos (READ)
    public ArrayList<MaterialConstruccion> consultarTodos() throws SQLException {

        ArrayList<MaterialConstruccion> respuesta = new ArrayList<MaterialConstruccion>();
        Connection conexion = null;        

        try{
            conexion = JDBCUtilities.getConnection();

            String consulta = "SELECT * FROM MaterialConstruccion;";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                MaterialConstruccion material = new MaterialConstruccion();
                material.setIdMaterialConstruccion(resultSet.getInt(1));
                material.setNombreMaterial(resultSet.getString(2));
                material.setImportado(resultSet.getString(3));
                material.setPrecioUnidad(resultSet.getInt(4));                              
                respuesta.add(material);
            }

            //Abiertas esas interacciones con BD
            resultSet.close();
            statement.close();


        }catch(SQLException e){
            System.err.println("Error consultando todos los materiales! "+e);
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar colección de vo's que satisfacen el requerimiento
        return respuesta;        
    }

    //Insertar material (Create)

    //Eliminar material (Delete)

    //Actualizar material (Update)

    
    
    
}
