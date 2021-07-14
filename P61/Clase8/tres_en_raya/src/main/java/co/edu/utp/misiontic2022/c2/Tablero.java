package co.edu.utp.misiontic2022.c2;

import java.util.ArrayList;

public class Tablero {

    //Atributos
    public static final int NUM_CASILLAS = 9;
    public static final int NUM_FILAS = 3;
    public static final int NUM_COLUMNAS = 3;
    public Casilla[][] casillas = new Casilla[Tablero.NUM_FILAS][Tablero.NUM_COLUMNAS];

    //Constructores
    public Tablero(){
        for (int i = 0; i < Tablero.NUM_FILAS; i++) {
            for (int j = 0; j < Tablero.NUM_COLUMNAS; j++) {
                // casillas[i][j] = new Casilla();
                // casillas[i][j].setFila(i);
                // casillas[i][j].setColumna(j);
                this.casillas[i][j] = new Casilla(i,j);
            }
        }
    }

    //Métodos
    public ArrayList<Casilla> obtenerCasillasVacias(){

        //Declarar contenedor que recibirá las casillas vacías
        ArrayList<Casilla> casillasLibres = new ArrayList<Casilla>();
        
        //Recorrer todo el tablero buscando casillas libres
        for (int i = 0; i < Tablero.NUM_FILAS; i++) {
            for (int j = 0; j < Tablero.NUM_COLUMNAS; j++) {
                //Coleccionar aquellas casillas que están libres o vacías
                if( casillas[i][j].getLibre()  ){
                    casillasLibres.add(casillas[i][j]);
                }
            }
        }

        //Retornar colección de casillas vacías
        return casillasLibres;

    }

    public boolean estaLleno(){
        if( this.obtenerCasillasVacias().isEmpty() ){
            return true;//Está lleno
        }else{
            return false;//Tiene casillas vacías
        }
    }

    public void mostrarTablero(){
        System.out.println();
        System.out.println();
        for (int i = 0; i < Tablero.NUM_FILAS; i++) {
            for (int j = 0; j < Tablero.NUM_COLUMNAS; j++) {
                System.out.print(casillas[i][j].getValorConsola() + " ");
            }
            System.out.println();
        }
    }



    
}
