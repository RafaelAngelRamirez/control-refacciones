/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JPanel;

/**
 *
 * @author Particular
 */
public class HiloConPrecarga extends Thread{
    
    Runnable operacion;
    Precarga precarga;
    JPanel panel;

    public HiloConPrecarga(Runnable operacion, JPanel panel) {
        this.panel = panel;
        this.operacion = operacion;
        
        this.precarga = new Precarga();
        precarga.setPanel(this.panel);
        precarga.mostrarPrecarga();
    }
    
    
    @Override
    public void run() {
        operacion.run();
        precarga.terminarPrecarga();
        
    }
    
    
    
   
    
    
}
