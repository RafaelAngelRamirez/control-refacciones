/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JPanel;

/**
 * Esta clase ejecuta la precarga mostrando un panel que se le defina hasta que la
 * operación que se le pase como parametro termine. 
 * @author Particular
 */
public class HiloConPrecarga extends Thread{
    
    Runnable operacion;
    Precarga precarga;
    JPanel panel;
    int tiempo;

    /**
     * Define un nuevo hilo con precarga y panel no modal. Esta es la opción básica. 
     * @param operacion La operación que se quiere precargar. 
     * @param panel El panel que se mostrará durante la precarga. 
     */
    public HiloConPrecarga(Runnable operacion, JPanel panel) {
        this.panel = panel;
        this.operacion = operacion;
        
        this.precarga = new Precarga();
        precarga.setPanel(this.panel);
        precarga.mostrarPrecarga();
    }
    
    /**
     * Define un nuevo hilo con precarga.
     * @param operacion La operación que se quiere ejecutar con precarga. 
     * @param panel El panel que se mostrara durante la precarga. 
     * @param tiempo El tiempo que durara en empezar a cerrarse el panel despues
     * de que la operacion que se quiere ejecutar haya terminado. 
     * @param encima Si el panel será modal o no. Este puede traer algúnas complicaciones. 
     * Se discreto en su uso. 
     */
    public HiloConPrecarga(Runnable operacion, JPanel panel, int tiempo, boolean encima) {
        this.panel = panel;
        this.operacion = operacion;
        
        this.precarga = new Precarga();
        precarga.setEncima(encima);
        precarga.setPanel(this.panel);
        precarga.mostrarPrecarga(tiempo);
    }
    
    
    @Override
    public void run() {
        operacion.run();
        precarga.terminarPrecarga();
        
    }
    
    
    
   
    
    
}
