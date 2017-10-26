package modelo.InfoTabla;


import java.util.ArrayList;
import java.util.List;
import modelo.ParametrosDeCampo;


/**
 *
 * @author Particular
 */
public class DepartamentoIT extends ITGenerales{
     /*
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "departamento";
    
    private static final ParametrosDeCampo ID = new ParametrosDeCampo();
    private static final ParametrosDeCampo DEPARTAMENTO = new ParametrosDeCampo();

    
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
        
        DEPARTAMENTO.setNombre("departamento");
        DEPARTAMENTO.setNombreParaMostrar("Departamento");
        DEPARTAMENTO.setLongitudDeCaracteres(200);
        DEPARTAMENTO.setTipoDeDatos("varchar");
        DEPARTAMENTO.setNulo(false);
        DEPARTAMENTO.setAutoIncrement(false);
        DEPARTAMENTO.setPermiteRepetido(true);
        
        CAMPOS_PDC.add(ID);
        CAMPOS_PDC.add(DEPARTAMENTO);
        
        
    }

    public static ParametrosDeCampo getID() {
        return ID;
    }

    

    public static ParametrosDeCampo getDEPARTAMENTO() {
        return DEPARTAMENTO;
    }

    
    
    
    
}
