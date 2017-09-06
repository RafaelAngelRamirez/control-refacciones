
package vista.UtilidadesIntefaz;

import vista.UtilidadesIntefaz.JPanelBase;
import controlador.Coordinador;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.ExcepcionPersonalizada;

/**
 * Este dialogo es el que permite mostrar los paneles de manera flotante. 
 * @author Particular
 */
public class JDialogBase extends JDialog{
    
    Coordinador coordinador;
    private JPanelBase panelActual;

    public JDialogBase(Coordinador coordinador) {
        this.coordinador = coordinador;
        
    }
    
    public void addPanel(JPanelBase panel){
        this.panelActual = panel;
        this.setContentPane(panelActual);
        this.panelActual.configurar();
        
    }
    
    public JPanelBase getPanel(){
        return this.panelActual;
    }
    
    @Override
    public void setVisible(boolean b){
        if (b) {
            //SOLO SE MARCA EL SET VISIBLE AQUI
            //POR QUE CERRAMOS DESDE EL CORRDINADOR LA VENTANA. 
            this.coordinador.addDialogAbierto(this);
            super.setVisible(b);
        }else{
            this.coordinador.cerrarDialogoAbierto(panelActual);
        }
    }
    
    
    public void configurarPanel(){
        ConfiguracionDePanel c = this.panelActual.getConfiguracionesDialogo();
//        this.panelActual.configurar();
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
            Logger.getLogger(JDialogBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removePanel(){
        this.remove(this.panelActual);
    }
    
    

    

}
