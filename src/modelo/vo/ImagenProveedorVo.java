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
        relacionCampo.put(i.getID_PROVEEDOR().getNombre(), ()->this.getIdProveedor());
        relacionCampo.put(i.getNOMBRE_PARA_MOSTRAR().getNombre(), ()->this.getNombreParaMostrar());
        relacionCampo.put(i.getNOMBRE_SERVIDOR().getNombre(), ()->this.getNombreServidor());
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

    @Override
    public String toString() {
       
        
        String a = "Clase: "+this.getClass().getSimpleName()+"\n";
        String b= "       | ";
        String c =  "\n      idProveedor" +b+ idProveedor+
                    "\nnombreParaMostrar" +b+ nombreParaMostrar+
                    "\n   nombreServidor" +b+ nombreServidor+
                    "\n    ficheroImagen" +b+ ficheroImagen.getAbsolutePath()+
                    "\n        urlImagen" +b+ urlImagen.toString();
        String d =  "----------------------";
        return a+d+c+d;

    }
    
    
    
    
    
}
