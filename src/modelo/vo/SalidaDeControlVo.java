/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import modelo.InfoTabla.SalidaDeControlIT;

/**
 *
 * @author Particular
 */
public class SalidaDeControlVo extends VoGenerales{

    
    private int id;
    private Object idRefaccion;
    private Object idMaquinaEnLaQueSeUsara;
    private Object idEmpleado;
    private Timestamp fechaSalida;
    private float cantidad;
    private String observaciones;

    public SalidaDeControlVo() {
        
        SalidaDeControlIT it = new SalidaDeControlIT();
        relacionCampo.put(it.getIdPDC().getNombre(), ()->this.getId());
        relacionCampo.put(it.getIdRefaccionPDC().getNombre(), ()->this.getIdRefaccion());
        relacionCampo.put(it.getIdMaquinaEnLaQueSeUsaraPDC().getNombre(), ()->this.getIdMaquinaEnLaQueSeUsara());
        relacionCampo.put(it.getIdEmpleadoPDC().getNombre(), ()->this.getIdEmpleado());
        relacionCampo.put(it.getFechaSalidaPDC().getNombre(), ()->this.getFechaSalida());
        relacionCampo.put(it.getCantidadPDC().getNombre(), ()->this.getCantidad());
        relacionCampo.put(it.getObservacionesPDC().getNombre(), ()->this.getObservaciones());
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getIdRefaccion() {
        return idRefaccion;
    }

    public void setIdRefaccion(Object idRefaccion) {
        this.idRefaccion = idRefaccion;
    }

    public Object getIdMaquinaEnLaQueSeUsara() {
        return idMaquinaEnLaQueSeUsara;
    }

    public void setIdMaquinaEnLaQueSeUsara(Object idMaquinaEnLaQueSeUsara) {
        this.idMaquinaEnLaQueSeUsara = idMaquinaEnLaQueSeUsara;
    }

    public Object getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Object idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Timestamp getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Timestamp fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
    
    
    
    
    
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
