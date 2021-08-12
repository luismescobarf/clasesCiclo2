package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Image;

import controller.ControladorRequerimientosReto4;

import model.vo.MaterialRankeadoCompras;
import java.util.ArrayList;

public class Requerimiento3_GUI extends JFrame {

    //Atributos -> Componentes intermedios y componentes
    // private JButton btnRequerimiento1;
    // private JButton btnRequerimiento2;
    // private JButton btnRequerimiento3;
    private JTable jtMateriales;

    //Constructor realizar la composición de la ventana
    public Requerimiento3_GUI(ArrayList<MaterialRankeadoCompras> materiales){

        //Propiedades del frame
        setTitle("-----Ranking Descendente Materiales Importados (Compras)-------");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);       

        //Construcción de la tabla que presentará los proyectos
        String[] encabezado = {"Nombre_Material", "Importado", "No_Compras"};
        this.jtMateriales = new JTable(this.formatoRegistros(materiales, encabezado.length), encabezado);
        JScrollPane sp = new JScrollPane(this.jtMateriales);

        //Componente intermedio
        JPanel panel = new JPanel(new GridLayout());
        panel.setBorder(new TitledBorder("Ranking Compras Materiales Importados"));
        panel.add(sp);     
        
        //Contenedor
        getContentPane().add(panel);        

        //Mostrar ventana/frame
        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private ImageIcon redimensionarIcono(ImageIcon icono, int pixeles){        
        Image image = icono.getImage(); 
        Image newimg = image.getScaledInstance(pixeles, pixeles,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }

    private String[][] formatoRegistros(ArrayList<MaterialRankeadoCompras> materiales, int numeroEncabezados){
        
        //Declaración del contenedor de retorno
        String[][] registros = new String[materiales.size()][numeroEncabezados];        

        //Desenvolver los objetos de la colección
        for (int i = 0; i < materiales.size(); i++) {            
            registros[i][0] = materiales.get(i).getNombreMaterial();            
            registros[i][1] = materiales.get(i).getImportado();            
            registros[i][2] = String.valueOf(materiales.get(i).getNoCompras());           
        }

        //Retornar registros en formato JTable
        return registros;

    }

      


}
