/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.capturadeerrores;

import controlador.Coordinador;
import java.util.HashMap;
import javax.swing.JOptionPane;
import vista.UtilidadesIntefaz.JDialogBase;
import vista.UtilidadesIntefaz.JPanelBase;

/**
 *
 * @author Particular
 */
public class CoordinadorPaneles {
    
    Coordinador coordinador;
    
    /*------------------------------------------------------------
        NOMBRAMOS LOS PANELES Y DIALOGOS CON VARIABLES ESTATICAS
        PARA IDENTIFICARLOS Y LLAMARLOS POR FUERA. ESTE MISMO NOMBRE
        SE MUESTRA EN LOS MENUS.
    ------------------------------------------------------------*/
    /**
     * Nombre del panel principal donde se consultar las refacciones al 
     * iniciar el sistema.
     */
    public static String PANEL_REFACCIONES_CONSULTAR = "Consultar refacciones";
    /**
     * Nombre del panel registro de refacciones.
     */
    public static String PANEL_REGISTRAR_NUEVA_REFACCION = "Registrar nueva refacción";
    /**
     * Nombre del panel para modificar refacciones. 
     */
    public static String PANEL_MODIFICAR_REFACCION = "Modificar refacción";
    /**
     * Dialogo Imagen detalle.
     */
    public static String DIALOGO_IMAGEN_DETALLE = "Detalle de imagen";
    /**
     * Nombre del dialogo Maquina modelo agregar
     */
    public static String DIALOGO_MAQUINA_MODELO_AGREGAR = "Registrar maquina-modelo";
    /**
     * Nombre del dialogo Maquina modelo modificar
     */
    public static String DIALOGO_MAQUINA_MODELO_MODIFICAR = "Modificar maquina-modelo";
    /**
     * Nombre del dialogo proveedor registrar.
     */
    public static String DIALOGO_PROVEEDOR_REGISTRAR = "Registrar proveedor";
    /**
     * Nombre del dialogo proveedor modificar.
     */
    public static String DIALOGO_PROVEEDOR_MODIFICAR = "Modificar proveedor";
    /**
     * Nombre del dialogo refaccion detalle.
     */
    public static String DIALOGO_REFACCION_DETALLE = "Detalle refacción";
    /**
     * Nombre del dialogo entrada lote.
     */
    public static String DIALOGO_ENTRADA_LOTE = "Entrada lote";
    /**
     * Nombre del dialogo entrada lote.
     */
    public static String DIALOGO_SALIDA_LOTE = "Salida lote";
    /**
     * Nombre del dialogo agregar empleado.
     */
    public static String PANEL_EMPLEADO_AGREGAR = "Agregar empleado";
    
    /**
     * Nombre del dialogo modficar empleado.
     */
    public static String DIALOGO_EMPLEADO_MODIFICAR = "Modificar empleado";
    
    private HashMap<JPanelBase, JDialogBase> dialogosAbiertos = new HashMap<>();

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
      
    /**
     * Esta operación solo se utiliza desde la clase JDialogBase para controlad
     * los dialogos que se abren. 
     * @param dialogo
     */
    public void addDialogAbierto(JDialogBase dialogo){
        String elNombreDelPanel = dialogo.getPanel().getConfiguracionesDialogo().getTitle();
        coordinador.getMarcoParaVentanaPrincipal().remove(dialogo.getPanel());
        coordinador.getMarcoParaVentanaPrincipal().repaint();
        
        dialogosAbiertos.put(dialogo.getPanel(), dialogo);
    }
    
    /**
     * Esta función ayuda a sustituir el dispose de las ventanas. En caso 
     * de que no se a un dialogo regresa a la ventana principal. 
     * 
     * @param jpb
     */
    public boolean cerrarDialogoAbierto(JPanelBase jpb){
        //SI EXISTE EL DIALOGO EL MAPA ENTONCES LO CERRAMOS Y DEVOLVEMOS TRUE
        // PARA QUE LA OPERACIÓN DE DESACOPLE SE LLEVE A CABO. SI SE INVOCA
        // DESDE DENTRO DEL PANEL CUANDO HAY UN DIALOGO SOLO LO CIERRA. EN CASO
        // DE QUE SEA PANEL RETORNA A LA VENTANA PRICIPAL. 
        if (dialogosAbiertos.containsKey(jpb)) {
            JDialogBase dialogo = dialogosAbiertos.get(jpb);
            //OBTENEMOS LA ÚLTIMA POSICIÓN
            jpb.getConfiguracionesDialogo().setUltimaPosicionDeDialogo(dialogo.getLocationOnScreen());
            //CERRAMOS EL DIALOGO. NO CONFUNDIR CON EL DISPOSE DE JPANEL BASE
            // QUE DETONA ESTA FUNCIÓN PARA CERRAR EL DIALOGO DESDE DENTRO DL
            // PANEL. 
            dialogo.dispose();
            // QUITAMOS EL PANEL DE LA LISTA POR QUE YA NO LO TENEMOS ABIERTO.
            dialogosAbiertos.remove(jpb);
            //RETORNAMOS TRUE PARA QUE SI SE LLAMO ESTA FUNCIÓN DESDE LAS OPERACIONES
            // DE DESACOPLE Y ACOPLE SE EJECUTA LA FUNCIÓN CONTRARIA. (ACOPLAR Y 
            // DESACOPLAR).
            return true;
            
        }else{
            coordinador.getMarcoParaVentanaPrincipal().setJPanel(coordinador.getPanelRefaccionConsulta());
            coordinador.getPanelRefaccionConsulta().configurar();
            return false;
        }
    }
}
