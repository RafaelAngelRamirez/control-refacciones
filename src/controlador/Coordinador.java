
package controlador;

import vista.panelsYDialogosOptimizados.PanelRefaccionAgregar;
import vista.panelsYDialogosOptimizados.PanelRefaccionesConsulta;
import controlador.capturadeerrores.CapturaDeSucesos;
import controlador.capturadeerrores.ConsolaDeErrores;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import modelo.InfoTabla.MaquinaModeloIT;
import modelo.InfoTabla.ProveedorIT;
import modelo.InfoTabla.RefaccionIT;
import modelo.logica.Logica;
import modelo.logica.Validacion;
import modelo.vo.ImagenVo;
import modelo.vo.MaquinaModeloVo;
import modelo.vo.MaterialVo;
import modelo.vo.PaisVo;
import modelo.vo.ProveedorVo;
import modelo.vo.RefaccionVo;
import modelo.vo.RelacionRefaccionMaquinaModeloVo;
import modelo.vo.RelacionRefaccionProveedorVo;
import modelo.vo.UnidadVo;
import vista.MarcoParaVentanaPrincipal;
import vista.panelsYDialogosOptimizados.*;

/**
 * Se controlan todas las interacciónes entre las diferentes ventanas. Se mantiene
 * una sola instancia de conexión, usuario y controlador general.
 * @author Rafael Ángel Ramírez Estrada.
 */
public class Coordinador {
    
    private MarcoParaVentanaPrincipal marcoParaVentanaPrincipal;
    private ConsolaDeErrores consolaDeErrores;
    private CapturaDeSucesos SystemOut;
    private Logica logica;
    
    private PanelRefaccionesConsulta panelRefaccionConsulta;
    private PanelRefaccionAgregar panelRefaccionAgregar;
    private PanelRefaccionModificar panelRefaccionModificar;
    
    private DialogoMaquinaModeloAgregar dialogoMaquinaModeloAgregar;
    private DialogoRefaccionDetalle dialogoRefaccionDetalle;
    private DialogoImagenDetalle dialogoImagenDetalle;
    private DialogoProveedorRegistrar dialogoProveedorRegistrar;
    private DialogoMaquinaModeloModificar dialogoMaquinaModeloModificar;
    
    
    public DialogoRefaccionDetalle getDialogoRefaccionDetalle() {    
        return dialogoRefaccionDetalle;
    }
    
    /*
    ========================================================================
    GETS AND SETS
    ////////////////////////////////////////////////////////////////////////
     */

    public DialogoMaquinaModeloModificar getDialogoMaquinaModeloModificar() {
        return dialogoMaquinaModeloModificar;
    }

    public void setDialogoMaquinaModeloModificar(DialogoMaquinaModeloModificar dialogoMaquinaModeloModificar) {
        this.dialogoMaquinaModeloModificar = dialogoMaquinaModeloModificar;
    }
    
    public PanelRefaccionModificar getPanelRefaccionModificar() {
        return panelRefaccionModificar;
    }

    public void setPanelRefaccionModificar(PanelRefaccionModificar panelRefaccionModificar) {
        this.panelRefaccionModificar = panelRefaccionModificar;
    }
    
    public DialogoImagenDetalle getDialogoImagenDetalle() {
        return dialogoImagenDetalle;
    }

    public void setDialogoImagenDetalle(DialogoImagenDetalle dialogoImagenDetalle) {
        this.dialogoImagenDetalle = dialogoImagenDetalle;
    }
    
    public void setDialogoRefaccionDetalle(DialogoRefaccionDetalle dialogoRefaccionDetalle) {
        this.dialogoRefaccionDetalle = dialogoRefaccionDetalle;
    }

    public DialogoMaquinaModeloAgregar getDialogoMaquinaModeloAgregar() {
        return dialogoMaquinaModeloAgregar;
    }

    public void setDialogoMaquinaModeloAgregar(DialogoMaquinaModeloAgregar dialogoMaquinaModeloAgregar) {
        this.dialogoMaquinaModeloAgregar = dialogoMaquinaModeloAgregar;
    }
    
    public Logica getLogica() {
        return logica;
    }

    public void setLogica(Logica logica) {
        this.logica = logica;
    }

    public DialogoProveedorRegistrar getDialogoProveedorRegistrar() {
        return dialogoProveedorRegistrar;
    }

    public void setDialogoProveedorRegistrar(DialogoProveedorRegistrar dialogoProveedorRegistrar) {
        this.dialogoProveedorRegistrar = dialogoProveedorRegistrar;
    }
    
    public PanelRefaccionAgregar getPanelRefaccionAgregar() {
       
        return panelRefaccionAgregar;
    }

    public void setPanelRefaccionAgregar(PanelRefaccionAgregar panelRefaccionAgregar) {
        this.panelRefaccionAgregar = panelRefaccionAgregar;
    }
    
    public PanelRefaccionesConsulta getPanelConsultaRefacciones() {
        return panelRefaccionConsulta;
    }

    public void setPanelRefaccionConsulta(PanelRefaccionesConsulta panelRefaccionConsulta) {
        this.panelRefaccionConsulta = panelRefaccionConsulta;
    }
    
    public MarcoParaVentanaPrincipal getMarcoParaVentanaPrincipal() {
        return marcoParaVentanaPrincipal;
    }
    
    public void setMarcoParaVentanaPrincipal(MarcoParaVentanaPrincipal marcoParaVentanaPrincipal) {
        this.marcoParaVentanaPrincipal = marcoParaVentanaPrincipal;
    }
    
    public ConsolaDeErrores getConsolaDeErrores() {
        return consolaDeErrores;
    }

    public void setConsolaDeErrores(ConsolaDeErrores consolaDeErrores) {
        this.consolaDeErrores = consolaDeErrores;
    }

    public CapturaDeSucesos getSystemOut() {
        return SystemOut;
    }

    public void setSystemOut(CapturaDeSucesos SystemOut) {
        this.SystemOut = SystemOut;
    }
    
    

    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN GETS AND SETS
    ========================================================================
    */
    
    
     /* 
    ========================================================================
       CONSOLA DE DEBUG
    ////////////////////////////////////////////////////////////////////////
    */
    
    /**
    * Inicializa la consola de debugueo.
     * @param debug True si se quiere mostrar la consola de debug. 
    */
    public void inicializarConsola(boolean debug){
       // this.debugueoActivo = debug;
        if (debug) {
            this.getSystemOut().setDebug(debug);
            this.getConsolaDeErrores().setTitle("Consola de debugueo.");
            this.getConsolaDeErrores().getTxtAreaConsola().setEditable(false);
            String mensajeDeConsola = "[!] MODO DEBUG ACTIVADO \n"
                    + "[!] PARA DESACTIVAR ESTA CONSOLA MODIFCA LA CLASE CONTROLADOR.|\n";
            this.getConsolaDeErrores().getTxtAreaConsola().setText(mensajeDeConsola);
            this.getConsolaDeErrores().setVisible(true);
        }        
    }
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN CONSOLA DE DEBUG
    ========================================================================
    */
    
    
    /* 
    ========================================================================
       INICIO PROVEEDOR 
    ////////////////////////////////////////////////////////////////////////
    */
    
    //INTERFAZ
    /**
     * Abre el dialogo para guardar un nuevo proveedor.
     */
    public void proveedorAbrirDialogoGuardarNuevo(){
        //ES NECESARIO LANZAR EL PROCEDIMIENTO DE CONFIGURACIÓN AQUI
        // PARA QUE LAS INSTANCIAS QUE REQUIEREN SE SETEAN POR COMPLETO.
        this.getDialogoProveedorRegistrar().configurar();
        this.getDialogoProveedorRegistrar().setVisible(true);
    }
    
    /**
     * Abre el dialogo par guardar una nueva refaccioón pasando como parametro
     * lo que el usuario escribio en el detonante de la acción.
     * @param nuevoElemento El elemento que se quire escribir en el dialogo. 
     */
    public void proveedoresAbrirDialogo(String nuevoElemento){
        this.getDialogoProveedorRegistrar().configurar();
        this.getDialogoProveedorRegistrar().setProveedorPrecargado(nuevoElemento);
        this.getDialogoProveedorRegistrar().setVisible(true);
    }
    
    //VALIDACIONES
    /**
     * Valida la lista de proveedores que se asociaran con una refacción. 
     * @param lista Lista de datos para comprobar si son validos. 
     * @return Lista con el resultado de las validaciones.
     * @see Validacion
     */
    public List<Validacion> refaccionValidarCamposProveedor(List<RelacionRefaccionProveedorVo> lista){
        return this.logica.refaccionValidarCamposProveedor(lista);
    } 
    
    //GUARDAR Y CONSULTAR.
    /**
     * Guarda un proveedor en la base de datos. 
     * @param vo Los datos del proveedor. 
     */
    public void proveedorGuardar(ProveedorVo vo){
        this.logica.proveedorGuardar(vo);
    }
    public void proveedorActualizarLista(){
        this.getPanelRefaccionAgregar().cargarListaProveedor();
    }
    
    /**
     * Consulta toda la lista de proveedores y retorna solo el campo empresa.  
     * @return  Toda la lista de proveedores existentes. 
     */
    public List<ProveedorVo> proveedoresConsultarMarcas(){
        return this.logica.proveedorConsultarMarcas();
    }
    
    
    /**
     * Consulta toda la lista de proveedores y retorna solo el campo empresa 
     * filtrando las coincidencias con el id que se le pase como parametro.  
     * @param id El id que se quiere filtrar en la tabla. 
     * @return La lista de relaciones entre una refacción y un proveedor dentro de un 
     * clase para ello.
     * @see RelacionRefaccionProveedorVo
     */
    public List<RelacionRefaccionProveedorVo> proveedoresConsultarMarcas(int id){
        return this.logica.proveedorConsultarMarcas(id);
    }
    
    /**
     * Revisa si proveedorExiste un proveedor en la base de datos. 
     * @param proveedor El nombre del proveedor.
     * @return Retorna true si existe. 
     */
    public boolean proveedorExiste (String proveedor){
        return this.logica.proveedorExiste(proveedor);
    }
    
    //VALIDACIONES 
    public List<Validacion> proveedorValidarCampos(ProveedorVo Vo){
        return this.logica.proveedorValidarCampos(Vo);
    
    }
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN DE PROVEEDOR
    ========================================================================
    */
    
    
    
    
    /* 
    ========================================================================
       INICIO PAIS
    ////////////////////////////////////////////////////////////////////////
    */
    
    public void paisGuardar(PaisVo vo){
        this.logica.paisGuardar(vo);
    }
    
    
    public List<PaisVo> PaisConsultar(){
        return this.logica.paisConsultar();
    }
    
    public boolean paisRepetido(String pais){
        return this.logica.paisExiste(pais);
    }
    
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN DE PAIS
    ========================================================================
    */
    
    
    /* 
    ========================================================================
       INICIO MAQUINAS Y MAQUINASMODELO
    ////////////////////////////////////////////////////////////////////////
    */
    
    public void maquinaModeloAbrirDialogoAgregar(){
        getDialogoMaquinaModeloAgregar().configurar();
        getDialogoMaquinaModeloAgregar().setVisible(true);
    
    }
    
    public void maquinaModeloAbrirDialogoModificar(){
        getDialogoMaquinaModeloModificar().configurar();
        getDialogoMaquinaModeloModificar().setVisible(true);
    }
    
    public List<Validacion> maquinaModeloValidarCampos(MaquinaModeloVo vo){
        return this.logica.maquinaModeloValidarCampos(vo);
    
    }
    
    public void maquinaModeloGuardar(MaquinaModeloVo vo){
        this.logica.maquinaModeloGuardar(vo);
    
    }
    
    //ACTUALIZAR
    public void maquinaModeloActualizarDialogoModificar(){
        this.getDialogoMaquinaModeloModificar().cargarCombosYListas();
        
    }
    
    public List<MaquinaModeloVo> maquinaModeloConsultar(){
        return this.logica.maquinaModeloConsultarModeloAnio();
    
    }
    
    /**
     * Busca el objeto que conicida con el id que se le pase como parametro.
     * @param id - El id que se quiere consultar. 
     * @return El objeto que coincide con el id. 
     */
    public MaquinaModeloVo maquinaModeloConsultarUno(int id){
        return this.logica.maquinaModeloConsultarUno(id);
    
    }
    
    public List<RelacionRefaccionMaquinaModeloVo> maquinaModeloConsultar(int id){
        return this.logica.maquinaModeloConsultarModeloAnio(id);
    
    }
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN DE REGISTRO DE MAQUINAS Y MAQUINAS MODELO
    ========================================================================
    */
    
    
    
    /* 
    ========================================================================
      INICIO DE UNIDAD
    ////////////////////////////////////////////////////////////////////////
    */
    
    public void unidadGuardar(UnidadVo vo){
        this.logica.unidadGuardar(vo);
    
    }
    
    public boolean unidadExiste(String unidad){
        return this.logica.unidadExiste(unidad);
    }
    
    public List<UnidadVo> unidadConsultar(){
        return this.logica.unidadConsultar();
    }
    
    
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN DE REGISTRO DE UNIDAD
    ========================================================================
    */
    
    /* 
    ========================================================================
      INICIO DE MATERIAL
    ////////////////////////////////////////////////////////////////////////
    */
    public void materialGuardar(MaterialVo vo){
        this.logica.materialGuardar(vo);
    
    }
    
    public boolean materialExiste(String material){
        return this.logica.materialExiste(material);
    }
    
    public List<MaterialVo> materialConsultar(){
        return this.logica.materialConsultar();
    }
    
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN DE MATERIAL
    ========================================================================
    */
    
    
    /* 
    ========================================================================
      INICIO DE REFACCION
    ////////////////////////////////////////////////////////////////////////
    */
    
    
    //VALIDACIONES.
    
    public List<Validacion> refaccionValidarCampos(RefaccionVo vo){
        return this.logica.refaccionValidarCampos(vo);        
    }
    public List<Validacion> refaccionValidarCampos(RefaccionVo vo, boolean validandoUpdate){
        return this.logica.refaccionValidarCampos(vo, validandoUpdate);        
    }
    
    /**
     * Valida la lista de refaccione que se asociaran con esta refacción. 
     * @param lista La lista de RelacionRefaccionMaquinaModeloVo a validar.
     * @return Retorna el resultad de la valicacion en una clase Validacion.
     * @see Validacion
     */
    public List<Validacion> refaccionValidarCamposMaquinaModelo(List<RelacionRefaccionMaquinaModeloVo> lista){
        
        return this.logica.refaccionValidarCamposMaquinaModelo(lista);
    }
    
    //ABRIR PANEL DIALOGOS
    private Deque<Integer> refaccionesPorModificarId = new ArrayDeque<>();
    private boolean salirDeCicloRefaccionesPorModificar = false;
    /**
     * Modifica las refacciones que esten seleccionadas en talbla del panel consulta
     * de refacciones una por una hasta completar el contador refacccionesPorModificar.
     * @param cancelado True si se cancela la acción de modificar refacciones 
     * antes de que llege a 0 la lista.
     */
    public void refaccionAbrirPanelModificar(boolean cancelado){
        //ESTA FUNCION SE LLAMA DIRECTAMENTE CUANDO SE DEJA QUE TERMINE SOLO
        // DE REVISAR LAS REFACCIONES POR MODIFICAR. 
        if (cancelado) {
            //CUANDO SE QUIERE CANCELAR ESTA TAREA DE REVISION DE REFACCIONES
            // HAY QUE LIMPIAR TODO.
            this.refaccionAbrirPanelConsultaRefacciones();
            refaccionesPorModificarId.clear();
            salirDeCicloRefaccionesPorModificar = false;
        }else{
            //COMPROBAMOS QUE NO ESTE PUESTRO EN TRUE salirDeCicloRefaccionesPorModificar
            // PARA CONTINUAR MODIFICANDO REFACCIONES.
            if (!salirDeCicloRefaccionesPorModificar) {
                //SI NO TENEMOS NINGUNA REFACCION POR MODIFICAR CARGAMOS LAS QUE
                // ESTEN SELECCIONADAS EN LA TABLA.
                if (refaccionesPorModificarId.isEmpty()) {
                    refaccionesPorModificarId = this.getPanelConsultaRefacciones().getIdSeleccionados();
                }
                // SI refaccionesPorModificarId NO ESTA VACIO ENTONCES QUIERE
                //DECIR QUE SE SELECCIONARON ELEMENTOS DE LA TABLA.
                if (!refaccionesPorModificarId.isEmpty()) {
                    // SI refaccionesPorModificarId NO ESTA VACIO ENTONCES
                    //ABRIMOS EL PANEL, LE PASAMOS EL ID A MODIFICAR Y QUITAMOS
                    // DE LA FILA ESE ID. 
                    this.getPanelRefaccionModificar().configurar(
                            refaccionesPorModificarId.pop(),
                            refaccionesPorModificarId.size()
                    );
                    //SI SE QUEDO VACIO refaccionesPorModificarId MANDAMOS UN TRUE
                    // A salirDeCicloRefaccionesPorModificar PARA QUE SE DETENGA
                    // EN EL PRÓXIMO CICLO.
                    if (refaccionesPorModificarId.isEmpty()) {
                        salirDeCicloRefaccionesPorModificar = true;
                    }
                }else{
                    //LO PONEMOS ASI POR QUE SI. xp
                    this.refaccionAbrirPanelConsultaRefacciones();
                    JOptionPane.showMessageDialog(this.getMarcoParaVentanaPrincipal(),
                            "Debes seleccionar por lo menos una refacción de la tabla.");
                }
            }else{
                //ACCIONES CUANDO salirDeCicloRefaccionesPorModificar NOTIFICO
                // QUE YA NO HAY refaccionesPorModificarId.
                this.refaccionAbrirPanelConsultaRefacciones();
                refaccionesPorModificarId.clear();
                salirDeCicloRefaccionesPorModificar = false;
            }
        }    
    }
    
    /**
     * Abre el panel para modificar una sola refaccion en secuencia desde el Deque
     * refaccionesPorModificar. Se utiliza para itinerar hasta que ya no haya 
     * refacciones en la lista por modificar. Esta funcion llama a la funcion
     * sobrecargada refaccionAbrirPanelModificar(boolean cancelar) con el parametro
     * por defecto en falso. De esta manera no jala los datos que esten seleccionados
     * en la tabla de refacciones.
     */
    public void refaccionAbrirPanelModificar(){
        refaccionAbrirPanelModificar(false);
    }
    
    /**
     * Abre el panel para modificar la refacción que se le pase como parametro.
     * @param idRefaccion El id de la refacción que se quiere modificar. 
     */

    public void refaccionAbrirPanelModificar(int idRefaccion){
        this.getMarcoParaVentanaPrincipal()
                .setJPanelActual(MarcoParaVentanaPrincipal.PANEL_MODIFICAR_REFACCION);
        this.getPanelRefaccionModificar().configurar(idRefaccion, 0);
    }
    
    public void refaccionAbrirPanelConsultaRefacciones(){
        this.getMarcoParaVentanaPrincipal()
                .setJPanelActual(MarcoParaVentanaPrincipal.PANEL_CONSULTAR_REFACCIONES);
        
    }
    
    //DETALLE DE REFACCIONES
    public void refaccionAbrirDetalleRefaccion(String id){
        this.getDialogoRefaccionDetalle().configurar(id);
        this.getDialogoRefaccionDetalle().setVisible(true);
    }
    
    public void refaccionAbrirDetalleRefaccion(){
        int a = this.getPanelConsultaRefacciones().getIdSeleccionado();
        if (a==-1) {
            JOptionPane.showMessageDialog(null, "Selecciona un elemento de la \n"
                    + "tabla para mostrarlo.");
 
        }else{
            refaccionAbrirDetalleRefaccion(a+"");
        }
    }
    
    //DETALLE DE IMAGENES
    
    public void refaccionAbrirDetalleImagen(){
        this.getDialogoImagenDetalle().setVisible(true);
        this.getDialogoImagenDetalle().configurar();
    
    }
    
    public void refaccionMostrarDetalleActualizarImagenes(int id){
        this.getDialogoRefaccionDetalle().cargarImagenes(id);
        this.getDialogoImagenDetalle().cargarImagenes();
    }
    
    //GUARDAR DATOS
    public void refaccionGuardar(RefaccionVo vo){
        this.logica.refaccionGuardar(vo);
    }
    
    //CONSULTAR DATOS
    
    public int refaccionConsultarUltimoId(){
        return this.logica.refaccionConsultarUltimoId();
    }
    
     public boolean refaccionExisteCodigoInterno(String codigo){
        return this.logica.refaccionExisteCodigoInterno(codigo);
    }
    
    public List<RefaccionVo> refaccionConsultar(){
        return this.logica.refaccionConsultar();
    }
    
    public RefaccionVo refaccionConsultar(int id){
        return this.logica.refaccionConsultar(id);
    }
    
    public List<RefaccionVo> refaccionConsultarTodoBusqueda(String buscar){
        return this.logica.refaccionConsultarTodoBusqueda(buscar);
    }
    
   
    
    //ACTUALIZAR 
    
    public void refaccionActualizarPanelConsultaRefacciones(){
        this.getPanelConsultaRefacciones().cargarRefaccionesInicio();
    }
    
    public void refaccionActualizarPanelAgregarRefaccion(){
        this.getPanelRefaccionAgregar().cargarListasYCombos();
    }
    
    public void refaccionActualizarPanelModificar(){
        this.getPanelRefaccionModificar().cargarListasYCombos();
    }
    
    /**
     * Retorna la lista de imágenes consultadas en DialogoDetalleRefaccion.
     * @return  Las imágenes ya cargadas en otro dialogo.
     */ 
    public List<ImagenVo> refaccionListaDeImagenesDetalles(){
        return this.getDialogoRefaccionDetalle().getListaImagenesRefaccion();
    }
    
    //MODIFICAR DATOS.
    public void refaccionModificar(RefaccionVo vo){
        this.logica.refaccionModificar(vo);
    }
     /* 
    ////////////////////////////////////////////////////////////////////////
        FIN DE REFACCION
    ========================================================================
    */
    /* 
    ========================================================================
       INICIO DE IMAGEN
    ////////////////////////////////////////////////////////////////////////
    */
    //IMAGENES
    public String imagenGuardarLista(List<ImagenVo> vo){
        return this.logica.imagenGuardarLista(vo);
    }
    
    public List<ImagenVo> imagenConsultar(int id){
        return this.logica.imagenConsultar(id);
    }
    
    public void imagenEliminar(ImagenVo vo){
        this.logica.imagenEliminar(vo);
    }
    
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN DE IMAGEN
    ========================================================================
    */
    
   
    
    /* 
    ========================================================================
       INICIO DE RELACION REFACCION MAQUIN-AMODELO
    ////////////////////////////////////////////////////////////////////////
    */
    
    /**
     * Guarda la lista de maquina-modelo que este relacionada con una refacción
     * en especifico.
     * @param listaVo La lista de RelacionRefaccionMaquinaModeloVo que se quiere
     * guardar. 
     */
    public void relacionRefaccionMaquinaModeloGuardarLista(
            List <RelacionRefaccionMaquinaModeloVo> listaVo){
        this.logica.relacionRefaccionMaquinaModeloGuardarLista(listaVo);
    }
    
    /**
     * Actualiza la lista de máquinas relacionadas con una refacción.
     * @param lvo La lista de RelacionRefaccionMaquinaModeloVo que se quieren
     * actualizar. 
     */
    public void relacionRefaccionMaquinaModeloModificarLista(
            List<RelacionRefaccionMaquinaModeloVo> lvo){
        this.logica.relacionRefaccionMaquinaModeloModificarLista(lvo);
    }
    
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN DE RELACION REFACCION MAQUIN-AMODELO
    ========================================================================
    */
    
    
    /* 
    ========================================================================
       INICIO DE RELACION REFACCION PROVEEDOR
    ////////////////////////////////////////////////////////////////////////
    */
    
    public void relacionRefaccionProveedorGuardarLista(List<RelacionRefaccionProveedorVo> listaVo){
        this.logica.relacionRefaccionProveedorGuardarLista(listaVo);
    }
    
    public void relacionRefaccionProveedorModificarLista(
            List<RelacionRefaccionProveedorVo> listaVo){
        this.logica.relacionRefaccionProveedorModificarLista(listaVo);
    }
    
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN DE RELACION REFACCION PROVEEDOR
    ========================================================================
    */
    
    
    
    /* 
    ========================================================================
       INICIO DE ACTUALIZACIONES DE TABLA
    ////////////////////////////////////////////////////////////////////////
    */
    
    private List<OperacionesPorActualizar> listaOperacionesPorActualizar = new ArrayList<>();

    
    /**
     * Agrega un elemento que contiene operaciones para actualizar elementos que
     * dependen de una tabla y que se puede modificar desde cualquier parte del sistema.
     * @param op El objeto que contiene las especificaciones
     * para ejecutar la actualización de operaciones. 
     * @see OperacionesPorActualizar
     * 
     */
    public void addListaOperacionesPorActualizar(OperacionesPorActualizar op) {
        this.listaOperacionesPorActualizar.add(op);
    }

    /**
     * Ejecuta las operaciones para actualizar contenidas en los objetos 
     * OperacionesPorActualizar que esten actualmente mostrandose y los señala
     * como actualizados. Si hay algún cambio entontonces se debe modificar
     * el objeto directamente en la operacion setActualizado a false.
     */
    public void ejecutarOperacionesParaActualizar(){
        JOptionPane.showMessageDialog(null, "ejecutar operaciones de actualizacion!!!!!");
        for (OperacionesPorActualizar listaOp : listaOperacionesPorActualizar) {
            if(marcoParaVentanaPrincipal.getjPanelActual().getNombre().equals(listaOp.getPanel().getNombre())) {
                if (!listaOp.isActualizado()) {
                    JOptionPane.showMessageDialog(null, "actualizando panel:"+listaOp.getPanel().getNombre());
                    listaOp.actualizar();
                }
            }
        }
    }
    
    public void huboUnCambioEnTabla(String nombreDeLaTabla){
        //ESTE MAMA LO UTILIZAMOS PARA GUARDAR LOS PANELES QUE FUERON MODIFICADOS
        // Y QUE SE TIENEN QUE GUARDAR. 
        JOptionPane.showMessageDialog(null, "se señalo un cambio en la tabla:"+nombreDeLaTabla);
        HashMap<String, Boolean> mapa = new HashMap<>();
        switch(nombreDeLaTabla){
            case RefaccionIT.NOMBRE_TABLA:
                mapa.put(MarcoParaVentanaPrincipal.PANEL_CONSULTAR_REFACCIONES, true);
                break;
            case ProveedorIT.NOMBRE_TABLA:    
                mapa.put(MarcoParaVentanaPrincipal.PANEL_CONSULTAR_REFACCIONES, true);
                mapa.put(MarcoParaVentanaPrincipal.PANEL_MODIFICAR_REFACCION, true);
                mapa.put(MarcoParaVentanaPrincipal.PANEL_REGISTRAR_NUEVA_REFACCION, true);
                break;
            case MaquinaModeloIT.NOMBRE_TABLA:
                mapa.put(MarcoParaVentanaPrincipal.PANEL_CONSULTAR_REFACCIONES, true);
                mapa.put(MarcoParaVentanaPrincipal.PANEL_MODIFICAR_REFACCION, true);
                mapa.put(MarcoParaVentanaPrincipal.PANEL_REGISTRAR_NUEVA_REFACCION, true);
                break;
            
        }
        for (Map.Entry<String, Boolean> entrada : mapa.entrySet()) {
            String nombreDelPanel = entrada.getKey();
            Boolean valor = entrada.getValue();
            for (OperacionesPorActualizar lop : listaOperacionesPorActualizar) {
                if (lop.getPanel().getNombre().equals(nombreDelPanel)) {
                    lop.setActualizado(valor);
                    break;
                }
            }
        }
    }
    
    public class OperacionesPorActualizar{
        private MarcoParaVentanaPrincipal.MenuConstructor panel;
        private List<Runnable> operacionesParaActualizar;
        private boolean actualizado;

        public OperacionesPorActualizar() {
            this.actualizado = true;
            this.operacionesParaActualizar = new ArrayList<>();
        }
        /**
         * Almacena las operaciones de actualización que se ejecutaran cada vez
         * que el panel actual coincida con el definido dentro de este elemento.
         * 
         * @param operacion La operación que se quiere ejecutar. 
         */
        public void addOperacionParaActualizar(Runnable operacion){
            operacionesParaActualizar.add(operacion);
        }

        /**
         * Lista de operaciones definidas para actualizar en el panel. 
         * @return Las operaciones definidas para ejecutar. 
         */
        public List<Runnable> getOperacionesParaActualizar() {
            return operacionesParaActualizar;
        }
        
        /**
         * El panel en objeto tipo MenuConstructor que se quiere comparar. 
         * @return El panel guardado.
         * @see Menuconstructor
         */
        public MarcoParaVentanaPrincipal.MenuConstructor getPanel() {
            return panel;
        }

        /**
         * Añade el menuConstructor que contiene el Jpanel para compararlo
         * con el que se esta visualizando. 
         * @param panel El MenuConstructor 
         */
        public void setPanel(MarcoParaVentanaPrincipal.MenuConstructor panel) {
            this.panel = panel;
        }

        /**
         * Independientemente de las cantidad de operaciones definidas para 
         * actualizar esta función retorna true si ejecutaron todas las operaciones
         * de actualización y retorna false cuando es necesario ejecutar las 
         * operaciones. 
         * @return Devuelve true si se ejecutaron todas las operaciones de actualización.
         * 
         */
        public boolean isActualizado() {
            return actualizado;
        }
        
        /**
         * Ejecuta las operaciones de actualzacion definidas en {@see addOperacionParaActualizar() } 
         * y cambia el estado de {@see isActualizado()} a false;
         */
        public void actualizar(){
            for (Runnable runnable : operacionesParaActualizar) {
                runnable.run();
            }
            setActualizado(false);
        }

        /**
         * Despues de que se ejecutan las operaciones en {@see: getOperacionesParaActualizar()}
         * 
         * @param actualizado
         */
        public void setActualizado(boolean actualizado) {
            this.actualizado = actualizado;
        }
    }
    
    
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN DE ACTUALIZACIONES DE TABLA
    ========================================================================
    */
    
    
    /* 
    ========================================================================
       INICIO DE ALGO
    ////////////////////////////////////////////////////////////////////////
    */
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN DE ALGO
    ========================================================================
    */
    
    
    
    
}
