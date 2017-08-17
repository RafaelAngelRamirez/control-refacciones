/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import modelo.InfoTabla.EntradaLoteIT;

/**
 *
 * @author Particular
 */
public class EntradaLoteVo extends VoGenerales{

        
    private int id;
    private String fechaRecepcionLote;
    private float cantidad;
    private int idRefaccion;
    private int idEmpleado;
    private String observaciones;

    public EntradaLoteVo() {
        EntradaLoteIT i = new EntradaLoteIT();
        relacionCampo.put(i.getIdPDC().getNombre(), ()->this.getId());
        relacionCampo.put(i.getFechaRecepcionLotePDC().getNombre(), ()->this.getFechaRecepcionLote());
        relacionCampo.put(i.getCantidadPDC().getNombre(), ()->this.getCantidad());
        relacionCampo.put(i.getIdRefaccionPDC().getNombre(), ()->this.getIdRefaccion());
        relacionCampo.put(i.getIdEmpleadoPDC().getNombre(), ()->this.getIdEmpleado());
        relacionCampo.put(i.getObservacionesPDC().getNombre(), ()->this.getObservaciones());
        
    
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaRecepcionLote() {
        return fechaRecepcionLote;
    }

    public void setFechaRecepcionLote(String fechaRecepcionLote) {
        this.fechaRecepcionLote = fechaRecepcionLote;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdRefaccion() {
        return idRefaccion;
    }

    public void setIdRefaccion(int idRefaccion) {
        this.idRefaccion = idRefaccion;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    

    @Override
    public String toString() {
        
        String a = "Clase: "+this.getClass().getSimpleName()+"\n";
        String b= "       | ";
        String c =  "\n                Id" +b+ id+
                    "\nfechaRecepcionLote" +b+ fechaRecepcionLote+
                    "\n          cantidad" +b+ cantidad+
                    "\n       idRefaccion" +b+ idRefaccion+
                    "\n        idEmpleado" +b+ idEmpleado;
        String d =  "----------------------";
        return a+d+c+d;
        
    }
    
}
