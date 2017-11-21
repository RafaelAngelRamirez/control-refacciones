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

import com.bulenkov.darcula.DarculaLaf;
import controlador.ActualizacionDeComponentesGráficos.ControladorActualizacionGUI_BD;
import controlador.capturadeerrores.CapturaDeSucesos;
import controlador.capturadeerrores.ConsolaDeErrores;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicLookAndFeel;
import modelo.logica.Logica;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reportes.Reportes;
import vista.UtilidadesIntefaz.VentanaPrincipal.MarcoParaVentanaPrincipal;
import vista.panels.PanelCarga;
import vista.panels.PanelEmpleadoAgregar;
import vista.panels.PanelEmpleadoModificar;
import vista.panels.PanelEntradaLote;
import vista.panels.PanelImagenRefaccionDetalle;
import vista.panels.PanelMaquinaAsignarNumeros;
import vista.panels.PanelMaquinaModeloAgregar;
import vista.panels.PanelMaquinaModeloModificar;
import vista.panels.PanelProveedorModificar;
import vista.panels.PanelProveedorRegistrar;
import vista.panels.PanelRefaccionAgregar;
import vista.panels.PanelRefaccionDetalle;
import vista.panels.PanelRefaccionesConsulta;
import vista.panels.PanelReportesGenerar;
import vista.panels.PanelSalidaDeLote;
import vista.panels.PanelSalidaDeLoteCantidadADescontarDeLote;
import vista.panels.PanelSalidaDeLoteSeleccionLotes;
import vista.panels.PanelSeccionMaquinaRelacionModeloMaquina;

/**
 *
 * @author Rafael Ángel Ramírez Estrada
 */
public class Principal {
    
    private static final Logger LOG = LogManager.getLogger(Principal.class.getName());

    
    public static void main(String[] args) {
//        iniciarPrograma();
         LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.warn("warn message");
        LOG.info("info message");
        LOG.error("error message");
        LOG.fatal("fatal message");
        
        PanelCarga panelCargaInicio = new PanelCarga();
        
        
        HiloConPrecarga hilo = new HiloConPrecarga(()->iniciarPrograma(), panelCargaInicio, 1000, true);
        hilo.start();
        
        
        
    }
    
    private static void iniciarPrograma(){
        //Agregamos el LookAndFeel de Darcula :3
        BasicLookAndFeel darcula = new DarculaLaf();
        try {
                UIManager.setLookAndFeel(darcula);
                
        } catch (UnsupportedLookAndFeelException ex) {
//            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
        /*
        ====================================================================
            INSTANCIAMOS LAS CLASES PRINCIPALES
        ====================================================================
        */
        final boolean ESTADO_DE_DEBUG = false;
        
//        //VENTANAS SECUNDARIAS
        ConsolaDeErrores consolaDeErrores = new ConsolaDeErrores();
        consolaDeErrores.setVisible(ESTADO_DE_DEBUG);
        //RECURSOS VARIOS
        CapturaDeSucesos SystemOut_ = new CapturaDeSucesos(System.out);
        SystemOut_.setDebug(true);
        SystemOut_.setConsolaDeErrores(consolaDeErrores);
        System.setOut(SystemOut_);
        
        
        //COORDINADORES
        Coordinador coordinador = new Coordinador();
        coordinador.setDebugMode(ESTADO_DE_DEBUG);
        coordinador.setConsolaDeErrores(consolaDeErrores);
        coordinador.setCapturaDeSucesos(SystemOut_);
        
        CoordinadorPaneles coordinadorPaneles = new CoordinadorPaneles();
        
        
        //CONTROLADOR DE ACTUALIZACIÓN DE VENTANAS. 
        ControladorActualizacionGUI_BD controladorActualizacionGUI_BD = new ControladorActualizacionGUI_BD();
        
        controladorActualizacionGUI_BD.setCoordinador(coordinador);
        coordinador.setControladorActualizacionGUI_BD(controladorActualizacionGUI_BD);
        
        //VENTANA PRINCIPAL
        MarcoParaVentanaPrincipal marcoParaVentanaPrincipal = new MarcoParaVentanaPrincipal();
        
        //PANELES
        PanelRefaccionesConsulta panelConsultaRefacciones = new PanelRefaccionesConsulta();
        PanelRefaccionAgregar panelRefaccionAgregar = new PanelRefaccionAgregar();
        PanelProveedorRegistrar panelProveedorRegistrar = new PanelProveedorRegistrar();
        PanelMaquinaModeloAgregar panelMaquinaModeloAgregar = new PanelMaquinaModeloAgregar();
        PanelRefaccionDetalle panelRefaccionDetalle = new PanelRefaccionDetalle();
        PanelImagenRefaccionDetalle panelImagenDetalle = new PanelImagenRefaccionDetalle();
        PanelMaquinaModeloModificar panelMaquinaModeloModificar = new PanelMaquinaModeloModificar();
        PanelProveedorModificar panelProveedorModificar = new PanelProveedorModificar();
        PanelEntradaLote panelEntradaLote = new PanelEntradaLote();
        PanelEmpleadoAgregar panelEmpleadoAgregar = new PanelEmpleadoAgregar();
        PanelEmpleadoModificar panelEmpleadoModificar = new PanelEmpleadoModificar();
        PanelSalidaDeLote panelSalidaDeLote = new PanelSalidaDeLote();
        PanelSalidaDeLoteSeleccionLotes panelSalidaDeLoteSeleccionLotes = new PanelSalidaDeLoteSeleccionLotes();
        PanelSalidaDeLoteCantidadADescontarDeLote panelSalidaDeLoteCantidadADescontarPorLote = new PanelSalidaDeLoteCantidadADescontarDeLote();
        PanelMaquinaAsignarNumeros panelMaquinaAsignarNumeros = new PanelMaquinaAsignarNumeros();
        PanelSeccionMaquinaRelacionModeloMaquina panelSeccionMaquinaRelacionModeloMaquina = new PanelSeccionMaquinaRelacionModeloMaquina();
        PanelCarga panelCarga = new PanelCarga();
        PanelReportesGenerar panelReportesGenerar = new PanelReportesGenerar();
        
        Reportes reportes = new Reportes();
        
                
                
        
        
        //LOGICA
        Logica logica = new Logica();
        
       
        /*
        ====================================================================
            SETEOS CLASES DENTRO DE COORDINADOR
        ====================================================================
        */
        
        coordinador.setMarcoParaVentanaPrincipal(marcoParaVentanaPrincipal);
        coordinador.setPanelRefaccionConsulta(panelConsultaRefacciones);
        coordinador.setPanelRefaccionAgregar(panelRefaccionAgregar);
        coordinador.setPanelProveedorRegistrar(panelProveedorRegistrar);
        coordinador.setLogica(logica);
        coordinador.setPanelMaquinaModeloAgregar(panelMaquinaModeloAgregar);
        coordinador.setPanelRefaccionDetalle(panelRefaccionDetalle);
        coordinador.setPanelImagenDetalle(panelImagenDetalle);
        coordinador.setPanelMaquinaModeloModificar(panelMaquinaModeloModificar);
        coordinador.setPanelProveedorModificar(panelProveedorModificar);
        coordinador.setPanelEntradaLote(panelEntradaLote);
        coordinador.setPanelEmpleadoAgregar(panelEmpleadoAgregar);
        coordinador.setPanelEmpleadoModificar(panelEmpleadoModificar);
        coordinador.setPanelSalidaDeLoteSeleccionLotes(panelSalidaDeLoteSeleccionLotes);
        coordinador.setPanelSalidaDeLote(panelSalidaDeLote);
        coordinador.setCoordinadorPaneles(coordinadorPaneles);
        coordinador.setPanelSalidaDeLoteCantidadADescontarDeLote(panelSalidaDeLoteCantidadADescontarPorLote);
        coordinador.setPanelMaquinaAsignarNumeros(panelMaquinaAsignarNumeros);
        coordinador.setPanelSeccionMaquinaRelacionModeloMaquina(panelSeccionMaquinaRelacionModeloMaquina);
        coordinador.setPanelCarga(panelCarga);
        coordinador.setPanelReportesGenerar(panelReportesGenerar);
        
        
        coordinador.setReportes(reportes);
        
        /*
        ====================================================================
            SETEOS COORDINADOR EN CLASES
        ====================================================================
        */
        marcoParaVentanaPrincipal.setCoordinador(coordinador);
        SystemOut_.setCoordinador(coordinador);
        
        panelConsultaRefacciones.setCoordinador(coordinador);
        panelRefaccionAgregar.setCoordinador(coordinador);
        panelProveedorRegistrar.setCoordinador(coordinador);
        panelMaquinaModeloAgregar.setCoordinador(coordinador);
        panelRefaccionDetalle.setCoordinador(coordinador);
        panelImagenDetalle.setCoordinador(coordinador);
        panelMaquinaModeloModificar.setCoordinador(coordinador);
        panelProveedorModificar.setCoordinador(coordinador);
        panelEntradaLote.setCoordinador(coordinador);
        panelEmpleadoAgregar.setCoordinador(coordinador);
        panelEmpleadoModificar.setCoordinador(coordinador);
        panelSalidaDeLote.setCoordinador(coordinador);
        coordinadorPaneles.setCoordinador(coordinador);
        panelSalidaDeLoteSeleccionLotes.setCoordinador(coordinador);
        panelSalidaDeLoteCantidadADescontarPorLote.setCoordinador(coordinador);
        panelMaquinaAsignarNumeros.setCoordinador(coordinador);
        panelSeccionMaquinaRelacionModeloMaquina.setCoordinador(coordinador);
        panelReportesGenerar.setCoordinador(coordinador);
        
        logica.setCoordinador(coordinador);
        
        reportes.setCoordinador(coordinador);
        
        
        /*
        ====================================================================
            PARAMETROS DE INICIALIZACIÓN
        ====================================================================
        /*
  
        ====================================================================
            INICIO DE SISTEMA
        ====================================================================
        */
        
        System.out.println("[+] Iniciando sistema");
        marcoParaVentanaPrincipal.init();
        
        
    }
}
