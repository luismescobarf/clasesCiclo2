package view;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.IllegalFormatConversionException;
import controller.ControladorRequerimientosReto4;
import model.vo.MaterialNacional;
import model.vo.ProyectoRankeadoCompras;
import model.vo.CargoAsignacion;
import model.vo.MaterialConstruccion;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;


//GUI
public class CRUD_MaterialesGUI extends JFrame {

    //Controlador
    //public static final ControladorProyectosConstruccion controlador = new ControladorProyectosConstruccion();
    //public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    //Atributos de la interfaz
    private JTable jtTablaMaterialesConstruccion;
    private JButton btnAdicionar;
    private JButton btnEliminar;
    private JButton btnActualizar;
    private JTextField txtNombreMaterial;
    private JTextField txtImportado;
    private JTextField txtPrecioUnidad;
    private JLabel lblNombreMaterial;
    private JLabel lblImportado;
    private JLabel lblPrecioUnidad;  


    //Método que genere la ventana
    //Alternativas  -> Constructor
    //              -> Método

    public CRUD_MaterialesGUI(ArrayList<MaterialConstruccion> materiales , ControladorRequerimientosReto4 controlador){        
        
        setLayout(new GridLayout(3,1,0,10));

        //Título
        //super.setTitle("Menú Inicial Requerimientos");        
        setTitle("-----Gestión Materiales Construcción-------");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        String[] encabezados = {"ID","Nombre Material","Importado", "Precio Unitario"};        
        jtTablaMaterialesConstruccion = new JTable( 
                                            this.formatoRegistro(materiales, encabezados.length), 
                                            encabezados 
                                    );
        JScrollPane sp = new JScrollPane(jtTablaMaterialesConstruccion);
        JPanel panel = new JPanel( new GridLayout() );
        panel.add(sp);         
        panel.setBorder(new TitledBorder("Materiales de Construcción"));
        
        
        JPanel panelAdicionarMaterial = new JPanel( new GridLayout(3,2) );
        panelAdicionarMaterial.setBorder(new TitledBorder("Registrar Nuevo Material"));      
        
        btnAdicionar = new JButton("Agregar");
        btnAdicionar.addActionListener(controlador);
        btnAdicionar.setActionCommand("agregarMaterial");
        
        btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(controlador);
        btnActualizar.setActionCommand("actualizarMaterial");

        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(controlador);
        btnEliminar.setActionCommand("eliminarMaterial");

        txtNombreMaterial = new JTextField();
        txtImportado = new JTextField();
        txtPrecioUnidad = new JTextField();
        
        lblNombreMaterial = new JLabel("Nombre Material: ",SwingConstants.RIGHT);
        lblImportado = new JLabel("Importado: ",SwingConstants.RIGHT);
        lblPrecioUnidad = new JLabel("Precio Unitario: ",SwingConstants.RIGHT);

        panelAdicionarMaterial.add(lblNombreMaterial);
        panelAdicionarMaterial.add(txtNombreMaterial);
        panelAdicionarMaterial.add(lblImportado);
        panelAdicionarMaterial.add(txtImportado);
        panelAdicionarMaterial.add(lblPrecioUnidad);
        panelAdicionarMaterial.add(txtPrecioUnidad);
        //panelAdicionarMaterial.add(btnAdicionar);

        //JPanel panelBotones = new JPanel(new GridLayout(1,3,20,0));
        JPanel panelBotones = new JPanel(new FlowLayout());

        panelBotones.add(btnAdicionar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        
        getContentPane().add(panel);//Incorporar tabla
        getContentPane().add(panelBotones);//Incorporar tabla        
        getContentPane().add(panelAdicionarMaterial);//Incorporar formulario para registro de material

        //Propiedades de la ventana
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public String[][] formatoRegistro(ArrayList<MaterialConstruccion> materiales, int numeroColumnas){
        //Contenedor de los registros
        String[][] registros = new String[materiales.size()][numeroColumnas];

        //Desempaquetar información que llega en la colección de objetos
        for (int i = 0; i < registros.length; i++) {
            //Desempaquetar cada material en una fila                       
            registros[i][0] = String.valueOf(materiales.get(i).getIdMaterialConstruccion()) ;            
            registros[i][1] = materiales.get(i).getNombreMaterial();
            registros[i][2] = materiales.get(i).getImportado();
            registros[i][3] = String.valueOf(materiales.get(i).getPrecioUnidad());
        }

        //Retornar registros en formato de arreglo convencional
        return registros;

    }

    public JTable getJtTablaMaterialesConstruccion() {
        return jtTablaMaterialesConstruccion;
    }

    public void setJtTablaMaterialesConstruccion(JTable jtTablaMaterialesConstruccion) {
        this.jtTablaMaterialesConstruccion = jtTablaMaterialesConstruccion;
    }

    public JTextField getTxtNombreMaterial() {
        return txtNombreMaterial;
    }

    public void setTxtNombreMaterial(JTextField txtNombreMaterial) {
        this.txtNombreMaterial = txtNombreMaterial;
    }

    public JTextField getTxtImportado() {
        return txtImportado;
    }

    public void setTxtImportado(JTextField txtImportado) {
        this.txtImportado = txtImportado;
    }

    public JTextField getTxtPrecioUnidad() {
        return txtPrecioUnidad;
    }

    public void setTxtPrecioUnidad(JTextField txtPrecioUnidad) {
        this.txtPrecioUnidad = txtPrecioUnidad;
    }

    

    

     



    

    
}


