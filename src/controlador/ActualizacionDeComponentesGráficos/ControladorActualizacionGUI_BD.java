/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.ActualizacionDeComponentesGráficos;

import controlador.Coordinador;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import vista.UtilidadesIntefaz.JPanelBase;

/**
 *
 * @author Particular
 */
public class ControladorActualizacionGUI_BD {
    
    /**
     * Almacena los jpanel que han sido instanciados. 
     */
    private final List<JPanelBase> listaPaneles;
    private final HashMap<String, Boolean> tablasModificadas;
    
    Coordinador coordinador;

    public ControladorActualizacionGUI_BD() {
        this.tablasModificadas = new HashMap<>();
        this.listaPaneles = new ArrayList<>();
    }

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    /**
     * Añade un panel a la lista de paneles que se quieren 
     * @param panel
     */
    public void addPanel(JPanelBase panel){
        listaPaneles.add(panel);
    }
    
    /**
     * Revisa todos los paneles registrados que contengan operacines relacionadas
     * con la tabla que se le pase como parametro y define su estatus actualizado
     * como falso. De esta manera la siguiente vez que se llame a actualizar
     * la operación se ejecutara. 
     * 
     * @param tablaModificada La tabla que se quiere indicar como desactualizada. 
     */
    public void setTablaModificada(String tablaModificada){
        tablasModificadas.put(tablaModificada, true);
        for (JPanelBase panel : listaPaneles) {
            panel.getOpAct().definirCambioEnTabla(tablaModificada);
        }
        JOptionPane.showMessageDialog(null, "Se modifico la tabla: "+ tablaModificada);
    }
    
    /**
     * Esta operación actualiza todos los componentes que este visibles y que
     * las tablas esten señaladas como que hubo un cambio. 
     */
    public void actualizarTodoLoQueEsteVisible(){
        JOptionPane.showMessageDialog(null, "actualizando todo lo visible.");
        for (Map.Entry<String, Boolean> entry : tablasModificadas.entrySet()) {
            String tabla = entry.getKey();
            Boolean hayQueActualizar = entry.getValue();
            
            if (hayQueActualizar) {
                for (JPanelBase panel : listaPaneles) {
                    if (panel.soyVisible()) {
                        JOptionPane.showMessageDialog(null, "actualizando: "+ panel.getClass().getName());
                        panel.getOpAct().actualizarComponentePorTabla(tabla);
                    }
                }
            }
        }
    }
}
