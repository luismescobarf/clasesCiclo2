package model.dao;

import model.vo.BancoRankeadoAreaPromedio;
import model.vo.Lider;
import java.util.ArrayList;
import util.JDBCUtilities;
import java.sql.Connection;
import java.sql.SQLException;
//Clase para construir objetos de consulta
import java.sql.PreparedStatement;
//Clase para manejar la respuesta de la BD -> Contenedor (iterador)
import java.sql.ResultSet;


public class BancoRankeadoAreaPromedioDao {

    //Operaciones CRUD -> Create Read Update Delete

    //Consultar todos los líderes (READ)
    public ArrayList<BancoRankeadoAreaPromedio> consultarBancosAreaPromedioDesc() throws SQLException {

        //Contenedor de la respuesta -> Colección de líderes
        ArrayList<BancoRankeadoAreaPromedio> respuesta = new ArrayList<BancoRankeadoAreaPromedio>();
        Connection conexion = null;

        try{
            conexion = JDBCUtilities.getConnection();
            //SELECT * FROM Lider;

            String consulta = "SELECT  p.Banco_Vinculado,"+
                                        "AVG(t.Area_Max) as Area_Promedio "+
                                "FROM Proyecto p "+
                                "JOIN Tipo t ON "+
                                    "p.ID_Tipo = t.ID_Tipo "+
                                "GROUP BY p.Banco_Vinculado "+
                                "ORDER BY Area_Promedio DESC";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            //Moviendo apuntador por cada registro, cuando no hay más, retorna falso y se sale
            while(resultSet.next()){
                //Cargar el registro actual en un Value Object
                BancoRankeadoAreaPromedio banco = new BancoRankeadoAreaPromedio();
                banco.setAreaPromedio(resultSet.getDouble("Area_Promedio"));
                banco.setBancoVinculado(resultSet.getString("Banco_Vinculado"));

                respuesta.add(banco);
            }

            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando bancos rankeados areaMax promedio: "+e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornamos la colección de VO's obtenida de la BD (Vacía, con un VO o muchos)
        return respuesta;
    }
                            
    
}
