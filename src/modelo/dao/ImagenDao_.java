/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import controlador.Coordinador;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.InfoTabla.ImagenIT;
import modelo.ConexionDatos;
import modelo.FicherosOperacionesServidor;
import modelo.vo.ImagenVo;
/**
 *
 * @author Particular
 */
public class ImagenDao_ extends DAOGenerales_{
    
    private final ImagenIT it;
    public ImagenDao_(Coordinador coordinador) {
        super(coordinador);
        this.it = new ImagenIT();
    }
    
    public String guardarLista(List<ImagenVo> listaVo){
        //CONTENDRA EL NOMBRE DE LAS IMAGENES QUE NO SE PUDIERON SUBIR.
        String retornoErrores=null;
        //LOS VALUES PARA EL INSERT.
        String values ="";
        //PARA IR CONTANDO LA POSICION DEL MAPA ?
        int contador=1;
        // EL MAPA QUE RELACIONA ? CON EL DATO.
        HashMap<Integer, String> mapa = new HashMap<>();
        //CONTADOR PARA EVITAR LA ÚLTIMA COMA DEL SQL.
        int conComa=1;
        //RECORREMOS TODAS LAS IMAGENES QUE PASAMOS. 
        for (ImagenVo vo : listaVo) {
            //SI NO SE PUEDE SUBIR LA IMAGEN AL SERVIDOR NO LA GUARDAMOS EN LA
            // BD Y RETORNAMOS SU NOMBRE COMO ERROR.
            if (subirImagenesAServidor(vo.getFicheroImagen())) {
                // CREAMOS UNO DE ESTO POR CADA IMAGEN.
                values += " (?, ?, ?)";
                //SI ES LA ULTIMA IMAGEN NO LE PONEMOS COMA.
                if (listaVo.size()>conComa) {
                    values+=", ";
                }
                //ASIGNAMOS LOS DATOS AL MAPA DE DOS EN DOS PUESTO QUE ES EN 
                // TUPLAS QUE LO QUEREMOS MANEJAR.
                mapa.put( contador, vo.getIdRefaccion()+"");
                mapa.put( contador+1, vo.getNombreParaMostrar()+"");
                mapa.put( contador+2, vo.getNombreServidor()+"");
                //CONTADOR DE MAPA
                contador+=3;
                //CONTADOR DE COMAS
                conComa++;
            }else{
                //CARGAMOS EL NOMBRE DE LA IMAGEN QUE NO SE CARGO EN STRING. 
                retornoErrores += "     |>"+vo.getNombreParaMostrar()+"\n";
            }
            
        }
        
        String sql = "INSERT INTO " +ImagenIT.NOMBRE_TABLA 
                + " VALUES " + values;
        if (!values.isEmpty()) {
            conexion.executeUpdate(sql, mapa);
            
        }
       
        //SI NO HUBO ERRORES RETORNA NULL
        return retornoErrores;
    }
    
    public boolean subirImagenesAServidor(File img){
        FicherosOperacionesServidor ficheros = new FicherosOperacionesServidor(coordinador);
        ficheros.setUrlDeSubida(ConexionDatos.SUBIDA_IMAGEN);
        ficheros.setFicheroASubir(img);
        if (ficheros.subirFichero()) {
            return true;
        }
        return false;
    
    }
    
    public List<ImagenVo> consultar(int id){
        List<ImagenVo> livo = new ArrayList<>();
        String sql = "SELECT * FROM " + ImagenIT.NOMBRE_TABLA 
                + " WHERE " + it.getIdRefaccionPDC().getNombre() +"= ?";
        ResultSet r = conexion.executeQuery(sql, id+"");

        try {
            while (r.next()) {
                ImagenVo v = new ImagenVo();
                v.setNombreParaMostrar(r.getString(it.getNombreParaMostarPDC().getNombre()));
                v.setNombreServidor(r.getString(it.getNombreServidorPDC().getNombre()));
                v.setIdRefaccion(r.getInt(it.getIdRefaccionPDC().getNombre()));
                String nombreImagen = 
                        ConexionDatos.IMAGENES_RUTA_COMPLETA + v.getNombreServidor();
                System.out.println("nombre de imagen "+nombreImagen);
                URL u = new URL(nombreImagen);
                v.setUrlImagen(u);
                
                livo.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImagenDao_.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ImagenDao_.class.getName()).log(Level.SEVERE, null, ex);
        }
        return livo;
    }
    
    public void eliminar (ImagenVo vo){
        String sql = "DELETE FROM " + ImagenIT.NOMBRE_TABLA
                + " WHERE "
                + it.getIdRefaccionPDC().getNombre()
                + "=?  AND "
                + it.getNombreServidorPDC().getNombre()
                + "=?";
        
        HashMap<Integer, String> mapa = new HashMap<>();
        mapa.put(1, vo.getIdRefaccion()+"");
        mapa.put(2, vo.getNombreServidor());
        conexion.executeUpdate(sql, mapa);
        
    }
    
}
