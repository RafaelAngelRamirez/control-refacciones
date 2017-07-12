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
public class PaisIT extends ITGenerales{
    public static final String NOMBRE_TABLA = "pais";
    
    private ParametrosDeCampo idPDC = new ParametrosDeCampo();
    private ParametrosDeCampo paisPDC = new ParametrosDeCampo();

    public PaisIT() {
        
        idPDC.setNombre("id");
        idPDC.setLongitudDeCaracteres(11);
        idPDC.setTipoDeDatos("int");
        idPDC.setNulo(false);
        idPDC.setAutoIncrement(true);

        paisPDC.setNombre("pais");
        paisPDC.setNombreParaMostrar("Pais");
        paisPDC.setLongitudDeCaracteres(25);
        paisPDC.setTipoDeDatos("varchar");
        paisPDC.setNulo(false);
        paisPDC.setAutoIncrement(false);

        camposPDC.add(idPDC);
        camposPDC.add(paisPDC);
    
    }

    public ParametrosDeCampo getIdPDC() {
        return idPDC;
    }

    public ParametrosDeCampo getPaisPDC() {
        return paisPDC;
    }
    
    
    
    
}
