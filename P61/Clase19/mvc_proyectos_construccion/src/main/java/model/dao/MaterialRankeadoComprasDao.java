package model.dao;

import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.JDBCUtilities;
import model.vo.MaterialRankeadoCompras;

public class MaterialRankeadoComprasDao {

    //Ranking materiales importados más comprados
    public ArrayList<MaterialRankeadoCompras> rankingMaterialesComprasDescendente() throws SQLException {

        ArrayList<MaterialRankeadoCompras> respuesta = new ArrayList<MaterialRankeadoCompras>();
        Connection conexion = null;        

        try{
            conexion = JDBCUtilities.getConnection();

            String consulta = "SELECT  mc.Nombre_Material, "+
                                        "mc.Importado, "+
                                        "COUNT(c.ID_Compra) as No_Compras "+
                                "FROM Compra c "+
                                "inner JOIN MaterialConstruccion mc "+
                                "ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion  "+
                                "WHERE mc.Importado = 'Si' "+
                                "GROUP BY mc.ID_MaterialConstruccion "+
                                "ORDER BY    No_Compras DESC, "+
                                            "mc.Nombre_Material ";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                MaterialRankeadoCompras material = new MaterialRankeadoCompras();
                material.setNombreMaterial(resultSet.getString(1));
                material.setImportado(resultSet.getString(2));
                material.setNoCompras(resultSet.getInt(3));                
                respuesta.add(material);
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
