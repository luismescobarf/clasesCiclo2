package co.edu.utp.misiontic2022.c2;

public class Fibonacci { 
    
    //Constantes base de la serie
    static final int F_0 = 0;
    static final int F_1 = 1;

    // //Serie de Fibonacci -> F(N) = F(N-2) + F(N-1)
    // F(0) = 0, 
    // F(1) = 1, 
    // ----------
    // F(2) = F(0) + F(1) = 1, 
    // F(3) = F(2) + F(1) = 2,
    // F(4) = F(3) + F(2) = 3,
    // F(5) = F(3) + F(4) = 5,
    // F(6) = F(4) + F(5) = 8,

    public static void mostrarSerieFibonacci(int N){

        //Variables
        int terminoN_2 = F_0; 
        int terminoN_1 = F_1;

        //Generalizar la presentación de todos los términos
        for (int i = 0; i <= N; i++) {
            //Casos Base
            if(i==0 || i==1){
                System.out.printf("F(%d) = %d %n",i,i);                
            }else{//Caso general
                System.out.printf("F(%d) = F(%d) + F(%d) = %d %n",i,i-2,i-1,terminoN_2+terminoN_1);
                int auxiliar = terminoN_2;
                terminoN_2 = terminoN_1;
                terminoN_1 = auxiliar+terminoN_1;
            }         
        }
    }
    

    public static void main(String[] args) {

        System.out.println("Serie de Fibonacci");
        mostrarSerieFibonacci(8);
        
    }


    
    
}
