package mundoProblema;

import java.util.ArrayList;

/**
 * Empresa comercialización y cultivo de frutas
 *
 */
public class App{
    public static void main( String[] args ){

        // //Pruebas parciales
        // Fruta fruta1 = new Fruta("Sandía",3.8,2000,true);        
        // Fruta fruta1b = new Fruta("Melón",3.8,150);        
        // Fruta fruta2 = new Organica("Pitaya", 2.0,280);        
        // Fruta fruta3 = new Organica("Uchuva", 1.7,95);
        // Fruta fruta4 = new Organica("Banano",6.0,0.1,0.06);

        // fruta1.mostrarConsola();       
        // fruta1b.mostrarConsola();
        // fruta2.mostrarConsola();       
        // fruta3.mostrarConsola();       
        // fruta4.mostrarConsola(); 
        
        // double sumatoria = 0;
        // sumatoria += fruta2.calcularPrecio();
        // sumatoria += fruta3.calcularPrecio();
        // sumatoria += fruta4.calcularPrecio();
        // System.out.println("Valor frutas cultivo orgánico = "+sumatoria);

        // Convencional convencional1 = new Convencional("Granadilla", 4.0,0.1,2,400,true);
        // convencional1.mostrarConsola();
        // System.out.println("Valor frutas cultivo convencional = "+convencional1.calcularPrecio());

        ArrayList<Fruta> frutas = new ArrayList<Fruta>();
        frutas.add(new Fruta("Sandía",3.8,2000,true));
        frutas.add(new Convencional("Granadilla", 4.0,0.1,2,400,true)); 
        frutas.add(new Organica("Pitaya", 2.0,280));
        frutas.add(new Organica("Uchuva", 1.7,95));
        frutas.add(new Organica("Banano",6.0,0.1,0.06));
        Venta ventas = new Venta(frutas);
        ventas.mostrarTotales();
        System.out.println();

        ArrayList<Fruta> frutas2 = new ArrayList<>(); 
        frutas2.add(new Fruta("Papaya",3.0,1900)); 
        frutas2.add(new Fruta("Melón",3.6,1000));
        frutas2.add(new Convencional("Manzana", 3.0, 400, true)); 
        frutas2.add(new Convencional("Naranja", 2.4, 700, false)); 
        frutas2.add(new Organica("Fresa",2.8,0.1,0.06));
        Venta ventas2 = new Venta(frutas2); 
        ventas2.mostrarTotales();


    }
}
