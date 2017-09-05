/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JPanel;

/**
 *
 * @author Particular
 */
public abstract class JPanelBase extends JPanel{
    
    protected DialogoBase.Config configuracionesDialogo;
    
    /**
     * La configuración inicial del panel.
     */
    public abstract void configurar();

    public DialogoBase.Config getConfiguracionesDialogo() {
        return configuracionesDialogo;
    }

        
}
