package view;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.IllegalFormatConversionException;
import controller.ControladorRequerimientosReto4;
import model.vo.MaterialNacional;
import model.vo.ProyectoRankeadoCompras;
import model.vo.CargoAsignacion;


public class VistaRequerimientosReto4 {

    //Controlador
    //public static final ControladorProyectosConstruccion controlador = new ControladorProyectosConstruccion();
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    public static void requerimiento3(){

        System.out.println("-----Materiales Producción Nacional Más Comprados-------");       

        try{

            ArrayList<MaterialNacional> rankingMaterialesNacionales = controlador.consultarMaterialesNacionalesComprados();

            //Encabezado del resultado
            System.out.println("Nombre_Material Importado No_Compras");
            
            for (MaterialNacional materialNacional : rankingMaterialesNacionales) {
                System.out.printf("%s %s %d %n",
                    materialNacional.getNombreMaterial(),
                    materialNacional.getImportado(),
                    materialNacional.getNoCompras()
                );                
            }

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
            
            for (ProyectoRankeadoCompras proyecto : rankingProyectosGranito) {
                System.out.printf("%d %s %d %d %n",
                    proyecto.getIdProyecto(),
                    proyecto.getClasificacion(),
                    proyecto.getAreaMaxima(),
                    proyecto.getNoComprasGranito()
                );
            }

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
            
            for (CargoAsignacion cargo : cargosMenosAsignados) {
                System.out.printf("%s %d %n",
                    cargo.getCargo(),
                    cargo.getNoProyectos()
                );
            }

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    }

    
}


