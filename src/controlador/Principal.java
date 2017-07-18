/**
 * Derechos reservador Rafael Angel Ramirez Estrada 2017.
 * Gestion de Herramientas. Carrduci Botones.
 * 
 * No se permite la preproducción total o parcial sin antes recivir 
 * previa autorización del autor.
 * 
 * Este programa presenta características especiales para la empresa
 * Carrduci Botones. Toda la información recavada por el esta 
 * sometida a un acuerdo de confidencialidad. 
 * 
 * 2017
 * 
 * 
 */
package controlador;

import vista.panelsYDialogosOptimizados.PanelRefaccionAgregar;
import vista.panelsYDialogosOptimizados.PanelRefaccionesConsulta;
import com.bulenkov.darcula.DarculaLaf;
import controlador.capturadeerrores.CapturaDeSucesos;
import controlador.capturadeerrores.ConsolaDeErrores;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicLookAndFeel;
import modelo.logica.Logica;
import vista.*;
import vista.panelsYDialogosOptimizados.*;



/**
 *
 * @author Rafael Ángel Ramírez Estrada
 */
public class Principal {

    
    public static void main(String[] args) {
        iniciarPrograma();
    }
    
    private static void iniciarPrograma(){
        //Agregamos el LookAndFeel de Darcula :3
        BasicLookAndFeel darcula = new DarculaLaf();
        try {
                UIManager.setLookAndFeel(darcula);
                
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*
        ====================================================================
            INSTANCIAMOS LAS CLASES PRINCIPALES
        ====================================================================
        */
        
        //VENTANA PRINCIPAL
        MarcoParaVentanaPrincipal marcoParaVentanaPrincipal = new MarcoParaVentanaPrincipal();
        
        //VENTANAS SECUNDARIAS
        ConsolaDeErrores consolaDeErrores = new ConsolaDeErrores();
        
        //PANELES
        PanelRefaccionesConsulta panelConsultaRefacciones = new PanelRefaccionesConsulta();
        PanelRefaccionAgregar panelRefaccionAgregar = new PanelRefaccionAgregar();
        PanelRefaccionModificar panelRefaccionModificar = new PanelRefaccionModificar();
        
        //DIALOGOS
        DialogoProveedorRegistrar dialogoProveedorRegistrar = new DialogoProveedorRegistrar();
        DialogoMaquinaModeloAgregar dialogoMaquinaModeloAgregar = new DialogoMaquinaModeloAgregar();
        DialogoRefaccionDetalle dialogoRefaccionDetalle = new DialogoRefaccionDetalle();
        DialogoImagenDetalle dialogoImagenDetalle = new DialogoImagenDetalle();
        
        //RECURSOS VARIOS
        CapturaDeSucesos SystemOut = new CapturaDeSucesos();
        
        //COORDINADORES
        Coordinador coordinador = new Coordinador();
        
        //LOGICA
        Logica logica = new Logica();
        
        
        /*
        ====================================================================
            SETEOS COORDINADOR EN CLASES
        ====================================================================
        */
        marcoParaVentanaPrincipal.setCoordinador(coordinador);
        SystemOut.setCoordinador(coordinador);
        
        panelConsultaRefacciones.setCoordinador(coordinador);
        panelRefaccionAgregar.setCoordinador(coordinador);
        panelRefaccionModificar.setCoordinador(coordinador);
        
        dialogoProveedorRegistrar.setCoordinador(coordinador);
        dialogoMaquinaModeloAgregar.setCoordinador(coordinador);
        dialogoRefaccionDetalle.setCoordinador(coordinador);
        dialogoImagenDetalle.setCoordinador(coordinador);
        
        logica.setCoordinador(coordinador);
        
        /*
        ====================================================================
            SETEOS CLASES DENTRO DE COORDINADOR
        ====================================================================
        */
        
        coordinador.setMarcoParaVentanaPrincipal(marcoParaVentanaPrincipal);
        coordinador.setConsolaDeErrores(consolaDeErrores);
        coordinador.setSystemOut(SystemOut);
        coordinador.setPanelRefaccionConsulta(panelConsultaRefacciones);
        coordinador.setPanelRefaccionAgregar(panelRefaccionAgregar);
        coordinador.setDialogoProveedorRegistrar(dialogoProveedorRegistrar);
        coordinador.setLogica(logica);
        coordinador.setDialogoMaquinaModeloAgregar(dialogoMaquinaModeloAgregar);
        coordinador.setDialogoRefaccionDetalle(dialogoRefaccionDetalle);
        coordinador.setDialogoImagenDetalle(dialogoImagenDetalle);
        coordinador.setPanelRefaccionModificar(panelRefaccionModificar);
        
        
        
        /*
        ====================================================================
            PARAMETROS DE INICIALIZACIÓN
        ====================================================================
        */
        
        coordinador.inicializarConsola(true);
        
        /*
        ====================================================================
            PARA CLASES ESTATICAS QUE SE UTILIZAN AL PRINCIPIO.
        ====================================================================
        */
        
        new modelo.dao.ProveedorDao_(coordinador);
        new modelo.dao.PaisDao_(coordinador);
        
        /**/
        
        
        /*
        ====================================================================
            INICIO DE SISTEMA
        ====================================================================
        */
        SystemOut.println("[+]Iniciando sistema");
        marcoParaVentanaPrincipal.init();
        marcoParaVentanaPrincipal.setVisible(true);
        
    }
}
