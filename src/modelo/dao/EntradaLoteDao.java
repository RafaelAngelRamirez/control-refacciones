
package modelo.dao;

import controlador.Coordinador;
import java.util.HashMap;
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
    
    
    
    
    
    
}
