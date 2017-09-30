package modelo.vo;

import modelo.InfoTabla.EntradaLoteIT;
import modelo.InfoTabla.SalidaLoteIT;

/**
 *
 * @author Particular
 */
public class SalidaLoteVo extends VoGenerales{

        
    private int id;
    private java.sql.Date fechaSalidaLote;
    private float cantidad;
    private int idRefaccion;
    private int idEmpleado;
    private int idLote;
    private String observaciones;

    public SalidaLoteVo() {
        SalidaLoteIT i = new SalidaLoteIT();
        relacionCampo.put(i.getIdPDC().getNombre(), ()->this.getId());
        relacionCampo.put(i.getFechaSalidaLotePDC().getNombre(), ()->this.getFechaSalidaLote());
        relacionCampo.put(i.getCantidadPDC().getNombre(), ()->this.getCantidad());
        relacionCampo.put(i.getIdRefaccionPDC().getNombre(), ()->this.getIdRefaccion());
        relacionCampo.put(i.getIdEmpleadoPDC().getNombre(), ()->this.getIdEmpleado());
        relacionCampo.put(i.getIdLotePDC().getNombre(), ()->this.getIdLote());
        relacionCampo.put(i.getObservacionesPDC().getNombre(), ()->this.getObservaciones());
    
    }

    public int getIdLote() {
        return idLote;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
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

    public java.sql.Date getFechaSalidaLote() {
        return fechaSalidaLote;
    }

    public void setFechaSalidaLote(java.sql.Date fechaSalidaLote) {
        this.fechaSalidaLote = fechaSalidaLote;
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
                    "\n   fechaSalidaLote" +b+ fechaSalidaLote+
                    "\n          cantidad" +b+ cantidad+
                    "\n       idRefaccion" +b+ idRefaccion+
                    "\n        idEmpleado" +b+ idEmpleado;
        String d =  "----------------------";
        return a+d+c+d;
        
    }
    
}
