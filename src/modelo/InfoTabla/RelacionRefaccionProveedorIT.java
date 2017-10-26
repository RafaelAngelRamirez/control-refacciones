/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.InfoTabla;


import java.util.ArrayList;
import java.util.List;
import modelo.ParametrosDeCampo;


/**
 *
 * @author Particular
 */
public class RelacionRefaccionProveedorIT extends ITGenerales{
    
public static final String NOMBRE_TABLA = "relacionrefaccionproveedor";    
private static final ParametrosDeCampo ID_PROVEEDOR = new ParametrosDeCampo();
private static final ParametrosDeCampo ID_REFACCION = new ParametrosDeCampo();

    
    /**
     * Los campos de la tabla. 
     */
    private static final List<ParametrosDeCampo> CAMPOS_PDC = new ArrayList<>();

    public static List<ParametrosDeCampo> getCAMPOS_PDC() {
        return CAMPOS_PDC;
    }
    
    static {
        

        ID_REFACCION.setNombre("idRefaccion");
        ID_REFACCION.setLongitudDeCaracteres(11);
        ID_REFACCION.setTipoDeDatos("int");
        ID_REFACCION.setNulo(false);
        ID_REFACCION.setAutoIncrement(false);
        ID_REFACCION.setPermiteRepetido(true);
        
        ID_PROVEEDOR.setNombre("idProveedor");
        ID_PROVEEDOR.setLongitudDeCaracteres(11);
        ID_PROVEEDOR.setTipoDeDatos("int");
        ID_PROVEEDOR.setNulo(false);
        ID_PROVEEDOR.setAutoIncrement(false);
        ID_PROVEEDOR.setPermiteRepetido(true);
        ID_PROVEEDOR.setNombreParaMostrar("Proveedor");
        
        
        CAMPOS_PDC.add(ID_PROVEEDOR);
        CAMPOS_PDC.add(ID_REFACCION);
    
    }   

    public static ParametrosDeCampo getID_PROVEEDOR() {
        return ID_PROVEEDOR;
    }

    

    public static ParametrosDeCampo getID_REFACCION() {
        return ID_REFACCION;
    }

    
    
    
    
    
}
