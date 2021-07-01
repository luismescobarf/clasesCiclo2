package co.edu.utp.misiontic2022.c2;

public class Ejercicio2 {
    
    //Ejemplo de constante
    public static final int CONSTANTE_GLORIA = 12;
    public static final double IVA = 0.19;

    // //Requerimiento
    // Programa que calcule el precio de venta de un producto 
    // conociendo el precio por unidad (sin IVA) del producto, 
    // el número de productos vendidos y el porcentaje de IVA aplicado. 
    // Los datos anteriores se leerán por teclado.

    //Función que recoge precio de venta y cantidad del producto
    public static int[] leerInfoProducto(){

        //

        System.out.println("App del Número de la Suerte");
        System.out.println("Ingrese la fecha: ");
        Scanner lector = new Scanner(System.in);
        String fecha;
        fecha = lector.nextLine();
        
        lector.close();
        return fecha;
    }

    public static double calcularPrecioVenta(int precioUnidad, int cantidad){        
        
        //Variable donde se almacenará precio de venta
        double precioVenta = 0;

        precioVenta = precioUnidad * cantidad * IVA;
        precioVenta = precioVenta + (precioUnidad * cantidad);

        //Retornar precio de venta
        return precioVenta;

    }

    public static void main(String[] args) {


        
        
    }

}
