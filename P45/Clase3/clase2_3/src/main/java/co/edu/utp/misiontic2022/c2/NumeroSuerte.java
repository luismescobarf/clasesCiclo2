package co.edu.utp.misiontic2022.c2;

import java.util.Scanner;

public class NumeroSuerte {

    //Algoritmo -> Paso a paso
    //1) Obtener la fecha en formato String (Cadena DD/MM/AAAA)
    //2) Separar los días, los meses, y el año de la fecha y los almacenamos
    //3) Convertir días, meses y años a números
    //4) Sumamos los días, los meses y los años y los almacenamos en una variable
    //5) Separamos las cifras del número
    //6) Sumamos las cifras del número del paso cinco
    //7) Retornamos el número de la suerte que es el resultado de la suma
    

    //Funciones de interacción (Interfaz -> Recogemos datos y hacemos reportes o mensajes en consola)
    public static String leerFecha(){

        // //Equivalencia Python
        // print("App..")
        // fecha = input("Ingrese la fecha")
        // return fecha

        System.out.println("App del Número de la Suerte");
        System.out.println("Ingrese la fecha: ");
        Scanner lector = new Scanner(System.in);
        String fecha;
        fecha = lector.nextLine();
        lector.close();
        return fecha;
    }

    public static void presentarResultado(int numeroSuerte){
        System.out.println("El número de la suerte es: "+numeroSuerte);
    }

    //Lógica

    //Declaración del método o función en Python
    // def numeroSuerte(fechaNacimiento):
    //     pass

    //Función o método
    public static int numeroSuerte(String fechaNacimiento){
        
        //2) Separar los días, los meses, y el año de la fecha y los almacenamos
        String[] partesFecha = fechaNacimiento.split("/",5);

        //3) Convertir días, meses y años a números
        int valorDias = Integer.parseInt(partesFecha[0]);
        int valorMeses = Integer.parseInt(partesFecha[1]);
        int valorAño = Integer.parseInt(partesFecha[2]);

        //4) Sumamos los días, los meses y los años y los almacenamos en una variable
        int sumaPartes = valorDias + valorMeses + valorAño;

        //5) Separamos las cifras del número
        String sumaTexto = sumaPartes + "";

        //6) Sumamos las cifras del número del paso cinco

        // //Guía con el equivalente de Python
        // sumatoriaCifras = 0
        // for i in range(len(sumaTexto)):
        //     sumatoriaCifras += sumaTexto[i]

        int sumatoriaCifras = 0;
        for (int i = 0; i < sumaTexto.length(); i++) {         
            //Sumatoria genérica
            sumatoriaCifras = sumatoriaCifras + Character.getNumericValue( sumaTexto.charAt(i) );             
            //Forma resumida sumatoria
            //sumatoriaCifras += Character.getNumericValue( sumaTexto.charAt(i) );             
        }

        //7) Retornamos el número de la suerte que es el resultado de la suma
        return sumatoriaCifras;

    }
    
    public static void main(String[] args) {
        
        //Donde se va a ejecutar (sección principal)
        //Equivalente en Python a lo que está pegado a la margen izquierda
        presentarResultado(numeroSuerte(leerFecha()));

    }

}
