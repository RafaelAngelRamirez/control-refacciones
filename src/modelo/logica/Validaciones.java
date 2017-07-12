/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ExcepcionPersonalizada;
import modelo.dao.ParametrosDeCampo;

/**
 * Alamace los campos que se validan en la clase de lógica para 
 * transportalos a la GUI y mostrar el error o permitir que siga el programa. 
 *
 * @author Particular
 */
public class Validaciones {
    
    private String nombreDeCampo;
    private String mensajeDeError;
    private boolean valido;
    private boolean setValidado;
    private String nombreDeCampoParaMostrar;

    
    /**
     * Depues de la validación guarda si esta fue válida o no.  
     * @return 
     */
    public boolean isValido() {
        if (!setValidado) {
            try {
                throw new ExcepcionPersonalizada(
                        "No definiste si el campo "+this.getNombreDeCampo() +" es valido.", this, "isValido");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(Validaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valido;
    }
    
    /**
     * Guarda el resultado de la valiación. 
     * @param valido
     */
    public void setValido(boolean valido) {
        this.valido = valido;
        this.setValidado = true;
    }
    
    /**
     * El nombre del campo según la base de datos. 
     * @return 
     */
    public String getNombreDeCampo() {
        if (nombreDeCampo.isEmpty()) {
            try {
                throw new ExcepcionPersonalizada(
                        "No definiste el nombre de campo.", this, "getNombreDeCampo");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(Validaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return nombreDeCampo;
    }
    
    /**
     * El nombre del campo según la base de datos. Utiliar el InfoTable para
     * definirlo. 
     * @param campoPDC
     */
    public void setNombreDeCampo(ParametrosDeCampo campoPDC) {
        this.nombreDeCampo = campoPDC.getNombre();
        this.nombreDeCampoParaMostrar = campoPDC.getNombreParaMostrar();
    }

    /**
     * El mensaje de error a mostrar en la validación. 
     * @return 
     */
    public String getMensajeDeError() {
        if (mensajeDeError.isEmpty()) {
            try {
                throw new ExcepcionPersonalizada(
                        "No definiste el mensaje de error.", this, "getMensajeDeError");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(Validaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        mensajeDeError = nombreDeCampoParaMostrar + ": " + mensajeDeError;
        return mensajeDeError;
    }

    /**
     * Define el mensaje de error que se quiera mostrar en la interaz. 
     * 
     * No es necesario definir el nombre del campo puesto que se toma de 
     * setNombreDeCampo y se muestra de la siguiente manera:
     * 
     * <p style="color:rgb(255,255,0);">
     * "CAMPO:  no puede estar tal cosa.
     * </p>
     * 
     */
    public void setMensajeDeError(String mensajeDeError) {
        this.mensajeDeError = mensajeDeError;
    }
}
