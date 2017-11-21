/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import controlador.Coordinador;
import controlador.HiloConPrecarga;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author Particular
 */
public class Reportes {
    Coordinador coordinador;
    private static final Logger LOG = Logger.getLogger(Reportes.class.getName());
    
    private static final String REFACCION_EXISTENCIAS = "/reportes/Refacciones.jasper";
    private static final String REFACCION_EXISTENCIAS_TITULO = "Existencia de Refacciones";
    
    

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
        
    }
    
    
    private void configurarVentana (JasperViewer j, String titulo){
        j.setTitle(titulo);
        j.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
        j.setVisible(true);
        
        
    }
    
    public void cargarReporte(String ruta, String titulo){
        try {
            LOG.log(Level.INFO, "Cargando reporte:  {0}", ruta);
            Conexion conexion = new Conexion(coordinador);
            //Compila e imprime el reporte. 
            JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource(ruta));
            JasperPrint jp;
            jp = JasperFillManager.fillReport(reporte, null, conexion.getConexion());
            JasperViewer jv = new JasperViewer(jp);
            configurarVentana(jv, titulo);
            conexion.getConexion().close();
        } catch (JRException | SQLException ex) {
            LOG.info(ex.getMessage());
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void refaccionExistencias(){
        HiloConPrecarga hcp = new HiloConPrecarga(()->cargarReporte(REFACCION_EXISTENCIAS, REFACCION_EXISTENCIAS_TITULO)
                , coordinador.getPanelCarga());
        hcp.start();
    }
    
    
   
    
}
