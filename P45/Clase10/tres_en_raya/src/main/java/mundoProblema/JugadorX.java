package mundoProblema;

import java.util.ArrayList;

public class JugadorX extends Jugador{

    //Atributos -> Heredados

    //Establecer nuevos constructores o consumir alguno de los constructores
    //de la superclase (abstracta)
    JugadorX(String pNombre, int pMovimientoLogico, String pMovimientoConsola){
        super(pNombre, pMovimientoLogico, pMovimientoConsola);        
    }

    public Casilla elegirCasillaSI(Tablero tablero){        
        Casilla casillaElegida = new Casilla();
        ArrayList<Casilla> casillasLibres = tablero.obtenerCasillasVacias();
        casillaElegida = casillasLibres.get(0);
        return casillaElegida;
    }

    //Implementar el método abstracto pendiente (requisito)
    public void ejecutarEstrategiaEspecifica(Tablero tablero){
        //JugadorX busca la esquina superior izquierda (SI) del tablero que esté vacía
        super.realizarJugada(this.elegirCasillaSI(tablero), tablero);
    }
    
    


    
}
