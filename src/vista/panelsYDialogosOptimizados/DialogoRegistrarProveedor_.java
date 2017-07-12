/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.panelsYDialogosOptimizados;

import controlador.Coordinador;
import java.util.HashMap;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.InfoTabla.PaisIT;
import modelo.InfoTabla.ProveedorIT;
import modelo.logica.Validacion;
import modelo.vo.PaisVo;
import modelo.vo.ProveedorVo;
import vista.utilidadesOptimizadas.*;

/**
 *
 * @author Particular
 */
public class DialogoRegistrarProveedor_ extends JDialog {
    private Coordinador coordinador;
    
    String proveedorPrecargado;
    UtilidadesTxt_ _TxtEmpresa;
    UtilidadesTxt_ _TxtNombreContacto;
    UtilidadesTxt_ _TxtTelefono;
    UtilidadesTxt_ _TxtPaginaWeb;
    UtilidadesTxt_ _TxtEmail;
    UtilidadesComboBox_ _ComboPais;
    
    /**
     * Creates new form RegistrarProveedort
     */
    public DialogoRegistrarProveedor_() {
        initComponents();
    }
    
    /**
     * Configuraciones para el dialogo.  
     */
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
        setTitle("Registrar nuevo proveedor");
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
        
        //SETEAMOS LOS COMPONENTES DENTRO DE LA UTILIDAD.
        _TxtEmpresa.setComponente(txtEmpresa);
        _TxtNombreContacto.setComponente(txtNombreContacto); 
        _TxtTelefono.setComponente(txtTelefono); 
        _TxtPaginaWeb.setComponente(txtPaginaWeb); 
        _TxtEmail.setComponente(txtEmail); 
        _ComboPais.setComponente(comboPais);
       
        //ASIGNAMOS EL TAMAÑO DE CAMPO
        _TxtEmpresa.setTamanoDeCampo(pit.getEmpresaProveedorPDC().getLongitudDeCaracteres());
        _TxtNombreContacto.setTamanoDeCampo(pit.getNombreContactoPDC().getLongitudDeCaracteres());
        _TxtTelefono.setTamanoDeCampo(pit.getTelefonoPDC().getLongitudDeCaracteres());
        _TxtPaginaWeb.setTamanoDeCampo(pit.getPaginaWebPDC().getLongitudDeCaracteres());
        _TxtEmail.setTamanoDeCampo(pit.getEmailPDC().getLongitudDeCaracteres());
        _ComboPais.setTamanoDeCampo(paisit.getPaisPDC().getLongitudDeCaracteres());
        
        //CAMPOS QUE REQUIEREN TEXO EN MAYUSCULAS.
        _TxtEmpresa.setMayusculas();
        _TxtNombreContacto.setMayusculas();
        _ComboPais.setMayusculas();
        
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
            this.cargarComboPaises();
        
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

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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
        




        






        










        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_titulo_agregar proveedor.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(btnCancelar)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                            .addComponent(comboPais, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaEmpresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    private void limpiarTodo(){
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
                this.setVisible(false);
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
                        this.coordinador.paisGuardar(vo);
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
        ProveedorVo vo = new ProveedorVo();
        vo.setId(-1);
        vo.setEmail(_TxtEmail.getText());
        vo.setEmpresa(_TxtEmpresa.getText());
        vo.setIdPais(_ComboPais.getSelectedItem_idRetorno());
        vo.setNombreContacto(_TxtNombreContacto.getText());
        vo.setPaginaWeb(_TxtPaginaWeb.getText());
        vo.setTelefono(_TxtTelefono.getText());

        List<Validacion> validaciones = this.coordinador.proveedorValidarCampos(vo);
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
                String mensaje = validacione.getNombreDeCampo()+":"+validacione.getMensajeDeError();
                JOptionPane.showMessageDialog(null, mensaje);
                todoValido = false;
            }
        }
        
        if (todoValido) {
            this.coordinador.proveedorGuardar(vo);
            this.limpiarTodo();
            this.dispose();
            this.coordinador.proveedorActualizarLista();
            
            
            JOptionPane.showMessageDialog(
                    this.coordinador.getMarcoParaVentanaPrincipal(), 
                    "Se guardo correctamente el proveedor.");
        }
        
        
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.cancelar();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
    }//GEN-LAST:event_formWindowActivated

    private void cargarComboPaises(){
        List<PaisVo> listaPaises = this.coordinador.PaisConsultar();
        HashMap<String, Integer> datosPaises = new HashMap<>();
        for (PaisVo listaPaise : listaPaises) {
            datosPaises.put(listaPaise.getPais(), listaPaise.getId());
        }
        this._ComboPais.cargarCombo(datosPaises);
        
    }
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
            java.util.logging.Logger.getLogger(DialogoRegistrarProveedor_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogoRegistrarProveedor_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogoRegistrarProveedor_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogoRegistrarProveedor_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DialogoRegistrarProveedor_().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboPais;
    private javax.swing.JLabel etiquetaEmail;
    private javax.swing.JLabel etiquetaEmpresa;
    private javax.swing.JLabel etiquetaNombrecontacto;
    private javax.swing.JLabel etiquetaPaginaWeb;
    private javax.swing.JLabel etiquetaPais;
    private javax.swing.JLabel etiquetaTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtNombreContacto;
    private javax.swing.JTextField txtPaginaWeb;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
