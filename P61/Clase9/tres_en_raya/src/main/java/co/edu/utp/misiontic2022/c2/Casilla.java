package co.edu.utp.misiontic2022.c2;

public class Casilla {

    //Atributos
    private int valorLogico;
    private String valorConsola;
    private boolean libre;
    private int fila;
    private int columna;

    //Constructores
    public Casilla (){
        valorLogico = 0;
        valorConsola = "_";
        libre = true;
        fila = 0;
        columna = 0;
    }

    public Casilla (int pFila, int pColumna){
        valorLogico = 0;
        valorConsola = "_";
        libre = true;
        fila = pFila;
        columna = pColumna;
    }

    //Métodos
    public void aplicarJugada(int pValorLogico, String pValorConsola){
        this.valorLogico = pValorLogico;
        this.valorConsola = pValorConsola;
        this.libre = false;
    }

    //Getters
    public int getColumna() {
        return columna;
    }

    public int getFila() {
        return fila;
    }

    public String getValorConsola() {
        return valorConsola;
    }

    public int getValorLogico() {
        return valorLogico;
    }
    
    public boolean getLibre(){
        return libre;
    }
    
    

    //Setters
    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }
    
    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public void setValorConsola(String valorConsola) {
        this.valorConsola = valorConsola;
    }

    public void setValorLogico(int valorLogico) {
        this.valorLogico = valorLogico;
    }

    

    

}
