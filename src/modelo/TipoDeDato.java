
package modelo;

import java.time.LocalDate;

/**
 *  Comprueba el tipo de dato que se le pase como String y diferencia entre Integer,
 * Float, Double, Date, Timestamp. Despues retorna una cadena con 
 * 
 * @author Rafael Ramírez
 */
public class TipoDeDato {
    /**
     *El tipo de dato es String. 
     */
    public static final int STRING = 0;
    /**
     *El tipo de dato es entero. 
     */
    public static final int INTEGER = 1;
    /**
     *El tipo de dato es float. 
     */
    public static final int FLOAT = 2;
    /**
     *El tipo de dato es double. 
     */
    public static final int DOUBLE = 3;
    /**
     *El tipo de dato es Date. 
     */
    public static final int DATE = 4;
    /**
     *El tipo de dato es Timestamp. 
     */
    public static final int TIMESTAMP = 5;
    
    
    /**
     * Retorna el tipo de dato contenido en el string que se le pase. Para este
     * fin intenta convertir la cadena por varios métodos a Integer, Float, Double,
     * Date, y Timestamp. Según la coincidencia que encuentre retorna el valor
     * en una variable estatica.
     * @param dato La cadena de texto de la que se quiere comprobar el tipo de dato que es. 
     * @return El tipo de dato menos general <b>(int) </b> al más general <b>(String)</b>
     */
    public static int encontrarTipoDeDato(String dato){
        if (isInteger(dato)) {
            return INTEGER;
        }
        if (isFloat(dato)) {
            return FLOAT;
        }
        if (isDouble(dato)) {
            return DOUBLE;
        }
        if (isDate(dato)) {
            return DATE;
        }
        if (isTimestamp(dato)) {
            return TIMESTAMP;
        }
        
        return STRING;
    }
    
    private static boolean isTimestamp(String dato){
        try {
            java.sql.Timestamp.valueOf(dato);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private static boolean isDate(String dato){
        try {
            java.sql.Date.valueOf(dato);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private static boolean isInteger(String dato){
        try {
            Integer.parseInt(dato);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private static boolean isFloat(String dato){
        try {
            String a = Float.parseFloat(dato)+"";
            if (a.equals("Infinity")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private static boolean isDouble(String dato){
        try {
            String a =Double.parseDouble(dato)+"";
            if (a.equals("Infinity")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    
    }
    
    
    
}
