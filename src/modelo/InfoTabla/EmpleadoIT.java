
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
    
    private static final ParametrosDeCampo idPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo nombrePDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo idDepartamentoPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo bajaEmpleadoPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo fechaBaja = new ParametrosDeCampo();
    private static final ParametrosDeCampo fechaAlta = new ParametrosDeCampo();

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
        
        bajaEmpleadoPDC.setNombre("bajaEmpleado");
        bajaEmpleadoPDC.setLongitudDeCaracteres(11);
        bajaEmpleadoPDC.setTipoDeDatos("boolean");
        bajaEmpleadoPDC.setNulo(false);
        bajaEmpleadoPDC.setAutoIncrement(false);
        bajaEmpleadoPDC.setPermiteRepetido(true);
        
        fechaBaja.setNombre("fechaBaja");
        fechaBaja.setLongitudDeCaracteres(11);
        fechaBaja.setTipoDeDatos("date");
        fechaBaja.setNulo(true);
        fechaBaja.setAutoIncrement(false);
        fechaBaja.setPermiteRepetido(true);
        
        fechaAlta.setNombre("fechaAlta");
        fechaAlta.setLongitudDeCaracteres(11);
        fechaAlta.setTipoDeDatos("date");
        fechaAlta.setNulo(true);
        fechaAlta.setAutoIncrement(false);
        fechaAlta.setPermiteRepetido(true);
        
        camposPDC.add(idPDC);
        camposPDC.add(nombrePDC);
        camposPDC.add(idDepartamentoPDC);
        camposPDC.add(bajaEmpleadoPDC);
        camposPDC.add(fechaBaja);
        camposPDC.add(fechaAlta);
        
    
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

    public ParametrosDeCampo getBajaEmpleadoPDC() {
        return bajaEmpleadoPDC;
    }

    public void setBajaEmpleadoPDC(ParametrosDeCampo bajaEmpleadoPDC) {
        this.bajaEmpleadoPDC = bajaEmpleadoPDC;
    }

    public ParametrosDeCampo getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(ParametrosDeCampo fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public ParametrosDeCampo getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(ParametrosDeCampo fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    
    
    
    
}
