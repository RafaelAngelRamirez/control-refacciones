
package modelo.dao;

import controlador.Coordinador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.InfoTabla.DepartamentoIT;
import modelo.vo.DepartamentoVo;

/**
 *
 * @author Particular
 */
public class DepartamentoDao extends DAOGenerales{
    
    DepartamentoIT it;
    
    public DepartamentoDao(Coordinador coordinador) {
        super(coordinador);
        this.it = new DepartamentoIT();
        
    }
    
    
    public boolean guardar(DepartamentoVo vo){
        conexion = new Conexion(coordinador);
        String sql = "INSERT INTO " + DepartamentoIT.NOMBRE_TABLA + " VALUES (null, ?)";
        boolean r = conexion.executeUpdate(sql, vo.getDepartamento());
        return r;
    }
    
    public List<DepartamentoVo> consultarTodo(){
        conexion = new Conexion(coordinador);
        String sql = "SELECT * FROM " + DepartamentoIT.NOMBRE_TABLA;
        List<DepartamentoVo> listaVo = new ArrayList<>();
        
        ResultSet r = conexion.executeQuery(sql);
        try {
            while (r.next()) {
                DepartamentoVo vo = new DepartamentoVo();
                vo.setId(r.getInt(it.getID().getNombre()));
                vo.setDepartamento(r.getString(it.getDEPARTAMENTO().getNombre()));
                listaVo.add(vo);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVo;
    }
    
    
    
}
