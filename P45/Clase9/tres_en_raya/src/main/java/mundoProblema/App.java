package mundoProblema;

/**
 * TresEnRaya
 *
 */
public class App{
    public static void main( String[] args ){
        System.out.println( "Tres En Raya" );

        //Probar la construcción del tablero
        Tablero tablero = new Tablero();
        System.out.println("Antes de realizar movimientos");
        tablero.mostrarTableroConsola();

        // //Forzar unas jugadas probando el comportamiento de las casillas del tablero
        // tablero.casillas[0][1].aplicarJugada(10, "X");
        // tablero.casillas[2][0].aplicarJugada(1, "O");
        // tablero.casillas[2][2].aplicarJugada(1, "O");

        // //Revisar el tablero después de forzar jugadas
        // System.out.println("Después de realizar movimientos");
        // tablero.mostrarTableroConsola();        

        // //Para sobreescritura
        // System.out.println("Llamado a método genérico heredado de Java (sobreescrito)");
        // System.out.println(tablero.casillas[0][0].toString());
        // System.out.println(tablero.casillas[0][1].toString());

        // //Poner a trabajar la versión automática del jugadorX
        // JugadorX jugadorX = new JugadorX("TripulanteMinTIC2022", 10, "X");
        // jugadorX.ejecutarEstrategiaAleatoria(tablero);
        // jugadorX.ejecutarEstrategiaEspecifica(tablero);

        // //Poner a trabajar la versión automática del jugadorO
        // JugadorO jugadorO = new JugadorO("TripulanteOOO", 1, "O");
        // jugadorO.ejecutarEstrategiaAleatoria(tablero);
        // jugadorO.ejecutarEstrategiaEspecifica(tablero);

        //Forzar alternado de turnos con jugadores asistidos por la máquina
        JugadorX jugadorX = new JugadorX("TripulanteMinTIC2022", 10, "X");
        JugadorO jugadorO = new JugadorO("TripulanteOOO", 1, "O");
        jugadorO.ejecutarEstrategiaEspecifica(tablero);
        tablero.mostrarTableroConsola();
        jugadorX.ejecutarEstrategiaEspecifica(tablero);
        tablero.mostrarTableroConsola();
        jugadorO.realizarJugadaManual(tablero);
        tablero.mostrarTableroConsola();
        jugadorX.realizarJugadaManual(tablero);

        //Revisar el tablero después de movimientos automáticos del jugadorX
        System.out.println("Después de realizar movimientos");
        tablero.mostrarTableroConsola(); 

    }
}
