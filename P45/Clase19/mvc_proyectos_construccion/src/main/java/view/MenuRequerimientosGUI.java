package view;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.IllegalFormatConversionException;
import controller.ControladorRequerimientosReto4;
import model.vo.MaterialNacional;
import model.vo.ProyectoRankeadoCompras;
import model.vo.CargoAsignacion;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//GUI
public class MenuRequerimientosGUI extends JFrame {

    //Controlador
    //public static final ControladorProyectosConstruccion controlador = new ControladorProyectosConstruccion();
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    //Atributos de la interfaz
    private JButton btnRequerimiento1;
    private JButton btnRequerimiento2;
    private JButton btnRequerimiento3;

    //Método que genere la ventana
    //Alternativas  -> Constructor
    //              -> Método

    public void iniciarGUI(){

        //Título
        //super.setTitle("Menú Inicial Requerimientos");
        setTitle("Menú Inicial Requerimientos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Crear (instanciar) los componentes        
        btnRequerimiento1 = new JButton("Materiales Más Comprados");
        btnRequerimiento1.addActionListener(controlador);//Quién nos escucha
        btnRequerimiento1.setActionCommand("requerimiento1"); //Qué decimos con este botón
        
        btnRequerimiento2 = new JButton("Ranking Proyectos Granito");
        btnRequerimiento2.addActionListener(controlador);//Quién nos escucha
        btnRequerimiento2.setActionCommand("requerimiento2");//Qué decimos con este botón

        btnRequerimiento3 = new JButton("Cargos Liderando Menos");
        btnRequerimiento3.addActionListener(controlador);//Quién nos escucha
        btnRequerimiento3.setActionCommand("requerimiento3");//Qué decimos con este botón

        //Añadir los componentes a contenedores o contenendores intermedios
        
        //Contenedor intermedio
        JPanel panel = new JPanel();
        panel.add(btnRequerimiento1);
        panel.add(btnRequerimiento2);
        panel.add(btnRequerimiento3);

        //Contenedor intermedio a la ventana
        getContentPane().add(panel);      

        //Establecer últimas propiedades del frame
        setSize(800,200);
        setLocationRelativeTo(null);
        setVisible(true);

    } 



    public static void requerimiento3(){

        System.out.println("-----Materiales Producción Nacional Más Comprados-------");       

        try{

            ArrayList<MaterialNacional> rankingMaterialesNacionales = controlador.consultarMaterialesNacionalesComprados();

            //Encabezado del resultado
            System.out.println("Nombre_Material Importado No_Compras");
            
            for (MaterialNacional materialNacional : rankingMaterialesNacionales) {
                System.out.printf("%s %s %d %n",
                    materialNacional.getNombreMaterial(),
                    materialNacional.getImportado(),
                    materialNacional.getNoCompras()
                );                
            }

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    } 
    
    public static void requerimiento4(){

        System.out.println("-----Proyectos Mayor Compra de Granito-------");       

        try{

            ArrayList<ProyectoRankeadoCompras> rankingProyectosGranito = controlador.consultarProyectosComprasGranito();

            //Encabezado del resultado
            System.out.println("ID_Proyecto Clasificacion Area_Max No_Compras_Granito");
            
            for (ProyectoRankeadoCompras proyecto : rankingProyectosGranito) {
                System.out.printf("%d %s %d %d %n",
                    proyecto.getIdProyecto(),
                    proyecto.getClasificacion(),
                    proyecto.getAreaMaxima(),
                    proyecto.getNoComprasGranito()
                );
            }

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    }

    public static void requerimiento5(){

        System.out.println("-----Cargos Menos Asignados-------");       

        try{

            ArrayList<CargoAsignacion> cargosMenosAsignados = controlador.consultarCargosMenosAsignados();

            //Encabezado del resultado
            System.out.println("Cargo Número_Proyectos");
            
            for (CargoAsignacion cargo : cargosMenosAsignados) {
                System.out.printf("%s %d %n",
                    cargo.getCargo(),
                    cargo.getNoProyectos()
                );
            }

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    }

    
}


