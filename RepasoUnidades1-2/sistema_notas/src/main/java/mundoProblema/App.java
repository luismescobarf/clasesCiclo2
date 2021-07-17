package mundoProblema;

/**
 * Aplicación de Notas
 *
 */
public class App{

    public static void main( String[] args ){

        System.out.println( "Bienvenido al Sistema de Notas" );

        //Probar la clase Nota
        Nota nota1 = new Nota();
        nota1.mostrarNota();
        Nota nota2 = new Nota(77);
        nota2.mostrarNota();
        Nota nota3 = new Nota(2.0);        
        nota3.mostrarNota();


    }

}
