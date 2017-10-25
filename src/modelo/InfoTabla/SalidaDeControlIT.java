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
    private ParametrosDeCampo idRefaccionPDC = new ParametrosDeCampo();
    private ParametrosDeCampo idMaquinaEnLaQueSeUsaraPDC = new ParametrosDeCampo();
    private ParametrosDeCampo idEmpleadoPDC = new ParametrosDeCampo();
    private ParametrosDeCampo fechaSalidaPDC = new ParametrosDeCampo();
    private ParametrosDeCampo cantidadPDC = new ParametrosDeCampo();
    private ParametrosDeCampo observacionesPDC = new ParametrosDeCampo();

    public SalidaDeControlIT() {
        
        idPDC.setNombre("id");
        idPDC.setLongitudDeCaracteres(11);
        idPDC.setTipoDeDatos("int");
        idPDC.setNulo(false);
        idPDC.setAutoIncrement(true);
        idPDC.setPermiteRepetido(false);
       
        idRefaccionPDC.setNombre("idRefaccion");
        idRefaccionPDC.setLongitudDeCaracteres(11);
        idRefaccionPDC.setTipoDeDatos("int");
        idRefaccionPDC.setNulo(false);
        idRefaccionPDC.setAutoIncrement(false);
        idRefaccionPDC.setPermiteRepetido(true);
        
        idMaquinaEnLaQueSeUsaraPDC.setNombre("idMaquinaEnLaQueSeUsara");
        idMaquinaEnLaQueSeUsaraPDC.setLongitudDeCaracteres(11);
        idMaquinaEnLaQueSeUsaraPDC.setTipoDeDatos("int");
        idMaquinaEnLaQueSeUsaraPDC.setNulo(true);
        idMaquinaEnLaQueSeUsaraPDC.setAutoIncrement(false);
        idMaquinaEnLaQueSeUsaraPDC.setPermiteRepetido(true);
        idMaquinaEnLaQueSeUsaraPDC.setNombreParaMostrar("Maquina en la que se utilizara.");
       
        idEmpleadoPDC.setNombre("idEmpleado");
        idEmpleadoPDC.setLongitudDeCaracteres(11);
        idEmpleadoPDC.setTipoDeDatos("int");
        idEmpleadoPDC.setNulo(false);
        idEmpleadoPDC.setAutoIncrement(false);
        idEmpleadoPDC.setPermiteRepetido(true);
        
        fechaSalidaPDC.setNombre("fechaSalida");
//        fechaSalidaPDC.setLongitudDeCaracteres();
        fechaSalidaPDC.setTipoDeDatos("timestamp");
        fechaSalidaPDC.setNulo(false);
        fechaSalidaPDC.setAutoIncrement(false);
        fechaSalidaPDC.setPermiteRepetido(true);
        fechaSalidaPDC.setNombreParaMostrar("FechaDeSalida");
        
        cantidadPDC.setNombre("cantidad");
        cantidadPDC.setLongitudDeCaracteres(10);
        cantidadPDC.setLongitudDeDecimales(3);
        cantidadPDC.setTipoDeDatos("float");
        cantidadPDC.setNulo(false);
        cantidadPDC.setAutoIncrement(false);
        cantidadPDC.setPermiteRepetido(true);
        cantidadPDC.setNombreParaMostrar("Cantidad");
        
        observacionesPDC.setNombre("observaciones");
        observacionesPDC.setLongitudDeCaracteres(200);
        observacionesPDC.setTipoDeDatos("varchar");
        observacionesPDC.setNulo(true);
        observacionesPDC.setAutoIncrement(false);
        observacionesPDC.setPermiteRepetido(true);
        observacionesPDC.setNombreParaMostrar("Observaciones");

        camposPDC.add(idPDC);
        camposPDC.add(idRefaccionPDC);
        camposPDC.add(idMaquinaEnLaQueSeUsaraPDC);
        camposPDC.add(idEmpleadoPDC);
        camposPDC.add(fechaSalidaPDC);
        camposPDC.add(cantidadPDC);
        camposPDC.add(observacionesPDC);
        
        
    }

    public ParametrosDeCampo getIdPDC() {
        return idPDC;
    }

    

    public ParametrosDeCampo getIdRefaccionPDC() {
        return idRefaccionPDC;
    }

    

    public ParametrosDeCampo getIdMaquinaEnLaQueSeUsaraPDC() {
        return idMaquinaEnLaQueSeUsaraPDC;
    }

    

    public ParametrosDeCampo getIdEmpleadoPDC() {
        return idEmpleadoPDC;
    }

    

    public ParametrosDeCampo getFechaSalidaPDC() {
        return fechaSalidaPDC;
    }

    

    public ParametrosDeCampo getCantidadPDC() {
        return cantidadPDC;
    }

    

    public ParametrosDeCampo getObservacionesPDC() {
        return observacionesPDC;
    }

    
    
    
    

    
    
    
}
