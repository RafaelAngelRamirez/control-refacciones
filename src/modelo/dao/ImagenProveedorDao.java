/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import controlador.Coordinador;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ConexionDatos;
import modelo.FicherosOperacionesServidor;
import modelo.InfoTabla.ImagenProveedorIT;
import modelo.vo.ImagenProveedorVo;

/**
 *
 * @author Particular
 */
public class ImagenProveedorDao extends DAOGenerales{
    private final ImagenProveedorIT it;
    public ImagenProveedorDao(Coordinador coordinador) {
        super(coordinador);
        this.it = new ImagenProveedorIT();
    }
    
    public String guardarLista(List<ImagenProveedorVo> listaVo){
    //CONTENDRA EL NOMBRE DE LAS IMAGENES QUE NO SE PUDIERON SUBIR.
        String retornoErrores=null;
        //LOS VALUES PARA EL INSERT.
        String values ="";
        //PARA IR CONTANDO LA POSICION DEL MAPA ?
        int contador=1;
        // EL MAPA QUE RELACIONA ? CON EL DATO.
        HashMap<Integer, Object> mapa = new HashMap<>();
        //CONTADOR PARA EVITAR LA ÚLTIMA COMA DEL SQL.
        int conComa=1;
        //RECORREMOS TODAS LAS IMAGENES QUE PASAMOS. 
        for (ImagenProveedorVo vo : listaVo) {
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
                mapa.put( contador, vo.getIdProveedor()+"");
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
        
        String sql = "INSERT INTO " +ImagenProveedorIT.NOMBRE_TABLA 
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
        ficheros.setFichero(img);
        if (ficheros.subirFichero()) {
            return true;
        }
        return false;
    
    }
     
    public List<ImagenProveedorVo> consultar(int id){
        List<ImagenProveedorVo> livo = new ArrayList<>();
        String sql = "SELECT * FROM " + ImagenProveedorIT.NOMBRE_TABLA 
                + " WHERE " + it.getIdProveedorPDC().getNombre() +"= ?";
        ResultSet r = conexion.executeQuery(sql, id+"");

        try {
            while (r.next()) {
                ImagenProveedorVo v = new ImagenProveedorVo();
                v.setNombreParaMostrar(r.getString(it.getNombreParaMostarPDC().getNombre()));
                v.setNombreServidor(r.getString(it.getNombreServidorPDC().getNombre()));
                v.setIdProveedor(r.getInt(it.getIdProveedorPDC().getNombre()));
                String nombreImagen = 
                        ConexionDatos.IMAGENES_RUTA_COMPLETA + v.getNombreServidor();
                URL u = new URL(nombreImagen);
                v.setUrlImagen(u);
                
                livo.add(v);
            }
        } catch (SQLException | MalformedURLException ex) {
            Logger.getLogger(ImagenRefaccionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return livo;
    }
    
    public boolean eliminar (ImagenProveedorVo vo){
        String sql = "DELETE FROM " + ImagenProveedorIT.NOMBRE_TABLA
                + " WHERE "
                + it.getIdProveedorPDC().getNombre()
                + "=?  AND "
                + it.getNombreServidorPDC().getNombre()
                + "=?";
        
        HashMap<Integer, Object> mapa = new HashMap<>();
        mapa.put(1, vo.getIdProveedor()+"");
        mapa.put(2, vo.getNombreServidor());
        
        boolean a = conexion.executeUpdate(sql, mapa);
        boolean b = eliminarImagenesEnElServidor(vo.getNombreServidor());
        
        return a&&b;
        
    }
    
    public boolean eliminarImagenesEnElServidor(String img){
        FicherosOperacionesServidor ficheros = new FicherosOperacionesServidor(coordinador);
        ficheros.setUrlEliminar(ConexionDatos.ELIMINAR_IMAGEN);
        ficheros.setImagenAEliminar(img);
        return ficheros.eliminarImagen();
    
    }
}
