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
import modelo.Conexion;
import modelo.ConexionDatos;
import modelo.FicherosOperacionesServidor_;
import modelo.InfoTabla.ImagenRefaccionIT;
import modelo.vo.ImagenRefaccionVo;
/**
 *
 * @author Particular
 */
public class ImagenRefaccionDao extends DAOGenerales{
    
    public ImagenRefaccionDao(Coordinador coordinador) {
        super(coordinador);
    }
    
    public String guardarLista(List<ImagenRefaccionVo> listaVo){
        conexion = new Conexion(coordinador);
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
        for (ImagenRefaccionVo vo : listaVo) {
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
        
        String sql = "INSERT INTO " +ImagenRefaccionIT.NOMBRE_TABLA 
                + " VALUES " + values;
        if (!values.isEmpty()) {
            conexion.executeUpdate(sql, mapa);
            
        }
       
        //SI NO HUBO ERRORES RETORNA NULL
        return retornoErrores;
    }
    
    public boolean subirImagenesAServidor(File img){
        conexion = new Conexion(coordinador);
        FicherosOperacionesServidor_ ficheros = new FicherosOperacionesServidor_(coordinador);
        if (coordinador.isDebugMode()) {
            ficheros.setUrlDeSubida(ConexionDatos.SUBIDA_IMAGEN_PRUEBA);
         } else {
            ficheros.setUrlDeSubida(ConexionDatos.SUBIDA_IMAGEN);
         }
        ficheros.setFichero(img);
        return ficheros.subirFichero();
    
    }
    
    public List<ImagenRefaccionVo> consultar(int id){
        conexion = new Conexion(coordinador);
        List<ImagenRefaccionVo> livo = new ArrayList<>();
        String sql = "SELECT * FROM " + ImagenRefaccionIT.NOMBRE_TABLA 
                + " WHERE " + ImagenRefaccionIT.getID_REFACCION().getNombre() +"= ?";
        ResultSet r = conexion.executeQuery(sql, id+"");

        try {
            while (r.next()) {
                ImagenRefaccionVo v = new ImagenRefaccionVo();
                v.setNombreParaMostrar(r.getString(ImagenRefaccionIT.getNOMBRE_PARA_MOSTRAR().getNombre()));
                v.setNombreServidor(r.getString(ImagenRefaccionIT.getNOMBRE_SERVIDOR().getNombre()));
                v.setIdRefaccion(r.getInt(ImagenRefaccionIT.getID_REFACCION().getNombre()));
                String nombreImagen;
                if (coordinador.isDebugMode()) {
                    nombreImagen = ConexionDatos.IMAGENES_RUTA_COMPLETA_PRUEBA + v.getNombreServidor();
                } else {
                    nombreImagen = ConexionDatos.IMAGENES_RUTA_COMPLETA + v.getNombreServidor();
                }
                URL u = new URL(nombreImagen);
                v.setUrlImagen(u);
                
                livo.add(v);
            }
        } catch (SQLException | MalformedURLException ex) {
            Logger.getLogger(ImagenRefaccionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return livo;
    }
    
    public boolean eliminar (ImagenRefaccionVo vo){
        conexion = new Conexion(coordinador);
        String sql = ImagenRefaccionIT.getNOMBRE_SERVIDOR().getNombre()
                + "DELETE FROM " + ImagenRefaccionIT.NOMBRE_TABLA
                + " WHERE "
                + ImagenRefaccionIT.getID_REFACCION().getNombre()
                + "=?  AND "
                + "=?";
        
        HashMap<Integer, Object> mapa = new HashMap<>();
        mapa.put(1, vo.getIdRefaccion()+"");
        mapa.put(2, vo.getNombreServidor());
        boolean bd = conexion.executeUpdate(sql, mapa);
        boolean servidor = eliminarDeServidor(vo.getNombreServidor());
        if (bd && servidor) {
            return true;
        }
        return false;
    }
    
    public boolean eliminarDeServidor(String img){
        conexion = new Conexion(coordinador);
        FicherosOperacionesServidor_ ficheros = new FicherosOperacionesServidor_(coordinador);
        if (coordinador.isDebugMode()) {
            ficheros.setUrlEliminar(ConexionDatos.ELIMINAR_IMAGEN_PRUEBA);
        } else {
            ficheros.setUrlEliminar(ConexionDatos.ELIMINAR_IMAGEN);
        }
        ficheros.setImagenAEliminar(img);
        if (ficheros.eliminarImagen()) {
            return true;
        }
        System.out.println(ficheros.getRespuesta());
        return false;
    }
    
}
