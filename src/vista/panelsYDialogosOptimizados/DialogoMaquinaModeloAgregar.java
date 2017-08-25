/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.panelsYDialogosOptimizados;
import controlador.Coordinador;
import java.util.HashMap;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.InfoTabla.MaquinaModeloIT;
import modelo.InfoTabla.ProveedorIT;
import modelo.logica.Validacion;
import modelo.vo.MaquinaModeloVo;
import modelo.vo.ProveedorVo;
import vista.utilidadesOptimizadas.UtilidadesBotones_;
import vista.utilidadesOptimizadas.UtilidadesComboBox_;
import vista.utilidadesOptimizadas.UtilidadesTxt_;

/**
 *
 * @author Particular
 */
public class DialogoMaquinaModeloAgregar extends JDialog {
    private Coordinador coordinador;
    private UtilidadesTxt_ _TxtAnio;
    private UtilidadesTxt_ _TxtModeloMaquina;
    private UtilidadesComboBox_ _ComboMarca;
   
    
    /**
     * Creates new form PanelAgregarMaquina
     */
    public DialogoMaquinaModeloAgregar() {
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
        setModal(true);
        setResizable(false);
        setTitle("Registrar nueva máquina");
        setLocationRelativeTo(this.getCoordinador().getMarcoParaVentanaPrincipal());
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
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
        
        MaquinaModeloIT mmit = new MaquinaModeloIT();
        ProveedorIT pit = new ProveedorIT();
        etiquetaAno.setText(mmit.getAnioPDC().getNombreParaMostrar());
        etiquetaMarca.setText("Marca-"+pit.getEmpresaProveedorPDC().getNombreParaMostrar());
        etiquetaModeloMaquina.setText(mmit.getModeloPDC().getNombreParaMostrar());
        
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
        
        this._TxtAnio = new UtilidadesTxt_ (getCoordinador());
        this._TxtModeloMaquina = new UtilidadesTxt_ (getCoordinador());
        this._ComboMarca = new UtilidadesComboBox_ (getCoordinador());
        
        //SETEAMOS LOS COMPONENTES DENTRO DE LA UTILIDAD.
        
        _TxtAnio.setComponente(txtAnio);
        _TxtModeloMaquina.setComponente(txtModeloMaquina);
        _ComboMarca.setComponente(comboMarca);
       
        //ASIGNAMOS EL TAMAÑO DE CAMPO
        _TxtAnio.setTamanoDeCampo(mmit.getAnioPDC().getLongitudDeCaracteres());
        _TxtModeloMaquina.setTamanoDeCampo(mmit.getModeloPDC().getLongitudDeCaracteres());
        _ComboMarca.setTamanoDeCampo(pit.getEmpresaProveedorPDC().getLongitudDeCaracteres());
        
        //CAMPOS QUE REQUIEREN TEXO EN MAYUSCULAS.
        _TxtModeloMaquina.setPermitirSoloMayusculas();
        _ComboMarca.setPermitirSoloMayusculas();
        
        //CAMPOS SOLO NUMEROS.
        _TxtAnio.setPermitirSoloNumeros();
        
        //QUITAMOS LOS ESPACIOS SOBRANTES DESPUES DE DEJAR EL CAMPO.
        _TxtAnio.setEspaciosEnBlanco();
        _TxtModeloMaquina.setEspaciosEnBlanco();
        _ComboMarca.setEspaciosEnBlanco();
                
        
        //ACCIONES ESPECELIALES.
        _ComboMarca.setFocusAction(()->this.guardarProoveedor(), false);
        
        //ACCIONES DE BOTONES
        UtilidadesBotones_.setEnterYEspacio(btnCancelar);
        UtilidadesBotones_.setEnterYEspacio(btnGuardar);
        
        
        /* 
        ////////////////////////////////////////////////////////////////////////
            FIN SETEO DE UTILIDADES
        ========================================================================
        */
        /*
        =======================================================================
            INICIO CARGA DE ELEMENTOS 
        ///////////////////////////////////////////////////////////////////////
        */
            this.consultarProveedores();
        
        /* 
        ////////////////////////////////////////////////////////////////////////
            FIN CARGA DE ELEMENTOS 
        ========================================================================
        */
        
        
        
        
    }

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    public void guardarProoveedor(){
        String proveedor = _ComboMarca.getText();
        if (!proveedor.equals("")) {
            if (this.coordinador.proveedorExiste(proveedor)) {
                _ComboMarca.setSelectedItem(proveedor);
            }else{
                int r = JOptionPane.showConfirmDialog(this,
                    "¿Estas segúro que quieres agregar '"+proveedor+"' "
                    + "\n como proveedor-empresa nueva?",
                    "¿Guardar nuevo proveedor-empresa?", 
                    JOptionPane.YES_NO_OPTION);

                if (r==0) {
                    this.coordinador.proveedoresAbrirDialogo(proveedor);
                    this.consultarProveedores();
                    _ComboMarca.setSelectedItem(proveedor);
                    
                }else{
                    _ComboMarca.setText("");
                }
            }
        }
    }
    
    public void consultarProveedores(){
        List<ProveedorVo> l = this.coordinador.proveedoresConsultarMarcas();
        HashMap<String, Object> map = new HashMap<>();
        
        for (ProveedorVo vo : l) {
            map.put(vo.getEmpresa(), vo.getId());
        }


        _ComboMarca.cargarCombo(map);
    
    }
    
    private void limpiarTodo(){
        this._TxtModeloMaquina.setText("");
        this._TxtAnio.setText("");
        this._ComboMarca.setText("");
        
        this._TxtModeloMaquina.setErrorQuitar();
        this._TxtAnio.setErrorQuitar();
        this._ComboMarca.setErrorQuitar();
    }
    
    private void cancelar(){
        boolean todoVacio = true;
        //SI TODOS LOS CAMPOS ESTAN VACIOS CERRAMOS DIRECTAMENTE, SI NO, PEDIMOS
        // AL USUARIO CONFIRMACIÓN.
        
        if (    !this._TxtModeloMaquina.isEmpty() ||
                !this._TxtAnio.isEmpty() ||
                !this._ComboMarca.isEmpty() 
                ) {
            todoVacio = false;
        }
        
        if (todoVacio) {
            limpiarTodo();
            this.dispose();
        }else{
        
            int respuesta = JOptionPane.showConfirmDialog(
                    this, "¿Estas segúro que quieres cancelar?\n "
                            + "Se perderan los dato.", "Confirmar cancelación.",
                            JOptionPane.YES_NO_OPTION);
            if (respuesta==JOptionPane.YES_OPTION) {
                this.setVisible(false);
                limpiarTodo();
                this.dispose();
            }
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtModeloMaquina = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        etiquetaModeloMaquina = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        etiquetaAno = new javax.swing.JLabel();
        comboMarca = new javax.swing.JComboBox<>();
        etiquetaMarca = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtModeloMaquina.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtModeloMaquina.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtModeloMaquina.setText("MASS");
        txtModeloMaquina.setMaximumSize(new java.awt.Dimension(395, 2147483647));
        txtModeloMaquina.setMinimumSize(new java.awt.Dimension(395, 35));
        txtModeloMaquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloMaquinaActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/imagenes/iconos_palomita.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/imagenes/iconos_tache.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(104, 127, 13));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/imagenes/iconos_titulo_agregar modelo maquina.png"))); // NOI18N
        jLabel1.setOpaque(true);

        etiquetaModeloMaquina.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaModeloMaquina.setText("Modelo de máquina");

        txtAnio.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtAnio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAnio.setText("MASS");
        txtAnio.setMaximumSize(new java.awt.Dimension(395, 2147483647));
        txtAnio.setMinimumSize(new java.awt.Dimension(395, 35));
        txtAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnioActionPerformed(evt);
            }
        });

        etiquetaAno.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaAno.setText("Año");

        comboMarca.setEditable(true);
        comboMarca.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        comboMarca.setMaximumSize(new java.awt.Dimension(140, 30));
        comboMarca.setMinimumSize(new java.awt.Dimension(140, 30));

        etiquetaMarca.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaMarca.setText("Marca");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(etiquetaModeloMaquina)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiquetaAno)
                                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(etiquetaMarca)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(txtModeloMaquina, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaModeloMaquina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtModeloMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(etiquetaAno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiquetaMarca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void txtModeloMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloMaquinaActionPerformed
        // TODO add your haasdfndling casdode here:
    }//GEN-LAST:event_txtModeloMaquinaActionPerformed
 
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.cancelar();
    }//GEN-LAST:event_formWindowClosing

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        MaquinaModeloVo vo = new MaquinaModeloVo();
        String a = _TxtAnio.getText();
        //NO PUEDES PASAR UN INT NULO.
        if (a.equals("")) {
            vo.setAnio(-1);
        }else{
            vo.setAnio(Integer.parseInt(a));
        }
        vo.setIdProveedor(_ComboMarca.getSelectedItem_idRetorno());
        vo.setModelo(_TxtModeloMaquina.getText());
        vo.setId(-1);
        List<Validacion> validaciones = 
                this.coordinador.maquinaModeloValidarCampos(vo);
        
        boolean todoValido = true;
        boolean modeloYAnioMal = false;
        MaquinaModeloIT iT = new MaquinaModeloIT();
        for (Validacion validacione : validaciones) {
            //VALIDAMOS QUE EL MODELO Y EL AÑO NO ESTEN REGISTRADOS JUNTOS.
            if (validacione.getNombreDeCampo().equals(iT.getModeloPDC().getNombre())) {
               if (!validacione.isValido()) {
                   _TxtAnio.setError();
                   _TxtModeloMaquina.setError(validacione.getMensajeDeError());
                   modeloYAnioMal = true;
                   
               }else{
                   _TxtModeloMaquina.setErrorQuitar();
                   _TxtAnio.setErrorQuitar();
               }
            }
            
            //QUE EL FORMATO DE LA FECHA SEA CORRECTO.
            if (validacione.getNombreDeCampo().equals(iT.getAnioPDC().getNombre())) {
                if (!validacione.isValido()) {
                    _TxtAnio.setError(validacione.getMensajeDeError());
                    
                }else{
                    if (!modeloYAnioMal) {
                        _TxtAnio.setErrorQuitar();
                    }
                }
            }
            
            //QUE EL ITEM NO ESTE REPETIDO. ESTE CREO QUE CASI NO SE OCUPARA. 
            
            if (validacione.getNombreDeCampo().equals(iT.getIdProoveedorPDC().getNombre())) {
                if (!validacione.isValido()) {
                    _ComboMarca.setError(validacione.getMensajeDeError());
                    
                }else{
                    _ComboMarca.setErrorQuitar();
                }
            }
            
            if(!validacione.isValido()){
                todoValido = false;
            }
        }
        if (todoValido) {
            coordinador.maquinaModeloGuardar(vo);
            JOptionPane.showMessageDialog(null,"Se guardo correctamente el modelo.");
            limpiarTodo();
            this.getCoordinador().ejecutarOperacionesParaActualizar(MaquinaModeloIT.NOMBRE_TABLA);
            dispose();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogoMaquinaModeloAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogoMaquinaModeloAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogoMaquinaModeloAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogoMaquinaModeloAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogoMaquinaModeloAgregar dialog = new DialogoMaquinaModeloAgregar();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
               dialog.setVisible(true);
            } 
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboMarca;
    private javax.swing.JLabel etiquetaAno;
    private javax.swing.JLabel etiquetaMarca;
    private javax.swing.JLabel etiquetaModeloMaquina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtModeloMaquina;
    // End of variables declaration//GEN-END:variables
}
