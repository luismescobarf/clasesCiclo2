package co.edu.utp.misiontic2022.c2;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Jugador {

    //Atributos
    public String nombreJugador;
    public int movimientoLogico;
    public String movimientoConsola;

    //Constructor(es)
    public Jugador(String pNombreJugador, int pMovimientoLogico, String pMovimientoConsola){
        nombreJugador = pNombreJugador;
        movimientoLogico = pMovimientoLogico;
        movimientoConsola = pMovimientoConsola;
    }

    //Métodos

    //Comportamiento automático del jugador (bot)/////////
    public Casilla elegirCasillaAleatoria(Tablero tablero){

        //Solicitar al tablero casillas libres
        ArrayList<Casilla> casillasLibres = tablero.obtenerCasillasVacias();

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

    public void ejecutarEstrategiaAleatoria(Tablero tablero){        
        realizarMovimiento(elegirCasillaAleatoria(tablero), tablero);
    }

    public void realizarMovimiento(Casilla casillaSeleccionada, Tablero tablero){

        //Realizar el movimiento en el tablero con la info de la casilla seleccionada
        int fila = casillaSeleccionada.getFila();
        int columna = casillaSeleccionada.getColumna();
        tablero.casillas[fila][columna].aplicarJugada(this.movimientoLogico, this.movimientoConsola);        
        
    }

    //Juego manual -> solicitar posiciones al usuario
    public void realizarMovimientoManual(Tablero tablero){
        
        //Interacción -> Sacarlo luego al paquete de interacción luego
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Ingresar fila: ");
        int filaIngresada = sc.nextInt();
        System.out.print("Ingresar columna: ");
        int columnaIngresada = sc.nextInt();

        //Modificar la casilla elegida manualmente
        tablero.casillas[filaIngresada][columnaIngresada].aplicarJugada(this.movimientoLogico, this.movimientoConsola);

    }
    
    //Cada clase que hereda debe implementar este método (o todos los abstractos)
    abstract void ejecutarEstrategiaEspecifica(Tablero tablero);
    
}
