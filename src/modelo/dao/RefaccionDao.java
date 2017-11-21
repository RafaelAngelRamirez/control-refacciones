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
import modelo.InfoTabla.ImportanciaIT;
import modelo.InfoTabla.MaterialIT;
import modelo.InfoTabla.RefaccionIT;
import modelo.InfoTabla.UnidadIT;
import modelo.Textos;
import modelo.vo.RefaccionVo;

/**
 *
 * @author Particular
 */
public class RefaccionDao extends DAOGenerales{
    
    RefaccionIT it;
    public RefaccionDao(Coordinador coordinador) {
        super(coordinador);
        this.it = new RefaccionIT();
    }
    
    public boolean existeCodigoInterno(String codigo){
        conexion = new Conexion(coordinador);
        try {
            String sql = "SELECT COUNT(*) FROM " + RefaccionIT.NOMBRE_TABLA
                    + " WHERE " +  it.getCODIGO_INTERNO().getNombre() + "= ?";
            ResultSet r = conexion.executeQuery(sql, codigo);
            r.next();
            int a = r.getInt(1);
            if (a>0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RefaccionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return false;
    }
    
    public boolean existeCodigoInterno(RefaccionVo vo){
        conexion = new Conexion(coordinador);
        try {
            String sql = "SELECT COUNT(*) FROM " + RefaccionIT.NOMBRE_TABLA
                    + " WHERE " +  it.getCODIGO_INTERNO().getNombre() + "= ?"
                    + " AND " + it.getID().getNombre() + "!= ?";
            HashMap<Integer, Object> mapa = new HashMap<>();
            mapa.put(1, vo.getCodigoInterno());
            mapa.put(2, vo.getId()+"");
            
            
            
            ResultSet r = conexion.executeQuery(sql, mapa);
            r.next();
            int a = r.getInt(1);
            if (a>0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RefaccionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public int consultarUltimoId(){
        conexion = new Conexion(coordinador);
        String sql = "SELECT MAX("+it.getID().getNombre()+") FROM "+RefaccionIT.NOMBRE_TABLA;
        ResultSet r = conexion.executeQuery(sql);
        try {
            r.next();
            return r.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(RefaccionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    /**
     * Si todas las operaciones se ejecutaron correctamente devuelve true.  
     * @param vo los datos de la refacción que se quiere guardar.
     * @return Si todo se guardo correcto retorna true.
     */
    public boolean guardar(RefaccionVo vo){
        conexion = new Conexion(coordinador);
        String sql = "INSERT INTO "+ RefaccionIT.NOMBRE_TABLA 
                + " VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        HashMap<Integer, Object> mapa = new HashMap<>();
        
        mapa.put(1, vo.getNombre());
        mapa.put(2, vo.getIdMaterial());
        mapa.put(3, vo.getImportancia());
        mapa.put(4, vo.getStockMinimo());
        mapa.put(5, vo.getStockMaximo());
        mapa.put(6, vo.getUnidad());
        mapa.put(7, vo.getCodigoInterno());
        mapa.put(8, vo.getCodigoProveedor());
        mapa.put(9, vo.getDescripcion());
        mapa.put(10, vo.getQueEs());
        mapa.put(11, vo.getParaQueEs());
        mapa.put(12, vo.getRefaccionDeConsumoUnico());
        
        return conexion.executeUpdate(sql, mapa);
        
    }
    
    public List<RefaccionVo> consultarYBuscar(String busqueda){
        conexion = new Conexion(coordinador);
        
        List<RefaccionVo> listaVo = new ArrayList<>();
        busqueda = Textos.especialREGEX(busqueda);
       
        try {
            ImportanciaIT iit = new ImportanciaIT();
            UnidadIT uit = new UnidadIT();
            String sql =
                    "SELECT "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getID().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getCODIGO_INTERNO().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getCODIGO_PROVEEDOR().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getNOMBRE().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getDESCRIPCION().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getSTOCK_MINIMO().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getSTOCK_MAXIMO().getNombre() + ", "
                    + UnidadIT.NOMBRE_TABLA +"."+uit.getUNIDAD().getNombre() + ", "
                    + ImportanciaIT.NOMBRE_TABLA +"."+iit.getIMPORTANCIA().getNombre() + 
                    " FROM " + RefaccionIT.NOMBRE_TABLA +
                    
                    " INNER JOIN " + ImportanciaIT.NOMBRE_TABLA +
                    " ON " + 
                    ImportanciaIT.NOMBRE_TABLA +"."+ iit.getID().getNombre() 
                    + " = " + 
                    RefaccionIT.NOMBRE_TABLA+"."+it.getIMPORTANCIA().getNombre() +
                    " INNER JOIN " + UnidadIT.NOMBRE_TABLA +
                    " ON " + 
                    UnidadIT.NOMBRE_TABLA +"."+ uit.getID().getNombre() 
                    + " = " + 
                    RefaccionIT.NOMBRE_TABLA+"."+it.getUNIDAD().getNombre() 
                    ;
            
            String regexp = " REGEXP '.*"+busqueda+"|"+busqueda+".*' ";
           
            String sqlBusqueda = 
                    " WHERE " +
                    it.getNOMBRE().getNombre() + regexp
                    + " OR " + 
                    it.getCODIGO_INTERNO().getNombre() + regexp
                    + " OR " + 
                    it.getCODIGO_PROVEEDOR().getNombre() + regexp
                    + " OR " + 
                    it.getDESCRIPCION().getNombre() + regexp
                    + " OR " + 
                    ImportanciaIT.NOMBRE_TABLA+"."+iit.getIMPORTANCIA().getNombre() + regexp;
            
            if (!busqueda.isEmpty()) {
                sql += sqlBusqueda;
            }
            
            sql += "LIMIT 20";
            
            
            
                    
            
            ResultSet r = conexion.executeQuery(sql);
            while (r.next()) {
                RefaccionVo v = new RefaccionVo();
                v.setId(r.getInt(it.getID().getNombre()));
                v.setCodigoInterno(r.getString(it.getCODIGO_INTERNO().getNombre()));
                v.setCodigoProveedor(r.getString(it.getCODIGO_PROVEEDOR().getNombre()));
                v.setNombre(r.getString(it.getNOMBRE().getNombre()));
                v.setDescripcion(r.getString(it.getDESCRIPCION().getNombre()));
                v.setImportancia(r.getString(iit.getIMPORTANCIA().getNombre()));
                v.setStockMaximo(r.getDouble(it.getSTOCK_MAXIMO().getNombre()));
                v.setStockMinimo(r.getDouble(it.getSTOCK_MINIMO().getNombre()));
                v.setUnidad(r.getString(uit.getUNIDAD().getNombre()));
                
                listaVo.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RefaccionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVo;
    }
    
    public List<RefaccionVo> consultarYBuscar(){
        return consultarYBuscar("");
    
    }
    
    public RefaccionVo consultarPorId(int id){
        conexion = new Conexion(coordinador);
        RefaccionVo v = new RefaccionVo();
        try {
            ImportanciaIT iit = new ImportanciaIT();
            UnidadIT uit = new UnidadIT();
            MaterialIT mit = new MaterialIT();
            String sql =
                    "SELECT "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getID().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getNOMBRE().getNombre() + ", "
                    + MaterialIT.NOMBRE_TABLA +"."+mit.getMATERIAL().getNombre() + ", "
                    + ImportanciaIT.NOMBRE_TABLA +"."+iit.getIMPORTANCIA().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getSTOCK_MINIMO().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getSTOCK_MAXIMO().getNombre() + ", "
                    + UnidadIT.NOMBRE_TABLA +"."+uit.getUNIDAD().getNombre() + ", " 
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getCODIGO_INTERNO().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getCODIGO_PROVEEDOR().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getDESCRIPCION().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getQUE_ES().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getREFACCION_DE_CONSUMO_UNICO().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getPARA_QUE_ES().getNombre() 
                    +
                    " FROM " + RefaccionIT.NOMBRE_TABLA 
                    +
                    " INNER JOIN " + ImportanciaIT.NOMBRE_TABLA +
                    " ON " + 
                    ImportanciaIT.NOMBRE_TABLA +"."+ iit.getID().getNombre() 
                    + " = " + 
                    RefaccionIT.NOMBRE_TABLA+"."+it.getIMPORTANCIA().getNombre() +
                    
                    " INNER JOIN " + MaterialIT.NOMBRE_TABLA +
                    " ON " + 
                    MaterialIT.NOMBRE_TABLA +"."+ mit.getID().getNombre() 
                    + " = " + 
                    RefaccionIT.NOMBRE_TABLA+"."+it.getID_MATERIAL().getNombre() +
                    
                    " INNER JOIN " + UnidadIT.NOMBRE_TABLA +
                    " ON " + 
                    UnidadIT.NOMBRE_TABLA +"."+ uit.getID().getNombre() 
                    + " = " + 
                    RefaccionIT.NOMBRE_TABLA+"."+it.getUNIDAD().getNombre() +
                    
                    " WHERE " + RefaccionIT.NOMBRE_TABLA+"."+it.getID().getNombre() +" = ?" ;
            
            
            ResultSet r = conexion.executeQuery(sql, id+"");
            r.next();
            v.setId(r.getInt(it.getID().getNombre()));
            v.setCodigoInterno(r.getString(it.getCODIGO_INTERNO().getNombre()));
            v.setCodigoProveedor(r.getString(it.getCODIGO_PROVEEDOR().getNombre()));
            v.setNombre(r.getString(it.getNOMBRE().getNombre()));
            v.setDescripcion(r.getString(it.getDESCRIPCION().getNombre()));
            v.setImportancia(r.getString(iit.getIMPORTANCIA().getNombre()));
            v.setStockMaximo(r.getDouble(it.getSTOCK_MAXIMO().getNombre()));
            v.setStockMinimo(r.getDouble(it.getSTOCK_MINIMO().getNombre()));
            v.setUnidad(r.getString(uit.getUNIDAD().getNombre()));
            v.setParaQueEs(r.getString(it.getPARA_QUE_ES().getNombre()));
            v.setQueEs(r.getString(it.getQUE_ES().getNombre()));
            v.setRefaccionDeConsumoUnico(r.getByte(it.getREFACCION_DE_CONSUMO_UNICO().getNombre()));
            v.setIdMaterial(r.getString(mit.getMATERIAL().getNombre()));
            
                
        } catch (SQLException ex) {
            Logger.getLogger(RefaccionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
        
    }
    
    public boolean modificar(RefaccionVo vo){
        conexion = new Conexion(coordinador);
        String sql = 
            "UPDATE " + RefaccionIT.NOMBRE_TABLA 
            + " SET " +
                it.getNOMBRE().getNombre()+ "= ? , " +
                it.getID_MATERIAL().getNombre()+ "= ? , " +
                it.getIMPORTANCIA().getNombre()+ "= ? , " +
                it.getSTOCK_MINIMO().getNombre()+ "= ? , " +
                it.getSTOCK_MAXIMO().getNombre()+ "= ? , " +
                it.getUNIDAD().getNombre()+ "= ? , " +
                it.getCODIGO_INTERNO().getNombre()+ "= ? , " +
                it.getCODIGO_PROVEEDOR().getNombre()+ "= ? , " +
                it.getDESCRIPCION().getNombre()+ "= ? , " +
                it.getQUE_ES().getNombre()+ "= ? , " +
                it.getPARA_QUE_ES().getNombre()+ "= ? ,   " +
                it.getREFACCION_DE_CONSUMO_UNICO().getNombre()+ "= ?  " 
            + " WHERE " + it.getID().getNombre() + "= ?";
        
        HashMap<Integer, Object> mapa = new HashMap<>();
        mapa.put(1, vo.getNombre());
        mapa.put(2, (int)vo.getIdMaterial());
        mapa.put(3, (int)vo.getImportancia());
        mapa.put(4, vo.getStockMinimo());
        mapa.put(5, vo.getStockMaximo());
        mapa.put(6, (int)vo.getUnidad());
        mapa.put(7, vo.getCodigoInterno());
        mapa.put(8, vo.getCodigoProveedor());
        mapa.put(9, vo.getDescripcion());
        mapa.put(10, vo.getQueEs());
        mapa.put(11, vo.getParaQueEs());
        mapa.put(12, vo.getRefaccionDeConsumoUnico());
        
        mapa.put(13, vo.getId());
        
        return conexion.executeUpdate(sql, mapa);
    
    }
}