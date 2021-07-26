package mundoProblema;

/**
 * CarritoCompras Verduras
 *
 */
public class App{
    public static void main( String[] args ){

        //Probando comportamiento de las clases implementadas
        double sumatoria = 0;
        Organica organico1 = new Organica("Tomate Chonto", 2.0,280);
        organico1.mostrarConsola();
        Organica organico2 = new Organica("Cilantro", 1.7,95);
        organico2.mostrarConsola();
        Organica organico3 = new Organica("Aguacate",6.0,0.1,0.06);
        organico3.mostrarConsola();
        sumatoria += organico1.calcularPrecio();
        sumatoria += organico2.calcularPrecio();
        sumatoria += organico3.calcularPrecio();
        System.out.println("Valor verduras cultivo orgánico = "+sumatoria);        
        

    }


}
