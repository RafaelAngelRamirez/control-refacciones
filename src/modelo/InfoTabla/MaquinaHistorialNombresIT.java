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
public class MaquinaHistorialNombresIT extends ITGenerales{
    
    public static final String NOMBRE_TABLA = "maquinahistorialnombres";
    
    private ParametrosDeCampo idMaquinaPDC = new ParametrosDeCampo();
    private ParametrosDeCampo nombreAnteriorPDC = new ParametrosDeCampo();
    private ParametrosDeCampo fechaDeCambioPDC = new ParametrosDeCampo();

    public MaquinaHistorialNombresIT() {
        
        idMaquinaPDC.setNombre("idMaquina");
        idMaquinaPDC.setLongitudDeCaracteres(11);
        idMaquinaPDC.setTipoDeDatos("int");
        idMaquinaPDC.setNulo(false);
        idMaquinaPDC.setAutoIncrement(false);
        idMaquinaPDC.setPermiteRepetido(true);
        
        nombreAnteriorPDC.setNombre("nombre");
        nombreAnteriorPDC.setLongitudDeCaracteres(50);
        nombreAnteriorPDC.setTipoDeDatos("varchar");
        nombreAnteriorPDC.setNulo(false);
        nombreAnteriorPDC.setAutoIncrement(false);
        nombreAnteriorPDC.setPermiteRepetido(true);
        
        fechaDeCambioPDC.setNombre("fechaDeCambio");
        fechaDeCambioPDC.setLongitudDeCaracteres(50);
        fechaDeCambioPDC.setTipoDeDatos("datetime");
        fechaDeCambioPDC.setNulo(false);
        fechaDeCambioPDC.setAutoIncrement(false);
        fechaDeCambioPDC.setPermiteRepetido(true);
        
        camposPDC.add(idMaquinaPDC);
        camposPDC.add(nombreAnteriorPDC);
        camposPDC.add(fechaDeCambioPDC);
        
    }

    public ParametrosDeCampo getFechaDeCambioPDC() {
        return fechaDeCambioPDC;
    }

    
    
    public ParametrosDeCampo getIdMaquinaPDC() {
        return idMaquinaPDC;
    }

    

    public ParametrosDeCampo getNombreAnteriorPDC() {
        return nombreAnteriorPDC;
    }

    
    
}
