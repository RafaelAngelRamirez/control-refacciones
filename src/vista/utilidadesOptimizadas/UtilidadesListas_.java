
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
     * @param dato
     */
    public void removeElement(Object dato){
        DefaultListModel defaultListModel =(DefaultListModel) this.lista.getModel();
        defaultListModel.removeElement(dato);
        this.relacionDatoId.remove((String)dato);
    }
    
    /**
     * Cambia los elementos que se pasen a la segúnda lista.
     * @param dato
     */
    public void cambioEntreListas(Object dato){
        DefaultListModel l1 =(DefaultListModel) this.getThis().getModel();
        l1.removeElement(dato);
        
        DefaultListModel l2 = (DefaultListModel)this.listaAAgregar.getThis().getModel();
        l2.addElement(dato);
    }
    
    /**
     * Nombre que la sentencia sql necesita para recuperar el dato de la 
     * columna id.
     */
    public void setNombreColumnaId(String nombreColumnaId) {
        this.nombreColumnaId = nombreColumnaId;
    }
    
    /**
     * Nombre de la columna que se mostrara dentro de la lista.
     */
    public void setNombreDatoAMostrar(String nombreDatoAMostrar) {
        this.nombreDatoAMostrar = nombreDatoAMostrar;
    }
    
    /**
    * Lista en la que se cargaran los datos. Para listas dobles con interación
    * tambien es neceasrios agregar setListaAAgregar.
     * @param lista
    */
    public void setComponente(JList<String> lista) {
        this.lista = lista;
    }
   
    public UtilidadesListas_ getListaAAgregar() {
        return listaAAgregar;
    }

     /**
    * Lista en la que se cargaran los datos de la lista principal setComponente()
 cuando se invoque cambioEntreListas().
    * 
     * @param listaAAgregar
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
     * @param datos
     */
    public void cargarLista(HashMap <String, Integer> datos) {
        this.coordinador.getSystemOut().println("[i]Cargando datos en lista.", this);
        DefaultListModel<String> modelo  =
                new DefaultListModel<String>();
            
        for (Map.Entry<String, Integer> datosMap : datos.entrySet()) {
            Integer id = datosMap.getValue();
            String datoColumna = datosMap.getKey();
            
            modelo.addElement(datoColumna);
            this.relacionDatoId.put(datoColumna, id);
        }
//            
//            
//            while ()) {                
//                String datoDeColumna = 
//                        this.controlador.conexion.rst
//                            .getString(this.nombreDatoAMostrar);
//                String datoId =
//                        this.controlador.conexion.rst
//                            .getString(this.nombreColumnaId);
//                
//                modelo.addElement(datoDeColumna);
//                this.relacionDatoId.put(datoDeColumna, datoId);
//            }
//            
        this.lista.setModel(modelo);
// ????? SI HAY DOS LISTAS REINICIAMOS LA OTRA PARA NO DUPLICAR DATOS.
            
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
        
        
//        JList<String> listaQueSeSelecciona = _listaQueSeSelecciona.getLista();
//        JList<String> listaALaQueSeAgregaLaSeleccion=_listaALaQueSeAgregaLaSeleccion.getLista();
//        
//        //CARGAMOS LOS DATOS SELECCIONADOS.
//        List<String> listaDeLosDatosSeleccionados = 
//                listaQueSeSelecciona.getSelectedValuesList();
//        
//        if(listaDeLosDatosSeleccionados.size()>0){
//            //CARGAMOS LOS DATOS EXISTENTES EN EL MODELO DE LA LISTA POR AGREGAR.
//            ListModel<String> modeloDeListaALaQueSeAgregaLaSeleccion = 
//                    listaALaQueSeAgregaLaSeleccion.getModel();
//
//            //CARGAMOS LOS DATOS EXISTENTES EN EL MODELO DE LA LISTA QUE SE 
//            // SELECCIONA
//            ListModel<String> modeloListaQueSeSelecciona = 
//                    listaQueSeSelecciona.getModel();
//            
//            //LISTA PARA COMPARAR LOS DATOS QUE SE SELCCIONARON CONTRA 
//            // LOS QUE ESTAN EN EL MODELO.
//            List <String> listaDeDatosActualizadosParaListaQueSeSelecciona 
//                    = new ArrayList<String>();
//            
//            //CARGAMOS TODOS LOS DATOS EN LA NUEVA LISTA PARA IR ELIMINANDO
//            // LOS QUE YA COMPARAMOS.
//            for (int i = 0; i < modeloListaQueSeSelecciona.getSize(); i++) {
//                String elementoDeLaListaQueSeSelecciona = 
//                        modeloListaQueSeSelecciona.getElementAt(i);
//                listaDeDatosActualizadosParaListaQueSeSelecciona
//                        .add(elementoDeLaListaQueSeSelecciona);
//            }
//            
//            //ELIMINAMOS LOS QUE YA EXISTEN
//            
//            for (String listaDeLosDatosSeleccionado : listaDeLosDatosSeleccionados) {
//                //SANTO DIOS! Aqui copiamos los datos de relacionDatoId a el 
//                // nuevo hashMap o más bien a la otra lista con la que estamos 
//                // intercambiando datos. De esta manera podemos llamar más 
//                // facilmente los dato que tienen registrador y ponerlos en la 
//                // base de datos.
//                
//                _listaALaQueSeAgregaLaSeleccion.getRelacionDatoId().put(listaDeLosDatosSeleccionado
//                        , _listaQueSeSelecciona.getRelacionDatoId().get(listaDeLosDatosSeleccionado));
//                _listaQueSeSelecciona.getRelacionDatoId().remove(listaDeLosDatosSeleccionado);
//                
//                //AQUI REMOVEMOS DE LA LISTA PARA ACTUALIZARLA.
//                listaDeDatosActualizadosParaListaQueSeSelecciona
//                        .remove(listaDeLosDatosSeleccionado);
//            }
//       
//            
//            //CREAMOS EL NUEVO MODELO PARA ACTUALIZAR LOS DATOS DE LA LISTA
//            // QUE SE SELCCIONA Y QUE NO LOS MUESTRE UNA VEZ EN QUE ESTEN EN 
//            // LA LISTA POR AGREGAR.
//            DefaultListModel<String> modeloParaActualizarDatosListaQueSeSelecciona = new DefaultListModel<>();
//            for (String elementoActualizado : listaDeDatosActualizadosParaListaQueSeSelecciona) {
//                modeloParaActualizarDatosListaQueSeSelecciona.addElement(elementoActualizado);
//            }
//            listaQueSeSelecciona.setModel(modeloParaActualizarDatosListaQueSeSelecciona);
//
//
//            // CARGAMOS LOS DATOS YA EXISTENTES EN EL NUEVO MODELO PARA LA LISTA.
//            DefaultListModel<String> modeloParaListaAgregarDatos = new DefaultListModel<>();
//            for (int i = 0; i < modeloDeListaALaQueSeAgregaLaSeleccion.getSize(); i++) {
//                String elemento = modeloDeListaALaQueSeAgregaLaSeleccion.getElementAt(i);
//                modeloParaListaAgregarDatos.addElement(elemento);
//            }
//            for (String elemento : listaDeLosDatosSeleccionados) {
//                modeloParaListaAgregarDatos.addElement(elemento);
//            }
//            listaALaQueSeAgregaLaSeleccion.setModel(modeloParaListaAgregarDatos);
//        }
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
     */
    public void limpiar(){
        this.lista.setModel(new DefaultListModel<>());
        this.listaAAgregar.getLista().setModel(new DefaultListModel<>());
    }

    /**
     *  Agrega elementos a la lista uno por uno. Copia todo lo que hay. 
     * @param txt
     */
    @Override
    public void setText(String txt) {
        ListModel modelo = this.lista.getModel();
        DefaultListModel nuevoModelo = new DefaultListModel();
        for (int i = 0; i < modelo.getSize(); i++) {
            nuevoModelo.addElement(modelo.getElementAt(i));
        }
        nuevoModelo.addElement(txt);
        this.lista.setModel(nuevoModelo);
    }
    
    /**
     *  Retorna el mapa que contiene la relación que hay entre el elemento y el id; 
     */
    public HashMap getItems(){
        return this.relacionDatoId;
    }
    
    public List<Integer> getItems_soloId(){
        List<Integer> ids = new ArrayList<>();
        
        for (Map.Entry<Object, Integer> entry : relacionDatoId.entrySet()) {
            int dato = entry.getValue();
            ids.add(dato);
        }
        return ids;
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
