package mundoProblema;

public class Nota {

    //Atributos -> Variables del paradigma anterior en contexto -> Entidad representada
    public static final int APROBADO_ESCALA100 = 60;
    public static final double APROBADO_ESCALA5 = 2.99;
    public String conceptoEvaluado;
    private int escala100;
    private double escala5;
    private int escala5Redondeada;
    private String cualitativo;   

    //Métodos -> Funciones anteriores, en contexto son el comportamiento del objeto

    //Tipos Métodos:

    //1) Constructores -> Lógica (Algoritmo) de la construcción de un objeto de esta clase
    Nota(){
        this.conceptoEvaluado = "Concepto sin asignar";
        this.escala100 = 0;
        this.escala5 = 0;
        this.cualitativo = "Sin calificar"; 
    }

    Nota(int pEscala100){
        this.conceptoEvaluado = "Concepto sin asignar";
        this.escala100 = pEscala100;
        this.escala5 = (double)pEscala100/20;
        if(pEscala100 >= Nota.APROBADO_ESCALA100){
            this.cualitativo = "Aprobado"; 
        }else{
            this.cualitativo = "Reprobado"; 
        }        
    }

    Nota(double pEscala5){
        this.conceptoEvaluado = "Concepto sin asignar";
        this.escala5Redondeada = (int)pEscala5;
        this.escala100 = (int)(pEscala5 * 20);
        this.escala5 = pEscala5;
        if(pEscala5 >= Nota.APROBADO_ESCALA5){
            this.cualitativo = "Aprobado"; 
        }else{
            this.cualitativo = "Reprobado"; 
        }        
    }

    //2) Definen comportamiento
    public void mostrarNota(){        
        System.out.println("--Info Nota--");
        System.out.println("Concepto Evaluado: "+this.conceptoEvaluado);
        System.out.println("Escala100: "+this.escala100);
        System.out.println("Escala5: "+this.escala5);
        System.out.println("Cualitativo: "+this.cualitativo);
    }

    //3) Getters y Setters -> los atributos que son privados
    public int getEscala100() {
        return escala100;
    }
    public double getEscala5() {
        return escala5;
    }
    public String getCualitativo() {
        return cualitativo;
    }
    
}
