/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import modelo.InfoTabla.ImportanciaIT;

/**
 *
 * @author Particular
 */
public class ImportanciaVo extends VoGenerales{
    
    private int id;
    private String importancia;

    public ImportanciaVo() {
        ImportanciaIT i = new ImportanciaIT();
        relacionCampo.put(i.getIdPDC().getNombre(), this::getId);
        relacionCampo.put(i.getImportanciaPDC().getNombre(), this::getImportancia);
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImportancia() {
        return importancia;
    }

    public void setImportancia(String importancia) {
        this.importancia = importancia;
    }

    @Override
    public String toString() {
        
        String a = "Clase: "+this.getClass().getSimpleName()+"\n";
        String b= "       | ";
        String c =  "\n                Id" +b+ id+
                    "\n       Importancia" +b+ importancia;
        String d =  "----------------------";
        return a+d+c+d;
    }
    
    
}
