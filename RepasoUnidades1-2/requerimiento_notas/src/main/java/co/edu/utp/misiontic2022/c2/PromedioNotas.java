package co.edu.utp.misiontic2022.c2;

import java.util.Scanner;

public class PromedioNotas {
    
    //Paso a paso -> Algoritmo
    // 1) Recoger la información: código del estudiante y las 5 notas
    // 2) Identificar cuál es la peor nota
    // 3) Hallar el promedio ajustado (descartar la peor de las notas)
    // 4) Realizar la conversión a escala de 0 a 5
    // 5) Reportar ese promedio ajustado con el formato indicado
    
    //Funciones que resuelven el problema -> Modularizado
    
    // 2) Identificar cuál es la peor nota
    //alcance tipo_de_retorno nombreFuncion(especificación argumentos){Bloque de código}
    public static int obtenerPeorNota(int nota1, int nota2, int nota3, int nota4, int nota5){
        
        //Declarar
        int peorNota;
        //Inicializar
        peorNota = nota1;

        //Comparación una por una con las demás
        if(peorNota>nota2){
            peorNota = nota2;            
        }

        if(peorNota>nota3){
            peorNota = nota3;
        }

        if(peorNota>nota4){
            peorNota = nota4;
        }

        if(peorNota>nota5){
            peorNota = nota5;
        }

        return peorNota;

    }  
    
    // 3) Hallar el promedio ajustado (descartar la peor de las notas) -> 0 a 5 (decimal)
    public static double calcularPromedioAjustado(int nota1, int nota2, int nota3, int nota4, int nota5){

        int peorNota = obtenerPeorNota(nota1, nota2, nota3, nota4, nota5);
        
        int sumatoria = 0;

        double promedioAjustado = 0;

        sumatoria = (nota1+nota2+nota3+nota4+nota5)-peorNota;

        promedioAjustado = (double)sumatoria/4;

        return promedioAjustado;

    }

    // 4) Conversión escala de 100 -> escala 5
    public static double convertirEscala5(double calificacion100){
        return (calificacion100/20);
    }


    // 5) Reportar ese promedio ajustado con el formato indicado
    public static void reportarPromedioAjustado(String codigo, double promedioAjustado){
        System.out.println("El promedio ajustado del estudiante " + codigo + " es: " + promedioAjustado);
    }

    //Sección principal o punto de entrada para consumir estas funciones
    public static void main(String[] args) {

        // 1) Recoger la información: código del estudiante y las 5 notas
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el código del estudiante: ");
        String codigoEstudiante = sc.nextLine();
        System.out.print("Ingrese nota1: ");
        int nota1 = sc.nextInt();
        System.out.print("Ingrese nota2: ");
        int nota2 = sc.nextInt();
        System.out.print("Ingrese nota3: ");
        int nota3 = sc.nextInt();
        System.out.print("Ingrese nota4: ");
        int nota4 = sc.nextInt();
        System.out.print("Ingrese nota5: ");
        int nota5 = sc.nextInt();

        //Ejecutar las funciones -> al paso 3 (internamente realiza el paso 2)
        double promedioAjustado = convertirEscala5(calcularPromedioAjustado(nota1, nota2, nota3, nota4, nota5)) ;

        //Reportar el resultado
        //reportarPromedioAjustado(codigoEstudiante, Math.round(promedioAjustado) );
        reportarPromedioAjustado(codigoEstudiante, promedioAjustado );
        
    }


}
