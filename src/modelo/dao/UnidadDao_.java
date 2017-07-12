package modelo.dao;

import controlador.Coordinador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.InfoTabla.UnidadIT;
import modelo.vo.*;

/**
 *
 * @author Particular
 */
public class UnidadDao_ extends DAOGenerales_{
    
    private final UnidadIT it;
    public UnidadDao_ (Coordinador coordinador) {
        super(coordinador);
        it = new UnidadIT();
    }

    

    public void guardar(UnidadVo vo){
        String sql = "INSERT INTO " + UnidadIT.NOMBRE_TABLA 
                + " VALUES (null,  ?)";
       
        conexion.executeUpdate(sql, vo.getUnidad());
    }
    
    public List<UnidadVo> consultar(){
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
            Logger.getLogger(UnidadDao_.class.getName()).log(Level.SEVERE, null, ex);
        }
            return l;
    }
    
    public boolean existe(String unidad){
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
            Logger.getLogger(UnidadDao_.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}