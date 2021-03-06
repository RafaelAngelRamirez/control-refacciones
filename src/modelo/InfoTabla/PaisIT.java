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
public class PaisIT extends ITGenerales{
    public static final String NOMBRE_TABLA = "pais";
    
    private static final ParametrosDeCampo ID = new ParametrosDeCampo();
    private static final ParametrosDeCampo PAIS = new ParametrosDeCampo();

    
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

        PAIS.setNombre("pais");
        PAIS.setNombreParaMostrar("Pais");
        PAIS.setLongitudDeCaracteres(25);
        PAIS.setTipoDeDatos("varchar");
        PAIS.setNulo(false);
        PAIS.setAutoIncrement(false);

        CAMPOS_PDC.add(ID);
        CAMPOS_PDC.add(PAIS);
    
    }

    public static ParametrosDeCampo getID() {
        return ID;
    }

    public static ParametrosDeCampo getPAIS() {
        return PAIS;
    }
    
    
    
    
}
