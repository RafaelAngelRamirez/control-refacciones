
package vista.UtilidadesIntefaz;

import vista.UtilidadesIntefaz.JPanelBase;
import controlador.Coordinador;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import modelo.ExcepcionPersonalizada;

/**
 * Este dialogo es el que permite mostrar los paneles de manera flotante. 
 * @author Particular
 */
public class DialogoBase extends JDialog{
    
    Coordinador coordinador;
    private JPanelBase panelActual;
    

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    public void addPanel(JPanelBase panel){
        this.panelActual = panel;
        this.add(panelActual);
       
    }
    
    public void configurarPanel(){
        Config c = this.panelActual.getConfiguracionesDialogo();
        
        try {
            if (c==null) {
                    throw new ExcepcionPersonalizada("No has definido la configuración del panel", this, "configurarPanel()");
            }
            
            this.setModal(c.isModal());
            this.setResizable(c.isResizable());
            this.setTitle(c.getTitle());
            this.setLocationRelativeTo(c.getLocationRelativeTo());
            this.setDefaultCloseOperation(c.getDefaultCloseOperation());
            
        } catch (ExcepcionPersonalizada ex) {
            Logger.getLogger(DialogoBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removePanel(){
        this.remove(this.panelActual);
    }

    public class Config{
    
        private boolean modal;
        private boolean resizable;
        private String title;
        private Component locationRelativeTo;
        private int defaultCloseOperation;
                       
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


}
