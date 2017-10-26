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
public class SeccionDeMaquinaIT extends ITGenerales{
    
     /*
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "secciondemaquina";
    
    private static final ParametrosDeCampo ID = new ParametrosDeCampo();
    private static final ParametrosDeCampo NOMBRE_SECCION = new ParametrosDeCampo();
 

    
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

        NOMBRE_SECCION.setNombre("nombreSeccion");
        NOMBRE_SECCION.setNombreParaMostrar("Nombre de seccion");
        NOMBRE_SECCION.setLongitudDeCaracteres(30);
        NOMBRE_SECCION.setTipoDeDatos("varchar");
        NOMBRE_SECCION.setNulo(false);
        NOMBRE_SECCION.setAutoIncrement(false);
        NOMBRE_SECCION.setPermiteRepetido(false);
              
        CAMPOS_PDC.add(ID);
        CAMPOS_PDC.add(NOMBRE_SECCION);
    
    }

    public static ParametrosDeCampo getID() {
        return ID;
    }

    

    public static ParametrosDeCampo getNOMBRE_SECCION() {
        return NOMBRE_SECCION;
    }

    
    
    
    
    
    
}
