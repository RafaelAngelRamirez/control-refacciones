package modelo.dao;

import controlador.Coordinador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.InfoTabla.UnidadIT;
import modelo.vo.*;

/**
 *
 * @author Particular
 */
public class UnidadDao extends DAOGenerales{
    
    private final UnidadIT it;
    public UnidadDao (Coordinador coordinador) {
        super(coordinador);
        it = new UnidadIT();
    }

    

    public boolean guardar(UnidadVo vo){
        conexion = new Conexion(coordinador);

        String sql = "INSERT INTO " + UnidadIT.NOMBRE_TABLA 
                + " VALUES (null,  ?)";
       
        return conexion.executeUpdate(sql, vo.getUnidad());
    }
    
    public List<UnidadVo> consultar(){
        conexion = new Conexion(coordinador);
        String sql = "SELECT * FROM " + UnidadIT.NOMBRE_TABLA;
        List<UnidadVo> l = new ArrayList<>();
        
        try {
            ResultSet r = conexion.executeQuery(sql);
            while (r.next()) {
                UnidadVo vo = new UnidadVo();
                vo.setId(r.getInt(it.getIdPDC().getNombre()));
                vo.setUnidad(r.getString(it.getUnidadPDC().getNombre()));
                l.add(vo);
            }
            return l;
        } catch (SQLException ex) {
            Logger.getLogger(UnidadDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            return l;
    }
    
    public boolean existe(String unidad){
        conexion = new Conexion(coordinador);
        try {
            String sql = "SELECT COUNT(*) FROM " +UnidadIT.NOMBRE_TABLA 
                    + " WHERE "+it.getUnidadPDC().getNombre()+"=?";
            ResultSet r = conexion.executeQuery(sql, unidad);
            r.next();
            int a = r.getInt(1);
            if (a>0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UnidadDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}