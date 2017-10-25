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
public class MaquinaModeloIT extends ITGenerales{
    
    /*
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "maquinamodelo";
    private static final ParametrosDeCampo idPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo modeloPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo anoPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo idProoveedorPDC = new ParametrosDeCampo();

    public MaquinaModeloIT() {
       
        idPDC.setNombre("id");
        idPDC.setNombreParaMostrar("ID");
        idPDC.setLongitudDeCaracteres(11);
        idPDC.setTipoDeDatos("int");
        idPDC.setNulo(false);
        idPDC.setAutoIncrement(true);
        idPDC.setPermiteRepetido(false);

        modeloPDC.setNombre("modelo");
        modeloPDC.setNombreParaMostrar("Modelo");
        modeloPDC.setLongitudDeCaracteres(30);
        modeloPDC.setTipoDeDatos("varchar");
        modeloPDC.setNulo(false);
        modeloPDC.setAutoIncrement(false);
        modeloPDC.setPermiteRepetido(false);

        anoPDC.setNombre("anio");
        anoPDC.setNombreParaMostrar("Año");
        anoPDC.setLongitudDeCaracteres(4);
        anoPDC.setTipoDeDatos("int");
        anoPDC.setNulo(false);
        anoPDC.setAutoIncrement(false);
        anoPDC.setPermiteRepetido(true);

        idProoveedorPDC.setNombre("idProveedor");
        idProoveedorPDC.setLongitudDeCaracteres(11);
        idProoveedorPDC.setTipoDeDatos("int");
        idProoveedorPDC.setNulo(false);
        idProoveedorPDC.setAutoIncrement(false);
        idProoveedorPDC.setPermiteRepetido(true);
        
        camposPDC.add(idPDC);
        camposPDC.add(modeloPDC);
        camposPDC.add(anoPDC);
        camposPDC.add(idProoveedorPDC);
    }

    public ParametrosDeCampo getIdPDC() {
        return idPDC;
    }

    public void setIdPDC(ParametrosDeCampo idPDC) {
        this.idPDC = idPDC;
    }

    public ParametrosDeCampo getModeloPDC() {
        return modeloPDC;
    }

    public void setModeloPDC(ParametrosDeCampo modeloPDC) {
        this.modeloPDC = modeloPDC;
    }

    public ParametrosDeCampo getAnioPDC() {
        return anoPDC;
    }

    public void setAnoPDC(ParametrosDeCampo anoPDC) {
        this.anoPDC = anoPDC;
    }

    public ParametrosDeCampo getIdProoveedorPDC() {
        return idProoveedorPDC;
    }

    public void setIdProoveedorPDC(ParametrosDeCampo idProoveedorPDC) {
        this.idProoveedorPDC = idProoveedorPDC;
    }
    
    
    
    
    
}
