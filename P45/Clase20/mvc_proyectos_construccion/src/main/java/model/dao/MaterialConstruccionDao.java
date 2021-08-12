package model.dao;

import java.util.ArrayList;

import util.JDBCUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

//import model.vo.MaterialNacional;
import model.vo.MaterialConstruccion;


public class MaterialConstruccionDao {

    //Consultar todos los materiales de construcción
    public ArrayList<MaterialConstruccion> consultarTodos() throws SQLException {

        //Preparar la colección que tendrá la respuesta
        ArrayList<MaterialConstruccion> respuesta = new ArrayList<MaterialConstruccion>();

        //Declarar la conexión
        Connection conexion = null;

        //Intentar conectarnos y extraer la información de la base de datos para el requerimiento
        //Lógica -> Consulta SQL
        try{

            //Conectarse
            conexion = JDBCUtilities.getConnection();

            String consulta = "SELECT * FROM MaterialConstruccion;";

            //Construir objeto que realizará la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            //Realizar propiamente la consulta
            ResultSet resultSet = statement.executeQuery();

            //Recorrerlo mientras tenga posiciones, o registros
            while(resultSet.next()){                
                MaterialConstruccion material = new MaterialConstruccion();
                material.setIdMaterialConstruccion(resultSet.getInt(1));
                material.setNombreMaterial(resultSet.getString(2));
                material.setImportado(resultSet.getString(3));
                material.setPrecioUnidad(resultSet.getInt(4));
                
                respuesta.add(material);
            }

            resultSet.close();
            statement.close();


        }catch(SQLException e){
            System.err.println("Error consultando todos los materiales de construcción!! " + e);
            
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar la colección de materiales de producción nacional
        return respuesta;
        
    } 

    //Registrar nuevo material
    public MaterialConstruccion insertarMaterial(MaterialConstruccion nuevoMaterial) throws SQLException {

        //Declarar la conexión
        Connection conexion = null;

        //Intentar registrar nuevo material        
        try{

            //Conectarse
            conexion = JDBCUtilities.getConnection();

            String consulta =   "INSERT INTO MaterialConstruccion "+
                                "(Nombre_Material, Importado, Precio_Unidad) "+
                                "VALUES (?,?,?)";

            //Construir objeto que realizará la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nuevoMaterial.getNombreMaterial());
            statement.setString(2, nuevoMaterial.getImportado());
            statement.setInt(3, nuevoMaterial.getPrecioUnidad());

            //Realizar la inserción
            statement.executeUpdate();

            //Realizar el cierre
            statement.close();


        }catch(SQLException e){
            System.err.println("Error registrando nuevo material de construcción!! " + e);
            
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar la colección de materiales de producción nacional
        return nuevoMaterial;
        
    } 

    //Actualizar material de construcción
    public MaterialConstruccion actualizarMaterial(MaterialConstruccion nuevoMaterial) throws SQLException {

        //Declarar la conexión
        Connection conexion = null;

        //Intentar registrar nuevo material        
        try{

            //Conectarse
            conexion = JDBCUtilities.getConnection();

            String consulta =   "UPDATE MaterialConstruccion SET "+
                                "Nombre_Material = ?, Importado = ?, Precio_Unidad = ? "+
                                "WHERE ID_MaterialConstruccion = ?";

            //Construir objeto que realizará la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nuevoMaterial.getNombreMaterial());
            statement.setString(2, nuevoMaterial.getImportado());
            statement.setInt(3, nuevoMaterial.getPrecioUnidad());
            statement.setInt(4, nuevoMaterial.getIdMaterialConstruccion());

            //Realizar la inserción
            statement.executeUpdate();

            //Realizar el cierre
            statement.close();


        }catch(SQLException e){
            System.err.println("Error actualizando material de construcción!! " + e);
            nuevoMaterial = null;
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar la colección de materiales de producción nacional        
        return nuevoMaterial;
        
    } 

    //Actualizar material de construcción
    public MaterialConstruccion eliminarMaterial(MaterialConstruccion materialEliminar) throws SQLException {

        System.out.println("Desde el DAO:");
        materialEliminar.mostrarMaterialConstruccion();

        //Declarar la conexión
        Connection conexion = null;

        //Intentar registrar nuevo material        
        try{

            //Conectarse
            conexion = JDBCUtilities.getConnection();

            String consulta =   "DELETE FROM MaterialConstruccion WHERE ID_MaterialConstruccion = ?";            

            //Construir objeto que realizará la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, materialEliminar.getIdMaterialConstruccion());            

            //Realizar la inserción
            statement.executeUpdate();

            //Realizar el cierre
            statement.close();


        }catch(SQLException e){
            System.err.println("Error eliminando material de construcción!! " + e);
            materialEliminar = null;
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar la colección de materiales de producción nacional        
        return materialEliminar;
        
    } 

    // //Requerimiento 3 Reto 3
    
    // //Materiales de producción nacional más comprados
    // public ArrayList<MaterialNacional> topMaterialesNacionales() throws SQLException {

    //     //Preparar la colección que tendrá la respuesta
    //     ArrayList<MaterialNacional> respuesta = new ArrayList<MaterialNacional>();

    //     //Declarar la conexión
    //     Connection conexion = null;

    //     //Intentar conectarnos y extraer la información de la base de datos para el requerimiento
    //     //Lógica -> Consulta SQL
    //     try{

    //         //Conectarse
    //         conexion = JDBCUtilities.getConnection();

    //         String consulta = "SELECT  m.Nombre_Material,"+
    //                                     "m.Importado, "+
    //                                     "COUNT(*) as No_Compras "+
    //                             "FROM MaterialConstruccion as m "+
    //                             "INNER JOIN Compra c "+
    //                             "ON m.ID_MaterialConstruccion = c.ID_MaterialConstruccion "+
    //                             "WHERE m.Importado = 'No' "+
    //                             "GROUP BY m.ID_MaterialConstruccion "+
    //                             "ORDER BY No_Compras DESC, "+
    //                                     "m.Nombre_Material ASC ";

    //         //Construir objeto que realizará la consulta
    //         PreparedStatement statement = conexion.prepareStatement(consulta);

    //         //Realizar propiamente la consulta
    //         ResultSet resultSet = statement.executeQuery();

    //         //Recorrerlo mientras tenga posiciones, o registros
    //         while(resultSet.next()){                
    //             MaterialNacional material = new MaterialNacional();
    //             material.setNombreMaterial(resultSet.getString("Nombre_Material"));
    //             material.setImportado(resultSet.getString(2));
    //             //material.setImportado(resultSet.getString("Importado"));
    //             material.setNoCompras(resultSet.getInt("No_Compras"));
                
    //             respuesta.add(material);
    //         }

    //         resultSet.close();
    //         statement.close();


    //     }catch(SQLException e){
    //         System.err.println("Error consultando ranking de materiales nacionales!! " + e);
            
    //     }finally{
    //         if(conexion != null){
    //             conexion.close();
    //         }
    //     }

    //     //Retornar la colección de materiales de producción nacional
    //     return respuesta;
        
    // } 
    


    
}
