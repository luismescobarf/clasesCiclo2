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


//GUI
public class Requerimiento1GUI extends JFrame {

    //Controlador
    //public static final ControladorProyectosConstruccion controlador = new ControladorProyectosConstruccion();
    //public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    //Atributos de la interfaz    
    private JTable jtTablaRequerimiento1;    

    //Método que genere la ventana
    //Alternativas  -> Constructor
    //              -> Método

    public Requerimiento1GUI(ArrayList<MaterialNacional> materiales, ControladorRequerimientosReto4 controlador){
        
        //Título
        //super.setTitle("Menú Inicial Requerimientos");
        setTitle("-----Materiales Producción Nacional Más Comprados-------");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        String[] encabezados = {"Nombre_Material","Importado","No_Compras"};        
        jtTablaRequerimiento1 = new JTable( 
                                            this.formatoMaterialesNacionales(materiales, encabezados.length), 
                                            encabezados 
                                    );
        

        JScrollPane sp = new JScrollPane(jtTablaRequerimiento1);
        JPanel panel = new JPanel();
        panel.add(sp);        
        getContentPane().add(panel);//Incorporar tabla

        //Propiedades de la ventana
        setSize(600,400);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public String[][] formatoMaterialesNacionales(ArrayList<MaterialNacional> materiales, int numeroColumnas){
        //Contenedor de los registros
        String[][] registros = new String[materiales.size()][numeroColumnas];

        //Desempaquetar información que llega en la colección de objetos
        for (int i = 0; i < registros.length; i++) {
            //Desempaquetar cada material en una fila           
            registros[i][0] = materiales.get(i).getNombreMaterial();//Cargar el nombre del material
            registros[i][1] = materiales.get(i).getImportado();
            registros[i][2] = String.valueOf(materiales.get(i).getNoCompras());           
        }

        //Retornar registros en formato de arreglo convencional
        return registros;

    }

     



    

    
}


