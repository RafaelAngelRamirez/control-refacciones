
package vista.UtilidadesIntefaz;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ExcepcionPersonalizada;

/**
 *
 * @author Particular
 */
public class ConfiguracionDePanel{
    
    private boolean modal;
    private boolean resizable;
    private String title;
    private Component locationRelativeTo;
    private int defaultCloseOperation;
    private Runnable operacionDeAcople;
    private Runnable operacionDesacople;

    public Runnable getOperacionDeAcople() {
        try {
            if (operacionDeAcople==null) {
                    throw new ExcepcionPersonalizada("No has definido la operación de acople de"
                            + "\n\t el panel '"+getTitle()+"'", this);
            }
            return operacionDeAcople;
        } catch (ExcepcionPersonalizada ex) {
            Logger.getLogger(ConfiguracionDePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setOperacionDeAcople(Runnable operacionDeAcople) {
        this.operacionDeAcople = operacionDeAcople;
    }
    
    public Runnable getOperacionDesacople() {
        try {
            if (operacionDesacople==null) {
                    throw new ExcepcionPersonalizada("No has definido la operación de desacople de"
                            + "\n\t el panel '"+getTitle()+"'", this);
            }
            return operacionDesacople;
        } catch (ExcepcionPersonalizada ex) {
            Logger.getLogger(ConfiguracionDePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setOperacionDesacople(Runnable operacionDesacople) {
        this.operacionDesacople = operacionDesacople;
    }

    public boolean isModal() {
        return modal;
    }

    public void setModal(boolean modal) {
        this.modal = modal;
    }

    public boolean isResizable() {
        return resizable;
    }

    public void setResizable(boolean resizable) {
        this.resizable = resizable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Component getLocationRelativeTo() {
        return locationRelativeTo;
    }

    public void setLocationRelativeTo(Component locationRelativeTo) {
        this.locationRelativeTo = locationRelativeTo;
    }

    public int getDefaultCloseOperation() {
        return defaultCloseOperation;
    }

    public void setDefaultCloseOperation(int defaultCloseOperation) {
        this.defaultCloseOperation = defaultCloseOperation;
    }
        
        
}

