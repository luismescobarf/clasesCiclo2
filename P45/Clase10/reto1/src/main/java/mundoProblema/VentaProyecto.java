package mundoProblema;//Tampoco subir nombre del paquete

public class VentaProyecto {

    //Atributos
    public int tiempo;
    public double monto;
    public double interes;

    //Constructores
    public VentaProyecto(){
        this.tiempo = 0;
        this.monto = 0;
        this.interes = 0;
    }

    public VentaProyecto(int pTiempo, double pMonto, double pInteres){
        this.tiempo = pTiempo;
        this.monto = pMonto;
        this.interes = pInteres;
    }

    //Métodos
    public double calcularInteresSimple(){
        double interesSimple;
        interesSimple = this.monto * (this.interes/100) * tiempo;
        return Math.round(interesSimple);
    }

    public double calcularInteresCompuesto(){
        double interesCompuesto;
        double x = 1 + this.interes/100;
        double y = this.tiempo;
        interesCompuesto = this.monto * ( Math.pow(x,y) - 1 );
        return Math.round(interesCompuesto);
    }

    //Firma sin parámetros de entrada
    public String compararInversion(){
        double diferencia = this.calcularInteresCompuesto()-this.calcularInteresSimple();
        if(diferencia == 0){
            return "No se obtuvo diferencia entre las proyecciones, revisar los parámetros de entrada.";
        }else{
            return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + diferencia;
        }
    }

    //Firma con los parámetros especificados
    public String compararInversion(int pTiempo, double pMonto, double pInteres){
        
        //Cargar parámetros en atributos
        this.tiempo = pTiempo;
        this.monto = pMonto;
        this.interes = pInteres;

        //Aprovechar el comportamiento de comparación sobre atributos
        return this.compararInversion();        
        
    }
    
}
