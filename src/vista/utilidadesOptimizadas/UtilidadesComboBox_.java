
package vista.utilidadesOptimizadas;

import modelo.ExcepcionPersonalizada;
import controlador.Coordinador;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import org.jdesktop.swingx.autocomplete.*;

/**
 *  Utilidades para el facil manejo de los comboBox.
 * @author Rafael Angel Ramirez Estrada
 */
public class UtilidadesComboBox_ extends OperacionesBasicasPorDefinir_{
    
    private JComboBox comboBox;
   
    private HashMap<String, Integer> relacionDatoId = new HashMap<>();
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
    public void setComponente(JComboBox comboBox) {
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
    public void cargarCombo(HashMap <String, Integer> datos){
        this.limpiar();
        DefaultComboBoxModel<String> m
                    = new DefaultComboBoxModel<String>();
        
        this.relacionDatoId = datos;
        for (Map.Entry<String, Integer> entry : datos.entrySet()) {
            String valor = entry.getKey();
            m.addElement(valor);
        }    
        this.comboBox.setModel(m);
        this.autoCompletar();
    }
       

    
    /**
     * Limpia el contendi del combo.
     */
    public void limpiar(){
        this.coordinador.getSystemOut().println("[!]Limpiando combo!");
        this.comboBox.removeAllItems();
    }
    
    /**
     * Limpia un elemento en el combo.
     * @param elementoARemover El object que se quiere remover.
     */
    public void removeItem(Object elementoARemover){
        this.coordinador.getSystemOut().println("[!]Limpiando elemento de combo!");
        this.comboBox.removeItem(elementoARemover);
    }
    /**
     * Retorna el id del item seleccionado del comboBox que tenemos instanciado.
     * Nos facilita la vida!
     * 
     * @return Id que corresponde con la BD.
     */
    public int getSelectedItem_idRetorno(){
        if (this.isEmpty()) {
            return -1;
        }else{
            System.out.println("estamos en el combo:");
            for (Map.Entry<String, Integer> entry : relacionDatoId.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println("relacionDatoId: " + key + "- "+value);
                
            }
            return this.relacionDatoId.get((String)this.comboBox.getSelectedItem());
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
    private void seleccionarPrimerItemDelCombo(){
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
    public boolean contieneElItemEscrito(String itemEscrito){
        this.coordinador.getSystemOut().println("[!]Comprobando si el elemento escrito esta en el combo.", this);
        String elementoEscrito = itemEscrito;
        DefaultComboBoxModel modelo = (DefaultComboBoxModel) this.comboBox.getModel();
        for (int i = 0; i < modelo.getSize(); i++) {
            String elemento =(String) modelo.getElementAt(i);
            if (elemento.equals(elementoEscrito)) {
                this.coordinador.getSystemOut().println("        [!]Esta en combo.", this);
                return true;
            }
        }
        this.coordinador.getSystemOut().println("        [!]No esta en el combo.", this);
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
        if (this.comboBox.getModel().getSize()==0) {
            return true;
        }
        
        if (this.getSelectedItem().equals("")) {
            return true;
        }
        return false;
    }
    
    
    
    @Override
    public Component getThis() {
        return this.comboBox.getEditor().getEditorComponent();
    }

    @Override
    public void setEditable(boolean editable) {
        try {
            throw new ExcepcionPersonalizada("Todavia no esta soportado.", this, "setEditable");
        } catch (ExcepcionPersonalizada ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    
    
}
