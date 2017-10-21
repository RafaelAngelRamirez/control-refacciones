package modelo;

/**
 * Esta clase almacena los datos de conexión para acceder más facilmente a ellos. 
 * @author Particular
 */
public class ConexionDatos {
    /**
     * Contraseña de debugueo. Despues hay que cambiar para usar seguridad. 
     */
    public static final String CONTRASENA_SERVIDOR = "continuar";
    /**
     * Usuario con el que se trabajara en la base de datos. 
     */
    public static final String USUARIO_SERVIDOR = "desarrollo";
    /**
     * Dirección del servidor de datos e imagenes. 
     */
    public static final String URL_SERVIDOR = "192.168.1.109/";
    /**
     *La ruta donde se alojaran las imagenes.  
     */
    public static final String CARPETA_IMAGENES_SERVIDOR = "imagenes/";
    /**
     * Nombre de la base de datos. 
     */
    public static final String BD = "controlderefacciones";
    /**
     * Protocolo de conexión actual. 
     */
    public static final String PROTOCOLO = "http://";
    /**
     *El fichero php que recivira las imagenes. 
     */
    public static final String SUBIDA_IMAGEN = PROTOCOLO + URL_SERVIDOR+"$u63_4rc8iv0.php";
    /**
     *El fichero php que elimina la imagen en el servidor. 
     */
    public static final String ELIMINAR_IMAGEN = PROTOCOLO + URL_SERVIDOR+"3l1m1n4r.php";
    /**
     *Ruta para acceder a las imagenes en el servidor.
     */
    public static final String IMAGENES_RUTA_COMPLETA = 
            PROTOCOLO + URL_SERVIDOR +CARPETA_IMAGENES_SERVIDOR;
    
    
    
    //VARIABLES PARA PRUEBAS UNICAMENTE. 
     /**
      *Nombre de la base de datos de prueba. 
      */
    public static final String BD_PRUEBAS = "controlderefacciones_pruebas";
    /**
     *El fichero php que recivira las imagenes. 
     */
    public static final String SUBIDA_IMAGEN_PRUEBA = PROTOCOLO + URL_SERVIDOR+"$u63_4rc8iv0_prueba.php";
    /**
     *La ruta donde se alojaran las imagenes.  
     */
    public static final String CARPETA_IMAGENES_SERVIDOR_PRUEBA = "imagenesPrueba/";
    /**
     *El fichero php que elimina la imagen en el servidor. 
     */
    public static final String ELIMINAR_IMAGEN_PRUEBA = PROTOCOLO + URL_SERVIDOR+"3l1m1n4r_prueba.php";
    /**
     *Ruta para acceder a las imagenes en el servidor.
     */
    public static final String IMAGENES_RUTA_COMPLETA_PRUEBA = 
            PROTOCOLO + URL_SERVIDOR +CARPETA_IMAGENES_SERVIDOR_PRUEBA;
    
}
