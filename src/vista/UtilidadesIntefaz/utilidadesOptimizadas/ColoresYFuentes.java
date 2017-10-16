/**
 * MANEJO DE COLORES PARA LA INTERFAZ
 */
package vista.UtilidadesIntefaz.utilidadesOptimizadas;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Particular
 */
public class ColoresYFuentes {
    
    /**
     * Fuente de los menus de la ventana principal.
     * 
     */
    public static final Font FUENTE_MENU = new Font("Calibri light", Font.BOLD, 15);

    /**
     * Fuente para los item del menu de la ventana principal. 
     */
    public static final Font FUENTE_MENU_ITEM = new Font("Calibri light", Font.PLAIN, 18);

    /**
     * Fuente para la fecha y hora de la ventana principal 
     */
    public static final Font FUENTE_FECHA_Y_HORA = new Font("Calibri light", Font.PLAIN, 20);
    
    /**
     * Fuente que permite ver alineado el texto tipo consola.  
     */
    public static final Font FUENTE_ALINEADA = new Font("Lucida Console", Font.PLAIN, 15);
    
    /**
     * Fuente cuadro de texto normal.  
     */
    public static final Font FUENTE_CUADRO_TEXTO_NORMAL= new Font("Calibri light", Font.PLAIN, 18);
    
    
    
    //COLORES PARA ERRORES.

    /**
     * Color de fondo de errores resaltados. 
     */
    public static final Color ERROR_TXT_RESALTAR_BG = new Color(249,83,83);

    /**
     * Color de letra de errores resaltados. 
     */
    public static final Color ERROR_TXT_RESALTAR_FG = new Color(255,250,85);
    
    
    //COLORES RETORNO DE ERROR - BASICOS

    /**
     * Color de fondo de letras. 
     */
    public static final Color TEMA_TXT_BG = new Color(69,73,74);

    /**
     *Color de tema de letra??
     */
    public static final Color TEMA_TXT_FG = new Color(187,187,187);
    
    /**
     * Color de fondo del tema. No se donde lo estoy usando. 
     */
    public static final Color TEMA_FONDO_BG = new Color(60,63,65);
    
    /**
     * Color de fondo etiquetas oscuras 1
     */
    public static final Color TEMA_FONDO_ETIQUETAS_OSCURO = new Color(51,51,51);
    
    //VISOR DE IMAGENES.

    /**
     * Color de fondo del visor de imagenes. 
     */
    public static final Color TEMA_VISOR_DE_IMAGENES = TEMA_TXT_BG;
    
    /**
     * Gris muy oscuro para los menus. 
     */
    public static final Color TEMA_FONDO_OSCURO = new Color(30,30,30);
    
    
}
