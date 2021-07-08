package iu;

//Mundo del Problema (Modelado)
import co.edu.utp.misiontic2022.c2.*;

//Utilidades
import java.util.Scanner;

public class InterfazConsola {

    //Atributos
    private Materia materia;
    private Estudiante estudiante;

    //Constructores

    //Construir interfaz sin información, porque luego se cargará
    InterfazConsola(){
        this.materia = new Materia();
        this.estudiante = new Estudiante();    
    }

    InterfazConsola(Materia pMateria, Estudiante pEstudiante){
        this.materia = pMateria;
        this.estudiante = pEstudiante;
    }    
    
    //Métodos -> Interfaz por consola   

    public int menuPrincipal(){
        System.out.println();
        System.out.println();
        System.out.println("--Menú Principal--");
        System.out.println("1. Registrar Info Estudiante");
        System.out.println("2. Registrar Info Materia");
        System.out.println("3. Mostrar Promedio Ajustado");
        System.out.println("4. Mostrar Info Estudiante");
        System.out.println("5. Mostrar Info Materia");
        System.out.println("6. Salir");
        System.out.println("Ingresar opción: ");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        //sc.close();
        return opcion;       
    }

    public void registrarEstudiante(){

        //Recolectamos la información
        Scanner sc = new Scanner(System.in);        
        System.out.println("Ingrese los Nombres del Estudiante");
        String pNombres = sc.nextLine();
        System.out.println("Ingrese los Apellidos del Estudiante");
        String pApellidos = sc.nextLine();
        System.out.println("Ingrese el Semestre del Estudiante");
        int pSemestreActual = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el Género del Estudiante");
        String pGenero = sc.nextLine();
        System.out.println("Ingrese el Código del Estudiante");
        int pCodigo = sc.nextInt();
        
        //Cargar en el sistema -> InterfazConsola
        this.estudiante = new Estudiante(pCodigo,pNombres,pApellidos,pSemestreActual,pGenero);

    }

    public void registrarMateria(){               

        //Recolectamos la información
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese Nombre Materia");
        String pNombre = sc.nextLine();
        System.out.println("Ingrese Nota 1 (Escala100)");
        int pNota1_100 = sc.nextInt();
        System.out.println("Ingrese Nota 2 (Escala100)");
        int pNota2_100 = sc.nextInt();
        System.out.println("Ingrese Nota 3 (Escala100)");
        int pNota3_100 = sc.nextInt();
        System.out.println("Ingrese Nota 4 (Escala100)");
        int pNota4_100 = sc.nextInt();
        System.out.println("Ingrese Nota 5 (Escala100)");
        int pNota5_100 = sc.nextInt();        
        
        //Cargar en el sistema -> InterfazConsola
        this.materia = new Materia(this.estudiante, pNota1_100, pNota2_100, pNota3_100, pNota4_100, pNota5_100);

        //Asignar el nombre de la materia
        this.materia.setNombre(pNombre);
        //this.materia.nombre = "Nuevo nombre";

    }

    public void presentarPromedioAjustado(){
        materia.calcularPromedioAjustado();
        System.out.println("El promedio ajustado del estudiante "+this.estudiante.getCodigo()+" es: "+this.materia.getPromedioAjustado());
    }    

    //mainloop -> Consola, Dialog, GUI
    public void ejecutarMainloop(){

        //Bandera para el control del mainloop
        boolean continuar = true;

        //Ciclo permanente de la aplicación
        do{
            //Funcionalidades principales de la aplicación
            int opcion = menuPrincipal();
            if(opcion == 1){
                registrarEstudiante();               
            }else if(opcion == 2){
                registrarMateria();
            }else if(opcion == 3){
                presentarPromedioAjustado();
            }else if(opcion == 4){
                this.estudiante.mostrarInfoEstudiante();
            }else if(opcion == 5){
                this.materia.mostrarMateria();
            }else if(opcion == 6){
                continuar = false;
            }else{
                System.out.println("Opción inválida!");
            }            

        }while(continuar);
        

    }


    //public void registro


    //Punto de entrada de toda la aplicación
    public static void main(String[] args) {

        //Al iniciar la aplicación construimos la interfaz (consola)
        InterfazConsola interfaz = new InterfazConsola();

        //Funcionamiento -> Comportamiento que definamos de la interfaz
        interfaz.ejecutarMainloop();
        
    }

    
}