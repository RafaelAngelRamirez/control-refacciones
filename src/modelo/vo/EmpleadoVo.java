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
    private String fechaBaja;
    private String fechaAlta;
    

    public EmpleadoVo() {
        EmpleadoIT i = new EmpleadoIT();
        relacionCampo.put(i.getIdPDC().getNombre(), ()->this.getId());
        relacionCampo.put(i.getNombrePDC().getNombre(), ()->this.getNombre());
        relacionCampo.put(i.getIdDepartamentoPDC().getNombre(), ()->this.getIdDepartamento());
        relacionCampo.put(i.getBajaEmpleadoPDC().getNombre(), ()->this.isBajaEmpleado());
        relacionCampo.put(i.getFechaAlta().getNombre(), ()->this.getFechaAlta());
        relacionCampo.put(i.getFechaBaja().getNombre(), ()->this.getFechaAlta());
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

    public byte isBajaEmpleado() {
        return bajaEmpleado;
    }

    public void setBajaEmpleado(byte bajaEmpleado) {
        this.bajaEmpleado = bajaEmpleado;
    }

    public String getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(String fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
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
