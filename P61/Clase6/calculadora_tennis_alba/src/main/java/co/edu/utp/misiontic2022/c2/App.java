package co.edu.utp.misiontic2022.c2;

/**
 * App Sistema de Notas
 *
 */
public class App {
    public static void main( String[] args ){


        //Interactuar con el jugador
        Jugador jugador = new Jugador("Serena Williams","mujer",5,2,"Oro",3000,3,23,10,0);

        //Utilizar el comportamiento del jugador
        jugador.calcularProbabilidad();
        
  
    }

}