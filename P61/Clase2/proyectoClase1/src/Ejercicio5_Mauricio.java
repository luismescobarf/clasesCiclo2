import java.util.Scanner;

public class Ejercicio5_Mauricio {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        System.out.println("escriba un numero entero");

        var numero = sc.nextInt();
        var paronone = verificacion(numero);
        
        System.out.println(numero + " es " + paronone);
    
    }
    
    public static String verificacion(int numero) {
        String result = (numero%2 == 0 ) ? "Par." : "Impar.";

        //Equivalente a la línea anterior
        // if(numero%2 == 0){
        //     result = "Par.";
        // }else{
        //     result = "Impar.";
        // }
                    
        return result;
    }
    
}
