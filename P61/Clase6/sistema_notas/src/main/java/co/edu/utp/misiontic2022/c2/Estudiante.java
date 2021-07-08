package co.edu.utp.misiontic2022.c2;

public class Estudiante {

    //Atributos
    private int codigo;
    private String nombres;
    private String apellidos;
    private int semestreActual;   
    private String genero;

    //Constructores
    public Estudiante(int pCodigo, String pNombres, String pApellidos, int pSemestreActual, String pGenero ){
        this.codigo = pCodigo;
        this.nombres = pNombres;
        this.apellidos = pApellidos;
        this.semestreActual = pSemestreActual;
        this.genero = pGenero;
    }

    public Estudiante(){
        this.codigo = 0;
        this.nombres = "Nombres Sin Asignar";
        this.apellidos = "Apellidos Sin Asignar";
        this.semestreActual = 1;
        this.genero = "Sin Asignar";
    }

    //Métodos
    public void mostrarInfoEstudiante(){
        System.out.println("-----Detalles estudiante----");
        System.out.println("Código -> "+this.codigo);
        System.out.println("Nombres -> "+this.nombres);
        System.out.println("Apellidos -> "+this.apellidos);
        System.out.println("Semestre Actual -> "+this.semestreActual);
        System.out.println("Género -> "+this.genero);

    }

    //Getters
    public int getCodigo() {
        return codigo;
    }
    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getSemestreActual() {
        return semestreActual;
    }

    public String getGenero() {
        return genero;
    }

    //Setters
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setSemestreActual(int semestreActual) {
        this.semestreActual = semestreActual;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
