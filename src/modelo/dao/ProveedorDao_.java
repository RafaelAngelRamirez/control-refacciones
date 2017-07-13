package modelo.dao;

import controlador.Coordinador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.InfoTabla.ProveedorIT;
import modelo.Conexion;
import modelo.vo.*;

/**
 *
 * @author Particular
 */
public class ProveedorDao_ extends DAOGenerales_{

    private final ProveedorIT it;

    public ProveedorDao_(Coordinador coordinador) {
        super(coordinador);
        this.it = new ProveedorIT();
    }
    /**
     * Guarda un nuevo proveedor. 
     * @param vo Información del proveedo. 
     */
    public void guardar(ProveedorVo vo) {
        String sql = "INSERT INTO "+ProveedorIT.NOMBRE_TABLA+" "
                + "VALUES (null, ?, ?, ?, ?, ?, ?)";
        HashMap<Integer, String> d = new HashMap<>();
        
        d.put(1, vo.getNombreContacto());
        d.put(2, vo.getTelefono());
        d.put(3, vo.getEmail());
        d.put(4, vo.getEmpresa());
        d.put(5, vo.getPaginaWeb());
        d.put(6, vo.getIdPais()+"");

        conexion.executeUpdate(sql, d);
    }
    
    /**
     * Retorna todos los proveedores por empresa. 
     * @return La lista de proveedores existentes. 
     */
    public List<ProveedorVo> consultarProveedores(){
       
        List<ProveedorVo> l = new ArrayList<>();
        try {
            String sql = "SELECT " +it.getIdPDC().getNombre() +", "+it.getEmpresaProveedorPDC().getNombre()
                    + " FROM " + ProveedorIT.NOMBRE_TABLA;
            Conexion c = new Conexion(coordinador);
            ResultSet r = c.executeQuery(sql);            
            
            
            while (r.next()) {
                ProveedorVo vo = new ProveedorVo();
                vo.setId(r.getInt(it.getIdPDC().getNombre()));
                vo.setEmpresa(r.getString(it.getEmpresaProveedorPDC().getNombre()));
                l.add(vo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDao_.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
    
    
    /**
     * Revisa si el proveedor existe en la base de datos.  
     * @param proveedor El proveedor que se quiere verificar. 
     * @return True si existe.
     */
    public boolean existe(String proveedor){
        try {
            String sql = "SELECT COUNT(*) FROM " + ProveedorIT.NOMBRE_TABLA
                    + " WHERE "+ it.getEmpresaProveedorPDC().getNombre() + "= ?";
            
            HashMap<Integer, String > datos= new HashMap<>();
            datos.put(1, proveedor);
            ResultSet r = conexion.executeQuery(sql, datos);
            r.next();
            int a = r.getInt(1);
            if (a>0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDao_.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}