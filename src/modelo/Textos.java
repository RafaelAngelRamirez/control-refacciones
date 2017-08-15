package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Particular
 */
public class Textos {
    
    /**
     * Retorna solo letras de la cadena que se le pase.  
     * @param texto El texto que se quiere filtrar.
     * @return La cadena limpia de cualquier cosa que no coincida con 
     * Character.isAlphabetic(c) || Character.isWhitespace(c)
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
     * @param texto El texo que se quiere filtrar. 
     * @return  El String que del que se quieren eliminar cualquier cosa que 
     * no coincida con Character.isDigit(c)
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
     * @param texto El texto que será utilizado en REGEXP.
     * @return La cadena con los caracteres escapados que pudieran perjudijar el 
     * REGEXP.
     */
    public static String especialREGEX(String texto){
        List<String> ls = new ArrayList<>();
        ls.add("+");
        ls.add("|");
        ls.add("/");
        ls.add("*");
        ls.add(".");
        ls.add("'");
        ls.add("\\");
        ls.add("(");
        ls.add(")");
        ls.add("`");
        String[] arreglo = texto.split("");
        for (int i = 0; i < arreglo.length; i++) {
            for (String simbolo : ls) {
                if (simbolo.equals(arreglo[i])) {
                    System.out.println(
                              " ------------------------\n"
                            + " [REGEXP]sustitucion:" + simbolo+"\n"
                            + " ------------------------");
                    arreglo[i] = "\\\\"+arreglo[i];
                    break;
                }
            }
        }       
        return String.join("", arreglo);
    }
}
