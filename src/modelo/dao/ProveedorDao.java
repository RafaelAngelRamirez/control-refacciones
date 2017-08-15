package modelo.dao;

import controlador.Coordinador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.InfoTabla.ProveedorIT;
import modelo.Conexion;
import modelo.InfoTabla.PaisIT;
import modelo.vo.*;

/**
 *
 * @author Particular
 */
public class ProveedorDao extends DAOGenerales{

    private final ProveedorIT it;

    public ProveedorDao(Coordinador coordinador) {
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
            Logger.getLogger(ProveedorDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProveedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Revisa si el proveedor existe en la base de datos comparando su id y el 
     * nombre la de empresa. De esta manera se verifica que el update no repita
     * los nombres de empresa al modificarse. 
     * @param vo El objeto a ProveedorVo a comparar. 
     * @return True si existe.
     */
    public boolean existe(ProveedorVo vo){
        try {
            String sql = "SELECT COUNT(*) FROM " + ProveedorIT.NOMBRE_TABLA
                    + " WHERE "+ it.getEmpresaProveedorPDC().getNombre() + "= ?"
                    + " AND " + it.getIdPDC().getNombre() + "<> ?";
            
            HashMap<Integer, String > datos= new HashMap<>();
            datos.put(1, vo.getEmpresa());
            datos.put(2, vo.getId()+"");
            
            ResultSet r = conexion.executeQuery(sql, datos);
            r.next();
            int a = r.getInt(1);
            if (a>0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    
    public int consultarUltimoId(){
        String sql = "SELECT MAX("+it.getIdPDC().getNombre()+") FROM "+ProveedorIT.NOMBRE_TABLA;
        ResultSet r = conexion.executeQuery(sql);
        try {
            r.next();
            return r.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(RefaccionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public ProveedorVo consultar(int id){
        PaisIT pit = new PaisIT();
        ProveedorVo vo = new ProveedorVo();
        String sql = "SELECT "+
                ProveedorIT.NOMBRE_TABLA+"."+it.getIdPDC().getNombre() +", "+
                ProveedorIT.NOMBRE_TABLA+"."+it.getNombreContactoPDC().getNombre() +", "+
                ProveedorIT.NOMBRE_TABLA+"."+it.getTelefonoPDC().getNombre() +", "+
                ProveedorIT.NOMBRE_TABLA+"."+it.getEmailPDC().getNombre() +", "+
                ProveedorIT.NOMBRE_TABLA+"."+it.getEmpresaProveedorPDC().getNombre() +", "+
                ProveedorIT.NOMBRE_TABLA+"."+it.getPaginaWebPDC().getNombre() +", "+
                PaisIT.NOMBRE_TABLA+"."+pit.getPaisPDC().getNombre()+
                " FROM " 
                + ProveedorIT.NOMBRE_TABLA +
                " INNER JOIN " 
                + PaisIT.NOMBRE_TABLA+
                " ON "
                + ProveedorIT.NOMBRE_TABLA+"."+it.getIdPaisPDC().getNombre()+
                " = "
                + PaisIT.NOMBRE_TABLA+"."+pit.getIdPDC().getNombre()+
                " WHERE " 
                +ProveedorIT.NOMBRE_TABLA+"."+it.getIdPDC().getNombre() +" =?";
        ResultSet r = conexion.executeQuery(sql, id+"");
        try {
            if (r.next()) {
                vo.setEmail(r.getString(it.getEmailPDC().getNombre()));
                vo.setEmpresa(r.getString(it.getEmpresaProveedorPDC().getNombre()));
                vo.setId(r.getInt(it.getIdPDC().getNombre()));
                vo.setIdPais(r.getString(pit.getPaisPDC().getNombre()));
                vo.setNombreContacto(r.getString(it.getNombreContactoPDC().getNombre()));
                vo.setPaginaWeb(r.getString(it.getPaginaWebPDC().getNombre()));
                vo.setTelefono(r.getString(it.getTelefonoPDC().getNombre()));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vo;
    }
    
    public boolean eliminar(ProveedorVo vo){
        String sql = 
                "DELETE FROM " + ProveedorIT.NOMBRE_TABLA 
                +" WHERE " +
                it.getIdPDC().getNombre() + " = ?";
        
                
        return conexion.executeUpdate(sql, vo.getId()+"");
    }
    
    public boolean modificar(ProveedorVo vo){
        
        String sql = "UPDATE " + ProveedorIT.NOMBRE_TABLA 
                +" SET " + 
                it.getEmpresaProveedorPDC().getNombre() + "=?, "+
                it.getNombreContactoPDC().getNombre() + "=?, "+
                it.getTelefonoPDC().getNombre() + "=?, "+
                it.getPaginaWebPDC().getNombre() + "=?, "+
                it.getEmailPDC().getNombre() + "=?, "+
                it.getIdPaisPDC().getNombre() + "=? "
                +" WHERE "+
                it.getIdPDC().getNombre() +" = ?";
        
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, vo.getEmpresa());
        map.put(2, vo.getNombreContacto());
        map.put(3, vo.getTelefono());
        map.put(4, vo.getPaginaWeb());
        map.put(5, vo.getEmail());
        map.put(6, vo.getIdPais()+"");
        map.put(7, vo.getId()+"");
        
        return conexion.executeUpdate(sql, map);
        
    }
}