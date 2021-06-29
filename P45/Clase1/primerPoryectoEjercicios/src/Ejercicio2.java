import java.util.*;

public class Ejercicio2 {

    //Requerimiento:
    //Implemente un algoritmo que reciba un número 
    //por teclado y cuente cuántas cifras (o dígitos) 
    //contiene e imprima el mensaje en consola.

    public static int numeroCifras(int numero){

        //Declarar la variable que acumula el número de cifras
        int numCifras = 0;//Costumbre de inicializar

        //Procedimiento
        // 145 División flotante -> 14.5 
        //     División entera(tipos) -> 14 -> 1 -> 0

        //Mientras sea diferente de cero, realizar divisiones sucesivas
        //y por cada división que se realiza incrementar el acumulador
        //Python -> while numCifras!=0:
        while( numero != 0 ){
            //numCifras = numCifras / 10;//Versión genérica de actualización
            numero /= 10;//Versión resumida

            //Incremento porque acabo de eliminar una cifra
            // numCifras = numCifras + 1;
            // numCifras += 1;
            // ++numCifras;
            numCifras++;            
        }

        // //Daniel Alfaro
        // do{

        // }while(numCifras != 0)
        //Retornar lo que quede en el acumulador
        return numCifras;

    }

    public static void main(String[] args) {

        //Recolección en Python
        //numero = int(input("Ingrese un número"))       

        //Recolección del número por teclado
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un número: ");
        int numero = sc.nextInt();

        //Lógica (Algoritmo)
        int numeroCifras = numeroCifras(numero);

        //Reportar en pantalla
        System.out.println("El número de cifras es: "+numeroCifras);
        
        //No es neceario cierre para versiones relativamente recientes el cierre
        sc.close();

    }

    
}
