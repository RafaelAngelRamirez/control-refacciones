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

import vista.panels.DialogoEmpleadoModificar;
import vista.panels.DialogoRefaccionDetalle;
import vista.panels.DialogoMaquinaModeloAgregar;
import vista.panels.DialogoProveedorModificar;
import vista.panels.DialogoImagenRefaccionDetalle;
import vista.panels.DialogoMaquinaModeloModificar;
import vista.panels.DialogoEntradaLote;
import vista.panels.DialogoEmpleadoAgregar;
import vista.panels.DialogoProveedorRegistrar;
import vista.panels.DialogoSalidaDeLote;
import vista.panels.PanelRefaccionModificar;
import vista.UtilidadesIntefaz.DialogoBase;
import vista.UtilidadesIntefaz.VentanaPrincipal.MarcoParaVentanaPrincipal;
import vista.panels.PanelRefaccionAgregar;
import vista.panels.PanelRefaccionesConsulta;
import com.bulenkov.darcula.DarculaLaf;
import controlador.capturadeerrores.CapturaDeSucesos;
import controlador.capturadeerrores.ConsolaDeErrores;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicLookAndFeel;
import modelo.logica.Logica;

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
        final boolean ESTADO_DE_DEBUG = true;
        
//        //VENTANAS SECUNDARIAS
        ConsolaDeErrores consolaDeErrores = new ConsolaDeErrores();
        consolaDeErrores.setVisible(ESTADO_DE_DEBUG);
        //RECURSOS VARIOS
        CapturaDeSucesos SystemOut_ = new CapturaDeSucesos(System.out);
        SystemOut_.setDebug(ESTADO_DE_DEBUG);
        SystemOut_.setConsolaDeErrores(consolaDeErrores);
        System.setOut(SystemOut_);
        
        
        
        
        
        //VENTANA PRINCIPAL
        MarcoParaVentanaPrincipal marcoParaVentanaPrincipal = new MarcoParaVentanaPrincipal();
        
        //PANELES
        PanelRefaccionesConsulta panelConsultaRefacciones = new PanelRefaccionesConsulta();
        PanelRefaccionAgregar panelRefaccionAgregar = new PanelRefaccionAgregar();
        PanelRefaccionModificar panelRefaccionModificar = new PanelRefaccionModificar();
        
        //DIALOGOS
        
        //EL NUEVO UNICO DIALOGO
        DialogoBase dialogoBase = new DialogoBase();
        
        DialogoProveedorRegistrar dialogoProveedorRegistrar = new DialogoProveedorRegistrar();
        DialogoMaquinaModeloAgregar dialogoMaquinaModeloAgregar = new DialogoMaquinaModeloAgregar();
        DialogoRefaccionDetalle dialogoRefaccionDetalle = new DialogoRefaccionDetalle();
        DialogoImagenRefaccionDetalle dialogoImagenDetalle = new DialogoImagenRefaccionDetalle();
        DialogoMaquinaModeloModificar dialogoMaquinaModeloModificar = new DialogoMaquinaModeloModificar();
        DialogoProveedorModificar dialogoProveedorModificar = new DialogoProveedorModificar();
        DialogoEntradaLote dialogoEntradaLote = new DialogoEntradaLote();
        DialogoEmpleadoAgregar dialogoEmpleadoAgregar = new DialogoEmpleadoAgregar();
        DialogoEmpleadoModificar dialogoEmpleadoModificar = new DialogoEmpleadoModificar();
        DialogoSalidaDeLote dialogoSalidaDeLote = new DialogoSalidaDeLote();
        
        
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
        SystemOut_.setCoordinador(coordinador);
        
        panelConsultaRefacciones.setCoordinador(coordinador);
        panelRefaccionAgregar.setCoordinador(coordinador);
        panelRefaccionModificar.setCoordinador(coordinador);
        
        dialogoProveedorRegistrar.setCoordinador(coordinador);
        dialogoMaquinaModeloAgregar.setCoordinador(coordinador);
        dialogoRefaccionDetalle.setCoordinador(coordinador);
        dialogoImagenDetalle.setCoordinador(coordinador);
        dialogoMaquinaModeloModificar.setCoordinador(coordinador);
        dialogoProveedorModificar.setCoordinador(coordinador);
        dialogoEntradaLote.setCoordinador(coordinador);
        dialogoEmpleadoAgregar.setCoordinador(coordinador);
        dialogoEmpleadoModificar.setCoordinador(coordinador);
        dialogoSalidaDeLote.setCoordinador(coordinador);
        dialogoBase.setCoordinador(coordinador);
        
        logica.setCoordinador(coordinador);
        
        /*
        ====================================================================
            SETEOS CLASES DENTRO DE COORDINADOR
        ====================================================================
        */
        
        coordinador.setMarcoParaVentanaPrincipal(marcoParaVentanaPrincipal);
        coordinador.setPanelRefaccionConsulta(panelConsultaRefacciones);
        coordinador.setPanelRefaccionAgregar(panelRefaccionAgregar);
        coordinador.setDialogoProveedorRegistrar(dialogoProveedorRegistrar);
        coordinador.setLogica(logica);
        coordinador.setDialogoMaquinaModeloAgregar(dialogoMaquinaModeloAgregar);
        coordinador.setDialogoRefaccionDetalle(dialogoRefaccionDetalle);
        coordinador.setDialogoImagenDetalle(dialogoImagenDetalle);
        coordinador.setPanelRefaccionModificar(panelRefaccionModificar);
        coordinador.setDialogoMaquinaModeloModificar(dialogoMaquinaModeloModificar);
        coordinador.setDialogoProveedorModificar(dialogoProveedorModificar);
        coordinador.setDialogoEntradaLote(dialogoEntradaLote);
        coordinador.setDialogoEmpleadoAgregar(dialogoEmpleadoAgregar);
        coordinador.setDialogoEmpleadoModificar(dialogoEmpleadoModificar);
        coordinador.setDialogoSalidaDeLote(dialogoSalidaDeLote);
        coordinador.setDialogoBase(dialogoBase);
        
//        /*
//        ====================================================================
//            PARAMETROS DE INICIALIZACIÓN
//        ====================================================================
//        */
//        
//        coordinador.inicializarConsola(true);
//        
        /*
        ====================================================================
            PARA CLASES ESTATICAS QUE SE UTILIZAN AL PRINCIPIO.
        ====================================================================
        */
        //LAS PONEMOS AQUI POR QUE OCUPAMOS LAS VARIABLES ESTATICAS, DE OTRA
        // MANERA NO SE CARGAR Y DA ERROR!
        new modelo.dao.ProveedorDao(coordinador);
        new modelo.dao.PaisDao(coordinador);
        
        /**/
        
        
        /*
        ====================================================================
            INICIO DE SISTEMA
        ====================================================================
        */
        System.out.println("[+] Iniciando sistema");
        marcoParaVentanaPrincipal.init();
        marcoParaVentanaPrincipal.setVisible(true);
        
    }
}
