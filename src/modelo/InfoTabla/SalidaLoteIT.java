
package modelo.InfoTabla;

/**
 *
 * @author Particular
 */
public class SalidaLoteIT extends ITGenerales{
    /*
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "salidalote";
    
    private static final ParametrosDeCampo idPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo fechaSalidaLotePDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo cantidadPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo idRefaccionPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo idEmpleadoPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo observacionesPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo idLotePDC = new ParametrosDeCampo();
    

    public SalidaLoteIT() {
        idPDC.setNombre("id");
        idPDC.setLongitudDeCaracteres(11);
        idPDC.setTipoDeDatos("int");
        idPDC.setNulo(false);
        idPDC.setAutoIncrement(true);
        idPDC.setPermiteRepetido(false);

        fechaSalidaLotePDC.setNombre("fechaSalidaLote");
        fechaSalidaLotePDC.setNombreParaMostrar("Fecha de Lote");
        fechaSalidaLotePDC.setLongitudDeCaracteres(8);
        fechaSalidaLotePDC.setTipoDeDatos("date");
        fechaSalidaLotePDC.setNulo(false);
        fechaSalidaLotePDC.setAutoIncrement(false);
        fechaSalidaLotePDC.setPermiteRepetido(true);

        cantidadPDC.setNombre("cantidad");
        cantidadPDC.setNombreParaMostrar("Cantidad que sale");
        cantidadPDC.setTipoDeDatos("float");
        cantidadPDC.setLongitudDeCaracteres(10);
        cantidadPDC.setLongitudDeDecimales(3);
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
        
        idLotePDC.setNombre("idLote");
        idLotePDC.setNombreParaMostrar("Lote");
        idLotePDC.setLongitudDeCaracteres(11);
        idLotePDC.setTipoDeDatos("int");
        idLotePDC.setNulo(false);
        idLotePDC.setAutoIncrement(false);
        idLotePDC.setPermiteRepetido(true);

        idEmpleadoPDC.setNombre("idEmpleado");
        idEmpleadoPDC.setNombreParaMostrar("Nombre del empleado");
        idEmpleadoPDC.setLongitudDeCaracteres(11);
        idEmpleadoPDC.setTipoDeDatos("int");
        idEmpleadoPDC.setNulo(false);
        idEmpleadoPDC.setAutoIncrement(false);
        idEmpleadoPDC.setPermiteRepetido(true);
        
        observacionesPDC.setNombre("observaciones");
        observacionesPDC.setNombreParaMostrar("Observaciones");
        observacionesPDC.setLongitudDeCaracteres(200);
        observacionesPDC.setTipoDeDatos("varchar");
        observacionesPDC.setNulo(true);
        observacionesPDC.setAutoIncrement(false);
        observacionesPDC.setPermiteRepetido(true);
        
        camposPDC.add(idPDC);
        camposPDC.add(fechaSalidaLotePDC);
        camposPDC.add(cantidadPDC);
        camposPDC.add(idRefaccionPDC);
        camposPDC.add(idEmpleadoPDC);
        camposPDC.add(observacionesPDC);
    
    
    }

    public ParametrosDeCampo getIdLotePDC() {
        return idLotePDC;
    }

    public void setIdLotePDC(ParametrosDeCampo idLotePDC) {
        this.idLotePDC = idLotePDC;
    }
    
    public ParametrosDeCampo getIdPDC() {
        return idPDC;
    }

    public void setIdPDC(ParametrosDeCampo idPDC) {
        this.idPDC = idPDC;
    }

    public ParametrosDeCampo getFechaSalidaLotePDC() {
        return fechaSalidaLotePDC;
    }

    public void setFechaSalidaLotePDC(ParametrosDeCampo fechaSalidaLotePDC) {
        this.fechaSalidaLotePDC = fechaSalidaLotePDC;
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

    public ParametrosDeCampo getObservacionesPDC() {
        return observacionesPDC;
    }

    public void setObservacionesPDC(ParametrosDeCampo observacionesPDC) {
        this.observacionesPDC = observacionesPDC;
    }
    
    
}
