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
                    + RefaccionIT.NOMBRE_TABLA +"."+RefaccionIT.getID().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+RefaccionIT.getCODIGO_INTERNO().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+RefaccionIT.getCODIGO_PROVEEDOR().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+RefaccionIT.getNOMBRE().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+RefaccionIT.getDESCRIPCION().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+RefaccionIT.getSTOCK_MINIMO().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+RefaccionIT.getSTOCK_MAXIMO().getNombre() + ", "
                    + UnidadIT.NOMBRE_TABLA +"."+UnidadIT.getUNIDAD().getNombre() + ", "
                    + ImportanciaIT.NOMBRE_TABLA +"."+ImportanciaIT.getIMPORTANCIA().getNombre() + 
                    " FROM " + RefaccionIT.NOMBRE_TABLA +
                    
                    " INNER JOIN " + ImportanciaIT.NOMBRE_TABLA +
                    " ON " + 
                    ImportanciaIT.NOMBRE_TABLA +"."+ ImportanciaIT.getID().getNombre() 
                    + " = " + 
                    RefaccionIT.NOMBRE_TABLA+"."+RefaccionIT.getIMPORTANCIA().getNombre() +
                    " INNER JOIN " + UnidadIT.NOMBRE_TABLA +
                    " ON " + 
                    UnidadIT.NOMBRE_TABLA +"."+ UnidadIT.getID().getNombre() 
                    + " = " + 
                    RefaccionIT.NOMBRE_TABLA+"."+RefaccionIT.getUNIDAD().getNombre() 
                    ;
            
            String regexp = " REGEXP '.*"+busqueda+"|"+busqueda+".*' ";
           
            String sqlBusqueda = 
                    " WHERE " +
                    RefaccionIT.getNOMBRE().getNombre() + regexp
                    + " OR " + 
                    RefaccionIT.getCODIGO_INTERNO().getNombre() + regexp
                    + " OR " + 
                    RefaccionIT.getCODIGO_PROVEEDOR().getNombre() + regexp
                    + " OR " + 
                    RefaccionIT.getDESCRIPCION().getNombre() + regexp
                    + " OR " + 
                    ImportanciaIT.NOMBRE_TABLA+"."+ImportanciaIT.getIMPORTANCIA().getNombre() + regexp;
            
            if (!busqueda.isEmpty()) {
                sql += sqlBusqueda;
            }
            
            sql += "LIMIT 20";
            
            ResultSet r = conexion.executeQuery(sql);
            while (r.next()) {
                RefaccionVo v = new RefaccionVo();
                v.setId(r.getInt(RefaccionIT.getID().getNombre()));
                v.setCodigoInterno(r.getString(RefaccionIT.getCODIGO_INTERNO().getNombre()));
                v.setCodigoProveedor(r.getString(RefaccionIT.getCODIGO_PROVEEDOR().getNombre()));
                v.setNombre(r.getString(RefaccionIT.getNOMBRE().getNombre()));
                v.setDescripcion(r.getString(RefaccionIT.getDESCRIPCION().getNombre()));
                v.setImportancia(r.getString(ImportanciaIT.getIMPORTANCIA().getNombre()));
                v.setStockMaximo(r.getDouble(RefaccionIT.getSTOCK_MAXIMO().getNombre()));
                v.setStockMinimo(r.getDouble(RefaccionIT.getSTOCK_MINIMO().getNombre()));
                v.setUnidad(r.getString(UnidadIT.getUNIDAD().getNombre()));
                
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
                    + RefaccionIT.NOMBRE_TABLA +"."+RefaccionIT.getID().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+RefaccionIT.getNOMBRE().getNombre() + ", "
                    + MaterialIT.NOMBRE_TABLA +"."+MaterialIT.getMATERIAL().getNombre() + ", "
                    + ImportanciaIT.NOMBRE_TABLA +"."+ImportanciaIT.getIMPORTANCIA().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+RefaccionIT.getSTOCK_MINIMO().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+RefaccionIT.getSTOCK_MAXIMO().getNombre() + ", "
                    + UnidadIT.NOMBRE_TABLA +"."+UnidadIT.getUNIDAD().getNombre() + ", " 
                    + RefaccionIT.NOMBRE_TABLA +"."+RefaccionIT.getCODIGO_INTERNO().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+RefaccionIT.getCODIGO_PROVEEDOR().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+RefaccionIT.getDESCRIPCION().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+RefaccionIT.getQUE_ES().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+RefaccionIT.getREFACCION_DE_CONSUMO_UNICO().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+RefaccionIT.getPARA_QUE_ES().getNombre() 
                    +
                    " FROM " + RefaccionIT.NOMBRE_TABLA 
                    +
                    " INNER JOIN " + ImportanciaIT.NOMBRE_TABLA +
                    " ON " + 
                    ImportanciaIT.NOMBRE_TABLA +"."+ ImportanciaIT.getID().getNombre() 
                    + " = " + 
                    RefaccionIT.NOMBRE_TABLA+"."+RefaccionIT.getIMPORTANCIA().getNombre() +
                    
                    " INNER JOIN " + MaterialIT.NOMBRE_TABLA +
                    " ON " + 
                    MaterialIT.NOMBRE_TABLA +"."+ MaterialIT.getID().getNombre() 
                    + " = " + 
                    RefaccionIT.NOMBRE_TABLA+"."+RefaccionIT.getID_MATERIAL().getNombre() +
                    
                    " INNER JOIN " + UnidadIT.NOMBRE_TABLA +
                    " ON " + 
                    UnidadIT.NOMBRE_TABLA +"."+ UnidadIT.getID().getNombre() 
                    + " = " + 
                    RefaccionIT.NOMBRE_TABLA+"."+RefaccionIT.getUNIDAD().getNombre() +
                    
                    " WHERE " + RefaccionIT.NOMBRE_TABLA+"."+RefaccionIT.getID().getNombre() +" = ?" ;
            
            
            ResultSet r = conexion.executeQuery(sql, id+"");
            r.next();
            v.setId(r.getInt(RefaccionIT.getID().getNombre()));
            v.setCodigoInterno(r.getString(RefaccionIT.getCODIGO_INTERNO().getNombre()));
            v.setCodigoProveedor(r.getString(RefaccionIT.getCODIGO_PROVEEDOR().getNombre()));
            v.setNombre(r.getString(RefaccionIT.getNOMBRE().getNombre()));
            v.setDescripcion(r.getString(RefaccionIT.getDESCRIPCION().getNombre()));
            v.setImportancia(r.getString(ImportanciaIT.getIMPORTANCIA().getNombre()));
            v.setStockMaximo(r.getDouble(RefaccionIT.getSTOCK_MAXIMO().getNombre()));
            v.setStockMinimo(r.getDouble(RefaccionIT.getSTOCK_MINIMO().getNombre()));
            v.setUnidad(r.getString(UnidadIT.getUNIDAD().getNombre()));
            v.setParaQueEs(r.getString(RefaccionIT.getPARA_QUE_ES().getNombre()));
            v.setQueEs(r.getString(RefaccionIT.getQUE_ES().getNombre()));
            v.setRefaccionDeConsumoUnico(r.getByte(RefaccionIT.getREFACCION_DE_CONSUMO_UNICO().getNombre()));
            v.setIdMaterial(r.getString(MaterialIT.getMATERIAL().getNombre()));
            
                
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
                RefaccionIT.getNOMBRE().getNombre()+ "= ? , " +
                RefaccionIT.getID_MATERIAL().getNombre()+ "= ? , " +
                RefaccionIT.getIMPORTANCIA().getNombre()+ "= ? , " +
                RefaccionIT.getSTOCK_MINIMO().getNombre()+ "= ? , " +
                RefaccionIT.getSTOCK_MAXIMO().getNombre()+ "= ? , " +
                RefaccionIT.getUNIDAD().getNombre()+ "= ? , " +
                RefaccionIT.getCODIGO_INTERNO().getNombre()+ "= ? , " +
                RefaccionIT.getCODIGO_PROVEEDOR().getNombre()+ "= ? , " +
                RefaccionIT.getDESCRIPCION().getNombre()+ "= ? , " +
                RefaccionIT.getQUE_ES().getNombre()+ "= ? , " +
                RefaccionIT.getPARA_QUE_ES().getNombre()+ "= ? ,   " +
                RefaccionIT.getREFACCION_DE_CONSUMO_UNICO().getNombre()+ "= ?  " 
            + " WHERE " + RefaccionIT.getID().getNombre() + "= ?";
        
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
        
        mapa.put(13, vo.getId());
        
        return conexion.executeUpdate(sql, mapa);
    
    }
}