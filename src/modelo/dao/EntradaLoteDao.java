
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
import modelo.InfoTabla.EntradaLoteIT;
import modelo.vo.EntradaLoteVo;

/**
 *
 * @author Particular
 */
public class EntradaLoteDao extends DAOGenerales{
    
    EntradaLoteIT it;
    
    public EntradaLoteDao(Coordinador coordinador) {
        super(coordinador);
        this.it = new EntradaLoteIT();
    }
    
    public boolean guardar(EntradaLoteVo vo){
        String sql = "INSERT INTO "+ EntradaLoteIT.NOMBRE_TABLA 
                +" VALUES (null, ?, ?, ?, ?, ?)";
        
        
        HashMap<Integer, Object> datos = new HashMap<>();
        datos.put(1, vo.getFechaRecepcionLote());
        datos.put(2, vo.getCantidad());
        datos.put(3, vo.getIdRefaccion());
        datos.put(4, vo.getIdEmpleado());
        datos.put(5, vo.getObservaciones());
        
        return conexion.executeUpdate(sql, datos);
        
    
    }
    
    public float existencia(int id){
        try {
            String sql = "SELECT SUM("+it.getCantidadPDC().getNombre()+")"
                    +" FROM " +
                    EntradaLoteIT.NOMBRE_TABLA
                    +" WHERE "+
                    it.getIdRefaccionPDC().getNombre()+"=?";
            ResultSet r = conexion.executeQuery(sql, id+"");
            r.next();
            return r.getFloat(1);
        } catch (SQLException ex) {
            Logger.getLogger(EntradaLoteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
        
    }
    
    
    /**
     * Da la opción de filtrar los lotes que esten en ceros.
     * @param id El i de la refaccion que se quiere filtrar. 
     * @param todosLosLotes True si se quieren incluir los lotes en 0.
     * @return La lista de lotes que coinciden con los parametros. 
     */
    public List<EntradaLoteVo> lotes(int id, boolean todosLosLotes){
        String sql = "SELECT * FROM " + EntradaLoteIT.NOMBRE_TABLA
                +" WHERE "+
                it.getIdRefaccionPDC().getNombre()+" = ?";
        String sqlTodo =
                " AND "+
                it.getCantidadPDC().getNombre()+" >0";
        if (!todosLosLotes) {
            sql+=sqlTodo;
        }
        
        ResultSet r = conexion.executeQuery(sql, id+"");
        List<EntradaLoteVo> listVo = new ArrayList<>();
        try {
            while (r.next()) {
                EntradaLoteVo vo = new EntradaLoteVo();
                vo.setCantidad(r.getFloat(it.getCantidadPDC().getNombre()));
                vo.setFechaRecepcionLote(r.getDate(it.getFechaRecepcionLotePDC().getNombre()));
                vo.setId(r.getInt(it.getIdPDC().getNombre()));
                listVo.add(vo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntradaLoteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listVo;
    }
    
    public boolean actualizarExistencia(EntradaLoteVo vo){
        String sql = "UPDATE " + EntradaLoteIT.NOMBRE_TABLA 
                +" SET "+
                it.getCantidadPDC().getNombre() + " = " +it.getCantidadPDC().getNombre()+"- ?"
                +" WHERE "+
                it.getIdPDC().getNombre() +" = ?";
        HashMap<Integer, Object> datos = new HashMap<>();
        datos.put(1, vo.getCantidad());
        datos.put(1, vo.getId());
        return conexion.executeUpdate(sql, datos);
    }
    
    
    
}
