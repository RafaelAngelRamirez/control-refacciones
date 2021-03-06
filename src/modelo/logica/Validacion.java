/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import java.util.logging.Level;
import java.util.logging.Logger;
import controlador.capturadeerrores.ExcepcionPersonalizada;
import modelo.ParametrosDeCampo;

/**
 * Alamace los campos que se validan en la clase de lógica para 
 * transportalos a la GUI y mostrar el error o permitir que siga el programa. 
 *
 * @author Particular
 */
public class Validacion {
    
    private String nombreDeCampo;
    private String mensajeDeError;
    private boolean valido;
    //ESTE ES PARA COMPROBAR SI SE SETEO isValido. 
    private boolean setValidado;
    private String nombreDeCampoParaMostrar;
    
    private Object ObjetoEspecialDeTraslado;

    
    /**
     * Depues de la validación guarda si esta fue válida o no.  
     * @return  True si es valido. 
     */
    public boolean isValido() {
        if (!setValidado) {
            try {
                throw new ExcepcionPersonalizada(
                        "No definiste si el campo "+this.getNombreDeCampo() +" es valido.", this, "isValido");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(Validacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valido;
    }
    
    /**
     * Guarda el resultado de la valiación. 
     * @param valido True si es valido. 
     */
    public void setValido(boolean valido) {
        this.valido = valido;
        this.setValidado = true;
    }
    
    /**
     * El nombre del campo según la base de datos. 
     * @return Cadena de texto con el nombre según la BD.
     */
    public String getNombreDeCampo() {
        if (nombreDeCampo == null) {
            try {
                throw new ExcepcionPersonalizada(
                        "No definiste el nombre de campo.", this, "getNombreDeCampo");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(Validacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        return nombreDeCampo;
    }
    
    /**
     * El nombre del campo según la base de datos. Utilizar el InfoTable para
     * definirlo. 
     * @param campoPDC Extraido desde camposPDC de la clase. 
     * @see ParametrosDeCampo
     */
    public void setNombreDeCampo(ParametrosDeCampo campoPDC) {
        this.nombreDeCampo = campoPDC.getNombre();
        this.nombreDeCampoParaMostrar = campoPDC.getNombreParaMostrar();
    }
    
    /**
     * El nombre del campo que se utilizara para obtener el resultado de la validación
     * y que se mostrara en el mensaje de error. 
     * @param nombreParaMostrar El nombre que se mostrara en el mensaje. 
     */
    public void setNombreDeCampo( String nombreParaMostrar) {
        this.nombreDeCampo = nombreParaMostrar;
        this.nombreDeCampoParaMostrar = nombreParaMostrar;
    }
    /**
     * El mensaje de error a mostrar en la validación. 
     * @return Cadena de texto que almacena el mensaje de error de la validación.
     */
    public String getMensajeDeError() {
        if (mensajeDeError==null) {
            try {
                throw new ExcepcionPersonalizada(
                        "No definiste el mensaje de error." + nombreDeCampo, this, "getMensajeDeError");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(Validacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (nombreDeCampoParaMostrar==null ) {
            return mensajeDeError;
        }
        return nombreDeCampoParaMostrar + ": " + mensajeDeError;
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
     * @param mensajeDeError Cadena de texto . 
     */
    public void setMensajeDeError(String mensajeDeError) {
        this.mensajeDeError = mensajeDeError;
    }
    
    @Override
    /**
     *Retorna los datos de validación del componente. 
     */
    public String toString(){
        String me;
        if (mensajeDeError!=null) {
            me = getMensajeDeError();
        }else{
            me = "**NO DEFINIDO**";
        }
  
        
      String a = ""
                + "========================================================"
                + "\nValidando campo: '" + getNombreDeCampo()+"'"
                + "\nNombre para mostrar: '" + getNombreDeCampo()+"'"
                + "\nMensaje de error -> " + me
                + "\n¿Paso la validacion? ->" + isValido()
              + "\n\n\n";
      return a;
    }
}
