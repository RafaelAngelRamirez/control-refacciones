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

import vista.panelsYDialogosOptimizados.PanelAgregarRefaccion_;
import vista.panelsYDialogosOptimizados.PanelConsultaRefacciones;
import com.bulenkov.darcula.DarculaLaf;
import com.sun.javafx.applet.Splash;
import controlador.Coordinador;
import controlador.capturadeerrores.CapturaDeSucesos;
import controlador.capturadeerrores.ConsolaDeErrores;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTree;
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
        PanelConsultaRefacciones panelPrincipal = new PanelConsultaRefacciones();
        PanelAgregarRefaccion_ panelAgregarRefaccion = new PanelAgregarRefaccion_();
        PanelModificarRefaccion panelModificarRefaccion = new PanelModificarRefaccion();
        
        //DIALOGOS
        DialogoRegistrarProveedor_ dialogoRegistrarProveedor_ = new DialogoRegistrarProveedor_();
        DialogoAgregarMaquinaModelo_ dialogoAgregarMaquina_ = new DialogoAgregarMaquinaModelo_();
        DialogoDetalleRefaccion_ dialogoDetalleRefaccion_ = new DialogoDetalleRefaccion_();
        DialogoDetalleImagen dialogoDetalleImagen = new DialogoDetalleImagen();
        
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
        panelPrincipal.setCoordinador(coordinador);
        panelAgregarRefaccion.setCoordinador(coordinador);
        dialogoRegistrarProveedor_.setCoordinador(coordinador);
        logica.setCoordinador(coordinador);
        dialogoAgregarMaquina_.setCoordinador(coordinador);
        dialogoDetalleRefaccion_.setCoordinador(coordinador);
        dialogoDetalleImagen.setCoordinador(coordinador);
        panelModificarRefaccion.setCoordinador(coordinador);
        
        
        /*
        ====================================================================
            SETEOS CLASES DENTRO DE COORDINADOR
        ====================================================================
        */
        
        coordinador.setMarcoParaVentanaPrincipal(marcoParaVentanaPrincipal);
        coordinador.setConsolaDeErrores(consolaDeErrores);
        coordinador.setSystemOut(SystemOut);
        coordinador.setPanelPrincipal(panelPrincipal);
        coordinador.setPanelAgregarRefaccion(panelAgregarRefaccion);
        coordinador.setDialogoRegistrarProveedor(dialogoRegistrarProveedor_);
        coordinador.setLogica(logica);
        coordinador.setDialogoAgregarMaquina_(dialogoAgregarMaquina_);
        coordinador.setDialogoDetalleRefaccion_(dialogoDetalleRefaccion_);
        coordinador.setDialogoDetalleImagen(dialogoDetalleImagen);
        coordinador.setPanelModificarRefaccion(panelModificarRefaccion);
        
        
        
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
