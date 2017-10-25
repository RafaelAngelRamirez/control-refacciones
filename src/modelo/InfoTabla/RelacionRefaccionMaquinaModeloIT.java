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
public class RelacionRefaccionMaquinaModeloIT  extends ITGenerales{
    /**
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "relacionrefaccionmaquinamodelo";
    

    
    private static final ParametrosDeCampo idMaquinaModeloPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo idRefaccionPDC = new ParametrosDeCampo();

    public RelacionRefaccionMaquinaModeloIT() {
        
        idMaquinaModeloPDC.setNombre("idMaquinaModelo");
        idMaquinaModeloPDC.setLongitudDeCaracteres(11);
        idMaquinaModeloPDC.setTipoDeDatos("int");
        idMaquinaModeloPDC.setNulo(false);
        idMaquinaModeloPDC.setAutoIncrement(false);
        idMaquinaModeloPDC.setPermiteRepetido(true);
        idMaquinaModeloPDC.setNombreParaMostrar("Modelo-Maquina");

        idRefaccionPDC.setNombre("idRefaccion");
        idRefaccionPDC.setLongitudDeCaracteres(11);
        idRefaccionPDC.setTipoDeDatos("int");
        idRefaccionPDC.setNulo(false);
        idRefaccionPDC.setAutoIncrement(false);
        idRefaccionPDC.setPermiteRepetido(true);
        
        camposPDC.add(idMaquinaModeloPDC);
        camposPDC.add(idRefaccionPDC);
    
    }   

    public ParametrosDeCampo getIdMaquinaModeloPDC() {
        return idMaquinaModeloPDC;
    }

    public void setIdMaquinaModeloPDC(ParametrosDeCampo idMaquinaModeloPDC) {
        this.idMaquinaModeloPDC = idMaquinaModeloPDC;
    }

    public ParametrosDeCampo getIdRefaccionPDC() {
        return idRefaccionPDC;
    }

    public void setIdRefaccionPDC(ParametrosDeCampo idRefaccionPDC) {
        this.idRefaccionPDC = idRefaccionPDC;
    }
    
    
    
    
    
}
