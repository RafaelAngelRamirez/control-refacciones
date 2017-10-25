
package vista.panels;

import controlador.CoordinadorPaneles;
import java.util.HashMap;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.FechaYHora;
import modelo.InfoTabla.DepartamentoIT;
import modelo.InfoTabla.EmpleadoIT;
import modelo.logica.Validacion;
import modelo.vo.DepartamentoVo;
import modelo.vo.EmpleadoVo;
import vista.UtilidadesIntefaz.ConfiguracionDePanel;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesBotones_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesComboBox_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesTxt_;

/**
 *
 * @author Particular
 */
public class PanelEmpleadoAgregar extends vista.UtilidadesIntefaz.JPanelBase{

    private static final long serialVersionUID = 1L;
    
    UtilidadesTxt_ _txtNombre;
    UtilidadesComboBox_ _comboDepartamentos;
    boolean empleadoAdelantado= false;
    
   
    /**
     * Creates new form DialogoAgregarEmpleado
     */
    public PanelEmpleadoAgregar() {
        initComponents();
        configuracionesDialogo = new ConfiguracionDePanel();
        configuracionesDialogo.setModal(true);
        configuracionesDialogo.setResizable(false);
        configuracionesDialogo.setTitle(CoordinadorPaneles.PANEL_EMPLEADO_AGREGAR);
        configuracionesDialogo.setLocationRelativeTo(null);
        configuracionesDialogo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        etiquetaNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        etiquetaDepartamento = new javax.swing.JLabel();
        comboDepartamento = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(2, 10), new java.awt.Dimension(2, 10), new java.awt.Dimension(2, 10));

        jLabel2.setBackground(new java.awt.Color(98, 15, 89));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_titulo_agregar empleado.png"))); // NOI18N

        etiquetaNombre.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaNombre.setText("Nombre");

        txtNombre.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setMaximumSize(new java.awt.Dimension(395, 2147483647));
        txtNombre.setMinimumSize(new java.awt.Dimension(395, 35));

        etiquetaDepartamento.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaDepartamento.setText("Departamento");

        comboDepartamento.setEditable(true);
        comboDepartamento.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        comboDepartamento.setMinimumSize(new java.awt.Dimension(195, 32));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etiquetaNombre)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(etiquetaDepartamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboDepartamento, javax.swing.GroupLayout.Alignment.LEADING, 0, 195, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiquetaDepartamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCancelar)
                                .addComponent(btnGuardar))
                            .addComponent(comboDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    @Override
    public void configurar(){
        configurar("");
    }

    @Override
    public void initConfig() {
         /*
        =======================================================================
            INICIO SETEO NOMBRES DE ETIQUETA
        ///////////////////////////////////////////////////////////////////////
        */
        EmpleadoIT eit = new EmpleadoIT();
        DepartamentoIT dit = new DepartamentoIT();
        
        etiquetaDepartamento.setText(dit.getDEPARTAMENTO().getNombreParaMostrar());
        etiquetaNombre.setText(eit.getNOMBRE().getNombreParaMostrar());
        
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
       
        _txtNombre = new UtilidadesTxt_(getCoordinador());
        _comboDepartamentos = new UtilidadesComboBox_(getCoordinador());
        
        
        //SETEAMOS LOS COMPONENTES DENTRO DE LA UTILIDAD.
        _txtNombre.setComponente(txtNombre);
        _comboDepartamentos.setComponente(comboDepartamento);
       
        //ASIGNAMOS EL TAMAÑO DE CAMPO
        
        _txtNombre.setTamanoDeCampo(eit.getNOMBRE().getLongitudDeCaracteres());
        _comboDepartamentos.setTamanoDeCampo(dit.getDEPARTAMENTO().getLongitudDeCaracteres());

        //CAMPOS QUE REQUIEREN TEXTO EN MAYUSCULAS.
        _txtNombre.setPermitirSoloMayusculas();
        _comboDepartamentos.setPermitirSoloMayusculas();
        
        //QUITAMOS LOS ESPACIOS SOBRANTES DESPUES DE DEJAR EL CAMPO.
        _txtNombre.setEspaciosEnBlanco();
        _comboDepartamentos.setEspaciosEnBlanco();
        
        //ACCIONES ESPECELIALES.
        _comboDepartamentos.setFocusAction(()->guardarDepartamento(), false);
        
        //ACCIONES DE BOTONES
        UtilidadesBotones_.setEnterYEspacio(btnCancelar);
        UtilidadesBotones_.setEnterYEspacio(btnGuardar);
        
        //OPERACIONES DE ACTUALIZACIÓN.
        opAct.add(DepartamentoIT.NOMBRE_TABLA, this::cargarComboDepartamentos);
        
        
        /* 
        ////////////////////////////////////////////////////////////////////////
            FIN SETEO DE UTILIDADES
        ========================================================================
        */
        
    }
    
    
    
    /**
     * Cofiguraciones para el dialogo.  
     * @param empleadoAdelantado El nombre del empleado para rellenar. 
     */
    public void configurar(String empleadoAdelantado){
       
        /*
        =======================================================================
            INICIO CARGA DE ELEMENTOS 
        ///////////////////////////////////////////////////////////////////////
        */
        _txtNombre.setText(empleadoAdelantado);
//        this.cargarComboDepartamentos();
            
        if (!empleadoAdelantado.equals("")) {
            this.empleadoAdelantado = true;
        }
            
        
        /* 
        ////////////////////////////////////////////////////////////////////////
            FIN CARGA DE ELEMENTOS 
        ========================================================================
        */    
    
    }
    
        
    private boolean guardarDepartamento(){
        String elementoEscrito = this._comboDepartamentos.getText();
        if (this._comboDepartamentos.contieneElItemEscrito()) {
            this._comboDepartamentos.setSelectedItem(elementoEscrito);
            return true;
        }else{
            this._comboDepartamentos.setErrorQuitar();
            if (!elementoEscrito.equals("")) {
                if (this._comboDepartamentos.contieneElItemEscrito(elementoEscrito)) {
                    this._comboDepartamentos.setSelectedItem(elementoEscrito);
                }else{
                    int respuesta = JOptionPane.showConfirmDialog(this,
                            "¿Estas segúro que quieres guardar \n "
                           + " el nuevo departamento \" "+this._comboDepartamentos.getText()+"\"?", 
                            "Guardar nuevo departamento.", JOptionPane.YES_NO_OPTION);
                    if (respuesta==JOptionPane.YES_OPTION) {
                        DepartamentoVo vo = new DepartamentoVo();
                        vo.setDepartamento(this._comboDepartamentos.getText());
                        this.getCoordinador().departamentoGuardar(vo);
                    }else{
                        this._comboDepartamentos.setText("");
                    }
                }
            }
        }
        this.cargarComboDepartamentos();
        this._comboDepartamentos.setSelectedItem(elementoEscrito);
        return true;
        
    }
    
    public void cargarComboDepartamentos(){
        List<DepartamentoVo> listaDepartamentos = this.getCoordinador().departamentoConsultarTodo();
        HashMap<String, Object> datosDepartamentos = new HashMap<>();
        for (DepartamentoVo vo : listaDepartamentos) {
            datosDepartamentos.put(vo.getDepartamento(), vo.getId());
        }
        _comboDepartamentos.cargarCombo(datosDepartamentos);
    
    }
    
    public void limpiar(){
        _txtNombre.setText("");
        _comboDepartamentos.limpiar();
        
        _txtNombre.setErrorQuitar();
        _comboDepartamentos.setErrorQuitar();
    }
    
    public boolean cancelar(){
        this.dispose();
        boolean todoVacio = true;
        if (!_txtNombre.isEmpty() ||
            !_comboDepartamentos.isEmpty()) {
            todoVacio=false;
        }
        if (todoVacio) {
            limpiar();
            this.dispose();
            return true;
            
        } else {
            if (empleadoAdelantado && !_txtNombre.isEmpty()) {
                this.getCoordinador().entradaLoteDialogoSetearItemComboRecienAgregado(_txtNombre.getText());
            }
            this.limpiar();
            this.dispose();
            
        }
        return true;
    }
    

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        EmpleadoVo vo = new EmpleadoVo();
        vo.setNombre(_txtNombre.getText());
        vo.setIdDepartamento(_comboDepartamentos.getSelectedItem_idRetorno());
        vo.setBajaEmpleado((byte)0);
        
        vo.setFechaAlta(FechaYHora.Actual.getFecha_DateSQL());
        
        
        List<Validacion> validaciones = this.getCoordinador().empleadoValidarCampos(vo);
        DepartamentoIT it = new DepartamentoIT();
        
        boolean todoValido = true;
        
        for (Validacion val : validaciones) {
            if (val.getNombreDeCampo().equals(it.getDEPARTAMENTO().getNombre())) {
                if (!val.isValido()) {
                    _txtNombre.setError(val.getMensajeDeError());
                }else{
                    _txtNombre.setErrorQuitar();
                }
            }
            
            if (!val.isValido()) {
                String mensaje = val.getNombreDeCampo()+":"+val.getMensajeDeError();
                JOptionPane.showMessageDialog(this, mensaje);
                todoValido = false;
            }
        }
        
        if (todoValido) {
            //GUARDAMOS EL EMPLEADO.
            if (this.getCoordinador().empleadoGuardar(vo)) {
                limpiar();
                JOptionPane.showMessageDialog(this, "Se guardo correctamente el empleado.");
                if (empleadoAdelantado) {
                    getCoordinador().actualizarTodoLoVisible();
                    this.getCoordinador().entradaLoteDialogoSetearItemComboRecienAgregado(vo.getNombre());
                    this.dispose();
                    
                }
                getCoordinador().actualizarTodoLoVisible();
            }else{
                JOptionPane.showMessageDialog(this, 
                        "Algo sucedio y no se guardo el empleado.", 
                        "No se guardo el empleado.", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

   
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboDepartamento;
    private javax.swing.JLabel etiquetaDepartamento;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
