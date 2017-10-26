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
public class MaquinaHistorialNombresIT extends ITGenerales{
    
    public static final String NOMBRE_TABLA = "maquinahistorialnombres";
    
    private static final ParametrosDeCampo ID_MAQUINA = new ParametrosDeCampo();
    private static final ParametrosDeCampo NOMBRE_ANTERIOR = new ParametrosDeCampo();
    private static final ParametrosDeCampo FECHA_DE_CAMBIO = new ParametrosDeCampo();

    
    /**
     * Los campos de la tabla. 
     */
    private static final List<ParametrosDeCampo> CAMPOS_PDC = new ArrayList<>();

    public static List<ParametrosDeCampo> getCAMPOS_PDC() {
        return CAMPOS_PDC;
    }
    
    static {
        
        ID_MAQUINA.setNombre("idMaquina");
        ID_MAQUINA.setLongitudDeCaracteres(11);
        ID_MAQUINA.setTipoDeDatos("int");
        ID_MAQUINA.setNulo(false);
        ID_MAQUINA.setAutoIncrement(false);
        ID_MAQUINA.setPermiteRepetido(true);
        
        NOMBRE_ANTERIOR.setNombre("nombre");
        NOMBRE_ANTERIOR.setLongitudDeCaracteres(50);
        NOMBRE_ANTERIOR.setTipoDeDatos("varchar");
        NOMBRE_ANTERIOR.setNulo(false);
        NOMBRE_ANTERIOR.setAutoIncrement(false);
        NOMBRE_ANTERIOR.setPermiteRepetido(true);
        
        FECHA_DE_CAMBIO.setNombre("fechaDeCambio");
        FECHA_DE_CAMBIO.setLongitudDeCaracteres(50);
        FECHA_DE_CAMBIO.setTipoDeDatos("datetime");
        FECHA_DE_CAMBIO.setNulo(false);
        FECHA_DE_CAMBIO.setAutoIncrement(false);
        FECHA_DE_CAMBIO.setPermiteRepetido(true);
        
        CAMPOS_PDC.add(ID_MAQUINA);
        CAMPOS_PDC.add(NOMBRE_ANTERIOR);
        CAMPOS_PDC.add(FECHA_DE_CAMBIO);
        
    }

    public static ParametrosDeCampo getFECHA_DE_CAMBIO() {
        return FECHA_DE_CAMBIO;
    }

    
    
    public static ParametrosDeCampo getID_MAQUINA() {
        return ID_MAQUINA;
    }

    

    public static ParametrosDeCampo getNOMBRE_ANTERIOR() {
        return NOMBRE_ANTERIOR;
    }

    
    
}
