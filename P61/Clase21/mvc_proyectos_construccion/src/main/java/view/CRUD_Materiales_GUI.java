package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Image;

import controller.ControladorRequerimientosReto4;

import model.vo.MaterialConstruccion;
import java.util.ArrayList;

public class CRUD_Materiales_GUI extends JFrame {

    //Atributos -> Componentes intermedios y componentes
    private JTable jtMateriales;
    private JButton btnAdicionar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JTextField txtNombreMaterial;
    private JTextField txtImportado;
    private JTextField txtPrecioUnidad;
    private JLabel lblNombreMaterial;
    private JLabel lblImportado;
    private JLabel lblPrecioUnidad;   

    //Constructor realizar la composición de la ventana
    public CRUD_Materiales_GUI(ArrayList<MaterialConstruccion> materiales, ControladorRequerimientosReto4 controlador){

        //Propiedades del frame
        setTitle("Gestión de Materiales de Construcción");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout());      

        //Construcción de la tabla que presentará los materiales
        String[] encabezado = {"ID Material", "Nombre", "Importado", "Precio Unitario"};
        this.jtMateriales = new JTable(this.formatoRegistros(materiales, encabezado.length), encabezado);
        JScrollPane sp = new JScrollPane(this.jtMateriales);

        //Componente intermedio tabla con los materiales
        JPanel panel = new JPanel(new GridLayout());
        panel.setBorder(new TitledBorder("Materiales del SI"));
        panel.add(sp);  

        //Componente intermedio para formulario de adición de material
        JPanel panelFormularioAdicion = new JPanel(new GridLayout(4,2,0,40));
        panelFormularioAdicion.setBorder(new TitledBorder("Registro de Materiales del SI"));
        
        this.lblNombreMaterial = new JLabel("Nombre Material: ",SwingConstants.RIGHT);
        this.lblImportado = new JLabel("Importado: ",SwingConstants.RIGHT);        
        this.lblPrecioUnidad = new JLabel("Precio Unitario: ",SwingConstants.RIGHT);

        this.txtNombreMaterial = new JTextField();
        this.txtImportado = new JTextField();        
        this.txtPrecioUnidad = new JTextField();        
        
        panelFormularioAdicion.add(this.lblNombreMaterial);
        panelFormularioAdicion.add(this.txtNombreMaterial);
        panelFormularioAdicion.add(this.lblImportado);
        panelFormularioAdicion.add(this.txtImportado);
        panelFormularioAdicion.add(this.lblPrecioUnidad);
        panelFormularioAdicion.add(this.txtPrecioUnidad);
        
        //Componente intermedio de botones
        JPanel panelBotones = new JPanel(new GridLayout(1,3));
        panelBotones.setBorder(new TitledBorder("Acciones"));

        btnAdicionar = new JButton(redimensionarIcono(new ImageIcon("img/adicion.png"), 32));
        btnAdicionar.setText("Adicionar"); 
        btnAdicionar.addActionListener(controlador);        
        btnAdicionar.setActionCommand("adicionarMaterial");

        btnActualizar = new JButton(redimensionarIcono(new ImageIcon("img/actualizar.png"), 32));
        btnActualizar.setText("Actualizar"); 
        btnActualizar.addActionListener(controlador);        
        btnActualizar.setActionCommand("actualizarMaterial");

        btnEliminar = new JButton(redimensionarIcono(new ImageIcon("img/borrar.png"), 32));
        btnEliminar.setText("Borrar"); 
        btnEliminar.addActionListener(controlador);        
        btnEliminar.setActionCommand("borrarMaterial");

        panelBotones.add(btnAdicionar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar); 
        
        panelFormularioAdicion.add(panelBotones);
        
        //Contenedor
        getContentPane().add(panel);        
        getContentPane().add(panelFormularioAdicion);        

        //Mostrar ventana/frame
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private ImageIcon redimensionarIcono(ImageIcon icono, int pixeles){        
        Image image = icono.getImage(); 
        Image newimg = image.getScaledInstance(pixeles, pixeles,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }

    private String[][] formatoRegistros(ArrayList<MaterialConstruccion> materiales, int numeroEncabezados){
        
        //Declaración del contenedor de retorno
        String[][] registros = new String[materiales.size()][numeroEncabezados];        

        //Desenvolver los objetos de la colección
        for (int i = 0; i < materiales.size(); i++) {
            registros[i][0] = String.valueOf(materiales.get(i).getIdMaterialConstruccion()); 
            registros[i][1] = materiales.get(i).getNombreMaterial();            
            registros[i][2] = materiales.get(i).getImportado();
            registros[i][3] = String.valueOf(materiales.get(i).getPrecioUnidad());        
        }

        //Retornar registros en formato JTable
        return registros;

    }

      


}
