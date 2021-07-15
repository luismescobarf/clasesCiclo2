package mundoProblema;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Jugador {

    //Atributos
    public String nombreJugador;
    public int movimientoLogico;
    public String movimientoConsola;

    //Constructores
    Jugador(String pNombre, int pMovimientoLogico, String pMovimientoConsola){
        this.nombreJugador = pNombre;
        this.movimientoLogico = pMovimientoLogico;
        this.movimientoConsola = pMovimientoConsola;
    }

    //Comportamientos (Métodos)

    //Elegir casilla del tablero aleatoriamente para realizar la jugada
    public Casilla elegirCasillaAleatoria(Tablero tablero){
        //Espacio donde estará el objeto tipo casilla (elegida)
        Casilla casillaSeleccionada = new Casilla();

        //Solicitarle al tablero las casillas que están
        ArrayList<Casilla> casillasLibres = tablero.obtenerCasillasVacias();

        //Seleccionar casilla aleatoria
        int Min = 0;
        int Max = casillasLibres.size();
        int indiceSeleccion = Min + (int) (Math.random() * (Max-Min));
        casillaSeleccionada = casillasLibres.get(indiceSeleccion);

        //Retornar la casilla seleccionada
        return casillaSeleccionada;

    }

    //Realizar la jugada con base en la casilla elegida
    public void realizarJugada(Casilla casillaElegida, Tablero tablero){
        //Obtenemos la información de la casilla elegida
        int filaCasilla = casillaElegida.getFila();
        int columnaCasilla = casillaElegida.getColumna();
        //El jugador actualiza el tablero
        tablero.casillas[filaCasilla][columnaCasilla].aplicarJugada(this.movimientoLogico, this.movimientoConsola);        
    }

    //Realizar jugada manual
    public void realizarJugadaManual(Tablero tablero){

        //Solicitar fila y columna al usuario
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("--> Turno Jugador: "+this.nombreJugador+ " Símbolo: "+this.movimientoConsola);
        System.out.print("Ingrese la fila: ");
        int filaManual = sc.nextInt();
        System.out.print("Ingrese la columna: ");
        int columnaManual = sc.nextInt();

        //El jugador actualiza el tablero
        tablero.casillas[filaManual][columnaManual].aplicarJugada(this.movimientoLogico, this.movimientoConsola);        
    }

    //Ejecutar estrategia puramente aleatoria
    public void ejecutarEstrategiaAleatoria(Tablero tablero){
        
        //Selecciona la casilla libre aleatoriamente y efectúa ese movimiento
        this.realizarJugada(this.elegirCasillaAleatoria(tablero), tablero);

    }

    //Requisito para que al heredar se pueda instanciar y utilizar la clase
    abstract void ejecutarEstrategiaEspecifica(Tablero tablero);
    
}
