
package modelo.dao;

import controlador.Coordinador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.InfoTabla.SalidaLoteIT;
import modelo.vo.EntradaLoteVo;


public class SalidaLoteDao extends DAOGenerales{
    
    SalidaLoteIT it;
    
    public SalidaLoteDao(Coordinador coordinador) {
        super(coordinador);
        this.it = new SalidaLoteIT();
    }
    
    public boolean guardar(EntradaLoteVo vo){
        String sql = "INSERT INTO "+ SalidaLoteIT.NOMBRE_TABLA 
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
                    SalidaLoteIT.NOMBRE_TABLA
                    +" WHERE "+
                    it.getIdRefaccionPDC().getNombre()+"=?";
            ResultSet r = conexion.executeQuery(sql, id+"");
            r.next();
            return r.getFloat(1);
        } catch (SQLException ex) {
            Logger.getLogger(SalidaLoteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
        
    }
    
    
    
    
    
    
}
