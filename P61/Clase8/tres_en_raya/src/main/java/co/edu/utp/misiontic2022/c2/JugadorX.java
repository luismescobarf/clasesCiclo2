package co.edu.utp.misiontic2022.c2;

import java.util.ArrayList;

public class JugadorX extends Jugador{

    //Constructor
    JugadorX(String pNombreJugador, int pMovimientoLogico, String pMovimientoConsola){
        super(pNombreJugador, pMovimientoLogico, pMovimientoConsola);
    }

    //Elegir casilla Superior Izquierda
    public Casilla elegirCasillaSI(Tablero tablero){

        //Preparar la casilla que vamos a retornar como seleccionada
        Casilla casillaElegida = new Casilla();

        //Obtener casillas vacías
        ArrayList<Casilla> casillasLibres = tablero.obtenerCasillasVacias();

        //Seleccionar la que se encuentra más cerca de la esquina Superior Izquierda
        casillaElegida = casillasLibres.get(0);

        //Retornamos la casilla libre que está más cerca de la esquina SI
        return casillaElegida;

    }

    //Implementar método abstracto (satisfacer requisito de herencia)
    public void ejecutarEstrategiaEspecifica(Tablero tablero){
        super.realizarMovimiento(this.elegirCasillaSI(tablero), tablero);
    }

    
}
