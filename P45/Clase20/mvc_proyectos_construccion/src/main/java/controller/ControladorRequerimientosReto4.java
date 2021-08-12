package controller;

import model.vo.MaterialNacional;
import model.dao.MaterialNacionalDao;

import model.vo.ProyectoRankeadoCompras;
import model.dao.ProyectoRankeadoComprasDao;

import model.vo.CargoAsignacion;
import model.dao.CargoAsignacionDao;

import java.sql.SQLException;
import java.util.ArrayList;

import view.MenuRequerimientosGUI;
import view.Requerimiento1GUI;
import view.Requerimiento2GUI;
import view.Requerimiento3GUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

import view.VistaRequerimientosReto4;

public class ControladorRequerimientosReto4 implements ActionListener {    

    private final MaterialNacionalDao materialNacionalDao;
    private final ProyectoRankeadoComprasDao proyectoRankeadoComprasDao;
    private final CargoAsignacionDao cargoAsignacionDao;
    private MenuRequerimientosGUI menuRequerimientosGUI;
    private Requerimiento1GUI requerimiento1gui;
    private Requerimiento2GUI requerimiento2gui;
    private Requerimiento3GUI requerimiento3gui;

    public ControladorRequerimientosReto4(){
        this.materialNacionalDao = new MaterialNacionalDao();
        this.proyectoRankeadoComprasDao = new ProyectoRankeadoComprasDao();
        this.cargoAsignacionDao = new CargoAsignacionDao();
        this.menuRequerimientosGUI = new MenuRequerimientosGUI();
    }

    public ArrayList<MaterialNacional> consultarMaterialesNacionalesComprados() throws SQLException {
        return this.materialNacionalDao.topMaterialesNacionales();
    }

    public ArrayList<ProyectoRankeadoCompras> consultarProyectosComprasGranito() throws SQLException {
        return this.proyectoRankeadoComprasDao.topProyectosComprasGranito();
    }

    public ArrayList<CargoAsignacion> consultarCargosMenosAsignados() throws SQLException {
        return this.cargoAsignacionDao.cargosMenosAsignados();
    }
    
    public void inicio(){
        this.menuRequerimientosGUI.iniciarGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actionCommand = ((JButton)e.getSource()).getActionCommand();        
        
        //Caminos según el evento ocurrido
        switch(actionCommand){
            case "requerimiento1":
                //System.out.println("Requerimiento 1 en construcción!");                
                try{
                    //VistaRequerimientosReto4.requerimiento3b(this.consultarMaterialesNacionalesComprados());    
                    this.requerimiento1gui = new Requerimiento1GUI( this.consultarMaterialesNacionalesComprados(), 
                                                                    this);                    
                }catch(SQLException excepcion){
                    System.err.println("Problemas consultando req1: " + excepcion);
                }                
            break;
            case "requerimiento2":
                //System.out.println("Requerimiento 2 en construcción!"); 
                //System.out.println("Requerimiento 1 en construcción!");                
                try{
                    //VistaRequerimientosReto4.requerimiento3b(this.consultarMaterialesNacionalesComprados());    
                    this.requerimiento2gui = new Requerimiento2GUI( this.consultarProyectosComprasGranito(), 
                                                                    this);                    
                }catch(SQLException excepcion){
                    System.err.println("Problemas consultando req2: " + excepcion);
                }  
            break;
            case "requerimiento3":
                //System.out.println("Requerimiento 3 en construcción!");
                try{                    
                    this.requerimiento3gui = new Requerimiento3GUI( this.consultarCargosMenosAsignados(), 
                                                                        this);                    
                    }catch(SQLException excepcion){
                        System.err.println("Problemas consultando req3: " + excepcion);
                    } 
            break;

        }
        
    }
    
    
}
