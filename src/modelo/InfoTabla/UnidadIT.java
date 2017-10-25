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
public class UnidadIT extends ITGenerales{
    /*
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "unidad";
    private static final ParametrosDeCampo idPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo unidadPDC = new ParametrosDeCampo();

    public UnidadIT() {
        
        idPDC.setNombre("id");
        idPDC.setLongitudDeCaracteres(11);
        idPDC.setTipoDeDatos("int");
        idPDC.setNulo(false);
        idPDC.setAutoIncrement(true);
        idPDC.setPermiteRepetido(false);

        unidadPDC.setNombre("unidad");
        unidadPDC.setNombreParaMostrar("Unidad");
        unidadPDC.setLongitudDeCaracteres(20);
        unidadPDC.setTipoDeDatos("varchar");
        unidadPDC.setNulo(false);
        unidadPDC.setAutoIncrement(false);
        unidadPDC.setPermiteRepetido(false);
        
        camposPDC.add(idPDC);
        camposPDC.add(unidadPDC);
        
    }

    public ParametrosDeCampo getIdPDC() {
        return idPDC;
    }

    

    public ParametrosDeCampo getUnidadPDC() {
        return unidadPDC;
    }

    
    
    
}
