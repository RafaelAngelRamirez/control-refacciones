
package controlador;

import java.math.BigDecimal;
import vista.panels.PanelEmpleadoModificar;
import vista.panels.PanelRefaccionDetalle;
import vista.panels.PanelMaquinaModeloAgregar;
import vista.panels.PanelProveedorModificar;
import vista.panels.PanelImagenRefaccionDetalle;
import vista.panels.PanelMaquinaModeloModificar;
import vista.panels.PanelEntradaLote;
import vista.panels.PanelEmpleadoAgregar;
import vista.panels.PanelProveedorRegistrar;
import vista.panels.PanelSalidaDeLote;
import vista.panels.PanelRefaccionModificar;
import vista.panels.PanelRefaccionAgregar;
import vista.panels.PanelRefaccionesConsulta;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.logica.ComparacionLotes;
import modelo.logica.Logica;
import modelo.logica.Validacion;
import modelo.vo.DepartamentoVo;
import modelo.vo.EmpleadoVo;
import modelo.vo.EntradaLoteVo;
import modelo.vo.ImagenProveedorVo;
import modelo.vo.ImagenRefaccionVo;
import modelo.vo.MaquinaModeloVo;
import modelo.vo.MaterialVo;
import modelo.vo.PaisVo;
import modelo.vo.ProveedorVo;
import modelo.vo.RefaccionVo;
import modelo.vo.RelacionRefaccionMaquinaModeloVo;
import modelo.vo.RelacionRefaccionProveedorVo;
import modelo.vo.SalidaLoteVo;
import modelo.vo.UnidadVo;
import vista.UtilidadesIntefaz.JDialogBase;
import vista.UtilidadesIntefaz.VentanaPrincipal.MarcoParaVentanaPrincipal;
import vista.panels.PanelSalidaDeLoteCantidadADescontarDeLote;
import vista.panels.PanelSalidaDeLoteSeleccionLotes;
import vista.panels.PanelSalidaLoteContenedorDeFila;

/**
 * Se controlan todas las interacciónes entre las diferentes ventanas. Se mantiene
 * una sola instancia de conexión, usuario y controlador general.
 * @author Rafael Ángel Ramírez Estrada.
 */
public class Coordinador {
    
    private CoordinadorPaneles coordinadorPaneles;
    
    
    private MarcoParaVentanaPrincipal marcoParaVentanaPrincipal;
    private Logica logica;
    
    private PanelRefaccionesConsulta panelRefaccionConsulta;
    private PanelRefaccionAgregar panelRefaccionAgregar;
    private PanelRefaccionModificar panelRefaccionModificar;
    
    private PanelMaquinaModeloAgregar panelMaquinaModeloAgregar;
    private PanelRefaccionDetalle panelRefaccionDetalle;
    private PanelImagenRefaccionDetalle panelImagenDetalle;
    private PanelProveedorRegistrar panelProveedorRegistrar;
    private PanelMaquinaModeloModificar panelMaquinaModeloModificar;
    private PanelProveedorModificar panelProveedorModificar;
    private PanelEntradaLote panelEntradaLote;
    private PanelEmpleadoAgregar panelEmpleadoAgregar;
    private PanelEmpleadoModificar panelEmpleadoModificar;
    private PanelSalidaDeLote panelSalidaDeLote;
    private PanelSalidaDeLoteSeleccionLotes panelSalidaDeLoteSeleccionLotes;
    private PanelSalidaDeLoteCantidadADescontarDeLote panelSalidaDeLoteCantidadADescontarDeLote;
    
    
    
    
    public void salirDelSistema(){
        JOptionPane.showMessageDialog(null, "saliendo!");
        System.exit(0);
    
    }
    
//    /**
//     * Comprueba que el forma de fecha que se le pase sea correcto.
//     * @param fecha
//     */
//    public void comprobarFecha(String fecha, int formatoDeFecha){
//    
//    }

    /*
    ========================================================================
    GETS AND SETS
    ////////////////////////////////////////////////////////////////////////
     */

    public PanelSalidaDeLoteCantidadADescontarDeLote getPanelSalidaDeLoteCantidadADescontarDeLote() {
        return panelSalidaDeLoteCantidadADescontarDeLote;
    }

    public void setPanelSalidaDeLoteCantidadADescontarDeLote(PanelSalidaDeLoteCantidadADescontarDeLote panelSalidaDeLoteCantidadADescontarDeLote) {
        this.panelSalidaDeLoteCantidadADescontarDeLote = panelSalidaDeLoteCantidadADescontarDeLote;
    }
    
    public PanelSalidaDeLoteSeleccionLotes getPanelSalidaDeLoteSeleccionLotes() {
        return panelSalidaDeLoteSeleccionLotes;
    }

    public void setPanelSalidaDeLoteSeleccionLotes(PanelSalidaDeLoteSeleccionLotes panelSalidaDeLoteSeleccionLotes) {
        this.panelSalidaDeLoteSeleccionLotes = panelSalidaDeLoteSeleccionLotes;
    }
    
    public CoordinadorPaneles getCoordinadorPaneles() {
        return coordinadorPaneles;
    }

    public void setCoordinadorPaneles(CoordinadorPaneles coordinadorPaneles) {
        this.coordinadorPaneles = coordinadorPaneles;
    }
    
    public PanelSalidaDeLote getpanelSalidaLote() {
        return panelSalidaDeLote;
    }

    public void setPanelSalidaDeLote(PanelSalidaDeLote panelSalidaDeLote) {
        this.panelSalidaDeLote = panelSalidaDeLote;
    }
    
    public PanelEmpleadoModificar getPanelEmpleadoModificar() {
        return panelEmpleadoModificar;
    }

    public void setPanelEmpleadoModificar(PanelEmpleadoModificar panelEmpleadoModificar) {
        this.panelEmpleadoModificar = panelEmpleadoModificar;
    }
    
    public PanelEmpleadoAgregar getPanelEmpleadoAgregar() {    
        return panelEmpleadoAgregar;
    }
    public void setPanelEmpleadoAgregar(PanelEmpleadoAgregar panelEmpleadoAgregar) {
        this.panelEmpleadoAgregar = panelEmpleadoAgregar;
    }

    public PanelRefaccionDetalle getPanelRefaccionDetalle() {    
        return panelRefaccionDetalle;
    }
    
    public PanelEntradaLote getPanelEntradaLote() {
        return panelEntradaLote;
    }

    public void setPanelEntradaLote(PanelEntradaLote panelEntradaLote) {
        this.panelEntradaLote = panelEntradaLote;
    }
    
    public PanelProveedorModificar getPanelProveedorModificar() {
        return panelProveedorModificar;
    }

    public void setPanelProveedorModificar(PanelProveedorModificar panelProveedorModificar) {
        this.panelProveedorModificar = panelProveedorModificar;
    }

    public PanelMaquinaModeloModificar getPanelMaquinaModeloModificar() {
        return panelMaquinaModeloModificar;
    }

    public void setPanelMaquinaModeloModificar(PanelMaquinaModeloModificar panelMaquinaModeloModificar) {
        this.panelMaquinaModeloModificar = panelMaquinaModeloModificar;
    }
    
    public PanelRefaccionModificar getPanelRefaccionModificar() {
        return panelRefaccionModificar;
    }

    public void setPanelRefaccionModificar(PanelRefaccionModificar panelRefaccionModificar) {
        this.panelRefaccionModificar = panelRefaccionModificar;
    }
    
    public PanelImagenRefaccionDetalle getPanelImagenDetalle() {
        return panelImagenDetalle;
    }

    public void setPanelImagenDetalle(PanelImagenRefaccionDetalle panelImagenDetalle) {
        this.panelImagenDetalle = panelImagenDetalle;
    }
    
    public void setPanelRefaccionDetalle(PanelRefaccionDetalle panelRefaccionDetalle) {
        this.panelRefaccionDetalle = panelRefaccionDetalle;
    }

    public PanelMaquinaModeloAgregar getPanelMaquinaModeloAgregar() {
        return panelMaquinaModeloAgregar;
    }

    public void setPanelMaquinaModeloAgregar(PanelMaquinaModeloAgregar panelMaquinaModeloAgregar) {
        this.panelMaquinaModeloAgregar = panelMaquinaModeloAgregar;
    }
    
    public Logica getLogica() {
        return logica;
    }

    public void setLogica(Logica logica) {
        this.logica = logica;
    }

    public PanelProveedorRegistrar getPanelProveedorRegistrar() {
        return panelProveedorRegistrar;
    }

    public void setPanelProveedorRegistrar(PanelProveedorRegistrar panelProveedorRegistrar) {
        this.panelProveedorRegistrar = panelProveedorRegistrar;
    }
    
    public PanelRefaccionAgregar getPanelRefaccionAgregar() {
       
        return panelRefaccionAgregar;
    }

    public void setPanelRefaccionAgregar(PanelRefaccionAgregar panelRefaccionAgregar) {
        this.panelRefaccionAgregar = panelRefaccionAgregar;
    }
    
    public PanelRefaccionesConsulta getPanelRefaccionConsulta() {
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

    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN GETS AND SETS
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
        JDialogBase d = coordinadorPaneles.ifContainsReturnElseCreate(panelProveedorRegistrar);
        d.setVisible(true);
        panelProveedorRegistrar.configurar();
        
    }
    
    /**
     * Abre el dialogo par guardar una nueva refaccioón pasando como parametro
     * lo que el usuario escribio en el detonante de la acción.
     * @param nuevoElemento El elemento que se quire escribir en el dialogo. 
     */
    public void proveedoresAbrirDialogo(String nuevoElemento){
        JDialogBase d = coordinadorPaneles.ifContainsReturnElseCreate(panelProveedorRegistrar);
        d.setVisible(true);
        panelProveedorRegistrar.configurar();
        panelProveedorRegistrar.setProveedorPrecargado(nuevoElemento);
    }
    
    public void proveedoresAbrirDialogoModificar(){
        JDialogBase d = coordinadorPaneles.ifContainsReturnElseCreate(panelProveedorModificar);
        d.setVisible(true);
        panelProveedorModificar.configurar();
    }
    
    public void proveedorDialogoModificarActualizarPais(){
        this.getPanelProveedorModificar().cargarComboPaises();
    }
    public void proveedorDialogoModificarActualizarListaProveedores(){
        this.getPanelProveedorModificar().cargarListaProveedores();
    }
    
    public void proveedorDialogoModificarActualizarImagenes(){
        this.getPanelProveedorModificar().cargarImagenes();
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
     * @return  True si todo salio bien. 
     */
    public boolean proveedorGuardar(ProveedorVo vo){
        return this.logica.proveedorGuardar(vo);
    }
    
    public boolean proveedorModificar(ProveedorVo vo){
        return this.logica.proveedorModificar(vo);
    }
    
    public boolean proveedorEliminar(ProveedorVo vo){
        return this.logica.proveedorEliminar(vo);
    }
    
    public int proveedorConsultarUltimoId(){
        return this.logica.proveedorConsultarUltimoId();
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
    
    public ProveedorVo proveedorConsultar(int id){
        return this.logica.proveedorConsultar(id);
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
        return this.logica.proveedorValidarCampos(Vo, false);
    
    }
    
    public List<Validacion> proveedorValidarCampos(ProveedorVo vo, boolean validandoUpdate){
        return this.logica.proveedorValidarCampos(vo, validandoUpdate);
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
        
        JDialogBase d = coordinadorPaneles.ifContainsReturnElseCreate(panelMaquinaModeloAgregar);
        d.setVisible(true);
        panelMaquinaModeloAgregar.configurar();
        
    
    }
    
    public void maquinaModeloAbrirDialogoModificar(){
        JDialogBase d = coordinadorPaneles.ifContainsReturnElseCreate(panelMaquinaModeloModificar);
        d.setVisible(true);
        panelMaquinaModeloModificar.configurar();
    }
    
    public List<Validacion> maquinaModeloValidarCampos(MaquinaModeloVo vo, boolean validandoUpdate){
        return this.logica.maquinaModeloValidarCampos(vo, validandoUpdate);
    
    }
    
    public boolean maquinaModeloGuardar(MaquinaModeloVo vo){
        return this.logica.maquinaModeloGuardar(vo);
    }
    
    public boolean maquinaModeloModificar(MaquinaModeloVo vo){
        return this.logica.maquinaModeloModificar(vo);
    }
    
    public boolean maquinaModeloEliminar(MaquinaModeloVo vo){
        return this.logica.maquinaModeloEliminar(vo);
    }
    
    //ACTUALIZAR
    public void maquinaModeloActualizarDialogoModificar(){
        this.getPanelMaquinaModeloModificar().cargarCombosYListas();
    }
    
    public void maquinaModeloActualizarDialogoAgregar(){
        this.getPanelMaquinaModeloAgregar().consultarProveedores();
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
                    refaccionesPorModificarId = this.getPanelRefaccionConsulta().getIdSeleccionados();
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
                    coordinadorPaneles.setJPanel(getPanelRefaccionModificar());
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
        coordinadorPaneles.setJPanel(getPanelRefaccionModificar());
        this.getPanelRefaccionModificar().configurar(idRefaccion, 0);
    }
    
    
    
    public void refaccionAbrirPanelConsultaRefacciones(){
        refaccionAbrirPanelConsultaRefacciones_Panel(false);
    }

    public void refaccionAbrirPanelConsultaRefacciones_Panel(boolean configurar){
        this.coordinadorPaneles.setJPanel(this.panelRefaccionConsulta);
        if (configurar) {
        this.panelRefaccionConsulta.configurar();
        }
    }
    
    public JDialogBase refaccionAbrirPanelConsultaRefacciones_Dialogo(boolean configurar){
        JDialogBase d = new JDialogBase(this);
        d.add(this.getPanelRefaccionConsulta());
        if (configurar) {
            d.configurarPanel();
        }
        d.pack();
        d.setVisible(true);
        return d;
    }
    
    
    //DETALLE DE REFACCIONES
    public void refaccionAbrirDetalleRefaccion(String id){
        JDialogBase d = getCoordinadorPaneles()
                .ifContainsReturnElseCreate(getPanelRefaccionDetalle());
        d.setVisible(true);
        this.getPanelRefaccionDetalle().configurar(id);
        
    }
    
    public void refaccionAbrirDetalleRefaccion(){
        int a = this.getPanelRefaccionConsulta().getIdSeleccionado();
        if (a==-1) {
            JOptionPane.showMessageDialog(null, "Selecciona un elemento de la \n"
                    + "tabla para mostrarlo.");
 
        }else{
            refaccionAbrirDetalleRefaccion(a+"");
        }
    }
    
    //DETALLE DE IMAGENES
    
    public void refaccionAbrirDetalleImagen(){
        this.getPanelImagenDetalle().setVisible(true);
        this.getPanelImagenDetalle().configurar();
    
    }
    
    public void refaccionMostrarDetalleActualizarImagenes(){
        this.getPanelRefaccionDetalle().cargarImagenes();
        this.getPanelImagenDetalle().cargarImagenes();
    }
    
    //GUARDAR DATOS
    public void refaccionGuardar(RefaccionVo vo){
        this.logica.refaccionGuardar(vo);
    }
    
    public void refaccionAbrirPanelAgregar(){
        this.coordinadorPaneles.setJPanel(panelRefaccionAgregar);
        panelRefaccionAgregar.configurar();
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
        this.getPanelRefaccionConsulta().cargarRefaccionesInicio();
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
    public List<ImagenRefaccionVo> refaccionListaDeImagenesDetalles(){
        return this.getPanelRefaccionDetalle().getListaImagenesRefaccion();
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
       INICIO DE IMAGENREFACCION
    ////////////////////////////////////////////////////////////////////////
    */
    //IMAGENES
    public String imagenRefaccionGuardarLista(List<ImagenRefaccionVo> vo){
        return this.logica.imagenRefaccionGuardarLista(vo);
    }
    
    public List<ImagenRefaccionVo> imagenRefaccionConsultar(int id){
        return this.logica.imagenRefaccionConsultar(id);
    }
    
    public void imagenRefaccionEliminar(ImagenRefaccionVo vo){
        this.logica.imagenRefaccionEliminar(vo);
    }
    
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN DE IMAGENREFACCION
    ========================================================================
    */
    
    /* 
    ========================================================================
       INICIO DE IMAGENPROVEEDOR
    ////////////////////////////////////////////////////////////////////////
    */
    //IMAGENES
    public String imagenProveedorGuardarLista(List<ImagenProveedorVo> vo){
        return this.logica.imagenProveedorGuardarLista(vo);
    }
    
    public List<ImagenProveedorVo> imagenProveedorConsultar(int id){
        return this.logica.imagenProveedorConsultar(id);
    }
    
    public void imagenProveedorEliminar(ImagenProveedorVo vo){
        this.logica.imagenProveedorEliminar(vo);
    }
    
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN DE IMAGENPROVEEDOR
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
       INICIO DE EMPLEADO
    ////////////////////////////////////////////////////////////////////////
    */
    
       
    public void empleadoAbrirDialogoAgregar(){
        
        JDialog d = coordinadorPaneles.ifContainsReturnElseCreate(panelEmpleadoAgregar);
        d.setVisible(true);
        panelEmpleadoAgregar.configurar();
    }
    
    public void empleadoAbrirDialogoAgregar(String empleadoNuevo){
        JDialog d = coordinadorPaneles.ifContainsReturnElseCreate(panelEmpleadoAgregar);
        d.setVisible(true);
        panelEmpleadoAgregar.configurar(empleadoNuevo);
    }
    
    public void empleadoAbrirDialogoMoficar(){
        JDialog d = coordinadorPaneles.ifContainsReturnElseCreate(panelEmpleadoModificar);
        d.setVisible(true);
        panelEmpleadoModificar.configurar();
    }
    
    public void empleadoAbrirDialogoMoficar(String empleado){
        JDialog d = coordinadorPaneles.ifContainsReturnElseCreate(panelEmpleadoModificar);
        d.setVisible(true);
        panelEmpleadoModificar.configurar(empleado);
    } 
        
    public void empleadoDialogoModificarActualizar(){
            JOptionPane.showMessageDialog(null, "pendiente implementacion");
    }
    
    
    public void empleadoDialogoAgregarActualizar(){
        JOptionPane.showMessageDialog(null, "pendiente implementacion");
    }
    
    public List<Validacion> empleadoValidarCampos(EmpleadoVo vo){
        return this.logica.empleadoValidarCampos(vo);
    }
    
    public boolean empleadoGuardar(EmpleadoVo vo ){
        return this.logica.empleadoGuardar(vo);
    }
    
    public boolean empleadoModificar(EmpleadoVo vo){
        return this.logica.empleadoModificar(vo);
    }
    
    public boolean empleadoDarDeBajaAlta(EmpleadoVo vo){
        return this.logica.empleadoDarDeBajaAlta(vo);
    }
    public int empleadoConsultarUltimoId(){
        return this.logica.empleadoConsultarUltimoId();
    }
    
    public List<EmpleadoVo> empleadoConsultarTodo(){
        return this.logica.empleadoConsultarTodo();
    }
    public List<EmpleadoVo> empleadoConsultarTodoConBajas(){
        return this.logica.empleadoConsultarTodoConBajas();
    }
    
    public List<EmpleadoVo> empleadoConsultarBusqueda(String busqueda){
        return this.logica.empleadoConsultarBusqueda(busqueda);
    }
    public List<EmpleadoVo> empleadoConsultarBusquedaConBajas(String busqueda){
        return this.logica.empleadoConsultarBusquedaConBajas(busqueda);
    }
    
    
    
    
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN DE EMPLEADO
    ========================================================================
    */
    /* 
    ========================================================================
       INICIO DE DEPARTAMENTO
    ////////////////////////////////////////////////////////////////////////
    */
    
    public boolean departamentoGuardar(DepartamentoVo vo){
        return this.logica.departamentoGuardar(vo);
    
    }
    
    public List<DepartamentoVo> departamentoConsultarTodo(){
        return this.logica.departamentoConsultarTodo();
    
    }
    
    
    
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN DE DEPARTAMENTO
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
       INICIO DE ENTRADA LOTE
    ////////////////////////////////////////////////////////////////////////
    */
    public void entradaLoteAbrirDialogo(){
        JDialogBase d = coordinadorPaneles.ifContainsReturnElseCreate(panelEntradaLote);
        d.setVisible(true);
        panelEntradaLote.configurar();
    }

    /**
     * Abre el dialogo y muestra directamente la refacción que se le pase como
     * parametro. 
     * @param vo
     */
    public void entradaLoteAbrirDialogo(RefaccionVo vo){
        entradaLoteAbrirDialogo();
        panelEntradaLote.cargarRefaccionParaEntrada(vo);
    }
        
    /**
     * Abre el dialog entrada lote y setea la variable externo dentro del panel
     * para que se abra de nuevo el dialogo panelSalidaDeLote.
     * @param vo
     * @param externo
     */
    public void entradaLoteAbrirDialogoConRetornoAPanelSalidaLote(RefaccionVo vo){
        entradaLoteAbrirDialogo();
        panelEntradaLote.cargarRefaccionParaEntrada(vo, true);
    }

    public void entradaLoteDialogoSetearItemComboRecienAgregado(Object item){
        this.entradaLoteActualizarComboEmpleados();
        panelEntradaLote.setearItemComboEmpleado(item);

    }

    public void entradaLoteActualizarComboEmpleados(){
        this.getPanelEntradaLote().cargarComboEmpleados();

    }

    public List<Validacion> entradaLoteValidarCampos(EntradaLoteVo vo){
        return this.logica.entradaLoteValidarCampos(vo);
    }

    public boolean entradaLoteGuadar(EntradaLoteVo vo){
        return this.logica.entradaLoteGuardar(vo);
    }

    public float entradaLoteExistencia(int id){
        return this.logica.entradaLoteExistencia(id);
    }
    
    /**
     * Carga los lotes que esten relacionados con el id de la refacción que se le
     * pase.
     * @param id El id de la refacción que se quiere filtrar. 
     * @param cargarVacios True si se quiere cargar tambien los lotes vacios. 
     * @return La lista de lotes que coinciden con los parametros que se definieron.
     */
    public List<EntradaLoteVo> entradaLoteLotes(int id, boolean cargarVacios){
        return this.logica.entradaLoteLotes(id, cargarVacios);
    }

    /**
     * Carga el lote más antiguo que tenga relación con el id que se le
     * pase como parametro. 
     * @param id El id de la refacció que se quiere filtrar. 
     * @return El lote más antiguo que se encontro.
     */
    public EntradaLoteVo entradaLoteLoteMasAntiguo(int id){
        return this.logica.entradaLoteLoteMasAntiguo(id);
    }
    
    /**
     * Actualiza la lista de lotes que se le pasen como parametros. 
     * @param listaELVParaActualizar
     * @return True si la actaulización fue correcta. 
     */
    public boolean entradaLoteActualizarLotes(List<EntradaLoteVo> listaELVParaActualizar) {
         return this.logica.entradaloteActualizarLotes(listaELVParaActualizar);
    
    }
    
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN DE ENTRADA LOTE
    ========================================================================
    */
        
     /* 
    ========================================================================
       INICIO DE SALIDA LOTE
    ////////////////////////////////////////////////////////////////////////
    */

    public void salidaLoteAbrirDialogo(){
        JDialogBase d = coordinadorPaneles.ifContainsReturnElseCreate(panelSalidaDeLote);
        d.setVisible(true);
        panelSalidaDeLote.configurar();
     }
    public void salidaLoteAbrirDialogo(RefaccionVo vo){
        salidaLoteAbrirDialogo();
        float existencia = this.entradaLoteExistencia(vo.getId());
        panelSalidaDeLote.mostrarRefaccion(vo, existencia);
    }


    public void salidaLoteDialogoSetearItemCombo(Object item){
        this.salidaLoteActualizarComboEmpleados();
        this.getpanelSalidaLote().setearItemComboEmpleado(item);
    }

    public void salidaLoteActualizarComboEmpleados(){
        this.getpanelSalidaLote().cargarComboEmpleados();

    }

    public List<Validacion> salidaLoteValidarCampos(SalidaLoteVo vo){
        return this.logica.salidaLoteValidarCampos(vo);
    }
    
    public Validacion salidaLoteValidarLotes(
            List<EntradaLoteVo> lotesDisponibles,
            EntradaLoteVo voSeleccionado){
        return this.logica.salidaLoteValidarLotes(lotesDisponibles, voSeleccionado);
    }

    /**
     * Guarda el registr de los lotes que salieron y que se le pase como parametro.
     * @param vo
     * @return
     */
    public boolean salidaLoteGuadar(List<SalidaLoteVo> vo){
        return this.logica.salidaLoteGuadar(vo);
    }

    public float salidaLoteExistencia(int id){
        return this.logica.salidaLoteExistencia(id);
    }
    
    public void salidaLoteAbrirDialogoSeleccionarLotes(List<EntradaLoteVo> lista, List<EntradaLoteVo> listaSeoleccionActual){
        JDialogBase d = coordinadorPaneles.ifContainsReturnElseCreate(panelSalidaDeLoteSeleccionLotes);
        panelSalidaDeLoteSeleccionLotes.configurar();
        panelSalidaDeLoteSeleccionLotes.cargarLotes(lista, listaSeoleccionActual);
        d.setVisible(true);
    }
    
    /**
     * Carga los lotes seleccionados despues de que el usuario los escoja al 
     * no haber querido por defecto el lote más antiguo. 
     * @param lista
     */
    public void salidaLoteCargarLotesSeleccionados(List<EntradaLoteVo> lista){
        panelSalidaDeLote.cargarLotesSeleccionados(lista);
    }
    
    public void salidaLoteAbrirDialogoCantidadADescontarDeLote(List<ComparacionLotes> comparacionLotes, float cantidadSalida){
        JDialogBase d = coordinadorPaneles
                .ifContainsReturnElseCreate(panelSalidaDeLoteCantidadADescontarDeLote);
        panelSalidaDeLoteCantidadADescontarDeLote.configurar();
        panelSalidaDeLoteCantidadADescontarDeLote.cargarLotes(comparacionLotes, cantidadSalida);
        d.setVisible(true);
    
    }
    
    public List<Validacion> salidaLoteCantidadADescontarDeLoteValidaciones(
            List<PanelSalidaLoteContenedorDeFila> list, BigDecimal totalSalida){
        return this.logica.salidaLoteCantidadADescontarDeLoteValidaciones(
            list, totalSalida);
    
    }
    
           
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN DE SALIDA LOTE
    ========================================================================
    */
    
    
    
    
    /* 
    ========================================================================
       INICIO DE ACTUALIZACIONES DE TABLA
    ////////////////////////////////////////////////////////////////////////
    */
    
//        FIN DE ACTUALIZACIONES DE TABLA
//    ========================================================================
//    */
//    
    
   
    
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
