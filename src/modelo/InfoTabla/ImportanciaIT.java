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
    private ParametrosDeCampo idPDC = new ParametrosDeCampo();
    private ParametrosDeCampo importanciaPDC = new ParametrosDeCampo();

    public ImportanciaIT() {
        
        idPDC.setNombre("id");
        idPDC.setLongitudDeCaracteres(11);
        idPDC.setTipoDeDatos("int");
        idPDC.setNulo(false);
        idPDC.setAutoIncrement(true);
        idPDC.setPermiteRepetido(false);

        importanciaPDC.setNombre("importancia");
        importanciaPDC.setNombreParaMostrar("Importancia");
        importanciaPDC.setLongitudDeCaracteres(30);
        importanciaPDC.setTipoDeDatos("varchar");
        importanciaPDC.setNulo(false);
        importanciaPDC.setAutoIncrement(false);
        importanciaPDC.setPermiteRepetido(false);
        
        camposPDC.add(idPDC);
        camposPDC.add(importanciaPDC);
    
    }   

    public ParametrosDeCampo getIdPDC() {
        return idPDC;
    }

    public void setIdPDC(ParametrosDeCampo idPDC) {
        this.idPDC = idPDC;
    }

    public ParametrosDeCampo getImportanciaPDC() {
        return importanciaPDC;
    }

    public void setImportanciaPDC(ParametrosDeCampo importanciaPDC) {
        this.importanciaPDC = importanciaPDC;
    }
    
    
}
