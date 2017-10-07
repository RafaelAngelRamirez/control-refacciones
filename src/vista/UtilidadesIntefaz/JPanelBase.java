/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.UtilidadesIntefaz;

import controlador.ActualizacionDeComponentesGráficos.OperacionesDeActualizacion;
import controlador.Coordinador;
import java.awt.Container;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import modelo.ExcepcionPersonalizada;

/**
 *
 * @author Particular
 */
public abstract class JPanelBase extends JPanel implements HierarchyListener{

    private static final long serialVersionUID = 1L;

    /**
     * Guarda las configuraciones del dialgo en caso de que este panel 
     * se llame desde un JDialogBase.
     */
    protected ConfiguracionDePanel configuracionesDialogo;
    
    /**
     * Almacena las operaciones de actualización. 
     */
    protected OperacionesDeActualizacion opAct;
        
    Coordinador coordinador;
    int arrastre = 0;
    

    public JPanelBase() {
        this.opAct = new OperacionesDeActualizacion(this);
    }
    
    //ESTA SECCIÓN PERMITE DETECTAR SI EL PANEL ES VISIBLE. 
    
       
    /**
     * Esta función detecta si este panel esta visible para el usuario. Si
     * hay un JDialog que sea modal y se habre sobre este detectara que no esta
     * visible para el usuario. Cuando el panel modal se cierra detectara que
     * este panel esta visible. 
     * @return True si esta visible.
     */
    public boolean soyVisible(){
        
        Container c = getParent();
        while(c != null){
            System.out.println("--------------------------------"+c.getClass().getName());
            if (!c.isVisible()) {
                return false;
            } else {
                c = c.getParent();
            }
        }
        return true;
    }
    
    //PARA HierarchyListener
    @Override
    public void addNotify(){
        super.addNotify();
        addHierarchyListener(this);
    }
    
    //PARA HierarchyListener
    @Override
    public void removeNotify(){
        removeHierarchyListener(this);
        super.removeNotify();
    }
    
    /**
     * Ejectua la operación que se le pase como parametro a actualizarPanel.
     * En general esta operación debe estar relacionada con {@see ControladorActualizacionGUI_BD}
     * @param e
     */
    @Override
    public void hierarchyChanged(HierarchyEvent e){
        if (soyVisible()) {
            this.opAct.actualizarPanel();
        }
    }  

    public OperacionesDeActualizacion getOpAct() {
        return opAct;
    }

    public void setOpAct(OperacionesDeActualizacion opAct) {
        this.opAct = opAct;
    }
    
    public final Coordinador getCoordinador() {
        return coordinador;
    }

    /**
     * El coordinador del sistema.
     * @param coordinador
     */
    public final void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
        this.coordinador.getControladorActualizacionGUI_BD().addPanel(this);
    }
    
    private boolean listenersEjecutados=false;

    /**
     * Si los listeners fueron ejecutados entonces devuelve true. Se utiliza
     * para definir si es necesario cargar de nueva cuenta los 
     * listeners que implementamos en los diversos componentes. 
     * @return
     */
    public boolean isListenersEjecutados() {
        return listenersEjecutados;
    }

    public void setListenersEjecutados(boolean listenersEjecutados) {
        this.listenersEjecutados = listenersEjecutados;
        
    }
    
    
    
    /**
     * La configuración del panel.
     */
    public abstract void configurar();
    
    /**
     * Configuracion de inicialización. Solo se ejecuta cuando el panel se 
     * muestra por primera vez. 
     */
    public abstract void initConfig();

    /**
     * Las configuracines para mostrar el dialogo. 
     * @return
     */
    public final ConfiguracionDePanel getConfiguracionesDialogo() {
        return configuracionesDialogo;
    }
    
    
    public final boolean dispose(){
        return this.getCoordinador().getCoordinadorPaneles().cerrarDialogoAbierto(this);
    }
    

    @Override
    public final void setVisible(boolean aFlag) {
        try {
            throw new ExcepcionPersonalizada(
                    "setVisible esta deshabilitado para JPanelBase:"
                            +this.getClass().getName(), "setVisible()");
        } catch (ExcepcionPersonalizada ex) {
            Logger.getLogger(JPanelBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    

        
}
