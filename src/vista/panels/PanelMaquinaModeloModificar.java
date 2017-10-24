
package vista.panels;

import controlador.CoordinadorPaneles;
import java.util.HashMap;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.InfoTabla.MaquinaModeloIT;
import modelo.InfoTabla.ProveedorIT;
import modelo.logica.Validacion;
import modelo.vo.MaquinaModeloVo;
import modelo.vo.ProveedorVo;
import vista.UtilidadesIntefaz.ConfiguracionDePanel;
import vista.UtilidadesIntefaz.ConfirmacionExahustiva;
import vista.UtilidadesIntefaz.JPanelBase;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesBotones_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesComboBox_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesListas_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesTxt_;

/**
 * Este dialogo permite modificar una MaquinaModelo. 
 * @author Particular
 */
public class PanelMaquinaModeloModificar extends JPanelBase {

    private static final long serialVersionUID = 1L;
    private UtilidadesTxt_ _TxtAnio;
    private UtilidadesTxt_ _TxtModeloMaquina;
    private UtilidadesComboBox_ _ComboMarca;
    private UtilidadesListas_ _ListaMaquinaModelo;
    
    private int idConsultandoseActualmente;
            
    /** Inicializa opciones del dialogo. */
    public PanelMaquinaModeloModificar() {
        initComponents();
        configuracionesDialogo = new ConfiguracionDePanel();
        configuracionesDialogo.setModal(true);
        configuracionesDialogo.setResizable(false);
        configuracionesDialogo.setTitle(CoordinadorPaneles.PANEL_MAQUINA_MODELO_MODIFICAR);
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
        
        _TxtAnio = new UtilidadesTxt_ (getCoordinador());
        _TxtModeloMaquina = new UtilidadesTxt_ (getCoordinador());
        _ComboMarca = new UtilidadesComboBox_ (getCoordinador());
        _ListaMaquinaModelo = new UtilidadesListas_(getCoordinador());
        
        
        //SETEAMOS LOS COMPONENTES DENTRO DE LA UTILIDAD.
        
        _TxtAnio.setComponente(txtAnio);
        _TxtModeloMaquina.setComponente(txtModeloMaquina);
        _ComboMarca.setComponente(comboMarca);
        _ListaMaquinaModelo.setComponente(listaMaquinanasModelo);
       
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
        _ListaMaquinaModelo.setValueChange(()->this.cargarDatosConsultados());
        
        //ACCIONES DE BOTONES
        UtilidadesBotones_.setEnterYEspacio(btnCancelar);
        UtilidadesBotones_.setEnterYEspacio(btnGuardar);
        
        //OPERACIONES DE ACTUALIZACIÓN.
        opAct.add(ProveedorIT.NOMBRE_TABLA, this::cargarComboMarca);
        opAct.add(MaquinaModeloIT.NOMBRE_TABLA, this::cargarListaMaquinaModelo);
        
        /* 
        ////////////////////////////////////////////////////////////////////////
            FIN SETEO DE UTILIDADES
        ========================================================================
        */
        
        
    }
    
    @Override
    public void configurar(){
        
        /*
        =======================================================================
            INICIO CARGA DE ELEMENTOS 
        ///////////////////////////////////////////////////////////////////////
        */
//            cargarCombosYListas();
        
        /* 
        ////////////////////////////////////////////////////////////////////////
            FIN CARGA DE ELEMENTOS 
        ========================================================================
        */
    }

    public void guardarProoveedor(){
        String proveedor = _ComboMarca.getText();
        if (!proveedor.equals("")) {
            if (this.getCoordinador().proveedorExiste(proveedor)) {
                _ComboMarca.setSelectedItem(proveedor);
            }else{
                int r = JOptionPane.showConfirmDialog(this,
                    "¿Estas segúro que quieres agregar '"+proveedor+"' "
                    + "\n como proveedor-empresa nueva?",
                    "¿Guardar nuevo proveedor-empresa?", 
                    JOptionPane.YES_NO_OPTION);

                if (r==0) {
                    this.getCoordinador().proveedoresAbrirDialogo(proveedor);
                    this.cargarComboMarca();
                    _ComboMarca.setSelectedItem(proveedor);
                    
                }else{
                    _ComboMarca.setText("");
                }
            }
        }
    }
    
    public void cargarComboMarca(){
        List<ProveedorVo> l = this.getCoordinador().proveedoresConsultarMarcas();
        HashMap<String, Object> map = new HashMap<>();
        
        for (ProveedorVo vo : l) {
            map.put(vo.getEmpresa(), vo.getId());
        }


        _ComboMarca.cargarCombo(map);
    
    }
    
    public void cargarListaMaquinaModelo(){
        List<MaquinaModeloVo> lista = this.getCoordinador().maquinaModeloConsultar();
        HashMap<String, Object> datos = new HashMap<>();
        _ListaMaquinaModelo.limpiar();
        for (MaquinaModeloVo vo : lista) {
            String modeloAnio = vo.getModelo() + " " +vo.getAnio();
            datos.put(modeloAnio, vo.getId());
        }
        
        
        _ListaMaquinaModelo.cargarLista(datos);
    }
    
//    public void cargarCombosYListas(){
//        cargarComboMarca();
//        cargarListaMaquinaModelo();
//    }
//    
    private void limpiarTodo(){
        this._TxtModeloMaquina.setText("");
        this._TxtAnio.setText("");
        this._ComboMarca.setText("");
        
        this._TxtModeloMaquina.setErrorQuitar();
        this._TxtAnio.setErrorQuitar();
        this._ComboMarca.setErrorQuitar();
    }
    
    public void cargarDatosConsultados(){
        limpiarTodo();
        idConsultandoseActualmente = (int)_ListaMaquinaModelo.getSelectValueObject();
        if (idConsultandoseActualmente!=-1) {
            MaquinaModeloVo vo = 
                    this.getCoordinador()
                            .maquinaModeloConsultarUno(idConsultandoseActualmente);

            _TxtModeloMaquina.setText(vo.getModelo());
            _TxtAnio.setText(vo.getAnio()+"");
            _ComboMarca.setSelectedItem(vo.getIdProveedor()+"");
            
        }
    
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        etiquetaModeloMaquina = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        etiquetaAno = new javax.swing.JLabel();
        comboMarca = new javax.swing.JComboBox<>();
        etiquetaMarca = new javax.swing.JLabel();
        txtModeloMaquina = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaMaquinanasModelo = new javax.swing.JList<>();
        btnCancelar1 = new javax.swing.JButton();

     






        jLabel1.setBackground(new java.awt.Color(104, 127, 13));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_titulo_agregar modelo maquina.png"))); // NOI18N
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
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_palomita.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_tache.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        listaMaquinanasModelo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        listaMaquinanasModelo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaMaquinanasModelo.setFocusable(false);
        listaMaquinanasModelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMaquinanasModeloMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listaMaquinanasModelo);

        btnCancelar1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_tache.png"))); // NOI18N
        btnCancelar1.setText("Eliminar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addComponent(txtModeloMaquina, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnCancelar1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar1)
                .addGap(8, 8, 8)
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

        
    }// </editor-fold>//GEN-END:initComponents

    private void txtAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioActionPerformed

    private void txtModeloMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloMaquinaActionPerformed
        // TODO add your haasdfndling casdode here:
    }//GEN-LAST:event_txtModeloMaquinaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        
        if (_ListaMaquinaModelo.getThis().isSelectionEmpty() ) {
            JOptionPane.showMessageDialog(this, "No has seleccionado ningún elemento de la lista.");
        }else{
        
            MaquinaModeloVo vo = new MaquinaModeloVo();
            String a = _TxtAnio.getText();
            //NO PUEDES PASAR UN INT NULO.
            if (a.equals("")) {
                vo.setAnio(-1);
            }else{
                vo.setAnio(Integer.parseInt(a));
            }
            vo.setId(this.idConsultandoseActualmente);
            vo.setIdProveedor(_ComboMarca.getSelectedItem_idRetorno());
            vo.setModelo(_TxtModeloMaquina.getText());

            List<Validacion> validaciones =
            this.getCoordinador().maquinaModeloValidarCampos(vo, true);

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
                if (this.getCoordinador().maquinaModeloModificar(vo)) {

                    limpiarTodo();
//                    cargarListaMaquinaModelo();
                    getCoordinador().actualizarTodoLoVisible();
                    _ListaMaquinaModelo.getThis().setSelectedValue(vo.getModelo()+" "+vo.getAnio(), true);
                    JOptionPane.showMessageDialog(
                        this,
                        "Se modifico correctamente la refacción.");
                }else{
                    JOptionPane.showMessageDialog(
                            this, 
                            "No se pudo modificar el modelo.", 
                            "Error modificando el modelo", 
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed
    private void cancelar(){
        limpiarTodo();
        this.dispose();
    }
    private void listaMaquinanasModeloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMaquinanasModeloMouseClicked

    }//GEN-LAST:event_listaMaquinanasModeloMouseClicked

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        MaquinaModeloVo vo = new MaquinaModeloVo();
        if (!_ListaMaquinaModelo.getSelectValueObject().equals(-1)) {
            vo.setId(this.idConsultandoseActualmente);
            vo.setModelo(this._TxtModeloMaquina.getText());
            vo.setAnio(Integer.parseInt(this._TxtAnio.getText()));
            if (vo.getId()!=-1) {

                String msj1 =  "¿Estas segúro que quieres eliminar este modelo?\n "
                        + "Esta acción no se puede deshacer.";
                String msj2 = "Estas MUY SEGÚRO que quieres eliminar este modelo de máquina? Esto perjudicará todos los registros y el historial que pudo \n"
                        + "formarse durante el tiempo que se ha utilizado.";

                int r = ConfirmacionExahustiva.confirmarEliminacionPeligrosa(msj1, msj2);

                if (r==ConfirmacionExahustiva.SI_ELIMINAR) {
                    if(this.getCoordinador().maquinaModeloEliminar(vo)){
                        this.limpiarTodo();
    //                    cargarCombosYListas();
                        getCoordinador().actualizarTodoLoVisible();
                        JOptionPane.showMessageDialog(
                                this, 
                                "Se eliminó '"+vo.getModelo()+" "+vo.getAnio()+"' correctamente.");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.cancelar();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboMarca;
    private javax.swing.JLabel etiquetaAno;
    private javax.swing.JLabel etiquetaMarca;
    private javax.swing.JLabel etiquetaModeloMaquina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listaMaquinanasModelo;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtModeloMaquina;
    // End of variables declaration//GEN-END:variables

}
