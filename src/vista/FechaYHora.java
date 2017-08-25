
package vista;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ExcepcionPersonalizada;

/**
 * Esta clase gestiona todo lo relacionado con el formato de horas y tiempo. 
 * @author Particular
 */

public class FechaYHora {
   
    
    public static final int FECHA_DD_MM_AA = 0;
    private static final Calendar CALENDAR = Calendar.getInstance();
    private static String mantener="";
    private static String caracterDeSeparacion="/";
    protected FechaYHora() {
    }
    
    
    
    public static class Actual{
        private static String dd, ddmmaa, mm, hora, minutos, segundos, hhmm, hhmmss;
       
        
        private static final int diaDelMes = CALENDAR.get(Calendar.DAY_OF_MONTH);
        private static final int diaDelAnio = CALENDAR.get(Calendar.DAY_OF_YEAR);
        private static final int mes = CALENDAR.get(Calendar.MONTH)+1;
        private static final int anio = CALENDAR.get(Calendar.YEAR);
        private static final int diaDeLaSemana = CALENDAR.get(Calendar.DAY_OF_WEEK);
        
        
        
        
        
        private static final HashMap<Integer, String > diasDeLaSemana = new HashMap<>();
        private static final HashMap<Integer, String > mesesDelAnio = new HashMap<>();
        
        static{
            
            
            diasDeLaSemana.put(1, "domingo");
            diasDeLaSemana.put(2, "lunes");
            diasDeLaSemana.put(3, "martes");
            diasDeLaSemana.put(4, "miercoles");
            diasDeLaSemana.put(5, "jueves");
            diasDeLaSemana.put(6, "viernes");
            diasDeLaSemana.put(7, "sábado");
            
            mesesDelAnio.put(1, "enero");
            mesesDelAnio.put(2, "febrero");
            mesesDelAnio.put(3, "marzo");
            mesesDelAnio.put(4, "abril");
            mesesDelAnio.put(5, "mayo");
            mesesDelAnio.put(6, "junio");
            mesesDelAnio.put(7, "julio");
            mesesDelAnio.put(8, "agosto");
            mesesDelAnio.put(9, "septiembre");
            mesesDelAnio.put(10, "octubre");
            mesesDelAnio.put(11, "noviembre");
            mesesDelAnio.put(12, "diciembre");
            
            //EL NUMERO DE DIAS FORMATEADO
            if (diaDelMes<10) 
                dd = "0"+diaDelMes;
            else
                dd = diaDelMes+"";
            
            //EL NUMERO DE MES FORMATEADO. 
            if (mes<10) 
                mm = "0"+mes;
                else
                mm = mes+"";
        }
        
        private static final String diaCompleto = diasDeLaSemana.get(diaDeLaSemana);
        private static final String diaDDD = diaCompleto.substring(0, 3);
        private static final String mesCompleto = mesesDelAnio.get(mes);
        private static final String mesMMM = mesCompleto.substring(0,3);
        private static final String dia_dd_mes_anio = diaCompleto +", "+diaDelMes + " de " + mesCompleto +" de " + anio;
        private static final String anioAA = (anio+"").substring(2);

        /**
         * Retona los dos últimos digitos del año.
         * @return Los dos últimos digitos del año.
         */
        public static String getAnioAA() {
            return anioAA;
        }
        
        /**
         * Retorna el nombre compoleto del mes. 
         * @return Cadena con el nombre completo del mes. 
         */
        public static String getMesCompleto() {
            return mesCompleto;
        }

        /**
         * Retorna el mes con el formato MMM (ene, feb, mar, etc).
         * @return La cadena con el mes formateado. 
         */
        public static String getMesMMM() {
            return mesMMM;
        }

        /**
         * Retorna la fecha con el formato 'Lunes, ## de #### de 20##'.
         * @return La cadena con la fecha formateada. 
         */
        public static String getFecha_Dia_dd_mes_anio() {
            return dia_dd_mes_anio;
        }
        
        /**
         * Retorna el día del mes. 
         * @return El número que corresponde al día del mes. 
         */
        public static int getDiaDelMes() {
            return diaDelMes;
        }

        /**
         * Retorna el dia del mes formateado 0#, ##.
         * @return El día de la semana formateado. 
         */
        public static String getDia_dd() {
            return dd;
        }
              

        /**
         * Retorna el númeo que corresponde al día del año. 
         * @return El día del año. 
         */
        public static int getDiaDelAnio() {
            return diaDelAnio;
        }

        /**
         * Retorna el número del mes actual. 
         * @return El número del mes actual. 
         */
        public static int getMes() {
            return mes;
        }
        /**
         * Retorna el número del mes actual formateado como 0#, ##. 
         * @return El número del mes actual. 
         */
        public static String getMes_mm() {
            return mm;
        }

        /**
         * Retorna el año actual. 
         * @return
         */
        public static int getAnio() {
            return anio;
        }

        /**
         * Retorna el número de día de la semana. 
         * @return El número del día de la semana. 
         */
        public static int getDiaDeLaSemana() {
            return diaDeLaSemana;
        }

        /**
         * Rertorna el nombre del día complet. 
         * @return El nombre del día completo. 
         */
        public static String getDiaCompleto() {
            return diaCompleto;
        }

        /**
         * Retorna el día formateado como (lun, mart, mier, etc).
         * @return El día formateado. 
         */
        public static String getDiaDDD() {
            return diaDDD;
        }
        
        /**
         * Retorna la fecha actual en formato dd/mm/aa.
         * @return La fecha actual formateada. 
         */
        public static String getFecha_Ddmmaa(){
            return getDdmmaa(FechaYHora.caracterDeSeparacion);
        }
        
        /**
         * Retorna la fecha actual con el formato dd#mm#aa. El caracter de separación
         * se puede definir pero solo aceptara uno. Si se reciven dos maraca error.
         * @param caracterDeSeparacion El caracter que se mostrara como separación. 
         * @return
         */
        public static String getDdmmaa(String caracterDeSeparacion) {
                try {
                    if (caracterDeSeparacion.length()>1) {
                            throw new ExcepcionPersonalizada("Solo se permite un caracter de separación.\n \tSe definio: "+caracterDeSeparacion,"FechaYHora");
                    }
                    
                    FechaYHora.caracterDeSeparacion=caracterDeSeparacion;
                   

                    ddmmaa = getDia_dd()+FechaYHora.caracterDeSeparacion+mm+FechaYHora.caracterDeSeparacion+anioAA;
                } catch (ExcepcionPersonalizada ex) {
                    Logger.getLogger(FechaYHora.class.getName()).log(Level.SEVERE, null, ex);
                }

            return ddmmaa;
        }
        
        /**
         * Retorna la hora actual en formato 24HRS.
         * @return String de la hora actual. 
         */
        public static String getHora() {
            Date date = new Date();
            DateFormat horaFormateada = new SimpleDateFormat("HH");
            hora = horaFormateada.format(date);
            return hora;
        }

        /**
         *
         * @return
         */
        public static String getMinutos() {
            Date date = new Date();
            DateFormat horaFormateada = new SimpleDateFormat("mm");
            minutos = horaFormateada.format(date);
            return minutos;
        }
        
        public static String getSegundos(){
            Date date = new Date();
            DateFormat horaFormateada = new SimpleDateFormat("ss");
            segundos = horaFormateada.format(date);
            return segundos;
        }

        public static String getHora_Hhmm() {
            Date date = new Date();
            DateFormat horaFormateada = new SimpleDateFormat("HH:mm");
            hhmmss = horaFormateada.format(date);
            return hhmm;
        }

        public static String getHora_Hhmmss() {
            Date date = new Date();
            DateFormat horaFormateada = new SimpleDateFormat("HH:mm:ss");
            hhmmss = horaFormateada.format(date);
            return hhmmss;
        }
    }
    
    /**
     * Según el formato del texto que se le pasa ayuda a autocompletar la fecha
     * retornando la predicción más posible según el formato escogído. 
     * @param fecha
     * @param formato
     * @return
     */
    public static String autoCompletarFecha(String fecha, int formato){
        String a = null;
        
        switch(formato){
            case FECHA_DD_MM_AA:
                return autoCompletar_ddmmaa(fecha);
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
        if (mantener.length()>fecha.length()) {
            //NO HACEMOS NADA POR QUE ESTAMOS BORRANDO.
            mantener = fecha;
            return mantener;
        }
        
        if (fecha.length()==1) {
            if (fecha.equals(Actual.getDiaDelMes()+"")) {
                mantener = Actual.getDia_dd();
                return mantener;
            }
            mantener = fecha;
            return mantener;
        }
        
        if (fecha.length()==2) {
            mantener = fecha+caracterDeSeparacion;
            return mantener;
        }
        
        if (fecha.length()==4) {
            if (fecha.split("")[3].equals(caracterDeSeparacion)) {
                mantener=fecha.substring(0, 3);
                return mantener;
            }
            String a = fecha.split(caracterDeSeparacion)[1];
            if (a.equals(Actual.getMes()+"")) {
                mantener = fecha.split(caracterDeSeparacion)[0]
                        +caracterDeSeparacion+Actual.getMes_mm()
                        +caracterDeSeparacion+Actual.anioAA;
                return mantener;
            }
            
            if (!a.equals("1")&& !a.equals(caracterDeSeparacion)&& !a.equals("0")) {
                mantener = fecha.split(caracterDeSeparacion)[0]
                        +caracterDeSeparacion+"0"+a
                        +caracterDeSeparacion+Actual.anioAA;
                return mantener;
            }
        }
        
        if (fecha.length()==5) {
            JOptionPane.showMessageDialog(null, "entro aquiiiiii");
            if (true) {
                
            }
            
            
            
            
            
            String a = fecha.split("")[4];
            List<String> n = new ArrayList<>();
            n.add("0");
            n.add("1");
            n.add("2");
           
            if (n.contains(a)) {
                mantener = fecha
                        +caracterDeSeparacion+Actual.anioAA;
            }else{
                mantener = a;
                return mantener;
            }
            
        }
        
        
        mantener = fecha;
        return mantener;
    }
    
}
