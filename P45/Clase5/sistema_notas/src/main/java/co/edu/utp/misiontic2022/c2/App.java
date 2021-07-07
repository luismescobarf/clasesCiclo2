package co.edu.utp.misiontic2022.c2;

/**
 * Sistema de Notas
 *
 */
public class App{

    public static void main( String[] args ){
        
        //Probar nuestra clase Nota
        Nota nota1 = new Nota("Taller 2");

        //Observar el contenido
        //System.out.println(nota1);

        //Utilizar un comportamiento de la clase -> Mostrar sus atributos formateados en consola
        nota1.mostrarNota();

        //Construir segunda nota aprovechando otro comportamiento de construcción -> requerimiento
        int calificacionEscala100 = 69;
        Nota nota2 = new Nota(calificacionEscala100);
        nota2.mostrarNota();

        //Ejemplo constructor con código
        Nota notaEjemploFirmas = new Nota(34688,true);
        notaEjemploFirmas.mostrarNota();

        //Ejemplo constructor con código utilizando opción
        Nota notaEmpleandoOpcion = new Nota(45678,0);
        notaEmpleandoOpcion.mostrarNota();

        //Ejemplo constructor nota en escala de 100 utilizando opción
        Nota notaOpcion100 = new Nota(44,1);
        notaOpcion100.mostrarNota();

        //Ejemplo Pedro Miguel
        double calificacionPedro = 4;
        Nota notaPedro = new Nota("Taller Pedro",(double)4);
        notaPedro.mostrarNota();

    }

}
