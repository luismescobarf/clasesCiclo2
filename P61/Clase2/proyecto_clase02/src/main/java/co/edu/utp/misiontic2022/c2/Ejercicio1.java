package co.edu.utp.misiontic2022.c2;

import java.util.Scanner;

public class Ejercicio1 {

    //Algoritmo: Número de la suerte (objetivo)
    //1) Solicitar al usuario la fecha en formato String (Interacción)
    //2) Extraer los pedazos que corresponden al día, al mes y al año (split)
    //3) Cada pedazo convertirlo en un valor numérico
    //4) Sumar los pedazos y almacenarlos
    //5) De la sumatoria extraer las cifras
    //6) Sumar las cifras y retornar el número de la suerte

    //Traducir a Java!!!

    //Sección de las funciones o métodos
    public static int obtenerNumeroSuerte(String fecha){
        //Variable que contiene el resultado
        int numeroSuerte = 0;

        //2) Extraer los pedazos que corresponden al día, al mes y al año (split)
        String [] arregloFecha = fecha.split("/",5);

        //Variables para las versiones numéricas de las partes del año
        int valorDia = Integer.parseInt(arregloFecha[0]);
        int valorMes = Integer.parseInt(arregloFecha[1]);
        int valorAño = Integer.parseInt(arregloFecha[2]);

        //Salida de prueba
        System.out.println(valorDia);
        System.out.println(valorMes);
        System.out.println(valorAño);
        
        //Retornar el resultado
        return numeroSuerte;

         
    }

    //Interacción//////
    public static void saludo(){
        System.out.println("App Número Suerte");
    }

    public static String leerFecha(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar la fecha DD/MM/AAAA: ");
        //String fecha = sc.nextLine();
        //return fecha;
        return sc.nextLine();
    }

    public static void reportarNumeroSuerte(int numeroSuerte){
        System.out.println("El número de la suerte es: "+numeroSuerte);
    }

    //Lógica/////
    
    
    //Sección principal (ejecuta el código)
    public static void main(String[] args) {

        //Llamados para el funcionamiento de la aplicación
        saludo();       
        obtenerNumeroSuerte(leerFecha());
        
    }

    
}
