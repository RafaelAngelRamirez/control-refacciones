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
import javax.swing.JOptionPane;

/**
 *
 * @author Particular
 */
public class FicherosEnServidor {
    
    String charset = "UTF-8";
    String urlDeSubida;
    File ficheroASubir;
    String respuesta;
    
    String nombreDeCampoPostSubir = "subirArchivo";
    Coordinador controlador;

    public FicherosEnServidor(Coordinador controlador) {
        this.controlador = controlador;
    }
    
    public void setUrlDeSubida(String urlDeSubida) {
        this.urlDeSubida = urlDeSubida;
    }

    public void setFicheroASubir(File ficheroASubir) {
        this.ficheroASubir = ficheroASubir;
    }
    
    public boolean subirFichero(){
        try {
            SubidaPOST subida = new SubidaPOST(this.urlDeSubida, this.charset);
            subida.addFilePart(nombreDeCampoPostSubir, ficheroASubir);
            String r = subida.finish();
            if(r.contains("-$1")){
                this.respuesta = r.replace("-$1", "");
                return true;
            }else{
                this.respuesta = r;
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(FicherosEnServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public String getRespuesta() {
        return respuesta;
    }
   
    
    
    
}
