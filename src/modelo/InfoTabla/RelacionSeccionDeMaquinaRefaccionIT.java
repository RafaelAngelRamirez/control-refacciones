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
public class RelacionSeccionDeMaquinaRefaccionIT extends ITGenerales{
    
     /*
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "relacionseccionmaqrefaccion";
    
    private static final ParametrosDeCampo ID_REFACCION = new ParametrosDeCampo();
    private static final ParametrosDeCampo ID_SECCION_MAQUINA = new ParametrosDeCampo();

    
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

        ID_SECCION_MAQUINA.setNombre("idSeccionMaquina");
        ID_SECCION_MAQUINA.setLongitudDeCaracteres(11);
        ID_SECCION_MAQUINA.setTipoDeDatos("int");
        ID_SECCION_MAQUINA.setNulo(false);
        ID_SECCION_MAQUINA.setAutoIncrement(false);
        ID_SECCION_MAQUINA.setPermiteRepetido(true);
        
        CAMPOS_PDC.add(ID_REFACCION);
        CAMPOS_PDC.add(ID_SECCION_MAQUINA);
      
        
    }

    public static ParametrosDeCampo getID_REFACCION() {
        return ID_REFACCION;
    }

    

    public static ParametrosDeCampo getID_SECCION_MAQUINA() {
        return ID_SECCION_MAQUINA;
    }

    
    
    
}
