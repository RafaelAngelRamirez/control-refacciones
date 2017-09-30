
package modelo.dao;

import controlador.Coordinador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.InfoTabla.SalidaLoteIT;
import modelo.vo.SalidaLoteVo;


public class SalidaLoteDao extends DAOGenerales{
    
    SalidaLoteIT it;
    
    public SalidaLoteDao(Coordinador coordinador) {
        super(coordinador);
        this.it = new SalidaLoteIT();
    }
    
    public boolean guardar(List<SalidaLoteVo> vo){
        conexion = new Conexion(coordinador);
        String sql = "INSERT INTO " + SalidaLoteIT.NOMBRE_TABLA + " VALUES ";
        
        int cont1 = 1;
        for (SalidaLoteVo v : vo) {
            
            String a = "(null, ?, ?,?,?,?,? ) ";
            sql = cont1<vo.size() ? sql+a+",":sql+a;
            cont1++;
        }
        
        HashMap<Integer, Object> mapa = new HashMap<>();
        int cont =1;
        for (SalidaLoteVo v : vo) {
            mapa.put(cont, v.getFechaSalidaLote());
            cont++;
            mapa.put(cont, v.getIdLote());
            cont++;
            mapa.put(cont, v.getCantidad());
            cont++;
            mapa.put(cont, v.getIdRefaccion());
            cont++;
            mapa.put(cont, v.getIdEmpleado());
            cont++;
            mapa.put(cont, v.getObservaciones());
            cont++;
            
        }
        
        return conexion.executeUpdate(sql, mapa);
    }
    
    
    
    
    
}
