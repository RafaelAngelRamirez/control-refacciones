
package vista;

import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ExcepcionPersonalizada;

/**
 *
 * @author Particular
 */
public class FechaYHora {
    
    public static final int FECHA_DD_MM_AA = 0;
    
    public static String fechaActual_ddmmaa(){
    
        int dia, mes, anio;
        String diaS, mesS, anioS;

        Calendar cal = Calendar.getInstance();
        dia = cal.get(Calendar.DAY_OF_MONTH);
        mes = cal.get(Calendar.MONTH);
        anio = cal.get(Calendar.YEAR);

        if (dia<10) 
            diaS = "0"+dia;
         else
            diaS = dia+"";

        if (mes<10) 
            mesS = "0"+mes;
            else
            mesS = mes+"";

        anioS = anio+"";
        anioS = anioS.substring(2)+"";

        return diaS+"/"+mesS+"/"+anioS;
    }
    
    
    public static String autoCompletarFecha(String fecha, int formato){
        String a = null;
        
        switch(formato){
            case FECHA_DD_MM_AA:
                autoCompletar_ddmmaa(fecha);
                break;
            default:
        {
            try {
                throw new ExcepcionPersonalizada("El formato para autocompletar la fecha no existe.", "FechaYHora");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(FechaYHora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                        
                break;
        }
        
        return a;
    
    }
    
    
    private static String autoCompletar_ddmmaa(String fecha){
        fecha = "22/11/16";
        
        if () {
            
        }
        
    }
    
}
