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
import java.util.HashMap;
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
    
     /**
     * Elimina la máquina seleccionada y todo lo que este relacionada con ella. 
     * @param vo La máquina que se quiere eliminar. 
     * @return True si se elimino correctamente. 
     */
    public boolean eliminar(MaquinaVo vo) {
        conexion = new Conexion(coordinador);
        String sql = "DELETE FROM " + MaquinaIT.NOMBRE_TABLA 
               +" WHERE "+
               it.getIdPDC().getNombre()+" = ?";
        
        return conexion.executeUpdate(sql, vo.getId());
    }

    /**
     * Comprueba si la refacción existe. A diferencia de {@see maquinaRepetido}
     * esta comprueba solo si la refacción que se le pase existe más de una vez
     * incluida la misma que se le pase.
     * 
     * Sirve para comprobar si se modifica la máquina o se agrega una nueva. 
     * 
     * @param vo La refacción que se comprobara si esta repetida. 
     * @return True si esta repetida. 
     */
    public boolean existe(MaquinaVo vo) {
        conexion = new Conexion(coordinador);
        String sql = "SELECT COUNT(*) FROM " + MaquinaIT.NOMBRE_TABLA
                +" WHERE "+
                it.getNumeroDeMaquinaPDC().getNombre() +" = ?";
        
        ResultSet r = conexion.executeQuery(sql, vo.getNumeroDeMáquina());
        try {
            r.next();
            if (r.getInt(1)>0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaquinaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
     /**
     * Revisa que la máquina no este repetida sin incluirse a ella misma. 
     * @param vo La máquina que se quiere comparar.
     * @return True si existe repetido. 
     */
    public boolean repetido(MaquinaVo vo) {
        conexion = new Conexion(coordinador);
        String sql = "SELECT COUNT(*) FROM " + MaquinaIT.NOMBRE_TABLA
                + " WHERE "+
                it.getIdPDC().getNombre()+" <> ?";
        return conexion.executeUpdate(sql, vo.getId());
    }

    /**
     * Modifica la máquina que se le pase como parametro. 
     * @param vo
     * @return
     */
    public boolean modificar(MaquinaVo vo) {
        conexion = new Conexion(coordinador);
        
        String sql = "UPDATE " + MaquinaIT.NOMBRE_TABLA
                +" SET "+
                it.getNumeroDeMaquinaPDC().getNombre() + "=?"+
                it.getIdMaquinaModeloPDC().getNombre() + "=?"
                +" WHERE "+
                it.getIdPDC().getNombre() +" =?";
        
        HashMap<Integer, Object> mapa = new HashMap<>();
        mapa.put(1, vo.getNumeroDeMáquina());
        mapa.put(2, vo.getIdMaquinaModelo());
        mapa.put(3, vo.getId());
        
        return conexion.executeUpdate(sql, mapa);
    }

    /**
     * Guarda la máquina que se le pase como parametro. 
     * @param vo
     * @return
     */
    public boolean guardar(MaquinaVo vo) {
        conexion = new Conexion(coordinador);
        String sql = "INSERT INTO " + MaquinaIT.NOMBRE_TABLA 
                +" VALUES (null, ?, ?)";
                
        HashMap<Integer, Object> mapa = new HashMap<>();
        mapa.put(1, vo.getIdMaquinaModelo());
        mapa.put(2, vo.getNumeroDeMáquina());
        
        return conexion.executeUpdate(sql, mapa);
                
    }   
    
    
    
}
