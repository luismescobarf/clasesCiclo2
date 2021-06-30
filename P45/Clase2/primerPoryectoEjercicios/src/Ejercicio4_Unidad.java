import java.util.Scanner;
//VOLVEMOS 8:27
//VOLVEMOS 8:27
//VOLVEMOS 8:27
//VOLVEMOS 8:27
public class Ejercicio4_Unidad {


    public static void tablaMultiplicar(int numero){

        //Sabemos número de veces recomendación -> for
        for(int i = 0; i<11; i = i + 1){
            //Mostrar cada operación de la tabla
            int valor = numero * i;
            System.out.println("la tabla es " + numero + "*"+  i + " = "+valor);
        }      

    }

    public static void main(String[] args) {

         System.out.println("Ingresar número:");
         Scanner sc = new Scanner(System.in);
         tablaMultiplicar(sc.nextInt());
        
    }
    
}
