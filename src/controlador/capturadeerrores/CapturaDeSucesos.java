
package controlador.capturadeerrores;

import controlador.Coordinador;
import java.io.OutputStream;
import java.io.PrintStream;
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
public class CapturaDeSucesos  extends PrintStream{

//    private DescripcionDeSuceso descripcionDeSuceso;
//    private final TipoDeSucesoOErrores tiposDeSucesoOErrores = new TipoDeSucesoOErrores();
    public Coordinador coordinador;
    private  boolean debug;

    public CapturaDeSucesos(OutputStream out) {
        super(out);
    }
    
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
    @Override
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
    
}