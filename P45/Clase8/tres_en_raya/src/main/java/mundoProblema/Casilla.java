package mundoProblema;

public class Casilla {

    //Atributos
    private int valorLogico;
    private String valorConsola;
    private boolean libre;
    private int fila;
    private int columna;

    //Constructores
    Casilla(){
        this.valorLogico = 0;
        this.valorConsola = "_";
        this.libre = true;
        this.fila = 0;
        this.columna = 0;
    }

    Casilla(int pFila, int pColumna){
        this.valorLogico = 0;
        this.valorConsola = "_";
        this.libre = true;
        this.fila = pFila;
        this.columna = pColumna;
    }

    //Métodos -> comportamiento
    public void aplicarJugada(int pValorLogico, String pValorConsola){
        this.valorLogico = pValorLogico;
        this.valorConsola = pValorConsola;
        this.libre = false;
    }

    //Getters
    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean getLibre() {
        return libre;
    }   
    
    public String getValorConsola() {
        return valorConsola;
    }

    //Setters
    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    @Override
    public String toString() {        
        String infoCasilla = "";
        infoCasilla += "\n---InfoCasilla---\n";
        infoCasilla += "Fila: "+this.fila+"\n";
        infoCasilla += "Columna: "+this.columna+"\n";
        String mensajeLibre = this.libre ? "Si" : "No";
        infoCasilla += "Libre: "+mensajeLibre+"\n";
        return infoCasilla;
    }
    
}
