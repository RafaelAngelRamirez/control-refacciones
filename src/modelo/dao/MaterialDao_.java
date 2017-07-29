package modelo.dao;

import controlador.Coordinador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.InfoTabla.MaterialIT;
import modelo.vo.MaterialVo;

/**
 *
 * @author Particular
 */
public class MaterialDao_ extends DAOGenerales_{
   
    MaterialIT it;
    public MaterialDao_(Coordinador coordinador) {
        super(coordinador);
        it = new MaterialIT();
    
    }
    
    public void guardar(MaterialVo vo){
        String sql = "INSERT INTO " + MaterialIT.NOMBRE_TABLA +
                " VALUES (null, ?)";
        conexion.executeUpdate(sql, vo.getMaterial());
    }
    
    public List<MaterialVo> consultar(){
        String sql = "SELECT * FROM " + MaterialIT.NOMBRE_TABLA;
        List<MaterialVo> l = new ArrayList<>();
        ResultSet r = conexion.executeQuery(sql);
        try {
            while (r.next()) {
                MaterialVo vo = new MaterialVo();
                vo.setId(r.getInt(it.getIdPDC().getNombre()));
                vo.setMaterial(r.getString(it.getMaterialPDC().getNombre()));
                l.add(vo);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaterialDao_.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
    
    public boolean existe(String material){
        String sql = "SELECT COUNT(*) FROM " + MaterialIT.NOMBRE_TABLA 
                +" WHERE " + it.getMaterialPDC().getNombre() + "=? ";
        ResultSet r = conexion.executeQuery(sql, material);
        try {
            r.next();
            int a = r.getInt(1);
            if (a>0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaterialDao_.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
   
    


}