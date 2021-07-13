package iu;

//Traer clases del mundo del problema (nuesto modelamiento)
import co.edu.utp.misiontic2022.c2.Materia;
import co.edu.utp.misiontic2022.c2.Nota;

import java.util.Scanner;

import co.edu.utp.misiontic2022.c2.Estudiante;

public class InterfazConsola {

    //Atributos
    private Materia materia;
    private Estudiante estudiante;

    //Constructores
    InterfazConsola(){
        this.materia = new Materia();
        this.estudiante = new Estudiante();
    }

    //Métodos

    public int menuPrincipal(){
        System.out.println();
        System.out.println();
        System.out.println("----Menú Principal----");
        System.out.println("1. Registrar Estudiante");
        System.out.println("2. Registrar Info Materia");
        System.out.println("3. Mostrar Promedio Ajustado");
        System.out.println("4. Mostrar Info Materia");
        System.out.println("5. Mostrar Info Estudiante");
        System.out.println("6. Adicionar Nota");
        System.out.println("7. Salir");
        System.out.print("Ingresar opción: ");
        Scanner sc = new Scanner(System.in);
        int opcionIngresada = sc.nextInt();
        return opcionIngresada;
    }

    public void registrarEstudiante(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el código del estudiante: ");
        int pCodigo = sc.nextInt();
        sc.nextLine();//Manejar el movimiento de carro que no fue interpretado por nextInt()
        System.out.print("Ingrese los nombres del estudiante: ");
        String pNombres = sc.nextLine();
        System.out.print("Ingrese los apellidos del estudiante: ");
        String pApellidos = sc.nextLine();

        //Instancia la información recogida y la carga en la aplicación (InterfazConsola)
        this.estudiante = new Estudiante(pCodigo, pNombres, pApellidos);
    }

    public void ejecutarMainloop(){

        boolean continuar = true;

        while(continuar){
            
            //Aloja la ejecución de la aplicación
            int opcion = menuPrincipal();
            if(opcion == 1){
                //Llamado al registro del estudiante
                this.registrarEstudiante();
            }else if(opcion == 2){
                //Llamado al registro de la materia
                System.out.println("En construcción!!");
            }else if(opcion == 3){
                //Llamado a mostrar info del estudiante
                this.estudiante.mostrarInfoEstudiante();
            }else if(opcion == 4){
                continuar  = false;
                System.out.println("Salida exitosa!");
            }else{
                System.out.println("Opción inválida!");
            }

        }

    }

    public static void main(String[] args) {
        
        //Creamos la aplicación en versión de consola
        InterfazConsola interfaz = new InterfazConsola();

        //Iniciamos la aplicación
        interfaz.ejecutarMainloop();

    }
    
}
