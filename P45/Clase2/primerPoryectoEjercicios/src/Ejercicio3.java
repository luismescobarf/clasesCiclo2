import java.util.Scanner;

public class Ejercicio3 {

    //Lógica

    //Función o método que calcula el doble
    public static int doble(int numero){
        int doble = 0;
        doble = numero * 2;
        return doble;
    }

    //Función o método que calcula el triple
    public static int triple(int numero){
        int triple = 0;
        triple = numero * 3;
        return triple;
    }

    //Interacción

    //Binevenida y saludo al usuario recogiendo el nombre
    public static void saludo(){

        //Bienvenida
        System.out.println("Bienvenido al Ejercicio3!!");

        //Recoger el nombre para generar el saludo
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el nombre: ");
        String nombre = sc.nextLine();        

        //Presentar el saludo
        System.out.println("Hola "+nombre);

    }
    
    //Lectura del número que se va a procesar
    public static int leerNumero(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar número: ");
        int numero = sc.nextInt();        
        return numero;
    }

    //Reportar el resultado
    public static void reportarResultado(int doble, int triple){
        System.out.println("El doble es: "+doble+" El triple es: "+triple);
    }

    public static void main(String[] args) {
        
        //Objetivo, requerimiento o problema que vamos a solucionar:
        //Escribe un programa Java que lee un número entero por teclado 
        //y obtiene y muestra por pantalla el doble y el triple de ese número.

        // Algoritmo o pasos
        // 1) Leer el número entero
        // 2) Obtener el doble del número
        // 3) Obtener el triple dle número
        // 4) Presentar resultados en pantalla

        //Traducción a Java

        //0) Saludo (al separar lógica de interacción)
        saludo();

        // 1) Leer el número entero
        // -> Declarar la variable que va contener el número
        // -> Instanciar el objeto que me permite hacer la lectura
        // -> Realizar la lectura

        //Antes de modularizar (métodos)
        // int numero = 0;
        // Scanner lector = new Scanner(System.in);
        // System.out.println("Ingresar el número:");
        // numero = lector.nextInt();

        //Modularizado
        int numero = leerNumero();

        // 2) Obtener el doble del número
        //int doble = numero * 2;
        int doble = doble(numero);

        // 3) Obtener el triple dle número
        //int triple = numero * 3; 
        int triple = triple(numero); 

        // 4) Presentar resultados en pantalla
        //System.out.println("El doble es: "+doble+" El triple es: "+triple);
        reportarResultado(doble, triple);
        
    }
    
}
