package model.dao;

import model.vo.Lider;
import java.util.ArrayList;
import util.JDBCUtilities;
import java.sql.Connection;
import java.sql.SQLException;
//Clase para construir objetos de consulta
import java.sql.PreparedStatement;
//Clase para manejar la respuesta de la BD -> Contenedor (iterador)
import java.sql.ResultSet;


public class LiderDao {

    //Operaciones CRUD -> Create Read Update Delete

    //Consultar todos los líderes (READ)
    public ArrayList<Lider> consultarTodos() throws SQLException {

        //Contenedor de la respuesta -> Colección de líderes
        ArrayList<Lider> respuesta = new ArrayList<Lider>();
        Connection conexion = null;

        try{
            conexion = JDBCUtilities.getConnection();
            //SELECT * FROM Lider;
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Lider");
            ResultSet resultSet = statement.executeQuery();

            //Moviendo apuntador por cada registro, cuando no hay más, retorna falso y se sale
            while(resultSet.next()){
                //Cargar el registro actual en un Value Object
                Lider lider = new Lider();
                lider.setIdLider(resultSet.getInt("ID_Lider"));
                lider.setNombre(resultSet.getString("Nombre"));
                lider.setPrimerApellido(resultSet.getString("Primer_Apellido"));
                lider.setSegundoApellido(resultSet.getString("Segundo_Apellido"));
                lider.setSalario(resultSet.getInt("Salario"));
                lider.setClasificacion(resultSet.getDouble("Clasificacion"));

                respuesta.add(lider);
            }

            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando líderes: "+e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }


        //Retornamos la colección de VO's obtenida de la BD (Vacía, con un VO o muchos)
        return respuesta;
    }
                            
    
}
