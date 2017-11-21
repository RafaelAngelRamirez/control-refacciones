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
public class ExistenciaRefaccionIT extends ITGenerales{
    
     /*
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "existenciarefaccion";
    
    private static final ParametrosDeCampo ID_REFACCION = new ParametrosDeCampo();
    private static final ParametrosDeCampo EXISTENCIA = new ParametrosDeCampo();
    
    private static final List<ParametrosDeCampo> CAMPOS_PDC = new ArrayList<>();

//    public static List<ParametrosDeCampo> getCAMPOS_PDC() {
//        return CAMPOS_PDC;
//    }
    
    static {
        ID_REFACCION.setNombre("idRefaccion");
        ID_REFACCION.setLongitudDeCaracteres(11);
        ID_REFACCION.setTipoDeDatos("int");
        ID_REFACCION.setNulo(false);
        ID_REFACCION.setAutoIncrement(false);
        ID_REFACCION.setPermiteRepetido(false);
        
        EXISTENCIA.setNombre("existencia");
        EXISTENCIA.setNombreParaMostrar("Existencia Actual");
        EXISTENCIA.setTipoDeDatos("float");
        EXISTENCIA.setLongitudDeCaracteres(10);
        EXISTENCIA.setLongitudDeDecimales(3);
        EXISTENCIA.setNulo(false);
        EXISTENCIA.setAutoIncrement(false);
        EXISTENCIA.setPermiteRepetido(true);
        
        CAMPOS_PDC.add(EXISTENCIA);
        CAMPOS_PDC.add(ID_REFACCION);
    
    }
    
    public static ParametrosDeCampo getID_REFACCION(){
        return ID_REFACCION;
    }
    
    public static ParametrosDeCampo getEXISTENCIA(){
        return EXISTENCIA;
    }
    
}
