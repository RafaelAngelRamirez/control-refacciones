/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import modelo.InfoTabla.RelacionSeccionMaqRefaccionIT;

/**
 *
 * @author Particular
 */
public class RelacionSeccionMaqRefaccionVO extends VoGenerales{
    
    private Object idRefaccion;
    private Object idSeccionMaquina;

    public RelacionSeccionMaqRefaccionVO() {
        RelacionSeccionMaqRefaccionIT i = new RelacionSeccionMaqRefaccionIT();
        
        relacionCampo.put(i.getIdRefaccionPDC().getNombre(), this::getIdRefaccion);
        relacionCampo.put(i.getIdSeccionMaquinaPDC().getNombre(), this::getIdSeccionMaquina);
    
    }

    public Object getIdRefaccion() {
        return idRefaccion;
    }

    public void setIdRefaccion(Object idRefaccion) {
        this.idRefaccion = idRefaccion;
    }

    public Object getIdSeccionMaquina() {
        return idSeccionMaquina;
    }

    public void setIdSeccionMaquina(Object idSeccionMaquina) {
        this.idSeccionMaquina = idSeccionMaquina;
    }

    @Override
    public String toString() {
           String a = "Clase: "+this.getClass().getSimpleName()+"\n";
        String b= "       | ";
        String c =  "\n      idRefaccion" +b+ idRefaccion.toString()+
                    "\n idSeccionMaquina" +b+ idSeccionMaquina.toString();
        String d =  "----------------------";
        return a+d+c+d;
    }
    
}
