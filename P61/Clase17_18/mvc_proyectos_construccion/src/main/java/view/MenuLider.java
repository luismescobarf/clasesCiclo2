package view;

import java.sql.SQLException;
import controller.ControladorProyectosConstruccion;
import model.vo.BancoRankeadoAreaPromedio;
import model.vo.Lider;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuLider {

    //Atributo -> Controlador necesario para el funcionamiento de la vista
    public static final ControladorProyectosConstruccion controlador = new ControladorProyectosConstruccion();

    //Listar todos los líderes
    public static void mostrarRequerimiento3(){

        //Encabezado
        System.out.println("Banco_Vinculado Area_Promedio");        
        System.out.println("--------------- --------------");        

        try{
            
            ArrayList<BancoRankeadoAreaPromedio> bancos = controlador.requerimiento3();
            for (BancoRankeadoAreaPromedio banco : bancos) {
                
                System.out.printf("%s\t%f %n", 
                    banco.getBancoVinculado(),
                    banco.getAreaPromedio()
                );

            }

        }catch(SQLException e){
            System.err.println( "Error recibido al rankear los bancos: " + e.getMessage() );
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
                listar();
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

    //Listar todos los líderes
    public static void listar(){

        //Encabezado
        System.out.println("ID_Lider Nombre Primer_Apellido Segundo_Apellido Salario Clasificación");        
        System.out.println("-------- ------ --------------- ---------------- ------- -------------");        

        try{
            
            ArrayList<Lider> lideres = controlador.consultarTodosLideres();
            for (Lider lider : lideres) {
                
                System.out.printf("%d\t%s\t%s\t%s\t%d\t%d\t %n", 
                    lider.getIdLider(),
                    lider.getNombre(),
                    lider.getPrimerApellido(),
                    lider.getSegundoApellido(),
                    lider.getSalario(),
                    Math.round(lider.getClasificacion())
                );

            }

        }catch(SQLException e){
            System.err.println( "Error recibido al listar: " + e.getMessage() );
        }

    }

    //Consultar por id un líder

    //Guardar líder

    //Remover líder
    
}
