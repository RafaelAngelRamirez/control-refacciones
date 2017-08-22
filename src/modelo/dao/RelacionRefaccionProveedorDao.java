package modelo.dao;

import controlador.Coordinador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.InfoTabla.ProveedorIT;
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
        this.it = new RelacionRefaccionProveedorIT();
    }
    
    public boolean guardarLista(List<RelacionRefaccionProveedorVo> listaVo){
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
    
    public List<RelacionRefaccionProveedorVo> consultarProveedores(int id){
        List<RelacionRefaccionProveedorVo> lrrpvo = new ArrayList<>();
        ProveedorIT pit = new ProveedorIT();
        String sql = 
                " SELECT " 
                + ProveedorIT.NOMBRE_TABLA+"."+pit.getEmpresaProveedorPDC().getNombre() +", "
                + RelacionRefaccionProveedorIT.NOMBRE_TABLA+"."+it.getIdProveedorPDC().getNombre()
                +" FROM " + RelacionRefaccionProveedorIT.NOMBRE_TABLA +
                
                " INNER JOIN " + ProveedorIT.NOMBRE_TABLA +
                " ON " +
                ProveedorIT.NOMBRE_TABLA+"."+pit.getIdPDC().getNombre()
                + " = " +
                RelacionRefaccionProveedorIT.NOMBRE_TABLA+"."+it.getIdProveedorPDC().getNombre()
                
                + " WHERE " + it.getIdRefaccionPDC().getNombre() + " = ?" 
                ;
        
        ResultSet r = conexion.executeQuery(sql, id+"");
        
        try {
            while (r.next()) {
                RelacionRefaccionProveedorVo vo = new RelacionRefaccionProveedorVo();
                ProveedorVo pvo = new ProveedorVo();
                vo.setIdProveedor(r.getInt(it.getIdProveedorPDC().getNombre()));
                vo.setProveedorVo(pvo);
                
                pvo.setEmpresa(r.getString(pit.getEmpresaProveedorPDC().getNombre()));
                
                lrrpvo.add(vo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RelacionRefaccionProveedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lrrpvo;
    }
    
    
    public boolean modificar(List<RelacionRefaccionProveedorVo> vo){
        String sql = "DELETE FROM "+RelacionRefaccionProveedorIT.NOMBRE_TABLA +
                " WHERE " +it.getIdRefaccionPDC().getNombre() + "=?" ;
        conexion.executeUpdate(sql, vo.get(0).getIdRefaccion()+"");
        
        return guardarLista(vo);
    }
    
    
   
}