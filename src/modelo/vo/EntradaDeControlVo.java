/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import java.sql.Timestamp;
import modelo.InfoTabla.EntradaDeControlIT;

/**
 *
 * @author Particular
 */
public class EntradaDeControlVo extends VoGenerales{

    
    private int id;
    private Object idRefaccion;
    private Object idMaquinaEnLaQueSeUsara;
    private Object idEmpleado;
    private Timestamp fechaSalida;
    private float cantidad;
    private String observaciones;

    public EntradaDeControlVo() {
        
        EntradaDeControlIT it = new EntradaDeControlIT();
        relacionCampo.put(it.getID().getNombre(), ()->this.getId());
        relacionCampo.put(it.getID_REFACCION_().getNombre(), ()->this.getIdRefaccion());
        relacionCampo.put(it.getID_MAQUINA_EN_LA_QUE_SE_USARA().getNombre(), ()->this.getIdMaquinaEnLaQueSeUsara());
        relacionCampo.put(it.getID_EMPLEADO().getNombre(), ()->this.getIdEmpleado());
        relacionCampo.put(it.getFECHA_SALIDA().getNombre(), ()->this.getFechaSalida());
        relacionCampo.put(it.getCANTIDAD().getNombre(), ()->this.getCantidad());
        relacionCampo.put(it.getOBSERVACIONES().getNombre(), ()->this.getObservaciones());
    
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
