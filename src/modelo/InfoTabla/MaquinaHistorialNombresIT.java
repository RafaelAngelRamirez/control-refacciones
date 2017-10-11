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
    
    private ParametrosDeCampo idMaquina = new ParametrosDeCampo();
    private ParametrosDeCampo nombreAnterior = new ParametrosDeCampo();

    public MaquinaHistorialNombresIT() {
        
        idMaquina.setNombre("idMaquina");
        idMaquina.setLongitudDeCaracteres(11);
        idMaquina.setTipoDeDatos("int");
        idMaquina.setNulo(false);
        idMaquina.setAutoIncrement(false);
        idMaquina.setPermiteRepetido(true);
        
        nombreAnterior.setNombre("nombre");
        nombreAnterior.setLongitudDeCaracteres(50);
        nombreAnterior.setTipoDeDatos("varchar");
        nombreAnterior.setNulo(false);
        nombreAnterior.setAutoIncrement(false);
        nombreAnterior.setPermiteRepetido(true);
        
        camposPDC.add(idMaquina);
        camposPDC.add(nombreAnterior);
        
    }

    public ParametrosDeCampo getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(ParametrosDeCampo idMaquina) {
        this.idMaquina = idMaquina;
    }

    public ParametrosDeCampo getNombreAnterior() {
        return nombreAnterior;
    }

    public void setNombreAnterior(ParametrosDeCampo nombreAnterior) {
        this.nombreAnterior = nombreAnterior;
    }
    
}
