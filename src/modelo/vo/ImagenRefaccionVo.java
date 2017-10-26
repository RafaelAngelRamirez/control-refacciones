/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import java.io.File;
import java.net.URL;
import modelo.InfoTabla.ImagenRefaccionIT;

/**
 *
 * @author Particular
 */
public class ImagenRefaccionVo extends VoGenerales{
    private int idRefaccion;
    private String nombreParaMostrar;
    private String nombreServidor;
    private File ficheroImagen;
    private URL urlImagen;

    public ImagenRefaccionVo() {
        ImagenRefaccionIT i = new ImagenRefaccionIT();
        relacionCampo.put(i.getID_REFACCION().getNombre(), ()->this.getIdRefaccion());
        relacionCampo.put(i.getNOMBRE_PARA_MOSTRAR().getNombre(), ()->this.getNombreParaMostrar());
        relacionCampo.put(i.getNOMBRE_SERVIDOR().getNombre(), ()->this.getNombreServidor());
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

    @Override
    public String toString() {
        return "IMAGEN REFACCION VO:"+
            "\n       idRefaccion"+ idRefaccion+
            "\n nombreParaMostrar"+ nombreParaMostrar+
            "\n    nombreServidor"+ nombreServidor+
            "\n     ficheroImagen"+ ficheroImagen+
            "\n         urlImagen"+ urlImagen;
    }
    
    
            
}
