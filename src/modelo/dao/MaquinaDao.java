/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import controlador.Coordinador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.InfoTabla.MaquinaIT;
import modelo.vo.MaquinaVo;

/**
 *
 * @author Particular
 */
public class MaquinaDao extends DAOGenerales{
    
    MaquinaIT it;
    
    public MaquinaDao(Coordinador coordinador) {
        super(coordinador);
        it = new MaquinaIT();
        
    }

    /**
     * Retorna todos los elementos de esta tabla. 
     * @return
     */
    public List<MaquinaVo> consultar() {
        conexion = new Conexion(coordinador);
        String sql = "SELECT * FROM "+MaquinaIT.NOMBRE_TABLA;
        
        ResultSet r = conexion.executeQuery(sql);
        List<MaquinaVo> listVo = new ArrayList<>();
        try {
            while (r.next()) {
                MaquinaVo vo = new MaquinaVo();
                vo.setId(r.getInt(it.getIdPDC().getNombre()));
                vo.setIdMaquinaModelo(r.getInt(it.getIdMaquinaModeloPDC().getNombre()));
                vo.setNumeroDeMáquina(r.getString(it.getNumeroDeMaquinaPDC().getNombre()));
                listVo.add(vo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaquinaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listVo;
    }

    public boolean eliminar(MaquinaVo vo) {
        conexion = new Conexion(coordinador);
        String sql = "DELETE FROM " + MaquinaIT.NOMBRE_TABLA 
               +" WHERE "+
               it.getIdPDC().getNombre()+" = ?";
        
        return conexion.executeUpdate(sql, vo.getId());
        
       
    }
    
    
    
}
