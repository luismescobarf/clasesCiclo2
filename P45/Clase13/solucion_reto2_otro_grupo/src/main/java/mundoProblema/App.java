package mundoProblema;

/**
 * Empresa comercialización y cultivo de frutas
 *
 */
public class App{
    public static void main( String[] args ){

        //Pruebas parciales
        Fruta fruta1 = new Fruta("Sandía",3.8,2000,true);        
        Fruta fruta1b = new Fruta("Melón",3.8,150);        
        Fruta fruta2 = new Organica("Pitaya", 2.0,280);        
        Fruta fruta3 = new Organica("Uchuva", 1.7,95);
        Fruta fruta4 = new Organica("Banano",6.0,0.1,0.06);

        fruta1.mostrarConsola();       
        fruta1b.mostrarConsola();
        fruta2.mostrarConsola();       
        fruta3.mostrarConsola();       
        fruta4.mostrarConsola(); 
        
        double sumatoria = 0;
        sumatoria += fruta2.calcularPrecio();
        sumatoria += fruta3.calcularPrecio();
        sumatoria += fruta4.calcularPrecio();
        System.out.println("Valor frutas cultivo orgánico = "+sumatoria);

    }
}
