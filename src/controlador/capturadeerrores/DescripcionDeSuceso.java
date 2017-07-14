package controlador.capturadeerrores;

import javax.swing.JFrame;


/**
 * Ayuda a manejar la información de un tipo de error para que la clase 
 * CapturaDeErrores haga lo suyo.
 * @author Particular
 */
public class DescripcionDeSuceso {
    
    private String mensajeDeError;
    private String detallesDelError;
    private int tipoDeError;
    private String ubicacion;
    public final TipoDeSucesoOErrores tipoDeSucesoOErrores = new TipoDeSucesoOErrores();
    private JFrame padreJFrame;

     /**
     * Retorna el padre que se le asignara al mensaje a mostrar.
     * @return Retorna el padre para el mensaje. 
     */
    public JFrame getPadreJFrame() {
        return padreJFrame;
    }

     /**
     * Retorna el nombre de la clase desde donde se ejecuto el suceso.
     * @param padreJFrame
     */
    public void setPadreJFrame(JFrame padreJFrame) {
        this.padreJFrame = padreJFrame;
    }
    
    /**
     * Retorna el nombre de la clase desde donde se ejecuto el suceso.
     * @return
     */
    public String getUbicacion() {
        return ubicacion;
    }
   
    /**
     * Define el nombre de la clase. 
     * @param ubicacion La clase de la que se va a obtener el dato. This.
     */
    public void setUbicacion(Object ubicacion) {
        this.ubicacion = ubicacion.getClass().getName();
    }

    /**
     * El mensaje de error que se mostrara.
     * @return
     */
    public String getMensajeDeError() {
        return mensajeDeError;
    }

    /**
     *Define el mensaje de error a mostrar.
     * @param mensajeDeError
     */
    public void setMensajeDeError(String mensajeDeError) {
        this.mensajeDeError = mensajeDeError;
    }

    /**
     * Detalles del error que solo se mostraran en la consola.
     * @return
     */
    public String getDetallesDelError() {
        return detallesDelError;
    }

    /**
     * Define los detalles del error que solo se mostrar en la consola
     * @param detallesDelError
     */
    public void setDetallesDelError(String detallesDelError) {
        this.detallesDelError = detallesDelError;
    }

    
    /**
     * Retorna el tipo de errror dentro del que hemos clasifica el error. 
     * Todos los errores estan dentro de @TipoDeError. De manera que podamos
     * modificar ciertas caracteristicas del error sin perder su relación.
     * @return
     */
    public int getTipoDeError() {
        return tipoDeError;
    }

    /**
     *Define el tipo de error. Es neceario crear un objeto @TipoDeError para 
     * extraer los errores preestablecidos. 
     * @param tipoDeError
     */
    public void setTipoDeError(int tipoDeError) {
        this.tipoDeError = tipoDeError;
    }
}
