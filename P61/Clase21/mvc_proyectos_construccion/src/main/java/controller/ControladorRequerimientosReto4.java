package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;

//Model

//Requerimiento 3
import model.vo.BancoRankeadoAreaPromedio;
import model.dao.BancoRankeadoAreaPromedioDao;
//Requerimiento 1
import model.vo.ProyectoRankeadoCompras;
import model.dao.ProyectoRankeadoComprasDao;
//Requerimiento 5
import model.vo.MaterialRankeadoCompras;
import model.dao.MaterialRankeadoComprasDao;

//View
import view.MenuPrincipalGUI;
import view.Requerimiento1_GUI;
import view.Requerimiento2_GUI;
import view.Requerimiento3_GUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControladorRequerimientosReto4 implements ActionListener {   

    //Alojar objetos del modelo
    private final ProyectoRankeadoComprasDao proyectoRankeadoComprasDao;
    private final BancoRankeadoAreaPromedioDao bancoRankeadoAreaPromedioDao;
    private final MaterialRankeadoComprasDao materialRankeadoComprasDao; 
    
    //Alojar objetos de la vista
    private final MenuPrincipalGUI menuPrincipalGUI;
    private Requerimiento1_GUI requerimiento1_GUI;
    private Requerimiento2_GUI requerimiento2_GUI;
    private Requerimiento3_GUI requerimiento3_GUI;

    //Constructor
    public ControladorRequerimientosReto4(){
        //Instanciamos los DAO      
        this.proyectoRankeadoComprasDao = new ProyectoRankeadoComprasDao();
        this.bancoRankeadoAreaPromedioDao = new BancoRankeadoAreaPromedioDao();        
        this.materialRankeadoComprasDao = new MaterialRankeadoComprasDao();
        //Instanciamos las interfaces
        this.menuPrincipalGUI = new MenuPrincipalGUI();
    }    

    //Cada requerimiento solicitado -> Casos de Uso    
    
    //Requerimiento 1 Reto3/Reto4
    public ArrayList<ProyectoRankeadoCompras> consultarProyectosCompras10() throws SQLException{
        return this.proyectoRankeadoComprasDao.rankingProyectosComprasDescendente10();
    }    

    //Requerimiento 3 Reto3/Reto4
    public ArrayList<BancoRankeadoAreaPromedio>  consultarBancosRankeadosAreaPromedio() throws SQLException{
        return this.bancoRankeadoAreaPromedioDao.rankingBancosAreaPromedioDescendente();
    }
    
    //Requerimiento 5 Reto3/Reto4
    public ArrayList<MaterialRankeadoCompras> consultarMaterialesRankeadosCompras() throws SQLException {
        return this.materialRankeadoComprasDao.rankingMaterialesComprasDescendente();
    }

    //Controlador iniciando la aplicación
    public void iniciarAplicacion(){
        this.menuPrincipalGUI.iniciarGUI(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Obtener el evento asociado al botón
        String actionCommand = ((JButton)e.getSource()).getActionCommand();

        switch(actionCommand){

            case "rankingProyectos":
                //System.out.println("()()()Interfaz Proyectos en construcción!");                
                try{
                    ArrayList<ProyectoRankeadoCompras> proyectos = new ArrayList<ProyectoRankeadoCompras>();
                    proyectos = this.proyectoRankeadoComprasDao.rankingProyectosComprasDescendente10();
                    this.requerimiento1_GUI = new Requerimiento1_GUI(proyectos);
                }catch(SQLException eProyectosCompras){
                    System.err.println("Error cargando rq1 en la ventana!! "+eProyectosCompras);
                }
            break;

            case "rankingBancos":
                //System.out.println("$$$Interfaz BANCOS en construcción!");
                try{
                    ArrayList<BancoRankeadoAreaPromedio> bancos = new ArrayList<BancoRankeadoAreaPromedio>();
                    bancos = this.bancoRankeadoAreaPromedioDao.rankingBancosAreaPromedioDescendente();
                    this.requerimiento2_GUI = new Requerimiento2_GUI(bancos);
                }catch(SQLException eBancosArea){
                    System.err.println("Error cargando rq2 en la ventana!! "+eBancosArea);
                }
            break;

            case "rankingMaterialesImportados":
                //System.out.println("--Interfaz mAtErIales en construcción!");
                try{
                    ArrayList<MaterialRankeadoCompras> materiales = new ArrayList<MaterialRankeadoCompras>();
                    materiales = this.materialRankeadoComprasDao.rankingMaterialesComprasDescendente();
                    this.requerimiento3_GUI = new Requerimiento3_GUI(materiales);
                }catch(SQLException eMateriales){
                    System.err.println("Error cargando rq3 en la ventana!! "+eMateriales);
                }
            break;

        }

    }
    
}

