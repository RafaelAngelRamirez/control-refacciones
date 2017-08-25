/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import controlador.Coordinador;
import java.awt.event.KeyEvent;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.KeyStroke;

/**
 * Utilidades básicas para los botónes. La más destacable es setEnterYEspacio que 
 proporciona la capacidad al botón de ejecutar la acción predetermiana 
 con el boton de Enter o barra espaciadora.
 * 
 * @author Particular
 */
public class UtilidadesBotones_ {
    
    private JButton boton;
    private Coordinador coordinador;

    public UtilidadesBotones_(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    /**
     * Estable el boton que se utilizara.  
     * @param boton El botón para esta utilidad. 
     */
    public void setComponente(JButton boton){
        this.boton = boton;
    }
    
    /**
     * Da la propiedad de ejecutar la acción predeterminada del botón al presionar
     * enter. No confundir con la asinación de una acción.
     * @param boton Botón que se quiere asignar. 
     */
    public static void setEnterYEspacio(JButton boton){
        InputMap map = new InputMap();
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "pressed");
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), "released");
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), "pressed");
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true), "released");
        boton.setInputMap(0, map);
    
    }
    
    
    
}
