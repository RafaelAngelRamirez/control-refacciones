/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import modelo.InfoTabla.PaisIT;

/**
 *
 * @author Particular
 */
public class PaisVo extends VoGenerales{
    
    int id;
    String pais;

    public PaisVo() {
        PaisIT iT = new PaisIT();
        relacionCampo.put(iT.getID().getNombre(), ()->this.getId());
        relacionCampo.put(iT.getPAIS().getNombre(), ()->this.getPais());
    
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
