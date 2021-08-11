package model.dao;

import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.JDBCUtilities;
import model.vo.ProyectoRankeadoCompras;

public class ProyectoRankeadoComprasDao {

    //Obtener los 10 proyectos rankeados según las compras
    public ArrayList<ProyectoRankeadoCompras> rankingProyectosComprasDescendente10() throws SQLException {

        ArrayList<ProyectoRankeadoCompras> respuesta = new ArrayList<ProyectoRankeadoCompras>();
        Connection conexion = null;        

        try{
            conexion = JDBCUtilities.getConnection();

            String consulta = "SELECT  p.ID_Proyecto, "+
                                        "p.Clasificacion, "+
                                        "sum( c.Cantidad * m.Precio_Unidad ) as Gasto_Compras, "+
                                        "p.Serial "+
                                "FROM Proyecto p "+
                                "JOIN Compra c ON "+
                                "p.ID_Proyecto = c.ID_Proyecto "+
                                "JOIN MaterialConstruccion m ON "+
                                "c.ID_MaterialConstruccion = m.ID_MaterialConstruccion "+
                                "GROUP BY p.ID_Proyecto "+
                                "ORDER BY Gasto_Compras DESC "+
                                "LIMIT 10";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                ProyectoRankeadoCompras proyecto = new ProyectoRankeadoCompras();
                //proyecto.setIdProyecto(resultSet.getInt("ID_Proyecto"));
                proyecto.setIdProyecto(resultSet.getInt(1));
                proyecto.setClasificacion(resultSet.getString("Clasificacion"));
                proyecto.setGastoCompras(resultSet.getInt("Gasto_Compras"));
                proyecto.setSerial(resultSet.getString("Serial"));

                respuesta.add(proyecto);
            }

            //Abiertas esas interacciones con BD
            resultSet.close();
            statement.close();


        }catch(SQLException e){
            System.err.println("Error consultando los proyectos rankeados por compras! "+e);
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar colección de vo's que satisfacen el requerimiento
        return respuesta;
        
        
    } 
    
}
