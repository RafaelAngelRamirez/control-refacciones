
package modelo.InfoTabla;


import java.util.ArrayList;
import java.util.List;
import modelo.ParametrosDeCampo;


/**
 *
 * @author Particular
 */
public class SalidaLoteIT extends ITGenerales{
    /*
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "salidalote";
    
    private static final ParametrosDeCampo ID = new ParametrosDeCampo();
    private static final ParametrosDeCampo FECHA_SALIDA_LOTE = new ParametrosDeCampo();
    private static final ParametrosDeCampo CANTIDAD = new ParametrosDeCampo();
    private static final ParametrosDeCampo ID_REFACCION = new ParametrosDeCampo();
    private static final ParametrosDeCampo ID_EMPLEADO = new ParametrosDeCampo();
    private static final ParametrosDeCampo OBSERVACIONES = new ParametrosDeCampo();
    private static final ParametrosDeCampo ID_LOTE = new ParametrosDeCampo();
    

    
    /**
     * Los campos de la tabla. 
     */
    private static final List<ParametrosDeCampo> CAMPOS_PDC = new ArrayList<>();

    public static List<ParametrosDeCampo> getCAMPOS_PDC() {
        return CAMPOS_PDC;
    }
    
    static {
        ID.setNombre("id");
        ID.setLongitudDeCaracteres(11);
        ID.setTipoDeDatos("int");
        ID.setNulo(false);
        ID.setAutoIncrement(true);
        ID.setPermiteRepetido(false);

        FECHA_SALIDA_LOTE.setNombre("fechaSalidaLote");
        FECHA_SALIDA_LOTE.setNombreParaMostrar("Fecha de Lote");
        FECHA_SALIDA_LOTE.setLongitudDeCaracteres(8);
        FECHA_SALIDA_LOTE.setTipoDeDatos("date");
        FECHA_SALIDA_LOTE.setNulo(false);
        FECHA_SALIDA_LOTE.setAutoIncrement(false);
        FECHA_SALIDA_LOTE.setPermiteRepetido(true);

        CANTIDAD.setNombre("cantidad");
        CANTIDAD.setNombreParaMostrar("Cantidad que sale");
        CANTIDAD.setTipoDeDatos("float");
        CANTIDAD.setLongitudDeCaracteres(10);
        CANTIDAD.setLongitudDeDecimales(3);
        CANTIDAD.setNulo(false);
        CANTIDAD.setAutoIncrement(false);
        CANTIDAD.setPermiteRepetido(true);

        ID_REFACCION.setNombre("idRefaccion");
        ID_REFACCION.setNombreParaMostrar("Nombre de la refacción");
        ID_REFACCION.setLongitudDeCaracteres(11);
        ID_REFACCION.setTipoDeDatos("int");
        ID_REFACCION.setNulo(false);
        ID_REFACCION.setAutoIncrement(false);
        ID_REFACCION.setPermiteRepetido(true);
        
        ID_LOTE.setNombre("idLote");
        ID_LOTE.setNombreParaMostrar("Lote");
        ID_LOTE.setLongitudDeCaracteres(11);
        ID_LOTE.setTipoDeDatos("int");
        ID_LOTE.setNulo(false);
        ID_LOTE.setAutoIncrement(false);
        ID_LOTE.setPermiteRepetido(true);

        ID_EMPLEADO.setNombre("idEmpleado");
        ID_EMPLEADO.setNombreParaMostrar("Nombre del empleado");
        ID_EMPLEADO.setLongitudDeCaracteres(11);
        ID_EMPLEADO.setTipoDeDatos("int");
        ID_EMPLEADO.setNulo(false);
        ID_EMPLEADO.setAutoIncrement(false);
        ID_EMPLEADO.setPermiteRepetido(true);
        
        OBSERVACIONES.setNombre("observaciones");
        OBSERVACIONES.setNombreParaMostrar("Observaciones");
        OBSERVACIONES.setLongitudDeCaracteres(200);
        OBSERVACIONES.setTipoDeDatos("varchar");
        OBSERVACIONES.setNulo(true);
        OBSERVACIONES.setAutoIncrement(false);
        OBSERVACIONES.setPermiteRepetido(true);
        
        CAMPOS_PDC.add(ID);
        CAMPOS_PDC.add(FECHA_SALIDA_LOTE);
        CAMPOS_PDC.add(CANTIDAD);
        CAMPOS_PDC.add(ID_REFACCION);
        CAMPOS_PDC.add(ID_EMPLEADO);
        CAMPOS_PDC.add(OBSERVACIONES);
    
    
    }

    public static ParametrosDeCampo getID_LOTE() {
        return ID_LOTE;
    }

    
    
    public static ParametrosDeCampo getID() {
        return ID;
    }

    

    public static ParametrosDeCampo getFECHA_SALIDA_LOTE() {
        return FECHA_SALIDA_LOTE;
    }

    

    public static ParametrosDeCampo getCANTIDAD() {
        return CANTIDAD;
    }

    

    public static ParametrosDeCampo getID_REFACCION() {
        return ID_REFACCION;
    }

    

    public static ParametrosDeCampo getID_EMPLEADO() {
        return ID_EMPLEADO;
    }

    

    public static ParametrosDeCampo getOBSERVACIONES() {
        return OBSERVACIONES;
    }

    
    
    
}
