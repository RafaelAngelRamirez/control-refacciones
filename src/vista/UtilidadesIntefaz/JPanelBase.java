/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.UtilidadesIntefaz;

import controlador.Coordinador;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Particular
 */
public abstract class JPanelBase extends JPanel{
    
    protected ConfiguracionDePanel configuracionesDialogo;
    
    Coordinador coordinador;

    public JPanelBase() {
        
        this.addMouseListener(new MouseAdapter() {
            JPanelBase panel;
            public MouseAdapter parametros (JPanelBase panel){
                this.panel = panel;
                return this;
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount()==3) {
                    JOptionPane.showMessageDialog(null, "acoplar!!!!");
                    //SI DEVUELVE TRUE QUIERE DECIR QUE EL PANEL ESTABA MONTADO
                    //SOBRE UN DIALOGO. 
                    if (panel.dispose()) {
                    JOptionPane.showMessageDialog(null, "PENDIENTE ACOPLADA!!!!");
                        
                    }
                    
                }
                
            }
          
        }.parametros(this));
    }

     
    
    
    
    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    
    /**
     * La configuración inicial del panel.
     */
    public abstract void configurar();

    public ConfiguracionDePanel getConfiguracionesDialogo() {
        return configuracionesDialogo;
    }
    
    
    public boolean dispose(){
        return this.getCoordinador().cerrarDialogoAbierto(this);
    }
    

        
}
