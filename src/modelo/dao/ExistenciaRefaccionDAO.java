/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import controlador.Coordinador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.InfoTabla.ExistenciaRefaccionIT;

/**
 *
 * @author Particular
 */
public class ExistenciaRefaccionDAO extends DAOGenerales{

    public ExistenciaRefaccionDAO(Coordinador coordinador) {
        super(coordinador);
    }

    public float existencia(int id) {
        try {
            conexion = new Conexion(coordinador);
            String sql = "SELECT " + ExistenciaRefaccionIT.getEXISTENCIA().getNombre()
                    + " FROM " + ExistenciaRefaccionIT.NOMBRE_TABLA
                    + " WHERE  " + ExistenciaRefaccionIT.getID_REFACCION().getNombre() +" = ?";
            
            ResultSet r = conexion.executeQuery(sql, id);
            r.next();
            return r.getFloat(ExistenciaRefaccionIT.getEXISTENCIA().getNombre());
        } catch (SQLException ex) {
            Logger.getLogger(ExistenciaRefaccionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return -1;
    }
    
}
