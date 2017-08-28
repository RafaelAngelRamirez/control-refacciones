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
public class SalidaDeControlIT extends ITGenerales{
    /**
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "salidadecontrol";
    
    private ParametrosDeCampo idPDC = new ParametrosDeCampo();
    private ParametrosDeCampo idMaquinaModeloPDC = new ParametrosDeCampo();
    private ParametrosDeCampo descripcionPDC = new ParametrosDeCampo();
    private ParametrosDeCampo numeroDeMaquinaPDC = new ParametrosDeCampo();

    public SalidaDeControlIT() {
        
        idPDC.setNombre("id");
        idPDC.setLongitudDeCaracteres(11);
        idPDC.setTipoDeDatos("int");
        idPDC.setNulo(false);
        idPDC.setAutoIncrement(true);
        idPDC.setPermiteRepetido(false);
        
        idMaquinaModeloPDC.setNombre("idMaquinaModelo");
        idMaquinaModeloPDC.setLongitudDeCaracteres(11);
        idMaquinaModeloPDC.setTipoDeDatos("int");
        idMaquinaModeloPDC.setNulo(false);
        idMaquinaModeloPDC.setAutoIncrement(false);
        idMaquinaModeloPDC.setPermiteRepetido(true);
        idMaquinaModeloPDC.setNombreParaMostrar("Modelo de máquina");
        
        descripcionPDC.setNombre("descripcion");
        descripcionPDC.setLongitudDeCaracteres(400);
        descripcionPDC.setTipoDeDatos("varchar");
        descripcionPDC.setNulo(true);
        descripcionPDC.setAutoIncrement(false);
        descripcionPDC.setPermiteRepetido(true);
        descripcionPDC.setNombreParaMostrar("Descripcion");
        
        numeroDeMaquinaPDC.setNombre("numeroDeMaquina");
        numeroDeMaquinaPDC.setLongitudDeCaracteres(20);
        numeroDeMaquinaPDC.setTipoDeDatos("varchar");
        numeroDeMaquinaPDC.setNulo(false);
        numeroDeMaquinaPDC.setAutoIncrement(false);
        numeroDeMaquinaPDC.setPermiteRepetido(true);
        numeroDeMaquinaPDC.setNombreParaMostrar("Número de máquina");

        camposPDC.add(idPDC);
        camposPDC.add(idMaquinaModeloPDC);
        camposPDC.add(descripcionPDC);
        camposPDC.add(numeroDeMaquinaPDC);
        
    }

    public ParametrosDeCampo getIdPDC() {
        return idPDC;
    }

    public void setIdPDC(ParametrosDeCampo idPDC) {
        this.idPDC = idPDC;
    }

    public ParametrosDeCampo getIdMaquinaModeloPDC() {
        return idMaquinaModeloPDC;
    }

    public void setIdMaquinaModeloPDC(ParametrosDeCampo idMaquinaModeloPDC) {
        this.idMaquinaModeloPDC = idMaquinaModeloPDC;
    }

    public ParametrosDeCampo getDescripcionPDC() {
        return descripcionPDC;
    }

    public void setDescripcionPDC(ParametrosDeCampo descripcionPDC) {
        this.descripcionPDC = descripcionPDC;
    }

    public ParametrosDeCampo getNumeroDeMaquinaPDC() {
        return numeroDeMaquinaPDC;
    }

    public void setNumeroDeMaquinaPDC(ParametrosDeCampo numeroDeMaquinaPDC) {
        this.numeroDeMaquinaPDC = numeroDeMaquinaPDC;
    }
    
    
    
    
}
