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
import modelo.InfoTabla.MaquinaModeloIT;
import modelo.InfoTabla.ProveedorIT;
import modelo.InfoTabla.RelacionRefaccionMaquinaModeloIT;
import modelo.InfoTabla.RelacionRefaccionProveedorIT;
import modelo.vo.*;

/**
 *
 * @author Particular
 */
public class RelacionRefaccionProveedorDao extends DAOGenerales{
   
    RelacionRefaccionProveedorIT it;
    public RelacionRefaccionProveedorDao(Coordinador coordinador) {
        super(coordinador);
    }
    
    public boolean guardarLista(List<RelacionRefaccionProveedorVo> listaVo){
        conexion = new Conexion(coordinador);
        //LOS VALUES PARA EL INSERT.
        String values ="";
        //PARA IR CONTANDO LA POSICION DEL MAPA ?
        int contador=1;
        // EL MAPA QUE RELACIONA ? CON EL DATO.
        HashMap<Integer, Object> mapa = new HashMap<>();
        //CONTADOR PARA EVITAR LA ÚLTIMA COMA DEL SQL.
        int conComa=1;
        //RECORREMOS TODAS LAS IMAGENES QUE PASAMOS. 
        for (RelacionRefaccionProveedorVo vo : listaVo) {
            // CREAMOS UNO DE ESTO POR CADA IMAGEN.
            values += " (?, ?)";
            //SI ES LA ULTIMA IMAGEN NO LE PONEMOS COMA.
            if (listaVo.size()>conComa) {
                values+=", ";
            }
            //ASIGNAMOS LOS DATOS AL MAPA DE DOS EN DOS PUESTO QUE ES EN 
            // TUPLAS QUE LO QUEREMOS MANEJAR.
            mapa.put( contador, vo.getIdRefaccion()+"");
            mapa.put( contador+1, vo.getIdProveedor()+"");
            //CONTADOR DE MAPA
            contador+=2;
            //CONTADOR DE COMAS
            conComa++;
            
        }
        
        String sql = "INSERT INTO " +RelacionRefaccionProveedorIT.NOMBRE_TABLA 
                +  " VALUES " + values;
               
        return conexion.executeUpdate(sql, mapa);
    }
    
    /**
     * Consulta los proveedores que estan seleccionados con el id de la máquina
     * que se le pase como parametro. 
     * @param vo La refacción de la cual se quiere buscar las máquinas. 
     * @return La lista de máquinas relacionadas. 
     */
    public List<ProveedorVo> consultarProveedores(RefaccionVo vo){
        conexion = new Conexion(coordinador);
        List<ProveedorVo> lrrpvo = new ArrayList<>();
        
        String sql = "SELECT " +
                    ProveedorIT.NOMBRE_TABLA+"."+ProveedorIT.getID().getNombre()+" ,"+
                    ProveedorIT.NOMBRE_TABLA+"."+ProveedorIT.getEMPRESA_PROVEEDOR().getNombre()
                +" FROM "+
                    ProveedorIT.NOMBRE_TABLA
                +" JOIN "+
                    MaquinaModeloIT.NOMBRE_TABLA
                +" ON "+
                    MaquinaModeloIT.NOMBRE_TABLA+"."+MaquinaModeloIT.getID_PROVEEDOR().getNombre()
                    +" = "+
                    ProveedorIT.NOMBRE_TABLA+"."+ProveedorIT.getID().getNombre()
                +" WHERE "+
                    MaquinaModeloIT.NOMBRE_TABLA+"."+MaquinaModeloIT.getID_PROVEEDOR().getNombre()
                +" IN ( SELECT "+
                            RelacionRefaccionMaquinaModeloIT.getID_MAQUINA_MODELO().getNombre() 
                        +" FROM "+
                            RelacionRefaccionMaquinaModeloIT.NOMBRE_TABLA
                        +" WHERE "+
                            RelacionRefaccionMaquinaModeloIT.getID_REFACCION().getNombre()+" =? )"
                +" GROUP BY " +
                    ProveedorIT.NOMBRE_TABLA+"."+ProveedorIT.getID().getNombre();
        
        ResultSet r = conexion.executeQuery(sql, vo.getId());
        try {
            while (r.next()) {
                ProveedorVo pvo = new ProveedorVo();
                pvo.setId(r.getInt(ProveedorIT.getID().getNombre()));
                pvo.setEmpresa(r.getString(ProveedorIT.getEMPRESA_PROVEEDOR().getNombre()));
                lrrpvo.add(pvo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RelacionRefaccionProveedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                            
        return lrrpvo;
    }
    
    
    
    public boolean modificar(List<RelacionRefaccionProveedorVo> vo){
        conexion = new Conexion(coordinador);
        String sql = "DELETE FROM "+RelacionRefaccionProveedorIT.NOMBRE_TABLA +
                " WHERE " +
                RelacionRefaccionProveedorIT.getID_REFACCION().getNombre() + "=?" ;
        conexion.executeUpdate(sql, vo.get(0).getIdRefaccion()+"");
        
        return guardarLista(vo);
    }
    
    
   
}