package modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controlador.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Gestión de las conexiones a la base de datos.
 * @author angel
 */
public class Conexion {
 
    private Connection conexion;
   
    //public Statement stm;
    //public ResultSet rst;
    private final boolean exitosa;
    private boolean queryExitoso;
    private final Coordinador controlador;
    //private CapturaDeSucesos capturaDeSuscesos;
//    private final String contrasenaServidor = "";
//    private final String usuarioServidor = "root";
//    /**
//     * Dirección donde esta alojado el servidor de datos e imagenes. 
//     */
//    public static final String URL_SERVIDOR = "127.0.0.1/";
//    
//    /**
//     *La ruta donde se alojaran las imagenes.  
//     */
//    public static final String RUTA_IMAGENES_SERVIDOR = "imagenes/";
//    /**
//     *El fichero php que recivira las imagenes. 
//     */
//    private final String bd = "controlderefacciones";
//    public static final String PROTOCOLO = "http://";
//    public static final String SUBIDA_IMAGEN = PROTOCOLO + URL_SERVIDOR+"$u63_4rc8iv0.php";
//    public static final String ELIMINAR_IMAGEN = PROTOCOLO + URL_SERVIDOR+"3l1m1n4r.php";
    private HashMap<Integer, String> algo;
    
            

    /**
     * Gestiona las conexiones con la base de datos. Los datos se añaden modificando
     * directamente esta clase.
     * 
     * @param controlador El jefe de jefe, señores!
     */
    public Conexion(Coordinador controlador) {
        this.controlador = controlador;
        //this.capturaDeSuscesos = new CapturaDeSucesos(this.controlador);
        //this.capturaDeSuscesos.println("[+] CONECTANDO A LA BASE DE DATOS.");
        this.controlador.getSystemOut().println("[+] CONECTANDO A LA BASE DE DATOS.");
        this.exitosa = Miconexion();
    }

    //CREAMOS UNA CONEXION CONSTANTE. 
    private boolean Miconexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");  
            this.conexion= DriverManager.getConnection("jdbc:mysql://"
                    +ConexionDatos.URL_SERVIDOR
                    +ConexionDatos.BD,
                    ConexionDatos.USUARIO_SERVIDOR,
                    ConexionDatos.CONTRASENA_SERVIDOR);
            //ELIMI
            //this.stm=this.conexion.createStatement();
            this.controlador.getSystemOut().println("[+] CONEXIÓN EXITOSA: "+ConexionDatos.URL_SERVIDOR );
              return true;    
        } 
        catch(ClassNotFoundException | SQLException e){
//            DescripcionDeSuceso descripcionDeSusceso = new DescripcionDeSuceso();
//            descripcionDeSusceso.setMensajeDeError("[!] NO SE PUDO CONECTAR A LA BD.");
//            descripcionDeSusceso.setDetallesDelError(
//                    "   [-] No se conecto a la base de "
//                    + "datos por alguna razón.  \n\n" + e);
//            descripcionDeSusceso.setUbicacion(this);
//            descripcionDeSusceso.setTipoDeError(
//                    descripcionDeSusceso.tipoDeSucesoOErrores.ERROR_FATAL);
//            
//            
//            this.controlador.getSystemOut().setDescripcionDeSuceso(descripcionDeSusceso);
//            this.controlador.getSystemOut().ejecutar();
            
             JOptionPane.showMessageDialog(
                        null, "No se puede conectar "
                        + "a la base de datos: \n"+e.getMessage());
            System.exit(0);
                                        
            return false;
        }
    }
    
    /**
     * Si la conexión al servidor se realizo exitosamente.
     * @return True si la conexión se realizo con éxito. 
     */ 
    public boolean isExitosa() {
        return exitosa;
    }
    
    
     /**
     * Solo comando DDL (Data Definition Languaje)(SELECT, 
     * Ejecuta la sentencia que se le pase como parametro. Lo importante de esta 
     * sentencia es que evita SQLInjection. <br>
     * 
     * La estructura a utilizar es la siguiente:<br> 
     * 
     * <p style="color:rgb(255,255,0);" >
     * sql = "SELECT * FROM tabla WHERE id=? and user=?";
     * </p>
     * 
     * <br>
     * 
     * Los singnos de interrogación serán sustituidos por
     * el número que le pasemos en el HasMap. Por ejemplo:<br>
     * <p style="color:rgb(255,255,0);" >
     * mapa.put(1, "dato");<br>
     * mapa.put(2, "dato 2");<br>
     * </p>
     * 
     * @param sql  La sentencia con '?' para ser sustituido.
     * @param datos  El HashMap que contiene los datos para sustituir.
     * @return  ResulSet para iterar en caso de que la consulta haya devuelto
     * algún dato.
     * 
     * 
     */
    public ResultSet executeQuery (String sql, HashMap<Integer, String> datos){
        this.controlador.getSystemOut().println("[SQL] EJECUTANDO QUERY", this);
        return this.ejecutarSentencia(sql, datos, true);
    }
    
    /**
     * Solo comando DML (Data Manipulation Languaje)(INSERT, UPDATE, CREATE TABLE,
     * DELETE)
     * Ejecuta la sentencia que se le pase como parametro. Lo importante de esta 
     * sentencia es que evita SQLInjection. <br>
     * 
     * La estructura a utilizar es la siguiente:<br> 
     * 
     * <p style="color:rgb(255,255,0);" >
     * sql = "INSERT INTO tabla VALUES (null, ?,?) WHERE campo= ?";
     * </p>
     * 
     * <br>
     * 
     * Los singnos de interrogación serán sustituidos por
     * el número que le pasemos en el HasMap. Por ejemplo:<br>
     * <p style="color:rgb(255,255,0);" >
     * mapa.put(1, "dato");<br>
     * mapa.put(2, "dato 2");<br>
     * </p>
     * 
     * @param sql  La sentencia con '?' para ser sustituido.
     * @param datos  El HashMap que contiene los datos para sustituir.
     * @return Retorna true si la sentencia de se ejecuto de manera correcta.
     * 
     * 
     */
    public boolean executeUpdate(String sql, HashMap<Integer, String> datos){
        this.controlador.getSystemOut().println("[SQL] EJECUTANDO UPDATE", this);
        this.ejecutarSentencia(sql, datos, false);
        return queryExitoso;
    }
    
    /**
     * Solo comando DML (Data Manipulation Languaje)(INSERT, UPDATE, CREATE TABLE,
     * DELETE)
     * Ejecuta la sentencia que se le pase como parametro. Lo importante de esta 
     * sentencia es que evita SQLInjection. <br>
     * 
     * La estructura a utilizar es la siguiente:<br> 
     * 
     * <p style="color:rgb(255,255,0);" >
     * sql = "INSERT INTO tabla VALUES (null, ?)";
     * </p>
     * 
     * <br>
     * 
     * El signo de interrogación será sustituido por el valor que se le pase a datos.
     * @param sql  La sentencia con '?' para ser sustituido.
     * @param datos  El HashMap que contiene los datos para sustituir.
     * @return Retorna true si la sentencia de se ejecuto de manera correcta.
     * 
     */
    public boolean executeUpdate(String sql, String datos){
        this.controlador.getSystemOut().println("[SQL] EJECUTANDO UPDATE", this);
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, datos);
        this.executeUpdate(sql, map);
        return this.queryExitoso;
    }
   
    //executeOrUpdate True para executeQuery, false para updateQuery.
    // executeQuery retorna un ResulSet pero no se puede utilizar para DDL (Data
    // Definition Languaje). Para esto necesitamos executeUpdate que si lo permite.
    // executeUpdate retorna un entero que por el momento no estamos capturando.
    // 
    private ResultSet ejecutarSentencia (String sql, HashMap<Integer, String> datos, boolean executeOrUpdate){
        
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        this.queryExitoso = false;
        try {
            //SI EL STRING CONTIENE ? Y LOS DATOS QUE LE PASAMOS NO SON NULL
            //QUIERE DECIR QUE HAY UN ERROR. 
            if(!sql.contains("?") && datos!=null){
                throw new ExcepcionPersonalizada(
                        "No definiste ningún '?' para el PreparedStatement", 
                        this,
                        "executeQuery");
            }
            
            preparedStatement = this.conexion.prepareStatement(sql);
            if (datos!=null) {
                for (Map.Entry<Integer, String> entry : datos.entrySet()) {
                    Integer posicion = entry.getKey();
                    String dato = entry.getValue();
                    System.out.println("depurando conexion preparedstatement");
                    switch(TipoDeDato.encontrarTipoDeDato(dato)){
                        case TipoDeDato.STRING:
                            System.out.println("string");
                            preparedStatement.setString(posicion, dato);
                            break;
                        case TipoDeDato.INTEGER:
                            System.out.println("integer");
                            preparedStatement.setInt(posicion, Integer.parseInt(dato));
                            break;
                        case TipoDeDato.FLOAT:
                            System.out.println("float");
                            preparedStatement.setFloat(posicion, Float.parseFloat(dato));
                            break;
                        case TipoDeDato.DOUBLE:
                            System.out.println("double");
                            preparedStatement.setDouble(posicion, Float.parseFloat(dato));
                            break;
                        case TipoDeDato.DATE:
                            System.out.println("date");
                            preparedStatement.setDate(posicion, java.sql.Date.valueOf(dato));
                            break;
                        case TipoDeDato.TIMESTAMP:
                            System.out.println("TimeStamp");
                            preparedStatement.setTimestamp(posicion, java.sql.Timestamp.valueOf(dato));
                            break;
                        default:
                           throw new ExcepcionPersonalizada(
                            "Esta excepcion se lanzo desde conexión por que el dato que \n"
                            + "pasaste al preparedStatement no coincidio con ningúna de las \n"
                            + "validaciones que definiste para seleccionar la función.", 
                            this,
                            "TipoDeDato.tipoDeDato(dato)");
                    }
                }
            }
            if (executeOrUpdate) {
                rs = preparedStatement.executeQuery();
            }else{
                rs = null;
                preparedStatement.executeUpdate();
            }
            String sqlMostrar = preparedStatement.toString().split(":")[1];
            this.controlador.getSystemOut().println(
                    "[SQL]" + sqlMostrar, this);
            this.queryExitoso = true;
        } catch (SQLException ex) {
            System.out.println("ERROR ->" + preparedStatement.toString());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExcepcionPersonalizada e){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return rs;
    }
    
    
    
    
    /**
     * Ejecuta la sentencia que se le pase como parametro. Lo importante de esta 
     * sentencia es que evita SQLInjection. Para pasar más parametros usar la
     * sobrecarga con HashMap.<br>
     * 
     * La estructura a utilizar es la siguiente:<br> 
     * 
     * <p style="color:rgb(255,255,0);" >
     * sql = "SELECT * FROM tabla WHERE id=?;
     * </p>
     * 
     * <br>
     * 
     * El singno de interrogación serán sustituido por el string
     * que le pasamoscomo dato. Por ejemplo:<br>
     * 
     * @param sql  La sentencia con '?' para ser sustituido.
     * @param dato  El HashMap que contiene los datos para sustituir.
     * @return  ResulSet para iterar en caso de que la consulta haya devuelto
     * algún dato.
     * 
     * 
     */
    public ResultSet executeQuery (String sql, String dato){
        //PARA FACILITAR LAS CONSULTAS CUANDO SOLO SEA UN DATO.
        HashMap<Integer, String> datos = new HashMap<>();
        datos.put(1, dato);
        ResultSet rs = this.executeQuery(sql, datos);
        return rs;
    }
    
    
    /**
     * Ejecuta una sentencia simple sin parametros en la consulta. 
     * Por ejemplo:.<br>
     * 
     * <p style="color:rgb(255,255,0);" >
     * sql = "SELECT * FROM tabla;
     * </p>
     * 
     * <br>
     * 
     *
     * @param sql  La sentencia sql.
     * @return  ResulSet para iterar en caso de que la consulta haya devuelto
     * algún dato.
     * 
     * 
     */
    public ResultSet executeQuery (String sql){
        //PARA FACILITAR LAS CONSULTAS CUANDO SOLO SEA UN DATO.
        HashMap<Integer, String> datos = null;
        ResultSet rs = this.executeQuery(sql, datos);
        return rs;
    }
}
