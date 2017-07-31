
package vista.utilidadesOptimizadas;

import modelo.ExcepcionPersonalizada;
import controlador.Coordinador;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 * Utilidades para el fácil manejo de las listas.
 * @author Rafael Ángel Ramírez Estrada
 */
public class UtilidadesListas_ extends OperacionesBasicasPorDefinir_{
    
    private String nombreColumnaId, nombreDatoAMostrar;
    private JList<String> lista;
    private UtilidadesListas_ listaAAgregar;
    
    private HashMap<Object, Integer> relacionDatoId  = new HashMap();

    public UtilidadesListas_(Coordinador controlador) {
        super(controlador);
    }

    public HashMap<Object, Integer> getRelacionDatoId() {
        return relacionDatoId;
    }

    public void setRelacionDatoId(HashMap<Object, Integer> relacionDatoId) {
        this.relacionDatoId = relacionDatoId;
    }

    /**
     * Remueve un elemento de la lista.
     * @param dato El elemento que se quiere remover.
     */
    public void removeElement(Object dato){
        DefaultListModel defaultListModel =(DefaultListModel) this.lista.getModel();
        defaultListModel.removeElement(dato);
        this.relacionDatoId.remove((String)dato);
    }
    
    /**
     * Cambia los elementos que se pasen a la segúnda lista.
     * @param dato El dato que se quiere interacambiar.
     */
    public void cambioEntreListas(Object dato){
        DefaultListModel l1 =(DefaultListModel) this.getThis().getModel();
        l1.removeElement(dato);
        
        DefaultListModel l2 = (DefaultListModel)this.listaAAgregar.getThis().getModel();
        l2.addElement(dato);
    }
    
//    /**
//     * Nombre que la sentencia sql necesita para recuperar el dato de la 
//     * columna id.
//     * @param nombreColumnaId
//     */
//    public void setNombreColumnaId(String nombreColumnaId) {
//        this.nombreColumnaId = nombreColumnaId;
//    }
    
//    /**
//     * Nombre de la columna que se mostrara dentro de la lista.
//     * @param nombreColumnaAMostrar La columna conforme a la BD para obtener
//     * los datos y cargarlos en esta lista. 
//     */
//    public void setNombreDatoAMostrar(String nombreColumnaAMostrar) {
//        this.nombreDatoAMostrar = nombreColumnaAMostrar;
//    }
    
    /**
    * Lista en la que se cargaran los datos. Para listas dobles con interación
    * tambien es neceasrios agregar setListaAAgregar.
     * @param lista La lista que se quiere manejar con esta utilidad.
    */
    public void setComponente(JList<String> lista) {
        this.lista = lista;
    }
   
    /**
     * La lista con la que se intercambiaran datos. Se setea aqui para un manejo
     * más facil.
     * @return El componente JList.
     */
    public UtilidadesListas_ getListaAAgregar() {
        return listaAAgregar;
    }

     /**
    * Lista en la que se cargaran los datos de la lista principal setComponente()
 cuando se invoque cambioEntreListas().
    * 
     * @param listaAAgregar La lista que se quiere manejar para el intercambio de
     * datos.
    */
    public void setListaAAgregar(UtilidadesListas_ listaAAgregar) {
        this.listaAAgregar = listaAAgregar;
    }
    
    public String getNombreColumnaId() {
        return nombreColumnaId;
    }

    public String getNombreDatoAMostrar() {
        return nombreDatoAMostrar;
    }

    public JList<String> getLista() {
        return lista;
    }
    
    /**
     * Carga la lista con los dato que le pasamos por el hasmap.
     * 
     * Es necesario precisar el id para que este tambien quede almacenado y
     * despues se pueda recuper facilmente. 
     * 
     * @param datos El mapa que contiene los datos relacionados con id para
     * mostrarse en la lista. 
     */
    public void cargarLista(HashMap <String, Integer> datos) {
        Suceso s = new Suceso();
        s.setClase(this);
        s.setComoSeMostraraLaInfo(Suceso.INFO_CLASE);
        s.setTextoAMostrar("[i]Cargando datos en lista.");
        System.out.println(s);
        
        DefaultListModel<String> modelo  =
                new DefaultListModel<String>();
            
        for (Map.Entry<String, Integer> datosMap : datos.entrySet()) {
            Integer id = datosMap.getValue();
            String datoColumna = datosMap.getKey();
            
            modelo.addElement(datoColumna);
            this.relacionDatoId.put(datoColumna, id);
        }
        this.lista.setModel(modelo);
            
    }
    
   
    private void cambioEntreListas(UtilidadesListas_ _listaQueSeSelecciona,
                                   UtilidadesListas_ _listaALaQueSeAgregaLaSeleccion
                                   ){
                                   
        DefaultListModel quitarDeAqui =(DefaultListModel) _listaQueSeSelecciona.getThis().getModel();
        DefaultListModel agregarAqui =(DefaultListModel) _listaALaQueSeAgregaLaSeleccion.getThis().getModel();
        List<Object> itemSeleccionados = _listaQueSeSelecciona.getThis().getSelectedValuesList();
        for (Object valor : itemSeleccionados) {
            
            agregarAqui.addElement(valor);
            quitarDeAqui.removeElement(valor);
            int id = _listaQueSeSelecciona.getRelacionDatoId().get(valor);
            _listaALaQueSeAgregaLaSeleccion.getRelacionDatoId().put(valor, id);
            _listaQueSeSelecciona.getRelacionDatoId().remove(valor);
        }
    }
    
    /**
     * Gestiona el cambio de datos entre dos listas definidas previamente con 
 setComponente() y getListaAAgregar();
     * @param invertir True manda los datos de la lista principal a la secundaria
     * y viceversa.
     */
    public void cambioEntreListas(boolean invertir){
        if (!invertir) {
            this.cambioEntreListas(this, this.listaAAgregar);
        } else {
            this.cambioEntreListas(this.listaAAgregar, this );
        }
    }

   

    @Override
    public void setError() {
        this.setListaError(this.lista);
    }
    
    public void setError(String mensajeDeError) {
        this.setMensajeDeError(mensajeDeError);
        this.setError();
        this.mostrarError();
    }
    
    public void setErrorQuitar(){
        this.setListaErrorRestaurar(this.lista);
    }
    
    public boolean isEmpty(){
        return !(this.lista.getModel().getSize()>0);
    }
    

    /**
     * No soportado para este item.
     */
    @Deprecated
    @Override
    public void setFocus() {
        throw new UnsupportedOperationException("setFocuso soportado. Listas."); //To change body of generated methods, choose Tools | Templates.
    }


    public JList getThis() {
        return lista;
    }

    
    @Override
    public String getText() {
        throw new UnsupportedOperationException("getText no Soportado. Listas."); //To change body of generated methods, choose Tools | Templates.

    }
    
    /**
     * Limpia la lista controlada por esta utilidad y si la lista de intercambio
     * es !=null entonces tambien la limpia. 
     */
    public void limpiar(){
        this.lista.setModel(new DefaultListModel<>());
        if (this.listaAAgregar!=null) {
            this.listaAAgregar.getLista().setModel(new DefaultListModel<>());
        }
    }

    /**
     *  Agrega elementos a la lista uno por uno. Copia todo lo que hay. 
     * @param txt Texto a agregar
     */
    @Override
    public void setText(String txt) {
        DefaultListModel modelo = (DefaultListModel)this.lista.getModel();
        modelo.addElement(txt);
    }
    
    @Override
    public void setEditable(boolean editable) {
        try {
            throw new ExcepcionPersonalizada("Todavia no esta soportado.", this, "setEditable");
        } catch (ExcepcionPersonalizada ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *  Retorna el mapa que contiene la relación que hay entre el elemento y el id; 
     * @return Un mapa String, int.
     */
    public HashMap getItems(){
        return this.relacionDatoId;
    }
    
    /**
     * Retorna todos los id de la lista. 
     * @return La lista que contiene los id definidos dentro de la lista. 
     */
    public List<Integer> getItems_soloId(){
        List<Integer> ids = new ArrayList<>();
        
        for (Map.Entry<Object, Integer> entry : relacionDatoId.entrySet()) {
            int dato = entry.getValue();
            ids.add(dato);
        }
        return ids;
    }
    
    /**
     * Retorna el id que esta relacionado con el valor que se selecciona.
     * @return El id relacionado con el valor que se selecciono.
     */
    public int getSelectValueId(){
        HashMap<String, Integer> mapa = this.getItems();
        return mapa.get(this.getThis().getSelectedValue());
    }

    
    
    
}
