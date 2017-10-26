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
import modelo.InfoTabla.MaquinaModeloIT;
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
        MaquinaModeloIT mmit = new MaquinaModeloIT();
        String sql = "SELECT "+
                MaquinaIT.NOMBRE_TABLA+"."+it.getID().getNombre()+", "+
                MaquinaIT.NOMBRE_TABLA+"."+it.getID_MAQUINA_MODELO().getNombre()+", "+
                MaquinaIT.NOMBRE_TABLA+"."+it.getNUMERO_DE_MAQUINA().getNombre()+", "+
                MaquinaIT.NOMBRE_TABLA+"."+it.getMATRICULA().getNombre()+", "+
                MaquinaModeloIT.NOMBRE_TABLA+"."+mmit.getMODELO().getNombre()+", "+
                MaquinaModeloIT.NOMBRE_TABLA+"."+mmit.getAnioPDC().getNombre()
                
                +" FROM "+
                MaquinaIT.NOMBRE_TABLA
                +" INNER JOIN " + 
                MaquinaModeloIT.NOMBRE_TABLA
                +" ON "+
                MaquinaIT.NOMBRE_TABLA+"."+it.getID_MAQUINA_MODELO().getNombre() 
                +"="+
                MaquinaModeloIT.NOMBRE_TABLA+"."+mmit.getID().getNombre();
        
        ResultSet r = conexion.executeQuery(sql);
        List<MaquinaVo> listVo = new ArrayList<>();
        try {
            while (r.next()) {
                MaquinaVo vo = new MaquinaVo();
                vo.setId(r.getInt(it.getID().getNombre()));
                vo.setIdMaquinaModelo(
                        r.getObject(mmit.getMODELO().getNombre())+" "+
                        r.getObject(mmit.getAnioPDC().getNombre())
                );
                vo.setNumeroDeMáquina(r.getString(it.getNUMERO_DE_MAQUINA().getNombre()));
                vo.setMatricula(r.getString(it.getMATRICULA().getNombre()));
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
               it.getID().getNombre()+" = ?";
        
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
                it.getNUMERO_DE_MAQUINA().getNombre() +" = ?";
        
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
                it.getID().getNombre()+" <> ?"
                + " AND "+
                it.getNUMERO_DE_MAQUINA().getNombre() +" = ?";
        HashMap<Integer, Object> mapa = new HashMap<>();
        mapa.put(1, vo.getId());
        mapa.put(2, vo.getNumeroDeMáquina());
        ResultSet r;
        r = conexion.executeQuery(sql, mapa);
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
     * Modifica la máquina que se le pase como parametro. 
     * @param vo
     * @return
     */
    public boolean modificar(MaquinaVo vo) {
        conexion = new Conexion(coordinador);
        
        String sql = "UPDATE " + MaquinaIT.NOMBRE_TABLA
                +" SET "+
                it.getNUMERO_DE_MAQUINA().getNombre() + "=?, "+
                it.getID_MAQUINA_MODELO().getNombre() + "=? "
                +" WHERE "+
                it.getID().getNombre() +" =?";
        
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
                +" VALUES (null, ?, ?, ?)";
                
        HashMap<Integer, Object> mapa = new HashMap<>();
        mapa.put(1, vo.getIdMaquinaModelo());
        mapa.put(2, vo.getNumeroDeMáquina());
        mapa.put(3, vo.getMatricula());
        
        return conexion.executeUpdate(sql, mapa);
                
    } 
    
    /**
     * Revisa que la mátricula que se le pase como parametro no este ya registradas.
     * @param vo La máquina con la matricula a revisar.
     * @return True si existe. 
     */
    public boolean existeMatricula(MaquinaVo vo) {
        conexion = new Conexion(coordinador);
        String sql = "SELECT COUNT(*) FROM "+MaquinaIT.NOMBRE_TABLA 
                +" WHERE "+
                it.getMATRICULA().getNombre() +" = ?";
        
        ResultSet r = conexion.executeQuery(sql, vo.getMatricula());
        try {
            r.next();
            return r.getInt(1)>0;
        } catch (SQLException ex) {
            Logger.getLogger(MaquinaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

     /**
     * Retorna true si la matrícula esta repetida para otra máquina exepto para
     * si misma. 
     * @param vo La máquina que se quiere revisar con su matricula.
     * @return True si esta repetida. 
     */
    public boolean repetidoMatricula(MaquinaVo vo) {
        conexion = new Conexion(coordinador);
        try {
            String sql = "SELECT COUNT(*) FROM " + MaquinaIT.NOMBRE_TABLA
                    +" WHERE "+
                    it.getMATRICULA().getNombre() +"<> ?";
            ResultSet r = conexion.executeQuery(sql, vo.getMatricula());
            r.next();
            return r.getInt(1)>0;
        } catch (SQLException ex) {
            Logger.getLogger(MaquinaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
     
    
    
    
}
