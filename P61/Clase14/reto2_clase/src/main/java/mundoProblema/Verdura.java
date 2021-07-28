package mundoProblema;

public class Verdura {

    //Atributos
    private static final int GRAMAJE_BASE_VENTA = 200;
    private String nombre;
    private double precioBase;
    protected int gramosVenta;
    protected boolean importada = false;

    //Constructores
    public Verdura(String pNombre, double pPrecio){
        this.nombre = pNombre;
        this.precioBase = pPrecio;
        this.gramosVenta = Verdura.GRAMAJE_BASE_VENTA;
    }

    public Verdura(String pNombre, double pPrecio, int pGramosVenta){        
        this(pNombre, pPrecio);       
        this.gramosVenta = this.validarGramajeMinimo(pGramosVenta);
    }

    public Verdura(String pNombre, double pPrecio, int pGramosVenta, boolean pImportada){ 
        this(pNombre, pPrecio,pGramosVenta);
        this.importada = pImportada;
    }

    //Métodos
    private int validarGramajeMinimo(int pGramosVenta){
        if(pGramosVenta < Verdura.GRAMAJE_BASE_VENTA){
            return Verdura.GRAMAJE_BASE_VENTA;
        }else{
            return pGramosVenta;
        }
    }

    public double calcularPrecio(){
        double precioVenta = 0;
        if(this.importada){
            precioVenta = (this.precioBase  * this.gramosVenta) + (this.precioBase * this.gramosVenta * 0.10);
        }else{
            precioVenta = (this.precioBase  * this.gramosVenta);
        }
        return precioVenta;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
    
}
