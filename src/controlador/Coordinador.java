
package controlador;

import vista.panelsYDialogosOptimizados.PanelAgregarRefaccion_;
import vista.panelsYDialogosOptimizados.PanelConsultaRefacciones;
import controlador.capturadeerrores.CapturaDeSucesos;
import controlador.capturadeerrores.ConsolaDeErrores;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import javax.swing.JOptionPane;
import modelo.InfoTabla.MaquinaIT;
import modelo.dao.RelacionRefaccionProveedorDao;
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
import vista.utilidadesOptimizadas.UtilidadesJXViewImage_;
/**
 * Se controlan todas las interacciónes entre las diferentes ventanas. Se mantiene
 * una sola instancia de conexión, usuario y controlador general.
 * @author Rafael Ángel Ramírez Estrada.
 */
public class Coordinador {
    
    private MarcoParaVentanaPrincipal marcoParaVentanaPrincipal;
    private ConsolaDeErrores consolaDeErrores;
    private CapturaDeSucesos SystemOut;
    private PanelConsultaRefacciones panelPrincipal;
    private PanelAgregarRefaccion_ panelAgregarRefaccion;
    private DialogoRegistrarProveedor_ dialogoRegistrarProveedor;
    private Logica logica;
    private DialogoAgregarMaquinaModelo_ dialogoAgregarMaquina_;
    private DialogoDetalleRefaccion_ dialogoDetalleRefaccion_;
    private DialogoDetalleImagen dialogoDetalleImagen;
    private PanelModificarRefaccion panelModificarRefaccion;
    
    
    public DialogoDetalleRefaccion_ getDialogoDetalleRefaccion_() {    
        return dialogoDetalleRefaccion_;
    }
    
    /*
    ========================================================================
    GETS AND SETS
    ////////////////////////////////////////////////////////////////////////
     */

    public PanelModificarRefaccion getPanelModificarRefaccion() {
        return panelModificarRefaccion;
    }

    public void setPanelModificarRefaccion(PanelModificarRefaccion panelModificarRefaccion) {
        this.panelModificarRefaccion = panelModificarRefaccion;
    }
    public DialogoDetalleImagen getDialogoDetalleImagen() {
        return dialogoDetalleImagen;
    }

    public void setDialogoDetalleImagen(DialogoDetalleImagen dialogoDetalleImagen) {
        this.dialogoDetalleImagen = dialogoDetalleImagen;
    }
    
    public void setDialogoDetalleRefaccion_(DialogoDetalleRefaccion_ dialogoDetalleRefaccion_) {
        this.dialogoDetalleRefaccion_ = dialogoDetalleRefaccion_;
    }

    public DialogoAgregarMaquinaModelo_ getDialogoAgregarMaquina_() {
        return dialogoAgregarMaquina_;
    }

    public void setDialogoAgregarMaquina_(DialogoAgregarMaquinaModelo_ dialogoAgregarMaquina_) {
        this.dialogoAgregarMaquina_ = dialogoAgregarMaquina_;
    }
    
    public Logica getLogica() {
        return logica;
    }

    public void setLogica(Logica logica) {
        this.logica = logica;
    }

    public DialogoRegistrarProveedor_ getDialogoRegistrarProveedor() {
        return dialogoRegistrarProveedor;
    }

    public void setDialogoRegistrarProveedor(DialogoRegistrarProveedor_ dialogoRegistrarProveedor) {
        this.dialogoRegistrarProveedor = dialogoRegistrarProveedor;
    }
    
    public PanelAgregarRefaccion_ getPanelAgregarRefaccion() {
       
        return panelAgregarRefaccion;
    }

    public void setPanelAgregarRefaccion(PanelAgregarRefaccion_ panelAgregarRefaccion) {
        this.panelAgregarRefaccion = panelAgregarRefaccion;
    }
    
    public PanelConsultaRefacciones getPanelConsultaRefacciones() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(PanelConsultaRefacciones panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
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
     * @param debug
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
    
    
    
    /**
     * Abre el dialogo para guardar una nueva refacción.
     * @param dato
     */
    public void proveedorAbrirDialogoGuardarNuevo(){
        //ES NECESARIO LANZAR EL PROCEDIMIENTO DE CONFIGURACIÓN AQUI
        // PARA QUE LAS INSTANCIAS QUE REQUIEREN SE SETEAN POR COMPLETO.
        this.getDialogoRegistrarProveedor().configurar();
        this.getDialogoRegistrarProveedor().setVisible(true);
    }
    
    /**
     * Abre el dialogo par guardar una nueva refaccioón pasando como parametro
     * lo que el usuario escrribio en el detonante de la acción.
     * @param nuevoElemento
     */
    public void proveedoresAbrirDialogo(String nuevoElemento){
        this.getDialogoRegistrarProveedor().configurar();
        this.getDialogoRegistrarProveedor().setProveedorPrecargado(nuevoElemento);
        this.getDialogoRegistrarProveedor().setVisible(true);
    }
    
    /**
     * Guarda un proveedor en la base de datos. 
     * @param vo
     */
    public void proveedorGuardar(ProveedorVo vo){
        this.logica.proveedorGuardar(vo);
    }
    public void proveedorActualizarLista(){
        this.getPanelAgregarRefaccion().cargarListaProveedor();
    }
    
    /**
     * Consulta toda la lista de proveedores y retorna solo el campo empresa.  
     * @return 
     */
    public List<ProveedorVo> proveedoresConsultarMarcas(){
        return this.logica.proveedorConsultarMarcas();
    }
    
    
    /**
     * Consulta toda la lista de proveedores y retorna solo el campo empresa 
     * filtrando las coincidencias con el id que se le pase como parametro.  
     * @return 
     */
    public List<RelacionRefaccionProveedorVo> proveedoresConsultarMarcas(int id){
        return this.logica.proveedorConsultarMarcas(id);
    }
    
    /**
     * Revisa si proveedorExiste un proveedor en la base de datos. 
     */
    public boolean proveedorExiste (String proveedor){
        return this.logica.proveedorExiste(proveedor);
    }
    
    
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
    
    public void maquinaModeloAbrirDialogo(){
        getDialogoAgregarMaquina_().configurar();
        getDialogoAgregarMaquina_().setVisible(true);
    
    }
    
    public List<Validacion> maquinaModeloValidarCampos(MaquinaModeloVo vo){
        return this.logica.maquinaModeloValidarCampos(vo);
    
    }
    
    public void maquinaModeloGuardar(MaquinaModeloVo vo){
        this.logica.maquinaModeloGuardar(vo);
    
    }
    
    public void maquinaModeloActualizarLista(){
        this.getPanelAgregarRefaccion().cargarListaMaquinaModelo();
    }
    
    public List<MaquinaModeloVo> maquinaModeloConsultar(){
        return this.logica.maquinaModeloConsultarModeloAnio();
    
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
    
    
    public void refaccionAbrirPanelConsultaRefacciones(){
        this.getMarcoParaVentanaPrincipal()
                .setJPanelActual(MarcoParaVentanaPrincipal.PANEL_INICIO);
        
    }
    
    
    public List<Validacion> refaccionValidarCampos(RefaccionVo vo){
        return this.logica.refaccionValidarCampos(vo);        
    }
    public List<Validacion> refaccionValidarCampos(RefaccionVo vo, boolean validandoUpdate){
        return this.logica.refaccionValidarCampos(vo, validandoUpdate);        
    }
    
    /**
     * Valida la lista de refaccione que se asociaran con esta refacción. 
     * @param lista
     */
    public List<Validacion> refaccionValidarCamposMaquinaModelo(List<RelacionRefaccionMaquinaModeloVo> lista){
        
        return this.logica.refaccionValidarCamposMaquinaModelo(lista);
    }
    
    /**
     * Valida la lista de proveedores que se asociaran con esta refacción. 
     * @param lista
     */
    public List<Validacion> refaccionValidarCamposProveedor(List<RelacionRefaccionProveedorVo> lista){
        return this.logica.refaccionValidarCamposProveedor(lista);
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
    
    public void refaccionActualizarPanerlConsultaRefacciones(){
        this.getPanelConsultaRefacciones().cargarRefaccionesInicio();
    }
    
    
    
    
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
                //SI NO TENEMOS NINGUNA REFACCION POR MODIFAR CARGAMOS LAS QUE
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
                    this.getPanelModificarRefaccion().configurar(
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
     * 
     */
    public void refaccionAbrirPanelModificar(){
        refaccionAbrirPanelModificar(false);
    }
    
    public void refaccionAbrirPanelModificar(int idRefaccion){
        this.getMarcoParaVentanaPrincipal()
                .setJPanelActual(MarcoParaVentanaPrincipal.PANEL_MODIFICAR_REFACCION);
        this.getPanelModificarRefaccion().configurar(idRefaccion, 0);
    }
    
    
    //GUARDAR DATOS
    public void refaccionGuardar(RefaccionVo vo){
        this.logica.refaccionGuardar(vo);
    }
    
    public int refaccionConsultarUltimoId(){
        return this.logica.refaccionConsultarUltimoId();
    }
    
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
    
    
    
    //RELACION REFACCION MAQUINA MODELO
    
    public void relacionRefaccionMaquinaModeloGuardarLista(
            List <RelacionRefaccionMaquinaModeloVo> listaVo){
        this.logica.relacionRefaccionMaquinaModeloGuardarLista(listaVo);
    }
    
    public void relacionRefaccionProveedorGuardarLista(List<RelacionRefaccionProveedorVo> listaVo){
        this.logica.relacionRefaccionProveedorGuardarLista(listaVo);
    }
    
    
    //DETALLE DE REFACCIONES
    public void refaccionMostrarDetalle(String id){
        this.getDialogoDetalleRefaccion_().configurar(id);
        this.getDialogoDetalleRefaccion_().setVisible(true);
    }
    
    //DETALLE DE IMAGENES
    
    public void refaccionMostrarDetalleImagen(){
        this.getDialogoDetalleImagen().setVisible(true);
        this.getDialogoDetalleImagen().configurar();
    
    }
    
    public void refaccionMostrarDetalleActualizarImagenes(int id){
        this.getDialogoDetalleRefaccion_().cargarImagenes(id);
        this.getDialogoDetalleImagen().cargarImagenes();
    }
    
    /**
     * Retorna la lista de imágenes consultadas en DialogoDetalleRefaccion.
     */ 
    public List<ImagenVo> refaccionListaDeImagenesDetalles(){
        return this.getDialogoDetalleRefaccion_().getListaImagenesRefaccion();
    }
    
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN DE REFACCION
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
