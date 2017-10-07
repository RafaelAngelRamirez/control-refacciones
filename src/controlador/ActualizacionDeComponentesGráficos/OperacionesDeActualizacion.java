/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.ActualizacionDeComponentesGráficos;

import java.util.ArrayList;
import java.util.List;
import vista.UtilidadesIntefaz.JPanelBase;

/**
 *
 * @author Particular
 */
public class OperacionesDeActualizacion {
    
    JPanelBase panel;
    List<ObjetoDeActualizacion> listOperaconesDeActualizacion;

    /**
     * Esta clase se encarga de almacenar las operaciones de actaulización de los
     * paneles de manera que se puedan ejecutar cuando las tablas se hayan modificado. 
     * @param panel
     */
    public OperacionesDeActualizacion(JPanelBase panel) {
        listOperaconesDeActualizacion = new ArrayList<>();
        this.panel = panel;
    }
    
    public void add(String tabla, Runnable operacionDeActualización){
        ObjetoDeActualizacion ca = new ObjetoDeActualizacion();
        ca.setOperacionDeActualizacion(operacionDeActualización);
        ca.setTablaConElQueEstaRelacionado(tabla);
        listOperaconesDeActualizacion.add(ca);
    }

    /**
     * Retorna la lista de comp
     * @return
     */
    public List<ObjetoDeActualizacion> getComponentseActualizar() {
        return listOperaconesDeActualizacion;
    }

    public void setListOperaconesDeActualizacion(List<ObjetoDeActualizacion> listOperaconesDeActualizacion) {
        this.listOperaconesDeActualizacion = listOperaconesDeActualizacion;
    }

    /**
     * Ejecuta todas las operaciones de actualización del panel que esten agregadas.
     * Aunque estas no esten marcadas como desactaulizadas. 
     */
    public void actualizarPanel() {
        System.out.println("[ACTUALIZANDO PANEL]\n\n\n\t\t"+panel.getClass().getName()+"\n\n\n[ACTUALIZANDO PANEL]");
        if (!listOperaconesDeActualizacion.isEmpty()) {
            for (ObjetoDeActualizacion cA : listOperaconesDeActualizacion) {
                cA.getOperacionDeActualizacion().run();
            }
        }
    }
    
    /**
     * Ejecuta las operaciones de actualización que coincidan con la tabla que se le pase
     * como parametro. 
     * @param tabla
     */
    public void actualizarComponentePorTabla(String tabla){
        for (ObjetoDeActualizacion cA : listOperaconesDeActualizacion) {
            if (cA.getTablaConElQueEstaRelacionado().equals(panel)) {
                cA.getOperacionDeActualizacion().run();
                cA.setActualizado(true);
            }
        }
    }
    
    /**
     * Cuando algúna de las tablas ha sido modificada entonces llamados a esta
     * operación que busca todas las operaciones que esten relacionadas con 
     * la susodicha y la defina como desacualizada (false);
     * @param tabla La tabla que queremos definir como desactualizada. 
     */
    public void definirCambioEnTabla(String tabla){
        for (ObjetoDeActualizacion cA : listOperaconesDeActualizacion) {
            if (cA.getTablaConElQueEstaRelacionado().equals(panel)) {
                cA.setActualizado(false);
            }
        }
    
    }
    
    
    //ESTA CLASE GUARDA EL COMPONENETE Y SU RELACIÓN CON LAS TABLAS DE MANERA
    // QUE SI LA TABLA SE MODIFICA ENTONCES ESTE COMPONENTE SE ACTUALIZA. 
    private class ObjetoDeActualizacion{
        
        boolean actualizado;
        Runnable operacionDeActualizacion;
        String tablaConElQueEstaRelacionado;

        /**
         * Define si la operación se ha actualizado desde la última vez que
         * se señalo algún cambio en la 
         */
        public boolean isActualizado() {
            return actualizado;
        }

        public void setActualizado(boolean actualizado) {
            this.actualizado = actualizado;
        }

        public Runnable getOperacionDeActualizacion() {
            return operacionDeActualizacion;
        }

        public void setOperacionDeActualizacion(Runnable operacionDeActualizacion) {
            this.operacionDeActualizacion = operacionDeActualizacion;
        }

        public String getTablaConElQueEstaRelacionado() {
            return tablaConElQueEstaRelacionado;
        }

        public void setTablaConElQueEstaRelacionado(String tablaConElQueEstaRelacionado) {
            this.tablaConElQueEstaRelacionado = tablaConElQueEstaRelacionado;
        }
    
    }
    
    
}
