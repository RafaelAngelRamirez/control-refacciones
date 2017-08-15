package modelo.vo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import modelo.InfoTabla.ProveedorIT;
import modelo.dao.ProveedorDao;

/**
 *
 * @author Particular
 */
public class ProveedorVo extends VoGenerales{
    
    private int id;
    private String nombreContacto;
    private String telefono;
    private String email;
    private String empresa;
    private String paginaWeb;
    private Object idPais;
    
   

    public ProveedorVo() {
        ProveedorIT pit = new ProveedorIT();
                
        relacionCampo.put(pit.getEmpresaProveedorPDC().getNombre(), ()->this.getEmpresa());
        relacionCampo.put(pit.getIdPDC().getNombre(), ()->this.getId());
        relacionCampo.put(pit.getIdPaisPDC().getNombre(), ()->this.getIdPais());
        relacionCampo.put(pit.getNombreContactoPDC().getNombre(), ()->this.getNombreContacto());
        relacionCampo.put(pit.getPaginaWebPDC().getNombre(), ()->this.getPaginaWeb());
        relacionCampo.put(pit.getTelefonoPDC().getNombre(), ()->this.getTelefono());
        relacionCampo.put(pit.getEmailPDC().getNombre(), ()->this.getEmail());
        
    }

    public void setRelacionCampo(HashMap<String, Callable> relacionCampo) {
        this.relacionCampo = relacionCampo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public Object getIdPais() {
        return idPais;
    }

    public void setIdPais(Object idPais) {
        this.idPais = idPais;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
