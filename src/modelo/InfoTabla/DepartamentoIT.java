package modelo.InfoTabla;

/**
 *
 * @author Particular
 */
public class DepartamentoIT extends ITGenerales{
     /*
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "departamento";
    
    private ParametrosDeCampo idPDC = new ParametrosDeCampo();
    private ParametrosDeCampo departamentoPDC = new ParametrosDeCampo();

    public DepartamentoIT() {
        
        idPDC.setNombre("id");
        idPDC.setLongitudDeCaracteres(11);
        idPDC.setTipoDeDatos("int");
        idPDC.setNulo(false);
        idPDC.setAutoIncrement(true);
        idPDC.setPermiteRepetido(false);
        
        departamentoPDC.setNombre("departamento");
        departamentoPDC.setNombreParaMostrar("Departamento");
        departamentoPDC.setLongitudDeCaracteres(200);
        departamentoPDC.setTipoDeDatos("varchar");
        departamentoPDC.setNulo(false);
        departamentoPDC.setAutoIncrement(false);
        departamentoPDC.setPermiteRepetido(true);
        
        camposPDC.add(idPDC);
        camposPDC.add(departamentoPDC);
        
        
    }

    public ParametrosDeCampo getIdPDC() {
        return idPDC;
    }

    public void setIdPDC(ParametrosDeCampo idPDC) {
        this.idPDC = idPDC;
    }

    public ParametrosDeCampo getDepartamentoPDC() {
        return departamentoPDC;
    }

    public void setDepartamentoPDC(ParametrosDeCampo departamentoPDC) {
        this.departamentoPDC = departamentoPDC;
    }
    
    
    
}