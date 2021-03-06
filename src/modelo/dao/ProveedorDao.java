package modelo.dao;

import controlador.Coordinador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.InfoTabla.PaisIT;
import modelo.InfoTabla.ProveedorIT;
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
     * @return  True si todo salio bien.
     */
    public boolean guardar(ProveedorVo vo) {
        conexion = new Conexion(coordinador);
        String sql = "INSERT INTO "+ProveedorIT.NOMBRE_TABLA+" "
                + "VALUES (null, ?, ?, ?, ?, ?, ?)";
        HashMap<Integer, Object> d = new HashMap<>();
        
        d.put(1, vo.getNombreContacto());
        d.put(2, vo.getTelefono());
        d.put(3, vo.getEmail());
        d.put(4, vo.getEmpresa());
        d.put(5, vo.getPaginaWeb());
        d.put(6, vo.getIdPais()+"");

        return conexion.executeUpdate(sql, d);
    }
    
    /**
     * Retorna todos los proveedores por empresa. 
     * @return La lista de proveedores existentes. 
     */
    public List<ProveedorVo> consultarProveedores(){
        conexion= new Conexion(coordinador);
        
        List<ProveedorVo> l = new ArrayList<>();
        try {
            String sql = "SELECT " +it.getID().getNombre() +", "+it.getEMPRESA_PROVEEDOR().getNombre()
                    + " FROM " + ProveedorIT.NOMBRE_TABLA;
            ResultSet r = conexion.executeQuery(sql);            
            
            
            while (r.next()) {
                ProveedorVo vo = new ProveedorVo();
                vo.setId(r.getInt(it.getID().getNombre()));
                vo.setEmpresa(r.getString(it.getEMPRESA_PROVEEDOR().getNombre()));
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
        conexion = new Conexion(coordinador);
        try {
            String sql = "SELECT COUNT(*) FROM " + ProveedorIT.NOMBRE_TABLA
                    + " WHERE "+ it.getEMPRESA_PROVEEDOR().getNombre() + "= ?";
            
            HashMap<Integer, Object > datos= new HashMap<>();
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
        conexion = new Conexion(coordinador);
        try {
            String sql = "SELECT COUNT(*) FROM " + ProveedorIT.NOMBRE_TABLA
                    + " WHERE "+ it.getEMPRESA_PROVEEDOR().getNombre() + "= ?"
                    + " AND " + it.getID().getNombre() + "<> ?";
            
            HashMap<Integer, Object > datos= new HashMap<>();
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
        conexion = new Conexion(coordinador);
        String sql = "SELECT MAX("+it.getID().getNombre()+") FROM "+ProveedorIT.NOMBRE_TABLA;
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
        conexion =  new Conexion(coordinador);
        PaisIT pit = new PaisIT();
        ProveedorVo vo = new ProveedorVo();
        String sql = "SELECT "+
                ProveedorIT.NOMBRE_TABLA+"."+it.getID().getNombre() +", "+
                ProveedorIT.NOMBRE_TABLA+"."+it.getNOMBRE_CONTACTO().getNombre() +", "+
                ProveedorIT.NOMBRE_TABLA+"."+it.getTELEFONO().getNombre() +", "+
                ProveedorIT.NOMBRE_TABLA+"."+it.getEMAIL().getNombre() +", "+
                ProveedorIT.NOMBRE_TABLA+"."+it.getEMPRESA_PROVEEDOR().getNombre() +", "+
                ProveedorIT.NOMBRE_TABLA+"."+it.getPAGINA_WEB().getNombre() +", "+
                PaisIT.NOMBRE_TABLA+"."+pit.getPAIS().getNombre()+
                " FROM " 
                + ProveedorIT.NOMBRE_TABLA +
                " INNER JOIN " 
                + PaisIT.NOMBRE_TABLA+
                " ON "
                + ProveedorIT.NOMBRE_TABLA+"."+it.getID_PAIS().getNombre()+
                " = "
                + PaisIT.NOMBRE_TABLA+"."+pit.getID().getNombre()+
                " WHERE " 
                +ProveedorIT.NOMBRE_TABLA+"."+it.getID().getNombre() +" =?";
        ResultSet r = conexion.executeQuery(sql, id+"");
        try {
            if (r.next()) {
                vo.setEmail(r.getString(it.getEMAIL().getNombre()));
                vo.setEmpresa(r.getString(it.getEMPRESA_PROVEEDOR().getNombre()));
                vo.setId(r.getInt(it.getID().getNombre()));
                vo.setIdPais(r.getString(pit.getPAIS().getNombre()));
                vo.setNombreContacto(r.getString(it.getNOMBRE_CONTACTO().getNombre()));
                vo.setPaginaWeb(r.getString(it.getPAGINA_WEB().getNombre()));
                vo.setTelefono(r.getString(it.getTELEFONO().getNombre()));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vo;
    }
    
    public boolean eliminar(ProveedorVo vo){
        conexion = new Conexion(coordinador);
        String sql = 
                "DELETE FROM " + ProveedorIT.NOMBRE_TABLA 
                +" WHERE " +
                it.getID().getNombre() + " = ?";
        
                
        return conexion.executeUpdate(sql, vo.getId()+"");
    }
    
    public boolean modificar(ProveedorVo vo){
        conexion = new Conexion(coordinador);
        String sql = "UPDATE " + ProveedorIT.NOMBRE_TABLA 
                +" SET " + 
                it.getEMPRESA_PROVEEDOR().getNombre() + "=?, "+
                it.getNOMBRE_CONTACTO().getNombre() + "=?, "+
                it.getTELEFONO().getNombre() + "=?, "+
                it.getPAGINA_WEB().getNombre() + "=?, "+
                it.getEMAIL().getNombre() + "=?, "+
                it.getID_PAIS().getNombre() + "=? "
                +" WHERE "+
                it.getID().getNombre() +" = ?";
        
        HashMap<Integer, Object> map = new HashMap<>();
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