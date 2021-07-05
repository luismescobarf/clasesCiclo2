package co.edu.utp.misiontic2022.c2;

public class numeroSuerteMonica {

    public static int obtenerNumeroSuerte(String fecha){
        int numeroSuerte = 0;

        String [] arregloFecha = fecha.split("/", 5);
        int valorDia = Integer.parseInt(arregloFecha[0]);
        int valorMes = Integer.parseInt(arregloFecha[1]);
        int valorAño = Integer.parseInt(arregloFecha[2]);

        int sumaPartesFechas = valorDia + valorMes + valorAño;

        while (sumaPartesFechas > 0) {
            numeroSuerte += sumaPartesFechas % 10;
            sumaPartesFechas = (sumaPartesFechas / 10);
        }

        return numeroSuerte;
    }

    public static void main(String[] args) {
        System.out.println(obtenerNumeroSuerte("12/07/1980"));
        
    }
    
}
