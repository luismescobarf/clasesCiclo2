package mundoProblema;

import java.util.ArrayList;
import java.util.Date;

public class Juego {
    
    //Atributos
    private JugadorX jugadorX;
    private JugadorO jugadorO;
    private Tablero tablero;
    private boolean empate;
    private boolean ganador;
    private ValoresLogicos turnoActual;//Valor lógico del jugador que tiene el turno actual
    public Date momentoInicio;
    public Date momentoFin;

    //Constructores
    Juego(String pNombreJugadorO, String pNombreJugadorX){

        //Construir jugadores
        this.jugadorX = new JugadorX(pNombreJugadorX, ValoresLogicos.JUGADOR_X.getValorLogico(), ValoresConsola.JUGADOR_X.getValorConsola());
        this.jugadorO = new JugadorO(pNombreJugadorO, ValoresLogicos.JUGADOR_O.getValorLogico(), ValoresConsola.JUGADOR_O.getValorConsola());

        //Construir tablero
        this.tablero = new Tablero();        

        //Atributos que controlan el juego (estado inicial)
        this.empate = false;
        this.ganador = false;

        //Aleatoriamente elegir quién inicia la partida
        if(Math.random()>0.5){
            this.turnoActual = ValoresLogicos.JUGADOR_O;
        }else{
            this.turnoActual = ValoresLogicos.JUGADOR_X;
        }

        //Momento de inicio
        this.momentoInicio = new Date();
        

    }

    //Juego va a extraer una fila, una columna, la diagonal o la diagonal contraria.
    
    //Extraer una fila
    public ArrayList<Casilla> obtenerFila(int pFila){
        ArrayList<Casilla> fila = new ArrayList<Casilla>();       
        for (int j = 0; j < Tablero.NUM_COLUMNAS; j++) {
            fila.add( this.tablero.casillas[pFila][j] );            
        }
        return fila;
    }

    public ArrayList<Casilla> obtenerColumna(int pColumna){
        ArrayList<Casilla> columna = new ArrayList<Casilla>();       
        for (int i = 0; i < Tablero.NUM_FILAS; i++) {
            columna.add( this.tablero.casillas[i][pColumna] );            
        }        
        return columna;
    }

    public ArrayList<Casilla> obtenerDiagonal(){
        ArrayList<Casilla> diagonal = new ArrayList<Casilla>();       
        for (int i = 0; i < Tablero.NUM_FILAS; i++) {
            diagonal.add( this.tablero.casillas[i][i] );            
        }        
        return diagonal;
    }

    public ArrayList<Casilla> obtenerDiagonalInversa(){
        ArrayList<Casilla> diagonalInversa = new ArrayList<Casilla>();
        int j = Tablero.NUM_COLUMNAS;
        for (int i = 0; i < Tablero.NUM_FILAS; i++) {
            diagonalInversa.add( this.tablero.casillas[i][j] );  
            j--;          
        }        
        return diagonalInversa;
    }

    //Sumatoria de una colección en general
    public int sumatoriaCasillas(ArrayList<Casilla> coleccion){
        int sumatoria = 0;
        for (Casilla casilla : coleccion) {
            sumatoria += casilla.getValorLogico();
        }
        return sumatoria;
    }

    //Sumatoria completa del tablero
    public int sumatoriaTablero(){
        int sumatoriaTotal = 0;
        for (int i = 0; i < Tablero.NUM_FILAS; i++) {
            for (int j = 0; j < Tablero.NUM_COLUMNAS; j++) {
                sumatoriaTotal += this.tablero.casillas[i][j].getValorLogico();
            }
            
        }
        return sumatoriaTotal;
    }

    //Capacidad al juego para revisar el tablero y determinar en qué estado se encuentra
    public ValoresLogicos revisarTablero(){

        //Obtener las sumatorias de las filas
        ArrayList<Integer> sumatoriaFilas = new ArrayList<Integer>();
        for (int i = 0; i < Tablero.NUM_FILAS; i++) {
            sumatoriaFilas.add(this.sumatoriaCasillas(this.obtenerFila(i)));
        }

        //Obtener las sumatorias de las columnas

        //Obtener sumatoria de la diagonal

        //Obtener sumatoria de la diagonal inversa

    }  







}
