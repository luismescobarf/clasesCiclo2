package model.vo;

public class ProyectoRankeadoCompras {

    //Atributos
    private Integer idProyecto;
    private String clasificacion;
    private Integer gastoCompras;
    private String serial;
    
    
    public ProyectoRankeadoCompras() {
    }

    public ProyectoRankeadoCompras(Integer idProyecto, String clasificacion, Integer gastoCompras, String serial) {
        this.idProyecto = idProyecto;
        this.clasificacion = clasificacion;
        this.gastoCompras = gastoCompras;
        this.serial = serial;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Integer getGastoCompras() {
        return gastoCompras;
    }

    public void setGastoCompras(Integer gastoCompras) {
        this.gastoCompras = gastoCompras;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    

    
    
}
