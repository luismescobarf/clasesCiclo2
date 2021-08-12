package model.vo;

public class CargoAsignacion {

    private String cargo;
    private Integer noProyectos;

    public CargoAsignacion(){

    }

    public CargoAsignacion(String cargo, Integer noProyectos) {
        this.cargo = cargo;
        this.noProyectos = noProyectos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getNoProyectos() {
        return noProyectos;
    }

    public void setNoProyectos(Integer noProyectos) {
        this.noProyectos = noProyectos;
    }

    
    
}
