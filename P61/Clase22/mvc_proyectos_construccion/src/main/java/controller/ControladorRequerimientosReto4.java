package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

//Model

//Requerimiento 3
import model.vo.BancoRankeadoAreaPromedio;
import model.vo.MaterialConstruccion;
import model.dao.BancoRankeadoAreaPromedioDao;
//Requerimiento 1
import model.vo.ProyectoRankeadoCompras;
import model.dao.ProyectoRankeadoComprasDao;
//Requerimiento 5
import model.vo.MaterialRankeadoCompras;
import model.dao.MaterialRankeadoComprasDao;

import model.vo.MaterialConstruccion;
import model.dao.MaterialConstruccionDao;

//View
import view.MenuPrincipalGUI;
import view.Requerimiento1_GUI;
import view.Requerimiento2_GUI;
import view.Requerimiento3_GUI;
import view.CRUD_Materiales_GUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControladorRequerimientosReto4 implements ActionListener {   

    //Alojar objetos del modelo
    private final ProyectoRankeadoComprasDao proyectoRankeadoComprasDao;
    private final BancoRankeadoAreaPromedioDao bancoRankeadoAreaPromedioDao;
    private final MaterialRankeadoComprasDao materialRankeadoComprasDao; 
    private final MaterialConstruccionDao materialConstruccionDao;
    
    //Alojar objetos de la vista
    private final MenuPrincipalGUI menuPrincipalGUI;
    private Requerimiento1_GUI requerimiento1_GUI;
    private Requerimiento2_GUI requerimiento2_GUI;
    private Requerimiento3_GUI requerimiento3_GUI;
    private CRUD_Materiales_GUI crud_Materiales_GUI;

    //Constructor
    public ControladorRequerimientosReto4(){
        //Instanciamos los DAO      
        this.proyectoRankeadoComprasDao = new ProyectoRankeadoComprasDao();
        this.bancoRankeadoAreaPromedioDao = new BancoRankeadoAreaPromedioDao();        
        this.materialRankeadoComprasDao = new MaterialRankeadoComprasDao();
        this.materialConstruccionDao = new MaterialConstruccionDao();
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

            case "crudMateriales":
                // JOptionPane.showMessageDialog(  this.menuPrincipalGUI, 
                //                                 "CRUD Materiales en Construcción!", 
                //                                 "SW", 
                //                                 JOptionPane.INFORMATION_MESSAGE);

                try{
                    ArrayList<MaterialConstruccion> materiales = new ArrayList<MaterialConstruccion>();
                    materiales = this.materialConstruccionDao.consultarTodos();
                    this.crud_Materiales_GUI = new CRUD_Materiales_GUI(materiales,this);                    
                }catch(SQLException eMaterialesCRUD){
                    System.err.println("Error cargando materiales de construcción (CRUD)!! "+eMaterialesCRUD);
                }                

            break;

            case "adicionarMaterial":

                //Recoger la información del formulario o de la GUI
                MaterialConstruccion nuevoMaterial = new MaterialConstruccion();
                nuevoMaterial.setNombreMaterial(crud_Materiales_GUI.getTxtNombreMaterial().getText());
                nuevoMaterial.setImportado(crud_Materiales_GUI.getTxtImportado().getText());
                int precioUnidad = 0;//Valor por defecto
                try{
                    precioUnidad = Integer.valueOf(crud_Materiales_GUI.getTxtPrecioUnidad().getText());
                }catch(NumberFormatException eFormatoPrecioUnidad){

                    try{
                        precioUnidad = Integer.valueOf(JOptionPane.showInputDialog(
                            crud_Materiales_GUI, 
                            "Ingrese un precio unitario válido (numérico): ", 
                            "Error de Formato", 
                            JOptionPane.ERROR_MESSAGE)
                        );
                    }catch(NumberFormatException errorSegundoIntento){
                        JOptionPane.showMessageDialog(
                            crud_Materiales_GUI, 
                            "Precio unitario inválido, valor por defecto establecido!!", 
                            "Error Formato", 
                            JOptionPane.ERROR_MESSAGE
                        );                      
                    }

                     
                } 
                nuevoMaterial.setPrecioUnidad(precioUnidad);            
                
                //Solicitar al modelo la adición del nuevo material
                MaterialConstruccion materialRegistrado = null;
                try{
                    materialRegistrado = materialConstruccionDao.adicionarMaterial(nuevoMaterial);
                }catch(SQLException eNuevoMaterial){
                    JOptionPane.showMessageDialog(
                        crud_Materiales_GUI, 
                        "Error insertando nuevo material!!", 
                        "Error BD", 
                        JOptionPane.ERROR_MESSAGE
                        );
                }

                //Reportar éxito y proceder a actualizar por el registro exitoso
                if(materialRegistrado != null){
                    JOptionPane.showMessageDialog(
                        crud_Materiales_GUI, 
                        "Registro exitoso!!", 
                        "Transacción Completa BD", 
                        JOptionPane.INFORMATION_MESSAGE
                        );
                    
                    //Limpiar los campos del formulario
                    crud_Materiales_GUI.getTxtNombreMaterial().setText("");
                    crud_Materiales_GUI.getTxtImportado().setText("");
                    crud_Materiales_GUI.getTxtPrecioUnidad().setText("");

                    //Actualizar la vista con el nuevo material registrado exitosamente

                    // //Versión 1 (Reconstruyendo todo el Frame)
                    // crud_Materiales_GUI.dispose();
                    // try{
                    //     crud_Materiales_GUI = new CRUD_Materiales_GUI(materialConstruccionDao.consultarTodos(), this);
                    // }catch(SQLException eReconsultandoMateriales){
                    //     JOptionPane.showMessageDialog(
                    //         crud_Materiales_GUI, 
                    //         "Error consultando todos los materiales!!", 
                    //         "Error BD", 
                    //         JOptionPane.ERROR_MESSAGE
                    //         );
                    // }
                    
                    //Versión 2 (Actualizando la tabla)

                    //Limpiar todos los materiales
                    while(crud_Materiales_GUI.getModeloTablaMateriales().getRowCount() > 0){
                        crud_Materiales_GUI.getModeloTablaMateriales().removeRow(0);
                    }                  

                    //Cargar los materiales de la base de datos (versión actualizada)
                    try{
                        for (MaterialConstruccion filaMaterial : materialConstruccionDao.consultarTodos()) {
                            crud_Materiales_GUI.getModeloTablaMateriales().addRow(
                                new Object[]{
                                    String.valueOf(filaMaterial.getIdMaterialConstruccion()),
                                    filaMaterial.getNombreMaterial(),
                                    filaMaterial.getImportado(),
                                    String.valueOf(filaMaterial.getPrecioUnidad())                                                                       
                                }
                            );                            
                        }
                    }catch(SQLException eReconsultandoMateriales){
                        JOptionPane.showMessageDialog(
                            crud_Materiales_GUI, 
                            "Error consultando todos los materiales para actualizar GUI!!", 
                            "Error BD", 
                            JOptionPane.ERROR_MESSAGE
                            );
                    }
                }//Cierre revisión de registro exitoso

            break;

            case "eliminarMaterial":
                
            break;

            case "actualizarMaterial":
                
            break;

        }

    }
    
}

