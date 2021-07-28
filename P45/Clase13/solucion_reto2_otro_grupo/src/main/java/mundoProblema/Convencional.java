package mundoProblema;

public class Convencional extends Fruta{

    //Atributos
    private static final double RECARGO_CONVENCIONALES_BASE = 0.08;
    private double recargoConvencionales;
    private int gradoAditamentos = 1;

    //Constructores
    public Convencional(String pNombre, double pPrecio){
        super(pNombre, pPrecio);
        this.recargoConvencionales = Convencional.RECARGO_CONVENCIONALES_BASE;
    }

    public Convencional(String pNombre, double pPrecio, double pRecargo){
        this(pNombre, pPrecio);        
        this.recargoConvencionales = pRecargo;
    }

    public Convencional(String pNombre, double pPrecio, double pRecargo, int pGradoAditamentos){
        this(pNombre, pPrecio, pRecargo);        
        this.gradoAditamentos = pGradoAditamentos;
    }

    public Convencional(String pNombre, double pPrecio, double pRecargo, int pGradoAditamentos, int pGramosVenta, boolean pImportada){
        this(pNombre, pPrecio, pRecargo, pGradoAditamentos);        
        super.gramosVenta = pGramosVenta;
        super.importada = pImportada;
    }

    public Convencional(String pNombre, double pPrecio, int pGramosVenta, boolean pImportada){
        this(pNombre, pPrecio);        
        super.gramosVenta = pGramosVenta;
        super.importada = pImportada;
    }

    //Método
    public double calcularPrecio(){
        double precioVenta = super.calcularPrecio();
        double precioConvencional = precioVenta + (precioVenta*this.recargoConvencionales);
        precioConvencional += precioVenta * (0.01 * this.gradoAditamentos);
        return precioConvencional;
    }

    public void mostrarConsola(){
        System.out.println();
        System.out.println("----Info Fruta Convencional-----");
        System.out.println("Convencional: Sí");
        System.out.println("Nombre:" + super.getNombre());
        System.out.println("Precio Base:" + super.getPrecioBase());
        System.out.println("Gramos Venta:" + super.gramosVenta);
        String importadoSiNo = super.importada ? "Sí" : "No";
        System.out.println("Importada: "+importadoSiNo);
        System.out.println("Recargo Convencionales: "+this.recargoConvencionales);
        System.out.println("Grado Aditamentos: "+this.gradoAditamentos);
        System.out.println("Precio ->: "+ this.calcularPrecio());
    }
    
}
