package modelo.dao;

import controlador.Coordinador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.InfoTabla.MaquinaModeloIT;
import modelo.InfoTabla.ProveedorIT;
import modelo.vo.MaquinaModeloVo;

/**
 *
 * @author Particular
 */
public class MaquinaModeloDao extends DAOGenerales{
    
    private final MaquinaModeloIT it;
    
    public MaquinaModeloDao(Coordinador coordinador) {
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
        conexion = new Conexion(coordinador);
        try {
            String sql = "SELECT COUNT(*) FROM " +MaquinaModeloIT.NOMBRE_TABLA
                    +" WHERE "+it.getMODELO().getNombre()+"=? AND "
                    + it.getAnioPDC().getNombre() +"=?";
            HashMap<Integer, Object > datos= new HashMap<>();
            datos.put(1, modelo);
            datos.put(2, ""+anio);
            ResultSet r = conexion.executeQuery(sql, datos);
            r.next();
            int a = r.getInt(1);
            if (a>0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaquinaModeloDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    /**
     * Revisa si el modelo-año de la máquina existe en la base de datos descartando el
     * id que se le pase. 
     * @param vo Modelo, año y id que se quieren filtrar.
     * @return True si hay coincidencias. 
     */
    public boolean existe(MaquinaModeloVo vo){
        conexion = new Conexion(coordinador);
        try {
            String sql = "SELECT COUNT(*) FROM " +MaquinaModeloIT.NOMBRE_TABLA
                    +" WHERE "+
                    it.getMODELO().getNombre()+"=? "
                    + " AND "+
                    it.getAnioPDC().getNombre() +"=?"
                    + " AND "+
                    it.getID().getNombre()+"<>?";
            
            HashMap<Integer, Object > datos= new HashMap<>();
            datos.put(1, vo.getModelo());
            datos.put(2, vo.getAnio());
            datos.put(3, vo.getId());
            
            ResultSet r = conexion.executeQuery(sql, datos);
            r.next();
            int a = r.getInt(1);
            if (a>0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaquinaModeloDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean guardar(MaquinaModeloVo vo){
        conexion = new Conexion(coordinador);
        String sql = "INSERT INTO " + MaquinaModeloIT.NOMBRE_TABLA 
                +" VALUES (null, ?, ? , ?)";
        
        HashMap<Integer, Object> d = new HashMap<>();
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
        conexion = new Conexion(coordinador);
        String sql = "SELECT * FROM " +MaquinaModeloIT.NOMBRE_TABLA 
                + " ORDER BY " + it.getMODELO().getNombre() + " ASC" ;
        List<MaquinaModeloVo> lista = new ArrayList<>();
        try {
            
            ResultSet r = conexion.executeQuery(sql);
            while (r.next()) {
                 
                MaquinaModeloVo vo = new MaquinaModeloVo();
                vo.setIdProveedor(r.getInt(it.getID_PROVEEDOR().getNombre()));
                vo.setModelo(r.getString(it.getMODELO().getNombre()));        
                vo.setAnio(r.getInt(it.getAnioPDC().getNombre()));
                vo.setId(r.getInt(it.getID().getNombre()));
                lista.add(vo);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(MaquinaModeloDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    /**
     * Retorna la maquina modelo que coicida con el id que se le pase como parametro.
     * @param id El íd a consultar. 
     * @return El objeto MaquinaModelo coincidente. 
     */
    public MaquinaModeloVo consultar (int id){
        conexion = new Conexion(coordinador);
        MaquinaModeloVo vo = new MaquinaModeloVo();
        ProveedorIT pit = new ProveedorIT();
        try {
            String sql = "SELECT "
                    + MaquinaModeloIT.NOMBRE_TABLA+"."+it.getID().getNombre() +", "
                    + MaquinaModeloIT.NOMBRE_TABLA+"."+it.getAnioPDC().getNombre() +", "
                    + MaquinaModeloIT.NOMBRE_TABLA+"."+it.getMODELO().getNombre() +", "
                    + ProveedorIT.NOMBRE_TABLA+"."+pit.getEMPRESA_PROVEEDOR().getNombre() 
                    + " FROM " + MaquinaModeloIT.NOMBRE_TABLA
                    + " INNER JOIN " + ProveedorIT.NOMBRE_TABLA 
                    + " ON " +
                    ProveedorIT.NOMBRE_TABLA+"."+pit.getID().getNombre()
                    + "=" +
                    MaquinaModeloIT.NOMBRE_TABLA+"."+it.getID_PROVEEDOR().getNombre()
                    + " WHERE " + MaquinaModeloIT.NOMBRE_TABLA+"."+it.getID().getNombre() + "=?";
            
            ResultSet r = conexion.executeQuery(sql, id+"");
            r.next();
            vo.setIdProveedor(r.getString(pit.getEMPRESA_PROVEEDOR().getNombre()));
            vo.setModelo(r.getString(it.getMODELO().getNombre()));
            vo.setAnio(r.getInt(it.getAnioPDC().getNombre()));
            vo.setId(r.getInt(it.getID().getNombre()));
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MaquinaModeloDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vo;
    }
    
    public boolean eliminar(MaquinaModeloVo vo){
        conexion = new Conexion(coordinador);
        String sql = "DELETE FROM " + MaquinaModeloIT.NOMBRE_TABLA 
                + " WHERE " +
                it.getID().getNombre() +" = ?";
        return conexion.executeUpdate(sql, vo.getId()+"");
    }
    
    public boolean modificar(MaquinaModeloVo vo){
        conexion = new Conexion(coordinador);

        String sql = "UPDATE " + MaquinaModeloIT.NOMBRE_TABLA 
                +" SET " +
                it.getMODELO().getNombre() + " = ?,"+
                it.getAnioPDC().getNombre() + " = ?,"+
                it.getID_PROVEEDOR().getNombre() + " = ?"
                +" WHERE " + it.getID().getNombre() +"=?";
                
        HashMap<Integer, Object> mapa = new HashMap<>();
        mapa.put(1, vo.getModelo());
        mapa.put(2, vo.getAnio()+"");
        mapa.put(3, vo.getIdProveedor()+"");
        mapa.put(4, vo.getId()+"");
        
        
        return conexion.executeUpdate(sql, mapa);
    }
    
}