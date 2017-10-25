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
    
    private static final ParametrosDeCampo ID_SECCION_MAQ = new ParametrosDeCampo();
    private static final ParametrosDeCampo ID_MAQUINA_MODELO = new ParametrosDeCampo();

    public RelacionMaqModSeccionDeMaquinaIT() {
        ID_SECCION_MAQ.setNombre("idSeccionMaq");
        ID_SECCION_MAQ.setLongitudDeCaracteres(11);
        ID_SECCION_MAQ.setTipoDeDatos("int");
        ID_SECCION_MAQ.setNulo(false);
        ID_SECCION_MAQ.setAutoIncrement(false);
        ID_SECCION_MAQ.setPermiteRepetido(true);

        ID_MAQUINA_MODELO.setNombre("idMaquinaModelo");
        ID_MAQUINA_MODELO.setLongitudDeCaracteres(11);
        ID_MAQUINA_MODELO.setTipoDeDatos("int");
        ID_MAQUINA_MODELO.setNulo(false);
        ID_MAQUINA_MODELO.setAutoIncrement(false);
        ID_MAQUINA_MODELO.setPermiteRepetido(true);
        
        CAMPOS_PDC.add(ID_SECCION_MAQ);
        CAMPOS_PDC.add(ID_MAQUINA_MODELO);
      
        
    }

    public static ParametrosDeCampo getID_SECCION_MAQ() {
        return ID_SECCION_MAQ;
    }

    

    public static ParametrosDeCampo getID_MAQUINA_MODELO() {
        return ID_MAQUINA_MODELO;
    }

    
    
}
