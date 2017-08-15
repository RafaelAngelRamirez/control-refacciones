/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ExcepcionPersonalizada;

/**
 *
 * @author Particular
 */
public abstract class VoGenerales {
    
    protected HashMap<String, Callable> relacionCampo = new HashMap<>();
    
    /**
     * Retorna un mapa que relaciona el campo vo con su contenido para que las 
     * validaciones se puedan hacer con respecto al getCampo y su nomobre definido
     * dentro de TI.
     * @return El mapa que contiene las llamadas a los campos get.
     */
    public HashMap<String, Callable> getRelacionCampo() {
        if (relacionCampo.isEmpty()) {
            try {
                throw new ExcepcionPersonalizada("No has definido la relación entre campos y sus nombres.",
                        this, "getRelacionCampo");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(VoGenerales.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return relacionCampo;
    }
    
    @Override
    public abstract String toString();
    
}
