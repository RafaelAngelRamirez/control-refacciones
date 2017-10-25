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
public class RelacionMaqModSeccionDeMaquinaIT extends ITGenerales{
    
     /*
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "relacionmaqmodsecciondemaquina";
    
    private ParametrosDeCampo idSeccionMaq = new ParametrosDeCampo();
    private ParametrosDeCampo idMaquinaModelo = new ParametrosDeCampo();

    public RelacionMaqModSeccionDeMaquinaIT() {
        idSeccionMaq.setNombre("idSeccionMaq");
        idSeccionMaq.setLongitudDeCaracteres(11);
        idSeccionMaq.setTipoDeDatos("int");
        idSeccionMaq.setNulo(false);
        idSeccionMaq.setAutoIncrement(false);
        idSeccionMaq.setPermiteRepetido(true);

        idMaquinaModelo.setNombre("idMaquinaModelo");
        idMaquinaModelo.setLongitudDeCaracteres(11);
        idMaquinaModelo.setTipoDeDatos("int");
        idMaquinaModelo.setNulo(false);
        idMaquinaModelo.setAutoIncrement(false);
        idMaquinaModelo.setPermiteRepetido(true);
        
        camposPDC.add(idSeccionMaq);
        camposPDC.add(idMaquinaModelo);
      
        
    }

    public ParametrosDeCampo getIdSeccionMaq() {
        return idSeccionMaq;
    }

    

    public ParametrosDeCampo getIdMaquinaModelo() {
        return idMaquinaModelo;
    }

    
    
}
