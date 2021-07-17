package mundoProblema;

import java.util.ArrayList;

public class Materia {

    //Atributos
    public String nombre;
    private double promedioAjustado;
    private ArrayList<Nota> notasQuizes = new ArrayList<Nota>();
    public Nota peorNota;
    String codigoEstudianteCursando;

    //Constructores
    public Materia(String pNombre, int n1, int n2, int n3, int n4, int n5){
        this.nombre = pNombre;        
        this.notasQuizes.add(new Nota(n1));
        this.notasQuizes.add(new Nota(n2));
        this.notasQuizes.add(new Nota(n3));
        this.notasQuizes.add(new Nota(n4));
        this.notasQuizes.add(new Nota(n5));
        this.peorNota = new Nota(100);
        this.promedioAjustado = 0;
    }

    //Obtener la peor nota
    public void obtenerPeorNota(){        
        for (Nota nota : notasQuizes) {
            if(nota.getEscala100() < this.peorNota.getEscala100()){
                this.peorNota = nota;
            }
        }        
    }


    
}
