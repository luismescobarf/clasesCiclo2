package co.edu.utp.misiontic2022.c2;

import java.util.ArrayList;

public class Materia {
    
    //Atributos
    private String nombre;
    private double promedioAjustado;
    private double promedio;
    private String promedioCualitativo;
    private String promedioCualitativoAjustado;
    private Nota nota1; //Declarado mas no inicializado (null)
    private Nota nota2;
    private Nota nota3;
    private Nota nota4;
    private Nota nota5;
    private Nota notaExcluida;
    private Nota mejorNota;
    private Estudiante estudianteCursando;//Asociación
    private ArrayList<Nota> notasColeccion = new ArrayList<Nota>(); //Si queremos mutación de la colección
    //private Nota[] notasArregloBasico; //Si va a estar fijo

    //Constructores
    Materia(){
        this.nombre = "Sin nombre";
        this.promedioAjustado = 0;
        this.promedio = 0;
        this.promedioCualitativo = "";
        this.promedioCualitativoAjustado = "";
        this.nota1 = new Nota();
        this.nota2 = new Nota();
        this.nota3 = new Nota();
        this.nota4 = new Nota();
        this.nota5 = new Nota();
        this.notaExcluida = new Nota();
        this.mejorNota = new Nota();
    }

    Materia(int pNota1_100, int pNota2_100, int pNota3_100, int pNota4_100, int pNota5_100){
        this.nombre = "Sin nombre";
        this.promedioAjustado = 0;
        this.promedio = 0;
        this.promedioCualitativo = "";
        this.promedioCualitativoAjustado = "";
        this.nota1 = new Nota(pNota1_100);
        this.nota2 = new Nota(pNota2_100);
        this.nota3 = new Nota(pNota3_100);
        this.nota4 = new Nota(pNota4_100);
        this.nota5 = new Nota(pNota5_100);
        this.notaExcluida = new Nota();
        this.mejorNota = new Nota();

        //Inicializar el atributo tipo colección        
        this.coleccionarNotasEstaticas();

    }

    Materia(Estudiante pEstudianteCursando, int pNota1_100, int pNota2_100, int pNota3_100, int pNota4_100, int pNota5_100){        
        this.nombre = "Sin nombre";
        this.promedioAjustado = 0;
        this.promedio = 0;
        this.promedioCualitativo = "";
        this.promedioCualitativoAjustado = "";
        this.nota1 = new Nota(pNota1_100);
        this.nota2 = new Nota(pNota2_100);
        this.nota3 = new Nota(pNota3_100);
        this.nota4 = new Nota(pNota4_100);
        this.nota5 = new Nota(pNota5_100);
        this.notaExcluida = new Nota();
        this.mejorNota = new Nota();
        this.estudianteCursando = pEstudianteCursando;

        //Inicializar el atributo tipo colección
        this.coleccionarNotasEstaticas();
    }

    //Métodos generales
    private void coleccionarNotasEstaticas(){
        this.notasColeccion.add(this.nota1);
        this.notasColeccion.add(this.nota2);
        this.notasColeccion.add(this.nota3);
        this.notasColeccion.add(this.nota4);
        this.notasColeccion.add(this.nota5);
    }

    public void mostrarColeccionNotas(){    
        System.out.println("Contenido del atributo que colecciona las notas");
        for (Nota nota : notasColeccion) {
            nota.mostrarNotaConsola();
        }
    }

    public void adicionarNota(int pNota_100){
        //Construir la nota a partir de la calificiación recibida
        Nota notaRecibida = new Nota(pNota_100);
        //Coleccionamos
        this.notasColeccion.add(notaRecibida);
    }

    public void mostrarMateria(){
        System.out.println("******************Materia*****************");
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Notas:");
        this.nota1.mostrarNotaConsola();
        this.nota2.mostrarNotaConsola();
        this.nota3.mostrarNotaConsola();
        this.nota4.mostrarNotaConsola();
        this.nota5.mostrarNotaConsola();
        System.out.println("Peor Nota:");
        this.notaExcluida.mostrarNotaConsola();
        System.out.println("Mejor Nota:");
        this.mejorNota.mostrarNotaConsola();
        System.out.println("Promedio Ajustado -> "+this.promedioAjustado);
        System.out.println("Promedio Sin Ayuda -> "+this.promedio);
        System.out.println("Promedio Cualitativo Ajustado -> "+this.promedioCualitativoAjustado);
        System.out.println("Promedio Cualitativo Sin Ayuda -> "+this.promedioCualitativo);
        this.estudianteCursando.mostrarInfoEstudiante();

    }

    //Comportamiento para actualizar atrobuto notaExcluida
    public void calcularPeorNota(){
        
        //Suponer que la nota1 es la peor de todas
        this.notaExcluida = this.nota1;
        //Realizar las comparaciones
        if(this.nota2.getEscala100() < this.notaExcluida.getEscala100() ){
            this.notaExcluida = this.nota2;
        }
        if(this.nota3.getEscala100() < this.notaExcluida.getEscala100() ){
            this.notaExcluida = this.nota3;
        }
        if(this.nota4.getEscala100() < this.notaExcluida.getEscala100() ){
            this.notaExcluida = this.nota4;
        }
        if(this.nota5.getEscala100() < this.notaExcluida.getEscala100() ){
            this.notaExcluida = this.nota5;
        }

    }

    //Comportamiento para actualizar atributo mejorNota
    public void calcularMejorNota(){
        
        //Suponer que la nota1 es la mejor de todas
        this.mejorNota = this.nota1;
        //Realizar las comparaciones
        if(this.nota2.getEscala100() > this.mejorNota.getEscala100() ){
            this.mejorNota = this.nota2;
        }
        if(this.nota3.getEscala100() > this.mejorNota.getEscala100() ){
            this.mejorNota = this.nota3;
        }
        if(this.nota4.getEscala100() > this.mejorNota.getEscala100() ){
            this.mejorNota = this.nota4;
        }
        if(this.nota5.getEscala100() > this.mejorNota.getEscala100() ){
            this.mejorNota = this.nota5;
        }

    }

    //Calcular el promedio ayudando al estudiante (promedioAjustado)
    public void calcularPromedioAjustado(){
        //Identificar la peor nota
        this.calcularPeorNota();
        
        // //Local al método (cuándo utilizar this)
        // Nota nota1 = new Nota();
        // nota1.setCualitativa("Aprobado");
        // nota1.setEscala100(34);
        // nota1.convertirNota100_5();

        //Calcular el promedio excluyendo la peor nota        
        this.promedioAjustado = (nota1.getEscala100() + nota2.getEscala100() + nota3.getEscala100() + nota4.getEscala100() + nota5.getEscala100() - notaExcluida.getEscala100())/4;

        //Expresarlo en el atributo cualitativo
        Nota notaPromedioAjustado = new Nota((int)this.promedioAjustado);
        this.promedioCualitativoAjustado = notaPromedioAjustado.getCualitativa();
        
        //Aprovechamos el comportamiento de la envoltura que hicimos al promedio
        this.promedioAjustado = notaPromedioAjustado.getEscala5();

    }

    //Calcular el promedio sobre la colección (mutable) de notas
    public void calcularPromedio(int modo){//Cualquier valor entero indica promedio sobre colección
        double sumatoria = 0;
        for (Nota nota : notasColeccion) {
            sumatoria += nota.getEscala5();
        }
        this.promedio = sumatoria/this.notasColeccion.size();
    }

    //Calcular el promedio sin ayudar al estudiante
    public void calcularPromedio(){       

        //Calcular el promedio excluyendo la peor nota        
        this.promedio = (nota1.getEscala100() + nota2.getEscala100() + nota3.getEscala100() + nota4.getEscala100() + nota5.getEscala100())/5;

        //Expresarlo en el atributo cualitativo
        Nota notaPromedio = new Nota((int)this.promedio);
        this.promedioCualitativo = notaPromedio.getCualitativa();
        
        //Aprovechamos el comportamiento de la envoltura que hicimos al promedio
        this.promedio = notaPromedio.getEscala5();

    }

    //Getters
    public Nota getMejorNota() {
        return mejorNota;
    }

    public Nota getNotaExcluida() {
        return notaExcluida;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    public double getPromedioAjustado() {
        return promedioAjustado;
    }

    //Setters
    public void setNota1(Nota nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(Nota nota2) {
        this.nota2 = nota2;
    }

    public void setNota3(Nota nota3) {
        this.nota3 = nota3;
    }

    public void setNota4(Nota nota4) {
        this.nota4 = nota4;
    }

    public void setNota5(Nota nota5) {
        this.nota5 = nota5;
    }

    //Main (punto de entrada)

}
