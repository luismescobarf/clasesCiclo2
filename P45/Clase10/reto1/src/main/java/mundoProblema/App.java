package mundoProblema;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Caso de prueba 1
        VentaProyecto ventaConstruccion = new VentaProyecto();
        System.out.println(ventaConstruccion.calcularInteresSimple()); 
        System.out.println(ventaConstruccion.calcularInteresCompuesto()); 
        System.out.println(ventaConstruccion.compararInversion(36,200000,5.0));

        //Caso de prueba 2
        VentaProyecto ventaConstruccion2 = new VentaProyecto(12,150000,2.0);
        System.out.println(ventaConstruccion2.calcularInteresSimple()); 
        System.out.println(ventaConstruccion2.calcularInteresCompuesto()); 
        System.out.println(ventaConstruccion2.compararInversion());

        //Caso de prueba 3
        VentaProyecto ventaConstruccion3 = new VentaProyecto();
        System.out.println(ventaConstruccion3.calcularInteresSimple()); 
        System.out.println(ventaConstruccion3.calcularInteresCompuesto()); 
        System.out.println(ventaConstruccion3.compararInversion());
    }
}
