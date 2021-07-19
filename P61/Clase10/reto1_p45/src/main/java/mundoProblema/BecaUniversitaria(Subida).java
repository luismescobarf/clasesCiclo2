public class BecaUniversitaria {
   
    //Atributos
    private double monto;
    private double interes;
    private int tiempo;

    //Constructores
    public BecaUniversitaria(){
        this.monto = 0;
        this.interes = 0;
        this.tiempo = 0;
    }

    public BecaUniversitaria(int pTiempo,double pMonto, double pInteres){
        this.monto = pMonto;
        this.interes = pInteres;
        this.tiempo = pTiempo;
    }

    //Métodos
    public double calcularInteresSimple(){
        double interesSimple = this.monto * (this.interes/100) * this.tiempo;
        return Math.round(interesSimple);
    }    

    public double calcularInteresCompuesto(){
        double interesCompuesto = monto * (  Math.pow( 1+this.interes/100, this.tiempo) - 1 );
        return Math.round(interesCompuesto);
    }

    public String compararInversion(){
        double diferencia = 0;
        //Calcular la diferencia
        diferencia = this.calcularInteresCompuesto() - this.calcularInteresSimple();

        //Primera propuesta
        // if(diferencia == 0){
        //     return "No se obtuvo diferencia entre las proyecciones, revisar los parámetros de entrada.";
        // }else{
        //     return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + diferencia;
        // }

        //Alterna
        if(diferencia == 0){//En caso de que no se envíen (no debería ser lo común)
            return "No se obtuvo diferencia entre las proyecciones, revisar los parámetros de entrada.";
        }

        //Conducto regular es que se envían parámetros
        return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + diferencia;
        
    }

    public String compararInversion(int pTiempo,double pMonto, double pInteres){

        //Cargamos en los atributos porque calcularInteresCompuesto y calcularInteresSimple trabajan sobre estos
        this.monto = pMonto;
        this.interes = pInteres;
        this.tiempo = pTiempo;

        return this.compararInversion();

        // double diferencia = 0;
        // //Calcular la diferencia
        // diferencia = this.calcularInteresCompuesto() - this.calcularInteresSimple();

        // if(diferencia == 0){
        //     return "No se obtuvo diferencia entre las proyecciones, revisar los parámetros de entrada.";
        // }else{
        //     return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + diferencia;
        // }

    }   


}
