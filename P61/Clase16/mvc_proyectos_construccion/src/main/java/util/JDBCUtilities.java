package util;

//Librerías para conexión a base de datos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Librerías para archivos
import java.io.File;

public class JDBCUtilities {

    //Ubicación de la base de datos que soporta este SW
    private static final String UBICACION_BD = "/Users/luismiguelescobarfalcon/Dropbox/MisionTIC2022/Ciclo2/repositorioClasesCiclo2/P61/Clase16/mvc_proyectos_construccion/ProyectosConstruccion.db";//Ruta absoluta
    
    //Método para proveer conexión
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + JDBCUtilities.UBICACION_BD;
        return DriverManager.getConnection(url);
    }

    //Método complementario -> sqlite si no existe la base de datos, la crea (vacía)
    public static boolean estaVacia(){
        File archivo = new File(JDBCUtilities.UBICACION_BD);
        return archivo.length() == 0;
    }

    //Inicialización de la base de datos
    //...

}
