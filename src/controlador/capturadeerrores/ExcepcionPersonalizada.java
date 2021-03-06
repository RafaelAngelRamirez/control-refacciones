
package controlador.capturadeerrores;


/**
 *
 * @author Particular
 */
public class ExcepcionPersonalizada extends Exception {

    private static final long serialVersionUID = 1L;
    
    
    
    /**
     * Exception estandar para los errores de programación.
     * 
     * @param mensaje - El mensaje que mostrara la consola de errores.
     * @param nombreClase - La clase qe lo manda.
     */
    public ExcepcionPersonalizada(String mensaje, Object nombreClase ) {
        super(
        "\n[-][-][-][-][-][-][-][-][-][-][-][-][-]\n\n"+        
        "[ERROR] Hay muchachito!! \n"+       
        "        "+mensaje +"\n\n"+
        "       Clase -> "+nombreClase.getClass().getName()+
        "\n\n[-][-][-][-][-][-][-][-][-][-][-][-][-]\n\n"
        );
        
    }
    
    /**
     * Exception estandar para los errores de programación con variacion en el nombre de la case..
     * 
     * @param mensaje - El mensaje que mostrara la consola de errores.
     * @param nombreClase - La clase qe lo manda.
     */
    public ExcepcionPersonalizada(String mensaje, String nombreClase ) {
        super(
        "\n[-][-][-][-][-][-][-][-][-][-][-][-][-]\n\n"+        
        "[ERROR] Hay muchachito!! \n"+       
        "        "+mensaje +"\n\n"+
        "       Clase -> "+nombreClase+
        "\n\n[-][-][-][-][-][-][-][-][-][-][-][-][-]\n\n"
        );
        
    }
     
    /**
     * Excepcion con descripcion de función. 
     * 
     * @param mensaje - El mensaje a mostrar.
     * @param clase - El objeto this de la clase.
     * @param metodo - El string del metodo.
     */
     public ExcepcionPersonalizada(String mensaje, Object clase, String metodo ) {
        super(
        "\n[-][-][-][-][-][-][-][-][-][-][-][-][-]\n\n"+        
        "[ERROR] Hay muchachito!! \n"+       
        "        "+mensaje +"\n\n"+
        "       CLASE  -> "+clase.getClass().getName()+"\n"+
        "       METODO -> "+metodo+        
        "\n\n[-][-][-][-][-][-][-][-][-][-][-][-][-]\n\n"
        );
    } 
}
