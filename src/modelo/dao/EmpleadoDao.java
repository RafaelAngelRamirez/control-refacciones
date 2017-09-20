
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
import modelo.Conexion;
import modelo.InfoTabla.DepartamentoIT;
import modelo.InfoTabla.EmpleadoIT;
import modelo.Textos;
import modelo.vo.EmpleadoVo;

/**
 *
 * @author Particular
 */
public class EmpleadoDao extends DAOGenerales{
    
    EmpleadoIT it;
    
    public EmpleadoDao(Coordinador coordinador) {
        super(coordinador);
        this.it = new EmpleadoIT();
    }
    
    public boolean existe(EmpleadoVo vo){
        conexion = new Conexion(coordinador);
        String sql = "SELECT COUNT(*) FROM " + EmpleadoIT.NOMBRE_TABLA 
                +" WHERE "+
                it.getNombrePDC().getNombre()+" =? "
                +" AND "+
                it.getIdDepartamentoPDC().getNombre() +" =?"
                +" AND "+
                it.getBajaEmpleadoPDC().getNombre() +" =false"               
                ;
        
        HashMap<Integer, Object> mapa = new HashMap<>();
        mapa.put(1, vo.getNombre());
        mapa.put(2, vo.getIdDepartamento());
        
        ResultSet r = conexion.executeQuery(sql, mapa);
        try {
            r.next();
            int i = r.getInt(1);
            return (i>0);
            
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public boolean guardar(EmpleadoVo vo){
        conexion = new Conexion(coordinador);
        String sql = "INSERT INTO " + EmpleadoIT.NOMBRE_TABLA 
                +" VALUES (null, ?, ?, ?, null, ?)";
        
        HashMap<Integer, Object> mapa = new HashMap<>();
        mapa.put(1, vo.getNombre());
        mapa.put(2, vo.getIdDepartamento());
        mapa.put(3, vo.getBajaEmpleado());
        mapa.put(4, vo.getFechaAlta());
        return conexion.executeUpdate(sql, mapa);
    }
    
    public int consultarUltimoId(){
        String sql = "SELECT MAX(" + it.getIdPDC().getNombre() + ") FROM "+EmpleadoIT.NOMBRE_TABLA;
        ResultSet r = conexion.executeQuery(sql);
        try {
            r.next();
            return r.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;    
    }
    
    /**
     * Consulta todos los datos de empleados sin tomar encuenta a los que
     * han sido dados de baja.
     * 
     * @return Los empleados que no han sido dados de baja. 
     */
    public List<EmpleadoVo> consultarTodo(){
        return consultarTodoConBajas(false);
    }
    
    /**
     * Consulta todos los datos de empleados sin tomar encuenta a los que
     * han sido dados de baja.
     * 
     * @param incluirBajas True si se quieren listar las bajas. 
     * @return Los empleados que no han sido dados de baja. 
     */
    public List<EmpleadoVo> consultarTodoConBajas(){
        return consultarTodoConBajas(true);
    }
    
    private List<EmpleadoVo> consultarTodoConBajas(boolean incluirBajas){
        conexion = new Conexion(coordinador);
        DepartamentoIT dit = new DepartamentoIT();
        List<EmpleadoVo> listVo= new ArrayList<>();
        String sql = "SELECT "+
                EmpleadoIT.NOMBRE_TABLA+"."+it.getIdPDC().getNombre()+", "+
                EmpleadoIT.NOMBRE_TABLA+"."+it.getNombrePDC().getNombre()+", "+
                DepartamentoIT.NOMBRE_TABLA+"."+dit.getDepartamentoPDC().getNombre();
        if (incluirBajas) {
            
            String sqlBaj = ", "+            
                    EmpleadoIT.NOMBRE_TABLA+"."+it.getBajaEmpleadoPDC().getNombre()+", "+
                    EmpleadoIT.NOMBRE_TABLA+"."+it.getFechaBaja().getNombre()+", "+
                    EmpleadoIT.NOMBRE_TABLA+"."+it.getFechaAlta().getNombre();
            sql += sqlBaj;
        }
        sql +=  " FROM " + 
                EmpleadoIT.NOMBRE_TABLA
                +" INNER JOIN "+
                DepartamentoIT.NOMBRE_TABLA
                +" ON "+
                EmpleadoIT.NOMBRE_TABLA+"."+it.getIdDepartamentoPDC().getNombre()
                +" = "+
                DepartamentoIT.NOMBRE_TABLA+"."+dit.getIdPDC().getNombre();
        
        if (!incluirBajas) {
            String sqlBajas = 
                " WHERE "+
                EmpleadoIT.NOMBRE_TABLA+"."+it.getBajaEmpleadoPDC().getNombre()+"=false";
            sql =sql+sqlBajas;
        }
        sql += " ORDER BY "+EmpleadoIT.NOMBRE_TABLA+"."+it.getIdPDC().getNombre() + " DESC";
        
        ResultSet r = conexion.executeQuery(sql);
        try {
            while (r.next()) {
                EmpleadoVo vo = new EmpleadoVo();
                vo.setId(r.getInt(it.getIdPDC().getNombre()));
                vo.setNombre(r.getString(it.getNombrePDC().getNombre()));
                vo.setIdDepartamento(r.getObject(dit.getDepartamentoPDC().getNombre()));
                if (incluirBajas) {
                    vo.setBajaEmpleado(r.getByte(it.getBajaEmpleadoPDC().getNombre()));
                    vo.setFechaBaja(r.getDate(it.getFechaBaja().getNombre()));
                    vo.setFechaAlta(r.getDate(it.getFechaAlta().getNombre()));
                }
                listVo.add(vo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listVo;
    
    }
    
    /**
     * Realiza una busqueda sin incluir a los empleados dados de baja. 
     * @param busqueda La busqueda a realizar. 
     * @return
     */
    public List<EmpleadoVo> consultarBusqueda(String busqueda){
        return consultarBusqueda(busqueda, false);
    }
    
    /**
     * Realiza una busqueda de los empleados. 
     * @param busqueda La busqueda a realizar. 
     * @param bajas True si se quiere incluir bajas
     * @return
     */
    public List<EmpleadoVo> consultarBusquedaConBajas(String busqueda){
        return consultarBusqueda(busqueda, true);
    
    }

    private List<EmpleadoVo> consultarBusqueda(String busqueda, boolean incluirBajas){
        conexion = new Conexion(coordinador);
        DepartamentoIT dit = new DepartamentoIT();
        List<EmpleadoVo> listVo= new ArrayList<>();
        busqueda = Textos.especialREGEX(busqueda);
        
        String sql = "SELECT "+
                EmpleadoIT.NOMBRE_TABLA+"."+it.getIdPDC().getNombre()+", "+
                EmpleadoIT.NOMBRE_TABLA+"."+it.getNombrePDC().getNombre()+", "+
                DepartamentoIT.NOMBRE_TABLA+"."+dit.getDepartamentoPDC().getNombre();
        if (incluirBajas) {
            
            String sqlBaj = ", "+            
                    EmpleadoIT.NOMBRE_TABLA+"."+it.getBajaEmpleadoPDC().getNombre()+", "+
                    EmpleadoIT.NOMBRE_TABLA+"."+it.getFechaBaja().getNombre()+", "+
                    EmpleadoIT.NOMBRE_TABLA+"."+it.getFechaAlta().getNombre();
            sql += sqlBaj;
        }
        sql +=  " FROM " + 
                EmpleadoIT.NOMBRE_TABLA
                +" INNER JOIN "+
                DepartamentoIT.NOMBRE_TABLA
                +" ON "+
                EmpleadoIT.NOMBRE_TABLA+"."+it.getIdDepartamentoPDC().getNombre()
                +" = "+
                DepartamentoIT.NOMBRE_TABLA+"."+dit.getIdPDC().getNombre();
        
        
        
        String regexp = " REGEXP '.*"+busqueda+"|"+busqueda+".*' ";
           
        String sqlBusqueda = 
                " WHERE " +
                it.getNombrePDC().getNombre() + regexp
                + " OR " + 
                DepartamentoIT.NOMBRE_TABLA+"."+dit.getDepartamentoPDC().getNombre() + regexp;
        
        
        
        String sqlOrden =  
                " ORDER BY "+  EmpleadoIT.NOMBRE_TABLA +"."+ it.getNombrePDC().getNombre() +" ASC ";
    
        if (!busqueda.isEmpty()) {
            sql += sqlBusqueda;
            
            if (!incluirBajas) {
                String sqlBajas = 
                    " AND "+
                    EmpleadoIT.NOMBRE_TABLA+"."+it.getBajaEmpleadoPDC().getNombre()+"=false";
                sql =sql+sqlBajas;
            }
        }
        
            
        sql+=sqlOrden;
        
        ResultSet r = conexion.executeQuery(sql);
        
        try {
            while (r.next()) {
                EmpleadoVo v = new EmpleadoVo();
                v.setId(r.getInt(it.getIdPDC().getNombre()));
                v.setIdDepartamento(r.getObject(dit.getDepartamentoPDC().getNombre()));
                v.setNombre(r.getString(it.getNombrePDC().getNombre()));
                if (incluirBajas) {
                    v.setBajaEmpleado(r.getByte(it.getBajaEmpleadoPDC().getNombre()));
                    v.setFechaBaja(r.getDate(it.getFechaBaja().getNombre()));
                    v.setFechaAlta(r.getDate(it.getFechaAlta().getNombre()));
                }
                listVo.add(v);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listVo;
    }
    
    public boolean modificar(EmpleadoVo vo){
        conexion = new Conexion(coordinador);
        String sql = "UPDATE " + EmpleadoIT.NOMBRE_TABLA 
                +" SET "+
                it.getNombrePDC().getNombre()+" = ?,"+ 
                it.getIdDepartamentoPDC().getNombre()+" = ?,"+ 
                it.getBajaEmpleadoPDC().getNombre()+" = ?" 
                +" WHERE "+
                it.getIdPDC().getNombre()+"=?";
        HashMap<Integer, Object> mapa = new HashMap<>();
        mapa.put(1, vo.getNombre());
        mapa.put(2, vo.getIdDepartamento());
        mapa.put(3, vo.getBajaEmpleado());
        mapa.put(4, vo.getId());
        if(conexion.executeUpdate(sql, mapa))
            return true;
        else
            return false;
    }
    
    public boolean darDeBajaAlta(EmpleadoVo vo){
        conexion = new Conexion(coordinador);
        String sql = " UPDATE " + EmpleadoIT.NOMBRE_TABLA
                +" SET "+
                it.getBajaEmpleadoPDC().getNombre()+"=?"
                +" WHERE "+
                it.getIdPDC().getNombre()+"=?";
        
        HashMap<Integer, Object> mapa = new HashMap<>();
        mapa.put(1, vo.getBajaEmpleado());
        mapa.put(2, vo.getId());
        if (conexion.executeUpdate(sql, mapa))
            return true;
        else
            return false;
        
    }
    
    
    
}
