package co.edu.utp.misiontic2022.c2;

public class Nota {

    //1) Atributos (antes variables que estaban sueltas)
    private int escala100;
    private double escala5;
    //private double atributoPruebaFirma;//Análisis de choque de firmas 
    private String cualitativa;
    private String nombre;//Evaluación, taller, o reto correspondiente

    //2) Constructor(es)
    Nota(){
        this.escala100 = 0;
        this.escala5 = 0;
        this.cualitativa = "";
    }

    Nota(int pEscala100){
        this.escala100 = pEscala100;
        this.escala5 = (double)pEscala100 / 20;
        if(pEscala100 >= 60){
            this.cualitativa = "Aprobado";
        }else{
            this.cualitativa = "Reprobado";
        }
    }

    Nota(double pEscala5){
        this.escala5 = pEscala5;
        this.escala100 = (int)pEscala5 * 20;
        if(pEscala5 >= 2.95){
            this.cualitativa = "Aprobado";
        }else{
            this.cualitativa = "Reprobado";
        }
    }

    // //Alternativa con choque de firmas, un constructor que generaliza
    // Nota(int a, int b, int modo){

    //     if(modo == 1){

    //     }else if(modo == 2){

    //     }else if(modo == 3){

    //     }else{

    //     }

    // }

    Nota(double pEscala5, int pEscala100, String pCualitativo){
        this.escala5 = pEscala5;
        this.escala100 = pEscala100;
        this.cualitativa = pCualitativo;

    }
    
    //3) Métodos -> comportamiento
    //Forma específica de mostrar la información
    //Conversión de las notas
    public void mostrarNotaConsola(){
        System.out.println("-----InfoNota-------");
        System.out.println("Valor Escala 5 -> " + this.escala5);
        System.out.println("Valor Escala 100 -> " + this.escala100);
        System.out.println("Cualitativa  -> " + this.cualitativa);
    }

    //Conversión de notas que fueron creadas vacías y actualizadas parcialmente
    public void convertirNota5_100(){
        this.escala100 = (int)(this.escala5 * 20);
    }

    public void convertirNota100_5(){
        this.escala5 = (double)this.escala100/20;
    }

    public void convertirNota100_Cualitativo(){
        if(this.escala100 >= 60){
            this.cualitativa = "Aprobado";
        }else{
            this.cualitativa = "Reprobado";
        }
    }

    
    //4) Getters
    public String getCualitativa() {
        return cualitativa;
    }

    public int getEscala100() {
        return escala100;
    }

    public double getEscala5() {
        return escala5;
    }   

    //5) Setters
    public void setCualitativa(String cualitativa) {
        this.cualitativa = cualitativa;
    }

    public void setEscala100(int escala100) {
        this.escala100 = escala100;
    }

    public void setEscala5(double escala5) {
        this.escala5 = escala5;
    }


}
