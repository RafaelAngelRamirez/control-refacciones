/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.UtilidadesIntefaz;

import controlador.Coordinador;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import modelo.ExcepcionPersonalizada;

/**
 *
 * @author Particular
 */
public abstract class JPanelBase extends JPanel{
    
    protected ConfiguracionDePanel configuracionesDialogo;
    
    Coordinador coordinador;
    int arrastre = 0;

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    private boolean listenersEjecutados=false;

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

    public ConfiguracionDePanel getConfiguracionesDialogo() {
        return configuracionesDialogo;
    }
    
    
    public boolean dispose(){
        return this.getCoordinador().getCoordinadorPaneles().cerrarDialogoAbierto(this);
    }
    

    @Override
    public void setVisible(boolean aFlag) {
        try {
            throw new ExcepcionPersonalizada(
                    "setVisible esta deshabilitado para JPanelBase:"
                            +this.getClass().getName(), "setVisible()");
        } catch (ExcepcionPersonalizada ex) {
            Logger.getLogger(JPanelBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        
}
