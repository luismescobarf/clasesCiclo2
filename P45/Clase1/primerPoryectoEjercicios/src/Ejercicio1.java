public class Ejercicio1 {

    /*

    Hola esto es un comentario
    de varias líneas

    */

    //Comentario de una sola línea

    //Lógica que resuelve el problema del ejercicio
    // def saludo(nombre):
    //     cadenaSaludo = "Hola "+ nombre
    //     return cadenaSaludo

    //Traducción a Java
    public static String saludo(String nombre){
        String cadenaSaludo = "Hola "+ nombre;
        return cadenaSaludo;        
    }

    //Sección principal
    public static void main(String[] args) {

        String nombre = "Tripulante MisiónTIC2022";
        String cadenaSaludoCompleto = saludo(nombre);
        System.out.println(cadenaSaludoCompleto);
        
    }

    
}
