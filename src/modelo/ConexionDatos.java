package modelo;

/**
 * Esta clase almacena los datos de conexión para acceder más facilmente a ellos. 
 * @author Particular
 */
public class ConexionDatos {
    /**
     * Contraseña de debugueo. Despues hay que cambiar para usar seguridad. 
     */
//    public static final String CONTRASENA_SERVIDOR = "";
    public static final String CONTRASENA_SERVIDOR = "continuar";
    /**
     * Usuario con el que se trabajara en la base de datos. 
     */
//    public static final String USUARIO_SERVIDOR = "root";
    public static final String USUARIO_SERVIDOR = "desarrollo";
    /**
     * Dirección del servidor de datos e imagenes. 
     */
    public static final String URL_SERVIDOR = "192.168.1.73/";
//    public static final String URL_SERVIDOR = "187.152.42.1/";
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
    
}
