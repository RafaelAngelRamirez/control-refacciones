/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import controlador.Coordinador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.InfoTabla.MaquinaModeloIT;
import modelo.InfoTabla.RelacionRefaccionMaquinaModeloIT;
import modelo.vo.MaquinaModeloVo;
import modelo.vo.RelacionRefaccionMaquinaModeloVo;

/**
 *
 * @author Particular
 */
public class RelacionRefaccionMaquinaModeloDao extends DAOGenerales_{

    RelacionRefaccionMaquinaModeloIT it;
  
    
    public RelacionRefaccionMaquinaModeloDao(Coordinador coordinador) {
        super(coordinador);
        this.it = new RelacionRefaccionMaquinaModeloIT();
    }
    
    public boolean guardarLista(List <RelacionRefaccionMaquinaModeloVo> listaVo){
        //LOS VALUES PARA EL INSERT.
        String values ="";
        //PARA IR CONTANDO LA POSICION DEL MAPA ?
        int contador=1;
        // EL MAPA QUE RELACIONA ? CON EL DATO.
        HashMap<Integer, String> mapa = new HashMap<>();
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
    
    public List<RelacionRefaccionMaquinaModeloVo> consultarModeloAnio(int id){
        List<RelacionRefaccionMaquinaModeloVo> lrrmm = new ArrayList<>();
        MaquinaModeloIT mmit = new MaquinaModeloIT();
        String sql = "SELECT "
                +MaquinaModeloIT.NOMBRE_TABLA+"."+mmit.getModeloPDC().getNombre() + " ,"
                +MaquinaModeloIT.NOMBRE_TABLA+"."+mmit.getAnioPDC().getNombre() + " ,"
                +RelacionRefaccionMaquinaModeloIT.NOMBRE_TABLA+"."+it.getIdMaquinaModeloPDC().getNombre()
                +" FROM " + RelacionRefaccionMaquinaModeloIT.NOMBRE_TABLA +
                
                " INNER JOIN " + MaquinaModeloIT.NOMBRE_TABLA +
                " ON " +
                MaquinaModeloIT.NOMBRE_TABLA+"."+mmit.getIdPDC().getNombre()
                + " = " +
                RelacionRefaccionMaquinaModeloIT.NOMBRE_TABLA+"."+it.getIdMaquinaModeloPDC().getNombre()
                
                +" WHERE " + it.getIdRefaccionPDC().getNombre() + "=?"
                ;
        
        ResultSet r = conexion.executeQuery(sql, id+"");
        
        try {
            while (r.next()) {            
                    RelacionRefaccionMaquinaModeloVo vo = new RelacionRefaccionMaquinaModeloVo();
                    MaquinaModeloVo mvo = new MaquinaModeloVo();
                    vo.setIdMaquinaModelo(r.getInt(it.getIdMaquinaModeloPDC().getNombre()));
                    vo.setMaquinaModeloVo(mvo);
                    mvo.setAnio(r.getInt(mmit.getAnioPDC().getNombre()));
                    mvo.setModelo(r.getString(mmit.getModeloPDC().getNombre()));
                    lrrmm.add(vo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RelacionRefaccionMaquinaModeloDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lrrmm;
    }
    
    public boolean modificar(List<RelacionRefaccionMaquinaModeloVo> vo){
        String sql = "DELETE FROM "+RelacionRefaccionMaquinaModeloIT.NOMBRE_TABLA +
                " WHERE " +it.getIdRefaccionPDC().getNombre() + "=?" ;
        conexion.executeUpdate(sql, vo.get(0).getIdRefaccion()+"");
        
        
        return guardarLista(vo);
    }
}
