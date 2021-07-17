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

    public void registrarMateria(){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la materia ");
        String pNombre = sc.nextLine();
        System.out.print("Ingrese Nota1 (Escala 100)  ");
        int pNota1 = sc.nextInt();
        sc.nextLine();//Manejar el movimiento de carro que no fue interpretado por nextInt()
        System.out.print("Ingrese Nota2 (Escala 100)  ");
        int pNota2 = sc.nextInt();
        sc.nextLine();//Manejar el movimiento de carro que no fue interpretado por nextInt()
        System.out.print("Ingrese Nota3 (Escala 100)  ");
        int pNota3 = sc.nextInt();
        sc.nextLine();//Manejar el movimiento de carro que no fue interpretado por nextInt()
        System.out.print("Ingrese Nota4 (Escala 100)  ");
        int pNota4 = sc.nextInt();
        sc.nextLine();//Manejar el movimiento de carro que no fue interpretado por nextInt()
        System.out.print("Ingrese Nota5 (Escala 100)  ");
        int pNota5 = sc.nextInt();
        sc.nextLine();//Manejar el movimiento de carro que no fue interpretado por nextInt()

        //Instanciar con la información recogida
        this.materia = new Materia(this.estudiante, pNombre, pNota1, pNota2, pNota3, pNota4, pNota5);        
        
    }

    public void registrarNota(){
        
        //Formulario (interacción con el usuario)
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la nota ");
        String pNombre = sc.nextLine();
        System.out.print("Ingrese Calificación (Escala 100)  ");
        int pEscala100 = sc.nextInt();
        sc.nextLine();//Manejar el movimiento de carro que no fue interpretado por nextInt()

        //Consumo de la lógica o del mundo que hemos modelado
        this.materia.adicionarNota(pEscala100,pNombre);      


    }

    public void mostrarPromedioAjustadoColeccion(){
        
        //Calcular el promedio ajustado de la colección
        this.materia.calcularPromedioAjustadoColeccion();

        //Estando listo ese promedio, preparar el mensaje de salida
        System.out.println("El promedio ajustado del estudiante "+this.estudiante.getCodigo()+" es "+this.materia.getPromedioAjustado());

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
                this.registrarMateria();
            }else if(opcion == 3){
                //Llamado a presentar promedio  ajustado
                this.mostrarPromedioAjustadoColeccion();
            }else if(opcion == 4){
                //Llamado a mostrar info de la materia
                this.materia.mostrarMateria();            
            }else if(opcion == 5){
                //Llamado a mostrar info del estudiante
                this.estudiante.mostrarInfoEstudiante();
            }else if(opcion == 6){
                //Llamado a adicionar nota
                this.registrarNota();
            }else if(opcion == 7){
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
