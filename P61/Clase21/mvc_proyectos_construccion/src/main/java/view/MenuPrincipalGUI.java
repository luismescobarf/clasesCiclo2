package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Image;

import controller.ControladorRequerimientosReto4;

public class MenuPrincipalGUI extends JFrame {

    //Atributos -> Componentes intermedios y componentes
    private JButton btnRequerimiento1;
    private JButton btnRequerimiento2;
    private JButton btnRequerimiento3;
    private JButton btnCRUD_Materiales;

    //Constructor realizar la composición de la ventana
    public MenuPrincipalGUI(){

    }

    private ImageIcon redimensionarIcono(ImageIcon icono, int pixeles){        
        Image image = icono.getImage(); 
        Image newimg = image.getScaledInstance(pixeles, pixeles,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }

    //Método para composición
    public void iniciarGUI(ControladorRequerimientosReto4 controlador){
        
        //Propiedades del frame
        setTitle("Menú Principal Reto 5 / CRUD");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Agregar componentes
        btnRequerimiento1 = new JButton(redimensionarIcono(new ImageIcon("img/proyectos.png"), 64));
        btnRequerimiento1.setText("Ranking Proyectos");
        //Quién me va a escuchar
        btnRequerimiento1.addActionListener(controlador);
        //Qué voy a decir para que se haga lo que tengo asociado
        btnRequerimiento1.setActionCommand("rankingProyectos");
        
        btnRequerimiento2 = new JButton(redimensionarIcono(new ImageIcon("img/bancos.png"), 64));
        btnRequerimiento2.setText("Bancos");
        btnRequerimiento2.addActionListener(controlador);        
        btnRequerimiento2.setActionCommand("rankingBancos");

        btnRequerimiento3 = new JButton(redimensionarIcono(new ImageIcon("img/materiales.png"), 64));
        btnRequerimiento3.setText("Materiales Importados"); 
        btnRequerimiento3.addActionListener(controlador);        
        btnRequerimiento3.setActionCommand("rankingMaterialesImportados");  
        
        btnCRUD_Materiales = new JButton(redimensionarIcono(new ImageIcon("img/editar.png"), 64));
        btnCRUD_Materiales.setText("Gestión Materiales"); 
        btnCRUD_Materiales.addActionListener(controlador);        
        btnCRUD_Materiales.setActionCommand("crudMateriales");       

        //Asociar los componentes al componente intermedio o al contenedor
        
        //Componente intermedio
        JPanel panel = new JPanel(new GridLayout(4,1));
        panel.add(btnRequerimiento1);
        panel.add(btnRequerimiento2);
        panel.add(btnRequerimiento3);
        panel.add(btnCRUD_Materiales);
        
        //Contenedor
        getContentPane().add(panel);        

        //Mostrar ventana/frame
        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    //Manejo de acciones y llamados a la lógica -> Modelo (procesos)
    //MVC -> No suceda nada de lo anterior en la vista (Consola o Interfaz Gráfica)    


}
