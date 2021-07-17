package mundoProblema;

import java.util.ArrayList;

/**
 * Aplicación de Notas
 *
 */
public class App{

    public static void main( String[] args ){

        System.out.println( "Bienvenido al Sistema de Notas" );

        // //Probar la clase Nota
        // Nota nota1 = new Nota();
        // nota1.mostrarNota();
        // Nota nota2 = new Nota(77);
        // nota2.mostrarNota();
        // Nota nota3 = new Nota(2.0);        
        // nota3.mostrarNota();

        //Llamado ejemplo composición
        // Materia materia = new Materia("AA0010276","Programación Básica",40,50,39,76,96);
        // materia.calcularPromedioAjustado();
        // materia.mostrarMateria();

        //Llamado ejemplo agregación
        ArrayList<Nota> notasAgregacion = new ArrayList<Nota>();
        notasAgregacion.add(new Nota(40));
        notasAgregacion.add(new Nota(50));
        notasAgregacion.add(new Nota(39));
        notasAgregacion.add(new Nota(76));
        notasAgregacion.add(new Nota(96));
        Materia materia = new Materia("AA0010276","Programación Básica",notasAgregacion);
        materia.calcularPromedioAjustado();
        materia.mostrarMateria();        


    }

}
