
package vista.UtilidadesIntefaz.utilidadesOptimizadas;

import controlador.Coordinador;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import org.jdesktop.swingx.autocomplete.*;
import vista.UtilidadesIntefaz.OperacionesBasicasPorDefinir;

/**
 *  Utilidades para el facil manejo de los comboBox.
 * @author Rafael Angel Ramirez Estrada
 */
public class UtilidadesComboBox_ extends OperacionesBasicasPorDefinir{
    
    private JComboBox comboBox;
    private DefaultComboBoxModel<String> defaultComboBoxModel;
   
    private HashMap<String, Object> relacionDatoObjeto = new HashMap<>();
    private String nombreColumnaId, nombreColumnaDatoAMostrar;
//    private Runnable accionCuandoPierdeElFoco;
    
    
    public UtilidadesComboBox_(Coordinador coordinador) {
        super(coordinador);
        this.esComboBox = true;
    }
    
    /**
     *El jComboBox que se cargara con los datos de la consulta. 
     * @param comboBox JCombobox
     */
    @SuppressWarnings("unchecked")
    public void setComponente(JComboBox<?> comboBox) {
        defaultComboBoxModel = (DefaultComboBoxModel<String>)comboBox.getModel();
        this.comboBox = comboBox;
    }

   
    public String getNombreColumnaId() {
        return nombreColumnaId;
    }

    /**
    * La columna de donde se obtendra el íd para extraer los datos que se van 
    * a sacar de la base de datos. xP
     * @param nombreColumnaId El nombre de la columna. Se debe tomar desde
     * una clase IT para que coicida con la tabla.
    */
    public void setNombreColumnaId(String nombreColumnaId) {
        this.nombreColumnaId = nombreColumnaId;
    }

    public String getNombreColumnaDatoAMostrar() {
        return nombreColumnaDatoAMostrar;
    }

    
    /**
    * El nombre de la columna para cargar en el combo los datos que se quieren 
    * mostrar. Estos estan relacionados en un hashmap que devuelve el id del
    * susodicho.
     * @param nombreColumnaDatoAMostrar La columna que contiene los datos que se
     * quieren mostrar en el combobox.
    */
    public void setNombreColumnaDatoAMostrar(String nombreColumnaDatoAMostrar) {
        this.nombreColumnaDatoAMostrar = nombreColumnaDatoAMostrar;
    }
    
    /**
     *Retorna el dato seleccionado en el combobox.
     * @return El dato que esta escrito en el combo.
     */
    public String getSelectedItem() {
        return (String) this.comboBox.getSelectedItem();
    }
    
     /**
     * Carga el comboBox
     * @param datos El primer string es el valor y el segúndo es el id que se
     * quiere almacenear para relacionarlo al seleccionar un elemento del combo.
     */
    @SuppressWarnings("unchecked")
    public void cargarCombo(HashMap <String, Object> datos){
        this.limpiar();
//        DefaultComboBoxModel<String> m
//                    = new DefaultComboBoxModel<String>();
        defaultComboBoxModel.removeAllElements();
        List<String> ordenar = new ArrayList<>();
        
        this.relacionDatoObjeto = datos;
        for (Map.Entry<String, Object> entry : datos.entrySet()) {
            String valor = entry.getKey();
//            m.addElement(valor);
            ordenar.add(valor);
        }
        Collections.sort(ordenar);
        for (String d : ordenar) {
            defaultComboBoxModel.addElement(d);
        }
//        this.comboBox.setModel(m);
        this.autoCompletar();
    }
       

    
    /**
     * Limpia el contendi del combo.
     */
    public void limpiar(){
        this.comboBox.removeAllItems();
        defaultComboBoxModel.removeAllElements();
        
    }
    
    /**
     * Limpia un elemento en el combo.
     * @param elementoARemover El object que se quiere remover.
     */
    public void removeItem(Object elementoARemover){
        this.comboBox.removeItem(elementoARemover);
    }
    /**
     * Retorna el id del item seleccionado del comboBox que tenemos instanciado 
     * ó el objeto que deseamos que se retorne.
     * Nos facilita la vida!
     * 
     * @return Id que corresponde con la BD o el objeto que queremos que nos retorne.
     */
    public Object getSelectedItem_idRetorno(){
        if (this.isEmpty()) {
            return -1;
        }else{
            for (Map.Entry<String, Object> entry : relacionDatoObjeto.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                
            }
            return this.relacionDatoObjeto.get((String)this.comboBox.getSelectedItem());
        }
    }
    /**
     * Autocompleta el comboBox con los datos que tiene cargado en el modelo.
     */
    private void autoCompletar(){
         this.comboBox.setEditable(true);
         AutoCompleteDecorator.decorate(this.comboBox);
    }
    
    /**
     * Define una accion para el combo cuando se pierde el foco.
     * @param accionCuandoPierdeElFoco La acción que se quiere ejecutar. 
     * @param ganadoOPerdido Cuando se quiere ejecutar. True ganado, false perdido.
     */
    public void setFocusAction(Runnable accionCuandoPierdeElFoco, 
            boolean ganadoOPerdido) {
        this.setFocusAction(accionCuandoPierdeElFoco, 
                this.comboBox.getEditor().getEditorComponent(),
                ganadoOPerdido);
        
        this.setFocusAction(()->seleccionarPrimerItemDelCombo(), 
                this.comboBox.getEditor().getEditorComponent(),
                ganadoOPerdido);
    }
    
    /*
    El combo no puede estar vacio. Así que cada vez que se edita y se deja en 
    blanco se selecciona el primer item de la lista siempre y cuando el combo
    contenga algun elemento.
    */
    public void seleccionarPrimerItemDelCombo(){
        if(this.comboBox.getItemCount()!=0){
            if (this.isEmpty()) {
                if (this.comboBox.getSelectedIndex()==-1) {
                    this.comboBox.setSelectedIndex(0);
                }
            }
        }    
    }
    
    /**
     * Compara el elemento que se le pase contra la lista que contiene el combo.
     * @param itemEscrito El String a comparar.
     * @return True si contiene el elemento.
     */
    public boolean contieneElItemEscrito(Object itemEscrito){
        
        String elementoEscrito = itemEscrito+"";
        for (int i = 0; i < defaultComboBoxModel.getSize(); i++) {
            String elemento =defaultComboBoxModel.getElementAt(i);
            if (elemento.equals(elementoEscrito)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Obtiene el elemento escrito para compararlo con la lista que contiene.
     * Sirve para agregar un nuevo elemento a la BD.
     * @return True si contiene el elemento.
     */
    public boolean contieneElItemEscrito(){
        return this.contieneElItemEscrito(this.getText());
    }
    
    /**
     * Retorna el elemento escrito, no el seleccionado.
     */
    public String getText(){
        String texto = (String) this.comboBox.getEditor().getItem();
        //SI EL COMBO ESTA VACIO ENTONCES ES NECESARIO RETORNAR "" PARA QUE NO
        // HAYA PROBLEMAS CON LAS COMPOROBACIONES QUE SE HACEN.
        if (texto == null) {
            return "";
        }
        return this.quitarEspaciosSobrantes(texto);
    }
    
    /**
     * Define el elemento escrito dentro del combo box sin seleccionar 
     * un item.
     */
    public void setText(String texto){
        this.comboBox.getEditor().setItem(texto);
    }
    
    /**
     * Pone el foco en el combo.
     */
    public void setFocus(){
        this.comboBox.requestFocusInWindow();
    }
   
    /**
     * Selecciona el item que se le pase.
     * @param objeto El objeto que se quiere seleccionar. 
     */
    public void setSelectedItem(Object objeto){
        this.comboBox.setSelectedItem(objeto);
    }

    @Override
    public void setError() {
        this.setCampoComboBoxError(this.comboBox);
    }
    
    public void setError(String mensajeDeError){
        this.setMensajeDeError(mensajeDeError);
        this.setError();
        this.mostrarError();
        this.setFocus();
    
    }
    
    public void setErrorQuitar(){
        this.setCampoComboBoxRestaurar(this.comboBox);
    }
    
    public boolean isEmpty(){
        if (defaultComboBoxModel.getSize()==0) {
            return true;
        }
        
        if (getSelectedItem()==null) {
            return true;
        }
    
        if (this.getSelectedItem().equals("")) {
            return true;
        }
        return false;
    }
    
    /**
     * Retorna el editor de este combobox, no el JCombobox. Este sirve para 
     * setear directamente el texto en el campo. 
     *
     * @return 
     */
    @Override
    public Component getThis() {
        return this.comboBox.getEditor().getEditorComponent();
    }
    
    /**
     * Retorna el JComboBox seteado en esta utilidad. 
     * @return
     */
    public JComboBox getThisComboBox(){
        return this.comboBox;
    }
    
    public void setEditable(boolean editable) {
        this.getThisComboBox().setEditable(editable);
        this.getThisComboBox().getEditor().getEditorComponent().setVisible(editable);
    }
    
    /**
     * Ejecuta una acción que se le pase como parametro al seleccionar un item de la tabla. 
     * @param accion La acción que se quiere ejecutar. 
     */
    public void setSelectionAction(Runnable accion){
        comboBox.addActionListener(new ActionListener() {
            
            Runnable accion;
            public ActionListener operacion(Runnable accion){
                this.accion = accion;
                return this;
            }
            
            @Override
            public void actionPerformed(ActionEvent e) {
                accion.run();
            }
        }.operacion(accion));
    }    

    /**
     * Retorna el HashMap que lleva la relacion entre el dato y el objeto(Antes id)
     * para los fines que al interesado convengan. xP
     * @return El mapa con los datos cargados en el combo. 
     */
    public HashMap<String, Object> getRelacionDatoObjeto() {
        return relacionDatoObjeto;
    }
    
}
