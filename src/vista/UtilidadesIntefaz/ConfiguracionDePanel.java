
package vista.UtilidadesIntefaz;

import java.awt.Component;
import java.awt.Point;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import controlador.capturadeerrores.ExcepcionPersonalizada;

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
    private Point ultimaPosicionDeDialogo;
    private JDialogBase dialogoTemporal;

    public JDialogBase getDialogoTemporal() {
        return dialogoTemporal;
    }

    public void setDialogoTemporal(JDialogBase dialogoTemporal) {
        this.dialogoTemporal = dialogoTemporal;
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
        "            resizable->"+resizable+n+
        "ultimaPosicionDelDialogo->"+ultimaPosicionDeDialogo+n+
        "                title->"+title+n;
        return m;

    }
        
        
}

