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
    private static final ParametrosDeCampo idPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo materialPDC = new ParametrosDeCampo();

    public MaterialIT() {
        
        idPDC.setNombre("id");
        idPDC.setLongitudDeCaracteres(11);
        idPDC.setTipoDeDatos("int");
        idPDC.setNulo(false);
        idPDC.setAutoIncrement(true);
        idPDC.setPermiteRepetido(false);

        materialPDC.setNombre("material");
        materialPDC.setNombreParaMostrar("¿De que esta echo?");
        materialPDC.setLongitudDeCaracteres(30);
        materialPDC.setTipoDeDatos("varchar");
        materialPDC.setNulo(false);
        materialPDC.setAutoIncrement(false);
        materialPDC.setPermiteRepetido(false);
    
    }

    public ParametrosDeCampo getIdPDC() {
        return idPDC;
    }

    

    public ParametrosDeCampo getMaterialPDC() {
        return materialPDC;
    }

    
    
    
   
}
