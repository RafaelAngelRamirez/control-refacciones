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
public class MaquinaModeloIT extends ITGenerales{
    
    /*
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "maquinamodelo";
    private static final ParametrosDeCampo ID = new ParametrosDeCampo();
    private static final ParametrosDeCampo MODELO = new ParametrosDeCampo();
    private static final ParametrosDeCampo ANIO = new ParametrosDeCampo();
    private static final ParametrosDeCampo ID_PROVEEDOR = new ParametrosDeCampo();

    
    /**
     * Los campos de la tabla. 
     */
    private static final List<ParametrosDeCampo> CAMPOS_PDC = new ArrayList<>();

    public static List<ParametrosDeCampo> getCAMPOS_PDC() {
        return CAMPOS_PDC;
    }
    
    static {
       
        ID.setNombre("id");
        ID.setNombreParaMostrar("ID");
        ID.setLongitudDeCaracteres(11);
        ID.setTipoDeDatos("int");
        ID.setNulo(false);
        ID.setAutoIncrement(true);
        ID.setPermiteRepetido(false);

        MODELO.setNombre("modelo");
        MODELO.setNombreParaMostrar("Modelo");
        MODELO.setLongitudDeCaracteres(30);
        MODELO.setTipoDeDatos("varchar");
        MODELO.setNulo(false);
        MODELO.setAutoIncrement(false);
        MODELO.setPermiteRepetido(false);

        ANIO.setNombre("anio");
        ANIO.setNombreParaMostrar("Año");
        ANIO.setLongitudDeCaracteres(4);
        ANIO.setTipoDeDatos("int");
        ANIO.setNulo(false);
        ANIO.setAutoIncrement(false);
        ANIO.setPermiteRepetido(true);

        ID_PROVEEDOR.setNombre("idProveedor");
        ID_PROVEEDOR.setLongitudDeCaracteres(11);
        ID_PROVEEDOR.setTipoDeDatos("int");
        ID_PROVEEDOR.setNulo(false);
        ID_PROVEEDOR.setAutoIncrement(false);
        ID_PROVEEDOR.setPermiteRepetido(true);
        
        CAMPOS_PDC.add(ID);
        CAMPOS_PDC.add(MODELO);
        CAMPOS_PDC.add(ANIO);
        CAMPOS_PDC.add(ID_PROVEEDOR);
    }

    public static ParametrosDeCampo getID() {
        return ID;
    }

    

    public static ParametrosDeCampo getMODELO() {
        return MODELO;
    }

    

    public static ParametrosDeCampo getAnioPDC() {
        return ANIO;
    }

    

    public static ParametrosDeCampo getID_PROVEEDOR() {
        return ID_PROVEEDOR;
    }

    
    
    
    
    
    
}
