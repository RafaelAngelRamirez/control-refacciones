/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import modelo.InfoTabla.MaquinaIT;

/**
 *
 * @author Particular
 */
public class MaquinaVo extends VoGenerales{
    
    private int id;
    private Object idMaquinaModelo;
    private String numeroDeMáquina;
    private String matricula;

    public MaquinaVo() {
        MaquinaIT it = new MaquinaIT();
        relacionCampo.put(it.getIdPDC().getNombre(), ()->this.getId());
        relacionCampo.put(it.getIdMaquinaModeloPDC().getNombre(), ()->this.getIdMaquinaModelo());
        relacionCampo.put(it.getNumeroDeMaquinaPDC().getNombre(), ()->this.getNumeroDeMáquina());
        relacionCampo.put(it.getMatriculaPDC().getNombre(), ()->this.getMatricula());
        
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getIdMaquinaModelo() {
        return idMaquinaModelo;
    }

    public void setIdMaquinaModelo(Object idMaquinaModelo) {
        this.idMaquinaModelo = idMaquinaModelo;
    }
    public String getNumeroDeMáquina() {
        return numeroDeMáquina;
    }

    public void setNumeroDeMáquina(String numeroDeMáquina) {
        this.numeroDeMáquina = numeroDeMáquina;
    }

    @Override
    public String toString() {
        String a = "Clase: "+this.getClass().getSimpleName()+"\n";
        String b= "       | ";
        
        String c =  "\n             Id" +b+ id+
                    "\n    idRefaccion" +b+ idMaquinaModelo+
                    "\n     idMaterial" +b+ numeroDeMáquina;

        String d =  "----------------------"; 
        
        return a+d+c+d;
    }
    
}
