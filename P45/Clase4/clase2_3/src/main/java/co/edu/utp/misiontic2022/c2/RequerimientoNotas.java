package co.edu.utp.misiontic2022.c2;

import java.util.Scanner;

public class RequerimientoNotas {

    //Algoritmo -> Paso a paso
    //1) Obtener la información del estudiante: código y las 5 notas en escala de 0 a 100
    //2) Identificar la peor nota y la vamos a almacenar
    //3) Calcular el promedio ajustado, quitando la peor nota identificada
    //4) Armar el mensaje de salida como se solicita en el requerimiento

    //Lógica (calcular el promedio ajustado)
    public static double calcularPromedioAjustado(int n1, int n2, int n3, int n4, int n5){

        //Declarar la variable que recibirá la respuesta
        double promedioAjustado = 0;

        //2) Identificar la peor nota y la vamos a almacenar
        int peorNota = n1;
        if(peorNota > n2){
            peorNota = n2;
        }
        if(peorNota > n3){
            peorNota = n3;
        }
        if(peorNota > n4){
            peorNota = n4;
        }
        if(peorNota > n5){
            peorNota = n5;
        }      

        //3) Calcular el promedio ajustado, quitando la peor nota identificada
        promedioAjustado = (double)(n1+n2+n3+n4+n5-peorNota)/4;
        promedioAjustado = (promedioAjustado*5)/100;

        //Retornar el resultado
        return promedioAjustado;

    }

    //Armar el mensaje del requerimiento
    public static void generarMensajePromedio(String codigo, double promedioAjustado){
        //4) Armar el mensaje de salida como se solicita en el requerimiento
        System.out.println("El promedio ajustado del estudiante "+codigo+" es: "+promedioAjustado);
    }

    public static void main(String[] args) {

        //Interacción -> Recolección
        //1) Obtener la información del estudiante: código y las 5 notas en escala de 0 a 100
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese el codigo: ");
        String codigo = lector.nextLine();
        System.out.println("Ingrese nota1: ");
        int nota1 = lector.nextInt();
        System.out.println("Ingrese nota2: ");
        int nota2 = lector.nextInt();
        System.out.println("Ingrese nota3: ");
        int nota3 = lector.nextInt();
        System.out.println("Ingrese nota4: ");
        int nota4 = lector.nextInt();
        System.out.println("Ingrese nota5: ");
        int nota5 = lector.nextInt();

        //2) Identificar la peor nota y la vamos a almacenar
        //3) Calcular el promedio ajustado, quitando la peor nota identificada
        double promedioAjustado = calcularPromedioAjustado(nota1, nota2, nota3, nota4, nota5);

        //4) Armar el mensaje de salida como se solicita en el requerimiento
        generarMensajePromedio(codigo, promedioAjustado);


        
    }
        
}
