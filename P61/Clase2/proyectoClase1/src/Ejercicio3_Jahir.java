public class Ejercicio3_Jahir {
    public static int[] potenciaDosYTres(int numero1)
     {
          int[]resultado=new int[2];
          int potencia2 = numero1*numero1;
          int potencia3 = numero1*numero1*numero1;
          resultado[0]=potencia2;
          resultado[1]=potencia3;
          return resultado;
     }

     public static void main(String[] args) {
          var sc = new Scanner(System.in);
          System.out.println("Por favor ingrese un numero entero: ");
          var numero1 = sc.nextInt();
          var potencias = potenciaDosYTres(numero1);
          System.out.println("El doble y triple del numero ingresado es: "+ potencias[0] +","+potencias[1]);
          
     }
     
}

