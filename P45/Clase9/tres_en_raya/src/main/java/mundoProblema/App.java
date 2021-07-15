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

        //Forzar unas jugadas probando el comportamiento de las casillas del tablero
        tablero.casillas[0][1].aplicarJugada(10, "X");
        tablero.casillas[2][0].aplicarJugada(1, "O");
        tablero.casillas[2][2].aplicarJugada(1, "O");

        //Revisar el tablero después de forzar jugadas
        System.out.println("Después de realizar movimientos");
        tablero.mostrarTableroConsola();        

        //Para sobreescritura
        System.out.println("Llamado a método genérico heredado de Java (sobreescrito)");
        System.out.println(tablero.casillas[0][0].toString());
        System.out.println(tablero.casillas[0][1].toString());

    }
}
