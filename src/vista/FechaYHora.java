
package vista;

import java.util.Calendar;

/**
 *
 * @author Particular
 */
public class FechaYHora {

    public static String fechaActual_ddmmaa(){
    
        int dia, mes, anio;
        String diaS, mesS, anioS;

        Calendar cal = Calendar.getInstance();
        dia = cal.get(Calendar.DAY_OF_MONTH);
        mes = cal.get(Calendar.DAY_OF_MONTH);
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
        anioS = anioS.substring(1)+"";

        return diaS+"/"+mesS+"/"+anioS;
    }
    
}
