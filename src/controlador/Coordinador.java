
package controlador;

import controlador.ActualizacionDeComponentesGráficos.ControladorActualizacionGUI_BD;
import controlador.capturadeerrores.CapturaDeSucesos;
import controlador.capturadeerrores.ConsolaDeErrores;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.InfoTabla.DepartamentoIT;
import modelo.InfoTabla.EmpleadoIT;
import modelo.InfoTabla.EntradaLoteIT;
import modelo.InfoTabla.ImagenProveedorIT;
import modelo.InfoTabla.ImagenRefaccionIT;
import modelo.InfoTabla.MaquinaIT;
import modelo.InfoTabla.MaquinaModeloIT;
import modelo.InfoTabla.MaterialIT;
import modelo.InfoTabla.PaisIT;
import modelo.InfoTabla.ParametrosDeCampo;
import modelo.InfoTabla.ProveedorIT;
import modelo.InfoTabla.RefaccionIT;
import modelo.InfoTabla.RelacionRefaccionMaquinaModeloIT;
import modelo.InfoTabla.RelacionRefaccionProveedorIT;
import modelo.InfoTabla.SalidaLoteIT;
import modelo.InfoTabla.SeccionDeMaquinaIT;
import modelo.InfoTabla.UnidadIT;
import modelo.logica.ComparacionLotes;
import modelo.logica.Logica;
import modelo.logica.Validacion;
import modelo.vo.DepartamentoVo;
import modelo.vo.EmpleadoVo;
import modelo.vo.EntradaLoteVo;
import modelo.vo.ImagenProveedorVo;
import modelo.vo.ImagenRefaccionVo;
import modelo.vo.ImportanciaVo;
import modelo.vo.MaquinaHistorialNombresVO;
import modelo.vo.MaquinaModeloVo;
import modelo.vo.MaquinaVo;
import modelo.vo.MaterialVo;
import modelo.vo.PaisVo;
import modelo.vo.ProveedorVo;
import modelo.vo.RefaccionVo;
import modelo.vo.RelacionRefaccionMaquinaModeloVo;
import modelo.vo.RelacionRefaccionProveedorVo;
import modelo.vo.RelacionSeccionMaqRefaccionVO;
import modelo.vo.SalidaLoteVo;
import modelo.vo.SeccionDeMaquinaVO;
import modelo.vo.UnidadVo;
import vista.UtilidadesIntefaz.JDialogBase;
import vista.UtilidadesIntefaz.VentanaPrincipal.MarcoParaVentanaPrincipal;
import vista.panels.PanelEmpleadoAgregar;
import vista.panels.PanelEmpleadoModificar;
import vista.panels.PanelEntradaLote;
import vista.panels.PanelImagenRefaccionDetalle;
import vista.panels.PanelMaquinaAsignarNumeros;
import vista.panels.PanelMaquinaModeloAgregar;
import vista.panels.PanelMaquinaModeloModificar;
import vista.panels.PanelProveedorModificar;
import vista.panels.PanelProveedorRegistrar;
import vista.panels.PanelRefaccionAgregar;
import vista.panels.PanelRefaccionDetalle;
import vista.panels.PanelRefaccionModificar;
import vista.panels.PanelRefaccionesConsulta;
import vista.panels.PanelSalidaDeLote;
import vista.panels.PanelSalidaDeLoteCantidadADescontarDeLote;
import vista.panels.PanelSalidaDeLoteSeleccionLotes;
import vista.panels.PanelSalidaLoteContenedorDeFila;
import vista.panels.PanelSeccionMaquinaRelacionModeloMaquina;

/**
 * Se controlan todas las interacciónes entre las diferentes ventanas. Se mantiene
 * una sola instancia de conexión, usuario y controlador general.
 * @author Rafael Ángel Ramírez Estrada.
 */
public class Coordinador {
    
    private boolean debugMode;
    private ConsolaDeErrores consolaDeErrores;
    private CapturaDeSucesos capturaDeSucesos;
    
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
    private PanelMaquinaAsignarNumeros panelMaquinaAsignarNumeros;
    private PanelSeccionMaquinaRelacionModeloMaquina panelSeccionMaquinaRelacionModeloMaquina;
    
    private ControladorActualizacionGUI_BD controladorActualizacionGUI_BD;
    
    
    
    
    public void salirDelSistema(){
//        JOptionPane.showMessageDialog(null, "saliendo!");
        System.exit(0);
    
    }
    
    public void entrarOQuitarModoDebug(){
        debugMode = !debugMode;
        consolaDeErrores.setVisible(debugMode);
        marcoParaVentanaPrincipal.barraTituloColor();
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

    public CapturaDeSucesos getCapturaDeSucesos() {
        return capturaDeSucesos;
    }

    public void setCapturaDeSucesos(CapturaDeSucesos capturaDeSucesos) {
        this.capturaDeSucesos = capturaDeSucesos;
    }
    
    public ConsolaDeErrores getConsolaDeErrores() {
        return consolaDeErrores;
    }

    public void setConsolaDeErrores(ConsolaDeErrores consolaDeErrores) {
        this.consolaDeErrores = consolaDeErrores;
    }

    public boolean isDebugMode() {
        return debugMode;
    }

    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }
    

    public PanelSeccionMaquinaRelacionModeloMaquina getPanelSeccionMaquinaRelacionModeloMaquina() {
        return panelSeccionMaquinaRelacionModeloMaquina;
    }

    public void setPanelSeccionMaquinaRelacionModeloMaquina(PanelSeccionMaquinaRelacionModeloMaquina panelSeccionMaquinaRelacionModeloMaquina) {
        this.panelSeccionMaquinaRelacionModeloMaquina = panelSeccionMaquinaRelacionModeloMaquina;
    }
    
    public PanelMaquinaAsignarNumeros getPanelMaquinaAsignarNumeros() {
        return panelMaquinaAsignarNumeros;
    }

    public void setPanelMaquinaAsignarNumeros(PanelMaquinaAsignarNumeros panelMaquinaAsignarNumeros) {
        this.panelMaquinaAsignarNumeros = panelMaquinaAsignarNumeros;
    }

    public ControladorActualizacionGUI_BD getControladorActualizacionGUI_BD() {
        return controladorActualizacionGUI_BD;
    }

    public void setControladorActualizacionGUI_BD(ControladorActualizacionGUI_BD controladorActualizacionGUI_BD) {
        this.controladorActualizacionGUI_BD = controladorActualizacionGUI_BD;
    }
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
        panelProveedorRegistrar.configurar();
        d.setVisible(true);
        
    }
    
    /**
     * Abre el dialogo par guardar una nueva refaccioón pasando como parametro
     * lo que el usuario escribio en el detonante de la acción.
     * @param nuevoElemento El elemento que se quire escribir en el dialogo. 
     */
    public void proveedoresAbrirDialogo(String nuevoElemento){
        JDialogBase d = coordinadorPaneles.ifContainsReturnElseCreate(panelProveedorRegistrar);
        panelProveedorRegistrar.setProveedorPrecargado(nuevoElemento);
        panelProveedorRegistrar.configurar();
        d.setVisible(true);
    }
    
    public void proveedoresAbrirDialogoModificar(){
        JDialogBase d = coordinadorPaneles.ifContainsReturnElseCreate(panelProveedorModificar);
        panelProveedorModificar.configurar();
        d.setVisible(true);
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
        boolean a = this.logica.proveedorGuardar(vo);
        if (a) {
            setTablaModificada(ProveedorIT.NOMBRE_TABLA);
        }
        return a;
    }
    
    public boolean proveedorModificar(ProveedorVo vo){
        boolean a = this.logica.proveedorModificar(vo);
        if (a) {
            setTablaModificada(ProveedorIT.NOMBRE_TABLA);
        }
        return a;
    }
    
    public boolean proveedorEliminar(ProveedorVo vo){
        boolean a = this.logica.proveedorEliminar(vo) ;
        if (a) {
            setTablaModificada(ProveedorIT.NOMBRE_TABLA);
        }
        return a;
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
    
    public boolean paisGuardar(PaisVo vo){
        boolean a = this.logica.paisGuardar(vo);
        if (a) {
            setTablaModificada(PaisIT.NOMBRE_TABLA);
        }
        
        return a;
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

    /**
     * Abre el dialogo agregar maquinaModelo.
     * @param modelo El modelo que se quiere precargar. 
     */
    public void maquinaModeloAbrirDialogoAgregar(String modelo){
        JDialogBase d = coordinadorPaneles.ifContainsReturnElseCreate(panelMaquinaModeloAgregar);
        panelMaquinaModeloAgregar.configurar();
        panelMaquinaModeloAgregar.preCargarModelo(modelo);
        d.setVisible(true);
    }
    /**
     * Abre el dialogo agregar maquinaModelo.
     */
    public void maquinaModeloAbrirDialogoAgregar(){
        JDialogBase d = coordinadorPaneles.ifContainsReturnElseCreate(panelMaquinaModeloAgregar);
        panelMaquinaModeloAgregar.configurar();
        d.setVisible(true);
    }
    
    /**
     * Abre el dialogo modificar maquina modelo. 
     */
    public void maquinaModeloAbrirDialogoModificar(){
        JDialogBase d = coordinadorPaneles.ifContainsReturnElseCreate(panelMaquinaModeloModificar);
        panelMaquinaModeloModificar.configurar();
        d.setVisible(true);
    }
    
    /**
     * Valida que los datos que se le pasen sean correctos. 
     * @param vo
     * @param validandoUpdate
     * @return
     */
    public List<Validacion> maquinaModeloValidarCampos(MaquinaModeloVo vo, boolean validandoUpdate){
        return this.logica.maquinaModeloValidarCampos(vo, validandoUpdate);
    
    }
    
    /** 
     * Guarda la máquina modelo que se le pase como parametro. 
     * @param vo
     * @return
     */
    public boolean maquinaModeloGuardar(MaquinaModeloVo vo){
        boolean a = this.logica.maquinaModeloGuardar(vo);
        if (a) {
            setTablaModificada(MaquinaModeloIT.NOMBRE_TABLA);
        }
        return a;
    }
    
    /**
     *  Modifica la maquina modelo que se le pase como parametro. 
     * @param vo
     * @return
     */
    public boolean maquinaModeloModificar(MaquinaModeloVo vo){
        boolean a = this.logica.maquinaModeloModificar(vo);
        if (a) {
            setTablaModificada(MaquinaModeloIT.NOMBRE_TABLA);
        }
        return a;
    }
    
    /**
     * Elimina la máquina-modelo que se le pase como parametro. 
     * @param vo
     * @return
     */
    public boolean maquinaModeloEliminar(MaquinaModeloVo vo){
        boolean a = this.logica.maquinaModeloEliminar(vo);
        if (a) {
            setTablaModificada(MaquinaModeloIT.NOMBRE_TABLA);
        }
        return a;
    }
    
    //ACTUALIZAR
//    public void maquinaModeloActualizarDialogoModificar(){
//          JOptionPane.showMessageDialog(null, "deberia acualizarse---maquinaModeloActualizarDialogoModificar");
////        this.getPanelMaquinaModeloModificar().cargarCombosYListas();
//    }
//    
//    /**
//     * Actualiza el
//     */
//    public void maquinaModeloActualizarDialogoAgregar(){
//          JOptionPane.showMessageDialog(null, "deberia acualizarse---maquinaModeloActualizarDialogoAgregar");
//        this.getPanelMaquinaModeloAgregar().consultarProveedores();
//    }
    
    /**
     * Consulta la lista de modelos - año.
     * @return  Retorna un objeto MaquinaModeloVo.
     */
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
    
    /** 
     * Consulta las máquinas que esten relacionadas con el id 
     * @param id
     * @return
     */
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
    
    public boolean unidadGuardar(UnidadVo vo){
        boolean a = this.logica.unidadGuardar(vo);
        if (a) {
            setTablaModificada(UnidadIT.NOMBRE_TABLA);
        }
        return a;
    
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
    public boolean materialGuardar(MaterialVo vo){
        boolean a = logica.materialGuardar(vo);
        if (a) {
            setTablaModificada(MaterialIT.NOMBRE_TABLA);
        }
        return a;
    
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
     * Modifica las refacciones que esten seleccionadas en tabla del panel consulta
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
            //COMPROBAMOS QUE NO ESTE PUESTO EN TRUE salirDeCicloRefaccionesPorModificar
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
                    coordinadorPaneles.setJPanel(getPanelRefaccionModificar());
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
//                    this.refaccionAbrirPanelConsultaRefacciones();
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
     * Si la refacción es única se ponde en True, así no ejecuta de nuevo la operación
     * para revisar si hay nuevas operaciones. 
     * @param idRefaccion El id de la refacción que se quiere modificar. 
     * @param esUnica 
     */
    public void refaccionAbrirPanelModificar(int idRefaccion, boolean esUnica){
        coordinadorPaneles.setJPanel(getPanelRefaccionModificar());
        getPanelRefaccionModificar().setUnaSolaRefaccion(esUnica);
        this.getPanelRefaccionModificar().configurar(idRefaccion, 0);
    }
    
    
       
    
    public void refaccionAbrirPanelConsultaRefacciones(){
        this.coordinadorPaneles.setJPanel(this.panelRefaccionConsulta);
        
    }
    
    
    //DETALLE DE REFACCIONES
    public void refaccionAbrirDetalleRefaccion(String id){
        JDialogBase d = getCoordinadorPaneles()
                .ifContainsReturnElseCreate(getPanelRefaccionDetalle());
        
        this.getPanelRefaccionDetalle().configurar(id);
        d.setVisible(true);
        
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
        JDialogBase d = getCoordinadorPaneles()
                .ifContainsReturnElseCreate(panelImagenDetalle);
        this.getPanelImagenDetalle().configurar();
        
        d.setVisible(true);
    
    }
    
    public void refaccionMostrarDetalleActualizarImagenes(){
        JOptionPane.showMessageDialog(null, "se supone que se actualiza. ---refaccionMostrarDetalleActualizarImagenes()");
//        this.getPanelRefaccionDetalle().cargarImagenes();
//        this.getPanelImagenDetalle().cargarImagenes();
    }
    
    //GUARDAR DATOS
    public boolean refaccionGuardar(RefaccionVo vo){
        boolean a = logica.refaccionGuardar(vo);
        if (a) {
            setTablaModificada(RefaccionIT.NOMBRE_TABLA);
        }
        return a;
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
    
//    public void refaccionActualizarPanelConsultaRefacciones(){
//        JOptionPane.showMessageDialog(null, "se supone que se debe actualizar.---refaccionActualizarPanelConsultaRefacciones");
////        this.getPanelRefaccionConsulta().getOpAct().actualizarPanel();
//    }
    
    public void refaccionActualizarPanelAgregarRefaccion(){
        JOptionPane.showMessageDialog(null, "se supone que se debe actualizar.---refaccionActualizarPanelAgregarRefaccion");
//        this.getPanelRefaccionAgregar().getOpAct().actualizarPanel();
    }
    
    public void refaccionActualizarPanelModificar(){
        JOptionPane.showMessageDialog(null, "se supone que se debe actualizar.---refaccionActualizarPanelModificar");
//        this.getPanelRefaccionModificar().cargarListasYCombos();
    }
    
    /**
     * Retorna la lista de imágenes consultadas en DialogoDetalleRefaccion.
     * @return  Las imágenes ya cargadas en otro dialogo.
     */ 
    public List<ImagenRefaccionVo> refaccionListaDeImagenesDetalles(){
        return this.getPanelRefaccionDetalle().getListaImagenesRefaccion();
    }
    
    //MODIFICAR DATOS.
    public boolean refaccionModificar(RefaccionVo vo){
        boolean a = this.logica.refaccionModificar(vo);
        if (a) {
            setTablaModificada(RefaccionIT.NOMBRE_TABLA);
        }
        return a;
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
        setTablaModificada(ImagenRefaccionIT.NOMBRE_TABLA);
        return this.logica.imagenRefaccionGuardarLista(vo);
    }
    
    public List<ImagenRefaccionVo> imagenRefaccionConsultar(int id){
        return this.logica.imagenRefaccionConsultar(id);
    }
    
    public boolean imagenRefaccionEliminar(ImagenRefaccionVo vo){
        
        boolean a = this.logica.imagenRefaccionEliminar(vo);
        if (a) {
            setTablaModificada(ImagenRefaccionIT.NOMBRE_TABLA);
        }
        return a;
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
        setTablaModificada(ImagenProveedorIT.NOMBRE_TABLA);
        return this.logica.imagenProveedorGuardarLista(vo);
    }
    
    public List<ImagenProveedorVo> imagenProveedorConsultar(int id){
        return this.logica.imagenProveedorConsultar(id);
    }
    
    public boolean imagenProveedorEliminar(ImagenProveedorVo vo){
        boolean a = this.logica.imagenProveedorEliminar(vo);
        if (a) {
            setTablaModificada(ImagenProveedorIT.NOMBRE_TABLA);
        }
        return a;
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
    public boolean relacionRefaccionMaquinaModeloGuardarLista(
            List <RelacionRefaccionMaquinaModeloVo> listaVo){
        setTablaModificada(RelacionRefaccionMaquinaModeloIT.NOMBRE_TABLA);
        return this.logica.relacionRefaccionMaquinaModeloGuardarLista(listaVo);
    }
    
    /**
     * Actualiza la lista de máquinas relacionadas con una refacción.
     * @param lvo La lista de RelacionRefaccionMaquinaModeloVo que se quieren
     * actualizar. 
     */
    public void relacionRefaccionMaquinaModeloModificarLista(
            List<RelacionRefaccionMaquinaModeloVo> lvo){
        setTablaModificada(RelacionRefaccionMaquinaModeloIT.NOMBRE_TABLA);
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
        panelEmpleadoAgregar.configurar();
        d.setVisible(true);
    }
    
    public void empleadoAbrirDialogoAgregar(String empleadoNuevo){
        JDialog d = coordinadorPaneles.ifContainsReturnElseCreate(panelEmpleadoAgregar);
        panelEmpleadoAgregar.configurar(empleadoNuevo);
        d.setVisible(true);
    }
    
    public void empleadoAbrirDialogoModificar(){
        JDialog d = coordinadorPaneles.ifContainsReturnElseCreate(panelEmpleadoModificar);
        panelEmpleadoModificar.configurar();
        d.setVisible(true);
    }
    
    public void empleadoAbrirDialogoModificar(String empleado){
        JDialog d = coordinadorPaneles.ifContainsReturnElseCreate(panelEmpleadoModificar);
        panelEmpleadoModificar.configurar(empleado);
        d.setVisible(true);
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
        boolean a = this.logica.empleadoGuardar(vo);
        if (a) {
            setTablaModificada(EmpleadoIT.NOMBRE_TABLA);
        }
        return a;
    }
    
    public boolean empleadoModificar(EmpleadoVo vo){
        boolean a = this.logica.empleadoModificar(vo);
        if (a) {
            setTablaModificada(EmpleadoIT.NOMBRE_TABLA);
        }
        return a;
    }
    
    public boolean empleadoDarDeBajaAlta(EmpleadoVo vo){
        boolean a = this.logica.empleadoDarDeBajaAlta(vo);
        if (a) {
            setTablaModificada(EmpleadoIT.NOMBRE_TABLA);
        }
        return a;
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
        boolean a  = this.logica.departamentoGuardar(vo);
        if (a) {
            setTablaModificada(DepartamentoIT.NOMBRE_TABLA);
        }
        return a;
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
    
    public boolean relacionRefaccionProveedorGuardarLista(List<RelacionRefaccionProveedorVo> listaVo){
        setTablaModificada(RelacionRefaccionProveedorIT.NOMBRE_TABLA);
        return this.logica.relacionRefaccionProveedorGuardarLista(listaVo);
    }
    
    public void relacionRefaccionProveedorModificarLista(
            List<RelacionRefaccionProveedorVo> listaVo){
        setTablaModificada(RelacionRefaccionProveedorIT.NOMBRE_TABLA);
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
        panelEntradaLote.configurar();
        d.setVisible(true);
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
        boolean a = this.logica.entradaLoteGuardar(vo);
        if (a) {
            setTablaModificada(EntradaLoteIT.NOMBRE_TABLA);
        }
        return a;
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
        boolean a =  this.logica.entradaloteActualizarLotes(listaELVParaActualizar);
        if (a) {
             setTablaModificada(EntradaLoteIT.NOMBRE_TABLA);
        }
        return a; 
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
        panelSalidaDeLote.configurar();
        d.setVisible(true);
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
        boolean a = this.logica.salidaLoteGuadar(vo);
        if (a) {
            setTablaModificada(SalidaLoteIT.NOMBRE_TABLA);
        }
        return a;
        
    }

//    public float salidaLoteExistencia(int id){
//        return this.logica.salidaLoteExistencia(id);
//    }
//    
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
       INICIO DE IMPORTANCIA
    ////////////////////////////////////////////////////////////////////////
    */

        public List<ImportanciaVo> importanciaConsultar() {
            return this.logica.importanciaConsultar();

        }
    /* 
        
        
      /* ////////////////////////////////////////////////////////////////////////
        FIN DE IMPORTANCIA
    ========================================================================
    */
   
    /* 
    ========================================================================
       INICIO DE ACTUALIZACIONES DE TABLA
    ////////////////////////////////////////////////////////////////////////
    */

    /**
     * Cuando modificamos algúna tabla la seteamos con esta operación para que
     * posteriormente se actualize con actualizarTodoLoVisible(); 
     * 
     * Esta se debe porner solo en el coordinador cuando llamemos las operaciones
     * de la lógica que agregan o modifican algúna tabla. No usar en los paneles. 
     * @param tabla
     */
    public void setTablaModificada(String tabla){
        controladorActualizacionGUI_BD.setTablaModificada(tabla);
    }
    
    /**
     * Actualiza todos los paneles visible que esten etiquetados como desactualzados. 
     * Se manda a llamar desde las últimas acciones de guardado que ejecuta el panel
     * cuidando sea antes del mensaje de confirmación de modificación según sea
     * el caso. 
     */
    public void actualizarTodoLoVisible(){
        controladorActualizacionGUI_BD.actualizarTodoLoQueEsteVisible();
    }
    
    
    /*
        FIN DE ACTUALIZACIONES DE TABLA
    ========================================================================
    */
   
    /* 
    ========================================================================
       INICIO DE MAQUINA
    ////////////////////////////////////////////////////////////////////////
    */
    
    
    /**
     * Abre el dialogo que permite registrar y asignar números a máquinas para 
     * manejarlas independientemente de maquina-modelos.
     */
    public void maquinaAbrirDialogoAsignarNumeros(){
        JDialogBase d = coordinadorPaneles
                .ifContainsReturnElseCreate(panelMaquinaAsignarNumeros);
        d.setVisible(true);
    }

    /**
     * Retorna todas las máquinas existentes en la tabla Maquina.
     * @return
     */
    public List<MaquinaVo> maquinaConsultar() {
        return logica.maquinaConsultar();
    }

    /**
     * Elimina la máquina seleccionada y todo lo que este relacionada con ella. 
     * @param vo La máquina que se quiere eliminar. 
     * @return True si se elimino correctamente. 
     */
    public boolean maquinaEliminar(MaquinaVo vo) {
        setTablaModificada(MaquinaIT.NOMBRE_TABLA);
        return logica.maquinaEliminar(vo);
    }

    /**
     * Comprueba si la refacción existe. A diferencia de {@see maquinaRepetido}
     * esta comprueba solo si la refacción que se le pase existe más de una vez
     * incluida la misma que se le pase.
     * 
     * Sirve para comprobar si se modifica la máquina o se agrega una nueva. 
     * 
     * @param vo La refacción que se comprobara si esta repetida. 
     * @return True si esta repetida. 
     */
    public boolean maquinaExiste(MaquinaVo vo) {
        return logica.maquinaExiste(vo);
    }

    /**
     * Valida que los campos cumplan las condiciones para almacenarse o modificarse. 
     * 
     * @param vo
     * @return
     */
    public List<Validacion> maquinaValidarCampos(MaquinaVo vo) {
        return logica.maquinaValidadCampos(vo);
    }
    
    /**
     * Revisa que la máquina no este repetida sin incluirse a ella misma. 
     * @param vo La máquina que se quiere comparar.
     * @return True si existe repetido. 
     */
    public boolean maquinaRepetido(MaquinaVo vo) {
        return logica.maquinaRepetido(vo);
    }

    /**
     * Modifca la refacción que se le pase como parametro. 
     * @param vo
     * @return
     */
    public boolean maquinaModificar(MaquinaVo vo) {
        setTablaModificada(MaquinaIT.NOMBRE_TABLA);
        return logica.maquinaModificar(vo);
    }

    /**
     * Guarda la máquina que se le pase como parametro. 
     * @param vo
     * @return
     */
    public boolean maquinaGuardar(MaquinaVo vo) {
        setTablaModificada(MaquinaIT.NOMBRE_TABLA);
        return logica.maquinaGuardar(vo);
    }
    
     /**
     * Almacena el nombre que fue modificado y guarda la fecha y hora en que se 
     * modifico. 
     * @param mhnVo El objeto que contiene los datos a alamcenar. 
     * @return True si se logro.
     */
    public boolean maquinaHistorialNombresGuardar(MaquinaHistorialNombresVO mhnVo) {
        return logica.maquinaHistorialNombresGuardar(mhnVo);

    }

     /* 
    ////////////////////////////////////////////////////////////////////////
        FIN DE MAQUINA
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

    /**
     * Abre el dialogo seccion de maquina. 
     */
    public void seccionDeMaquinaAbrirDialogo(){
        JDialogBase d = getCoordinadorPaneles().ifContainsReturnElseCreate(panelSeccionMaquinaRelacionModeloMaquina);
        d.setVisible(true);
    }

    /**
     * Consulta todas las secciones que hay registradas. 
     * @return
     */
    public List<SeccionDeMaquinaVO> seccionDeMaquinaConsultar() {
        return logica.seccionDeMaquinaConsultar();
    }

    /**
     * Esto que hace????
     * @param idActual
     * @return
     */
    public List<MaquinaModeloVo> maquinaModeloRelacionSeccion(SeccionDeMaquinaVO idActual) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Valida que la sección este correcta. 
     * @param sdmvo Los datos de la sección.
     * @return El resultado de las validaciones. 
     */
    public List<Validacion> seccionDeMaquinaValidar(SeccionDeMaquinaVO sdmvo) {
        SeccionDeMaquinaIT it = new SeccionDeMaquinaIT();
        List<Validacion> listVal = new ArrayList<>();
        for (ParametrosDeCampo parametrosDeCampo : it.getCamposPDC()) {
            
            if (parametrosDeCampo.getNombre().equals(it.getIdPDC().getNombre())) {
                Validacion val = new Validacion();
                if (sdmvo.getNombreSeccion().isEmpty()) {
                    val.setMensajeDeError("No has definido un nombre.");
                    val.setValido(false);
                } else {
                    val.setValido(true);
                }
                listVal.add(val);
            }
        }
        return listVal;
    }

    /**
     * Guarda una sección de máquina en la BD.
     * @param sdmvo Los datos de la sección que se quieren guardar. 
     * @return True si todo fue correcto. 
     */
    public boolean seccionDeMaquinaGuardar(SeccionDeMaquinaVO sdmvo) {
        boolean a = logica.seccionDeMaquinaGuardar(sdmvo);
        if (a) {
            setTablaModificada(SeccionDeMaquinaIT.NOMBRE_TABLA);
        }
        return a;
    }

    /**
     * Retorna el último id en la tabla de secciones máquinas. 
     * @return El último id de la seccion;
     */
    public int seccionDeMaquinaUltimoId() {
        return logica.seccionDeMaquinaUltimoId();
    }

    /**
     * Guarda la relacion que hay entre la sección de la máquina y la refacción.
     * @param listRelacion Lista de refacciones relacionadas.
     * @return True si todo fue bien. 
     */
    public boolean seccionDeMaquinaRelacionRefaccionGuardar(List<RelacionSeccionMaqRefaccionVO> listRelacion) {
        return logica.seccionDeMaquinaRelacionRefaccionGuardar(listRelacion);
        
    }

    public List<RefaccionVo> refaccionConsultarCompatiblesConMaquinaModelo(MaquinaModeloVo mmvo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<RefaccionVo> refaccionRelacionSeccionMaquina(SeccionDeMaquinaVO idActual) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean seccionDeMaquinaEliminar(SeccionDeMaquinaVO seccionDeMaquinaVO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    

}
