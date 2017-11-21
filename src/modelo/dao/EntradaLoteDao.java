
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
        conexion = new Conexion(coordinador);
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
        conexion = new Conexion(coordinador);
        try {
            String sql = "SELECT SUM("+EntradaLoteIT.getCANTIDAD().getNombre()+")"
                    +" FROM " +
                    EntradaLoteIT.NOMBRE_TABLA
                    +" WHERE "+
                    EntradaLoteIT.getID_REFACCION().getNombre()+"=?";
            
            
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
        conexion = new Conexion(coordinador);
        String sql = "SELECT * FROM " + EntradaLoteIT.NOMBRE_TABLA
                +" WHERE "+
                it.getID_REFACCION().getNombre()+" = ?";
        String sqlTodo =
                " AND "+
                it.getCANTIDAD().getNombre()+" >0";
        if (!todosLosLotes) {
            sql+=sqlTodo;
        }
        
        ResultSet r = conexion.executeQuery(sql, id+"");
        List<EntradaLoteVo> listVo = new ArrayList<>();
        try {
            while (r.next()) {
                EntradaLoteVo vo = new EntradaLoteVo();
                vo.setCantidad(r.getFloat(it.getCANTIDAD().getNombre()));
                vo.setFechaRecepcionLote(r.getDate(it.getFECHA_RECEPCION_LOTE().getNombre()));
                vo.setId(r.getInt(it.getID().getNombre()));
                listVo.add(vo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntradaLoteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listVo;
    }
    
    
    /**
     * Obtenemos el lote más antiguo con existencia de la refacción que se pase
     * como parametro. Si no hay un lote que cumpla los parametros se devuelve
     * null.
     * 
     * @param id El id de la refacción que se quiere filtrar. 
     * @return El lote más antiguo que con existencia. 
     */
    public EntradaLoteVo loteMasAntiguo(int id){
        conexion = new Conexion(coordinador);
        String sql = "SELECT * FROM "+EntradaLoteIT.NOMBRE_TABLA 
                +" WHERE "+
                it.getID_REFACCION().getNombre()+"=?"
                +" AND "+
                it.getCANTIDAD().getNombre() +">0"
                +" AND "+
                it.getFECHA_RECEPCION_LOTE().getNombre()+" = " 
                +"(SELECT min("+it.getFECHA_RECEPCION_LOTE().getNombre()+") "
                        + " FROM "+EntradaLoteIT.NOMBRE_TABLA
                        + " WHERE "+
                        it.getID_REFACCION().getNombre()+ " =? "
                        + " AND "+
                        it.getCANTIDAD().getNombre() +">0 )" 
                +" AND "+
                it.getID().getNombre() +" = "+
                "(SELECT min("+it.getID().getNombre()+") "
                        +" FROM "+
                        EntradaLoteIT.NOMBRE_TABLA
                        +" WHERE "+
                        it.getID_REFACCION().getNombre()+"= ?"
                        +" AND "+ 
                        it.getCANTIDAD().getNombre() + " >0 "
                        +" AND " + 
                        it.getFECHA_RECEPCION_LOTE().getNombre() +" = "
                        +"(SELECT min("+it.getFECHA_RECEPCION_LOTE().getNombre() +") "
                            + " FROM " + EntradaLoteIT.NOMBRE_TABLA 
                            + " WHERE "+
                            it.getID_REFACCION().getNombre() + " =? "
                            + " AND "+
                            it.getCANTIDAD().getNombre() +">0 )"+
                ")";
        HashMap<Integer, Object> datos = new HashMap<>();
        datos.put(1, id);
        datos.put(2, id);
        datos.put(3, id);
        datos.put(4, id);
        ResultSet r = conexion.executeQuery(sql, datos);
        EntradaLoteVo vo = null;
        try {
            if(r.next()){
                vo = new EntradaLoteVo();
                vo.setId(r.getInt(it.getID().getNombre()));
                vo.setFechaRecepcionLote(r.getDate(it.getFECHA_RECEPCION_LOTE().getNombre()));
                vo.setCantidad(r.getFloat(it.getCANTIDAD().getNombre()));
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(EntradaLoteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return vo;  
            
                    
    }

    /**
     * Actualiza los lotes con la cantidad que se le pase como parametro. 
     * @param listaELVParaActualizar
     * @return
     */
    public boolean actualizarLotes(List<EntradaLoteVo> listaELVParaActualizar) {
        conexion = new Conexion(coordinador);
        String signos="";
        String sql = "UPDATE "+ EntradaLoteIT.NOMBRE_TABLA;
              sql += " SET " + it.getCANTIDAD().getNombre()+"= CASE " + it.getID().getNombre();
        
        int contador = 1;
        for (EntradaLoteVo a : listaELVParaActualizar) {
            
            sql += " WHEN ? THEN ? ";
           
            signos = contador<listaELVParaActualizar.size() ? signos +" ?, ":signos+" ? ";
            contador++;
            
        }
        sql+=" END ";
        
        sql+=" WHERE "+it.getID().getNombre()+" IN ("+signos+")" ;
        
        HashMap<Integer, Object> mapa = new HashMap<>();
        
        int c = 1;
        for (EntradaLoteVo v : listaELVParaActualizar) {
            mapa.put(c, v.getId());
            mapa.put(c+1, v.getCantidad());
            c+=2;
        }
        
        for (EntradaLoteVo v : listaELVParaActualizar) {
            mapa.put(c, v.getId());
            c++;
        }
        
        return conexion.executeUpdate(sql, mapa);
        
    }
    
    
    
}
