
package modelo.dao;
import modelo.ExcepcionPersonalizada;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    tiposDeDatoEnLaBD.add("boolean");
    tiposDeDatoEnLaBD.add("longint");
    }
    
    /**
     * Nombre del campo como esta definido en la tabla. 
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Nombre del campo. Definir como esta en la base de datos. 
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreParaMostrar() {
        return nombreParaMostrar;
    }
    
    /**
     * Nombre para mostrar del campo. Definir como se quiere mostrar. 
     * @param nombreParaMostrar
     */
    public void setNombreParaMostrar(String nombreParaMostrar) {
        this.nombreParaMostrar = nombreParaMostrar;
    }

    public List<String> getTiposDeDatoEnLaBD() {
        return tiposDeDatoEnLaBD;
    }

    public void setTiposDeDatoEnLaBD(List<String> tiposDeDatoEnLaBD) {
        this.tiposDeDatoEnLaBD = tiposDeDatoEnLaBD;
    }
    
    
    
    /**
     * Cantidad de caracteres definidos para el campo en la base de datos. 
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
     * @param longitudDeCaracteres
     */
    public void setLongitudDeCaracteres(int longitudDeCaracteres) {
        this.longitudDeCaracteres = longitudDeCaracteres;
    }
    
    /**
     * Cantidad de decimales definidos para los tipos float y decimal en la 
     * base de datos.
     * @return 
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
     * Longitud de los decimales en la tabla. No necesario para cadenas. Pero
     * si es necesario que se defina el tipo de datos para descartar las comprobaciones
     * de este tipo.
     * @param longitudDeDecimales
     */
    public void setLongitudDeDecimales(int longitudDeDecimales) {
        try{
            if(this.tipoDeDatos == null){
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
     * @param tipoDeDatos
     */
    public void setTipoDeDatos(String tipoDeDatos) {
        if (!this.tiposDeDatoEnLaBD.contains(tipoDeDatos)) {
            try {
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
     */
    public void setNulo(boolean nulo) {
        if (autoIncrement && nulo) {
            try {
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
     * @param autoIncrement
     */
    public void setAutoIncrement(boolean autoIncrement) {
        if (autoIncrement && nulo) {
            try {
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

    public void setPermiteRepetido(boolean permiteRepetido) {
        this.permiteRepetido = permiteRepetido;
    }
    
}
