/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import controlador.Coordinador;
import java.util.HashMap;
import modelo.Conexion;
import modelo.InfoTabla.MaquinaHistorialNombresIT;
import modelo.vo.MaquinaHistorialNombresVO;

/**
 *
 * @author Particular
 */
public class MaquinaHistorialNombresDao extends DAOGenerales {
    
    MaquinaHistorialNombresIT it = new MaquinaHistorialNombresIT();
    
    public MaquinaHistorialNombresDao(Coordinador coordinador) {
        super(coordinador);
    }

    public boolean guardar(MaquinaHistorialNombresVO mhnVo) {
        conexion = new Conexion(coordinador);
        String sql = "INSERT INTO "+ MaquinaHistorialNombresIT.NOMBRE_TABLA
                        +" VALUES (?,?, NOW())";
        HashMap<Integer, Object> mapa = new HashMap<>();
        mapa.put(1, mhnVo.getIdMaquina());
        mapa.put(2, mhnVo.getNombreAnterior());
        return conexion.executeUpdate(sql, mapa);

    }
    
    
    
}
