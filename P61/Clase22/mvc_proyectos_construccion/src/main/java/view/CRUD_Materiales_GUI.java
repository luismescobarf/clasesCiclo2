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
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Image;

import controller.ControladorRequerimientosReto4;

import model.vo.MaterialConstruccion;
import java.util.ArrayList;

public class CRUD_Materiales_GUI extends JFrame {

    //Atributos -> Componentes intermedios y componentes
    private JTable jtMateriales;
    private DefaultTableModel modeloTablaMateriales;
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
        
        //Forma básica de construcción de la tabla
        //this.jtMateriales = new JTable(this.formatoRegistros(materiales, encabezado.length), encabezado);

        //Construcción de la tabla a partir del modelo -> personalización y actualización
        modeloTablaMateriales = new DefaultTableModel(this.formatoRegistros(materiales, encabezado.length), encabezado){
            
            //Personalizar quién no es editable
            @Override
            public boolean isCellEditable(int row, int column) {                
                
                //Que sea editable cuando la columna es diferente de la primera
                return column != 0;

                //Establecer cuáles son editables (Ejemplo Alex)
                //return column == 1 || column == 3;
            }             

        };
        this.jtMateriales = new JTable(modeloTablaMateriales);
        
        //Colocar dentro de un scroll panel en caso de que sobrepase el tamaño
        JScrollPane sp = new JScrollPane(this.jtMateriales);

        //Componente intermedio tabla con los materiales
        JPanel panel = new JPanel(new GridLayout());
        panel.setBorder(new TitledBorder("Materiales del SI"));
        panel.add(sp); 
        
        //Panel para organizar formulario y acciones
        JPanel panelSectorDerecho = new JPanel(new GridLayout(2,1));
        panelSectorDerecho.setBorder(new TitledBorder("Registro de Materiales del SI"));

        //Componente intermedio para formulario de adición de material
        JPanel panelFormularioAdicion = new JPanel(new GridLayout(3,2,0,20));
        //JPanel panelFormularioAdicion = new JPanel(new GridLayout(4,2,0,40));
        //panelFormularioAdicion.setBorder(new TitledBorder("Registro de Materiales del SI"));
        
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
        
        //panelFormularioAdicion.add(panelBotones);
        panelSectorDerecho.add(panelFormularioAdicion);
        panelSectorDerecho.add(panelBotones);
        
        //Contenedor
        getContentPane().add(panel);        
        //getContentPane().add(panelFormularioAdicion);        
        getContentPane().add(panelSectorDerecho);        

        //Mostrar ventana/frame
        setSize(800,500);
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

    public JTable getJtMateriales() {
        return jtMateriales;
    }

    public void setJtMateriales(JTable jtMateriales) {
        this.jtMateriales = jtMateriales;
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

    public DefaultTableModel getModeloTablaMateriales() {
        return modeloTablaMateriales;
    }

    public void setModeloTablaMateriales(DefaultTableModel modeloTablaMateriales) {
        this.modeloTablaMateriales = modeloTablaMateriales;
    }

    

      


}
