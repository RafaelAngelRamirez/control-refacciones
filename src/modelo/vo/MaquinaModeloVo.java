/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import modelo.InfoTabla.MaquinaModeloIT;

/**
 *
 * @author Particular
 */
public class MaquinaModeloVo extends VoGenerales{
    
    int id;
    String modelo;
    int anio;
    Object idProveedor;

    public MaquinaModeloVo() {
        MaquinaModeloIT it = new MaquinaModeloIT();

        relacionCampo.put(it.getAnioPDC().getNombre(), ()->this.getAnio());
        relacionCampo.put(it.getID().getNombre(), ()->this.getId());
        relacionCampo.put(it.getMODELO().getNombre(), ()->this.getModelo());
        relacionCampo.put(it.getID_PROVEEDOR().getNombre(), ()->this.getIdProveedor());
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Object getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Object idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public String toString() {
        
        String f = "= ";
        String separador = "\n--------------------------";
        String titulo = separador +"\n"+this.getClass().getSimpleName();
        String a = "      |           id"+f+getId()+"\n"+
                   "      |       modelo"+f+getModelo()+"\n"+
                   "      |          año"+f+getAnio()+"\n"+
                   "      |  idProveedor"+f+getIdProveedor()+"\n";

        return titulo +"\n"+a +separador;
    }
    
}
