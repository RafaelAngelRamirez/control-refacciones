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
public class RelacionRefaccionMaquinaModeloIT  extends ITGenerales{
    /**
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "relacionrefaccionmaquinamodelo";
    

    
    private static final ParametrosDeCampo ID_MAQUINA_MODELO = new ParametrosDeCampo();
    private static final ParametrosDeCampo ID_REFACCION = new ParametrosDeCampo();

    public RelacionRefaccionMaquinaModeloIT() {
        
        ID_MAQUINA_MODELO.setNombre("idMaquinaModelo");
        ID_MAQUINA_MODELO.setLongitudDeCaracteres(11);
        ID_MAQUINA_MODELO.setTipoDeDatos("int");
        ID_MAQUINA_MODELO.setNulo(false);
        ID_MAQUINA_MODELO.setAutoIncrement(false);
        ID_MAQUINA_MODELO.setPermiteRepetido(true);
        ID_MAQUINA_MODELO.setNombreParaMostrar("Modelo-Maquina");

        ID_REFACCION.setNombre("idRefaccion");
        ID_REFACCION.setLongitudDeCaracteres(11);
        ID_REFACCION.setTipoDeDatos("int");
        ID_REFACCION.setNulo(false);
        ID_REFACCION.setAutoIncrement(false);
        ID_REFACCION.setPermiteRepetido(true);
        
        CAMPOS_PDC.add(ID_MAQUINA_MODELO);
        CAMPOS_PDC.add(ID_REFACCION);
    
    }   

    public static ParametrosDeCampo getID_MAQUINA_MODELO() {
        return ID_MAQUINA_MODELO;
    }

    

    public static ParametrosDeCampo getID_REFACCION() {
        return ID_REFACCION;
    }

    
    
    
    
    
    
}
