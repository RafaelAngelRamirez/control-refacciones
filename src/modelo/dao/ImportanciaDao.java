package modelo.dao;

import controlador.Coordinador;
import modelo.ExcepcionPersonalizada;
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
        String sql = "INSERT INTO "+ImportanciaIT.NOMBRE_TABLA+" VALUES (null, ?)";
                       
        HashMap<Integer, Object> mapaDatos = new HashMap<>();
        mapaDatos.put(1, vo.getImportancia());
        conexion.executeUpdate(sql, mapaDatos);
           
    }

  
}