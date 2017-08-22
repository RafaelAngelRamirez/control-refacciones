
package modelo.dao;

import controlador.Coordinador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        String sql = "INSERT INTO " + DepartamentoIT.NOMBRE_TABLA + " VALUES (null, ?)";
        return conexion.executeUpdate(sql, vo.getDepartamento());
    }
    
    public List<DepartamentoVo> consultarTodo(){
        String sql = "SELECT * FROM " + DepartamentoIT.NOMBRE_TABLA;
        List<DepartamentoVo> listaVo = new ArrayList<>();
        
        ResultSet r = conexion.executeQuery(sql);
        try {
            while (r.next()) {
                DepartamentoVo vo = new DepartamentoVo();
                vo.setId(r.getInt(it.getIdPDC().getNombre()));
                vo.setDepartamento(r.getString(it.getDepartamentoPDC().getNombre()));
                listaVo.add(vo);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaVo;
    }
    
    
    
}
