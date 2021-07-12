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

        //El jugadorX va a realizar un movimiento
        ArrayList<Casilla> casillasVacias = tablero.obtenerCasillasVacias();
        Casilla casillaElegida = jugadorX.elegirCasillaAleatoria(casillasVacias);
        jugadorX.realizarMovimiento(casillaElegida, tablero);

        //Mostrar tablero después del movimiento
        tablero.mostrarTablero();

    }
}
