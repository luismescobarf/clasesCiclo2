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

    //Revisar el tablero para establecer si hay ganador, empate, o aún no ha terminado el juego
    public ParametroLogico revisarTablero(){

        //Realizar las sumatorias de las filas
        ArrayList<Integer> sumatoriasFilas = new ArrayList<Integer>();
        for (int i = 0; i < Tablero.NUM_FILAS; i++) {
            sumatoriasFilas.add( sumatoriaCasillas(obtenerFila(i)) );             
        }

        //Realizar las sumatorias de las columnas
        ArrayList<Integer> sumatoriasColumnas = new ArrayList<Integer>();
        for (int j = 0; j < Tablero.NUM_COLUMNAS; j++) {
            sumatoriasColumnas.add( sumatoriaCasillas(obtenerColumna(j)) );             
        }

        //Ralizar las sumatorias de las diagonales
        int sumatoriaDiagonal = sumatoriaCasillas(obtenerDiagonal());
        int sumatoriaDiagonalInversa = sumatoriaCasillas(obtenerDiagonalInversa());

        //Ganador

        //Si JugadorO Gana
        if( sumatoriasFilas.contains(ParametroLogico.LINEA_JUGADOR_O.getValorLogico()) ||
            sumatoriasColumnas.contains(ParametroLogico.LINEA_JUGADOR_O.getValorLogico()) ||
            sumatoriaDiagonal == ParametroLogico.LINEA_JUGADOR_O.getValorLogico() ||
            sumatoriaDiagonalInversa == ParametroLogico.LINEA_JUGADOR_O.getValorLogico()       
        ){
            //Retornamos el valor lógico del jugador
            return ParametroLogico.JUGADOR_O;
        }

        //Si JugadorX Gana
        if( sumatoriasFilas.contains(ParametroLogico.LINEA_JUGADOR_X.getValorLogico()) ||
            sumatoriasColumnas.contains(ParametroLogico.LINEA_JUGADOR_X.getValorLogico()) ||
            sumatoriaDiagonal == ParametroLogico.LINEA_JUGADOR_X.getValorLogico() ||
            sumatoriaDiagonalInversa == ParametroLogico.LINEA_JUGADOR_X.getValorLogico()       
        ){
            //Retornamos el valor lógico del jugador
            return ParametroLogico.JUGADOR_X;
        }

        //Empate
        int sumatoriaCompleta = this.sumatoriaTablero();
        if( sumatoriaCompleta == ParametroLogico.EMPATE_INICIANDO_O.getValorLogico() ||
            sumatoriaCompleta == ParametroLogico.EMPATE_INICIANDO_X.getValorLogico()
        ){
            return ParametroLogico.PARTIDA_EMPATADA;
        }

        //No hay ganador y no hay empate
        return ParametroLogico.SIN_GANADOR;

    }     
    
    //Método que modela el juego automático entre los jugadores X y O (bots)
    public void ejecutarJuego(ParametroLogico modo){

        //Ejecutar el juego
        while(true){

            //Quien tiene el turno juega
            if(this.turnoActual == ParametroLogico.JUGADOR_O){
                if(modo == ParametroLogico.MODO_MANUAL){
                    this.jugadorO.realizarMovimientoManual(tablero);;
                }else{
                    this.jugadorO.ejecutarEstrategiaAleatoria(tablero);
                }                
            }else{
                if(modo == ParametroLogico.MODO_MANUAL){
                    this.jugadorX.realizarMovimientoManual(tablero);;
                }else{
                    this.jugadorX.ejecutarEstrategiaAleatoria(tablero);  
                }                
            }

            //Mostrar el tablero en consola después de cada intervención
            this.tablero.mostrarTablero();

            //Comportamiento arbitral de la clase
            ParametroLogico revision = this.revisarTablero();
            if(revision == ParametroLogico.JUGADOR_O){
                System.out.println("El Jugador O -> "+ this.jugadorO.nombreJugador + " ha ganado!");
                this.empate = false;
                this.ganador = true;
                this.valorGanador = ParametroLogico.JUGADOR_O;
                break;
            }else if(revision == ParametroLogico.JUGADOR_X){
                System.out.println("El Jugador X -> "+ this.jugadorX.nombreJugador + " ha ganado!");
                this.empate = false;
                this.ganador = true;
                this.valorGanador = ParametroLogico.JUGADOR_X;
                break;
            }else if(revision == ParametroLogico.PARTIDA_EMPATADA){
                System.out.println("Empate!!!");
                this.empate = true;
                this.ganador = false;
                this.valorGanador = ParametroLogico.PARTIDA_EMPATADA;
                break;
            }else if(revision == ParametroLogico.SIN_GANADOR){
                String quienJuega = this.turnoActual == ParametroLogico.JUGADOR_O ? "Jugador O "+this.jugadorO.nombreJugador : "Jugador X "+this.jugadorX.nombreJugador;
                System.out.println("Jugando: "+quienJuega);
                System.out.println("Aún no se decide la partida...");
            }

            //Alternar el turno
            if(this.turnoActual == ParametroLogico.JUGADOR_O){
                this.turnoActual = ParametroLogico.JUGADOR_X;
            }else{
                this.turnoActual = ParametroLogico.JUGADOR_O;
            }

        }

    }

    
}
