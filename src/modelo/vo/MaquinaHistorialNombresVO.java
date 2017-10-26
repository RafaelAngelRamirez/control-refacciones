/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import java.sql.Date;
import modelo.InfoTabla.MaquinaHistorialNombresIT;

/**
 *
 * @author Particular
 */
public class MaquinaHistorialNombresVO extends VoGenerales{

    
    private int idMaquina;
    private String nombreAnterior;
    private java.sql.Date fechaDeCambio;

    public MaquinaHistorialNombresVO() {
        MaquinaHistorialNombresIT it= new MaquinaHistorialNombresIT();
        relacionCampo.put(it.getID_MAQUINA().getNombre(), this::getIdMaquina);
        relacionCampo.put(it.getNOMBRE_ANTERIOR().getNombre(), this::getNombreAnterior);
        relacionCampo.put(it.getFECHA_DE_CAMBIO().getNombre(), this::getFechaDeCambio);

    }

    public Date getFechaDeCambio() {
        return fechaDeCambio;
    }

    public void setFechaDeCambio(Date fechaDeCambio) {
        this.fechaDeCambio = fechaDeCambio;
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
        
        String a = "Clase: "+this.getClass().getSimpleName()+"\n";
        String b= "       | ";
        String c =  "\n      idMaquina" +b+ idMaquina+
                    "\n nombreAnterior" +b+ nombreAnterior+
                    "\n  fechaDeCambio" +b+ fechaDeCambio;
        String d =  "----------------------"; 
        
        return a+d+c+d;
        
    }
    
}
