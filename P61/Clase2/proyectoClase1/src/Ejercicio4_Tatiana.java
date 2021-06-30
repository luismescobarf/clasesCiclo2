import java.util.Scanner;

public class Ejercicio4_Tatiana {

    public static void main(String[] args){
        var sc = new Scanner(System.in);
        System.out.println("Ingrese temperatura: ");
        float temperatura = sc.nextFloat();

        var resultado = equivalencia(temperatura);
        System.out.println("La equivalencia de temperatura en grados fahrenheit es: "+resultado);
    }
    public static float equivalencia(float temperatura){
        float fahrenheit = 32 + (9*temperatura/5);
        return fahrenheit;
    }
    
}
