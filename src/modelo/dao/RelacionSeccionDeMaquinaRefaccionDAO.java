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
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.InfoTabla.RefaccionIT;
import modelo.InfoTabla.RelacionSeccionDeMaquinaRefaccionIT;
import modelo.vo.RefaccionVo;
import modelo.vo.RelacionSeccionDeMaquinaRefaccionVO;
import modelo.vo.SeccionDeMaquinaVO;

/**
 *
 * @author Particular
 */
public class RelacionSeccionDeMaquinaRefaccionDAO extends DAOGenerales{
    
    public RelacionSeccionDeMaquinaRefaccionDAO(Coordinador coordinador) {
        super(coordinador);
    }

     /**
     * Guarda la relacion que hay entre la sección de la máquina y la refacción.
     * @param listRelacion Lista de refacciones relacionadas.
     * @return True si todo fue bien. 
     */
    public boolean guardarRelacion(List<RelacionSeccionDeMaquinaRefaccionVO> listRelacion) {
        conexion = new Conexion(coordinador);
        String sql = "INSERT INTO "+ RelacionSeccionDeMaquinaRefaccionIT.NOMBRE_TABLA 
                +" VALUES ";
        int contador= 1;
        HashMap<Integer, Object> mapa = new HashMap<>();
        for (Iterator<RelacionSeccionDeMaquinaRefaccionVO> i = 
                listRelacion.iterator(); i.hasNext();) {
            RelacionSeccionDeMaquinaRefaccionVO next = i.next();
            if (i.hasNext()) {
                sql += "(?,?),";
            }else{
                sql += "(?,?)";
            }
            mapa.put(contador, next.getIdRefaccion());
            mapa.put(contador+1, next.getIdSeccionMaquina());
            contador+=2;
        }
        
        return conexion.executeUpdate(sql, mapa);
    }

    /**
     * Consulta todas las refacciones que esten relacionadas con el id de seccion
     * que se le pase como parametro. 
     * @param idActual
     * @return La lista de refacciones compatibles con la sección.
     */
    public List<RefaccionVo> consultarRefacciones(SeccionDeMaquinaVO idActual) {
        conexion = new Conexion(coordinador);
        List<RefaccionVo>listRVO = new ArrayList<>();
        String sql = "SELECT "+
                RefaccionIT.NOMBRE_TABLA+"."+RefaccionIT.getID().getNombre()+" ,"+
                RefaccionIT.NOMBRE_TABLA+"."+RefaccionIT.getNOMBRE().getNombre()+" ,"+
                RefaccionIT.NOMBRE_TABLA+"."+RefaccionIT.getCODIGO_INTERNO().getNombre()+" ,"+
                RefaccionIT.NOMBRE_TABLA+"."+RefaccionIT.getCODIGO_PROVEEDOR().getNombre()
                +" FROM " +RelacionSeccionDeMaquinaRefaccionIT.NOMBRE_TABLA
                +" JOIN "+
                    RefaccionIT.NOMBRE_TABLA
                    +" ON "+
                    RefaccionIT.NOMBRE_TABLA+"."+RefaccionIT.getID().getNombre()
                    +" = "+
                    RelacionSeccionDeMaquinaRefaccionIT.NOMBRE_TABLA+"."+RelacionSeccionDeMaquinaRefaccionIT.getID_REFACCION().getNombre()
                    
                +" WHERE "+
                    RelacionSeccionDeMaquinaRefaccionIT.getID_SECCION_MAQUINA().getNombre() +" = ? ";
        
        ResultSet r = conexion.executeQuery(sql, idActual.getId());
        try {
            while (r.next()) {
                RefaccionVo vo = new RefaccionVo();
                vo.setId(r.getInt(RefaccionIT.getID().getNombre()));
                vo.setNombre(r.getString(RefaccionIT.getNOMBRE().getNombre()));
                vo.setCodigoInterno(r.getString(RefaccionIT.getCODIGO_INTERNO().getNombre()));
                vo.setCodigoProveedor(r.getString(RefaccionIT.getCODIGO_PROVEEDOR().getNombre()));
                listRVO.add(vo);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(RelacionSeccionDeMaquinaRefaccionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRVO;
    }
    
    /**
     * Actualiza la relación entre una sección de máquina y las refacciones que 
     * se le pasen como paramtro. Para esto elimina toda las relaciones y luego las crea de nuevo.
     * @param listRelacion Las nuevas relaciónes que se sustituiran a las anteriores. 
     * @return True si se modifico correctamente. 
     */
    public boolean actualizar(List<RelacionSeccionDeMaquinaRefaccionVO> listRelacion) {
        if (eliminarRelacionConSeccionDeMaquina((int)listRelacion.get(0).getIdRefaccion())) {
            return guardarRelacion(listRelacion);
        }
        return false;
    }
    
    public boolean eliminarRelacionConSeccionDeMaquina(int idSeccion){
        conexion = new Conexion(coordinador);
        String sql = " DELETE FROM " +
                        RelacionSeccionDeMaquinaRefaccionIT.NOMBRE_TABLA
                        +" WHERE "+
                        RelacionSeccionDeMaquinaRefaccionIT.getID_SECCION_MAQUINA().getNombre()+" = ? ;";
        return conexion.executeUpdate(sql, idSeccion);
        
        
    }
}
