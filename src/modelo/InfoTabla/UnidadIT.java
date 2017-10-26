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
public class UnidadIT extends ITGenerales{
    /*
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "unidad";
    private static final ParametrosDeCampo ID = new ParametrosDeCampo();
    private static final ParametrosDeCampo UNIDAD = new ParametrosDeCampo();

    
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

        UNIDAD.setNombre("unidad");
        UNIDAD.setNombreParaMostrar("Unidad");
        UNIDAD.setLongitudDeCaracteres(20);
        UNIDAD.setTipoDeDatos("varchar");
        UNIDAD.setNulo(false);
        UNIDAD.setAutoIncrement(false);
        UNIDAD.setPermiteRepetido(false);
        
        CAMPOS_PDC.add(ID);
        CAMPOS_PDC.add(UNIDAD);
        
    }

    public static ParametrosDeCampo getID() {
        return ID;
    }

    

    public static ParametrosDeCampo getUNIDAD() {
        return UNIDAD;
    }

    
    
    
}
