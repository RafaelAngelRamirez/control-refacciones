
package modelo.InfoTabla;

/**
 *
 * @author Particular
 */
public class EntradaLoteIT extends ITGenerales{
    /*
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "entradalote";
    
    private ParametrosDeCampo idPDC = new ParametrosDeCampo();
    private ParametrosDeCampo fechaRecepcionLotePDC = new ParametrosDeCampo();
    private ParametrosDeCampo cantidadPDC = new ParametrosDeCampo();
    private ParametrosDeCampo idRefaccionPDC = new ParametrosDeCampo();
    private ParametrosDeCampo idEmpleadoPDC = new ParametrosDeCampo();

    public EntradaLoteIT() {
        idPDC.setNombre("id");
        idPDC.setLongitudDeCaracteres(11);
        idPDC.setTipoDeDatos("int");
        idPDC.setNulo(false);
        idPDC.setAutoIncrement(true);
        idPDC.setPermiteRepetido(false);

        fechaRecepcionLotePDC.setNombre("fechaRecepcionLote");
        fechaRecepcionLotePDC.setNombreParaMostrar("Fecha de Lote");
        fechaRecepcionLotePDC.setLongitudDeCaracteres(8);
        fechaRecepcionLotePDC.setTipoDeDatos("date");
        fechaRecepcionLotePDC.setNulo(false);
        fechaRecepcionLotePDC.setAutoIncrement(false);
        fechaRecepcionLotePDC.setPermiteRepetido(true);

        cantidadPDC.setNombre("cantidad");
        cantidadPDC.setNombreParaMostrar("Cantidad que entra");
        cantidadPDC.setLongitudDeCaracteres(10);
        cantidadPDC.setLongitudDeDecimales(3);
        cantidadPDC.setTipoDeDatos("float");
        cantidadPDC.setNulo(false);
        cantidadPDC.setAutoIncrement(false);
        cantidadPDC.setPermiteRepetido(true);

        idRefaccionPDC.setNombre("idRefaccion");
        idRefaccionPDC.setNombreParaMostrar("Nombre de la refacción");
        idRefaccionPDC.setLongitudDeCaracteres(11);
        idRefaccionPDC.setTipoDeDatos("int");
        idRefaccionPDC.setNulo(false);
        idRefaccionPDC.setAutoIncrement(false);
        idRefaccionPDC.setPermiteRepetido(true);

        idEmpleadoPDC.setNombre("idEmpleado");
        idEmpleadoPDC.setNombreParaMostrar("Nombre del empleado");
        idEmpleadoPDC.setLongitudDeCaracteres(11);
        idEmpleadoPDC.setTipoDeDatos("int");
        idEmpleadoPDC.setNulo(false);
        idEmpleadoPDC.setAutoIncrement(false);
        idEmpleadoPDC.setPermiteRepetido(true);
        
        camposPDC.add(idPDC);
        camposPDC.add(fechaRecepcionLotePDC);
        camposPDC.add(cantidadPDC);
        camposPDC.add(idRefaccionPDC);
        camposPDC.add(idEmpleadoPDC);
    
    
    }

    public ParametrosDeCampo getIdPDC() {
        return idPDC;
    }

    public void setIdPDC(ParametrosDeCampo idPDC) {
        this.idPDC = idPDC;
    }

    public ParametrosDeCampo getFechaRecepcionLotePDC() {
        return fechaRecepcionLotePDC;
    }

    public void setFechaRecepcionLotePDC(ParametrosDeCampo fechaRecepcionLotePDC) {
        this.fechaRecepcionLotePDC = fechaRecepcionLotePDC;
    }

    public ParametrosDeCampo getCantidadPDC() {
        return cantidadPDC;
    }

    public void setCantidadPDC(ParametrosDeCampo cantidadPDC) {
        this.cantidadPDC = cantidadPDC;
    }

    public ParametrosDeCampo getIdRefaccionPDC() {
        return idRefaccionPDC;
    }

    public void setIdRefaccionPDC(ParametrosDeCampo idRefaccionPDC) {
        this.idRefaccionPDC = idRefaccionPDC;
    }

    public ParametrosDeCampo getIdEmpleadoPDC() {
        return idEmpleadoPDC;
    }

    public void setIdEmpleadoPDC(ParametrosDeCampo idEmpleadoPDC) {
        this.idEmpleadoPDC = idEmpleadoPDC;
    }
    
    
    
    
            
    
}
