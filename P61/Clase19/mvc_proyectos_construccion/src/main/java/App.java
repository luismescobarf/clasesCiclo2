import util.JDBCUtilities;
import java.sql.Connection;
import java.sql.SQLException;
//import view.MenuLider;
import view.VistaRequerimientosReto4;

/**
 * Aplicación Proyectos Construcción
 *
 */
public class App {
    public static void main( String[] args ) {  
        
        //Requerimiento 1 - Reto3
        VistaRequerimientosReto4.requerimiento1();
        System.out.println();

        //Requerimiento 3 - Reto3
        VistaRequerimientosReto4.requerimiento3();
        System.out.println();

        // //Intentar conectarnos a la base de datos
        // try(Connection conexion = JDBCUtilities.getConnection()){
            
        //     if(JDBCUtilities.estaVacia()){
        //         System.out.println("Se encuentra vacía!");
        //     }else{
        //         System.out.println("No está vacía BD encontrada");
        //     }

        //     //Iniciaríamos nuestra aplicación
        //     //Llamado al menú de inicio de la vista/view
        //     //MenuLider.iniciar();

        //     MenuLider.mostrarRequerimiento3();

            
        // }catch( SQLException e ){

        //     System.err.println("Error iniciando conexión: "+e);

        // }

    }
}
