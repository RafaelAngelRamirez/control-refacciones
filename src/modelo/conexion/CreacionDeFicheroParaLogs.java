/**
 * En esta clase hay que crear los ficheros que necesarios para guardar los logs
 * que no se pueden almacenar en la base de datos.
 */
package modelo.conexion;

import controlador.Coordinador;
import controlador.capturadeerrores.CapturaDeSucesos;
import controlador.capturadeerrores.DescripcionDeSuceso;
import javax.swing.JOptionPane;
/**
 *
 * @author Particular
 */
public class CreacionDeFicheroParaLogs {
    
    Coordinador controlador;
    
    public CreacionDeFicheroParaLogs(Coordinador controlador) {
        this.controlador = controlador;
    }
    private void cargarOCrearArchivo(){
        
    }
    
    
    public void guardarLogEnFichero(DescripcionDeSuceso suceso){
        JOptionPane.showMessageDialog(null, "Pendiente implementar"+
                this.getClass().getName());
        
    }
    
}

