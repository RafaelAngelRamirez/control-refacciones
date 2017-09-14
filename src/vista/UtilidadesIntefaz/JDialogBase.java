
package vista.UtilidadesIntefaz;

import controlador.Coordinador;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import modelo.ExcepcionPersonalizada;

/**
 * Este dialogo es el que permite mostrar los paneles de manera flotante. 
 * @author Particular
 */
public class JDialogBase extends JDialog{
    
    Coordinador coordinador;
    private JPanelBase panelActual;
    
    protected Point ubicacionEnPantalla;
    protected Dimension tamanoDeDialogo;

    public JDialogBase(Coordinador coordinador) {
        this.coordinador = coordinador;
        
        this.addComponentListener(new ComponentAdapter() {
            JDialogBase dialogo;
            public ComponentAdapter parametros(JDialogBase dialogo){
                this.dialogo = dialogo;
                return this;
            }
            @Override
            public void componentResized(ComponentEvent e) {
                System.out.println("aquiii");
                dialogo.tamanoDeDialogo = dialogo.getSize();
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                if (dialogo.isVisible()) {
                    dialogo.ubicacionEnPantalla = dialogo.getLocationOnScreen();
                }
            }

         
        }.parametros(this));
        
        ActionListener escapeAction = new ActionListener() {
            JDialogBase d;
            ActionListener parametros(JDialogBase d){
                this.d=d;
                return this;
            }
            @Override
            public void actionPerformed(ActionEvent e) {
               this.d.dispose();
            }
        }.parametros(this);
        
        this.getRootPane().registerKeyboardAction(escapeAction,
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
    }
    
    public void retormarFormaYPosicion(){
        this.setSize(tamanoDeDialogo);
        this.setLocation(ubicacionEnPantalla);
    }
    
    public void add(JPanelBase panel){
        this.panelActual = panel;
        this.setContentPane(panelActual);
    }
    
    public JPanelBase getPanel(){
        return this.panelActual;
    }
    
    @Override
    public void setVisible(boolean b){
        ConfiguracionDePanel  config = 
                this.panelActual.getConfiguracionesDialogo();
        if (config==null) {
            try {
                throw new ExcepcionPersonalizada(
                        "No definiste la configuracion "
                                + "del panel: "+this.panelActual.getClass().getName()
                        , this, "setVisible()");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(JDialogBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (b) {
            //SOLO SE MARCA EL SET VISIBLE AQUI
            //POR QUE CERRAMOS DESDE EL CORRDINADOR LA VENTANA. 
            this.coordinador.getCoordinadorPaneles().addDialogAbierto(this);
            if (config.getUltimaPosicionDeDialogo() == null) {
                this.setLocationRelativeTo(config.getLocationRelativeTo());
            }else{
                this.setLocation(config.getUltimaPosicionDeDialogo());
            }
            super.setVisible(b);
            configurarPanel();
        }else{
            this.coordinador.getCoordinadorPaneles().cerrarDialogoAbierto(panelActual);
        }
    }
    
    
    public void configurarPanel(){
//        this.panelActual.configurar();
        ConfiguracionDePanel c = this.panelActual.getConfiguracionesDialogo();
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
