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
import modelo.vo.ImportanciaVo;

/**
 *
 * @author Particular
 */
public class ImportanciaDao extends DAOGenerales{
       

    private final ImportanciaIT it;

    public ImportanciaDao(Coordinador coordinador) {
        super(coordinador);
        this.it = new ImportanciaIT();
    }
    

    public void registrar(ImportanciaVo vo) {
        conexion= new Conexion(coordinador);
        String sql = "INSERT INTO "+ImportanciaIT.NOMBRE_TABLA+" VALUES (null, ?)";
                       
        HashMap<Integer, Object> mapaDatos = new HashMap<>();
        mapaDatos.put(1, vo.getImportancia());
        conexion.executeUpdate(sql, mapaDatos);
           
    }

    /**
     * Consulta todos los niveles de importancia. 
     * @return La lista con los niveles de importancia. 
     */
    public List<ImportanciaVo> consultar() {
        conexion = new Conexion(coordinador);
        String sql = "SELECT * FROM " + ImportanciaIT.NOMBRE_TABLA;
        
        ResultSet r = conexion.executeQuery(sql);
        List<ImportanciaVo> listVo = new ArrayList<>();
        try {
            while (r.next()) {
                ImportanciaVo vo = new ImportanciaVo();
                vo.setId(r.getInt(it.getIdPDC().getNombre()));
                vo.setImportancia(r.getString(it.getImportanciaPDC().getNombre()));
                listVo.add(vo);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportanciaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listVo;
    }

  
}