
package controlador.capturadeerrores;

import controlador.Coordinador;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Esta clase se encarga de administrar los sucesos que ocurren en el programa.
 * 
 * Una de las características que actualmente utiliza es la creación y almacenamiento
 de los logs de errores. Estoy implementando actualizar la consolaDeErrores de debug y
 la creación de archivos de log. 
 * 
 * 
 * @author Rafael Ángel Ramírez Estrada.
 */
public class CapturaDeSucesos {

//    private DescripcionDeSuceso descripcionDeSuceso;
    private final TipoDeSucesoOErrores tiposDeSucesoOErrores = new TipoDeSucesoOErrores();
    public Coordinador coordinador;
    private  boolean debug;
    
    /**
     * Retorna el jefe de jefes.
     * @return Si señor!
     */
    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
    
    
   
    /**
     * Imprime en la consolaDeErrores de debug sin guardar en log ni en base de datos.  
     * 
     * @param textoAMostrar El texto que se mostrara en la consola. 
     */
    public void println(String textoAMostrar){
       this.println(textoAMostrar, null);
    }
     /**
     * Imprime en la consolaDeErrores de debug sin guardar en log ni en base de datos.  
     * 
     * @param textoAMostrar el texto que se mostrara en la consola. 
     * @param clase La clase de donde se ejecuto la operación.
     * @param mostarVentanaEmergente Si se quiere mostrar ventana o no. 
     */
    public void println(String textoAMostrar, Object clase, boolean mostarVentanaEmergente){
        if (this.debug) {
            this.println(textoAMostrar, clase);
            JOptionPane.showMessageDialog(null, textoAMostrar);
            
        }
    }
    /**
     * Imprime en la consolaDeErrores de debug sin guardar log ni base de datos.  
     * 
     * @param textoAMostrar El texto que se quiere mostrar. 
     * @param clase La clase donde se ejecutó la operación. 
     */
    public void println(String textoAMostrar, Object clase){
        String usuario="";
//        if (this.coordinador.getUsuarioActivo() == null) {
            usuario = "SYS";
//        }else{
//            usuario = this.coordinador.getUsuarioActivo().getNombreDelUsuario();
//        }
        
        if(this.debug){
            String textoAntiguo = this.coordinador.getConsolaDeErrores().getTxtAreaConsola().getText();
            textoAntiguo = textoAntiguo +"\n" +usuario+"$"+ textoAMostrar; 
            if (clase!=null) {
                textoAntiguo = textoAntiguo 
                        + "\n         Desde |"  + clase.getClass().getName();
            }
            this.coordinador.getConsolaDeErrores().getTxtAreaConsola().setText(textoAntiguo);
        }
    }
    
//    /**
//     *  Ejecuta las acciones por defecto según el tipo de error que se definio 
//     * al pasar la descripción del suceso.
//     *  
//     */
//    public void ejecutar(){
//        
//        switch(this.descripcionDeSuceso.getTipoDeError()){
//           case 0:
//               this.mostrarMensajeEmergente();
//               this.mostrarErrorEnConsola();
//               this.EJECUTAR_ERROR_FATAL();
//               break;
//           case 2:
//               this.mostrarErrorEnConsola();
//               break;
//            
//               
//           default:
//                JOptionPane.showMessageDialog(null, "ERROR NO DEFINIDO: "
//                + this.descripcionDeSuceso.getTipoDeError());
//       }
//    }

//    
//    private void mostrarMensajeEmergente(){
//        //MUESTRA LA VENTANA EMERGENTE CON EL MENSAJE DEFINIDO.
//        JOptionPane.showMessageDialog(this.descripcionDeSuceso.getPadreJFrame(),
//                                      this.descripcionDeSuceso.getMensajeDeError(),
//                                      "ERROR DETECTADO", JOptionPane.ERROR_MESSAGE );
//    }
    
    private void mostrarErrorEnConsola(){
//        if (this.debug) {
//            // MUESTRA EL ERROR DESCRITO ACOMODADO EN LA CONSOLA.
//            String usuarioActivo;
//
//            try {
//                usuarioActivo = this.coordinador.getUsuarioActivo().getNombreDelUsuario();
//
//            } catch (Exception e) {
//                usuarioActivo = "Arranque";
//
//            }
//            String textoParaConsola = ""
//                    + "[ ERROR ---------------- ]\n"
//                    + "\n  " + this.descripcionDeSuceso.getMensajeDeError()
//                    + "\n     " + this.descripcionDeSuceso.getDetallesDelError()
//                    + "\n\n  USUARIO ACTIVO ["+usuarioActivo+"] "
//                    + "\n       UBICACION ["+this.descripcionDeSuceso.getUbicacion()+"]"
//                    + "\n     No DE ERROR ["+this.descripcionDeSuceso.getTipoDeError()+"]"
//                    + "\n\n[--------------------]";
//
//            this.println(textoParaConsola);
//        }
    }
    
    // SE ASIGNA EN ejecutar SEGÚN EL TIPO DE SUCESO QUE OCURRA
    private void guardarLogin(){
//        //GUARDAMOS EL LOG DE ERRORES. SI ES QUE ESTAMOS CONECTADOS A LA BASE
//        // DE DATOS.
//
//        String sql = "INSERT INTO gestionerrores VALUES("
//                + " null, "
//                + " null, "
//                + " '"+this.coordinador.getUsuarioActivo()+"', "
//                + " '"+this.descripcionDeSuceso.getTipoDeError()+"', "
//                + " '"+this.descripcionDeSuceso.getDetallesDelError()+"', "
//                + " '"+this.descripcionDeSuceso.getUbicacion()+"', "
//                + ")";
//        
//        //SI DESDE Coordinador NO HUBO CONEXIÓN FORZAMOS EL CIERRE DEL
//        // SISTEMA.
//        if (this.coordinador.conexion.isExitosa()) {
//            try {
//                this.coordinador.conexion.stm.execute(sql);
//            } catch (Exception e) {
//                
//                DescripcionDeSuceso suceso = new DescripcionDeSuceso();
//                suceso.setMensajeDeError("Algo paso y no se guardo el login.");
//                suceso.setPadreJFrame(null);
//                suceso.setDetallesDelError(e.getMessage());
//                suceso.setUbicacion(this);
//                this.guardarEnTxtLogin(suceso);
//            }
//            
//        }else{
//            JOptionPane.showMessageDialog(null,
//                                      "No se pudo guardar el lógin. (Se tiene que guardar en txt.--- pendiente)",
//                                      "SIN CONEXION A LA BASE DE DATOS", JOptionPane.ERROR_MESSAGE );
//            
//            DescripcionDeSuceso suceso = new DescripcionDeSuceso();
//            suceso.setMensajeDeError("No se pudo guardar el lógin en la BD. Se creara un txt.");
//            suceso.setPadreJFrame(null);
//            suceso.setDetallesDelError(" ");
//            suceso.setUbicacion(this);
//            this.guardarEnTxtLogin(suceso);
//            this.EJECUTAR_ERROR_FATAL();
//        
//        }
//        
        
    }
    
    //CANDIDATO PARA DEPRECATED
    private void guardarError(){
//        //ACTUALIZAMOS LA CONSOLA.
//        try {
//        String hora, usuario, errorCapturado, detalles, ubicacionDelError;
//        String sql = "SELECT "
//                + "gestionerror.hora, "
//                + "gestionusuarios_usuarios.nombre,  "
//                + "gestionerror.errorCapturado, "
//                + "gestionerror.detalles, "
//                + "gestionerror.ubicacionDelError "
//                
//                + "FROM gestionerror "
//                + "INNER JOIN gestionusuarios_usuarios"
//                + "ON gestionusuarios_usuarios.id = gestionerrores.idUsuarioActivo"
//                + "ORDERY BY gestionerror.hora DESC LIMIT 1";
//        
//            this.coordinador.conexion.rst = this.coordinador.conexion.stm.executeQuery(sql);
//            
//            this.coordinador.conexion.rst.next();
//            hora =this.coordinador.conexion.rst.getString("hora");
//            usuario =this.coordinador.conexion.rst.getString("nombre");
//            errorCapturado=this.coordinador.conexion.rst.getString("errorCapturado");
//            detalles =this.coordinador.conexion.rst.getString("detalles");
//            ubicacionDelError=this.coordinador.conexion.rst.getString("ubicacionDeError");
//            
//            String textoError = "[¡ERROR! "+hora+" ] " +usuario+"\n "+errorCapturado+
//                    "\nDetalles: " +detalles + "nUbicacion: "+ubicacionDelError; 
//            
//            String texto = this.coordinador.consolaDeErrores.txtAreaConsola.getText();
//            this.coordinador.consolaDeErrores.txtAreaConsola.setText(texto + textoError);
//        } catch (SQLException ex) {
//            Logger.getLogger(CapturaDeSucesos.class.getName()).log(Level.SEVERE, null, ex);
//        }
//          
    }
    
    //TERMINA LA EJECUCIÓN DEL SISTEMA.
    private void EJECUTAR_ERROR_FATAL(){
        JOptionPane.showMessageDialog(null, "ERROR FATAL: Se forzara "
                + "el cierre del programa", "ERROR FATAL",
                JOptionPane.ERROR_MESSAGE );
        System.exit(0);
    }

//    /**
//     * Recive un objeto tidpo DescripcionDeSuceso para trabajar con la informacion
//     * contenida en el.
//     * @param descripcionDeSuceso La descripción de lo que paso. 
//     * @see DescripcionDeSuceso
//     */
//    public void setDescripcionDeSuceso(DescripcionDeSuceso descripcionDeSuceso) {
//        this.descripcionDeSuceso = descripcionDeSuceso;
//    }
//
//    public DescripcionDeSuceso getDescripcionDeSuceso() {
//        return descripcionDeSuceso;
//    }
            
}
