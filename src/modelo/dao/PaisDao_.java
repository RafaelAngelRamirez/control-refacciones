package modelo.dao;

import controlador.Coordinador;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.ExcepcionPersonalizada;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.InfoTabla.PaisIT;
import modelo.Conexion;
import modelo.vo.*;

/**
 *
 * @author Particular
 */
public class PaisDao_ extends DAOGenerales_{

    Conexion conexion = new Conexion(coordinador);
    PaisIT it;
            

    public PaisDao_(Coordinador coordinador) {
        super(coordinador);
        this.it = new PaisIT();
        
    }    


    public void guardar(PaisVo vo) {
        HashMap<Integer, String> datos = new HashMap<>();
        
        datos.put(1, vo.getId()+"");
        datos.put(2, vo.getPais());
        
        String sql = "INSERT INTO " + PaisIT.NOMBRE_TABLA +" VALUES(?, ?)";
        Conexion con = new Conexion(coordinador);
        con.executeUpdate(sql, datos);
        
    }
    
    public List<PaisVo> consultar(){
        List<PaisVo> lista = new ArrayList<>();
        try {
            Conexion con = new Conexion(coordinador);
            
            String sql = "SELECT * FROM " + PaisIT.NOMBRE_TABLA;
            ResultSet resultado = con.executeQuery(sql);
            
            while(resultado.next()){
                PaisVo a = new PaisVo();
                a.setPais(resultado.getString(it.getPaisPDC().getNombre()));
                a.setId(resultado.getInt(it.getIdPDC().getNombre()));
                lista.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaisDao_.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
        
    }
    
    public boolean existe (String pais){
        try {
            Conexion con = new Conexion(coordinador);
            String sql = "SELECT COUNT(*) FROM "+PaisIT.NOMBRE_TABLA+" "
                    + "where "+it.getPaisPDC().getNombre()+"=?";
            ResultSet r = con.executeQuery(sql, pais);
            
            r.next();
            int a = r.getInt(1);
            if (a>0) {
                return true;
            }
            return false;
            
        } catch (SQLException ex) {
            Logger.getLogger(PaisDao_.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }



}