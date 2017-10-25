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
public class RelacionSeccionMaqRefaccionIT extends ITGenerales{
    
     /*
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "relacionseccionmaqrefaccion";
    
    private ParametrosDeCampo idRefaccionPDC = new ParametrosDeCampo();
    private ParametrosDeCampo idSeccionMaquinaPDC = new ParametrosDeCampo();

    public RelacionSeccionMaqRefaccionIT() {
        idRefaccionPDC.setNombre("idRefaccion");
        idRefaccionPDC.setLongitudDeCaracteres(11);
        idRefaccionPDC.setTipoDeDatos("int");
        idRefaccionPDC.setNulo(false);
        idRefaccionPDC.setAutoIncrement(false);
        idRefaccionPDC.setPermiteRepetido(true);

        idSeccionMaquinaPDC.setNombre("idSeccionMaquina");
        idSeccionMaquinaPDC.setLongitudDeCaracteres(11);
        idSeccionMaquinaPDC.setTipoDeDatos("int");
        idSeccionMaquinaPDC.setNulo(false);
        idSeccionMaquinaPDC.setAutoIncrement(false);
        idSeccionMaquinaPDC.setPermiteRepetido(true);
        
        camposPDC.add(idRefaccionPDC);
        camposPDC.add(idSeccionMaquinaPDC);
      
        
    }

    public ParametrosDeCampo getIdRefaccionPDC() {
        return idRefaccionPDC;
    }

    

    public ParametrosDeCampo getIdSeccionMaquinaPDC() {
        return idSeccionMaquinaPDC;
    }

    
    
    
}
