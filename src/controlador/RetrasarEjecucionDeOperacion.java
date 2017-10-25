/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import vista.UtilidadesIntefaz.JPanelBase;

/**
 * Esta clase permite un retraso de de la ejecución de la operación de manera
 * que no se sature el programa. Es necesario definir el tiempo de espera en
 * milisegundos y la operación que se quiere ejecutar.
 * 
 * Si se define un JPanelBase entonces la operación solo se ejecutara si el 
 * panel esta visible de otra manera no lo hara. 
 * 
 * @author Particular
 */
public class RetrasarEjecucionDeOperacion {
        
    Runnable operacion;
    boolean repetir = false;
    Hilo esteHilo;
    int tiempoDeRetraso;
    boolean ejecutado;
    
    JPanelBase panel;

    public RetrasarEjecucionDeOperacion(JPanelBase panel) {
        this.ejecutado = false;
        this.tiempoDeRetraso = -1;
        this.esteHilo = new Hilo();
        this.panel = panel;
    }
    public RetrasarEjecucionDeOperacion() {
        this.ejecutado = false;
        this.tiempoDeRetraso = -1;
    }

    /**
     * El tiempo que se definio para retrasar la operación.
     * @return
     */
    public int getTiempoDeRetraso() {
        return tiempoDeRetraso;
    }

    /**
     * Define el tiempo en milisegundos del retraso que se quiere
     * definir. Si no se define por defecto es de 100 milisegundos.
     * Se recomienda mantener el tiempo por defecto ya que valores más elevados
     * pueden causar problemas en la ejecución de la operación.
     * @param tiempoDeRetraso
     */
    public void setTiempoDeRetraso(int tiempoDeRetraso) {
        this.tiempoDeRetraso = tiempoDeRetraso;
    }

    /**
     * Retorna la operación que se quiere temporizar. 
     * @return
     */
    public Runnable getOperacion() {
        return operacion;
    }

    /**
     * La operación cuya ejecución se quiere retrasar. 
     * @param operacion
     */
    public void setOperacion(Runnable operacion) {
        esteHilo = new Hilo();
        this.operacion = operacion;
    }
    
    /**
     * Esta operación ejecuta la definida en {@see: setOperacion(Runnable operacion)}
     * con el tiempo de retraso definido o 100 milisegundos por defecto si no se
     * definio. 
     */
    public void ejecutar(){
        repetir = true;
        if (!ejecutado) {
            esteHilo.start();
            ejecutado = true;
        }else{
            if (!esteHilo.isAlive()) {
                esteHilo = new Hilo();
                ejecutado = false;
                ejecutar();
            }
        }
    }

    private class Hilo extends Thread{
        
        @Override
        public void run() {
            while (repetir) {                    
                try {
                    repetir = false;
                    if (tiempoDeRetraso==-1) {
                        tiempoDeRetraso=100;
                    }
                    esteHilo.sleep(tiempoDeRetraso);
                } catch (InterruptedException ex) {
                    Logger.getLogger(RetrasarEjecucionDeOperacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (panel!=null) {
                if (panel.soyVisible()) {
                    operacion.run();
                }
            }else{
                operacion.run();
            }
        }
    }
}
