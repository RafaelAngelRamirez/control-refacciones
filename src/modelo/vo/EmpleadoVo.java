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

    public EmpleadoVo() {
        EmpleadoIT i = new EmpleadoIT();
        relacionCampo.put(i.getIdPDC().getNombre(), ()->this.getId());
        relacionCampo.put(i.getNombrePDC().getNombre(), ()->this.getNombre());
        relacionCampo.put(i.getIdDepartamentoPDC().getNombre(), ()->this.getIdDepartamento());
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
    
    @Override
    public String toString() {
        String a = "Clase: "+this.getClass().getSimpleName()+"\n";
        String b= "       | ";
        String c =  "\n                Id" +b+ id+
                    "\n       idRefaccion" +b+ nombre+
                    "\n        idEmpleado" +b+ idDepartamento;
        String d =  "----------------------";
        return a+d+c+d;
        
    }
    
}
