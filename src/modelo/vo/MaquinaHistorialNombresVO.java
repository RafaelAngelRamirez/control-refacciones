/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import modelo.InfoTabla.MaquinaHistorialNombresIT;

/**
 *
 * @author Particular
 */
public class MaquinaHistorialNombresVO extends VoGenerales{

    
    private int idMaquina;
    private String nombreAnterior;

    public MaquinaHistorialNombresVO() {
        MaquinaHistorialNombresIT it= new MaquinaHistorialNombresIT();
        relacionCampo.put(it.getIdMaquina().getNombre(), this::getIdMaquina);
        relacionCampo.put(it.getNombreAnterior().getNombre(), this::getNombreAnterior);

    }

    public int getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getNombreAnterior() {
        return nombreAnterior;
    }

    public void setNombreAnterior(String nombreAnterior) {
        this.nombreAnterior = nombreAnterior;
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
