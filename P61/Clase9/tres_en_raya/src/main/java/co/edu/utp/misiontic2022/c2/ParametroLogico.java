package co.edu.utp.misiontic2022.c2;

public enum ParametroLogico {

    //Valores lógicos JugadorO
    JUGADOR_O(1), LINEA_JUGADOR_O(3),
    //Valores lógicos JugadorX
    JUGADOR_X(10), LINEA_JUGADOR_X(30),
    //Situaciones de empate
    EMPATE_INICIANDO_O(45), EMPATE_INICIANDO_X(54), PARTIDA_EMPATADA(1), SIN_GANADOR(0),
    //Modo de juego
    MODO_MANUAL(1),MODO_SIMULACION(0);

    //Atributo que representa el valor
    private int valorLogico;

    //Constructor
    ParametroLogico(int pValorLogico){
        this.valorLogico = pValorLogico;
    }

    //Getter
    public int getValorLogico() {
        return valorLogico;
    }

    
}
