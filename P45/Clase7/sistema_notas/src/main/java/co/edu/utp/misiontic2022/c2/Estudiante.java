package co.edu.utp.misiontic2022.c2;

public class Estudiante {

    //Atributos
    private int codigo;
    private String nombres;
    private String apellidos;

    //Constructores
    Estudiante(){
        this.codigo = 0;
        this.nombres = "Sin nombres asignados";
        this.apellidos = "Sin apellidos asignados";
    }

    Estudiante(int pCodigo, String pNombres, String pApellidos){
        this.codigo = pCodigo;
        this.nombres = pNombres;
        this.apellidos = pApellidos;
    }

    //Métodos -> No hemos colocado lógica, pero está posibilidad
    public void mostrarInfoEstudiante(){
        System.out.println("&&&&&& Info Estudiante &&&");
        System.out.println("Código -> "+this.codigo);
        System.out.println("Nombres -> "+this.nombres);
        System.out.println("Apellidos -> "+this.apellidos);
    }

    //Getters
    public int getCodigo() {
        return codigo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    //Setters
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

}
