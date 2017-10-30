/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JPanel;
import vista.UtilidadesIntefaz.VentanaPrincipal.MarcoParaVentanaPrincipal;

/**
 *
 * @author Particular
 */
public class HiloConPrecarga extends Thread{
    
    Runnable operacion;
    Precarga precarga;
    JPanel panel;
    int tiempo;
    MarcoParaVentanaPrincipal principal;
    

    public MarcoParaVentanaPrincipal getPrincipal() {
        return principal;
    }

    public void setPrincipal(MarcoParaVentanaPrincipal principal) {
        this.principal = principal;
    }
    
    

    public HiloConPrecarga(Runnable operacion, JPanel panel) {
        this.panel = panel;
        this.operacion = operacion;
        
        this.precarga = new Precarga();
        precarga.setPanel(this.panel);
        precarga.mostrarPrecarga();
    }
    
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
