/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import java.io.File;
import java.net.URL;
import modelo.InfoTabla.ImagenProveedorIT;

/**
 *
 * @author Particular
 */
public class ImagenProveedorVo extends VoGenerales{
    
    private int idProveedor;
    private String nombreParaMostrar;
    private String nombreServidor;
    private File ficheroImagen;
    private URL urlImagen;
    
     public ImagenProveedorVo() {
        ImagenProveedorIT i = new ImagenProveedorIT();
        relacionCampo.put(i.getIdProveedorPDC().getNombre(), ()->this.getIdProveedor());
        relacionCampo.put(i.getNombreParaMostarPDC().getNombre(), ()->this.getNombreParaMostrar());
        relacionCampo.put(i.getNombreServidorPDC().getNombre(), ()->this.getNombreServidor());
    }
    
    
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreParaMostrar() {
        return nombreParaMostrar;
    }

    public void setNombreParaMostrar(String nombreParaMostrar) {
        this.nombreParaMostrar = nombreParaMostrar;
    }

    public String getNombreServidor() {
        return nombreServidor;
    }

    public void setNombreServidor(String nombreServidor) {
        this.nombreServidor = nombreServidor;
    }

    public File getFicheroImagen() {
        return ficheroImagen;
    }

    public void setFicheroImagen(File ficheroImagen) {
        this.ficheroImagen = ficheroImagen;
    }

    public URL getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(URL urlImagen) {
        this.urlImagen = urlImagen;
    }
    
    
    
    
    
}
