package mundoProblema;

import java.util.ArrayList;

public class CarritoCompras {

    //Atributos
    private double totalVerduras;
    private double totalVerdurasOrganicas;
    private double totalVerdurasConvencionales;
    private ArrayList<Verdura> listaVerduras = new ArrayList<Verdura>();
    private int verduraObsequio = -1;

    //Constructor
    public CarritoCompras( ArrayList<Verdura> pListaVerduras ){
        this.listaVerduras = pListaVerduras;
        this.totalVerduras = 0;
        this.totalVerdurasConvencionales = 0;
        this.totalVerdurasOrganicas = 0;
    }

    //Método del requerimiento
    public void mostrarTotales(){

        //Determinar si se activa el obsequio
        int numConvencionales = 0;
        int numOrganicas = 0;

        for (int i = 0; i < this.listaVerduras.size() ; i++) {
            
            if(this.listaVerduras.get(i) instanceof Convencional){
                numConvencionales++;
                //numConvencionales+=1;
                this.totalVerdurasConvencionales += this.listaVerduras.get(i).calcularPrecio(); 
            }else if(this.listaVerduras.get(i) instanceof Organica){

                numOrganicas++;
                this.totalVerdurasOrganicas += this.listaVerduras.get(i).calcularPrecio();
                
                if(this.verduraObsequio == -1){
                    this.verduraObsequio = i;
                }else{                    
                    if( this.listaVerduras.get(this.verduraObsequio).calcularPrecio() > 
                        this.listaVerduras.get(i).calcularPrecio()
                    ){
                        this.verduraObsequio = i;
                    }
                }            
            //}else{
            }else if(this.listaVerduras.get(i) instanceof Verdura){
                this.totalVerduras += this.listaVerduras.get(i).calcularPrecio();               
            }
        }

        double totalCompra = this.totalVerduras + this.totalVerdurasConvencionales + this.totalVerdurasOrganicas;
        System.out.println("Valor verduras cultivo convencional = " + this.totalVerdurasConvencionales);
        System.out.println("Valor verduras cultivo orgánico = " + this.totalVerdurasOrganicas);
        System.out.println("Valor total compra = " + (this.totalVerduras + totalCompra));
        //System.out.println("Valor total compra = " + totalCompra);

        if(numOrganicas > numConvencionales){

            String nombreObsequio = listaVerduras.get(this.verduraObsequio).getNombre();
            int gramosObsequio = listaVerduras.get(this.verduraObsequio).gramosVenta;
            
            System.out.println("Se obsequian "+gramosObsequio+" gramos de "+nombreObsequio+ " tipo orgánico");
        }


    }
    
}
