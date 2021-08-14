package view;

import java.sql.SQLException;
import controller.ControladorRequerimientosReto4;
import model.vo.ProyectoRankeadoCompras;
import model.vo.BancoRankeadoAreaPromedio;
import model.vo.MaterialRankeadoCompras;
import java.util.ArrayList;
import java.util.Scanner;

public class VistaRequerimientosReto4 {

    //Atributo -> Controlador necesario para el funcionamiento de la vista
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    public static void requerimiento1(){

        System.out.println("-----10 Proyectos Mayor Gasto-------");       

        try{

            ArrayList<ProyectoRankeadoCompras> rankingProyectosCompras = controlador.consultarProyectosCompras10();

            //Encabezado del resultado
            System.out.println("ID_Proyecto Clasificación Gasto_Compras Serial");            
            
            for (ProyectoRankeadoCompras proyecto : rankingProyectosCompras) {
                
                System.out.printf("%d %s %d %s %n", 
                    proyecto.getIdProyecto(),
                    proyecto.getClasificacion(),
                    proyecto.getGastoCompras(),
                    proyecto.getSerial()
                );

            }

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    }

    //Listar los bancos
    public static void requerimiento3(){

        //Encabezado
        System.out.println("-----Ranking Descendente Bancos (Área Proyectos)-------");             

        try{

            System.out.println("Banco_Vinculado Area_Promedio");
            
            ArrayList<BancoRankeadoAreaPromedio> bancos = controlador.consultarBancosRankeadosAreaPromedio();
            for (BancoRankeadoAreaPromedio banco : bancos) {
                
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

            System.out.println("Nombre_Material Importado No_Compras");
            
            ArrayList<MaterialRankeadoCompras> materiales = controlador.consultarMaterialesRankeadosCompras();
            for (MaterialRankeadoCompras material : materiales) {
                
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

    //Menú principal de los líderes
    public static void iniciar(){        

        boolean mainloop = true;
        Scanner lector = new Scanner(System.in);
        do{
            System.out.println("====Menú Líderes====");
            System.out.println("1. Listar todos los líderes");
            System.out.println("2. Consultar líder por ID");
            System.out.println("3. Guardar líder ");
            System.out.println("4. Remover líder ");
            System.out.println("5. Salir ");
            System.out.print("Ingresar opción: ");
            int opcionIngresada = lector.nextInt();
            if(opcionIngresada == 1){
                //listar();
            }else if(opcionIngresada == 2){
                System.out.println("En construcción: 2. Consultar líder por ID");
            }else if(opcionIngresada == 3){
                System.out.println("En construcción: 3. Guardar líder ");
            }else if(opcionIngresada == 4){
                System.out.println("En construcción: 4. Remover líder ");
            }else if(opcionIngresada == 5){
                mainloop = false;
                System.out.println("Salida exitosa.");
            }else{
                System.out.println("Opción inválida!");
            }

        }while(mainloop);

    }    

    
    
}
