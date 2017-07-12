/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.conexion;

import controlador.Coordinador;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Sube las imagenes a un servidor apache que se le asigne.
 * @author Particular
 */
public class ImagenesEnElServidor {
    
    private final String subirArchivo = "subearchivo.php";
    private final String eliminarArchivo = "eliminar.php";
    private final String urlDeServidor;
    private String rutaDeArchivoASubir;
    private String rutaDeArchivoAEliminar;
    private Coordinador coordinador;

    String charset = "UTF-8";
    public ImagenesEnElServidor(String urlDeServidor,
            Coordinador coordinador) {
        this.urlDeServidor = "http://"+urlDeServidor;
        this.coordinador = coordinador;
    }

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    

    public void setRutaDeArchivoASubir(String rutaDeArchivoASubir) {
        this.rutaDeArchivoASubir = rutaDeArchivoASubir;
    }

    public void setRutaDeArchivoAEliminar(String rutaDeArchivoAEliminar) {
        this.rutaDeArchivoAEliminar = rutaDeArchivoAEliminar;
    }
    
    public void subirImagen(){
            SubidaPOST multipart;
            try {
                multipart = new SubidaPOST(
                        this.urlDeServidor+this.subirArchivo, this.charset);
                multipart.addFilePart("uploadedfile", 
                        new File(this.rutaDeArchivoASubir));
                // RESPUESTA DEL SERVIDOR
                String respuesta = multipart.finish(); 
                this.getCoordinador().getSystemOut().println("    [WEB]"+respuesta);
            } catch (IOException ex) {
                Logger.getLogger(ImagenesEnElServidor.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
    }
    
    public void eliminarImagen(){
        SubidaPOST multipart;
            try {
                multipart = new SubidaPOST(
                        this.urlDeServidor+this.eliminarArchivo, this.charset);
                multipart.addFormField("uploadedfile", 
                        this.rutaDeArchivoAEliminar);
                // RESPUESTA DEL SERVIDOR
                String respuesta = multipart.finish(); 
                this.getCoordinador().getSystemOut().println("    [WEB]"+respuesta);
            } catch (IOException ex) {
                Logger.getLogger(ImagenesEnElServidor.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
            
    }
}
