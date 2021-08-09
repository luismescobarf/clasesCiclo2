//Librerías
import java.util.ArrayList;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//****************************************************************
//- Recordar que la clase que contiene el main no debe ser subida.
//- El main se utiliza como ejemplo para los llamados.
//- Tampoco incluir los System.out.println(); 
//  se sugieren como separadores mientras se realizan pruebas.
//- Al subir el reto la base de datos está en la ubicación ofrecida
//  en este esqueleto.
//****************************************************************
public class MisionTIC_C2R4_P45_Casos {
    public static void main( String[] args ){
		
        //Casos de prueba 

        //Requerimiento 3 - Reto3
        VistaRequerimientosReto4.requerimiento3();
        System.out.println();

        //Requerimiento 4 - Reto3
        VistaRequerimientosReto4.requerimiento4();
        System.out.println();

        //Requerimiento 5 - Reto3
        VistaRequerimientosReto4.requerimiento5();
        System.out.println();
        
        
    }    
}

//Vista
public class VistaRequerimientosReto4 {
    
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

     public static void requerimiento3(){

        System.out.println("-----Materiales Producción Nacional Más Comprados-------");       

        try{

            ArrayList<MaterialNacional> rankingMaterialesNacionales = controlador.consultarMaterialesNacionalesComprados();

            //Encabezado del resultado
            System.out.println("Nombre_Material Importado No_Compras");
            
            //.
            //.
            //.

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    }

    public static void requerimiento4(){

        System.out.println("-----Proyectos Mayor Compra de Granito-------");       

        try{

            ArrayList<ProyectoRankeadoCompras> rankingProyectosGranito = controlador.consultarProyectosComprasGranito();

            //Encabezado del resultado
            System.out.println("ID_Proyecto Clasificacion Area_Max No_Compras_Granito");
            
            //.
            //.
            //.

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    }

    public static void requerimiento5(){

        System.out.println("-----Cargos Menos Asignados-------");       

        try{

            ArrayList<CargoAsignacion> cargosMenosAsignados = controlador.consultarCargosMenosAsignados();

            //Encabezado del resultado
            System.out.println("Cargo Número_Proyectos");
            
            //.
            //.
            //.

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    }

    
    
}

//Controlador
public class ControladorRequerimientosReto4 {           
    
    //.
    //.
    //.


    public ControladorRequerimientosReto4(){        
        //.
        //.
        //.
    }

    public ArrayList<MaterialNacional> consultarMaterialesNacionalesComprados() throws SQLException {
        //.
        //.
        //.
    }

    public ArrayList<ProyectoRankeadoCompras> consultarProyectosComprasGranito() throws SQLException {
        //.
        //.
        //.
    }

    public ArrayList<CargoAsignacion> consultarCargosMenosAsignados() throws SQLException {
        //.
        //.
        //.
    }

    
}

//DAO's
public class CargoAsignacionDao {

    //Los dos cargos que tienen menos proyectos asignados
    public ArrayList<CargoAsignacion> cargosMenosAsignados() throws SQLException {

        //.
        //.
        //.
        
    } 
    
}

public class MaterialNacionalDao {

    //Materiales de producción nacional más comprados
    public ArrayList<MaterialNacional> topMaterialesNacionales() throws SQLException {

        //.
        //.
        //.
        
    } 
    
}

public class ProyectoRankeadoComprasDao {

    //Obtener los 5 proyectos rankeados según las compras
    public ArrayList<ProyectoRankeadoCompras> topProyectosComprasGranito() throws SQLException {

        //.
        //.
        //.
    
}

//VO's
public class CargoAsignacion {

    //.
    //.
    //.
    
}

public class MaterialNacional {

    //.
    //.
    //.
    
}

public class ProyectoRankeadoCompras {

    //.
    //.
    //.
    
}

public class JDBCUtilities {

    //Atributos de clase para gestión de conexión con la base de datos      
    private static final String UBICACION_BD = "ProyectosConstruccion.db";    

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + UBICACION_BD;        
        return DriverManager.getConnection(url);
    }

    public static boolean estaVacia(){
        File archivo = new File(JDBCUtilities.UBICACION_BD);        
        return archivo.length() == 0;
    }

}