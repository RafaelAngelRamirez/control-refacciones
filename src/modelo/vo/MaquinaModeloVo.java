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
        relacionCampo.put(it.getIdPDC().getNombre(), ()->this.getId());
        relacionCampo.put(it.getModeloPDC().getNombre(), ()->this.getModelo());
        relacionCampo.put(it.getIdProoveedorPDC().getNombre(), ()->this.getIdProveedor());
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
    
}
