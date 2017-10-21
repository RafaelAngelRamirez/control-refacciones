/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import controlador.Coordinador;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import modelo.Conexion;
import modelo.InfoTabla.RelacionSeccionMaqRefaccionIT;
import modelo.vo.RelacionSeccionMaqRefaccionVO;

/**
 *
 * @author Particular
 */
public class RelaccionSeccionDeMaquinaRefaccionDAO extends DAOGenerales{
    
    public RelaccionSeccionDeMaquinaRefaccionDAO(Coordinador coordinador) {
        super(coordinador);
    }

     /**
     * Guarda la relacion que hay entre la sección de la máquina y la refacción.
     * @param listRelacion Lista de refacciones relacionadas.
     * @return True si todo fue bien. 
     */
    public boolean guardarRelacion(List<RelacionSeccionMaqRefaccionVO> listRelacion) {
        conexion = new Conexion(coordinador);
        String sql = "INSERT INTO "+ RelacionSeccionMaqRefaccionIT.NOMBRE_TABLA;
        String s = " VALUES ";
        int contador= 1;
        HashMap<Integer, Object> mapa = new HashMap<>();
        for (Iterator<RelacionSeccionMaqRefaccionVO> i = listRelacion.iterator(); i.hasNext();) {
            RelacionSeccionMaqRefaccionVO next = i.next();
            if (i.hasNext()) {
                s += "(?,?),";
            }else{
                s += "(?,?)";
            }
            mapa.put(contador, next.getIdRefaccion());
            mapa.put(contador+1, next.getIdSeccionMaquina());
            contador+=2;
        }
        
        return conexion.executeUpdate(sql, mapa);
    }

    
}
