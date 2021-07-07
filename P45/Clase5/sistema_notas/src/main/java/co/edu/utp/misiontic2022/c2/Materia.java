package co.edu.utp.misiontic2022.c2;

public class Materia {

    //Atributos
    String nombre;
    double promedioAjustado;
    double promedio;
    Nota nota1;
    Nota nota2;
    Nota nota3;
    Nota nota4;
    Nota nota5;
    Nota peorNota;
    //Funcionalidad adicionales
    Nota mejorNota;

    //Constructores
    Materia(String pNombre, int n1, int n2, int n3, int n4, int n5){

        this.nombre = pNombre;

        //Construyen las notas de la materia
        this.nota1 = new Nota(n1);
        this.nota2 = new Nota(n2);
        this.nota3 = new Nota(n3);
        this.nota4 = new Nota(n4);
        this.nota5 = new Nota(n5);

        //Inicializar peorNota
        this.peorNota = new Nota();

        //Inicializar los promedios
        this.promedio = 0;
        this.promedioAjustado = 0;

    }

    //Métodos generales
    public void mostrarMateria(){
        System.out.println("**************Materia: "+this.nombre);
        this.nota1.mostrarNota();
        this.nota2.mostrarNota();
        this.nota3.mostrarNota();
        this.nota4.mostrarNota();
        this.nota5.mostrarNota();
        System.out.println("Peor Nota:");
        this.peorNota.mostrarNota();
        System.out.println("Promedio Ajustado: "+this.promedioAjustado);
    }

    public void obtenerPeorNota(){
        //Suponemos que la peor nota
        this.peorNota = this.nota1;
        //Las demás comparaciones
        if(this.nota2.getEscala100() < peorNota.getEscala100() ){
            this.peorNota = nota2;
        }
        if(this.nota3.getEscala100() < peorNota.getEscala100() ){
            this.peorNota = nota3;
        }
        if(this.nota4.getEscala100() < peorNota.getEscala100() ){
            this.peorNota = nota4;
        }
        if(this.nota5.getEscala100() < peorNota.getEscala100() ){
            this.peorNota = nota5;
        }
    }

    //Requerimiento
    public void calcularPromedioAjustado(){
        
        //Obtener la peor de las notas (carga en el atributo)
        this.obtenerPeorNota();

        //Cálculo del promedio ajustado
        this.promedioAjustado = (nota1.getEscala5()+nota2.getEscala5()+nota3.getEscala5()+nota4.getEscala5()+nota5.getEscala5()-peorNota.getEscala5())/4;        
        
    }

    public void generarMensajeProedioAjustado(){
        System.out.println("El promedio ajustado es: "+this.promedioAjustado);
    }

    //Getters
    public Nota getPeorNota() {
        return peorNota;
    }

    public double getPromedioAjustado() {
        return promedioAjustado;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
