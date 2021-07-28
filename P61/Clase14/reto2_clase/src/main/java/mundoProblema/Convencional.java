package mundoProblema;

public class Convencional extends Verdura {

    //Atributos
    private static final double RECARGO_CONVENCIONALES_BASE = 0.08;
    public double recargoConvencionales;
    public int gradoAditamentos = 1;

    //Constructores
    // public Convencional(String pNombre, double pPrecio){
    //     super.setNombre(pNombre);
    //     super.setPrecioBase(pPrecio);        
    //     super.gramosVenta = Verdura.GRAMAJE_BASE_VENTA;
    //     this.recargoConvencionales = Convencional.RECARGO_CONVENCIONALES_BASE;        
    // }
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

    // public Convencional(String pNombre, double pPrecio, double pRecargo, int pGradoAditamentos, int pGramosVenta, boolean pImportada){
    //     this(pNombre, pPrecio, pRecargo, pGradoAditamentos);
    //     super.gramosVenta = pGramosVenta;
    //     super.importada = pImportada;
    // }

    public Convencional(String pNombre, double pPrecio, double pRecargo, int pGradoAditamentos, int pGramosVenta, boolean pImportada){
        this(pNombre, pPrecio, pGramosVenta, pImportada);
        this.gradoAditamentos = pGradoAditamentos;
        this.recargoConvencionales = pRecargo;        
    }

    public Convencional(String pNombre, double pPrecio, int pGramosVenta, boolean pImportada){
        this(pNombre, pPrecio);
        super.gramosVenta = pGramosVenta;
        super.importada = pImportada;
    }

    // public Convencional(String pNombre, double pPrecio, int pGramosVenta, boolean pImportada){
    //     super(pNombre, pPrecio, pGramosVenta, pImportada);
    //     this.recargoConvencionales = Convencional.RECARGO_CONVENCIONALES_BASE;
    // }

    //Método -> Requerimiento
    public double calcularPrecio(){
        double precioVerdura = super.calcularPrecio();
        double precioConvencional = precioVerdura + (precioVerdura * this.recargoConvencionales);
        precioConvencional += precioVerdura * (0.01 * this.gradoAditamentos);
        return precioConvencional;
    }

    public void mostrarConsola(){
        
        System.out.println();
        System.out.println("---Info Verdura Convencional---");
        System.out.println("Convencional: Si");
        System.out.println("Nombre: "+ this.getNombre() );
        System.out.println("Precio Base: "+ this.getPrecioBase() );
        System.out.println("Gramos Venta: "+ super.gramosVenta );
        String importadaSiNo = super.importada ? "Si" : "No";
        System.out.println("Importada: "+ importadaSiNo );
        System.out.println("Recargo Convencional: "+ this.recargoConvencionales);
        System.out.println("Grado Aditamentos: "+ this.gradoAditamentos);        
        System.out.println("Precio: "+this.calcularPrecio());
        System.out.println("-----------------------------");

    }

    
}
