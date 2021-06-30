public class Ejercicio5_FreddyIgnacio {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un número entero: ");
        int numero=sc.nextInt();
        System.out.println(numero + " es " + validaPar(numero));
    }

    public static String validaPar(int numero) {
        String resultado = (numero%2==0)?"par":"impar";
        return resultado;
    } 
    
}
