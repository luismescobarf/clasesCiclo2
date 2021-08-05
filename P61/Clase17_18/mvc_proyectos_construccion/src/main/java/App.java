import util.JDBCUtilities;
import java.sql.Connection;
import java.sql.SQLException;
import view.MenuLider;

/**
 * Aplicación Proyectos Construcción
 *
 */
public class App {
    public static void main( String[] args ) {               

        //Intentar conectarnos a la base de datos
        try(Connection conexion = JDBCUtilities.getConnection()){
            
            if(JDBCUtilities.estaVacia()){
                System.out.println("Se encuentra vacía!");
            }else{
                System.out.println("No está vacía BD encontrada");
            }

            //Iniciaríamos nuestra aplicación
            //Llamado al menú de inicio de la vista/view
            MenuLider.iniciar();

            
        }catch( SQLException e ){

            System.err.println("Error iniciando conexión: "+e);

        }

    }
}
