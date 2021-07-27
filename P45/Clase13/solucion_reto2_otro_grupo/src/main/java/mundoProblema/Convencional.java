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

    
}
