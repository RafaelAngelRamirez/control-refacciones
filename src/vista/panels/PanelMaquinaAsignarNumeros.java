/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.panels;

import controlador.CoordinadorPaneles;
import java.util.HashMap;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.InfoTabla.MaquinaIT;
import modelo.InfoTabla.MaquinaModeloIT;
import modelo.logica.Validacion;
import modelo.vo.MaquinaHistorialNombresVO;
import modelo.vo.MaquinaModeloVo;
import modelo.vo.MaquinaVo;
import vista.UtilidadesIntefaz.ConfiguracionDePanel;
import vista.UtilidadesIntefaz.ConfirmacionExahustiva;
import vista.UtilidadesIntefaz.JPanelBase;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesBotones_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesComboBox_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesListas_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesTxt_;

/**
 *
 * @author Particular
 */
public class PanelMaquinaAsignarNumeros extends JPanelBase {

    private static final long serialVersionUID = 1L;
    
    private UtilidadesTxt_ _txtNombre;
    private UtilidadesTxt_ _txtMatricula;
    private UtilidadesComboBox_ _comboMaquinaModelo;
    private UtilidadesListas_ _listaMaquinas;
    
    

    /**
     * Creates new form PanelMaquinaAsignarNumeros
     */
    public PanelMaquinaAsignarNumeros() {
        initComponents();
        configuracionesDialogo = new ConfiguracionDePanel();
        configuracionesDialogo.setModal(true);
        configuracionesDialogo.setResizable(false);
        configuracionesDialogo.setTitle(CoordinadorPaneles.PANEL_MAQUINA_ASIGNAR_NUMERO);
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

        etiquetaNombreDeLaRefaccion1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaMaquinas = new javax.swing.JList<>();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        etiquetaMatricula = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        comboModelos = new javax.swing.JComboBox<>();
        etiquetaPais = new javax.swing.JLabel();
        btnCancelar1 = new javax.swing.JButton();
        txtMatricula = new javax.swing.JTextField();
        etiquetaNombre = new javax.swing.JLabel();

        etiquetaNombreDeLaRefaccion1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaNombreDeLaRefaccion1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_titulo_maquina asignar numero.png"))); // NOI18N

        listaMaquinas.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        listaMaquinas.setFocusable(false);
        jScrollPane5.setViewportView(listaMaquinas);

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

        btnEliminar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_tache.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        etiquetaMatricula.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaMatricula.setText("Matricula");

        txtNumero.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtNumero.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumero.setMaximumSize(new java.awt.Dimension(395, 2147483647));
        txtNumero.setMinimumSize(new java.awt.Dimension(395, 35));

        comboModelos.setEditable(true);
        comboModelos.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        comboModelos.setMinimumSize(new java.awt.Dimension(195, 32));

        etiquetaPais.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaPais.setText("Modelo");

        btnCancelar1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_limpiar.png"))); // NOI18N
        btnCancelar1.setText("Limpiar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        txtMatricula.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtMatricula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMatricula.setMaximumSize(new java.awt.Dimension(395, 2147483647));
        txtMatricula.setMinimumSize(new java.awt.Dimension(395, 35));

        etiquetaNombre.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaNombre.setText("Número");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiquetaNombreDeLaRefaccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaMatricula)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaPais)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                                .addComponent(btnCancelar1))
                            .addComponent(comboModelos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar))
                    .addComponent(txtMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaNombreDeLaRefaccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(etiquetaPais)
                                    .addComponent(etiquetaNombre)))
                            .addComponent(btnCancelar1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboModelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etiquetaMatricula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnCancelar)
                            .addComponent(btnEliminar))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarMaquina();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       
        this.eliminarMaquina();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        limpiar();
        cargarLista();
        cargarCombo();
    }//GEN-LAST:event_btnCancelar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboModelos;
    private javax.swing.JLabel etiquetaMatricula;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaNombreDeLaRefaccion1;
    private javax.swing.JLabel etiquetaPais;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<String> listaMaquinas;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables

    private void cancelar() {
        limpiar();
        dispose();
    }

    @Override
    public void initConfig() {
         /*
        =======================================================================
            INICIO SETEO NOMBRES DE ETIQUETA
        ///////////////////////////////////////////////////////////////////////
        */
        MaquinaIT it = new MaquinaIT();
        MaquinaModeloIT mmit = new MaquinaModeloIT();
        etiquetaNombre.setText(it.getNumeroDeMaquinaPDC().getNombreParaMostrar());
        etiquetaMatricula.setText(it.getMatriculaPDC().getNombreParaMostrar());
        
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
        _txtMatricula = new UtilidadesTxt_(getCoordinador());
        _listaMaquinas = new UtilidadesListas_(getCoordinador());
        _comboMaquinaModelo = new UtilidadesComboBox_(getCoordinador());
        
        //SETEAMOS LOS COMPONENTES DENTRO DE LA UTILIDAD.
        
        _comboMaquinaModelo.setComponente(comboModelos);
        _listaMaquinas.setComponente(listaMaquinas);
        _txtNombre.setComponente(txtNumero);
        _txtMatricula.setComponente(txtMatricula);
        
        //ASIGNAMOS EL TAMAÑO DE CAMPO
        _txtNombre.setTamanoDeCampo(it.getNumeroDeMaquinaPDC().getLongitudDeCaracteres());
        _txtMatricula.setTamanoDeCampo(it.getMatriculaPDC().getLongitudDeCaracteres());
        _comboMaquinaModelo.setTamanoDeCampo(mmit.getModeloPDC().getLongitudDeCaracteres());
        
        
        //CAMPOS QUE REQUIEREN TEXTO EN MAYUSCULAS.
        _txtNombre.setPermitirSoloMayusculas();
        _txtMatricula.setPermitirSoloMayusculas();
        _comboMaquinaModelo.setPermitirSoloMayusculas();
        
        //CAMPOS NUMÉRICOS
        
        
        //QUITAMOS LOS ESPACIOS SOBRANTES DESPUES DE DEJAR EL CAMPO.
        _txtNombre.setEspaciosEnBlanco();
        _txtMatricula.setEspaciosEnBlanco();

        //TRAVEL POLICY
        _txtNombre.setNextFocusableComponent(_comboMaquinaModelo.getThis());
        _comboMaquinaModelo.setNextFocusableComponent(_txtMatricula.getThis());
        _txtMatricula.setNextFocusableComponent(btnGuardar);
        btnGuardar.setNextFocusableComponent(btnCancelar);
        btnCancelar.setNextFocusableComponent(btnEliminar);
        btnEliminar.setNextFocusableComponent(_txtNombre.getThis());
        
        
        
        //ACCIONES ESPECELIALES.
        _listaMaquinas.setValueChange(this::cargarDatosDeListaParaModificar);
        _comboMaquinaModelo.setFocusAction(()->this.abrirGuardarNuevoModelo(), false);
        
        //ACCIONES DE BOTONES
        UtilidadesBotones_.setEnterYEspacio(btnCancelar);
        UtilidadesBotones_.setEnterYEspacio(btnEliminar);
        UtilidadesBotones_.setEnterYEspacio(btnGuardar);
        
        
        //OPERACIONES DE ACTUALIZACION
        
        opAct.add(MaquinaIT.NOMBRE_TABLA, this::cargarLista);
        opAct.add(MaquinaModeloIT.NOMBRE_TABLA, this::cargarCombo);
        
        
        /* 
        ////////////////////////////////////////////////////////////////////////
            FIN SETEO DE UTILIDADES
        ========================================================================
        */

    }

    @Override
    public void configurar() {
    }

    
    @Override
    public void limpiar() {
        idMaquinaActual = null;
        _txtNombre.setText();
        _listaMaquinas.limpiar();
    }
    
    MaquinaVo idMaquinaActual;
    /**
     * Carga las máquinas existententes de la lista a los campos para modificarlos. 
     * 
     */
    public void cargarDatosDeListaParaModificar(){
        Object o = _listaMaquinas.getSelectValueId();
        if (!o.equals(-1)) {
            MaquinaVo vo = (MaquinaVo)o;
            _txtNombre.setText(vo.getNumeroDeMáquina());
            _comboMaquinaModelo.setSelectedItem(vo.getIdMaquinaModelo());
            _txtMatricula.setText(vo.getMatricula());
            idMaquinaActual = vo;
        }
    }
    
    /**
     * Carga las máquinas en la lista. 
     */
    public void cargarLista(){
        _listaMaquinas.limpiar();
        List<MaquinaVo> list;
        list = getCoordinador().maquinaConsultar();
        
        HashMap<String, Object> mapa = new HashMap<>();
        for (MaquinaVo vo : list) {
            mapa.put(
                "No. "+vo.getNumeroDeMáquina() + " " +vo.getIdMaquinaModelo() + " "+vo.getMatricula(), vo);
        }
        _listaMaquinas.cargarLista(mapa);
        
    }
    
    /**
     * Carga los modelos en el combo. 
     */
    public void cargarCombo(){
        _comboMaquinaModelo.limpiar();
        List<MaquinaModeloVo> list = getCoordinador().maquinaModeloConsultar();
        HashMap<String, Object> mapa = new HashMap<>();
        
        for (MaquinaModeloVo vo : list) {
            mapa.put(vo.getModelo()+" "+vo.getAnio(), vo);
        }
        _comboMaquinaModelo.cargarCombo(mapa);
        
    }

    private void eliminarMaquina() {
        Object o = _listaMaquinas.getSelectValueId();
        if (!o.equals(-1)) {
            MaquinaVo vo = (MaquinaVo) o;
            String msj1 = "¿Estas segúro que quieres eliminar la máquina "
                            + "\""+vo.getNumeroDeMáquina()+"\"?. \n"
                            + "Esta acción no se puede deshacer y eliminara "
                                    + "todos los registros relacionados con esta máquina.";
                
            String msj2 =   "¿Estas MUY SEGURO que quieres eliminar esta máquina? Esto perjudicará todos los registros y el historial que puede \n"
                            + "haberse formado durante el tiempo que se ha utilizado.";
            int r = ConfirmacionExahustiva.confirmarEliminacionPeligrosa(msj1, msj2);
            if(r==ConfirmacionExahustiva.SI_ELIMINAR){
                    if(getCoordinador().maquinaEliminar(vo)){
                        _txtNombre.setText();
                        getCoordinador().actualizarTodoLoVisible();
                        JOptionPane.showMessageDialog(this, "Se elimino la máquina correctamente.");
                    }else{
                        JOptionPane.showMessageDialog(this, "Algo paso y no se pudo eliminar la máquina.");
                    }
            }
        }
    }

    private void guardarMaquina() {
        boolean todoValido = true;
        MaquinaVo vo = new MaquinaVo();
        
        if (_txtNombre.isEmpty()) {
            _txtNombre.setError("Debes definir un número o nombre.");
            todoValido = false;
        }else{
            _txtNombre.setErrorQuitar();
            todoValido = true;
        }
        
        boolean modOGuar = true;
        List<Validacion> listValidacion;
        if (todoValido) {
            vo.setNumeroDeMáquina(_txtNombre.getText());
                       
            if (idMaquinaActual!=null) {
                MaquinaVo v = (MaquinaVo) _listaMaquinas.getSelectValueId();
                MaquinaModeloVo eVo = (MaquinaModeloVo)_comboMaquinaModelo.getSelectedItem_idRetorno();
                vo.setId(idMaquinaActual.getId());
                vo.setIdMaquinaModelo(eVo.getId());
                vo.setNumeroDeMáquina(_txtNombre.getText());
                vo.setMatricula(_txtMatricula.getText());
                
                modOGuar = true;
            }else{
                MaquinaModeloVo eVo = (MaquinaModeloVo)_comboMaquinaModelo.getSelectedItem_idRetorno();
                vo.setId(-1);
                vo.setIdMaquinaModelo(eVo.getId());
                vo.setNumeroDeMáquina(_txtNombre.getText());
                vo.setMatricula(_txtMatricula.getText());
                modOGuar = false;
            
            }
            listValidacion = getCoordinador().maquinaValidarCampos(vo);
            
            //EL NÚMERO DE MÁQUINA EXISTE SIN TOMAR EN CUENTA A SÍ MISMO. AQUI
            // ES OTRA OPERACÍON DIFERENTE QUE LA DE maquinaExiste(). Ojo. ESTA
            // OTRA OPERACIÓ ES MAQUINA maquinaNoEstaRepetida().
            MaquinaIT it = new MaquinaIT();
            for (Validacion val : listValidacion) {
                if (val.getNombreDeCampo().equals(it.getNumeroDeMaquinaPDC().getNombre())) {
                    if (val.isValido()) {
                        _txtNombre.setErrorQuitar();
                        todoValido = true;
                    }else{
                        _txtNombre.setError(val.getMensajeDeError());
                        todoValido = false;
                    }
                }
                
                if (val.getNombreDeCampo().equals(it.getMatriculaPDC().getNombre())) {
                    if (val.isValido()) {
                        _txtMatricula.setErrorQuitar();
                    } else {
                        _txtMatricula.setError(val.getMensajeDeError());
                        todoValido = false;
                    }
                }
            }
        }
        
        if (todoValido) {
            //TRUE modifica, false guarda una nueva refacción. 
            if (modOGuar) {
                //MODIFICAMOS LA REFACCIÓN. 
                if (getCoordinador().maquinaModificar(vo)) {
                    
                    MaquinaHistorialNombresVO mhnVo = new MaquinaHistorialNombresVO();
                    MaquinaVo m2Vo = (MaquinaVo)_listaMaquinas.getSelectValueId();
                    
                    mhnVo.setIdMaquina(vo.getId());
                    mhnVo.setNombreAnterior(m2Vo.getNumeroDeMáquina());
                    getCoordinador().maquinaHistorialNombresGuardar(mhnVo);
                    
                    limpiar();
                    getCoordinador().actualizarTodoLoVisible();
                    JOptionPane.showMessageDialog(this, "Se modificó correctamente la máquina.");
                }else{
                    JOptionPane.showMessageDialog(
                            this, 
                            "Algo paso y no se pudo modificar la refacción.",
                            "Error modificando.", 
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                if (getCoordinador().maquinaGuardar(vo)) {
                    limpiar();
                    getCoordinador().actualizarTodoLoVisible();
                    JOptionPane.showMessageDialog(this, "Se guardo correctamente la máquina.");
                } else {
                    JOptionPane.showMessageDialog(
                            this, 
                            "Algo paso y no se pudo guardar la refacción.",
                            "Error guardando.", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     * Si la lista no tiene seleccionado nada quiere decir que el modelo no existe
     * y hay que dar la posibilidad de añadir uno nuevo. 
     */
    private void abrirGuardarNuevoModelo() {
        if (!_comboMaquinaModelo.contieneElItemEscrito()) {
            if (!_comboMaquinaModelo.getText().isEmpty()) {
                String itemEscrito = _comboMaquinaModelo.getText();
                
                String a = "¿Quieres agregar \""+itemEscrito+"\""
                                    + " como un nuevo modelo de máquina?";
                
                int r = JOptionPane.showConfirmDialog(
                        this,
                        a, 
                        "¿Agregar nuevo modelo?", 
                        JOptionPane.YES_NO_OPTION);
                
                if (r==JOptionPane.YES_OPTION) {
                    getCoordinador().maquinaModeloAbrirDialogoAgregar(itemEscrito);
                        _comboMaquinaModelo.setText(itemEscrito);
                        _comboMaquinaModelo.setFocus();
                }else{
                        _comboMaquinaModelo.setText();
                        _comboMaquinaModelo.setFocus();
                }
            }
        }
    }
}
