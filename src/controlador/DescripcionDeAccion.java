/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Particular
 */
public class DescripcionDeAccion {
    
    private String nombreDeLaAccion;
    private String descripción;
    private String id;
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreDeLaAccion() {
        return nombreDeLaAccion;
    }

    public void setNombreDeLaAccion(String nombreDeLaAccion) {
        this.nombreDeLaAccion = nombreDeLaAccion;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }
    
}
