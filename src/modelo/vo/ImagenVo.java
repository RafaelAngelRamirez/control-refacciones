/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import java.io.File;
import java.net.URL;
import modelo.InfoTabla.ImagenIT;

/**
 *
 * @author Particular
 */
public class ImagenVo extends VoGenerales{
    int idRefaccion;
    String nombreParaMostrar;
    String nombreServidor;
    File ficheroImagen;
    URL urlImagen;

    public ImagenVo() {
        ImagenIT i = new ImagenIT();
        relacionCampo.put(i.getIdRefaccionPDC().getNombre(), ()->this.getIdRefaccion());
        relacionCampo.put(i.getNombreParaMostarPDC().getNombre(), ()->this.getNombreParaMostrar());
        relacionCampo.put(i.getNombreServidorPDC().getNombre(), ()->this.getNombreServidor());
    }

    public String getNombreServidor() {
        return nombreServidor;
    }

    public void setNombreServidor(String nombreServidor) {
        this.nombreServidor = nombreServidor;
    }
    

    public URL getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(URL urlImagen) {
        this.urlImagen = urlImagen;
    }

    public File getFicheroImagen() {
        return ficheroImagen;
    }

    public void setFicheroImagen(File ficheroImagen) {
        this.ficheroImagen = ficheroImagen;
    }
    
    public int getIdRefaccion() {
        return idRefaccion;
    }

    public void setIdRefaccion(int idRefaccion) {
        this.idRefaccion = idRefaccion;
    }

    public String getNombreParaMostrar() {
        return nombreParaMostrar;
    }

    public void setNombreParaMostrar(String nombreParaMostrar) {
        this.nombreParaMostrar = nombreParaMostrar;
    }
    
    
            
}
