
package modelo.InfoTabla;


import java.util.ArrayList;
import java.util.List;
import modelo.ParametrosDeCampo;


/**
 *
 * @author Particular
 */
public class ImagenProveedorIT extends ITGenerales{
    /*
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "imagenproveedor";
    
    private static final ParametrosDeCampo ID_PROVEEDOR = new ParametrosDeCampo();
    private static final ParametrosDeCampo NOMBRE_PARA_MOSTRAR = new ParametrosDeCampo();
    private static final ParametrosDeCampo NOMBRE_SERVIDOR = new ParametrosDeCampo();

    
    /**
     * Los campos de la tabla. 
     */
    private static final List<ParametrosDeCampo> CAMPOS_PDC = new ArrayList<>();

    public static List<ParametrosDeCampo> getCAMPOS_PDC() {
        return CAMPOS_PDC;
    }
    
    static {
        
        
        ID_PROVEEDOR.setNombre("idProveedor");
        ID_PROVEEDOR.setLongitudDeCaracteres(11);
        ID_PROVEEDOR.setTipoDeDatos("int");
        ID_PROVEEDOR.setNulo(false);
        ID_PROVEEDOR.setAutoIncrement(false);
        ID_PROVEEDOR.setPermiteRepetido(true);

        NOMBRE_PARA_MOSTRAR.setNombre("nombreParaMostrar");
        NOMBRE_PARA_MOSTRAR.setNombreParaMostrar("Nombre imagen");
        NOMBRE_PARA_MOSTRAR.setLongitudDeCaracteres(200);
        NOMBRE_PARA_MOSTRAR.setTipoDeDatos("varchar");
        NOMBRE_PARA_MOSTRAR.setNulo(false);
        NOMBRE_PARA_MOSTRAR.setAutoIncrement(false);
        NOMBRE_PARA_MOSTRAR.setPermiteRepetido(true);
        
        NOMBRE_SERVIDOR.setNombre("nombreServidor");
        NOMBRE_SERVIDOR.setNombreParaMostrar("Nombre servidor");
        NOMBRE_SERVIDOR.setLongitudDeCaracteres(200);
        NOMBRE_SERVIDOR.setTipoDeDatos("varchar");
        NOMBRE_SERVIDOR.setNulo(false);
        NOMBRE_SERVIDOR.setAutoIncrement(false);
        NOMBRE_SERVIDOR.setPermiteRepetido(true);
        
        CAMPOS_PDC.add(ID_PROVEEDOR);
        CAMPOS_PDC.add(NOMBRE_PARA_MOSTRAR);
        CAMPOS_PDC.add(NOMBRE_SERVIDOR);
    
    }   

    public static ParametrosDeCampo getID_PROVEEDOR() {
        return ID_PROVEEDOR;
    }

    

    public static ParametrosDeCampo getNOMBRE_PARA_MOSTRAR() {
        return NOMBRE_PARA_MOSTRAR;
    }

    

    public static ParametrosDeCampo getNOMBRE_SERVIDOR() {
        return NOMBRE_SERVIDOR;
    }

    
    
    
    
}
