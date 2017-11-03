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
import modelo.InfoTabla.SeccionDeMaquinaIT;
import modelo.vo.SeccionDeMaquinaVO;

/**
 *
 * @author Particular
 */
public class SeccionDeMaquinaDAO extends DAOGenerales{
    
    public SeccionDeMaquinaDAO(Coordinador coordinador) {
        super(coordinador);
    }

    /**
     * Consulta todas las secciones existentes.
     * @return Las secciones existentes. 
     */
    public List<SeccionDeMaquinaVO> consultar() {
        conexion = new Conexion(coordinador);
        String sql = "SELECT * FROM "+SeccionDeMaquinaIT.NOMBRE_TABLA;
        List<SeccionDeMaquinaVO> list = new ArrayList<>();
        
        ResultSet r = conexion.executeQuery(sql);
        try {
            while (r.next()) {
                SeccionDeMaquinaVO vo = new SeccionDeMaquinaVO();
                vo.setId(r.getInt(SeccionDeMaquinaIT.getID().getNombre()));
                vo.setNombreSeccion(r.getString(SeccionDeMaquinaIT.getNOMBRE_SECCION().getNombre()));
                list.add(vo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeccionDeMaquinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    /**
     * Guarda una sección de máquina en la BD.
     * @param sdmvo Los datos de la sección que se quieren guardar. 
     * @return True si todo fue correcto. 
     */
    public boolean guardar(SeccionDeMaquinaVO sdmvo) {
        conexion = new Conexion(coordinador);
        String sql = "INSERT INTO " + SeccionDeMaquinaIT.NOMBRE_TABLA +
                " VALUES (null, ?)";
        return conexion.executeUpdate(sql, sdmvo.getNombreSeccion());
    }

    /**
     * Retorna el último id en la tabla de secciones máquinas. 
     * @return El último id de la seccion;
     */
    public int ultimoId() {
        conexion = new Conexion(coordinador);
        String sql = "SELECT MAX("+SeccionDeMaquinaIT.getID().getNombre()+") FROM " 
                +SeccionDeMaquinaIT.NOMBRE_TABLA;
        ResultSet r = conexion.executeQuery(sql);
        try {
            r.next();
            return r.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(SeccionDeMaquinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    /**
     * Valida que el nombre de la sección que se le pase como parametro no este
     * ya registrado exceptuando la comprobación contra la refacción que se 
     * esta actualizando. 
     * @param sdmvo La sección que se quiere revisar que al cambiar el nombre
     * este no pertenezca a otra refacción.
     * @return True si existe. 
     */
    public boolean nombreYaExiste(SeccionDeMaquinaVO sdmvo) {
        return nombreYaExisteORepetido(sdmvo, true);
    }
    
    /**
     * Valida que el nombre de la sección que se le pase como parametro no este
     * repetido. 
     * @param sdmvo La sección que se quiere revisar y que es nueva. 
     * @return True si ya se registro un nombre 
     */
    public boolean nombreRepetido(SeccionDeMaquinaVO sdmvo) {
        return nombreYaExisteORepetido(sdmvo, false);
    }
    
    private boolean nombreYaExisteORepetido(SeccionDeMaquinaVO sdmvo, boolean update) {
        conexion = new Conexion(coordinador);
        
        String sql = "SELECT COUNT(*) FROM "+SeccionDeMaquinaIT.NOMBRE_TABLA
                +" WHERE "+
                SeccionDeMaquinaIT.NOMBRE_TABLA+"."
                +SeccionDeMaquinaIT.getNOMBRE_SECCION().getNombre();
        ResultSet r;
        if (update) {
            
            sql+=" = ? AND " + SeccionDeMaquinaIT.getID().getNombre() + " <> ?";
            HashMap<Integer, Object> mapa = new HashMap<>();
            mapa.put(1, sdmvo.getNombreSeccion());
            mapa.put(2, sdmvo.getId());
            r = conexion.executeQuery(sql, mapa);
            
        }else{
            sql+=" = ?";
            r = conexion.executeQuery(sql, sdmvo.getNombreSeccion());
        }
        
        boolean a = false;
        try {
            r.next();
            a = r.getInt(1)>0;
        } catch (SQLException ex) {
            Logger.getLogger(SeccionDeMaquinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
    
    /**
     * Actualiza una seccion de máquina. 
     * @param vo La sección que se quiere modificar. 
     * @return True si se modifico correctamente. 
     */
    public boolean update(SeccionDeMaquinaVO vo) {
        conexion = new Conexion(coordinador);
        String sql = "UPDATE " + SeccionDeMaquinaIT.NOMBRE_TABLA
                +" SET "+
                SeccionDeMaquinaIT.getNOMBRE_SECCION().getNombre()
                +" = ? WHERE "+
                SeccionDeMaquinaIT.getID().getNombre()
                +" = ?";
        HashMap<Integer, Object> mapa = new HashMap<>();
        mapa.put(1, vo.getNombreSeccion());
        mapa.put(2, vo.getId());
        
        return conexion.executeUpdate(sql, mapa);
    }

    public boolean eliminar(SeccionDeMaquinaVO vo) {
        conexion = new Conexion(coordinador);
        String sql = "DELETE FROM " +SeccionDeMaquinaIT.NOMBRE_TABLA
                +" WHERE "+ SeccionDeMaquinaIT.getID().getNombre() +"=?";
        
        return conexion.executeUpdate(sql, vo.getId());

    }
}
