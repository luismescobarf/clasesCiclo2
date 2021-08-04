package model.dao;

import model.vo.Lider;
import util.JDBCUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LiderDao {

    //DAO -> CRUD -> Create Read Update Delete

    //Consultar todos los líderes
    public ArrayList<Lider> consultarTodos() throws SQLException {
        //Preparo contenedor de la respuesta
        ArrayList<Lider> respuesta = new ArrayList<Lider>();
        //Preparo contenero de la conexión
        Connection conexion = null;

        try{
            //Crear la conexión
            conexion = JDBCUtilities.getConnection();
            //Crear objeto a partir de la consulta SQL
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Lider;");
            //Ejecutar la consulta y almacenar la respuesta en estructura de datos
            //tipo ResultSet (iterador)
            ResultSet resultSet = statement.executeQuery();

            //Recorrer estilo iterador la estructura de datos que aloja los registros
            //Se detiene cuando siguiente retorna falso!
            while(resultSet.next()){
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
            System.err.println("Error consultando todos los líderes: "+e);
        }finally{
            //Siempre debo cerrar la conexión con la base de datos si se logró
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar respuesta obtenida tras interactuar con la base de datos
        return respuesta;

    }

    //Consultar líder por id
    public Lider consultarLiderID(Integer idLider) throws SQLException {
        //Preparo contenedor de la respuesta
        Lider respuesta = new Lider();
        //Preparo contenero de la conexión
        Connection conexion = null;

        try{
            //Crear la conexión
            conexion = JDBCUtilities.getConnection();
            //Crear objeto a partir de la consulta SQL

            //Opción 1 armado de consulta
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Lider WHERE ID_Lider = "+idLider);

            // //Opción 2 armado de consulta
            // PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Lider WHERE ID_Lider = ?");
            // statement.setInt(1, idLider);

            //Ejecutar la consulta y almacenar la respuesta en estructura de datos
            //tipo ResultSet (iterador)
            ResultSet resultSet = statement.executeQuery();

            //Recorrer estilo iterador la estructura de datos que aloja los registros
            //Se detiene cuando siguiente retorna falso!
            if(resultSet.next()){                
                respuesta.setIdLider(resultSet.getInt("ID_Lider"));
                respuesta.setNombre(resultSet.getString("Nombre"));
                respuesta.setPrimerApellido(resultSet.getString("Primer_Apellido"));
                respuesta.setSegundoApellido(resultSet.getString("Segundo_Apellido"));
                respuesta.setSalario(resultSet.getInt("Salario"));
                respuesta.setClasificacion(resultSet.getDouble("Clasificacion"));                
            }else{
                respuesta = null;
            }

            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando líder por id: "+e);
        }finally{
            //Siempre debo cerrar la conexión con la base de datos si se logró
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar respuesta obtenida tras interactuar con la base de datos
        return respuesta;

    }

    //Insertar o guardar un líder en la base de datos

    //Actualizar un líder

    //Eliminar un líder


    
}
