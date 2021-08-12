package controller;

import model.vo.MaterialNacional;
import model.dao.MaterialNacionalDao;

import model.vo.ProyectoRankeadoCompras;
import model.dao.ProyectoRankeadoComprasDao;

import model.vo.CargoAsignacion;
import model.dao.CargoAsignacionDao;

import model.vo.MaterialConstruccion;
import model.dao.MaterialConstruccionDao;

import java.sql.SQLException;
import java.util.ArrayList;

import view.MenuRequerimientosGUI;
import view.Requerimiento1GUI;
import view.Requerimiento2GUI;
import view.Requerimiento3GUI;
import view.CRUD_MaterialesGUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import view.VistaRequerimientosReto4;

public class ControladorRequerimientosReto4 implements ActionListener {    

    private final MaterialNacionalDao materialNacionalDao;
    private final ProyectoRankeadoComprasDao proyectoRankeadoComprasDao;
    private final CargoAsignacionDao cargoAsignacionDao;
    private final MaterialConstruccionDao materialConstruccionDao;
    private MenuRequerimientosGUI menuRequerimientosGUI;
    private Requerimiento1GUI requerimiento1gui;
    private Requerimiento2GUI requerimiento2gui;
    private Requerimiento3GUI requerimiento3gui;
    private CRUD_MaterialesGUI crud_MaterialesGUI;

    public ControladorRequerimientosReto4(){
        this.materialNacionalDao = new MaterialNacionalDao();
        this.proyectoRankeadoComprasDao = new ProyectoRankeadoComprasDao();
        this.cargoAsignacionDao = new CargoAsignacionDao();
        this.materialConstruccionDao = new MaterialConstruccionDao();
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
            case "crudMateriales":
                //Obtener los materiales
                //Instanciar la ventana del CRUD con los materiales
                try{                    
                    this.crud_MaterialesGUI = new CRUD_MaterialesGUI( this.materialConstruccionDao.consultarTodos(), 
                                                                        this);                    
                }catch(SQLException excepcion){
                    System.err.println("Problemas consultando materiales abriendo GUI CRUD Materiales: " + excepcion);
                }                                         
            break;

            case "agregarMaterial":
                //Extraer la información del formulario y envolverla en el Value Object correspondiente
                MaterialConstruccion nuevoMaterial = new MaterialConstruccion();                
                nuevoMaterial.setNombreMaterial(this.crud_MaterialesGUI.getTxtNombreMaterial().getText());
                nuevoMaterial.setImportado(this.crud_MaterialesGUI.getTxtImportado().getText());
                Integer precioUnidad = Integer.valueOf(this.crud_MaterialesGUI.getTxtPrecioUnidad().getText());
                nuevoMaterial.setPrecioUnidad(precioUnidad);

                //Revisar VO
                nuevoMaterial.mostrarMaterialConstruccion();

                //Intentar insertar el VO generado con la interfaz
                try{
                    this.materialConstruccionDao.insertarMaterial(nuevoMaterial);
                }catch(SQLException errorRegistroMaterial){
                    System.err.println("Error registrando nuevo material! "+errorRegistroMaterial);
                }
                
                this.crud_MaterialesGUI.dispose();

                //Instanciar la ventana del CRUD con los materiales
                try{                    
                    this.crud_MaterialesGUI = new CRUD_MaterialesGUI( this.materialConstruccionDao.consultarTodos(), 
                                                                        this);                    
                }catch(SQLException excepcion){
                    System.err.println("Problemas consultando materiales abriendo GUI CRUD Materiales: " + excepcion);
                }

            break;

            case "actualizarMaterial":
                
                //Extrraer registro seleccionado del JTable
                //int[] colSeleccionadas = crud_MaterialesGUI.getJtTablaMaterialesConstruccion().getSelectedColumns();
                int[] filasSeleccionadas = crud_MaterialesGUI.getJtTablaMaterialesConstruccion().getSelectedRows();
                int numeroColumnas = crud_MaterialesGUI.getJtTablaMaterialesConstruccion().getColumnCount();
                ArrayList<String> registro = new ArrayList<String>();
                for (int j = 0; j < numeroColumnas; j++) {
                    registro.add((String)crud_MaterialesGUI.getJtTablaMaterialesConstruccion().getValueAt(filasSeleccionadas[0], j) );
                }

                //Envolver el registro en un VO
                MaterialConstruccion materialActualizado = new MaterialConstruccion();                
                materialActualizado.setIdMaterialConstruccion(Integer.valueOf(registro.get(0)));                    
                materialActualizado.setNombreMaterial(registro.get(1));       
                materialActualizado.setImportado(registro.get(2));
                materialActualizado.setPrecioUnidad(Integer.valueOf(registro.get(3))); 
                
                //Intentar actualizar
                MaterialConstruccion materialRetornado = null;                
                try{
                    materialRetornado = this.materialConstruccionDao.actualizarMaterial(materialActualizado);
                }catch(SQLException errorActualizacion){

                    System.err.println("Error controlador: "+errorActualizacion);
                    
                    JOptionPane.showMessageDialog(  this.crud_MaterialesGUI, 
                                                    "Problemas actualizando el material!!",
                                                    "Error BD",
                                                    JOptionPane.ERROR_MESSAGE
                                                    );                                        
                }
                //Si no hubo error reportar éxito
                if(materialRetornado != null){
                    JOptionPane.showMessageDialog(  this.crud_MaterialesGUI, 
                                                    "Actualización Exitosa :-D",
                                                    "Éxito",
                                                    JOptionPane.INFORMATION_MESSAGE
                                                    );                                    
                    
                } 
                
                
                

            break;

            case "eliminarMaterial":

                //Extrraer registro seleccionado del JTable
                //int[] colSeleccionadas = crud_MaterialesGUI.getJtTablaMaterialesConstruccion().getSelectedColumns();
                int[] filasSeleccionadas2 = crud_MaterialesGUI.getJtTablaMaterialesConstruccion().getSelectedRows();
                int numeroColumnas2 = crud_MaterialesGUI.getJtTablaMaterialesConstruccion().getColumnCount();
                ArrayList<String> registro2 = new ArrayList<String>();
                for (int j = 0; j < numeroColumnas2; j++) {
                    registro2.add((String)crud_MaterialesGUI.getJtTablaMaterialesConstruccion().getValueAt(filasSeleccionadas2[0], j) );
                }

                //Envolver el registro en un VO
                MaterialConstruccion materialEliminar = new MaterialConstruccion();                
                materialEliminar.setIdMaterialConstruccion(Integer.valueOf(registro2.get(0)));                    
                materialEliminar.setNombreMaterial(registro2.get(1));       
                materialEliminar.setImportado(registro2.get(2));
                materialEliminar.setPrecioUnidad(Integer.valueOf(registro2.get(3)));
                
                //Revisar material eliminar
                materialEliminar.mostrarMaterialConstruccion();
                
                //Intentar actualizar
                MaterialConstruccion materialRetornado2 = null;                
                try{
                    materialRetornado2 = this.materialConstruccionDao.eliminarMaterial(materialEliminar);
                }catch(SQLException errorEliminacion){

                    System.err.println("Error controlador: "+errorEliminacion);
                    
                    JOptionPane.showMessageDialog(  this.crud_MaterialesGUI, 
                                                    "Problemas eliminando el material!!",
                                                    "Error BD",
                                                    JOptionPane.ERROR_MESSAGE
                                                    );                                        
                }
                //Si no hubo error reportar éxito
                if(materialRetornado2 != null){
                    JOptionPane.showMessageDialog(  this.crud_MaterialesGUI, 
                                                    "Eliminación Exitosa :-D",
                                                    "Éxito",
                                                    JOptionPane.INFORMATION_MESSAGE
                                                    );                                    
                    
                } 

                this.crud_MaterialesGUI.dispose();

                //Instanciar la ventana del CRUD con los materiales
                try{                    
                    this.crud_MaterialesGUI = new CRUD_MaterialesGUI( this.materialConstruccionDao.consultarTodos(), 
                                                                        this);                    
                }catch(SQLException excepcion){
                    System.err.println("Problemas consultando materiales recargando GUI CRUD Materiales: " + excepcion);
                }

            break;

        }
        
    }
    
    
}
