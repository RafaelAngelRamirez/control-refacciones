
package vista.UtilidadesIntefaz.utilidadesOptimizadas;

import vista.UtilidadesIntefaz.OperacionesBasicasPorDefinir;
import controlador.capturadeerrores.Suceso;
import modelo.ExcepcionPersonalizada;
import controlador.Coordinador;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Utilidades para el fácil manejo de las listas.
 * @author Rafael Ángel Ramírez Estrada
 */
public class UtilidadesListas_ extends OperacionesBasicasPorDefinir{
    
    private String nombreColumnaId, nombreDatoAMostrar;
    private JList<String> lista;
    private UtilidadesListas_ ComponenteListaAAgregar;
    protected boolean limpiandoLista = false;
    private DefaultListModel defaultListModel;

    public DefaultListModel getDefaultListModel() {
        return defaultListModel;
    }

    public void setDefaultListModel(DefaultListModel defaultListModel) {
        this.defaultListModel = defaultListModel;
    }
    
    private HashMap<Object, Object> relacionDatoId  = new HashMap();

    public UtilidadesListas_(Coordinador controlador) {
        super(controlador);
        this.defaultListModel = new DefaultListModel();
    }

    public HashMap<Object, Object> getRelacionDatoId() {
        return relacionDatoId;
    }

    public void setRelacionDatoId(HashMap<Object, Object> relacionDatoId) {
        this.relacionDatoId = relacionDatoId;
    }

    /**
     * Remueve un elemento de la lista.
     * @param dato El elemento que se quiere remover.
     */
    public void removeElement(Object dato){
//        defaultListModel =(DefaultListModel) this.lista.getModel();
        defaultListModel.removeElement(dato);
        this.relacionDatoId.remove((String)dato);
    }
    
    /**
     * Cambia los elementos que se pasen a la segúnda lista.
     * @param dato El dato que se quiere interacambiar.
     */
    public void cambioEntreListas(Object dato){
//        DefaultListModel l1 =(DefaultListModel) this.getThis().getModel();
        defaultListModel.removeElement(dato);
        
//        DefaultListModel l2 = (DefaultListModel)this.ComponenteListaAAgregar.getThis().getModel();
        this.ComponenteListaAAgregar.getDefaultListModel().addElement(dato);
    }
    
    
    /**
    * Lista en la que se cargaran los datos. Para listas dobles con interación
    * tambien es neceasrios agregar setListaAAgregar.
     * @param lista La lista que se quiere manejar con esta utilidad.
    */
    public void setComponente(JList<String> lista) {
        defaultListModel  =
                new DefaultListModel<String>();
        lista.setModel(defaultListModel);
//        DefaultListModel defaultListModel = new DefaultListModel<Object>();
//        lista.setModel(defaultListModel);
        this.lista = lista;
    }
   
    /**
     * La lista con la que se intercambiaran datos. Se setea aqui para un manejo
     * más facil.
     * @return El componente JList.
     */
    public UtilidadesListas_ getComponenteListaAAgregar() {
        return ComponenteListaAAgregar;
    }

     /**
    * Lista en la que se cargaran los datos de la lista principal setComponente()
 cuando se invoque cambioEntreListas().
    * 
     * @param ComponenteListaAAgregar La lista que se quiere manejar para el intercambio de
     * datos.
    */
    public void setComponenteListaAAgregar(UtilidadesListas_ ComponenteListaAAgregar) {
        this.ComponenteListaAAgregar = ComponenteListaAAgregar;
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
    public void cargarLista(HashMap <String, Object> datos) {
        Suceso s = new Suceso();
        s.setClase(this);
        s.setComoSeMostraraLaInfo(Suceso.INFO_CLASE);
        s.setTextoAMostrar("[i]Cargando datos en lista.");
        System.out.println(s);
        
        
        
        List<String> ordenar = new ArrayList<>();
        for (Map.Entry<String, Object> datosMap : datos.entrySet()) {
            Object id = datosMap.getValue();
            String datoColumna = datosMap.getKey();
            ordenar.add(datoColumna);
            this.relacionDatoId.put(datoColumna, id);
        }
        Collections.sort(ordenar);
        
        for (String datoOrdenado : ordenar) {
            defaultListModel.addElement(datoOrdenado);
        }
        
//        this.lista.setModel(modelo);
            
    }
    
   
    private void cambioEntreListas(UtilidadesListas_ _listaQueSeSelecciona,
                                   UtilidadesListas_ _listaALaQueSeAgregaLaSeleccion
                                   ){
                                   
        DefaultListModel quitarDeAqui = _listaQueSeSelecciona.getDefaultListModel();
        DefaultListModel agregarAqui = _listaALaQueSeAgregaLaSeleccion.getDefaultListModel();
        System.out.println(quitarDeAqui.size()+"-"+agregarAqui.size());
        List<Object> itemSeleccionados = _listaQueSeSelecciona.getThis().getSelectedValuesList();
        
        for (Object valor : itemSeleccionados) {
            
            agregarAqui.addElement(valor);
            quitarDeAqui.removeElement(valor);
            Object id = _listaQueSeSelecciona.getRelacionDatoId().get(valor);
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
            this.cambioEntreListas(this, this.ComponenteListaAAgregar);
        } else {
            this.cambioEntreListas(this.ComponenteListaAAgregar, this );
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
    
    /**
     * Comprueba a travez del modelo de la lista el tamaño de este y si es menor
     * que 0 retorna true!
     * @return True si esta vacio y getSize()=0
     */
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
        limpiandoLista = true;
//        DefaultListModel modelo = (DefaultListModel)this.lista.getModel();
        defaultListModel.clear();
//        this.lista.setModel(new DefaultListModel<>());
        if (this.ComponenteListaAAgregar!=null) {
            
//            DefaultListModel modelo2 = (DefaultListModel)this.ComponenteListaAAgregar.getLista().getModel();
            this.ComponenteListaAAgregar.getDefaultListModel().clear();
        }
        limpiandoLista = false;
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
     * Retorna todos los id(u objetos) de la lista. 
     * @return La lista que contiene los id definidos dentro de la lista. 
     */
    public List<Object> getItems_soloId(){
        List<Object> ids = new ArrayList<>();
        
        for (Map.Entry<Object, Object> entry : relacionDatoId.entrySet()) {
            Object dato = entry.getValue();
            ids.add(dato);
        }
        return ids;
    }
    
    /**
     * Retorna el id que esta relacionado con el valor que se selecciona.
     * @return El id relacionado con el valor que se selecciono o en caso contrario -1.
     */
    public Object getSelectValueId(){
        HashMap<String, Object> mapa = this.getItems();
        if (this.getThis().getSelectedValue()==null) {
            
            return -1;
        }
        return mapa.get(this.getThis().getSelectedValue());
    }
    
    /**
     * Ejecuta la operación que se le pase como parametro al detectase un cambio
     * en la lista. 
     * @param r La operación que se quiere ejecutar. 
     */
    public void setValueChange(Runnable r){
        this.getThis().addListSelectionListener(new ListSelectionListener() {
            
            Runnable r = null;
            UtilidadesListas_ utilildad;
            public ListSelectionListener parametros(Runnable r, UtilidadesListas_ utilidad){
                this.r = r;
                this.utilildad = utilidad;
                return this;
            }
            
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!utilildad.limpiandoLista) {
                    r.run();
                }
            }
        }.parametros(r, this));
    
    }

    
    
    
}
