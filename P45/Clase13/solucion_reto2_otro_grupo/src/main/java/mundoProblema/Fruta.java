package mundoProblema;

public class Fruta {
    
    //Atributos
    private static final int GRAMAJE_BASE_VENTA = 200;
    private String nombre;
    private double precioBase;
    protected int gramosVenta;
    protected boolean importada = false;

    //Constructores
    public Fruta(String pNombre, double pPrecio){
        this.nombre = pNombre;
        this.precioBase = pPrecio;
        this.gramosVenta = Fruta.GRAMAJE_BASE_VENTA;        
    }

    public Fruta(String pNombre, double pPrecio, int pGramosVenta){
        this(pNombre, pPrecio);
        //this.gramosVenta = pGramosVenta;//Podría recibir un pedido menor a 200 gramos             
        if(pGramosVenta < Fruta.GRAMAJE_BASE_VENTA){
            this.gramosVenta = Fruta.GRAMAJE_BASE_VENTA;
        }else{
            this.gramosVenta = pGramosVenta;
        }
        //Equivalente en una sola línea
        //this.gramosVenta = pGramosVenta < Fruta.GRAMAJE_BASE_VENTA ? Fruta.GRAMAJE_BASE_VENTA : pGramosVenta;
    }

    public Fruta(String pNombre, double pPrecio, int pGramosVenta, boolean pImportada){
        this(pNombre, pPrecio, pGramosVenta);
        this.importada = pImportada;
    }

    //Métodos
    public double calcularPrecio(){
        double precioVenta = 0;
        //Revisar si es importada
        if(this.importada){
            precioVenta = (this.precioBase * this.gramosVenta) + (this.precioBase * this.gramosVenta) * 0.10;
        }else{
            precioVenta = (this.precioBase * this.gramosVenta);
        }
        return precioVenta;
    }

    public void mostrarConsola(){
        System.out.println();
        System.out.println("****----Info Fruta-----");        
        System.out.println("Nombre:" + this.nombre);
        System.out.println("Precio Base:" + this.precioBase);
        System.out.println("Gramos Venta:" + this.gramosVenta);
        String importadoSiNo = this.importada ? "Sí" : "No";
        System.out.println("Importada: "+importadoSiNo);        
        System.out.println("Precio ->: "+ this.calcularPrecio());
    }

    //Getters y Setter
    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }
    


}
