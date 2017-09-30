package modelo.vo;

import modelo.InfoTabla.DepartamentoIT;

/**
 *
 * @author Particular
 */
public class DepartamentoVo extends VoGenerales{

    private int id;
    private String departamento;

    public DepartamentoVo() {
        DepartamentoIT i = new DepartamentoIT();
        
        relacionCampo.put(i.getIdPDC().getNombre(), ()->this.getId());
        relacionCampo.put(i.getDepartamentoPDC().getNombre(), ()->this.getDepartamento());
                
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
     
    
    
    @Override
    public String toString() {
         String a = "Clase: "+this.getClass().getSimpleName()+"\n";
        String b= "       | ";
        String c =  "\n                Id" +b+ id+
                    "\n        idEmpleado" +b+ departamento;
        String d =  "----------------------";
        return a+d+c+d;
    }
    
}
