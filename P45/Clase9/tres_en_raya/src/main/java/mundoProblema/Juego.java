package mundoProblema;

import java.util.Date;

public class Juego {
    
    //Atributos
    private JugadorX jugadorX;
    private JugadorO jugadorO;
    private Tablero tablero;
    private boolean empate;
    private boolean ganador;
    private int turnoActual;//Valor lógico del jugador que tiene el turno actual
    public Date momentoInicio;
    public Date momentoFin;

    //Constructores
    Juego(String pNombreJugadorO, String pNombreJugadorX){

        //Construir jugadores
        this.jugadorX = new JugadorX(pNombreJugadorX, ValoresLogicos.JUGADOR_X.getValorLogico(), ValoresConsola.JUGADOR_X.getValorConsola());
        this.jugadorO = new JugadorO(pNombreJugadorO, ValoresLogicos.JUGADOR_O.getValorLogico(), ValoresConsola.JUGADOR_O.getValorConsola());

        //Construir tablero
        this.tablero = new Tablero();

        //Comportamiento

        //Si hay ganador

        //Quién juega?

        //Si el tablero ya está lleno y hay empate

    }




}
