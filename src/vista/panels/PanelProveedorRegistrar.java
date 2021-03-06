/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesTxt_;

/**
 *
 * @author Particular
 */
public class PanelProveedorRegistrar extends JPanelBase {

    private static final long serialVersionUID = 1L;
    
    String proveedorPrecargado;
    UtilidadesTxt_ _TxtEmpresa;
    UtilidadesTxt_ _TxtNombreContacto;
    UtilidadesTxt_ _TxtTelefono;
    UtilidadesTxt_ _TxtPaginaWeb;
    UtilidadesTxt_ _TxtEmail;
    UtilidadesComboBox_ _ComboPais;
    UtilidadesJXViewImage_ _ImagenesProveedor;

    public PanelProveedorRegistrar() {
        initComponents();
        configuracionesDialogo = new ConfiguracionDePanel();
        configuracionesDialogo.setModal(true);
        configuracionesDialogo.setResizable(false);
        configuracionesDialogo.setTitle(CoordinadorPaneles.PANEL_PROVEEDOR_REGISTRAR);
        configuracionesDialogo.setLocationRelativeTo(null);
        configuracionesDialogo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
       
        
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

        this.etiquetaEmail.setText(pit.getEMAIL().getNombreParaMostrar());
        this.etiquetaEmpresa.setText(pit.getEMPRESA_PROVEEDOR().getNombreParaMostrar());
        this.etiquetaNombrecontacto.setText(pit.getNOMBRE_CONTACTO().getNombreParaMostrar());
        this.etiquetaPaginaWeb.setText(pit.getPAGINA_WEB().getNombreParaMostrar());
        this.etiquetaPais.setText(paisit.getPAIS().getNombreParaMostrar());
        this.etiquetaTelefono.setText(pit.getTELEFONO().getNombreParaMostrar());
        
        
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
        
        //SETEAMOS LOS COMPONENTES DENTRO DE LA UTILIDAD.
        _TxtEmpresa.setComponente(txtEmpresa);
        _TxtNombreContacto.setComponente(txtNombreContacto); 
        _TxtTelefono.setComponente(txtTelefono); 
        _TxtPaginaWeb.setComponente(txtPaginaWeb); 
        _TxtEmail.setComponente(txtEmail); 
        _ComboPais.setComponente(comboPais);
        _ImagenesProveedor.setComponente(imagenView);
        _ImagenesProveedor.setjLabelContador(etiquetaContadorImagenes);
        
        
       
        //ASIGNAMOS EL TAMAÑO DE CAMPO
        _TxtEmpresa.setTamanoDeCampo(pit.getEMPRESA_PROVEEDOR().getLongitudDeCaracteres());
        _TxtNombreContacto.setTamanoDeCampo(pit.getNOMBRE_CONTACTO().getLongitudDeCaracteres());
        _TxtTelefono.setTamanoDeCampo(pit.getTELEFONO().getLongitudDeCaracteres());
        _TxtPaginaWeb.setTamanoDeCampo(pit.getPAGINA_WEB().getLongitudDeCaracteres());
        _TxtEmail.setTamanoDeCampo(pit.getEMAIL().getLongitudDeCaracteres());
        _ComboPais.setTamanoDeCampo(paisit.getPAIS().getLongitudDeCaracteres());
        
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
        
        //ACCIONES DE BOTONES
        UtilidadesBotones_.setEnterYEspacio(btnCancelar);
        UtilidadesBotones_.setEnterYEspacio(btnGuardar);
        
        //OPERACIONES DE ACTAULIZACION.
        opAct.add(PaisIT.NOMBRE_TABLA, this::cargarComboPaises);
        
        
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
        /*
        =======================================================================
            INICIO CARGA DE ELEMENTOS 
        ///////////////////////////////////////////////////////////////////////
        */
//            this.cargarComboPaises();
            _TxtEmpresa.setFocus();
        
        /* 
        ////////////////////////////////////////////////////////////////////////
            FIN CARGA DE ELEMENTOS 
        ========================================================================
        */
        
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

    public String getProveedorPrecargado() {
        return _TxtEmpresa.getText();
    }
    
    /**
     * Setea dentro del campo empresa el nombre que se le pase como parametro.
     * 
     * @param proveedorPrecargado El proveedor que quiere que se muestre.
     */
    public void setProveedorPrecargado(String proveedorPrecargado) {
        _TxtEmpresa.setText(proveedorPrecargado);
        this.proveedorPrecargado = proveedorPrecargado;
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
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_palomita.png"))); // NOI18N
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
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_tache.png"))); // NOI18N
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
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_titulo_agregar proveedor.png"))); // NOI18N
        jLabel1.setOpaque(true);

        imagenView.setOpaque(false);

        etiquetaContadorImagenes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        etiquetaContadorImagenes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etiquetaContadorImagenes.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        etiquetaContadorImagenes.setOpaque(true);

        btnSiguienteImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_siguiente.png"))); // NOI18N
        btnSiguienteImagen.setFocusable(false);
        btnSiguienteImagen.setOpaque(false);
        btnSiguienteImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteImagenActionPerformed(evt);
            }
        });

        btnRegresarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_anterios.png"))); // NOI18N
        btnRegresarImagen.setFocusable(false);
        btnRegresarImagen.setOpaque(false);
        btnRegresarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarImagenActionPerformed(evt);
            }
        });

        btnAgregarImagen.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnAgregarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_mas.png"))); // NOI18N
        btnAgregarImagen.setText("Agregar");
        btnAgregarImagen.setOpaque(false);
        btnAgregarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarImagenActionPerformed(evt);
            }
        });

        btnEliminarImagen.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnEliminarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_tache.png"))); // NOI18N
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
                .addContainerGap(12, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaNombrecontacto)
                    .addComponent(etiquetaEmpresa)
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
                        .addComponent(btnGuardar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imagenView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiquetaEmpresa)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnCancelar)))
                    .addComponent(imagenView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

   
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    private void limpiarTodo(){
        _ImagenesProveedor.limpiar();
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
                            + "Se perderan los dato.", "Confirmar cancelación.",
                            JOptionPane.YES_NO_OPTION);
            if (respuesta==JOptionPane.YES_OPTION) {
                this.dispose();
                this.limpiarTodo();
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
        List<ImagenProveedorVo> listapVo = new ArrayList<>();
        
        ProveedorVo vo = new ProveedorVo();
        vo.setId(-1);
        vo.setEmail(_TxtEmail.getText());
        vo.setEmpresa(_TxtEmpresa.getText());
        vo.setIdPais(_ComboPais.getSelectedItem_idRetorno());
        vo.setNombreContacto(_TxtNombreContacto.getText());
        vo.setPaginaWeb(_TxtPaginaWeb.getText());
        vo.setTelefono(_TxtTelefono.getText());
        
        List<File> file = _ImagenesProveedor.getImagenesPorCargar();
        for (File f : file) {
            ImagenProveedorVo pvo = new ImagenProveedorVo();
            pvo.setFicheroImagen(f);
            pvo.setNombreParaMostrar(f.getName());
            listapVo.add(pvo);
        }
        
        List<Validacion> validaciones = this.getCoordinador().proveedorValidarCampos(vo);
        boolean todoValido = true;
        ProveedorIT iT = new ProveedorIT();
        for (Validacion validacione : validaciones) {
            if (validacione.getNombreDeCampo().equals(iT.getEMPRESA_PROVEEDOR().getNombre())) {
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
            //GUARDAMOS LA REFACCION
            if(this.getCoordinador().proveedorGuardar(vo)){
                //OBTENEMOS EL ID GENERADO.
                int idProveedor = this.getCoordinador().proveedorConsultarUltimoId();
                if (idProveedor==-1) {
                    JOptionPane.showMessageDialog(this, "Hubo un error y no se pudieron guardar algúnos datos.\n\n"
                           + "Puedes revisar si los datos de la refacción se almacenarón\n"
                           + "y asociar de nuevo la información modificandola directamente."
                           + "", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    //ASOCIAMOS LS DATOS QUE SE VAN A RELACIONAR CON LA REFACCIÓN RECIEN ALMACENADA. 
                    for (ImagenProveedorVo pVo : listapVo) {
                        pVo.setIdProveedor(idProveedor);
                    }

                    String errorImg = this.getCoordinador().imagenProveedorGuardarLista(listapVo);
                    if (errorImg!=null) {
                        JOptionPane.showMessageDialog(
                                null,
                                "No se cargaron las siguientes imagenes: \n\n" + errorImg,
                                "Error cargando imagenes", JOptionPane.ERROR_MESSAGE);
                    }

                    limpiarTodo();
                    this.dispose();
                    getCoordinador().actualizarTodoLoVisible();
                    JOptionPane.showMessageDialog(
                            this.getCoordinador().getMarcoParaVentanaPrincipal(), 
                            "Se guardo correctamente el proveedor.");
                }
            }else{
                JOptionPane.showMessageDialog(
                        this,
                        "Algo salio mal y no se guardo el proveedor.",
                        "No se pudo registrar el proveedor.", 
                        JOptionPane.ERROR_MESSAGE);
            
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.cancelar();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
    }//GEN-LAST:event_formWindowActivated

    private void btnSiguienteImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteImagenActionPerformed
        _ImagenesProveedor.siguienteAnterior(true);
    }//GEN-LAST:event_btnSiguienteImagenActionPerformed

    private void btnRegresarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarImagenActionPerformed
        _ImagenesProveedor.siguienteAnterior(false);
    }//GEN-LAST:event_btnRegresarImagenActionPerformed

    private void btnAgregarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarImagenActionPerformed

        _ImagenesProveedor.cargarImagenes();
    }//GEN-LAST:event_btnAgregarImagenActionPerformed

    private void btnEliminarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarImagenActionPerformed
        _ImagenesProveedor.eliminarImagenSeleccionada();
    }//GEN-LAST:event_btnEliminarImagenActionPerformed

    private void cargarComboPaises(){
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
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtNombreContacto;
    private javax.swing.JTextField txtPaginaWeb;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
