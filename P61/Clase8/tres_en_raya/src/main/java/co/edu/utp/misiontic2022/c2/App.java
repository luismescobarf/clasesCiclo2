package co.edu.utp.misiontic2022.c2;

import java.util.ArrayList;

/**
 * Tres en raya
 *
 */
public class App{
    public static void main( String[] args ){

        System.out.println( "Bienvenido Tres en Raya" );

        //Construir tablero
        Tablero tablero = new Tablero();

        //Mostrar antes de movimiento
        tablero.mostrarTablero();

        //Construir jugadorX
        JugadorX jugadorX = new JugadorX("TripulanteX", 10, "X");
        JugadorO jugadorO = new JugadorO("TripulanteO", 1, "O");

        //El jugadorX va a realizar un movimiento aleatorio
        //jugadorX.ejecutarEstrategiaAleatoria(tablero);
        
        // //Solicitar al jugadorX varios movimientos de su estilo de juego
        // jugadorX.ejecutarEstrategiaEspecifica(tablero);
        // jugadorX.ejecutarEstrategiaAleatoria(tablero);
        // jugadorX.ejecutarEstrategiaEspecifica(tablero);

        //Solicitar jugadas o movimientos al jugadorO
        // jugadorO.ejecutarEstrategiaEspecifica(tablero);
        // jugadorO.ejecutarEstrategiaEspecifica(tablero);
        // jugadorO.ejecutarEstrategiaEspecifica(tablero); 
        
        //Solicitar movimientos alternados a los jugadores
        jugadorO.ejecutarEstrategiaEspecifica(tablero);
        jugadorX.ejecutarEstrategiaEspecifica(tablero);
        jugadorO.ejecutarEstrategiaEspecifica(tablero);
        jugadorX.ejecutarEstrategiaEspecifica(tablero);

        //Mostrar tablero después del movimiento
        tablero.mostrarTablero();

    }
}
