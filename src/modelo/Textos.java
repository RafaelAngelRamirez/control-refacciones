package modelo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        ls.add("$");
        ls.add("^");
        ls.add("?");
        ls.add("[");
        ls.add("{");
            
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
        String a = String.join("", arreglo);
        System.out.println("[REGEXP]-> "+a);
        return a;
    }
    
    /**
     * Formatea un texto  en base al espacio que se le asigne de manera siguiente:
     * <br>totalEspacio=10
     * <br>texto='Hola'
     * <br>caracter='|'
     * 
     * <br><br>Resultado: <p> "Hola_____|"</p> (El caracter '_' representa un
     * espacio en blanco.)
     * <br>
     * Si el texto supera a el espacio asignado entonces se acortara con '...' 
     * más el caracter de separación asignado
     * 
     * @param totalEspacio El espacio total del que se quitara el string de separación
     * y el tamaño del texto. El mínimo permitido es 5.
     * @param texto
     * @param caracterDeSeparación
     * @return
     */
    public static String formatearEspacios(int totalEspacio, String texto, String caracterDeSeparación){
        try {
            
            if (totalEspacio<5) {
                throw new ExcepcionPersonalizada(
                        "El totalEspacio no puede ser menor que 5.",
                        "Textos",
                        "formatearEspacios()");
            }
            
            if (caracterDeSeparación.length()>1) {
                throw new ExcepcionPersonalizada(
                        "caracterDeSeparación no puede contener más de uno.",
                        "Textos",
                        "formatearEspacios()");
                
            }
            if (caracterDeSeparación.length()<1) {
                throw new ExcepcionPersonalizada(
                        "caracterDeSeparación debe contener por lo menos uno.",
                        "Textos",
                        "formatearEspacios()");
                
            }

        
            String espacio = "";
            String cadenaNueva = "";
            if (totalEspacio>texto.length()) {
                int espaciosEnBlanco = totalEspacio-texto.length();
                for (int i = 0; i < espaciosEnBlanco-1; i++) {
                    espacio+=" ";
                }
                espacio+=(caracterDeSeparación);
                cadenaNueva += texto+espacio;
            }else{
                String subTexto = texto.substring(0, totalEspacio-4);
                
                espacio+="..."+caracterDeSeparación;
                cadenaNueva += subTexto+espacio;

            }

            return cadenaNueva;
        
        } catch (ExcepcionPersonalizada ex) {
            Logger.getLogger(Textos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Formatea una cadena numerica agregando seún el patron que se le pase.
     * Esta basado en decimalFormat.
     * @param numero
     * @return
     */
    public static String formaetarNumeros (int numero, String patron){
    
        DecimalFormat df = new DecimalFormat(patron);
        String resultado  = df.format(numero);
        return resultado;
    
    }
    /**
     * Formatea una cadena numerica agregando seún el patron que se le pase.
     * Esta basado en decimalFormat.
     * @param numero
     * @return
     */
    public static String formaetarNumeros (float numero, String patron){
    
        DecimalFormat df = new DecimalFormat(patron);
        String resultado  = df.format(numero);
        return resultado;
    
    }
    
}
