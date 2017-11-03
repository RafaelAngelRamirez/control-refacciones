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
}
