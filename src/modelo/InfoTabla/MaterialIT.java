/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.InfoTabla;

/**
 *
 * @author Particular
 */
public class MaterialIT extends ITGenerales{
    
    /**
     * El nombre de la tabla en la base de datos. 
     */
    public static final String NOMBRE_TABLA = "material";
    private static final ParametrosDeCampo ID = new ParametrosDeCampo();
    private static final ParametrosDeCampo MATERIAL = new ParametrosDeCampo();

    public MaterialIT() {
        
        ID.setNombre("id");
        ID.setLongitudDeCaracteres(11);
        ID.setTipoDeDatos("int");
        ID.setNulo(false);
        ID.setAutoIncrement(true);
        ID.setPermiteRepetido(false);

        MATERIAL.setNombre("material");
        MATERIAL.setNombreParaMostrar("¿De que esta echo?");
        MATERIAL.setLongitudDeCaracteres(30);
        MATERIAL.setTipoDeDatos("varchar");
        MATERIAL.setNulo(false);
        MATERIAL.setAutoIncrement(false);
        MATERIAL.setPermiteRepetido(false);
    
    }

    public static ParametrosDeCampo getID() {
        return ID;
    }

    

    public static ParametrosDeCampo getMATERIAL() {
        return MATERIAL;
    }

    
    
    
   
}
