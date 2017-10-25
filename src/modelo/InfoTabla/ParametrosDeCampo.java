
package modelo.InfoTabla;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import controlador.capturadeerrores.ExcepcionPersonalizada;
/**
 * Esta clase maneja guarda los parametros del campo que tienen que coincidir 
 * con los de la base de datos. 
 * 
 * @author Rafael Ángel Ramírez Estrada
 */
public class ParametrosDeCampo {
  
    
    private String nombre;
    private String nombreParaMostrar;
    private int longitudDeCaracteres;
    private int longitudDeDecimales;
    private String tipoDeDatos;
    private boolean nulo;
    private boolean autoIncrement;
    private boolean permiteRepetido;
    
    List<String> tiposDeDatoEnLaBD = new ArrayList<>();

    public ParametrosDeCampo() {
        this.permiteRepetido = true;
    //LOS TIPOS DE DATOS QUE PODEMO DEFINIR. TIENEN QUE IR SEGÚN LA BASE DE DATOS.
    
    tiposDeDatoEnLaBD.add("varchar");
    tiposDeDatoEnLaBD.add("float");
    tiposDeDatoEnLaBD.add("int");
    tiposDeDatoEnLaBD.add("date");
    tiposDeDatoEnLaBD.add("datetime");
    tiposDeDatoEnLaBD.add("boolean");
    tiposDeDatoEnLaBD.add("longint");
    tiposDeDatoEnLaBD.add("byte");
    }
    
    /**
     * Nombre del campo como esta definido en la tabla. 
     * @return El nombre del campo. 
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Nombre del campo. Definir como esta en la base de datos. 
     * 
     * @param nombre El nombre del campo como esta en la base de datos. 
     */
    

    public String getNombreParaMostrar() {
        return nombreParaMostrar;
    }
    
    /**
     * Nombre para mostrar del campo. Definir como se quiere mostrar. 
     * @param nombreParaMostrar El nombre que se mostrara al usuario. 
     */
    

    public List<String> getTiposDeDatoEnLaBD() {
        return tiposDeDatoEnLaBD;
    }

    
    
    
    
    /**
     * Cantidad de caracteres definidos para el campo en la base de datos. 
     * @return La longitud de los caracteres que se definieron en la base de datos. 
     */
    public int getLongitudDeCaracteres() {
        Integer a = new Integer(longitudDeCaracteres);
        if (a == null) {
            try {
                throw new ExcepcionPersonalizada(
                        "No definiste logitud de caracteres.",
                        this,
                        "getLongitudDeCaracteres");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(ParametrosDeCampo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return longitudDeCaracteres;
    }
    
    /**
     * Longitud del campo como se definio en la bae de datos. 
     * @param longitudDeCaracteres La longitud de los caracteres que se definieron en la base de datos. 
     */
    
    
    /**
     * Cantidad de decimales definidos para los tipos float y decimal en la 
     * base de datos.
     * @return La longitud de los decimales que se definieron en la base de datos. 
     */
    public int getLongitudDeDecimales() {
        try {
            Integer a = new Integer(longitudDeDecimales);
            if (a == null) {
                throw new ExcepcionPersonalizada(
                        "No definiste logitud de decimales o lo declaraste antes \n"
                                + " de setear los la longitud de decimales..",
                        this,
                        "getLongitudDeDecimales");
            }else if(this.tipoDeDatos.equals("varchar")){
                throw new ExcepcionPersonalizada(
                        "El campo esta definido como tipo varchar.",
                        this,
                        "getLongitudDeDecimales");
                
            }else if(this.tipoDeDatos.equals("int")){
                throw new ExcepcionPersonalizada(
                        "El campo esta definido como tipo int.",
                        this,
                        "getLongitudDeDecimales");
            }else if(this.tipoDeDatos.equals("date")){
                throw new ExcepcionPersonalizada(
                        "El campo esta definido como tipo date.",
                        this,
                        "getLongitudDeDecimales");
            }else if(!this.tipoDeDatos.equals("float") && !this.tipoDeDatos.equals("decimal")){
                throw new ExcepcionPersonalizada(
                        "El campo es diferente de float y decimal .",
                        this,
                        "getLongitudDeDecimales");
            
            }
        } catch (ExcepcionPersonalizada ex) {
            Logger.getLogger(ParametrosDeCampo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return longitudDeDecimales;
    }

    /**
     * Longitud de los decimales en la tabla. No necesario para cadenas, pero
     * si es necesario que se defina el tipo de datos para descartar las comprobaciones
     * de este tipo.
     * @param longitudDeDecimales La longitud de los decimales que se definieron en la base de datos. 
     */
    
                throw new ExcepcionPersonalizada(
                        "No has definido el tipo de dato del campo.",
                        this,
                        "setLongitudDeDecimales");
            }else if(this.tipoDeDatos.equals("varchar")){
                throw new ExcepcionPersonalizada(
                        "El campo esta definido como tipo varchar.",
                        this,
                        "setLongitudDeDecimales");
            }else if(this.tipoDeDatos.equals("int")){
                throw new ExcepcionPersonalizada(
                        "El campo esta definido como tipo int.",
                        this,
                        "setLongitudDeDecimales");
            }else if(this.tipoDeDatos.equals("date")){
                throw new ExcepcionPersonalizada(
                        "El campo esta definido como tipo date.",
                        this,
                        "setLongitudDeDecimales");
            }else if(!this.tipoDeDatos.equals("float") && !this.tipoDeDatos.equals("decimal")){
                throw new ExcepcionPersonalizada(
                        "El campo es diferente de float y decimal .",
                        this,
                        "setLongitudDeDecimales");
            
            }
        } catch (ExcepcionPersonalizada ex) {
            Logger.getLogger(ParametrosDeCampo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.longitudDeDecimales = longitudDeDecimales;
    }
    
    /**
     * Tipo de datos definido en la tabla. 
     * @return Retorna una cadena con el tipo de datos. 
     */
    public String getTipoDeDatos() {
        if (tipoDeDatos.isEmpty()) {
            try {
                throw new ExcepcionPersonalizada(
                        "No definiste el tipo de datos.",
                        this,
                        "getTipoDeDatos");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(ParametrosDeCampo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return tipoDeDatos;
    }

    /**
     * Tipo de datos para el campo definido en la tabla. 
     * @param tipoDeDatos Define el tipo de datos que aceptara. 
     */
    
                throw new ExcepcionPersonalizada(
                        "El tipo de datos '"+tipoDeDatos+"' no existe. \n"
                                + "Si es un error por favor corrige la clase ParametrosDeCampo",
                        this,
                        "setTipoDeDatos");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(ParametrosDeCampo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.tipoDeDatos = tipoDeDatos;
    }
    
    /**
     * Retorna true o false según sea el caso definido en la tabla para el campo. 
     * @return True si permite nulos. 
     */
    public boolean isNulo() {
        Boolean a = new Boolean(nulo);
        if (a == null) {
            try {
                throw new ExcepcionPersonalizada(
                        "No definiste si el campo acepta nulos.",
                        this,
                        "isNulo");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(ParametrosDeCampo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return nulo;
    }
    
    /**
     *Permite valores nulos dentro de la tabla. 
     * @param nulo True si se permite nulo. 
     */
    
                throw new ExcepcionPersonalizada(
                        "El campo esta definido como autoincrement y no puede ser nulo.",
                        this,
                        "isNulo");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(ParametrosDeCampo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.nulo = nulo;
    }
    
    /**
     * Retorna true o false según sea el caso definido en la tabla para el campo. 
     * @return Retorna true si es autoincremente. 
     */
    public boolean isAutoIncrement() {
        Boolean a = autoIncrement;
        if (a == null) {
            try {
                throw new ExcepcionPersonalizada(
                        "No definiste si el campo es autoincrement.",
                        this,
                        "isNulo");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(ParametrosDeCampo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return autoIncrement;
    }

    /**
     * La columna esta definida como autoincrement. 
     * @param autoIncrement True para definir como autoincrement. 
     */
    
                throw new ExcepcionPersonalizada(
                        "El campo esta definido como null y no puede ser autoincrement.",
                        this,
                        "isNulo");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(ParametrosDeCampo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.autoIncrement = autoIncrement;
    }

    public boolean isPermiteRepetido() {
        return permiteRepetido;
    }

    
    
}
