package modelo.dao;

import controlador.Coordinador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.InfoTabla.MaquinaModeloIT;
import modelo.InfoTabla.RefaccionIT;
import modelo.InfoTabla.RelacionRefaccionMaquinaModeloIT;
import modelo.vo.MaquinaModeloVo;
import modelo.vo.RefaccionVo;
import modelo.vo.RelacionRefaccionMaquinaModeloVo;

/**
 *
 * @author Particular
 */
public class RelacionRefaccionMaquinaModeloDao extends DAOGenerales{

  
    
    public RelacionRefaccionMaquinaModeloDao(Coordinador coordinador) {
        super(coordinador);
    }
    
    /**
     * Guarda la lista de relaciones entre refaccionnes y maquinas modelo que
     * se le pase como parametro. 
     * @param listaVo La lista que se quiere guardar. 
     * @return  True si todo fue correcto. 
     */
    public boolean guardarLista(List <RelacionRefaccionMaquinaModeloVo> listaVo){
        conexion = new Conexion(coordinador);        
        //LOS VALUES PARA EL INSERT.
        String values ="";
        //PARA IR CONTANDO LA POSICION DEL MAPA ?
        int contador=1;
        // EL MAPA QUE RELACIONA ? CON EL DATO.
        HashMap<Integer, Object> mapa = new HashMap<>();
        //CONTADOR PARA EVITAR LA ÚLTIMA COMA DEL SQL.
        int conComa=1;
        //RECORREMOS TODAS LOS MODELOS QUE PASAMOS. 
        for (RelacionRefaccionMaquinaModeloVo vo : listaVo) {
            // CREAMOS UNO DE ESTO POR CADA MODELO.
            values += " (?, ?)";
            //SI ES LA ULTIMA IMAGEN NO LE PONEMOS COMA.
            if (listaVo.size()>conComa) {
                values+=", ";
            }
            //ASIGNAMOS LOS DATOS AL MAPA DE DOS EN DOS PUESTO QUE ES EN 
            // TUPLAS QUE LO QUEREMOS MANEJAR.
            mapa.put( contador, vo.getIdRefaccion()+"");
            mapa.put( contador+1, vo.getIdMaquinaModelo()+"");
            //CONTADOR DE MAPA
            contador+=2;
            //CONTADOR DE COMAS
            conComa++;
            
            
        }
        
        String sql = "INSERT INTO " +RelacionRefaccionMaquinaModeloIT.NOMBRE_TABLA 
                + " VALUES " + values;
               
        return conexion.executeUpdate(sql, mapa);
    }
    
    /**
     * Consulta el modelo y año como pares para luego retornar este dato. Se 
     * filtra al id de la refacción que se le pase. 
     * @param id El id de la refacción de la que se quiere consultar 
     * los modelos dependientes. 
     * @return La lista de maquinas-modelo relacionadas con la refacción.
     */
    public List<RelacionRefaccionMaquinaModeloVo> consultarModeloAnio(int id){
        conexion = new Conexion(coordinador);
        List<RelacionRefaccionMaquinaModeloVo> lrrmm = new ArrayList<>();
        MaquinaModeloIT mmit = new MaquinaModeloIT();
        String sql = "SELECT "
                +MaquinaModeloIT.NOMBRE_TABLA+"."+MaquinaModeloIT.getMODELO().getNombre() + " ,"
                +MaquinaModeloIT.NOMBRE_TABLA+"."+MaquinaModeloIT.getAnioPDC().getNombre() + " ,"
                +RelacionRefaccionMaquinaModeloIT.NOMBRE_TABLA+"."+RelacionRefaccionMaquinaModeloIT.getID_MAQUINA_MODELO().getNombre()
                +" FROM " + RelacionRefaccionMaquinaModeloIT.NOMBRE_TABLA +
                
                " INNER JOIN " + MaquinaModeloIT.NOMBRE_TABLA +
                " ON " +
                MaquinaModeloIT.NOMBRE_TABLA+"."+MaquinaModeloIT.getID().getNombre()
                + " = " +
                RelacionRefaccionMaquinaModeloIT.NOMBRE_TABLA+"."+RelacionRefaccionMaquinaModeloIT.getID_MAQUINA_MODELO().getNombre()
                
                +" WHERE " + RelacionRefaccionMaquinaModeloIT.getID_REFACCION().getNombre() + "=?"
                ;
        
        ResultSet r = conexion.executeQuery(sql, id+"");
        
        try {
            while (r.next()) {            
                    RelacionRefaccionMaquinaModeloVo vo = new RelacionRefaccionMaquinaModeloVo();
                    MaquinaModeloVo mvo = new MaquinaModeloVo();
                    vo.setIdMaquinaModelo(r.getInt(RelacionRefaccionMaquinaModeloIT.getID_MAQUINA_MODELO().getNombre()));
                    vo.setMaquinaModeloVo(mvo);
                    mvo.setAnio(r.getInt(MaquinaModeloIT.getAnioPDC().getNombre()));
                    mvo.setModelo(r.getString(MaquinaModeloIT.getMODELO().getNombre()));
                    lrrmm.add(vo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RelacionRefaccionMaquinaModeloDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lrrmm;
    }
    
    /**
     * Modifica la lista que este relaciona con el idRefaccion que se le pase
     * como parametro a todos los objetos RelacionRefaccionMaquinaModeloVo.
     * Primero los elimina todos y luego los vuelve a guardar. 
     * @param listaVo La lista nueva que se actualizara para la refacción.
     * @return Devuelve verdadero si todo fue bien. 
     * 
     */
    public boolean modificar( List<RelacionRefaccionMaquinaModeloVo> listaVo){
        conexion = new Conexion(coordinador);
        String sql = "DELETE FROM "+ RelacionRefaccionMaquinaModeloIT.NOMBRE_TABLA
                + " WHERE " + RelacionRefaccionMaquinaModeloIT.getID_REFACCION().getNombre() + " =? ";
        conexion.executeUpdate(sql, listaVo.get(0).getIdRefaccion()+"");
        return this.guardarLista(listaVo);
    }
    
   
    /**
     * Consulta todas las refacciones que sean compatibles con la máquina modelo 
     * que se le pase como parametro. 
     * @param mmvo La máquina modelo que se quiere buscar.
     * @return La lista de refacciones compatibles. 
     */
    public List<RefaccionVo> consultarCompatiblesConMaquinaModelo(List<MaquinaModeloVo>  mmvo) {
        return consultarCompatiblesConMaquinaModelo(mmvo, "");
    }
    
   /**
     * Consulta todas las refacciones que sean compatibles con la máquina modelo 
     * que se le pase como parametro filtradas por el texto. s
     * @param mmvo La máquina modelo que se quiere buscar. 
     * @param busqueda El texto que se va a buscar. 
     * @return La lista de refacciones compatibles. 
     */
    public List<RefaccionVo> consultarCompatiblesConMaquinaModelo(List<MaquinaModeloVo> mmvo, String busqueda) {
        conexion = new Conexion(coordinador);
        List<RefaccionVo> list = new ArrayList<>();
        
        String sql = "SELECT "+
                RefaccionIT.NOMBRE_TABLA+"."+RefaccionIT.getID().getNombre()+", "+
                RefaccionIT.NOMBRE_TABLA+"."+RefaccionIT.getNOMBRE().getNombre()+", "+
                RefaccionIT.NOMBRE_TABLA+"."+RefaccionIT.getCODIGO_INTERNO().getNombre()+", "+
                RefaccionIT.NOMBRE_TABLA+"."+RefaccionIT.getCODIGO_PROVEEDOR().getNombre()+", "+
                RefaccionIT.NOMBRE_TABLA+"."+RefaccionIT.getDESCRIPCION().getNombre()
                
                +" FROM "+
                RelacionRefaccionMaquinaModeloIT.NOMBRE_TABLA
               
                +" INNER JOIN "+
                RefaccionIT.NOMBRE_TABLA
                +" ON "+
                RelacionRefaccionMaquinaModeloIT.NOMBRE_TABLA+"."+RelacionRefaccionMaquinaModeloIT.getID_REFACCION().getNombre() 
                +"="+ 
                RefaccionIT.NOMBRE_TABLA+"."+RefaccionIT.getID().getNombre()
                 +" WHERE "+
                RelacionRefaccionMaquinaModeloIT.NOMBRE_TABLA+"."+RelacionRefaccionMaquinaModeloIT.getID_MAQUINA_MODELO().getNombre() 
                +" IN (";
        
        String a ="";
        HashMap<Integer,Object> mapa = new HashMap<>();
        int cont = 1;
        for (Iterator<MaquinaModeloVo> i = mmvo.iterator(); i.hasNext();) {
            MaquinaModeloVo vo = i.next();
            a+= i.hasNext() ? " ?, ":"?";
            mapa.put(cont, vo.getId());
            cont++;
        }
        
        sql+=a+")";
        
        
        String regexp = " REGEXP '.*"+busqueda+"|"+busqueda+".*' ";
           
        String sqlBusqueda = 
                " AND (" +
                RefaccionIT.getNOMBRE().getNombre() + regexp
                + " OR " + 
                RefaccionIT.getCODIGO_INTERNO().getNombre() + regexp
                + " OR " + 
                RefaccionIT.getCODIGO_PROVEEDOR().getNombre() + regexp
                + " OR " + 
                RefaccionIT.getDESCRIPCION().getNombre() + regexp+
                ")";
        
        if (!busqueda.isEmpty()) {
            sql+=sqlBusqueda;
        }
        
            
        ResultSet r = conexion.executeQuery(sql, mapa);
        
        try {
            while (r.next()) {
                RefaccionVo vo = new RefaccionVo();
                vo.setId(r.getInt(RefaccionIT.getID().getNombre()));
                vo.setNombre(r.getString(RefaccionIT.getNOMBRE().getNombre()));
                vo.setCodigoInterno(r.getString(RefaccionIT.getCODIGO_INTERNO().getNombre()));
                vo.setCodigoProveedor(r.getString(RefaccionIT.getCODIGO_PROVEEDOR().getNombre()));
                vo.setDescripcion(r.getString(RefaccionIT.getDESCRIPCION().getNombre()));
                list.add(vo);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(RelacionRefaccionMaquinaModeloDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    
    
    
}