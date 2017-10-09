package vista.panels;

import controlador.CoordinadorPaneles;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.InfoTabla.ImagenProveedorIT;
import modelo.InfoTabla.PaisIT;
import modelo.InfoTabla.ProveedorIT;
import modelo.logica.Validacion;
import modelo.vo.ImagenProveedorVo;
import modelo.vo.PaisVo;
import modelo.vo.ProveedorVo;
import vista.UtilidadesIntefaz.ConfiguracionDePanel;
import vista.UtilidadesIntefaz.JPanelBase;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesBotones_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesComboBox_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesJXViewImage_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesListas_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesTxt_;

/**
 *
 * @author Particular
 */
public class PanelProveedorModificar extends JPanelBase {

    private static final long serialVersionUID = 1L;
    private int id;
    
    private UtilidadesTxt_ _TxtEmpresa;
    private UtilidadesTxt_ _TxtNombreContacto;
    private UtilidadesTxt_ _TxtTelefono;
    private UtilidadesTxt_ _TxtPaginaWeb;
    private UtilidadesTxt_ _TxtEmail;
    private UtilidadesComboBox_ _ComboPais;
    private UtilidadesJXViewImage_ _ImagenesProveedor;
    private UtilidadesListas_ _ListaProveedores;

    public PanelProveedorModificar() {
        initComponents();
        configuracionesDialogo = new ConfiguracionDePanel();
        configuracionesDialogo.setModal(true);
        configuracionesDialogo.setResizable(false);
        configuracionesDialogo.setTitle(CoordinadorPaneles.PANEL_PROVEEDOR_MODIFICAR);
        configuracionesDialogo.setLocationRelativeTo(null);
        configuracionesDialogo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.id = -1;
    }

    @Override
    public void initConfig() {
         
        /*
        =======================================================================
            INICIO SETEO NOMBRES DE ETIQUETA
        ///////////////////////////////////////////////////////////////////////
        */
        ProveedorIT pit = new ProveedorIT();
        PaisIT paisit = new PaisIT();

        this.etiquetaEmail.setText(pit.getEmailPDC().getNombreParaMostrar());
        this.etiquetaEmpresa.setText(pit.getEmpresaProveedorPDC().getNombreParaMostrar());
        this.etiquetaNombrecontacto.setText(pit.getNombreContactoPDC().getNombreParaMostrar());
        this.etiquetaPaginaWeb.setText(pit.getPaginaWebPDC().getNombreParaMostrar());
        this.etiquetaPais.setText(paisit.getPaisPDC().getNombreParaMostrar());
        this.etiquetaTelefono.setText(pit.getTelefonoPDC().getNombreParaMostrar());
        
        
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
        this._TxtEmpresa = new UtilidadesTxt_(getCoordinador());
        this._TxtNombreContacto = new UtilidadesTxt_(getCoordinador());
        this._TxtTelefono = new UtilidadesTxt_(getCoordinador());
        this._TxtPaginaWeb = new UtilidadesTxt_(getCoordinador());
        this._TxtEmail = new UtilidadesTxt_(getCoordinador());
        this._ComboPais = new UtilidadesComboBox_(getCoordinador());
        this._ImagenesProveedor = new UtilidadesJXViewImage_(getCoordinador());
        this._ListaProveedores = new UtilidadesListas_(getCoordinador());
        
        //SETEAMOS LOS COMPONENTES DENTRO DE LA UTILIDAD.
        _TxtEmpresa.setComponente(txtEmpresa);
        _TxtNombreContacto.setComponente(txtNombreContacto); 
        _TxtTelefono.setComponente(txtTelefono); 
        _TxtPaginaWeb.setComponente(txtPaginaWeb); 
        _TxtEmail.setComponente(txtEmail); 
        _ComboPais.setComponente(comboPais);
        _ImagenesProveedor.setComponente(imagenView);
        _ImagenesProveedor.setjLabelContador(etiquetaContadorImagenes);
        _ListaProveedores.setComponente(listaProveedores);
                
       
        //ASIGNAMOS EL TAMAÑO DE CAMPO
        _TxtEmpresa.setTamanoDeCampo(pit.getEmpresaProveedorPDC().getLongitudDeCaracteres());
        _TxtNombreContacto.setTamanoDeCampo(pit.getNombreContactoPDC().getLongitudDeCaracteres());
        _TxtTelefono.setTamanoDeCampo(pit.getTelefonoPDC().getLongitudDeCaracteres());
        _TxtPaginaWeb.setTamanoDeCampo(pit.getPaginaWebPDC().getLongitudDeCaracteres());
        _TxtEmail.setTamanoDeCampo(pit.getEmailPDC().getLongitudDeCaracteres());
        _ComboPais.setTamanoDeCampo(paisit.getPaisPDC().getLongitudDeCaracteres());
        
        //CAMPOS QUE REQUIEREN TEXTO EN MAYUSCULAS.
        _TxtEmpresa.setPermitirSoloMayusculas();
        _TxtNombreContacto.setPermitirSoloMayusculas();
        _ComboPais.setPermitirSoloMayusculas();
        
        //QUITAMOS LOS ESPACIOS SOBRANTES DESPUES DE DEJAR EL CAMPO.
        _TxtEmpresa.setEspaciosEnBlanco();
        _TxtNombreContacto.setEspaciosEnBlanco();
        _TxtTelefono.setEspaciosEnBlanco();
        _TxtPaginaWeb.setEspaciosEnBlanco();
        _TxtEmail.setEspaciosEnBlanco();
        
        //ACCIONES ESPECELIALES.
        _ComboPais.setFocusAction(()->this.guardarPais(), false);
        _ListaProveedores.setValueChange(()->cargarProveedorSeleccionado());
        
        //ACCIONES DE BOTONES
        UtilidadesBotones_.setEnterYEspacio(btnCancelar);
        UtilidadesBotones_.setEnterYEspacio(btnGuardar);
        
        //OPERACIONES DE ACTUALIZACION.
        opAct.add(PaisIT.NOMBRE_TABLA, this::cargarComboPaises);
        opAct.add(ProveedorIT.NOMBRE_TABLA, this::cargarListaProveedores);
        opAct.add(ImagenProveedorIT.NOMBRE_TABLA, this::cargarImagenes);
        
        
        /* 
        ////////////////////////////////////////////////////////////////////////
            FIN SETEO DE UTILIDADES
        ========================================================================
        */
    }
    
    
    
    /**
     * Configuraciones para el dialogo.  
     */
    public void configurar(){
        
       
//        /*
//        =======================================================================
//            INICIO CARGA DE ELEMENTOS 
//        ///////////////////////////////////////////////////////////////////////
//        */
//            this.cargarComboPaises();
//            this.cargarListaProveedores();
//            
//        
//        /* 
//        ////////////////////////////////////////////////////////////////////////
//            FIN CARGA DE ELEMENTOS 
//        ========================================================================
//        */
//        
        
        
    }

    public JComboBox<String> getComboPais() {
        return comboPais;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JTextField getTxtEmpresa() {
        return txtEmpresa;
    }

    public JTextField getTxtNombreContacto() {
        return txtNombreContacto;
    }

    public JTextField getTxtPaginaWeb() {
        return txtPaginaWeb;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        etiquetaEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        etiquetaEmpresa = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        etiquetaPaginaWeb = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtPaginaWeb = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        etiquetaPais = new javax.swing.JLabel();
        etiquetaNombrecontacto = new javax.swing.JLabel();
        txtNombreContacto = new javax.swing.JTextField();
        comboPais = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        imagenView = new org.jdesktop.swingx.JXImageView();
        etiquetaContadorImagenes = new javax.swing.JLabel();
        btnSiguienteImagen = new javax.swing.JButton();
        btnRegresarImagen = new javax.swing.JButton();
        btnAgregarImagen = new javax.swing.JButton();
        btnEliminarImagen = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaProveedores = new javax.swing.JList<>();
        btnEliminarProveedor = new javax.swing.JButton();

        etiquetaTelefono.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaTelefono.setText("Telefono");

        txtTelefono.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefono.setMinimumSize(new java.awt.Dimension(180, 30));

        etiquetaEmail.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaEmail.setText("Email");

        txtEmail.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setMaximumSize(new java.awt.Dimension(195, 2147483647));
        txtEmail.setMinimumSize(new java.awt.Dimension(195, 30));

        etiquetaEmpresa.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaEmpresa.setText("Empresa");

        txtEmpresa.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtEmpresa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmpresa.setMaximumSize(new java.awt.Dimension(395, 2147483647));
        txtEmpresa.setMinimumSize(new java.awt.Dimension(395, 35));

        etiquetaPaginaWeb.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaPaginaWeb.setText("Pagina web");

        btnGuardar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/imagenes/iconos_palomita.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtPaginaWeb.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtPaginaWeb.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPaginaWeb.setMinimumSize(new java.awt.Dimension(208, 30));

        btnCancelar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/imagenes/iconos_tache.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        etiquetaPais.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaPais.setText("Pais");

        etiquetaNombrecontacto.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaNombrecontacto.setText("Nombre contaco");

        txtNombreContacto.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtNombreContacto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreContacto.setMaximumSize(new java.awt.Dimension(395, 2147483647));
        txtNombreContacto.setMinimumSize(new java.awt.Dimension(395, 30));

        comboPais.setEditable(true);
        comboPais.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        comboPais.setMinimumSize(new java.awt.Dimension(195, 32));

        jLabel1.setBackground(new java.awt.Color(104, 126, 13));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/imagenes/iconos_titulo_ modificar proveedor.png"))); // NOI18N
        jLabel1.setOpaque(true);

        imagenView.setOpaque(false);

        etiquetaContadorImagenes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        etiquetaContadorImagenes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etiquetaContadorImagenes.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        etiquetaContadorImagenes.setOpaque(true);

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

        btnAgregarImagen.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnAgregarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/imagenes/iconos_mas.png"))); // NOI18N
        btnAgregarImagen.setText("Agregar");
        btnAgregarImagen.setOpaque(false);
        btnAgregarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarImagenActionPerformed(evt);
            }
        });

        btnEliminarImagen.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnEliminarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/imagenes/iconos_tache.png"))); // NOI18N
        btnEliminarImagen.setText("Eliminar");
        btnEliminarImagen.setOpaque(false);
        btnEliminarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarImagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagenViewLayout = new javax.swing.GroupLayout(imagenView);
        imagenView.setLayout(imagenViewLayout);
        imagenViewLayout.setHorizontalGroup(
            imagenViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(imagenViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etiquetaContadorImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, imagenViewLayout.createSequentialGroup()
                        .addComponent(btnRegresarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSiguienteImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarImagen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarImagen)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        imagenViewLayout.setVerticalGroup(
            imagenViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenViewLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(imagenViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSiguienteImagen)
                    .addComponent(btnRegresarImagen)
                    .addGroup(imagenViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAgregarImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarImagen)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaContadorImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        listaProveedores.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        listaProveedores.setFocusable(false);
        jScrollPane5.setViewportView(listaProveedores);

        btnEliminarProveedor.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnEliminarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/imagenes/iconos_tache.png"))); // NOI18N
        btnEliminarProveedor.setText("Eliminar Proveedor");
        btnEliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(etiquetaNombrecontacto)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaEmpresa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminarProveedor))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiquetaTelefono)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiquetaPaginaWeb)
                                    .addComponent(txtPaginaWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtNombreContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etiquetaEmail))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiquetaPais)
                                    .addComponent(comboPais, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnCancelar)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardar))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(imagenView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminarProveedor)
                            .addComponent(etiquetaEmpresa, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etiquetaNombrecontacto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiquetaTelefono)
                            .addComponent(etiquetaPaginaWeb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPaginaWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiquetaEmail)
                            .addComponent(etiquetaPais))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnCancelar))
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5)
                        .addContainerGap())))
            .addComponent(imagenView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public void cargarProveedorSeleccionado(){
        this.id = (int)_ListaProveedores.getSelectValueId(); 
        if (id!=-1) {
            limpiarTodo();
            if (id!=0) {
                ProveedorVo vo = this.getCoordinador().proveedorConsultar(id);

                _ComboPais.setText(vo.getIdPais()+"");
                _TxtEmail.setText(vo.getEmail());
                _TxtEmpresa.setText(vo.getEmpresa());
                _TxtNombreContacto.setText(vo.getNombreContacto());
                _TxtPaginaWeb.setText(vo.getPaginaWeb());
                _TxtTelefono.setText(vo.getTelefono());
                cargarImagenes();
            }
        }
    }
    
    public void cargarImagenes(){
        int id = this.id;
        if (this.id!=-1) {
            List<ImagenProveedorVo> listaImagenProVo = this.getCoordinador().imagenProveedorConsultar(id);
            _ImagenesProveedor.limpiarComponenteURL();
            for (ImagenProveedorVo vo : listaImagenProVo) {
                UtilidadesJXViewImage_.TransporteImagenesURL t = new UtilidadesJXViewImage_.TransporteImagenesURL();
                t.setIdImagen(vo.getIdProveedor());
                t.setNombreImagen(vo.getNombreParaMostrar());
                t.setNombreImagenServidor(vo.getNombreServidor());
                t.setUrl(vo.getUrlImagen());
                _ImagenesProveedor.addIMagenes(t);
            }
            _ImagenesProveedor.cargarPrimeraImagen();
        }
    }
   
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    public void cargarListaProveedores(){
        List<ProveedorVo> listPvo = this.getCoordinador().proveedoresConsultarMarcas();
        HashMap<String, Object> mapa = new HashMap<>();
        for (ProveedorVo vo : listPvo) {
            mapa.put(vo.getEmpresa(), vo.getId());
        }
        _ListaProveedores.limpiar();
        _ListaProveedores.cargarLista(mapa);
    
    }
    private void limpiarTodo(){
        
        _ImagenesProveedor.limpiarComponenteURL();
        this._TxtEmail.setText("");
        this._TxtEmpresa.setText("");
        this._TxtNombreContacto.setText("");
        this._TxtPaginaWeb.setText("");
        this._TxtTelefono.setText("");
        this._ComboPais.setText("");
        
        
        this._TxtEmail.setErrorQuitar();
        this._TxtEmpresa.setErrorQuitar();
        this._TxtNombreContacto.setErrorQuitar();
        this._TxtPaginaWeb.setErrorQuitar();
        this._TxtTelefono.setErrorQuitar();
        this._ComboPais.setErrorQuitar();
    
    }
    private void cancelar(){
        boolean todoVacio = true;
        //SI TODOS LOS CAMPOS ESTAN VACIOS CERRAMOS DIRECTAMENTE, SI NO, PEDIMOS
        // AL USUARIO CONFIRMACIÓN.
        
        if (    !this._TxtEmail.isEmpty() ||
                !this._TxtEmpresa.isEmpty() ||
                !this._TxtNombreContacto.isEmpty() ||
                !this._TxtPaginaWeb.isEmpty() ||
                !this._TxtTelefono.isEmpty() ||
                !this._ComboPais.isEmpty()
                ) {
            todoVacio = false;
        }
        
        if (todoVacio) {
            this.limpiarTodo();
            this.dispose();
            
        }else{
        
            int respuesta = JOptionPane.showConfirmDialog(
                    this, "¿Estas segúro que quieres cancelar?\n "
                            + "Se perderan los datos.", "Confirmar cancelación.",
                            JOptionPane.YES_NO_OPTION);
            if (respuesta==JOptionPane.YES_OPTION) {
                this.limpiarTodo();
                this.dispose();
            }
        }
    }
    
    /**
     * Guarda el nuevo pais. 
     */
    private void guardarPais(){
        
        String elementoEscrito = this._ComboPais.getText();
        if (this._ComboPais.contieneElItemEscrito()) {
            this._ComboPais.setSelectedItem(elementoEscrito);
        }else{
            this._ComboPais.setErrorQuitar();
            if (!elementoEscrito.equals("")) {
                if (this._ComboPais.contieneElItemEscrito(elementoEscrito)) {
                    this._ComboPais.setSelectedItem(elementoEscrito);
                }else{
                    int respuesta = JOptionPane.showConfirmDialog(this,
                            "¿Estas segúro que quieres guardar \n "
                           + " el nuevo país \" "+this._ComboPais.getText()+"\"?", 
                            "Guardar nuevo país.", JOptionPane.YES_NO_OPTION);
                    if (respuesta==JOptionPane.YES_OPTION) {
                        PaisVo vo = new PaisVo();
                        vo.setPais(this._ComboPais.getText());
                        this.getCoordinador().paisGuardar(vo);
                    }else{
                        this._ComboPais.setText("");
                    }
                }
            }
        }
        this.cargarComboPaises();
        this._ComboPais.setSelectedItem(elementoEscrito);
    }
    
    /**
     * Guarda un nuevo proveedor. 
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (id==-1) {
            JOptionPane.showMessageDialog(this, "No has seleccionado ningún"
                    + " proveedor de la lista. ");
        }else{
            ProveedorVo vo = new ProveedorVo();
            vo.setId(id);
            vo.setEmail(_TxtEmail.getText());
            vo.setEmpresa(_TxtEmpresa.getText());
            
            vo.setIdPais(_ComboPais.getSelectedItem_idRetorno());
            vo.setNombreContacto(_TxtNombreContacto.getText());
            vo.setPaginaWeb(_TxtPaginaWeb.getText());
            vo.setTelefono(_TxtTelefono.getText());

            List<Validacion> validaciones = this.getCoordinador().proveedorValidarCampos(vo, true);
            boolean todoValido = true;
            ProveedorIT iT = new ProveedorIT();
            for (Validacion validacione : validaciones) {
                if (validacione.getNombreDeCampo().equals(iT.getEmpresaProveedorPDC().getNombre())) {
                    if (!validacione.isValido()) {
                        _TxtEmpresa.setError(validacione.getMensajeDeError());
                    }else{
                        _TxtEmpresa.setErrorQuitar();
                    }
                }

                if(!validacione.isValido()){
                    todoValido = false;
                }
            }

            if (todoValido) {
                //ACTUALIZAMOS LA REFACCIÓN.
                if (this.getCoordinador().proveedorModificar(vo)) {
                    JOptionPane.showMessageDialog(
                            this.getCoordinador().getMarcoParaVentanaPrincipal(), 
                            "Se modifico correctamente el proveedor.");
                    
                    limpiarTodo();
                    cargarProveedorSeleccionado();
                    cargarListaProveedores();
                    _ListaProveedores.getThis().setSelectedValue(vo.getEmpresa(), true);
                    
                }else{
                    JOptionPane.showMessageDialog(
                            this,
                            "Algo sucedio y no se modifico el proveedor.");
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.cancelar();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
    }//GEN-LAST:event_formWindowActivated

    private void btnSiguienteImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteImagenActionPerformed
        _ImagenesProveedor.imagenSiguiente();
    }//GEN-LAST:event_btnSiguienteImagenActionPerformed

    private void btnRegresarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarImagenActionPerformed
        _ImagenesProveedor.imagenAnterior();
    }//GEN-LAST:event_btnRegresarImagenActionPerformed

    private void btnAgregarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarImagenActionPerformed
        _ImagenesProveedor.setFiltros(new FileNameExtensionFilter("Imagenes", "jpg", "gif", "png", "tiff", "jpeg"));
        _ImagenesProveedor.cargarImagenes();
        List<ImagenProveedorVo> listaiVo = new ArrayList<>();
        List<File> file = _ImagenesProveedor.getImagenesPorCargar();
        for (File f : file) {
            ImagenProveedorVo vo = new ImagenProveedorVo();
            vo.setIdProveedor((int)_ListaProveedores.getSelectValueId());
            vo.setFicheroImagen(f);
            vo.setNombreParaMostrar(f.getName());
            listaiVo.add(vo);
        }
        
        String errorImg = this.getCoordinador().imagenProveedorGuardarLista(listaiVo);
        cargarImagenes();
        if (errorImg!=null) {
            JOptionPane.showMessageDialog(
                null,
                "No se cargaron las siguientes imagenes: \n\n" + errorImg,
                "Error cargando imagenes", JOptionPane.ERROR_MESSAGE);    
        }
        getCoordinador().actualizarTodoLoVisible();
    }//GEN-LAST:event_btnAgregarImagenActionPerformed

    private void btnEliminarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarImagenActionPerformed
        UtilidadesJXViewImage_.TransporteImagenesURL imgEliminar = _ImagenesProveedor.obtenerImagenActual();
        if (imgEliminar!=null) {
            int r = JOptionPane.showConfirmDialog(
                    this, 
                    "¿Estas segúro que quieres eliminar la imágen?"
                            + "\n Esta acción no se puede deshacer.",
                    "Eliminar imagen.", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE);
            if (r==JOptionPane.YES_OPTION) {
                ImagenProveedorVo vo = new ImagenProveedorVo();
                vo.setIdProveedor(imgEliminar.getIdImagen());
                vo.setNombreServidor(imgEliminar.getNombreImagenServidor());
                this.getCoordinador().imagenProveedorEliminar(vo);
//                cargarImagenes();
                getCoordinador().actualizarTodoLoVisible();
            }
        }

    }//GEN-LAST:event_btnEliminarImagenActionPerformed

    private void btnEliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProveedorActionPerformed
        ProveedorVo vo = new ProveedorVo();
        vo.setId(this.id);
        vo.setEmpresa(this._TxtEmpresa.getText());
       
        if (vo.getId()!=-1) {
            int r = JOptionPane.showConfirmDialog(
                    this, 
                    "¿Estas segúro que quieres eliminar al proveedor '"+vo.getEmpresa()+"'?"
                            + "\n Esta acción no se puede deshacer.",
                    "Eliminar proveedor '"+vo.getEmpresa()+"'.", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE);
        
            if (r==JOptionPane.YES_OPTION) {
                
                this.getCoordinador().proveedorEliminar(vo);
                UtilidadesJXViewImage_.TransporteImagenesURL imgEliminar = _ImagenesProveedor.obtenerImagenActual();
                if (imgEliminar!=null) {
                    ImagenProveedorVo iPvo = new ImagenProveedorVo();
                    iPvo.setIdProveedor(imgEliminar.getIdImagen());
                    iPvo.setNombreServidor(imgEliminar.getNombreImagenServidor());
                    this.getCoordinador().imagenProveedorEliminar(iPvo);
                }
                this.limpiarTodo();
                cargarListaProveedores();
                
            }        
        }else{
            JOptionPane.showMessageDialog(
                    this, 
                    "No has seleccionado ningún elemento de la lista.", 
                    "No seleccionado", 
                    JOptionPane.WARNING_MESSAGE);
        }

        
    }//GEN-LAST:event_btnEliminarProveedorActionPerformed

    public void cargarComboPaises(){
        List<PaisVo> listaPaises = this.getCoordinador().PaisConsultar();
        HashMap<String, Object> datosPaises = new HashMap<>();
        for (PaisVo listaPaise : listaPaises) {
            datosPaises.put(listaPaise.getPais(), listaPaise.getId());
        }
        this._ComboPais.cargarCombo(datosPaises);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarImagen;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarImagen;
    private javax.swing.JButton btnEliminarProveedor;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresarImagen;
    private javax.swing.JButton btnSiguienteImagen;
    private javax.swing.JComboBox<String> comboPais;
    private javax.swing.JLabel etiquetaContadorImagenes;
    private javax.swing.JLabel etiquetaEmail;
    private javax.swing.JLabel etiquetaEmpresa;
    private javax.swing.JLabel etiquetaNombrecontacto;
    private javax.swing.JLabel etiquetaPaginaWeb;
    private javax.swing.JLabel etiquetaPais;
    private javax.swing.JLabel etiquetaTelefono;
    private org.jdesktop.swingx.JXImageView imagenView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<String> listaProveedores;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtNombreContacto;
    private javax.swing.JTextField txtPaginaWeb;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
