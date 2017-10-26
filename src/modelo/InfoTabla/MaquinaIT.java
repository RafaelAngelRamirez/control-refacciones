package modelo.InfoTabla;


import java.util.ArrayList;
import java.util.List;
import modelo.ParametrosDeCampo;


public class MaquinaIT extends ITGenerales{
    /**
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "maquina";
    
    private static final ParametrosDeCampo ID = new ParametrosDeCampo();
    private static final ParametrosDeCampo ID_MAQUINA_MODELO = new ParametrosDeCampo();
    private static final ParametrosDeCampo NUMERO_DE_MAQUINA = new ParametrosDeCampo();
    private static final ParametrosDeCampo MATRICULA = new ParametrosDeCampo();

    
    /**
     * Los campos de la tabla. 
     */
    private static final List<ParametrosDeCampo> CAMPOS_PDC = new ArrayList<>();

    public static List<ParametrosDeCampo> getCAMPOS_PDC() {
        return CAMPOS_PDC;
    }
    
    static {
        
        ID.setNombre("id");
        ID.setLongitudDeCaracteres(11);
        ID.setTipoDeDatos("int");
        ID.setNulo(false);
        ID.setAutoIncrement(true);
        ID.setPermiteRepetido(false);
        
        ID_MAQUINA_MODELO.setNombre("idMaquinaModelo");
        ID_MAQUINA_MODELO.setLongitudDeCaracteres(11);
        ID_MAQUINA_MODELO.setTipoDeDatos("int");
        ID_MAQUINA_MODELO.setNulo(false);
        ID_MAQUINA_MODELO.setAutoIncrement(false);
        ID_MAQUINA_MODELO.setPermiteRepetido(true);
        ID_MAQUINA_MODELO.setNombreParaMostrar("Modelo de máquina");
        
        
        NUMERO_DE_MAQUINA.setNombre("nombre");
        NUMERO_DE_MAQUINA.setLongitudDeCaracteres(50);
        NUMERO_DE_MAQUINA.setTipoDeDatos("varchar");
        NUMERO_DE_MAQUINA.setNulo(false);
        NUMERO_DE_MAQUINA.setAutoIncrement(false);
        NUMERO_DE_MAQUINA.setPermiteRepetido(false);
        NUMERO_DE_MAQUINA.setNombreParaMostrar("Número");
        
        MATRICULA.setNombre("matricula");
        MATRICULA.setLongitudDeCaracteres(200);
        MATRICULA.setTipoDeDatos("varchar");
        MATRICULA.setNulo(true);
        MATRICULA.setAutoIncrement(false);
        MATRICULA.setPermiteRepetido(false);
        MATRICULA.setNombreParaMostrar("Matricula");
        

        CAMPOS_PDC.add(ID);
        CAMPOS_PDC.add(ID_MAQUINA_MODELO);
        CAMPOS_PDC.add(NUMERO_DE_MAQUINA);
        CAMPOS_PDC.add(MATRICULA);
        
        
    }

    public static ParametrosDeCampo getMATRICULA() {
        return MATRICULA;
    }

    
    
    public static ParametrosDeCampo getID() {
        return ID;
    }

    

    public static ParametrosDeCampo getID_MAQUINA_MODELO() {
        return ID_MAQUINA_MODELO;
    }

    
    public static ParametrosDeCampo getNUMERO_DE_MAQUINA() {
        return NUMERO_DE_MAQUINA;
    }

    
    
    
    
    
}
