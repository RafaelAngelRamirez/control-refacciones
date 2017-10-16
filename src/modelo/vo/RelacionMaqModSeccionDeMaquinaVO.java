/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import modelo.InfoTabla.RelacionMaqModSeccionDeMaquinaIT;

/**
 *
 * @author Particular
 */
public class RelacionMaqModSeccionDeMaquinaVO extends VoGenerales{
    
    private int idSeccionMaq;
    private int idMaquinaModelo;

    public RelacionMaqModSeccionDeMaquinaVO() {
        RelacionMaqModSeccionDeMaquinaIT i = new RelacionMaqModSeccionDeMaquinaIT();
        relacionCampo.put(i.getIdSeccionMaq().getNombreParaMostrar(), this::getIdSeccionMaq);
        relacionCampo.put(i.getIdMaquinaModelo().getNombre(), this::getIdMaquinaModelo);
    }

    public int getIdSeccionMaq() {
        return idSeccionMaq;
    }

    public void setIdSeccionMaq(int idSeccionMaq) {
        this.idSeccionMaq = idSeccionMaq;
    }

    public int getIdMaquinaModelo() {
        return idMaquinaModelo;
    }

    public void setIdMaquinaModelo(int idMaquinaModelo) {
        this.idMaquinaModelo = idMaquinaModelo;
    }
    
    @Override
    public String toString() {
         String a = "Clase: "+this.getClass().getSimpleName()+"\n";
        String b= "       | ";
        String c =  "\n      idSeccionMaq" +b+ idSeccionMaq+
                    "\n   idMaquinaModelo" +b+ idMaquinaModelo;
        String d =  "----------------------";
        return a+d+c+d;
    }
    
}
