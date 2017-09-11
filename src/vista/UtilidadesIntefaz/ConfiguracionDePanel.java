
package vista.UtilidadesIntefaz;

import java.awt.Component;
import java.awt.Point;
import java.util.concurrent.Callable;
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
    private Callable<JDialogBase> operacionDesacople;
    private Point ultimaPosicionDeDialogo;
    private JDialogBase dialogoTemporal;

    public JDialogBase getDialogoTemporal() {
        return dialogoTemporal;
    }

    public void setDialogoTemporal(JDialogBase dialogoTemporal) {
        this.dialogoTemporal = dialogoTemporal;
    }
    
    

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

    public void setOperacionDeAcople_Panel(Runnable operacionDeAcople) {
        this.operacionDeAcople = operacionDeAcople;
    }
    
    
    
    
    
    
    
    
    public Callable<JDialogBase> getOperacionDesacople() {
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

    
    
    
    
    
    public void setOperacionDesacople_Dialogo(Callable<JDialogBase> operacionDesacople) {
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

    public Point getUltimaPosicionDeDialogo() {
        return ultimaPosicionDeDialogo;
    }

    public void setUltimaPosicionDeDialogo(Point ultimaPosicionDeDialogo) {
        this.ultimaPosicionDeDialogo = ultimaPosicionDeDialogo;
    }
    
    
    
    public String toString(){
        
        String m = 
                "|\tCONFIGURACIONES DE PANEL: " + title+"\t\n";
        String n = "\n";
        m+=
        "   locationRelativeTo->"+locationRelativeTo+n+
        "                modal->"+modal+n+
        "    operacionDeAcople->"+operacionDeAcople+n+
        "   operacionDesacople->"+operacionDesacople+n+
        "            resizable->"+resizable+n+
        "ultimaPosicionDelDialogo->"+ultimaPosicionDeDialogo+n+
        "                title->"+title+n;
        return m;

    }
        
        
}

