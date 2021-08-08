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
public class MisionTIC_C2R4_P61_Casos {
    public static void main( String[] args ){
		
        //Casos de prueba 

        //Requerimiento 1 - Reto3
        VistaRequerimientosReto4.requerimiento1();
        System.out.println();

        //Requerimiento 3 - Reto3
        VistaRequerimientosReto4.requerimiento3();
        System.out.println();

        //Requerimiento 5 - Reto3
        VistaRequerimientosReto4.requerimiento5();
        System.out.println();        
        
    }    
}

//Vista
public class VistaRequerimientosReto4 {
    
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

     public static void requerimiento1(){

        System.out.println("-----10 Proyectos Mayor Gasto-------");       

        try{

            ArrayList<ProyectoRankeadoCompras> rankingProyectosCompras = controlador.consultarProyectosCompras10();

            //Encabezado del resultado
            System.out.println("ID_Proyecto Clasificación Gasto_Compras Serial");
            
            //Cada VO cargado, mostrarlo en la vista
            for (ProyectoRankeadoCompras proyectoRankeado : rankingProyectosCompras) {
                System.out.printf("%d %s %d %s %n", 
                    proyectoRankeado.getIdProyecto(), 
                    proyectoRankeado.getClasificacion(), 
                    Math.round(proyectoRankeado.getGastoCompras()), 
                    proyectoRankeado.getSerial()
                );   
            }

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    }

    public static void requerimiento3(){

        System.out.println("-----Ranking Descendente Bancos (Área Proyectos)-------");       

        try{

            ArrayList<BancoRankeadoAreaPromedio> rankingBancosArea = controlador.consultarBancosRankeadosAreaPromedio();

            //Encabezado del resultado
            System.out.println("Banco_Vinculado Area_Promedio");
            
            //Cada VO cargado, mostrarlo en la vista
            for (BancoRankeadoAreaPromedio banco : rankingBancosArea) {
                System.out.printf("%s %f %n", 
                    banco.getBancoVinculado(), 
                    banco.getAreaPromedio()                    
                );   
            }

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    }

    public static void requerimiento5(){

        System.out.println("-----Ranking Descendente Materiales Importados (Compras)-------");       

        try{

            ArrayList<MaterialRankeadoCompras> rankingMaterialesImportados = controlador.consultarMaterialesRankeadosCompras();

            //Encabezado del resultado
            System.out.println("Nombre_Material Importado No_Compras");
            
            //Cada VO cargado, mostrarlo en la vista
            for (MaterialRankeadoCompras material : rankingMaterialesImportados) {
                System.out.printf("%s %s %d %n", 
                    material.getNombreMaterial(),
                    material.getImportado(),
                    material.getNoCompras()              
                );   
            }

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

    public ArrayList<ProyectoRankeadoCompras> consultarProyectosCompras10() throws SQLException {
        //.
		//.
		//.
    }
    
    public ArrayList<BancoRankeadoAreaPromedio> consultarBancosRankeadosAreaPromedio() throws SQLException {
        //.
		//.
		//.
    }

    public ArrayList<MaterialRankeadoCompras> consultarMaterialesRankeadosCompras() throws SQLException {
        //.
		//.
		//.
    }

    
}

//DAO's
public class ProyectoRankeadoComprasDao {

    //Obtener los 10 proyectos rankeados según las compras
    public ArrayList<ProyectoRankeadoCompras> rankingProyectosComprasDescendente10() throws SQLException {

        //.
		//.
		//.
        
    } 
    
}

public class BancoRankeadoAreaPromedioDao {

    //Obtener los 10 proyectos rankeados según las compras
    public ArrayList<BancoRankeadoAreaPromedio> rankingBancosAreaPromedioDescendente() throws SQLException {

        //.
		//.
		//.
        
    }  
    
}

public class MaterialRankeadoComprasDao {

    //Obtener los 10 proyectos rankeados según las compras
    public ArrayList<MaterialRankeadoCompras> rankingMaterialesComprasDescendente() throws SQLException {

        //.
		//.
		//.
        
    }
        
}

//VO's
public class ProyectoRankeadoCompras {

    //.
	//.
	//.
    
}

public class BancoRankeadoAreaPromedio {

    //.
	//.
	//.
    
}

public class MaterialRankeadoCompras {

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


