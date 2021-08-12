package model.vo;

public class MaterialConstruccion {

    private Integer idMaterialConstruccion;
    private String nombreMaterial;
    private String importado;
    private Integer precioUnidad;

    public MaterialConstruccion(){

    }

    public MaterialConstruccion(Integer idMaterialConstruccion, String nombreMaterial, String importado,
            Integer precioUnidad) {
        this.idMaterialConstruccion = idMaterialConstruccion;
        this.nombreMaterial = nombreMaterial;
        this.importado = importado;
        this.precioUnidad = precioUnidad;
    }

    public void mostrarMaterialConstruccion(){
       System.out.println("----Material Cargado----"); 
       System.out.println("ID: "+this.idMaterialConstruccion);
       System.out.println("Nombre Material: "+this.nombreMaterial);
       System.out.println("Importado: "+this.importado);
       System.out.println("PrecioUnidad: "+this.precioUnidad);
       System.out.println("------------------------"); 
    }

    public Integer getIdMaterialConstruccion() {
        return idMaterialConstruccion;
    }

    public void setIdMaterialConstruccion(Integer idMaterialConstruccion) {
        this.idMaterialConstruccion = idMaterialConstruccion;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getImportado() {
        return importado;
    }

    public void setImportado(String importado) {
        this.importado = importado;
    }

    public Integer getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(Integer precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    

    
}
