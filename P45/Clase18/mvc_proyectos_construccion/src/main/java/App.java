import util.JDBCUtilities;

import java.io.IOException;
//Librerías para el manejo de la base de datos
import java.sql.Connection;
import java.sql.SQLException;

import view.MenuLider;

/**
 * SW Proyectos Construcción 
 *
 */
public class App {
    public static void main( String[] args ){

        //Iniciar mainloop de la aplicación (consola o con GUI)
        MenuLider.menuInicial();
        
        // try( Connection conexion = JDBCUtilities.getConnection() ){
            
        //     if(JDBCUtilities.estaVacia()){
        //         System.out.println("La base de datos está vacía!");
        //     }else{
        //         System.out.println("Conexión exitosa a la base de datos específica!");
        //     }

        //     //Iniciar mainloop de la aplicación (consola o con GUI)
        //     MenuLider.menuInicial();

        // }catch(SQLException objetoError){
        //     System.err.println("Error conectándose a la BD " + objetoError);            
        // }

    }
}
