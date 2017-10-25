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
    
    private static final ParametrosDeCampo ID = new ParametrosDeCampo();
    private static final ParametrosDeCampo ID_REFACCION = new ParametrosDeCampo();
    private static final ParametrosDeCampo ID_MAQUINA_EN_LA_QUE_SE_USARA = new ParametrosDeCampo();
    private static final ParametrosDeCampo ID_EMPLEADO = new ParametrosDeCampo();
    private static final ParametrosDeCampo FECHA_SALIDA = new ParametrosDeCampo();
    private static final ParametrosDeCampo CANTIDAD = new ParametrosDeCampo();
    private static final ParametrosDeCampo OBSERVACIONES = new ParametrosDeCampo();

    public SalidaDeControlIT() {
        
        ID.setNombre("id");
        ID.setLongitudDeCaracteres(11);
        ID.setTipoDeDatos("int");
        ID.setNulo(false);
        ID.setAutoIncrement(true);
        ID.setPermiteRepetido(false);
       
        ID_REFACCION.setNombre("idRefaccion");
        ID_REFACCION.setLongitudDeCaracteres(11);
        ID_REFACCION.setTipoDeDatos("int");
        ID_REFACCION.setNulo(false);
        ID_REFACCION.setAutoIncrement(false);
        ID_REFACCION.setPermiteRepetido(true);
        
        ID_MAQUINA_EN_LA_QUE_SE_USARA.setNombre("idMaquinaEnLaQueSeUsara");
        ID_MAQUINA_EN_LA_QUE_SE_USARA.setLongitudDeCaracteres(11);
        ID_MAQUINA_EN_LA_QUE_SE_USARA.setTipoDeDatos("int");
        ID_MAQUINA_EN_LA_QUE_SE_USARA.setNulo(true);
        ID_MAQUINA_EN_LA_QUE_SE_USARA.setAutoIncrement(false);
        ID_MAQUINA_EN_LA_QUE_SE_USARA.setPermiteRepetido(true);
        ID_MAQUINA_EN_LA_QUE_SE_USARA.setNombreParaMostrar("Maquina en la que se utilizara.");
       
        ID_EMPLEADO.setNombre("idEmpleado");
        ID_EMPLEADO.setLongitudDeCaracteres(11);
        ID_EMPLEADO.setTipoDeDatos("int");
        ID_EMPLEADO.setNulo(false);
        ID_EMPLEADO.setAutoIncrement(false);
        ID_EMPLEADO.setPermiteRepetido(true);
        
        FECHA_SALIDA.setNombre("fechaSalida");
//        FECHA_SALIDA.setLongitudDeCaracteres();
        FECHA_SALIDA.setTipoDeDatos("timestamp");
        FECHA_SALIDA.setNulo(false);
        FECHA_SALIDA.setAutoIncrement(false);
        FECHA_SALIDA.setPermiteRepetido(true);
        FECHA_SALIDA.setNombreParaMostrar("FechaDeSalida");
        
        CANTIDAD.setNombre("cantidad");
        CANTIDAD.setLongitudDeCaracteres(10);
        CANTIDAD.setLongitudDeDecimales(3);
        CANTIDAD.setTipoDeDatos("float");
        CANTIDAD.setNulo(false);
        CANTIDAD.setAutoIncrement(false);
        CANTIDAD.setPermiteRepetido(true);
        CANTIDAD.setNombreParaMostrar("Cantidad");
        
        OBSERVACIONES.setNombre("observaciones");
        OBSERVACIONES.setLongitudDeCaracteres(200);
        OBSERVACIONES.setTipoDeDatos("varchar");
        OBSERVACIONES.setNulo(true);
        OBSERVACIONES.setAutoIncrement(false);
        OBSERVACIONES.setPermiteRepetido(true);
        OBSERVACIONES.setNombreParaMostrar("Observaciones");

        CAMPOS_PDC.add(ID);
        CAMPOS_PDC.add(ID_REFACCION);
        CAMPOS_PDC.add(ID_MAQUINA_EN_LA_QUE_SE_USARA);
        CAMPOS_PDC.add(ID_EMPLEADO);
        CAMPOS_PDC.add(FECHA_SALIDA);
        CAMPOS_PDC.add(CANTIDAD);
        CAMPOS_PDC.add(OBSERVACIONES);
        
        
    }

    public static ParametrosDeCampo getID() {
        return ID;
    }

    

    public static ParametrosDeCampo getID_REFACCION() {
        return ID_REFACCION;
    }

    

    public static ParametrosDeCampo getID_MAQUINA_EN_LA_QUE_SE_USARA() {
        return ID_MAQUINA_EN_LA_QUE_SE_USARA;
    }

    

    public static ParametrosDeCampo getID_EMPLEADO() {
        return ID_EMPLEADO;
    }

    

    public static ParametrosDeCampo getFECHA_SALIDA() {
        return FECHA_SALIDA;
    }

    

    public static ParametrosDeCampo getCANTIDAD() {
        return CANTIDAD;
    }

    

    public static ParametrosDeCampo getOBSERVACIONES() {
        return OBSERVACIONES;
    }

    
    
    
    

    
    
    
}
