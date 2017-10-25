/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import modelo.InfoTabla.SeccionDeMaquinaIT;

/**
 *
 * @author Particular
 */
public class SeccionDeMaquinaVO extends VoGenerales{
    
    private int id;
    private String nombreSeccion;

    public SeccionDeMaquinaVO() {
        SeccionDeMaquinaIT i = new SeccionDeMaquinaIT();
        relacionCampo.put(i.getID().getNombre(), this::getId);
        relacionCampo.put(i.getNOMBRE_SECCION().getNombre(), this::getNombreSeccion);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreSeccion() {
        return nombreSeccion;
    }

    public void setNombreSeccion(String nombreSeccion) {
        this.nombreSeccion = nombreSeccion;
    }
    
    
    @Override
    public String toString() {
 String a = "Clase: "+this.getClass().getSimpleName()+"\n";
        String b= "       | ";
        String c =  "\n                Id" +b+ id+
                    "\n  nomnombreSeccion" +b+ nombreSeccion;
        String d =  "----------------------";
        return a+d+c+d;
    }
    
}
