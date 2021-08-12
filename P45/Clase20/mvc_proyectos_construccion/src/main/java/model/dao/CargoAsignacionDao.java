package model.dao;

import java.util.ArrayList;

import util.JDBCUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import model.vo.CargoAsignacion;


public class CargoAsignacionDao {

    //Requerimiento 5 Reto 3

    //Los dos cargos que tienen menos proyectos asignados
    public ArrayList<CargoAsignacion> cargosMenosAsignados() throws SQLException {

        //Preparar la colección que tendrá la respuesta
        ArrayList<CargoAsignacion> respuesta = new ArrayList<CargoAsignacion>();

        //Declarar la conexión
        Connection conexion = null;

        //Intentar conectarnos y extraer la información de la base de datos para el requerimiento
        //Lógica -> Consulta SQL
        try{

            //Conectarse
            conexion = JDBCUtilities.getConnection();

            String consulta = "SELECT l.Cargo, "+
                                        "COUNT (p.ID_Proyecto) AS Numero_Proyectos "+
                                "FROM Proyecto p "+
                                "JOIN Lider l ON "+
                                "p.ID_Lider = l.ID_Lider "+
                                "GROUP BY l.Cargo "+
                                "ORDER BY Numero_Proyectos "+
                                "LIMIT 2 ";

            //Construir objeto que realizará la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            //Realizar propiamente la consulta
            ResultSet resultSet = statement.executeQuery();

            //Recorrerlo mientras tenga posiciones, o registros
            while(resultSet.next()){                
                CargoAsignacion cargo = new CargoAsignacion();
                cargo.setCargo(resultSet.getString("Cargo"));
                cargo.setNoProyectos(resultSet.getInt("Numero_Proyectos"));            
                
                respuesta.add(cargo);
            }

            resultSet.close();
            statement.close();


        }catch(SQLException e){
            System.err.println("Error consultando cargos menos asignado!! " + e);
            
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar la colección de materiales de producción nacional
        return respuesta;
        
    }

}
