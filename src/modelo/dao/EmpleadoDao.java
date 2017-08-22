
package modelo.dao;

import controlador.Coordinador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.InfoTabla.EmpleadoIT;
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
        String sql = "SELECT COUNT(*) FROM " + EmpleadoIT.NOMBRE_TABLA 
                +" WHERE "+
                it.getNombrePDC().getNombre() +" =? "
                +" AND "+
                it.getIdDepartamentoPDC().getNombre() +" =?";
        
        HashMap<Integer, Object> mapa = new HashMap<>();
        mapa.put(1, vo.getNombre());
        mapa.put(2, vo.getIdDepartamento());
        
        ResultSet r = conexion.executeQuery(sql, mapa);
        try {
            r.next();
            int i = r.getInt(1);
            if (i>0) 
                return true;
            return false;
            
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public boolean guardar(EmpleadoVo vo){
        String sql = "INSERT INTO " + EmpleadoIT.NOMBRE_TABLA 
                +" VALUES (null, ?, ?)";
        
        HashMap<Integer, Object> mapa = new HashMap<>();
        mapa.put(1, vo.getNombre());
        mapa.put(2, vo.getIdDepartamento());
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
    
    
    
    
    
    
}
