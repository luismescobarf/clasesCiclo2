package co.edu.utp.misiontic2022.c2;

import java.util.ArrayList;

public class JugadorX {

    //Atributos
    public String nombreJugador;
    public int movimientoLogico;
    public String movimientoConsola;

    //Constructor(es)
    public JugadorX(String pNombreJugador, int pMovimientoLogico, String pMovimientoConsola){
        nombreJugador = pNombreJugador;
        movimientoLogico = pMovimientoLogico;
        movimientoConsola = pMovimientoConsola;
    }

    //Métodos

    //Comportamiento automático del jugador (bot)/////////
    public Casilla elegirCasillaAleatoria(ArrayList<Casilla> casillasLibres){

        //Contenedor de la casilla seleccionada
        Casilla casillaElegida = new Casilla();

        //Selección aleatoria
        int Min = 0;
        int Max = casillasLibres.size();
        int indiceElegido = Min + (int)(Math.random() * (Max-Min));
        casillaElegida = casillasLibres.get(indiceElegido);

        //Retornar la casilla elegida
        return casillaElegida;
    }

    public void realizarMovimiento(Casilla casillaSeleccionada, Tablero tablero){

        //Realizar el movimiento en el tablero con la info de la casilla seleccionada
        int fila = casillaSeleccionada.getFila();
        int columna = casillaSeleccionada.getColumna();
        tablero.casillas[fila][columna].aplicarJugada(this.movimientoLogico, this.movimientoConsola);        
        
    }

    //Juego manual -> solicitar posiciones al usuario

    
}
