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
public class ImportanciaIT extends ITGenerales{
    /*
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "importancia";
    private static final ParametrosDeCampo ID = new ParametrosDeCampo();
    private static final ParametrosDeCampo IMPORTANCIA = new ParametrosDeCampo();

    public ImportanciaIT() {
        
        ID.setNombre("id");
        ID.setLongitudDeCaracteres(11);
        ID.setTipoDeDatos("int");
        ID.setNulo(false);
        ID.setAutoIncrement(true);
        ID.setPermiteRepetido(false);

        IMPORTANCIA.setNombre("importancia");
        IMPORTANCIA.setNombreParaMostrar("Importancia");
        IMPORTANCIA.setLongitudDeCaracteres(30);
        IMPORTANCIA.setTipoDeDatos("varchar");
        IMPORTANCIA.setNulo(false);
        IMPORTANCIA.setAutoIncrement(false);
        IMPORTANCIA.setPermiteRepetido(false);
        
        CAMPOS_PDC.add(ID);
        CAMPOS_PDC.add(IMPORTANCIA);
    
    }   

    public static ParametrosDeCampo getID() {
        return ID;
    }

    

    public static ParametrosDeCampo getIMPORTANCIA() {
        return IMPORTANCIA;
    }

    
    
    
}
