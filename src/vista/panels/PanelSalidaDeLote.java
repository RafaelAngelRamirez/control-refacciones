/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.panels;

import modelo.logica.ComparacionLotes;
import controlador.Coordinador;
import controlador.CoordinadorPaneles;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.InfoTabla.EmpleadoIT;
import modelo.InfoTabla.RefaccionIT;
import modelo.InfoTabla.SalidaLoteIT;
import modelo.logica.Validacion;
import modelo.vo.EmpleadoVo;
import modelo.vo.EntradaLoteVo;
import modelo.vo.ImagenRefaccionVo;
import modelo.vo.RefaccionVo;
import modelo.vo.SalidaLoteVo;
import modelo.FechaYHora;
import vista.UtilidadesIntefaz.ConfiguracionDePanel;
import vista.UtilidadesIntefaz.OperacionesBasicasPorDefinir;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesBotones_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesComboBox_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesJXViewImage_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesListas_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesTxtArea_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesTxt_;
/**
 *
 * @author Particular
 */
public class PanelSalidaDeLote extends vista.UtilidadesIntefaz.JPanelBase {

    private Coordinador coordinador;
    
    private UtilidadesTxt_ _txtBusqueda;
    private UtilidadesListas_ _listaResultados;
    private UtilidadesTxt_ _txtNombreDeLaRefaccion;
    private UtilidadesTxt_ _txtCodigoInterno;
    private UtilidadesTxt_ _txtCodigoProveedor;
    private UtilidadesTxt_ _txtExistencia;
    private UtilidadesTxt_ _txtStockMax;
    private UtilidadesTxt_ _txtStockMin;
    private UtilidadesTxt_ _txtUnidad;
    private UtilidadesTxt_ _txtFechaDeLote;
    private UtilidadesTxt_ _txtCantidadQueSale;
    private UtilidadesComboBox_ _comboEmpleadoQueReciveLote;
    private UtilidadesComboBox_ _comboLotesDisponibles;
    private UtilidadesTxtArea_ _txtObservaciones;
    private UtilidadesJXViewImage_ _imagenesRefaccion;
    private UtilidadesTxt_ _txtExistenciaLote;
    private int idRefaccionActual;
    
    private List<EntradaLoteVo> voLotesSeleccionadosPorElUsuario;
    
    

    /**
     * Creates new form DialogoEntrada
     */
    public PanelSalidaDeLote() {
        initComponents();
        configuracionesDialogo = new ConfiguracionDePanel();
        configuracionesDialogo.setModal(false);
        configuracionesDialogo.setResizable(false);
        configuracionesDialogo.setTitle(CoordinadorPaneles.PANEL_SALIDA_LOTE);
        configuracionesDialogo.setLocationRelativeTo(null);
        configuracionesDialogo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
    
    @Override
    public void configurar(){
     /*
        =======================================================================
            INICIO CONFIGURACIONES DIALOGO
        ///////////////////////////////////////////////////////////////////////

        Los dialogos nos los estoy configurando de manera complicada. Solo lo
        básico para que funcionen en modal.
        
        */ 
       
        
        /* 
        ////////////////////////////////////////////////////////////////////////
            FIN SETEO DE UTILIDADES
        ========================================================================
        */
        
        /*
        =======================================================================
            INICIO SETEO NOMBRES DE ETIQUETA
        ///////////////////////////////////////////////////////////////////////
        */
        
        RefaccionIT rit = new RefaccionIT();
        SalidaLoteIT elit = new SalidaLoteIT();
        EmpleadoIT eit = new EmpleadoIT();
        
        etiquetaNombreDeLaRefaccion.setText(rit.getNombrePDC().getNombreParaMostrar());
        etiquetaCodigoInterno.setText(rit.getCodigoInternoPDC().getNombreParaMostrar());
        etiquetaCodigoDelProveedor.setText(rit.getCodigoProveedorPDC().getNombreParaMostrar());
        etiquetaStockMin.setText(rit.getStockMinimoPDC().getNombreParaMostrar());
        etiquetaStockMax.setText(rit.getStockMaximoPDC().getNombreParaMostrar());
        etiquetaFechaDeLote.setText(elit.getFechaSalidaLotePDC().getNombreParaMostrar());
        etiquetaCantidadQueEntra.setText(elit.getCantidadPDC().getNombreParaMostrar());
        etiquetaEmpleadoQueReciveElLote.setText(eit.getNombrePDC().getNombreParaMostrar());
        etiquetaObservaciones.setText(elit.getObservacionesPDC().getNombreParaMostrar());
        
               
        /* 
        ////////////////////////////////////////////////////////////////////////
            FIN SETEO NOMBRES DE ETIQUETA
        ========================================================================
        */
        /*
        =======================================================================
            INICIO SETEO UTILIDADES
        ///////////////////////////////////////////////////////////////////////
        */
        //INICIAMOS LAS UTILIDADES.
        
        
        
        _txtBusqueda = new UtilidadesTxt_(coordinador);
        _listaResultados = new UtilidadesListas_(coordinador);
        _txtNombreDeLaRefaccion = new UtilidadesTxt_(coordinador);
        _txtCodigoInterno = new UtilidadesTxt_(coordinador);
        _txtCodigoProveedor = new UtilidadesTxt_(coordinador);
        _txtExistencia = new UtilidadesTxt_(coordinador);
        _txtStockMax = new UtilidadesTxt_(coordinador);
        _txtStockMin = new UtilidadesTxt_(coordinador);
        _txtUnidad = new UtilidadesTxt_(coordinador);
        _txtFechaDeLote = new UtilidadesTxt_(coordinador);
        _txtCantidadQueSale = new UtilidadesTxt_(coordinador);
        _comboEmpleadoQueReciveLote = new UtilidadesComboBox_(coordinador);
        _txtObservaciones = new UtilidadesTxtArea_(coordinador);
        _imagenesRefaccion = new UtilidadesJXViewImage_(coordinador);
        _comboLotesDisponibles = new UtilidadesComboBox_(coordinador);
        _txtExistenciaLote = new UtilidadesTxt_(coordinador);
      
        _txtBusqueda.setNombre("_txtBusqueda");
        _listaResultados.setNombre("_listaResultados");
        _txtNombreDeLaRefaccion.setNombre("_txtNombreDeLaRefaccion");
        _txtCodigoInterno.setNombre("_txtCodigoInterno");
        _txtCodigoProveedor.setNombre("_txtCodigoProveedor");
        _txtExistencia.setNombre("_txtExistencia");
        _txtStockMax.setNombre("_txtStockMax");
        _txtStockMin.setNombre("_txtStockMin");
        _txtUnidad.setNombre("_txtUnidad");
        _txtFechaDeLote.setNombre("_txtFechaDeLote");
        _txtCantidadQueSale.setNombre("_txtCantidadQueEntra");
        _comboEmpleadoQueReciveLote.setNombre("_comboEmpleadoQueReciveLote");
        _txtObservaciones.setNombre("_txtObservaciones");
        _imagenesRefaccion.setNombre("_imagenesRefaccion");
        _comboLotesDisponibles.setNombre("_comboLotesDisponibles");
        _txtExistenciaLote.setNombre("_txtExistenciaLote");
      
        //REMOVEMOS LOS LISTENERS
        for (KeyListener l : txtBusqueda.getKeyListeners()) {
            txtBusqueda.removeKeyListener(l);
        }
        
        //SETEAMOS LOS COMPONENTES DENTRO DE LA UTILIDAD.
        _txtBusqueda.setComponente(txtBusqueda);
        _listaResultados.setComponente(listaResultados);
        _txtNombreDeLaRefaccion.setComponente(this.txtNombreDeLaRefaccion);
        _txtCodigoInterno.setComponente(this.txtCodigoInterno);
        _txtCodigoProveedor.setComponente(this.txtCodigoProveedor);
        _txtExistencia.setComponente(this.txtExistencia);
        _txtStockMax.setComponente(this.txtStockMax);
        _txtStockMin.setComponente(this.txtStockMin);
        _txtUnidad.setComponente(this.txtUnidad);
        _txtFechaDeLote.setComponente(this.txtFechaDeLote);
        _txtCantidadQueSale.setComponente(this.txtCantidadQueSale);
        _comboEmpleadoQueReciveLote.setComponente(this.comboEmpleadoQueReciveLote);
        _txtObservaciones.setComponente(this.txtObservaciones);
        _comboLotesDisponibles.setComponente(comboLotesDisponibles);
        _txtExistenciaLote.setComponente(txtExistenciaLote);
        
        _imagenesRefaccion.setComponente(imagenesRefacciones);
        _imagenesRefaccion.setjLabelContador(etiquetaNombreImagen);
        
        //ASIGNAMOS EL TAMAÑO DE CAMPO
        
        _txtBusqueda.setTamanoDeCampo(300);
        _txtFechaDeLote.setTamanoDeCampo(elit.getFechaSalidaLotePDC().getLongitudDeCaracteres());
        _txtCantidadQueSale.setTamanoDeCampo(elit.getCantidadPDC().getLongitudDeCaracteres(), elit.getCantidadPDC().getLongitudDeDecimales());
        _txtObservaciones.setTamanoDeCampo(elit.getObservacionesPDC().getLongitudDeCaracteres());
        _comboEmpleadoQueReciveLote.setTamanoDeCampo(eit.getNombrePDC().getLongitudDeCaracteres());
        _txtObservaciones.setTamanoDeCampo(elit.getObservacionesPDC().getLongitudDeCaracteres());
        
        //CAMPOS QUE REQUIEREN TEXTO EN MAYUSCULAS.
        
        _txtObservaciones.setPermitirSoloMayusculas();
        _txtBusqueda.setPermitirSoloMayusculas();
        _comboEmpleadoQueReciveLote.setPermitirSoloMayusculas();
        _txtObservaciones.setPermitirSoloMayusculas();
//        _comboLotesDisponibles.setPermitirSoloMayusculas();
        
        //CAMPOS QUE REQUIEREN FECHA. 
        _txtFechaDeLote.setPermitirSoloFecha_ddmmaa();
                
        //CAMPOS NUMÉRICOS
        
        _txtCantidadQueSale.setPermitirSoloNumeros(elit.getCantidadPDC().getLongitudDeCaracteres(), elit.getCantidadPDC().getLongitudDeDecimales());
        
        //QUITAMOS LOS ESPACIOS SOBRANTES DESPUES DE DEJAR EL CAMPO.
        _txtBusqueda.setEspaciosEnBlanco();
        _txtCantidadQueSale.setEspaciosEnBlanco();
        _txtObservaciones.setEspaciosEnBlanco();
        _comboEmpleadoQueReciveLote.setEspaciosEnBlanco();
        
        //TRAVEL POLICY
        
//        _txtBusqueda.setNextFocusableComponent(_txtFechaDeLote.getThis());
        _txtFechaDeLote.setNextFocusableComponent(_txtCantidadQueSale.getThis());
        _txtCantidadQueSale.setNextFocusableComponent(_comboEmpleadoQueReciveLote.getThis());
        _comboEmpleadoQueReciveLote.setNextFocusableComponent(_txtObservaciones.getThis());
        _txtObservaciones.setNextFocusableComponent(btnGuardar);
        btnGuardar.setNextFocusableComponent(btnSalir1);
        btnSalir1.setNextFocusableComponent(_txtBusqueda.getThis());
        
        //ACCIONES ESPECIALES.
        
       
        
        _comboLotesDisponibles.setEditable(false);

        _txtBusqueda.setKeyRelease(()->busqueda(), OperacionesBasicasPorDefinir.TECLA_CUALQUIERA_EXCEPTO_ENTER);
        _txtBusqueda.setKeyRelease(()->seleccionarRefaccionEnter(), OperacionesBasicasPorDefinir.TECLA_ENTER);

        _txtFechaDeLote.setKeyRelease(()->autocompletadoDeFecha(), OperacionesBasicasPorDefinir.TECLA_CUALQUIERA);
       
        
        _comboEmpleadoQueReciveLote.setFocusAction(()->guardarEmpleado(), false);
      
        
       
        
        
        //ACCIONES DE BOTONES
        UtilidadesBotones_.setEnterYEspacio(btnSalir1);
        UtilidadesBotones_.setEnterYEspacio(btnGuardar);
        
        /* 
        ////////////////////////////////////////////////////////////////////////
            FIN SETEO DE UTILIDADES
        ========================================================================
        */
        
        /*
        =======================================================================
            INICIO CARGA DE ELEMENTOS Y CONFIGURACIONES
        ///////////////////////////////////////////////////////////////////////
        */
        
        this.deshabilitarCamposParaRellenar(true);
        this.cargarComboEmpleados();
        
        
        

        /* 
        ////////////////////////////////////////////////////////////////////////
            FIN CARGA DE ELEMENTOS Y CONFIGURACIONES
        ========================================================================
        */    
    
    }
    @Override
    public Coordinador getCoordinador() {
        return coordinador;
    }

    @Override
    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    public void setearItemComboEmpleado(Object item){
        if (_comboEmpleadoQueReciveLote.contieneElItemEscrito(item)) {
            _comboEmpleadoQueReciveLote.setSelectedItem(item);
        }else{
            _comboEmpleadoQueReciveLote.setText("");
            _comboEmpleadoQueReciveLote.setFocus();
                    
        }
    }
    
    public void deshabilitarCamposParaRellenar(boolean deshabilitar){
        deshabilitar = !deshabilitar;
        _comboEmpleadoQueReciveLote.setEditable(deshabilitar);
        _txtFechaDeLote.getThis().setEnabled(deshabilitar);
        _txtCantidadQueSale.getThis().setEnabled(deshabilitar);
        _txtObservaciones.getThis().setEnabled(deshabilitar);
        btnGuardar.setEnabled(deshabilitar);
        _comboLotesDisponibles.setEditable(false);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaObservaciones = new javax.swing.JLabel();
        etiquetaStockMax = new javax.swing.JLabel();
        txtStockMin = new javax.swing.JTextField();
        etiquetaStockMin = new javax.swing.JLabel();
        imagenesRefacciones = new org.jdesktop.swingx.JXImageView();
        btnSiguienteImagen = new javax.swing.JButton();
        btnRegresarImagen = new javax.swing.JButton();
        etiquetaNombreImagen = new javax.swing.JLabel();
        txtStockMax = new javax.swing.JTextField();
        txtExistencia = new javax.swing.JTextField();
        txtNombreDeLaRefaccion = new javax.swing.JTextField();
        etiquetaExistencia = new javax.swing.JLabel();
        txtCodigoInterno = new javax.swing.JTextField();
        etiquetaCodigoInterno = new javax.swing.JLabel();
        txtCodigoProveedor = new javax.swing.JTextField();
        etiquetaCodigoDelProveedor = new javax.swing.JLabel();
        txtUnidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        etiquetaPedidoEnEspera = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        etiquetaFechaDeLote = new javax.swing.JLabel();
        txtFechaDeLote = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        etiquetaCantidadQueEntra = new javax.swing.JLabel();
        txtCantidadQueSale = new javax.swing.JTextField();
        comboEmpleadoQueReciveLote = new javax.swing.JComboBox<>();
        etiquetaNombreDeLaRefaccion = new javax.swing.JLabel();
        etiquetaEmpleadoQueReciveElLote = new javax.swing.JLabel();
        btnSalir1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaResultados = new javax.swing.JList<>();
        txtBusqueda = new javax.swing.JTextField();
        comboLotesDisponibles = new javax.swing.JComboBox<>();
        etiquetaNombreDeLaRefaccion1 = new javax.swing.JLabel();
        etiquetaStockMin1 = new javax.swing.JLabel();
        txtExistenciaLote = new javax.swing.JTextField();

        etiquetaObservaciones.setBackground(new java.awt.Color(30, 30, 30));
        etiquetaObservaciones.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        etiquetaObservaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaObservaciones.setText("Observaciones");
        etiquetaObservaciones.setOpaque(true);

        etiquetaStockMax.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaStockMax.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaStockMax.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaStockMax.setText("Stock Max");
        etiquetaStockMax.setOpaque(true);

        txtStockMin.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtStockMin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStockMin.setText("012345.123");
        txtStockMin.setFocusable(false);

        etiquetaStockMin.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaStockMin.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaStockMin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaStockMin.setText("Stock Min");
        etiquetaStockMin.setOpaque(true);

        imagenesRefacciones.setOpaque(false);

        btnSiguienteImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/imagenes/iconos_siguiente.png"))); // NOI18N
        btnSiguienteImagen.setFocusable(false);
        btnSiguienteImagen.setOpaque(false);
        btnSiguienteImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteImagenActionPerformed(evt);
            }
        });

        btnRegresarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/imagenes/iconos_anterios.png"))); // NOI18N
        btnRegresarImagen.setFocusable(false);
        btnRegresarImagen.setOpaque(false);
        btnRegresarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarImagenActionPerformed(evt);
            }
        });

        etiquetaNombreImagen.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaNombreImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaNombreImagen.setText("Stock Max");
        etiquetaNombreImagen.setOpaque(true);

        javax.swing.GroupLayout imagenesRefaccionesLayout = new javax.swing.GroupLayout(imagenesRefacciones);
        imagenesRefacciones.setLayout(imagenesRefaccionesLayout);
        imagenesRefaccionesLayout.setHorizontalGroup(
            imagenesRefaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenesRefaccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSiguienteImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaNombreImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addContainerGap())
        );
        imagenesRefaccionesLayout.setVerticalGroup(
            imagenesRefaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagenesRefaccionesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(imagenesRefaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSiguienteImagen)
                    .addComponent(btnRegresarImagen)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagenesRefaccionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etiquetaNombreImagen)
                .addContainerGap())
        );

        txtStockMax.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtStockMax.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStockMax.setText("012345.123");
        txtStockMax.setFocusable(false);

        txtExistencia.setFont(new java.awt.Font("Calibri", 0, 40)); // NOI18N
        txtExistencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtExistencia.setText("12349.1");
        txtExistencia.setFocusable(false);

        txtNombreDeLaRefaccion.setEditable(false);
        txtNombreDeLaRefaccion.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        txtNombreDeLaRefaccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreDeLaRefaccion.setFocusable(false);
        txtNombreDeLaRefaccion.setPreferredSize(new java.awt.Dimension(40, 337));

        etiquetaExistencia.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaExistencia.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaExistencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaExistencia.setText("Existencia Total");
        etiquetaExistencia.setOpaque(true);

        txtCodigoInterno.setEditable(false);
        txtCodigoInterno.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtCodigoInterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigoInterno.setFocusable(false);

        etiquetaCodigoInterno.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaCodigoInterno.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaCodigoInterno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaCodigoInterno.setText("Código interno");
        etiquetaCodigoInterno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        etiquetaCodigoInterno.setOpaque(true);

        txtCodigoProveedor.setEditable(false);
        txtCodigoProveedor.setBackground(new java.awt.Color(102, 102, 102));
        txtCodigoProveedor.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtCodigoProveedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigoProveedor.setFocusable(false);

        etiquetaCodigoDelProveedor.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaCodigoDelProveedor.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaCodigoDelProveedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaCodigoDelProveedor.setText("Código proveedor");
        etiquetaCodigoDelProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        etiquetaCodigoDelProveedor.setOpaque(true);

        txtUnidad.setEditable(false);
        txtUnidad.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtUnidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtUnidad.setText("METROS");
        txtUnidad.setFocusable(false);

        jLabel1.setBackground(new java.awt.Color(98, 15, 89));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_titulo_salida de lote.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/imagenes/iconos_buscar.png"))); // NOI18N

        etiquetaPedidoEnEspera.setBackground(new java.awt.Color(255, 255, 0));
        etiquetaPedidoEnEspera.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        etiquetaPedidoEnEspera.setForeground(new java.awt.Color(0, 0, 0));
        etiquetaPedidoEnEspera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaPedidoEnEspera.setText("Pedido en espera");
        etiquetaPedidoEnEspera.setToolTipText("");
        etiquetaPedidoEnEspera.setOpaque(true);

        txtObservaciones.setColumns(20);
        txtObservaciones.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtObservaciones.setLineWrap(true);
        txtObservaciones.setRows(1);
        txtObservaciones.setFocusCycleRoot(true);
        txtObservaciones.setFocusTraversalPolicyProvider(true);
        jScrollPane1.setViewportView(txtObservaciones);

        etiquetaFechaDeLote.setBackground(new java.awt.Color(30, 30, 30));
        etiquetaFechaDeLote.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        etiquetaFechaDeLote.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaFechaDeLote.setText("Fecha de lote");
        etiquetaFechaDeLote.setToolTipText("");
        etiquetaFechaDeLote.setOpaque(true);

        txtFechaDeLote.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        txtFechaDeLote.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaDeLote.setText("22/12/17");
        txtFechaDeLote.setAutoscrolls(false);
        txtFechaDeLote.setMaximumSize(new java.awt.Dimension(140, 30));
        txtFechaDeLote.setMinimumSize(new java.awt.Dimension(140, 30));

        btnGuardar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/imagenes/iconos_palomita.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        etiquetaCantidadQueEntra.setBackground(new java.awt.Color(30, 30, 30));
        etiquetaCantidadQueEntra.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        etiquetaCantidadQueEntra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaCantidadQueEntra.setText("Cantidad que sale");
        etiquetaCantidadQueEntra.setToolTipText("");
        etiquetaCantidadQueEntra.setOpaque(true);

        txtCantidadQueSale.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        txtCantidadQueSale.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadQueSale.setText("21365.156");
        txtCantidadQueSale.setAutoscrolls(false);
        txtCantidadQueSale.setMaximumSize(new java.awt.Dimension(140, 30));
        txtCantidadQueSale.setMinimumSize(new java.awt.Dimension(140, 30));

        comboEmpleadoQueReciveLote.setEditable(true);
        comboEmpleadoQueReciveLote.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        comboEmpleadoQueReciveLote.setMaximumSize(new java.awt.Dimension(436, 32767));
        comboEmpleadoQueReciveLote.setPreferredSize(new java.awt.Dimension(436, 24));

        etiquetaNombreDeLaRefaccion.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaNombreDeLaRefaccion.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaNombreDeLaRefaccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaNombreDeLaRefaccion.setText("Nombre de la refacción");
        etiquetaNombreDeLaRefaccion.setOpaque(true);

        etiquetaEmpleadoQueReciveElLote.setBackground(new java.awt.Color(30, 30, 30));
        etiquetaEmpleadoQueReciveElLote.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        etiquetaEmpleadoQueReciveElLote.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaEmpleadoQueReciveElLote.setText("Empleado que recive el lote.");
        etiquetaEmpleadoQueReciveElLote.setOpaque(true);

        btnSalir1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/imagenes/iconos_tache.png"))); // NOI18N
        btnSalir1.setText("Cancelar");
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });

        jScrollPane2.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N

        listaResultados.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        listaResultados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaResultados.setOpaque(false);
        listaResultados.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(listaResultados);

        txtBusqueda.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });

        comboLotesDisponibles.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        comboLotesDisponibles.setMaximumSize(new java.awt.Dimension(436, 32767));
        comboLotesDisponibles.setPreferredSize(new java.awt.Dimension(436, 24));
        comboLotesDisponibles.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboLotesDisponiblesItemStateChanged(evt);
            }
        });
        comboLotesDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboLotesDisponiblesActionPerformed(evt);
            }
        });

        etiquetaNombreDeLaRefaccion1.setBackground(new java.awt.Color(31, 31, 31));
        etiquetaNombreDeLaRefaccion1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaNombreDeLaRefaccion1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaNombreDeLaRefaccion1.setText("Lotes disponibles");
        etiquetaNombreDeLaRefaccion1.setOpaque(true);

        etiquetaStockMin1.setBackground(new java.awt.Color(31, 31, 31));
        etiquetaStockMin1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaStockMin1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaStockMin1.setText("Existencia lote");
        etiquetaStockMin1.setOpaque(true);

        txtExistenciaLote.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtExistenciaLote.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtExistenciaLote.setText("012345.123");
        txtExistenciaLote.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(307, 307, 307)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(335, 335, 335)
                                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaNombreDeLaRefaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreDeLaRefaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaCodigoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(etiquetaCodigoDelProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imagenesRefacciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(etiquetaStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(etiquetaStockMax, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txtStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txtStockMax, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(etiquetaPedidoEnEspera, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(etiquetaEmpleadoQueReciveElLote, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboEmpleadoQueReciveLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(btnSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaNombreDeLaRefaccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(etiquetaStockMin1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboLotesDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txtExistenciaLote, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaFechaDeLote, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(etiquetaCantidadQueEntra, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFechaDeLote, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(txtCantidadQueSale, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(etiquetaNombreDeLaRefaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(txtNombreDeLaRefaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(etiquetaCodigoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(etiquetaCodigoDelProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagenesRefacciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaStockMax, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStockMax, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaPedidoEnEspera, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaFechaDeLote, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaCantidadQueEntra, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaDeLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidadQueSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaNombreDeLaRefaccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaStockMin1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboLotesDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtExistenciaLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(etiquetaEmpleadoQueReciveElLote, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(comboEmpleadoQueReciveLote, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(etiquetaObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalir1)
                            .addComponent(btnGuardar)))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteImagenActionPerformed
        _imagenesRefaccion.imagenSiguiente();
    }//GEN-LAST:event_btnSiguienteImagenActionPerformed

    private void btnRegresarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarImagenActionPerformed
        _imagenesRefaccion.imagenAnterior();
    }//GEN-LAST:event_btnRegresarImagenActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        SalidaLoteIT it = new SalidaLoteIT();
        SalidaLoteVo vo = new SalidaLoteVo();
        //SE USA MAS ADELANTE. 
        List<EntradaLoteVo>voActualMultiple = new ArrayList<>();
        
        boolean todoValido = true;
        float cantidad;
        if (_txtCantidadQueSale.isEmpty()) {
            cantidad = -1;
        }else{
            cantidad = Float.parseFloat(_txtCantidadQueSale.getText());
        }
        vo.setCantidad(cantidad);
        
        vo.setFechaSalidaLote(FechaYHora.cambiarFormatoDeFecha(FechaYHora.FECHA_AAAA_MM_DD, _txtFechaDeLote.getText()));
        EmpleadoVo evo =(EmpleadoVo) _comboEmpleadoQueReciveLote.getSelectedItem_idRetorno();
        vo.setIdEmpleado(evo.getId());
        vo.setIdRefaccion(idRefaccionActual);
        vo.setObservaciones(_txtObservaciones.getText());
        
        List<Validacion> validaciones = this.getCoordinador().salidaLoteValidarCampos(vo);
        for (Validacion validacione : validaciones) {
            
            if (validacione.getNombreDeCampo().equals(it.getCantidadPDC().getNombre())) {
                if (!validacione.isValido()) {
                    _txtCantidadQueSale.setError(validacione.getMensajeDeError());
                        
                }else{
                    _txtCantidadQueSale.setErrorQuitar();
                }
            }
            
            if (validacione.getNombreDeCampo().equals(it.getFechaSalidaLotePDC().getNombre())) {
                if (!validacione.isValido()) {
                    _txtFechaDeLote.setError(validacione.getMensajeDeError());
                }else{
                    _txtFechaDeLote.setErrorQuitar();
                }
            }
            
            if (validacione.getNombreDeCampo().equals(it.getIdEmpleadoPDC().getNombre())) {
                if (!validacione.isValido()) {
                    _comboEmpleadoQueReciveLote.setError(validacione.getMensajeDeError());
                } else {
                    _comboEmpleadoQueReciveLote.setErrorQuitar();
                }
            }
            
            if (!validacione.isValido()) {
                todoValido = false;
            }
        }
        
        if (todoValido) {
            float existenciaRefaccion = this.getCoordinador().entradaLoteExistencia(vo.getIdRefaccion());
            if (existenciaRefaccion>=vo.getCantidad()) {
                todoValido = true;
                _txtCantidadQueSale.setErrorQuitar();
            }else{
                _txtCantidadQueSale.setError(
                        "Esta refacción no tiene suficiente existencia.");
                todoValido = false;
            }
        }
        
        //OPCIONES PARA LA SIGUIENTES COMPROBACIONES. 
        Object[] opciones = new Object[3];
                    opciones[0]="No hacer nada";
                    opciones[1]="Muestrame los lotes para seleccionar";
                    opciones[2]="Dejar el lote que tengo seleccionado";
        if (todoValido) {
            //EN ESTA PARTE VALIDAMOS LOS LOTES. 
            // QUE SEA EL MÁS ANTIGUO
            // QUE TENGA SUFICIENTE EL PRIMERO
            // CUANTOS SE VAN A OCUPAR
            // SIEMPRE SE DEBE DESCONTAR DESDE EL MÁS ANTIGUO AL PRIMERO. PERO
            // TAMBIEN HAY QUE DAR LA OPCIÓN A ESCOGER LOS LOTES. 
            
            //OBTENEMOS LOS LOTES DE LA REFACCIÓN
            List<Object> list = new ArrayList<>(_comboLotesDisponibles.getRelacionDatoObjeto().values());
            
            //HACEMOS UN CAST OBLIGADO A LA LISTA PARA CAMBIAR SU TIPO A ENTRADA LOTE. 
            @SuppressWarnings("unchecked")
            List<EntradaLoteVo> lista = (List<EntradaLoteVo>)(List<?>)list;
          
            //ORDENAMOS LA LISTA POR FECHA DE RECEPCIÓN, DE LA MÁS ANTIGUA A 
            // LA MÁS RECIENTE. 
            lista.sort(Comparator.comparing(EntradaLoteVo::getFechaRecepcionLote).thenComparingInt(EntradaLoteVo::getId));
            EntradaLoteVo voSeleccionado =(EntradaLoteVo) _comboLotesDisponibles.getSelectedItem_idRetorno();
            
            //INVOCAMOS LAS OPERACIONES DE VALIDACIÓN SOBRE LOTE. 
            Validacion valLoteMasAntiguo = this.getCoordinador()
                    .salidaLoteValidarLotes(lista, voSeleccionado);
            
            //COMPROMBAMOS EL LOTE MÁS ANTIGUO. 
            if (!valLoteMasAntiguo.isValido()) {
                int r = JOptionPane.showConfirmDialog(
                        this,
                        valLoteMasAntiguo.getMensajeDeError()+"\n\n"
                        +"Lote seleccionado: "+voSeleccionado.getFechaRecepcionLote() +" Existencia:"+voSeleccionado.getCantidad()+"\n"
                        +"Lote mas antiguo : "+lista.get(0).getFechaRecepcionLote()   +" Existencia:"+lista.get(0).getCantidad()+"\n\n"
                        + "¿Quieres seleccionar el lote más antiguo?",
                        "Hay disponible un lote más antiguo.",
                        JOptionPane.YES_NO_OPTION);
                if (r==JOptionPane.YES_OPTION) {
                    voActualMultiple.add(lista.get(0));
                    JOptionPane.showMessageDialog(null, "Has seleccionado el más antiguo");
                    todoValido = true;
                }else{
                    //SI PONE QUE NO ENTONCES HAY QUE OFRECER OPCIONES. 
                   
                    int r2 = JOptionPane.showOptionDialog(
                            this, 
                            "¿Que deseas hacer?", 
                            "Opciones posibles",
                            JOptionPane.YES_NO_CANCEL_OPTION , 
                            JOptionPane.QUESTION_MESSAGE,
                            null, opciones, opciones[2]);

                    switch(r2){
                        case 2:
                            // EL USUARIO QUIERE DEJAR EL LOTE SELECCIONADO. 
                            todoValido = true;
                            voActualMultiple.add(voSeleccionado);
                            break;
                        case 1:
                            //EL USUARIO QUIERE QUE SE LE MUESTREN LOS LOTES.
                            voActualMultiple = mostrarLotesParaSeleccionarse(lista, voActualMultiple);
                            todoValido = true;
                            break;
                        case 0:
                        default:
                            //NO HACER NADA. SE CANCELA TODO.
                            todoValido = false;
                            JOptionPane.showMessageDialog(null, "no hacer nada"+r2);
                            break;

                    }
                }
            }else{
                //EL LOTE QUE SE SELECCIONO ES EL MAS ANTIGUO, ENTONCES SE ASIGNA
                // A voActualMultiple PARA SEGUIR CON LAS COMPROBACIONES. 
                voActualMultiple.add(voSeleccionado);
                todoValido = true;
            }
            
            //REVISAMOS QUE LA EXISTENCIA TOTAL DE LOS LOTES SELECCIONADOS 
            // SEA MAYOR O IGUAL A LA CANTIDAD QUE SE QUEIRE SALIR. 
            if(todoValido){
                boolean salirDeCiclo = false;
                
                //REPETIMOS ESTA SECCION HASTA QUE SE CANCELE O SE ESCOJAN SUFICIENTES
                // LOTES PARA QUE LA CANTIDAD SEA SURTIDA. 
                while(!salirDeCiclo){
                    float totalSumaDeLotes = 0f;

                    //REALIZAMOS LA SUMA. 
                    for (EntradaLoteVo voSum : voActualMultiple) {
                         totalSumaDeLotes+=voSum.getCantidad();
                    }

                    //LA SUMA DE LOTES TIENE QUE SER MAYOR QUE LA CANTIDAD QUE SE QUIERE
                    // INGRESAR, DE LO CONTRARIO HAY QUE SOLICITAR DE NUEVO LAS OPCIONES
                    // PARA AGREGAR LOTES. 
                    if (totalSumaDeLotes<vo.getCantidad()) {
                        
                        String pLotes = voActualMultiple.size()>1? "Los lotes": "El lote";
                        String pTienen = voActualMultiple.size()>1? "tienen": "tiene";

                        Object op[] = new Object[2];
                        op[0] = "No hacer nada";
                        op[1] = "Muestrame los lotes";

                        int r3 = JOptionPane
                                .showOptionDialog(
                                        this, 
                                        pLotes + "que seleccionaste no "
                                          +pTienen+" suficiente existencia.\n"
                                          + "¿Que deseas hacer?"   , 
                                        "Opciones posibles",
                                        JOptionPane.YES_NO_CANCEL_OPTION , 
                                        JOptionPane.QUESTION_MESSAGE,
                                        null, op, op[1]);
                        switch(r3){
                            case 1:
                            //EL USUARIO QUIERE QUE SE LE MUESTREN LOS LOTES.
                            voActualMultiple = mostrarLotesParaSeleccionarse(lista, voActualMultiple);
                                                        break;
                        case 0:
                        default:
                            //NO HACER NADA. SE CANCELA TODO.
                            todoValido = false;
                            salirDeCiclo = true;
                            break;    
                        }
                    }else{
                        //EL totalSumaDeLotes ES MAYOR QUE LA CANTIDAD DE SALIDA
                        // POR TANTO TERMINAMOS EL BUCLE.
                        salirDeCiclo = true;
                        todoValido = true;
//                        JOptionPane.showMessageDialog(null, "la suma esta bien!");
                    }
                }
            }
            
            if (todoValido) {
                //SI TODO FUE VALIDO AHORA REVISAMOS CUANTO SOBRA DE LA SUMA TOTAL
                // DE LOS LOTES, DE MANERA QUE SI SOBRA UN LOTE INTACTO ENTONCES
                // DAMOS LA OPCION DE ESCOGER DE QUE LOTES DESCONTAR PRIMERO. 
                // SI NO, HAY QUE DECIR QUE POR DEFECTO SE DESCONTARA PRIMERO DEL MAS
                // ANTIGUO Y LUEGO DAR LA OPCIÓN DE ESCOGER SI SON MAS DE DOS LOTES.
                float cantidadSalidaTemp = vo.getCantidad();
                boolean hayLotesIntactos = false;
                List<ComparacionLotes> listComparacionLotes = new ArrayList<>();
                //
                for (EntradaLoteVo voActMult : voActualMultiple) {
                    ComparacionLotes cl = new ComparacionLotes(voActMult);
                    cantidadSalidaTemp = cl.restarDelTotal(cantidadSalidaTemp);
                    JOptionPane.showMessageDialog(null, cantidadSalidaTemp);
                    if (!cl.isModificado()) {
                        hayLotesIntactos = true;
                    }
                    listComparacionLotes.add(cl);
                }
                JOptionPane.showMessageDialog(null, listComparacionLotes.toString());
                
                //1
                if (hayLotesIntactos) {
                    
                    Object op[] = new Object[3];
                    op[0] = "No hacer nada.";
                    op[1] = "Definir la cantidad a descontar de cada lote.";
                    op[2] = "Continuar. ";

                    int r3 = JOptionPane
                            .showOptionDialog(
                            this, 
                            "Hay lotes de los que no se descontara nada. ¿Que deseas hacer?" , 
                            "Opciones posibles",
                            JOptionPane.YES_NO_CANCEL_OPTION , 
                            JOptionPane.QUESTION_MESSAGE,
                            null, op, op[2]);
                    
                    switch(r3){
                        case 2:
                            //CONTINUAR. CONSOLIDAMOS LAS OPERACIONES QUE HABIAMOS
                            //REALIZADO DENTRO DE LA CLASE COMPARACION LOTES
                            // Y LA DEVOLVEMOS AL FLUJO DE voActualMultiple
                            voActualMultiple.clear();
                            for (ComparacionLotes cl : listComparacionLotes) {
                                cl.consolidar();
                                voActualMultiple.add(voSeleccionado);
                            }
                            voActualMultiple.sort(
                                Comparator.comparing(EntradaLoteVo::getFechaRecepcionLote)
                                        .thenComparing(EntradaLoteVo::getId));
                            todoValido = true;
                            JOptionPane.showMessageDialog(null, "consolida!!\n"+voActualMultiple.toString());
                            break;
                        case 1:
                            coordinador.salidaLoteAbrirDialogoCantidadADescontarDeLote(listComparacionLotes, vo.getCantidad());
                            todoValido = true;
                            
                            break;
                        case 0:
                        default:
                            todoValido = false;
                            break;
                        
                    
                    }
                    
                  
                    
                    
                }else{
                    JOptionPane.showMessageDialog(null, "no hay lotes intactos");
                }
                
                
                
            
            
            
            
            
            
            
            
            //2-NO SOBRAN LOTES COMPLETOS. MOSTRAR ACCION POR DEFECTO.
            //2.1- SE ACEPTA QUE SE DESCUENTE DESDE EL MÁS ANTIGUO. 
            //2.2- NO SE ACEPTA QUE SE DESCUENTE DESDE EL MAS ANTIGUO(MOSTRAR LOTES PARA ORDENAR)
            //2.3- NO HACER NADA.(TODO VALIDO FALSE).
            
            
                        
                
                
            }
            
        }
            
           
            
            
        
        
        
//        //HAY UN LOTE MENOR QUE EL SELECCIONADO. ESTE NO MUESTRA MENSAJE
//        // PARA DESPUES COMPROBAR SI EL LOTE TIENE SUFICIENTE EXISTENCIA.
//        if (todoValido) {
//            JOptionPane.showMessageDialog(null, idRefaccionActual);
//            EntradaLoteVo voLoteMasAtiguo = this.getCoordinador().entradaLoteLoteMasAntiguo(idRefaccionActual);
//            EntradaLoteVo voLoteActual = (EntradaLoteVo)this._comboLotesDisponibles.getSelectedItem_idRetorno();
//            
//            JOptionPane.showMessageDialog(null, "comparativa:\n\n"
//                    + "\nvoLoteMásAntiguo: "+voLoteMasAtiguo.getId()
//                    + "\n                  "+voLoteMasAtiguo.getFechaRecepcionLote()
//                    + "\n                  "+voLoteMasAtiguo.getCantidad()
//                    + "\n\nvoLoteActual  : "+voLoteActual.getId()
//                    + "\n                  "+voLoteActual.getFechaRecepcionLote()
//                    + "\n                  "+voLoteActual.getCantidad()
//                    + "");
//            
//            
//                        
//           
//        }
//        
//        
//        
//        
//        
//        
        //QUITAR ESTA LINEA°!!!!!!!!!!!!!!!!!!!!!!!!
        todoValido = false;
        //QUITAR ESTA LINEA°!!!!!!!!!!!!!!!!!!!!!!!!
        if (todoValido) {
            //GUARDAMOS EL LOTE NUEVO.
            if(this.getCoordinador().salidaLoteGuadar(vo)){
//                this.getCoordinador().entradaLoteActualizarExistencia();
                limpiar();
                JOptionPane.showMessageDialog(this,
                        "Se registro la salida correctamente.");
                
            }else{
                JOptionPane.showMessageDialog(
                        this,
                        "Algo salio mal y no se registro la salida de lote.",
                        "No se pudo registrar la salida.",
                        JOptionPane.ERROR_MESSAGE);

            }
        }
    }
    
    private List<EntradaLoteVo> mostrarLotesParaSeleccionarse(List<EntradaLoteVo> lista, List<EntradaLoteVo> listaSeleccionActual){
        coordinador.salidaLoteAbrirDialogoSeleccionarRefaccion(lista, listaSeleccionActual);
        return voLotesSeleccionadosPorElUsuario;
    }
    

    
    private void autocompletadoDeFecha(){
       _txtFechaDeLote.setText(FechaYHora.autoCompletarFecha(_txtFechaDeLote.getText(), FechaYHora.FECHA_DD_MM_AA));
    
    }
    
    
    /**
     * Ejecuta la busqueda que se vaya digintando en el recuadro de busqueda. 
     * Si el cuadro de texto esta vacio limpia los resultados y todos los elementos.
     */
    private void busqueda(){
        if (!_txtBusqueda.isEmpty()) {
            //SI EL CUADRO NO ESTA VACIO CARGAMOS LAS REFACCIONES.
            cargarRefaccionesEnLista(_txtBusqueda.getText());
        }else{
            _listaResultados.limpiar();
            limpiar();
        }
    }
    
    public void cargarComboEmpleados(){
        cargarComboEmpleados("");
    }
    public void cargarComboEmpleados(Object item){
        List<EmpleadoVo> listVo = new ArrayList<>();
        
        listVo = this.getCoordinador().empleadoConsultarTodo();
        HashMap<String, Object> mapa = new HashMap<>();
        
        EmpleadoIT eit = new EmpleadoIT();
        
        
        for (EmpleadoVo vo : listVo) {
            mapa.put(vo.getNombre(), vo);
            
        }
        
        _comboEmpleadoQueReciveLote.cargarCombo(mapa);
        
        if (_comboEmpleadoQueReciveLote.contieneElItemEscrito(item+"")) {
            _comboEmpleadoQueReciveLote.setSelectedItem(item);
        }
        
        
    }
    
    private void guardarEmpleado(){
        String elementoEscrito = this._comboEmpleadoQueReciveLote.getText();
        if (this._comboEmpleadoQueReciveLote.contieneElItemEscrito()) {
            this._comboEmpleadoQueReciveLote.setSelectedItem(elementoEscrito);
            
        }else{
            this._comboEmpleadoQueReciveLote.setErrorQuitar();
            if (!elementoEscrito.equals("")) {
                if (this._comboEmpleadoQueReciveLote.contieneElItemEscrito(elementoEscrito)) {
                    this._comboEmpleadoQueReciveLote.setSelectedItem(elementoEscrito);
                }else{
                    int respuesta = JOptionPane.showConfirmDialog(this,
                            "¿Estas segúro que quieres registrar \n "
                           + " al nuevo empleado \" "+this._comboEmpleadoQueReciveLote.getText()+"\"?", 
                            "Guardar nuevo empleado.", JOptionPane.YES_NO_OPTION);
                    if (respuesta==JOptionPane.YES_OPTION) {
                        this.getCoordinador().empleadoAbrirDialogoAgregar(elementoEscrito);
                        this.cargarComboEmpleados();
                    }else{
                        this._comboEmpleadoQueReciveLote.getThisComboBox().setSelectedIndex(0);
                    }
                }
            }
        }
    }
    
    
    /**
     * Carga la lista de refacciones que coinciden con el texto introducido 
     * el cuadro de texto de busqueda. 
     */
    private void cargarRefaccionesEnLista(String busqueda){
        //PRIMERO LIMPIAMOS LA LISTA.
        _listaResultados.limpiar();
        //EL MAPA QUE CONTENDRA LOS DATOS PARA CARGARLOS EN EL JLIST.
        HashMap<String, Object> datos = new HashMap<>();
        //CONSULTAMOS LAS REFACCIONES QUE COINCIDAN CON EL TEXTO INGRESADO. 
        List<RefaccionVo> listaVo = this.coordinador.refaccionConsultarTodoBusqueda(busqueda);
        for (RefaccionVo vo : listaVo) {
            ///CARGAMOS EL MAPA
            datos.put(
                    //LA LISTA FORMATEADA DE DATOS (LLAVE-KEY)
                    formatearEspacios(25, vo.getNombre())+
                    formatearEspacios(15, vo.getCodigoInterno())+
                    formatearEspacios(15, vo.getCodigoProveedor())+
                    formatearEspacios(20, vo.getDescripcion())
                    //EL OBJETO QUE OBTENDREMOS.
                    ,vo);
        }
        //CARGAMOS LA LISTA. 
        _listaResultados.cargarLista(datos);
    }
    
//    private boolean noSeCargoDesdeEsteDialogo = true;
    
    
    RefaccionVo voMostrandose =null;
    private void seleccionarRefaccionEnter(){
            HashMap<Object, Object> datos = _listaResultados.getRelacionDatoId();
            if (datos.size()>0) {
                voMostrandose = (RefaccionVo) datos.get(_listaResultados.getThis().getModel().getElementAt(0));
            }else{
                voMostrandose = null;
            }
            comprobarLarefaccion(voMostrandose);
    }
    
    /**
     * Carga la los datos de la refacción consultada para mostrarlos en la interfaz.  
     */
    public void comprobarLarefaccion(RefaccionVo vo){
        //SI EL CUADRO DE BUSQUEDA NO ESTA VACIO CONTINUAMOS. 
        if (_txtBusqueda.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No has escrito nada en el cuadro de busqueda.");
        } else {
            //HAY UNA REFACCION CARGADA
            if(voMostrandose!=null){
                float existencia = this.getCoordinador().entradaLoteExistencia(vo.getId());
                //CUANDO HAY EXISTENCIA MOSTRAMOS LA REFACCIÓN. 
                if (existencia!=0f) {
                    mostrarRefaccion(vo, existencia);
                }else{
                //SI NO HAY EXISTENCIA DAMOS LA OPCIÓN DE ABRIR EL DIALOGO REGISTRAR
                // NUEVA REFACCIÓN.
                    String mensaje = "La refacción '"+vo.getNombre()+"' tiene 0 existencia."
                                           + "\n¿Quieres registrar una nueva entrada de lote?";
                    int respuesta = JOptionPane.showConfirmDialog(
                            this, 
                            mensaje, 
                            "Esta refacción no tiene existencia.", 
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (respuesta==JOptionPane.YES_OPTION) {
                        limpiar();
                        this.dispose();
                        this.getCoordinador().entradaLoteAbrirDialogoConRetornoAPanelSalidaLote(vo);
                    }else{
                        limpiar();
                        _listaResultados.limpiar();
                        JOptionPane.showMessageDialog(this,
                                "No se puede registrar una salida si la refacción no tiene existencia."
                                ,"No se puede registra salida." ,JOptionPane.ERROR_MESSAGE);
                    }
                }
            }else{

                JOptionPane.showMessageDialog(this, "No hubo coincidencias con tu busqueda:"+_listaResultados.getThis().getModel().getSize());
                deshabilitarCamposParaRellenar(true);
                limpiar();
            }
        }
    }
    
    public void mostrarRefaccion(RefaccionVo vo, float existencia){
        deshabilitarCamposParaRellenar(false);
        
        
        _txtNombreDeLaRefaccion.setText(vo.getNombre());
        _txtCodigoInterno.setText(vo.getCodigoInterno());
        _txtCodigoProveedor.setText(vo.getCodigoProveedor());
        _txtUnidad.setText(vo.getUnidad()+"");
        _txtStockMax.setText(vo.getStockMaximo()+"");
        _txtStockMin.setText(vo.getStockMinimo()+"");
        idRefaccionActual = vo.getId();
        
        _txtFechaDeLote.setFocus();
        _txtFechaDeLote.setText(FechaYHora.Actual.getDdmmaa("/"));
        _txtFechaDeLote.getThis().setSelectionStart(0);
        _txtFechaDeLote.getThis().setSelectionEnd(_txtFechaDeLote.getText().length());
        
        //CARGAMOS LAS IMAGENES. 
        cargarImagenes(vo.getId());
        
        cargarLotesDeRefaccion(vo.getId());
        _txtExistencia.setText(existencia+"");
        colorearMinYMax(existencia, vo);

        
        _txtBusqueda.setText("");
        _listaResultados.limpiar();
    }
    
//    public void mostrarRefaccionParaEntrada(RefaccionVo vo){
//        _txtNombreDeLaRefaccion.setText(vo.getNombre());
//        _txtCodigoInterno.setText(vo.getCodigoInterno());
//        _txtCodigoProveedor.setText(vo.getCodigoProveedor());
//        _txtUnidad.setText(vo.getUnidad()+"");
//        _txtStockMax.setText(vo.getStockMaximo()+"");
//        _txtStockMin.setText(vo.getStockMinimo()+"");
//        idRefaccionActual = vo.getId();
//        
//        _txtFechaDeLote.setFocus();
//        _txtFechaDeLote.setText(FechaYHora.Actual.getDdmmaa("/"));
//        _txtFechaDeLote.getThis().setSelectionStart(0);
//        _txtFechaDeLote.getThis().setSelectionEnd(_txtFechaDeLote.getText().length());
//        
//        //CARGAMOS LAS IMAGENES. 
//        cargarImagenes(vo.getId());
//        _txtBusqueda.setText("");
//        _listaResultados.limpiar();
//        
//        
//    }
    
    
//    /**
//     *   Muestra la refacción que tenga existencia. 
//     */
//    public void cargarRefaccionParaSalidaConExistencia(RefaccionVo vo){
//        if (vo!=null) {
////            float existencia = this.getCoordinador().entradaLoteExistencia(vo.getId());
//             
//            if (existencia!=0f) {
////                deshabilitarCamposParaRellenar(false);
//                //POR SI HUBO ALGÚN CAMBIO ENTRE TODOS ESTOS MOVIMIENTOS.
//                // COMO MODIFICACIÓN DE LA REFACCIÓN. STOCK MINIMO O MÁXIMO, ETC. 
//                if (noSeCargoDesdeEsteDialogo) {
//                    /**
//                     Esto lo tengo que hacer así por que el lambda me da error
//                     * si modifico el vo de RefaccionVo. Me dice que tiene que
//                     * ser final.
//                     */
//                    reconsultarRefaccionCargadaDesdeOtroLugar(vo);
//                }else{
//                
////                mostrarRefaccionParaEntrada(vo);
////                cargarLotesDeRefaccion(vo.getId());
////                _txtExistencia.setText(existencia+"");
////                colorearMinYMax(existencia, vo);
//                }
//            }else{
//                String mensaje = "La refacción '"+vo.getNombre()+"' tiene 0 existencia."
//                        + "\n¿Quieres registrar una nueva entrada de lote?";
//                int respuesta = JOptionPane.showConfirmDialog(
//                        this, 
//                        mensaje, 
//                        "Esta refacción no tiene existencia.", 
//                        JOptionPane.YES_NO_OPTION,
//                        JOptionPane.QUESTION_MESSAGE);
//                if (respuesta==JOptionPane.YES_OPTION) {
//                    limpiar();
//                    this.dispose();
//                    this.getCoordinador().entradaLoteAbrirDialogoConRetornoAPanelSalidaLote(vo);
//                }else{
//                    limpiar();
//                    _listaResultados.limpiar();
//                    JOptionPane.showMessageDialog(this,
//                            "No se puede registrar una salida si la refacción no tiene existencia."
//                            ,"No se puede registra salida." ,JOptionPane.ERROR_MESSAGE);
//                }
//            }    
//        }
//    }
//    
//    private void reconsultarRefaccionCargadaDesdeOtroLugar(RefaccionVo vo){
//        noSeCargoDesdeEsteDialogo = false;
//        vo = this.getCoordinador().refaccionConsultar(vo.getId());
//        cargarRefaccionParaSalidaConExistencia(vo);
//
//    }
    
    private void cargarLotesDeRefaccion(int id){
    
        List<EntradaLoteVo> listaLotes = this.getCoordinador().entradaLoteLotes(id, false);
        HashMap<String, Object> datos = new HashMap<>();
        
        for (EntradaLoteVo vo : listaLotes) {
            datos.put(vo.getNombreParaMostrarLote(), vo);
        }
        _comboLotesDisponibles.cargarCombo(datos);
        if (datos.size()==0) {
            _txtExistenciaLote.setText("");
        }
    }
    
    
    
    private void colorearMinYMax(float existencia, RefaccionVo vo){
        boolean todoBien = true;
        if (existencia>vo.getStockMaximo()) {
            _txtStockMax.setError();
            _txtExistencia.setError();
            todoBien = false;
        }else{
            _txtStockMax.setErrorQuitar();
        }
        
        if (existencia<vo.getStockMinimo()) {
            _txtStockMin.setError();
            _txtExistencia.setError();
            todoBien = false;
        } else {
            _txtStockMax.setErrorQuitar();
            _txtStockMin.setErrorQuitar();
        }
        
        if (todoBien) {
            _txtExistencia.setErrorQuitar();
          
        }
        
    
    }
    public void cargarImagenes(int id){
       
        List<ImagenRefaccionVo> listaImagenesRefaccion = this.getCoordinador().imagenRefaccionConsultar(id);
        _imagenesRefaccion.limpiarComponenteURL();
        for (ImagenRefaccionVo vo : listaImagenesRefaccion) {
            UtilidadesJXViewImage_.TransporteImagenesURL t = new UtilidadesJXViewImage_.TransporteImagenesURL();
            t.setIdImagen(vo.getIdRefaccion());
            t.setNombreImagen(vo.getNombreParaMostrar());
            t.setNombreImagenServidor(vo.getNombreServidor());
            t.setUrl(vo.getUrlImagen());
            _imagenesRefaccion.addIMagenes(t);
        }
        _imagenesRefaccion.cargarPrimeraImagen();
        
    }
    
    private String formatearEspacios(int totalEspacio, String texto){
    
        String espacio = "";
        String cadenaNueva = "";
        if (totalEspacio>texto.length()) {
            int espaciosEnBlanco = totalEspacio-texto.length();
            for (int i = 0; i < espaciosEnBlanco-1; i++) {
                espacio+=" ";
            }
            espacio+=("|");
            cadenaNueva += texto+espacio;
        }else{
            String subTexto = texto.substring(0, totalEspacio-4);
            espacio+="...|";
            cadenaNueva += subTexto+espacio;
            
        }
        return cadenaNueva;
    }
    
    private void limpiar(){
        deshabilitarCamposParaRellenar(true);
        _txtBusqueda.setText("");
        _txtNombreDeLaRefaccion.setText("");
        _txtCodigoInterno.setText("");
        _txtCodigoProveedor.setText("");
        _txtExistencia.setText("");
        _txtStockMax.setText("");
        _txtStockMin.setText("");
        _txtUnidad.setText("");
        _txtFechaDeLote.setText("");
        _txtCantidadQueSale.setText("");
        _txtExistenciaLote.setText("");
        
        _comboLotesDisponibles.limpiar();
        
        _txtStockMax.setErrorQuitar();
        _txtStockMin.setErrorQuitar();
        _txtExistencia.setErrorQuitar();
        
        
        _txtObservaciones.setText("");
        _imagenesRefaccion.limpiarComponenteURL();
        _txtBusqueda.setFocus();
        
//        _listaResultados.limpiar();
        
    }

    private void salir(){
            limpiar();
            dispose();
            
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        limpiar();
        salir();
        
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        salir();
    }//GEN-LAST:event_formWindowClosing

    private void comboLotesDisponiblesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboLotesDisponiblesItemStateChanged
    }//GEN-LAST:event_comboLotesDisponiblesItemStateChanged

    private void comboLotesDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboLotesDisponiblesActionPerformed
        Object a = _comboLotesDisponibles.getSelectedItem_idRetorno();
        if (!a.equals(-1)) {
            EntradaLoteVo vo = (EntradaLoteVo) a;
            _txtExistenciaLote.setText(vo.getCantidad()+"");
            
        }
    }//GEN-LAST:event_comboLotesDisponiblesActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresarImagen;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JButton btnSiguienteImagen;
    private javax.swing.JComboBox<String> comboEmpleadoQueReciveLote;
    private javax.swing.JComboBox<String> comboLotesDisponibles;
    private javax.swing.JLabel etiquetaCantidadQueEntra;
    private javax.swing.JLabel etiquetaCodigoDelProveedor;
    private javax.swing.JLabel etiquetaCodigoInterno;
    private javax.swing.JLabel etiquetaEmpleadoQueReciveElLote;
    private javax.swing.JLabel etiquetaExistencia;
    private javax.swing.JLabel etiquetaFechaDeLote;
    private javax.swing.JLabel etiquetaNombreDeLaRefaccion;
    private javax.swing.JLabel etiquetaNombreDeLaRefaccion1;
    private javax.swing.JLabel etiquetaNombreImagen;
    private javax.swing.JLabel etiquetaObservaciones;
    private javax.swing.JLabel etiquetaPedidoEnEspera;
    private javax.swing.JLabel etiquetaStockMax;
    private javax.swing.JLabel etiquetaStockMin;
    private javax.swing.JLabel etiquetaStockMin1;
    private org.jdesktop.swingx.JXImageView imagenesRefacciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaResultados;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCantidadQueSale;
    private javax.swing.JTextField txtCodigoInterno;
    private javax.swing.JTextField txtCodigoProveedor;
    private javax.swing.JTextField txtExistencia;
    private javax.swing.JTextField txtExistenciaLote;
    private javax.swing.JTextField txtFechaDeLote;
    private javax.swing.JTextField txtNombreDeLaRefaccion;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JTextField txtStockMax;
    private javax.swing.JTextField txtStockMin;
    private javax.swing.JTextField txtUnidad;
    // End of variables declaration//GEN-END:variables

    public void cargarLotesSeleccionados(List<EntradaLoteVo> lista) {
        voLotesSeleccionadosPorElUsuario = lista;
    }
}
