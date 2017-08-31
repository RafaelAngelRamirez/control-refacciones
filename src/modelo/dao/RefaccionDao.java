package modelo.dao;

import controlador.Coordinador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try {
            String sql = "SELECT COUNT(*) FROM " + RefaccionIT.NOMBRE_TABLA
                    + " WHERE " +  it.getCodigoInternoPDC().getNombre() + "= ?";
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
        try {
            String sql = "SELECT COUNT(*) FROM " + RefaccionIT.NOMBRE_TABLA
                    + " WHERE " +  it.getCodigoInternoPDC().getNombre() + "= ?"
                    + " AND " + it.getIdPDC().getNombre() + "!= ?";
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
        String sql = "SELECT MAX("+it.getIdPDC().getNombre()+") FROM "+RefaccionIT.NOMBRE_TABLA;
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
        
        
        List<RefaccionVo> listaVo = new ArrayList<>();
        busqueda = Textos.especialREGEX(busqueda);
       
        try {
            ImportanciaIT iit = new ImportanciaIT();
            UnidadIT uit = new UnidadIT();
            String sql =
                    "SELECT "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getIdPDC().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getCodigoInternoPDC().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getCodigoProveedorPDC().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getNombrePDC().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getDescripcionPDC().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getStockMinimoPDC().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getStockMaximoPDC().getNombre() + ", "
                    + UnidadIT.NOMBRE_TABLA +"."+uit.getUnidadPDC().getNombre() + ", "
                    + ImportanciaIT.NOMBRE_TABLA +"."+iit.getImportanciaPDC().getNombre() + 
                    " FROM " + RefaccionIT.NOMBRE_TABLA +
                    
                    " INNER JOIN " + ImportanciaIT.NOMBRE_TABLA +
                    " ON " + 
                    ImportanciaIT.NOMBRE_TABLA +"."+ iit.getIdPDC().getNombre() 
                    + " = " + 
                    RefaccionIT.NOMBRE_TABLA+"."+it.getImportanciaPDC().getNombre() +
                    " INNER JOIN " + UnidadIT.NOMBRE_TABLA +
                    " ON " + 
                    UnidadIT.NOMBRE_TABLA +"."+ uit.getIdPDC().getNombre() 
                    + " = " + 
                    RefaccionIT.NOMBRE_TABLA+"."+it.getUnidadPDC().getNombre() 
                    ;
            
            String regexp = " REGEXP '.*"+busqueda+"|"+busqueda+".*' ";
           
            String sqlBusqueda = 
                    " WHERE " +
                    it.getNombrePDC().getNombre() + regexp
                    + " OR " + 
                    it.getCodigoInternoPDC().getNombre() + regexp
                    + " OR " + 
                    it.getCodigoProveedorPDC().getNombre() + regexp
                    + " OR " + 
                    it.getDescripcionPDC().getNombre() + regexp
                    + " OR " + 
                    ImportanciaIT.NOMBRE_TABLA+"."+iit.getImportanciaPDC().getNombre() + regexp;
            
            String sqlOrden =  
                    " ORDER BY "+  ImportanciaIT.NOMBRE_TABLA +"."+ iit.getIdPDC().getNombre() +" ASC ";
            
            if (!busqueda.isEmpty()) {
                sql += sqlBusqueda;
            }
            
            sql+=sqlOrden;
            
                    
            
            ResultSet r = conexion.executeQuery(sql);
            while (r.next()) {
                RefaccionVo v = new RefaccionVo();
                v.setId(r.getInt(it.getIdPDC().getNombre()));
                v.setCodigoInterno(r.getString(it.getCodigoInternoPDC().getNombre()));
                v.setCodigoProveedor(r.getString(it.getCodigoProveedorPDC().getNombre()));
                v.setNombre(r.getString(it.getNombrePDC().getNombre()));
                v.setDescripcion(r.getString(it.getDescripcionPDC().getNombre()));
                v.setImportancia(r.getString(iit.getImportanciaPDC().getNombre()));
                v.setStockMaximo(r.getDouble(it.getStockMaximoPDC().getNombre()));
                v.setStockMinimo(r.getDouble(it.getStockMinimoPDC().getNombre()));
                v.setUnidad(r.getString(uit.getUnidadPDC().getNombre()));
                
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
        RefaccionVo v = new RefaccionVo();
        try {
            ImportanciaIT iit = new ImportanciaIT();
            UnidadIT uit = new UnidadIT();
            MaterialIT mit = new MaterialIT();
            String sql =
                    "SELECT "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getIdPDC().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getNombrePDC().getNombre() + ", "
                    + MaterialIT.NOMBRE_TABLA +"."+mit.getMaterialPDC().getNombre() + ", "
                    + ImportanciaIT.NOMBRE_TABLA +"."+iit.getImportanciaPDC().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getStockMinimoPDC().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getStockMaximoPDC().getNombre() + ", "
                    + UnidadIT.NOMBRE_TABLA +"."+uit.getUnidadPDC().getNombre() + ", " 
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getCodigoInternoPDC().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getCodigoProveedorPDC().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getDescripcionPDC().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getQueEsPDC().getNombre() + ", "
                    + RefaccionIT.NOMBRE_TABLA +"."+it.getParaQueEsPDC().getNombre() 
                    +
                    " FROM " + RefaccionIT.NOMBRE_TABLA 
                    +
                    " INNER JOIN " + ImportanciaIT.NOMBRE_TABLA +
                    " ON " + 
                    ImportanciaIT.NOMBRE_TABLA +"."+ iit.getIdPDC().getNombre() 
                    + " = " + 
                    RefaccionIT.NOMBRE_TABLA+"."+it.getImportanciaPDC().getNombre() +
                    
                    " INNER JOIN " + MaterialIT.NOMBRE_TABLA +
                    " ON " + 
                    MaterialIT.NOMBRE_TABLA +"."+ mit.getIdPDC().getNombre() 
                    + " = " + 
                    RefaccionIT.NOMBRE_TABLA+"."+it.getIdMaterialPDC().getNombre() +
                    
                    " INNER JOIN " + UnidadIT.NOMBRE_TABLA +
                    " ON " + 
                    UnidadIT.NOMBRE_TABLA +"."+ uit.getIdPDC().getNombre() 
                    + " = " + 
                    RefaccionIT.NOMBRE_TABLA+"."+it.getUnidadPDC().getNombre() +
                    
                    " WHERE " + RefaccionIT.NOMBRE_TABLA+"."+it.getIdPDC().getNombre() +" = ?" ;
            
            
            ResultSet r = conexion.executeQuery(sql, id+"");
            r.next();
            v.setId(r.getInt(it.getIdPDC().getNombre()));
            v.setCodigoInterno(r.getString(it.getCodigoInternoPDC().getNombre()));
            v.setCodigoProveedor(r.getString(it.getCodigoProveedorPDC().getNombre()));
            v.setNombre(r.getString(it.getNombrePDC().getNombre()));
            v.setDescripcion(r.getString(it.getDescripcionPDC().getNombre()));
            v.setImportancia(r.getString(iit.getImportanciaPDC().getNombre()));
            v.setStockMaximo(r.getDouble(it.getStockMaximoPDC().getNombre()));
            v.setStockMinimo(r.getDouble(it.getStockMinimoPDC().getNombre()));
            v.setUnidad(r.getString(uit.getUnidadPDC().getNombre()));
            v.setParaQueEs(r.getString(it.getParaQueEsPDC().getNombre()));
            v.setQueEs(r.getString(it.getQueEsPDC().getNombre()));
            v.setIdMaterial(r.getString(mit.getMaterialPDC().getNombre()));
            
                
        } catch (SQLException ex) {
            Logger.getLogger(RefaccionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
        
    }
    
    public boolean modificar(RefaccionVo vo){
        String sql = 
            "UPDATE " + RefaccionIT.NOMBRE_TABLA 
            + " SET " +
                it.getNombrePDC().getNombre()+ "= ? , " +
                it.getIdMaterialPDC().getNombre()+ "= ? , " +
                it.getImportanciaPDC().getNombre()+ "= ? , " +
                it.getStockMinimoPDC().getNombre()+ "= ? , " +
                it.getStockMaximoPDC().getNombre()+ "= ? , " +
                it.getUnidadPDC().getNombre()+ "= ? , " +
                it.getCodigoInternoPDC().getNombre()+ "= ? , " +
                it.getCodigoProveedorPDC().getNombre()+ "= ? , " +
                it.getDescripcionPDC().getNombre()+ "= ? , " +
                it.getQueEsPDC().getNombre()+ "= ? , " +
                it.getParaQueEsPDC().getNombre()+ "= ?   " 
            + " WHERE " + it.getIdPDC().getNombre() + "= ?";
        
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
        mapa.put(12, vo.getId());
        
        return conexion.executeUpdate(sql, mapa);
    
    }
}