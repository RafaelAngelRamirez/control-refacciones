
package modelo.InfoTabla;


import java.util.ArrayList;
import java.util.List;
import modelo.ParametrosDeCampo;


/**
 *
 * @author Particular
 */
public class EmpleadoIT extends ITGenerales{
     /*
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "empleado";
    
    private static final ParametrosDeCampo ID = new ParametrosDeCampo();
    private static final ParametrosDeCampo NOMBRE = new ParametrosDeCampo();
    private static final ParametrosDeCampo ID_DEPARTAMENTO = new ParametrosDeCampo();
    private static final ParametrosDeCampo BAJA_EMPLEADO = new ParametrosDeCampo();
    private static final ParametrosDeCampo FECHA_BAJA = new ParametrosDeCampo();
    private static final ParametrosDeCampo FECHA_ALTA = new ParametrosDeCampo();

    
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

        NOMBRE.setNombre("nombre");
        NOMBRE.setNombreParaMostrar("Nombre del empleado");
        NOMBRE.setLongitudDeCaracteres(50);
        NOMBRE.setTipoDeDatos("varchar");
        NOMBRE.setNulo(false);
        NOMBRE.setAutoIncrement(false);
        NOMBRE.setPermiteRepetido(true);
        
        ID_DEPARTAMENTO.setNombre("idDepartamento");
        ID_DEPARTAMENTO.setLongitudDeCaracteres(11);
        ID_DEPARTAMENTO.setTipoDeDatos("int");
        ID_DEPARTAMENTO.setNulo(false);
        ID_DEPARTAMENTO.setAutoIncrement(false);
        ID_DEPARTAMENTO.setPermiteRepetido(true);
        
        BAJA_EMPLEADO.setNombre("bajaEmpleado");
        BAJA_EMPLEADO.setLongitudDeCaracteres(11);
        BAJA_EMPLEADO.setTipoDeDatos("boolean");
        BAJA_EMPLEADO.setNulo(false);
        BAJA_EMPLEADO.setAutoIncrement(false);
        BAJA_EMPLEADO.setPermiteRepetido(true);
        
        FECHA_BAJA.setNombre("fechaBaja");
        FECHA_BAJA.setLongitudDeCaracteres(11);
        FECHA_BAJA.setTipoDeDatos("date");
        FECHA_BAJA.setNulo(true);
        FECHA_BAJA.setAutoIncrement(false);
        FECHA_BAJA.setPermiteRepetido(true);
        
        FECHA_ALTA.setNombre("fechaAlta");
        FECHA_ALTA.setLongitudDeCaracteres(11);
        FECHA_ALTA.setTipoDeDatos("date");
        FECHA_ALTA.setNulo(true);
        FECHA_ALTA.setAutoIncrement(false);
        FECHA_ALTA.setPermiteRepetido(true);
        
        CAMPOS_PDC.add(ID);
        CAMPOS_PDC.add(NOMBRE);
        CAMPOS_PDC.add(ID_DEPARTAMENTO);
        CAMPOS_PDC.add(BAJA_EMPLEADO);
        CAMPOS_PDC.add(FECHA_BAJA);
        CAMPOS_PDC.add(FECHA_ALTA);
        
    
    }

    public static ParametrosDeCampo getID() {
        return ID;
    }

    

    public static ParametrosDeCampo getNOMBRE() {
        return NOMBRE;
    }

    

    public static ParametrosDeCampo getID_DEPARTAMENTO() {
        return ID_DEPARTAMENTO;
    }

    

    public static ParametrosDeCampo getBAJA_EMPLEADO() {
        return BAJA_EMPLEADO;
    }

    

    public static ParametrosDeCampo getFECHA_BAJA() {
        return FECHA_BAJA;
    }

    

    public static ParametrosDeCampo getFECHA_ALTA() {
        return FECHA_ALTA;
    }

    
    
    
    
    
}
