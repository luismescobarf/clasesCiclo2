package co.edu.utp.misiontic2022.c2;

import java.util.ArrayList;

public class JugadorO extends Jugador{

    //Constructor
    JugadorO(String pNombreJugador, int pMovimientoLogico, String pMovimientoConsola){
        super(pNombreJugador, pMovimientoLogico, pMovimientoConsola);
    }

    //Métodos

    //Elegir casilla Inferior Derecha
    public Casilla elegirCasillaID(Tablero tablero){

        //Preparar la casilla que vamos a retornar como seleccionada
        Casilla casillaElegida = new Casilla();

        //Obtener casillas vacías
        ArrayList<Casilla> casillasLibres = tablero.obtenerCasillasVacias();

        //Seleccionar la que se encuentra más cerca de la esquina Inferior Derecha
        casillaElegida = casillasLibres.get( casillasLibres.size()-1 );

        //Retornamos la casilla libre que está más cerca de la esquina ID
        return casillaElegida;

    }

    //Implementación del método abstracto
    public void ejecutarEstrategiaEspecifica(Tablero tablero){

        //Alternar entre elegir esquina inferior derecha o completamente aleatorio
        
        //Selección aleatoria de la estrategia        
        double estrategiaElegida = Math.random();//Aleatorio entre 0.0 y 1.0
        if(estrategiaElegida > 0.5 ){
            super.ejecutarEstrategiaAleatoria(tablero);
            //System.out.println("Aleatorio elegido");
        }else{
            super.realizarMovimiento(this.elegirCasillaID(tablero), tablero);
            //System.out.println("ID elegido");
        }

    }
    
}
