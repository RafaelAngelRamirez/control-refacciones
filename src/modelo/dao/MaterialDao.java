package modelo.dao;

import controlador.Coordinador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.InfoTabla.MaterialIT;
import modelo.vo.MaterialVo;

/**
 *
 * @author Particular
 */
public class MaterialDao extends DAOGenerales{
   
    MaterialIT it;
    public MaterialDao(Coordinador coordinador) {
        super(coordinador);
        it = new MaterialIT();
    
    }
    
    public boolean guardar(MaterialVo vo){
        conexion = new Conexion(coordinador);
        String sql = "INSERT INTO " + MaterialIT.NOMBRE_TABLA +
                " VALUES (null, ?)";
        return conexion.executeUpdate(sql, vo.getMaterial());
    }
    
    public List<MaterialVo> consultar(){
        conexion = new Conexion(coordinador);
        String sql = "SELECT * FROM " + MaterialIT.NOMBRE_TABLA;
        List<MaterialVo> l = new ArrayList<>();
        ResultSet r = conexion.executeQuery(sql);
        try {
            while (r.next()) {
                MaterialVo vo = new MaterialVo();
                vo.setId(r.getInt(it.getID().getNombre()));
                vo.setMaterial(r.getString(it.getMATERIAL().getNombre()));
                l.add(vo);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
    
    public boolean existe(String material){
        conexion = new Conexion(coordinador);
        String sql = "SELECT COUNT(*) FROM " + MaterialIT.NOMBRE_TABLA 
                +" WHERE " + it.getMATERIAL().getNombre() + "=? ";
        ResultSet r = conexion.executeQuery(sql, material);
        try {
            r.next();
            int a = r.getInt(1);
            if (a>0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
   
    


}