    
package controlador.capturadeerrores;

/**
 * Retorna un código de error para los diferntes sucesos de error capturado.
 *   
 * @author Particular
 */
public class TipoDeSucesoOErrores {
    //ERROR FATAL EMPIEZA EN 1.
    public final int ERROR_FATAL = 0;
    
    // ERRORES DE BASE DE DATOS.
    public final int BD_ERROR_DE_CONEXION_EN_INICIO_BD = 1;
    public final int BD_ERROR_AL_EJECUTAR_SENTENCIA = 2;
    public final int BD_ERROR_OBTENIENDO_USUARIO_Y_CONTRASENA_DE_LA_BD = 3;
    
    //GESTIOS DE USUARIOS.
    public final int USUARIOS_O_CONTRASENA_INCORRECTA = 4;
    public final int USUARIOS_NO_EXISTE_EL_USUARIO = 5;
    public final int USUARIOS_EL_USUARIO_NO_TIENE_PERMISO_PARA_EJECUTAR_LA_ACCION =6;
    
    
    public final int SEGURIDAD_INTENTO_DE_SQL_INJECTION = 9000;
    public final int SEGURIDAD_POSIBLE_INTENTO_DE_FUERZA_BRUTA=9001;
}
