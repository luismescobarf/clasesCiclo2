package model.vo;

public class BancoRankeadoAreaPromedio {

    //Atributos -> Columnas de la tabla que representa la misma entidad
    private String bancoVinculado;
    private Double areaPromedio;

    public BancoRankeadoAreaPromedio(){
        
    }

    public String getBancoVinculado() {
        return bancoVinculado;
    }
    public void setBancoVinculado(String bancoVinculado) {
        this.bancoVinculado = bancoVinculado;
    }
    public Double getAreaPromedio() {
        return areaPromedio;
    }
    public void setAreaPromedio(Double areaPromedio) {
        this.areaPromedio = areaPromedio;
    }   

    
}
