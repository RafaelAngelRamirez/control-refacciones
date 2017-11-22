/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import modelo.InfoTabla.ExistenciaRefaccionIT;

/**
 *
 * @author Particular
 */
public class ExistenciaRefaccionVO extends VoGenerales{
    
    private int idRefaccion;
    private float existencia;

    public ExistenciaRefaccionVO() {
        relacionCampo.put(ExistenciaRefaccionIT.getID_REFACCION().getNombre(), this::getIdRefaccion);
        relacionCampo.put(ExistenciaRefaccionIT.getEXISTENCIA().getNombre(), this::getExistencia);
    
    }

    public int getIdRefaccion() {
        return idRefaccion;
    }

    public void setIdRefaccion(int idRefaccion) {
        this.idRefaccion = idRefaccion;
    }

    public float getExistencia() {
        return existencia;
    }

    public void setExistencia(float existencia) {
        this.existencia = existencia;
    }

    @Override
    public String toString() {
        String a = "Clase: "+this.getClass().getSimpleName()+"\n";
        String b= "       | ";
        String c =  "\n                Id" +b+ idRefaccion+
                    "\n        Existencia" +b+ existencia;
        String d =  "----------------------";
        return a+d+c+d;    

    }
    
}
