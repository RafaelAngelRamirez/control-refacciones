
package modelo.InfoTabla;

/**
 *
 * @author Particular
 */
public class EmpleadoIT extends ITGenerales{
     /*
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "empleado";
    
    private ParametrosDeCampo idPDC = new ParametrosDeCampo();
    private ParametrosDeCampo nombrePDC = new ParametrosDeCampo();
    private ParametrosDeCampo idDepartamentoPDC = new ParametrosDeCampo();

    public EmpleadoIT() {
        
        idPDC.setNombre("id");
        idPDC.setLongitudDeCaracteres(11);
        idPDC.setTipoDeDatos("int");
        idPDC.setNulo(false);
        idPDC.setAutoIncrement(true);
        idPDC.setPermiteRepetido(false);

        nombrePDC.setNombre("nombre");
        nombrePDC.setNombreParaMostrar("Nombre del empleado");
        nombrePDC.setLongitudDeCaracteres(50);
        nombrePDC.setTipoDeDatos("varchar");
        nombrePDC.setNulo(false);
        nombrePDC.setAutoIncrement(false);
        nombrePDC.setPermiteRepetido(true);
        
        idDepartamentoPDC.setNombre("idDepartamento");
        idDepartamentoPDC.setLongitudDeCaracteres(11);
        idDepartamentoPDC.setTipoDeDatos("int");
        idDepartamentoPDC.setNulo(false);
        idDepartamentoPDC.setAutoIncrement(false);
        idDepartamentoPDC.setPermiteRepetido(true);
        
        camposPDC.add(idPDC);
        camposPDC.add(nombrePDC);
        camposPDC.add(idDepartamentoPDC);
        
    
    }

    public ParametrosDeCampo getIdPDC() {
        return idPDC;
    }

    public void setIdPDC(ParametrosDeCampo idPDC) {
        this.idPDC = idPDC;
    }

    public ParametrosDeCampo getNombrePDC() {
        return nombrePDC;
    }

    public void setNombrePDC(ParametrosDeCampo nombrePDC) {
        this.nombrePDC = nombrePDC;
    }

    public ParametrosDeCampo getIdDepartamentoPDC() {
        return idDepartamentoPDC;
    }

    public void setIdDepartamentoPDC(ParametrosDeCampo idDepartamentoPDC) {
        this.idDepartamentoPDC = idDepartamentoPDC;
    }
    
    
    
    
}
