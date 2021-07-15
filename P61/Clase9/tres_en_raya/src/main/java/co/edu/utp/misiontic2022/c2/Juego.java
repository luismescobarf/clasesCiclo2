package co.edu.utp.misiontic2022.c2;

import java.util.ArrayList;
import java.util.Date;

public class Juego {

    //Atributos
    private Tablero tablero;
    private JugadorO jugadorO;
    private JugadorX jugadorX;
    private ParametroLogico turnoActual;
    private boolean ganador;
    private boolean empate;
    private ParametroLogico valorGanador;
    private Date inicioJuego;
    private Date finJuego;

    //Constructor -> Lógica
    public Juego(String pNombreJugadorO, String pNombreJugadorX){

        //Instancias -> Composición
        this.tablero = new Tablero();
        this.jugadorO = new JugadorO(pNombreJugadorO);
        this.jugadorX = new JugadorX(pNombreJugadorX);

        //Estados iniciales
        this.empate = false;
        this.ganador = false;
        this.inicioJuego = new Date();

        //Selección aleatoria del jugador que inicia la partida
        if(Math.random()>0.5){
            this.turnoActual = ParametroLogico.JUGADOR_O;//Inicia el jugadorO
        }else{
            this.turnoActual = ParametroLogico.JUGADOR_X;//Inicia el jugadorX
        }

    }

    //Comportamiento del Juego
    public int sumatoriaTablero(){
        int sumatoria = 0;        
        for (int i = 0; i < Tablero.NUM_FILAS; i++) {
            for (int j = 0; j < Tablero.NUM_COLUMNAS; j++) {
                sumatoria += this.tablero.casillas[i][j].getValorLogico();
            }            
        }
        return sumatoria;
    }

    public ArrayList<Casilla> obtenerFila(int pFila){
        ArrayList<Casilla> fila = new ArrayList<Casilla>();
        for (int j = 0; j < Tablero.NUM_COLUMNAS; j++) {
            fila.add(this.tablero.casillas[pFila][j]);            
        }
        return fila;
    }

    public ArrayList<Casilla> obtenerColumna(int pColumna){
        ArrayList<Casilla> columna = new ArrayList<Casilla>();
        for (int i = 0; i < Tablero.NUM_FILAS; i++) {
            columna.add(tablero.casillas[i][pColumna]);                        
        } 
        return columna;
    }

    public ArrayList<Casilla> obtenerDiagonal(){
        ArrayList<Casilla> diagonal = new ArrayList<Casilla>();
        for (int i = 0; i < Tablero.NUM_FILAS; i++) {
            diagonal.add(tablero.casillas[i][i]);                        
        } 
        return diagonal;
    }

    public ArrayList<Casilla> obtenerDiagonalInversa(){
        ArrayList<Casilla> diagonalInversa = new ArrayList<Casilla>();
        int j = Tablero.NUM_COLUMNAS - 1;
        for (int i = 0; i < Tablero.NUM_FILAS; i++) {
            diagonalInversa.add(tablero.casillas[i][j]);
            j--;                        
        } 
        return diagonalInversa;
    }

    public int sumatoriaCasillas(ArrayList<Casilla> coleccionCasillas){
        int sumatoria = 0;
        for (Casilla casilla : coleccionCasillas) {
            sumatoria += casilla.getValorLogico();
        }
        return sumatoria;
    }

    
}
