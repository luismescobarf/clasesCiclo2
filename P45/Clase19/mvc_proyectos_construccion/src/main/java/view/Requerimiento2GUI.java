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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;


//GUI
public class Requerimiento2GUI extends JFrame {

    //Controlador
    //public static final ControladorProyectosConstruccion controlador = new ControladorProyectosConstruccion();
    //public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    //Atributos de la interfaz
    private JTable jtTablaRequerimiento1;    

    //Método que genere la ventana
    //Alternativas  -> Constructor
    //              -> Método

    public Requerimiento2GUI(ArrayList<ProyectoRankeadoCompras> proyectos, ControladorRequerimientosReto4 controlador){        
        
        setLayout(new GridLayout());

        //Título
        //super.setTitle("Menú Inicial Requerimientos");        
        setTitle("-----Proyectos Mayor Compra Granito-------");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        String[] encabezados = {"ID_Proyecto","Clasificación","Area_Max","No_Compras_Granito"};        
        jtTablaRequerimiento1 = new JTable( 
                                            this.formatoRegistro(proyectos, encabezados.length), 
                                            encabezados 
                                    );
        

        JScrollPane sp = new JScrollPane(jtTablaRequerimiento1);
        JPanel panel = new JPanel( new GridLayout() );
        panel.add(sp);  
        panel.setBorder(new TitledBorder("Compras Granito"));      
        getContentPane().add(panel);//Incorporar tabla

        //Propiedades de la ventana
        setSize(600,400);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public String[][] formatoRegistro(ArrayList<ProyectoRankeadoCompras> proyectos, int numeroColumnas){
        //Contenedor de los registros
        String[][] registros = new String[proyectos.size()][numeroColumnas];

        //Desempaquetar información que llega en la colección de objetos
        for (int i = 0; i < registros.length; i++) {
            //Desempaquetar cada material en una fila           
            registros[i][0] = String.valueOf(proyectos.get(i).getIdProyecto());
            registros[i][1] = proyectos.get(i).getClasificacion();
            registros[i][2] = String.valueOf(proyectos.get(i).getAreaMaxima());           
            registros[i][3] = String.valueOf(proyectos.get(i).getNoComprasGranito());           
        }

        //Retornar registros en formato de arreglo convencional
        return registros;

    }

    

     



    

    
}


