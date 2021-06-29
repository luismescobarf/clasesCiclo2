import java.util.*;

public class Ejercicio3 {

    //Requerimiento:
    //Determinar si es par o impar el valor ingresado y reportar en consola.

    public static boolean esPar(int numero){
        if(numero % 2 == 0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {

        //Recolección en Python
        //numero = int(input("Ingrese un número"))       

        //Recolección del número por teclado
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un número: ");
        int numero = sc.nextInt();

        //Lógica (Algoritmo)
        if(esPar(numero)){
            //Reportar en pantalla
            System.out.println("El número "+numero+" es par");
        }else{
            //Reportar en pantalla
            System.out.println("El número "+numero+" es impar4");
        }        
        
        //No es neceario cierre para versiones relativamente recientes el cierre
        sc.close();

    }

    
}
