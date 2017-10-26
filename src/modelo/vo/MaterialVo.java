/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import modelo.InfoTabla.MaterialIT;

/**
 *
 * @author Particular
 */
public class MaterialVo extends VoGenerales{
    
    private int id;
    private String material;

    public MaterialVo() {
        MaterialIT i = new MaterialIT();
        relacionCampo.put(i.getID().getNombre(), this::getId);
        relacionCampo.put(i.getMATERIAL().getNombre(), this::getMaterial);
    
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        String a = "Clase: "+this.getClass().getSimpleName()+"\n";
        String b= "       | ";
        String c =  "\n                Id" +b+ id+
                    "\n          Material" +b+ material;
        String d =  "----------------------";
        return a+d+c+d;
    }
    
    
            
    
    
}
