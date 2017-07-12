package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Particular
 */
public class Textos {
    
    /**
     * Retorna solo letras de la cadea que se le pase.  
     */
    public static String soloLetras(String texto){
        String nuevoTesto = "";
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (Character.isAlphabetic(c) || Character.isWhitespace(c)) {
                nuevoTesto += ""+c;
            }
        }       
        return nuevoTesto;
    }
    
    /**
     * Retorna solo números dentro de una cadena de texto.  
     */
    public static String soloNumeros(String texto){
        String nuevoTesto = "";
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (Character.isDigit(c)) {
                nuevoTesto += ""+c;
            }
        }       
        return nuevoTesto;
    }
    
    /**
     * Escapa los caractéres que puedan impedir el funcionamiento del REGEXP.
     * 
     */
    public static String especialREGEX(String texto){
        List<String> ls = new ArrayList<>();
        ls.add("+");
        ls.add("|");
        ls.add("/");
        ls.add("*");
        ls.add(".");
        String[] arreglo = texto.split("");
        for (int i = 0; i < arreglo.length; i++) {
            for (String simbolo : ls) {
                if (simbolo.equals(arreglo[i])) {
                    System.out.println("sustitucion:" + simbolo);
                    arreglo[i] = "\\\\"+arreglo[i];
                    break;
                }
            }
        }       
        return String.join("", arreglo);
    
    }
    
    
}
