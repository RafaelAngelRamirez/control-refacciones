package modelo;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;

/**
 * Operaciones sobre ficheros.
 * @author Particular
 */
public class FicherosOperaciones {
    
    /*
     * Duplica un fichero y lo renombra para . Estos
     * ficheros no son permantes y se borran al terminar la seción de java que
     * que se este ecutando. 
     * 
     * @param fichero
     * @return 
     */
    public static File duplicarYRenombrar(File fichero){
        try {
            //LA RUTA DEL FICHERO ACTUAL.
            String ruta = fichero.getParent();
            //CONVERTIMOS EL NOMBRE DEL FICHERO A UTF-8
            Calendar fecha = Calendar.getInstance();
            int anio = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH);
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
            int hora = fecha.get(Calendar.HOUR_OF_DAY);
            int min = fecha.get(Calendar.MINUTE);
            int seg =fecha.get(Calendar.SECOND);
            int mili = fecha.get(Calendar.MILLISECOND);
            int r = (int)(Math.random()*10000);
            
            String ext = "."+FilenameUtils.getExtension(fichero.getName());
            String nombreDeFichero = "img"+"-"+r+"-"+anio+mes+dia+hora+min+seg+mili+ext;
            
            //CREAMOS EL PATH DEL FICHERO QUE QUEREMOS COPIAR.
            Path path = FileSystems.getDefault().getPath(fichero.getParent(), fichero.getName());
            //CREAMOS EL PATH DONDE COPIAREMOS EL NUEVO FICHERO.
            Path pathDuplicado = FileSystems.getDefault().getPath(ruta, nombreDeFichero);
            //CREAMOS LA INSTANCIA DEL FICHERO PARA COMPROBAR SI EXISTE. 
            File ficheroRenombrado = new File(ruta+System.getProperty("file.separator")+nombreDeFichero);
            
            //SI NO EXSTE LO COPIAMOS.
            Files.copy(path, pathDuplicado);
            //LO CAPTURAMOS CON LA INSTANCIA QUE SEÑALA A EL Y LO BORRAMOS
            // AL SALIR DEL PROGRAMA.
            ficheroRenombrado.deleteOnExit();
            //RETORNAMOS EL FICHERO.
            return ficheroRenombrado;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FicherosOperaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FicherosOperaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
