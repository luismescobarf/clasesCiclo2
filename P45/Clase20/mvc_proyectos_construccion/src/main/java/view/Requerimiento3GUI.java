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
public class Requerimiento3GUI extends JFrame {

    //Controlador
    //public static final ControladorProyectosConstruccion controlador = new ControladorProyectosConstruccion();
    //public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    //Atributos de la interfaz
    private JTable jtTablaRequerimiento3;    

    //Método que genere la ventana
    //Alternativas  -> Constructor
    //              -> Método

    public Requerimiento3GUI(ArrayList<CargoAsignacion> cargosAsignados, ControladorRequerimientosReto4 controlador){        
        
        setLayout(new GridLayout());

        //Título
        //super.setTitle("Menú Inicial Requerimientos");        
        setTitle("-----Cargos Menos Asignados-------");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        String[] encabezados = {"Cargo","No_Proyectos"};        
        jtTablaRequerimiento3 = new JTable( 
                                            this.formatoRegistro(cargosAsignados, encabezados.length), 
                                            encabezados 
                                    );
        

        JScrollPane sp = new JScrollPane(jtTablaRequerimiento3);
        JPanel panel = new JPanel( new GridLayout() );
        panel.add(sp);  
        panel.setBorder(new TitledBorder("Cargos Menos Asignados"));      
        getContentPane().add(panel);//Incorporar tabla

        //Propiedades de la ventana
        setSize(600,400);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public String[][] formatoRegistro(ArrayList<CargoAsignacion> cargosAsignados, int numeroColumnas){
        //Contenedor de los registros
        String[][] registros = new String[cargosAsignados.size()][numeroColumnas];

        //Desempaquetar información que llega en la colección de objetos
        for (int i = 0; i < registros.length; i++) {
            //Desempaquetar cada material en una fila                       
            registros[i][0] = cargosAsignados.get(i).getCargo();            
            registros[i][1] = String.valueOf(cargosAsignados.get(i).getNoProyectos());
        }

        //Retornar registros en formato de arreglo convencional
        return registros;

    }

    

     



    

    
}


