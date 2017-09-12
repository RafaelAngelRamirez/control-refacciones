/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.panels;

import controlador.Coordinador;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.InfoTabla.EmpleadoIT;
import modelo.InfoTabla.RefaccionIT;
import modelo.InfoTabla.SalidaLoteIT;
import modelo.Textos;
import modelo.logica.Validacion;
import modelo.vo.EmpleadoVo;
import modelo.vo.EntradaLoteVo;
import modelo.vo.ImagenRefaccionVo;
import modelo.vo.RefaccionVo;
import modelo.vo.SalidaLoteVo;
import modelo.FechaYHora;
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
    private UtilidadesTxt_ _txtCantidadQueEntra;
    private UtilidadesComboBox_ _comboEmpleadoQueReciveLote;
    private UtilidadesComboBox_ _comboLotesDisponibles;
    private UtilidadesTxtArea_ _txtObservaciones;
    private UtilidadesJXViewImage_ _imagenesRefaccion;
    private UtilidadesTxt_ _txtExistenciaLote;
    private int idRefaccionActual;
    
    

    /**
     * Creates new form DialogoEntrada
     */
    public PanelSalidaDeLote() {
        initComponents();
    }
    
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
        _txtCantidadQueEntra = new UtilidadesTxt_(coordinador);
        _comboEmpleadoQueReciveLote = new UtilidadesComboBox_(coordinador);
        _txtObservaciones = new UtilidadesTxtArea_(coordinador);
        _imagenesRefaccion = new UtilidadesJXViewImage_(coordinador);
        _comboLotesDisponibles = new UtilidadesComboBox_(coordinador);
        _txtExistenciaLote = new UtilidadesTxt_(coordinador);
        //SETEAMOS LOS COMPONENTES DENTRO DE LA UTILIDAD.
        
        _txtBusqueda.setComponente(this.txtBusqueda);
        _listaResultados.setComponente(listaResultados);
        _txtNombreDeLaRefaccion.setComponente(this.txtNombreDeLaRefaccion);
        _txtCodigoInterno.setComponente(this.txtCodigoInterno);
        _txtCodigoProveedor.setComponente(this.txtCodigoProveedor);
        _txtExistencia.setComponente(this.txtExistencia);
        _txtStockMax.setComponente(this.txtStockMax);
        _txtStockMin.setComponente(this.txtStockMin);
        _txtUnidad.setComponente(this.txtUnidad);
        _txtFechaDeLote.setComponente(this.txtFechaDeLote);
        _txtCantidadQueEntra.setComponente(this.txtCantidadQueEntra);
        _comboEmpleadoQueReciveLote.setComponente(this.comboEmpleadoQueReciveLote);
        _txtObservaciones.setComponente(this.txtObservaciones);
        _comboLotesDisponibles.setComponente(comboLotesDisponibles);
        _txtExistenciaLote.setComponente(txtExistenciaLote);
        
        _imagenesRefaccion.setComponente(imagenesRefacciones);
        _imagenesRefaccion.setjLabelContador(etiquetaNombreImagen);
        
        //ASIGNAMOS EL TAMAÑO DE CAMPO
        
        _txtBusqueda.setTamanoDeCampo(300);
        _txtFechaDeLote.setTamanoDeCampo(elit.getFechaSalidaLotePDC().getLongitudDeCaracteres());
        _txtCantidadQueEntra.setTamanoDeCampo(elit.getCantidadPDC().getLongitudDeCaracteres(), elit.getCantidadPDC().getLongitudDeDecimales());
        _txtObservaciones.setTamanoDeCampo(elit.getObservacionesPDC().getLongitudDeCaracteres());
        _comboEmpleadoQueReciveLote.setTamanoDeCampo(eit.getNombrePDC().getLongitudDeCaracteres());
        _txtObservaciones.setTamanoDeCampo(elit.getObservacionesPDC().getLongitudDeCaracteres());
        
        //CAMPOS QUE REQUIEREN TEXTO EN MAYUSCULAS.
        
        _txtObservaciones.setPermitirSoloMayusculas();
        _txtBusqueda.setPermitirSoloMayusculas();
        _comboEmpleadoQueReciveLote.setPermitirSoloMayusculas();
        _txtObservaciones.setPermitirSoloMayusculas();
        _comboLotesDisponibles.setPermitirSoloMayusculas();
        
        //CAMPOS QUE REQUIEREN FECHA. 
        _txtFechaDeLote.setPermitirSoloFecha_ddmmaa();
                
        //CAMPOS NUMÉRICOS
        
        _txtCantidadQueEntra.setPermitirSoloNumeros(elit.getCantidadPDC().getLongitudDeCaracteres(), elit.getCantidadPDC().getLongitudDeDecimales());
        
        //QUITAMOS LOS ESPACIOS SOBRANTES DESPUES DE DEJAR EL CAMPO.
        _txtBusqueda.setEspaciosEnBlanco();
        _txtCantidadQueEntra.setEspaciosEnBlanco();
        _txtObservaciones.setEspaciosEnBlanco();
        _comboEmpleadoQueReciveLote.setEspaciosEnBlanco();
        
        //TRAVEL POLICY
        
//        _txtBusqueda.setNextFocusableComponent(_txtFechaDeLote.getThis());
        _txtFechaDeLote.setNextFocusableComponent(_txtCantidadQueEntra.getThis());
        _txtCantidadQueEntra.setNextFocusableComponent(_comboEmpleadoQueReciveLote.getThis());
        _comboEmpleadoQueReciveLote.setNextFocusableComponent(_txtObservaciones.getThis());
        _txtObservaciones.setNextFocusableComponent(btnGuardar);
        btnGuardar.setNextFocusableComponent(btnSalir1);
        btnSalir1.setNextFocusableComponent(_txtBusqueda.getThis());
        
        //ACCIONES ESPECIALES.
        _comboLotesDisponibles.setEditable(false);
        
        _txtBusqueda.setKeyRelease(()->busqueda(), OperacionesBasicasPorDefinir.TECLA_CUALQUIERA_EXCEPTO_ENTER);
        _txtBusqueda.setKeyRelease(()->cargarRefaccionParaEntrada(), OperacionesBasicasPorDefinir.TECLA_ENTER);
        _txtBusqueda.setKeyPressAction(()->cargarRefaccionParaEntrada(), OperacionesBasicasPorDefinir.TECLA_TABULADOR);
        
        _listaResultados.setValueChange(()->cargarRefaccionParaEntrada());
        
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
    public Coordinador getCoordinador() {
        return coordinador;
    }

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
        
        _txtFechaDeLote.getThis().setEnabled(deshabilitar);
        _txtCantidadQueEntra.getThis().setEnabled(deshabilitar);
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
        txtCantidadQueEntra = new javax.swing.JTextField();
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

        txtCantidadQueEntra.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        txtCantidadQueEntra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadQueEntra.setText("21365.156");
        txtCantidadQueEntra.setAutoscrolls(false);
        txtCantidadQueEntra.setMaximumSize(new java.awt.Dimension(140, 30));
        txtCantidadQueEntra.setMinimumSize(new java.awt.Dimension(140, 30));

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
                                .addComponent(txtCantidadQueEntra, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                            .addComponent(txtCantidadQueEntra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        JOptionPane.showMessageDialog(null, "aqui nooo");
        SalidaLoteIT it = new SalidaLoteIT();
        SalidaLoteVo vo = new SalidaLoteVo();
        boolean todoValido = true;
        float cantidad;
        if (_txtCantidadQueEntra.isEmpty()) {
            cantidad = -1;
        }else{
            cantidad = Float.parseFloat(_txtCantidadQueEntra.getText());
        }
        vo.setCantidad(cantidad);
        JOptionPane.showMessageDialog(null, "aqui nooo");
        
        vo.setFechaSalidaLote(FechaYHora.cambiarFormatoDeFecha(FechaYHora.FECHA_AAAA_MM_DD, _txtFechaDeLote.getText()));
        EmpleadoVo evo =(EmpleadoVo) _comboEmpleadoQueReciveLote.getSelectedItem_idRetorno();
        vo.setIdEmpleado(evo.getId());
        vo.setIdRefaccion(idRefaccionActual);
        vo.setObservaciones(_txtObservaciones.getText());
        JOptionPane.showMessageDialog(null, "aqui nooo");
        
        List<Validacion> validaciones = this.getCoordinador().salidaLoteValidarCampos(vo);
        for (Validacion validacione : validaciones) {
            
            if (validacione.getNombreDeCampo().equals(it.getCantidadPDC().getNombre())) {
                if (!validacione.isValido()) {
                    _txtCantidadQueEntra.setError(validacione.getMensajeDeError());
                        
                }else{
                    _txtCantidadQueEntra.setErrorQuitar();
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
        JOptionPane.showMessageDialog(null, "aqui nooo");
        if (todoValido) {
            
            //COMPROBACIONES SOBRE LOS LOTES
            HashMap<String, Object> lotesDisponibles = _comboLotesDisponibles.getRelacionDatoObjeto();
            EntradaLoteVo elvo = null;
            //LA REFACCIÓN POR LO MENOS TIENE UN LOTE
            if (lotesDisponibles.size()>0) {
                todoValido = true;
            }else{
                JOptionPane.showMessageDialog(this, 
                        "Esta refacción no tiene existencias.", 
                        "Sin existencia.", JOptionPane.ERROR_MESSAGE);
                todoValido = false;
            }

            float existenciaRefaccion = this.getCoordinador().entradaLoteExistencia(vo.getIdRefaccion());
            if (existenciaRefaccion>=vo.getCantidad()&& todoValido) {
                todoValido = true;
            }else{
                _txtCantidadQueEntra.setError(
                        "Esta refacción no tiene suficiente existencia.");
                todoValido = false;
            }
        }
        
        //HAY UN LOTE MENOR QUE EL SELECCIONADO. ESTE NO MUESTRA MENSAJE
        // PARA DESPUES COMPROBAR SI EL LOTE TIENE SUFICIENTE EXISTENCIA.
        if (todoValido) {
            JOptionPane.showMessageDialog(null, idRefaccionActual);
            EntradaLoteVo voLoteMasAtiguo = this.getCoordinador().entradaLoteLoteMasAntiguo(idRefaccionActual);
            EntradaLoteVo voLoteActual = (EntradaLoteVo)this._comboLotesDisponibles.getSelectedItem_idRetorno();
            
            JOptionPane.showMessageDialog(null, "comparativa:\n\n"
                    + "\nvoLoteMásAntiguo: "+voLoteMasAtiguo.getId()
                    + "\n                  "+voLoteMasAtiguo.getFechaRecepcionLote()
                    + "\n                  "+voLoteMasAtiguo.getCantidad()
                    + "\n\nvoLoteActual  : "+voLoteActual.getId()
                    + "\n                  "+voLoteActual.getFechaRecepcionLote()
                    + "\n                  "+voLoteActual.getCantidad()
                    + "");
            
           
        }
        
        
        
        
        
        
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
    
//    private EntradaLoteVo comprobacionesSobreLote(Object a, float existencia){
//
//        
//        EntradaLoteVo elvo = (EntradaLoteVo) a;
//        if (this.getCoordinador().entradaloteEsElLoteMasConExistencia(elvo)) {
//
//        }else{
//            EntradaLoteVo voLoteMasChicoAntiguo = 
//                    this.getCoordinador().entradaLoteMasAtiguoConExistencia();
//            String mensaje = "Esta refacción tiene un lote más antiguo que el"
//                    + "seleccionado. \n"
//                    + "Este es el lote seleccionado: "+ elvo.getFechaRecepcionLote() + "- Cantidad:" +elvo.getCantidad()+"\n"
//                    + " Este es el lote más antiguo: "+ voLoteMasChicoAntiguo.getFechaRecepcionLote() + "- Cantidad:" +voLoteMasChicoAntiguo.getCantidad()
//                    + "\n\n¿Deseas descontar la salida de lote actual a '"+voLoteMasChicoAntiguo.getFechaRecepcionLote() +"' que es más antiguo?";
//            int r = JOptionPane.showConfirmDialog(
//                    this, 
//                    mensaje, 
//                    "Hay un lote más antiguo.", 
//                    JOptionPane.WARNING_MESSAGE);
//            if (r=JOptionPane.YES_OPTION) {
//
//            }
//        }
//    } 
    
    private void autocompletadoDeFecha(){
       _txtFechaDeLote.setText(FechaYHora.autoCompletarFecha(_txtFechaDeLote.getText(), FechaYHora.FECHA_DD_MM_AA));
    
    }
    private void busqueda(){
        if (!_txtBusqueda.isEmpty()) {
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
    
    private void cargarRefaccionesEnLista(String busqueda){
        _listaResultados.limpiar();
        HashMap<String, Object> datos = new HashMap<>();
        
        List<RefaccionVo> listaVo = this.coordinador.refaccionConsultarTodoBusqueda(busqueda);
        for (RefaccionVo vo : listaVo) {
            
            datos.put(
                    formatearEspacios(25, vo.getNombre())+
                    formatearEspacios(15, vo.getCodigoInterno())+
                    formatearEspacios(15, vo.getCodigoProveedor())+
                    formatearEspacios(20, vo.getDescripcion()),vo);
        }
               
        _listaResultados.cargarLista(datos);
        
        
    }
    
    private boolean noSeCargoDesdeEsteDialogo = true;
    public void cargarRefaccionParaEntrada(){
        RefaccionVo vo =null;
        HashMap<Object, Object> datos = _listaResultados.getRelacionDatoId();
        if (!_listaResultados.getThis().isSelectionEmpty()) {
            vo = (RefaccionVo) _listaResultados.getSelectValueId();
        }else if (!_listaResultados.isEmpty()) {
                vo = (RefaccionVo) datos.get(_listaResultados.getThis().getModel().getElementAt(0));
        }
        
        if(vo!=null){
            
            noSeCargoDesdeEsteDialogo = false; 
            cargarRefaccionParaEntrada(vo);
            noSeCargoDesdeEsteDialogo = true; 
        }else{
            JOptionPane.showMessageDialog(this, "No hubo coicidencias con tu busqueda.");
            deshabilitarCamposParaRellenar(true);
            limpiar();
        }
        
    }
    
    
    public void cargarRefaccionParaEntrada(RefaccionVo vo){
        if (vo!=null) {
            float existencia = this.getCoordinador().entradaLoteExistencia(vo.getId());
            //SI NO HAY EXISTENCIA DAMOS LA OPCIÓN DE ABRIR EL DIALOGO REGISTRAR
            // NUEVA REFACCIÓN. 
            if (existencia!=0f) {
                deshabilitarCamposParaRellenar(false);
                //POR SI HUBO ALGÚN CAMBIO ENTRE TODOS ESTOS MOVIMIENTOS.
                // COMO MODIFICACIÓN DE LA REFACCIÓN. STOCK MINIMO O MÁXIMO, ETC. 
                if (noSeCargoDesdeEsteDialogo) {
                    /**
                     Esto lo tengo que hacer así por que el lambda me da error
                     * si modifico el vo de RefaccionVo. Me dice que tiene que
                     * ser final.
                     */
                    reconsultarRefaccionCargadaDesdeOtroLugar(vo);
                }else{
                
                mostrarRefaccionParaEntrada(vo);
                cargarLotesDeRefaccion(vo.getId());
                _txtExistencia.setText(existencia+"");
                colorearMinYMax(existencia, vo);
                    
                }
            }else{
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
                    this.getCoordinador().entradaLoteAbrirDialogo(vo, 
                            ()->this.getCoordinador().salidaLoteAbrirDialogo(vo,
                                    this.getCoordinador().getPanelEntradaLote()));
                }else{
                    limpiar();
                    JOptionPane.showMessageDialog(this,
                            "No se puede registrar una salida si la refacción no tiene existencia."
                            ,"No se puede registra salida." ,JOptionPane.ERROR_MESSAGE);
                }
            }    
        }
    }
    
    private void reconsultarRefaccionCargadaDesdeOtroLugar(RefaccionVo vo){
        noSeCargoDesdeEsteDialogo = false;
        vo = this.getCoordinador().refaccionConsultar(vo.getId());
        cargarRefaccionParaEntrada(vo);

    }
    
    private void cargarLotesDeRefaccion(int id){
    
        List<EntradaLoteVo> listaLotes = this.getCoordinador().entradaLoteLotes(id, false);
        HashMap<String, Object> datos = new HashMap<>();
        
        for (EntradaLoteVo vo : listaLotes) {
            String idFormateado = Textos.formaetarNumeros(vo.getId(), "0000000");
            datos.put(vo.getFechaRecepcionLote()+" | "+idFormateado, vo);
        }
        _comboLotesDisponibles.cargarCombo(datos);
        if (datos.size()==0) {
            _txtExistenciaLote.setText("");
        }
    }
    
    public void mostrarRefaccionParaEntrada(RefaccionVo vo){
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
        _txtBusqueda.setText("");
//        _listaResultados.limpiar();
        
        
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
        _txtCantidadQueEntra.setText("");
        _txtExistenciaLote.setText("");
        
        _comboLotesDisponibles.limpiar();
        
        _txtStockMax.setErrorQuitar();
        _txtStockMin.setErrorQuitar();
        _txtExistencia.setErrorQuitar();
        
        
        _txtObservaciones.setText("");
        _imagenesRefaccion.limpiarComponenteURL();
        _txtBusqueda.setFocus();
        
        _listaResultados.limpiar();
        
    }

    private void salir(){
            limpiar();
            dispose();
            
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
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
        // TODO add your handling code here:
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
    private javax.swing.JTextField txtCantidadQueEntra;
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
}
