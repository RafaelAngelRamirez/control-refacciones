
package vista.UtilidadesIntefaz.utilidadesOptimizadas;

import controlador.Coordinador;
import controlador.capturadeerrores.ExcepcionPersonalizada;
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
import vista.UtilidadesIntefaz.OperacionesBasicasPorDefinir;

/**
 * Utilidades para el fácil manejo de las listas.
 * @author Rafael Ángel Ramírez Estrada
 */
public class UtilidadesListas_ extends OperacionesBasicasPorDefinir{
    
//    private String nombreColumnaId, nombreDatoAMostrar;
    private JList<String> lista;
    private UtilidadesListas_ ComponenteListaAAgregar;
    protected boolean listaEnMantenimiento = false;
    private DefaultListModel defaultListModel;

    /**
     * Si esta en true evita que se ejecuta el evento que detecta cambios en la 
     * lista
     * 
     * @return
     */
    public boolean isListaEnMantenimiento() {
        return listaEnMantenimiento;
    }

    public void setListaEnMantenimiento(boolean listaEnMantenimiento) {
        this.listaEnMantenimiento = listaEnMantenimiento;
    }
    
    
    private boolean ejecutarOperacionesEntreCambioDeListas;
    List<OperacionAlCambiarItem> operacionesAlCambiarItem;
    

    public DefaultListModel getDefaultListModel() {
        return defaultListModel;
    }

    public void setDefaultListModel(DefaultListModel defaultListModel) {
        this.defaultListModel = defaultListModel;
    }
    
    private HashMap<Object, Object> relacionDatoId;

    @SuppressWarnings("unchecked")
    public UtilidadesListas_(Coordinador controlador) {
        super(controlador);
        this.ejecutarOperacionesEntreCambioDeListas = true;
        this.operacionesAlCambiarItem = new ArrayList<>();
        this.relacionDatoId = new HashMap();
        this.defaultListModel = new DefaultListModel();
    }

    public HashMap<Object, Object> getRelacionDatoId() {
        return relacionDatoId;
    }

    public void setRelacionDatoId(HashMap<Object, Object> relacionDatoId) {
        this.relacionDatoId = relacionDatoId;
    }

    /**
     * Remueve un elemento de la lista. Para hacer referencia a el se debe
     * pasar como parametro el nombre del objeto. 
     * @param dato El elemento que se quiere remover.
     */
    public void removeElement(Object dato){
        defaultListModel.removeElement(dato);
        this.relacionDatoId.remove((String)dato);
    }
    
    /**
     * Cambia el elemento que se le pase como parametro de una lista a otra. 
     * La refarencia a usar es el nombre que muestra la lista. Si la lista no
     * contiene el elemento entonces marca un error. 
     * 
     * @param dato El dato que se quiere interacambiar.
     */
    @SuppressWarnings({"unchecked", "unchecked"})
    public void cambioEntreListas(Object dato){
        if (!defaultListModel.contains(dato)) {
            try {
                throw new ExcepcionPersonalizada(
                        "El objeto: '"+dato+"' no esta dentro de la lista.",
                        this, "cambioEntreListas(Object dato)");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(UtilidadesListas_.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            
            Object valor = relacionDatoId.remove(dato);
            ComponenteListaAAgregar.getRelacionDatoId().put(dato, valor);
            
            
            defaultListModel.removeElement(dato);
            this.ComponenteListaAAgregar.getDefaultListModel().addElement(dato);
        }    
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
    
//    public String getNombreColumnaId() {
//        return nombreColumnaId;
//    }
//
//    public String getNombreDatoAMostrar() {
//        return nombreDatoAMostrar;
//    }

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
        
    }
    
   
    private void cambioEntreListas(UtilidadesListas_ _listaQueSeSelecciona,
                                   UtilidadesListas_ _listaALaQueSeAgregaLaSeleccion
                                   ){
                                   
        DefaultListModel quitarDeAqui = _listaQueSeSelecciona.getDefaultListModel();
        DefaultListModel agregarAqui = _listaALaQueSeAgregaLaSeleccion.getDefaultListModel();
        @SuppressWarnings("unchecked")
        List<Object> itemSeleccionados = _listaQueSeSelecciona.getThis().getSelectedValuesList();
        
        _listaQueSeSelecciona.setListaEnMantenimiento(true);
        _listaALaQueSeAgregaLaSeleccion.setListaEnMantenimiento(true);
        
        for (Object valor : itemSeleccionados) {
            agregarAqui.addElement(valor);
            quitarDeAqui.removeElement(valor);
            Object id = _listaQueSeSelecciona.getRelacionDatoId().get(valor);
            _listaALaQueSeAgregaLaSeleccion.getRelacionDatoId().put(valor, id);
            _listaQueSeSelecciona.getRelacionDatoId().remove(valor);
        }
        
       
        
        _listaQueSeSelecciona.ordenarLista();
        _listaALaQueSeAgregaLaSeleccion.ordenarLista();
        
        _listaQueSeSelecciona.setListaEnMantenimiento(false);
        _listaALaQueSeAgregaLaSeleccion.setListaEnMantenimiento(false);
    }
    
    public void ordenarLista(){
    
        @SuppressWarnings("unchecked")
        DefaultListModel<String> dlm = this.getDefaultListModel();
        
        List<String> ordenar = new ArrayList<>();
        
        for (Object o : dlm.toArray()) {
            ordenar.add((String)o);
        }
        
        Collections.sort(ordenar);
        
        dlm.clear();
        ordenar.forEach((t)->{
            dlm.addElement(t);
        });
        
        
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
        ejecutarOperacionesDeCambioEntreLista(invertir);
    }
    
    
    /**
     * Esta función ejecuta las operaciones cuando hay un cambio entre las listas.
     * 
     */
    private void ejecutarOperacionesDeCambioEntreLista(boolean invertir){
        if (ejecutarOperacionesEntreCambioDeListas) {
            for (OperacionAlCambiarItem op : operacionesAlCambiarItem) {
                if (op.isCuandoEjecutar()==invertir) {
                    op.getOp().run();
                }
            }
        }
    }
    

    /**
     * True cuando la ejecucuón de operaciones entre listas esta activa. 
     * {@see: addOperacionAlQuitarItem}
     * @return
     */
    public boolean isEjecutarOperacionesEntreCambioDeListas() {
        return ejecutarOperacionesEntreCambioDeListas;
    }

    /**
     * False si se quiere desactivar la ejecución de operaciones cuando hay un 
     * cambio entre listas. 
     * @param ejecutarOperacionesEntreCambioDeListas
     */
    public void setEjecutarOperacionesEntreCambioDeListas(boolean ejecutarOperacionesEntreCambioDeListas) {
        this.ejecutarOperacionesEntreCambioDeListas = ejecutarOperacionesEntreCambioDeListas;
    }

    
    /**
     * Añade operaciones que se ejecutaran cuando haya un cambio entre las listas.
     * @param operacion La operación que se quiere añadir. 
     * @param cuandoEjecutar True cuando se mandan de la lista principal a la secundaria.
     * False al reves.(Esta es la lista principal.) 
     */
    public void addOperacionAlIntercambiarItem(Runnable operacion, boolean cuandoEjecutar){
        OperacionAlCambiarItem a = new OperacionAlCambiarItem();
        a.setCuandoEjecutar(cuandoEjecutar);
        a.setOp(operacion);
        operacionesAlCambiarItem.add(a);
    }
    
    /**
     * Esta clase almacena una operación que se ejecutara durante el cambio 
     * entre listas. 
     */
    private class OperacionAlCambiarItem{
        
        private Runnable op;
        private boolean cuandoEjecutar;

        public Runnable getOp() {
            return op;
        }

        public void setOp(Runnable op) {
            this.op = op;
        }

        public boolean isCuandoEjecutar() {
            return cuandoEjecutar;
        }

        public void setCuandoEjecutar(boolean cuandoEjecutar) {
            this.cuandoEjecutar = cuandoEjecutar;
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

    
    /**
     * Retorna el texto del item seleccionado.  {@see getSelectedValue}
     * @return 
     */
    @Override
    public String getText() {
        return lista.getSelectedValue();
    }
    
    /**
     * Retorna el texto del item seleccionado. 
     * @return
     */
    public String getSelectedValue(){
        return getText();
    }
    
    
    
    /**
     * Limpia la lista controlada por esta utilidad y si la lista de intercambio
     * es !=null entonces tambien la limpia. 
     */
    public void limpiar(){
        listaEnMantenimiento = true;
        defaultListModel.clear();
        if (this.ComponenteListaAAgregar!=null) {
            this.ComponenteListaAAgregar.getDefaultListModel().clear();
        }
        relacionDatoId.clear();
        listaEnMantenimiento = false;
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
    public List<Object> getItems_ObjectsRelacionados(){
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
    public Object getSelectValueObject(){
        if (this.getThis().getSelectedValue()==null) {
            return -1;
        }
        HashMap<String, Object> mapa = this.getItems();
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
                if (!utilildad.listaEnMantenimiento) {
                    r.run();
                }
            }
        }.parametros(r, this));
    }
    
    
}
