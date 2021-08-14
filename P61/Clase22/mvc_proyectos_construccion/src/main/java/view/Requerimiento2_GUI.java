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

import model.vo.BancoRankeadoAreaPromedio;
import java.util.ArrayList;

public class Requerimiento2_GUI extends JFrame {

    //Atributos -> Componentes intermedios y componentes
    // private JButton btnRequerimiento1;
    // private JButton btnRequerimiento2;
    // private JButton btnRequerimiento3;
    private JTable jtBancos;

    //Constructor realizar la composición de la ventana
    public Requerimiento2_GUI(ArrayList<BancoRankeadoAreaPromedio> bancos){

        //Propiedades del frame
        setTitle("-----Ranking Descendente Bancos (Área Proyectos)-------");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);       

        //Construcción de la tabla que presentará los proyectos
        String[] encabezado = {"Banco_Vinculado", "Area_Promedio"};
        this.jtBancos = new JTable(this.formatoRegistros(bancos, encabezado.length), encabezado);
        JScrollPane sp = new JScrollPane(this.jtBancos);

        //Componente intermedio
        JPanel panel = new JPanel(new GridLayout());
        panel.setBorder(new TitledBorder("Ranking Bancos: Área Promedio Proyectos Respaldados"));
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

    private String[][] formatoRegistros(ArrayList<BancoRankeadoAreaPromedio> bancos, int numeroEncabezados){
        
        //Declaración del contenedor de retorno
        String[][] registros = new String[bancos.size()][numeroEncabezados];        

        //Desenvolver los objetos de la colección
        for (int i = 0; i < bancos.size(); i++) {            
            registros[i][0] = bancos.get(i).getBancoVinculado();            
            registros[i][1] = String.valueOf(bancos.get(i).getAreaPromedio());           
        }

        //Retornar registros en formato JTable
        return registros;

    }

      


}
