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
public class MaquinaIT extends ITGenerales{
    /*
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "maquina";
    private ParametrosDeCampo idPDC = new ParametrosDeCampo();
    private ParametrosDeCampo idMaquinasModeloPDC = new ParametrosDeCampo();
    private ParametrosDeCampo descripcionPDC = new ParametrosDeCampo();
    private ParametrosDeCampo idMarcaPDC = new ParametrosDeCampo();
    private ParametrosDeCampo numeroDeMaquinaPDC = new ParametrosDeCampo();

    public MaquinaIT() {
        
       
        idPDC.setNombre("id");
        idPDC.setTipoDeDatos("int");
        idPDC.setLongitudDeCaracteres(11);
        idPDC.setNulo(false);
        idPDC.setAutoIncrement(true);
        idPDC.setPermiteRepetido(false);

        idMaquinasModeloPDC.setNombre("idMaquinaModelo");
        idMaquinasModeloPDC.setTipoDeDatos("int");
        idMaquinasModeloPDC.setLongitudDeCaracteres(11);
        idMaquinasModeloPDC.setNulo(false);
        idMaquinasModeloPDC.setAutoIncrement(false);
        idMaquinasModeloPDC.setPermiteRepetido(true);

        descripcionPDC.setNombre("descripcion");
        descripcionPDC.setTipoDeDatos("varchar");
        descripcionPDC.setLongitudDeCaracteres(400);
        descripcionPDC.setNulo(true);
        descripcionPDC.setAutoIncrement(false);
        descripcionPDC.setPermiteRepetido(true);
        descripcionPDC.setNombreParaMostrar("Descripción");

        idMarcaPDC.setNombre("idMarca");
        idMarcaPDC.setTipoDeDatos("int");
        idMarcaPDC.setLongitudDeCaracteres(11);
        idMarcaPDC.setNulo(false);
        idMarcaPDC.setAutoIncrement(false);
        idMarcaPDC.setPermiteRepetido(true);

        numeroDeMaquinaPDC.setNombre("numeroDeMaquina");
        numeroDeMaquinaPDC.setTipoDeDatos("varchar");
        numeroDeMaquinaPDC.setLongitudDeCaracteres(20);
        numeroDeMaquinaPDC.setNulo(true);
        numeroDeMaquinaPDC.setAutoIncrement(false);
        numeroDeMaquinaPDC.setPermiteRepetido(false);
        numeroDeMaquinaPDC.setNombreParaMostrar("Número de Máquina");
        
        camposPDC.add(idPDC);
        camposPDC.add(idMaquinasModeloPDC);
        camposPDC.add(descripcionPDC);
        camposPDC.add(idMarcaPDC);
        camposPDC.add(numeroDeMaquinaPDC);
    
    }   

    public ParametrosDeCampo getIdPDC() {
        return idPDC;
    }

    public void setIdPDC(ParametrosDeCampo idPDC) {
        this.idPDC = idPDC;
    }

    public ParametrosDeCampo getIdMaquinasModeloPDC() {
        return idMaquinasModeloPDC;
    }

    public void setIdMaquinasModeloPDC(ParametrosDeCampo idMaquinasModeloPDC) {
        this.idMaquinasModeloPDC = idMaquinasModeloPDC;
    }

    public ParametrosDeCampo getDescripcionPDC() {
        return descripcionPDC;
    }

    public void setDescripcionPDC(ParametrosDeCampo descripcionPDC) {
        this.descripcionPDC = descripcionPDC;
    }

    public ParametrosDeCampo getIdMarcaPDC() {
        return idMarcaPDC;
    }

    public void setIdMarcaPDC(ParametrosDeCampo idMarcaPDC) {
        this.idMarcaPDC = idMarcaPDC;
    }

    public ParametrosDeCampo getNumeroDeMaquinaPDC() {
        return numeroDeMaquinaPDC;
    }

    public void setNumeroDeMaquinaPDC(ParametrosDeCampo numeroDeMaquinaPDC) {
        this.numeroDeMaquinaPDC = numeroDeMaquinaPDC;
    }
    
    
    
    
}
