package view;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.ArrayList;
import controller.ControladorProyectosConstruccion;
import model.vo.Lider;


public class MenuLider {

    //Controlador
    public static final ControladorProyectosConstruccion controlador = new ControladorProyectosConstruccion();

    public static void menuInicial(){

        boolean mainloop = true;
        Scanner lector = new Scanner(System.in);
        do{
            System.out.println("=====Menú Líderes=====");            
            System.out.println("1. Listar todos los líderes de proyecto");
            System.out.println("2. Consultar líder por ID");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opción: ");
            int opcionIngresada = lector.nextInt();
            if(opcionIngresada == 1){
                listar();
            }else if(opcionIngresada == 2){
                System.out.println("En construcción!!!!!");
            }else if(opcionIngresada == 3){
                System.out.println("Salida exitosa.");
                mainloop = false;
            }else{
                System.out.println("Opción Inválida!");
            }

        }while(mainloop);

    }

    public static void listar(){

        try{
            ArrayList<Lider> lideres = controlador.consultarTodosLideres();
            System.out.println("ID_Lider Nombre Primer_Apellido Segundo_Apellido Salario Clasificación");
            for (Lider lider : lideres) {
                System.out.printf("%d\t%s\t%s\t%s\t%d\t%d %n",
                    lider.getIdLider(),
                    lider.getNombre(),
                    lider.getPrimerApellido(),
                    lider.getSegundoApellido(),
                    lider.getSalario(),
                    Math.round(lider.getClasificacion())
                );
            }
        }catch(SQLException e){
            System.err.println("Error consultando todos los líderes!! "+e.getMessage());
        }

    }
    
}
