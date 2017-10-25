package modelo.dao;

import controlador.Coordinador;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import modelo.Conexion;
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
     * Consulta todos los proveedores que esten relacionados con el id de la 
     * refacción que se le pase como parametro.  
     * @param id El id de refacción del que se quiere obtener las máquinas relacionadas.
     * @return La lista de relaciones entre una refacción y un proveedor dentro de un 
     * clase para ello.
     * @see RelacionRefaccionProveedorVo
     */
    public List<ProveedorVo> consultarProveedores(int id){
        conexion = new Conexion(coordinador);
        List<ProveedorVo> lrrpvo = new ArrayList<>();
        ProveedorIT pit = new ProveedorIT();
        String sql = 
               
                
                
                
        return lrrpvo;
    }
    
    
    public boolean modificar(List<RelacionRefaccionProveedorVo> vo){
        conexion = new Conexion(coordinador);
        String sql = "DELETE FROM "+RelacionRefaccionProveedorIT.NOMBRE_TABLA +
                " WHERE " +it.getIdRefaccionPDC().getNombre() + "=?" ;
        conexion.executeUpdate(sql, vo.get(0).getIdRefaccion()+"");
        
        return guardarLista(vo);
    }
    
    
   
}