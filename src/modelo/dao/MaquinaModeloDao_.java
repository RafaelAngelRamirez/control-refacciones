package modelo.dao;

import controlador.Coordinador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.InfoTabla.MaquinaModeloIT;
import modelo.InfoTabla.ProveedorIT;
import modelo.vo.MaquinaModeloVo;

/**
 *
 * @author Particular
 */
public class MaquinaModeloDao_ extends DAOGenerales_{
    
    private final MaquinaModeloIT it;
    
    public MaquinaModeloDao_(Coordinador coordinador) {
        super(coordinador);
        this.it = new MaquinaModeloIT();
    }
    
    /**
     * Revisa si el modelo de la máquina existe en la base de datos. 
     * @param modelo - El modelo de la máquina. 
     * @param anio - El año de la maquina.
     * @return Si existe la combinacion retorn true. 
     */
    public boolean existe(String modelo, int anio){
        try {
            String sql = "SELECT COUNT(*) FROM " +MaquinaModeloIT.NOMBRE_TABLA
                    +" WHERE "+it.getModeloPDC().getNombre()+"=? AND "
                    + it.getAnioPDC().getNombre() +"=?";
            HashMap<Integer, String > datos= new HashMap<>();
            datos.put(1, modelo);
            datos.put(2, ""+anio);
            ResultSet r = conexion.executeQuery(sql, datos);
            r.next();
            int a = r.getInt(1);
            if (a>0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaquinaModeloDao_.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean guardar(MaquinaModeloVo vo){
        String sql = "INSERT INTO " + MaquinaModeloIT.NOMBRE_TABLA 
                +" VALUES (null, ?, ? , ?)";
        
        HashMap<Integer, String> d = new HashMap<>();
        d.put(1, vo.getModelo());
        d.put(2, vo.getAnio()+"");
        d.put(3, vo.getIdProveedor()+"");
        
       return conexion.executeUpdate(sql, d);
        
    }
    
    /**
     * Consulta todos los modelos.
     * @return Retorna todas las máquinas-modelo.
     */
    public List<MaquinaModeloVo> consultar(){
        String sql = "SELECT * FROM " +MaquinaModeloIT.NOMBRE_TABLA;
        List<MaquinaModeloVo> lista = new ArrayList<>();
        try {
            
            ResultSet r = conexion.executeQuery(sql);
            while (r.next()) {
                 
                MaquinaModeloVo vo = new MaquinaModeloVo();
                vo.setIdProveedor(r.getInt(it.getIdProoveedorPDC().getNombre()));
                vo.setModelo(r.getString(it.getModeloPDC().getNombre()));        
                vo.setAnio(r.getInt(it.getAnioPDC().getNombre()));
                vo.setId(r.getInt(it.getIdPDC().getNombre()));
                lista.add(vo);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(MaquinaModeloDao_.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    /**
     * Retorna la maquina modelo que coicida con el id que se le pase como parametro.
     * @param id El íd a consultar. 
     * @return El objeto MaquinaModelo coincidente. 
     */
    public MaquinaModeloVo consultar (int id){
        MaquinaModeloVo vo = new MaquinaModeloVo();
        ProveedorIT pit = new ProveedorIT();
        try {
            String sql = "SELECT "
                    + MaquinaModeloIT.NOMBRE_TABLA+"."+it.getIdPDC().getNombre() +", "
                    + MaquinaModeloIT.NOMBRE_TABLA+"."+it.getAnioPDC().getNombre() +", "
                    + MaquinaModeloIT.NOMBRE_TABLA+"."+it.getModeloPDC().getNombre() +", "
                    + ProveedorIT.NOMBRE_TABLA+"."+pit.getEmpresaProveedorPDC().getNombre() 
                    + " FROM " + MaquinaModeloIT.NOMBRE_TABLA
                    + " INNER JOIN " + ProveedorIT.NOMBRE_TABLA 
                    + " ON " +
                    ProveedorIT.NOMBRE_TABLA+"."+pit.getIdPDC().getNombre()
                    + "=" +
                    MaquinaModeloIT.NOMBRE_TABLA+"."+it.getIdProoveedorPDC().getNombre()
                    + " WHERE " + MaquinaModeloIT.NOMBRE_TABLA+"."+it.getIdPDC().getNombre() + "=?";
            
            ResultSet r = conexion.executeQuery(sql, id+"");
            r.next();
            vo.setIdProveedor(r.getString(pit.getEmpresaProveedorPDC().getNombre()));
            vo.setModelo(r.getString(it.getModeloPDC().getNombre()));
            vo.setAnio(r.getInt(it.getAnioPDC().getNombre()));
            vo.setId(r.getInt(it.getIdPDC().getNombre()));
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MaquinaModeloDao_.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vo;
    }
    
}