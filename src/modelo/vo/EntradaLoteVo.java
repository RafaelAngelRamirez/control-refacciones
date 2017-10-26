package modelo.vo;

import modelo.InfoTabla.EntradaLoteIT;
import modelo.Textos;

/**
 *
 * @author Particular
 */
public class EntradaLoteVo extends VoGenerales{

        
    private int id;
    private java.sql.Date fechaRecepcionLote;
    private float cantidad;
    private int idRefaccion;
    private int idEmpleado;
    private String observaciones;

    public EntradaLoteVo() {
        EntradaLoteIT i = new EntradaLoteIT();
        relacionCampo.put(i.getID().getNombre(), ()->this.getId());
        relacionCampo.put(i.getFECHA_RECEPCION_LOTE().getNombre(), ()->this.getFechaRecepcionLote());
        relacionCampo.put(i.getCANTIDAD().getNombre(), ()->this.getCantidad());
        relacionCampo.put(i.getID_REFACCION().getNombre(), ()->this.getIdRefaccion());
        relacionCampo.put(i.getID_EMPLEADO().getNombre(), ()->this.getIdEmpleado());
        relacionCampo.put(i.getOBSERVACIONES().getNombre(), ()->this.getObservaciones());
    
    }

    public String getNombreParaMostrarLote() {
        String idFormateado = Textos.formaetarNumeros(this.getId(), "0000");
        String completo = this.getFechaRecepcionLote()+"-"+idFormateado;
        return completo;
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

    public java.sql.Date getFechaRecepcionLote() {
        return fechaRecepcionLote;
    }

    public void setFechaRecepcionLote(java.sql.Date fechaRecepcionLote) {
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
