package modelo.vo;

import modelo.InfoTabla.EmpleadoIT;

/**
 *
 * @author Particular
 */
public class EmpleadoVo extends VoGenerales{

    private int id;
    private String nombre;
    private Object idDepartamento;
    private byte bajaEmpleado;
    private java.sql.Date fechaBaja;
    private java.sql.Date fechaAlta;
    

    public EmpleadoVo() {
        EmpleadoIT i = new EmpleadoIT();
        relacionCampo.put(i.getID().getNombre(), ()->this.getId());
        relacionCampo.put(i.getNOMBRE().getNombre(), ()->this.getNombre());
        relacionCampo.put(i.getID_DEPARTAMENTO().getNombre(), ()->this.getIdDepartamento());
        relacionCampo.put(i.getBAJA_EMPLEADO().getNombre(), ()->this.getBajaEmpleado());
        relacionCampo.put(i.getFECHA_ALTA().getNombre(), ()->this.getFechaAlta());
        relacionCampo.put(i.getFECHA_BAJA().getNombre(), ()->this.getFechaAlta());
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Object idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public byte getBajaEmpleado() {
        return bajaEmpleado;
    }

    public void setBajaEmpleado(byte bajaEmpleado) {
        this.bajaEmpleado = bajaEmpleado;
    }

    public java.sql.Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(java.sql.Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public java.sql.Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(java.sql.Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    
    
    @Override
    public String toString() {
        String a = "Clase: "+this.getClass().getSimpleName()+"\n";
        String b= "       | ";
        String c =  "\n                Id" +b+ id+
                    "\n       idRefaccion" +b+ nombre+
                    "\n        idEmpleado" +b+ idDepartamento+
                    "\n      bajaEmpleado" +b+ bajaEmpleado+
                    "\n         fechaBaja" +b+ fechaBaja+
                    "\n         fechaAlta" +b+ fechaAlta;
        String d =  "----------------------";
        return a+d+c+d;
        
    }
    
}
