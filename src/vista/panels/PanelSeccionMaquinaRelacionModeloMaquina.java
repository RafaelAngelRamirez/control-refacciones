/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.panels;

import controlador.CoordinadorPaneles;
import controlador.HiloConPrecarga;
import controlador.RetrasarEjecucionDeOperacion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.InfoTabla.RefaccionIT;
import modelo.InfoTabla.SeccionDeMaquinaIT;
import modelo.Textos;
import modelo.vo.MaquinaModeloVo;
import modelo.vo.RefaccionVo;
import modelo.vo.SeccionDeMaquinaVO;
import vista.UtilidadesIntefaz.ConfiguracionDePanel;
import vista.UtilidadesIntefaz.ConfirmacionExahustiva;
import vista.UtilidadesIntefaz.JPanelBase;
import vista.UtilidadesIntefaz.OperacionesBasicasPorDefinir;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesBotones_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesListas_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesTxt_;


/**
 *
 * @author Particular
 */
public class PanelSeccionMaquinaRelacionModeloMaquina extends JPanelBase {

    private static final long serialVersionUID = 1L;
    private UtilidadesListas_ _listaModelosMaquinaAsignados;
    private UtilidadesListas_ _listaModelosMaquinaDisponibles;
    private UtilidadesListas_ _listaRefaccionesAsignadas;
    private UtilidadesListas_ _listaRefaccionesDisponibles;
    private UtilidadesListas_ _listaSecciones;
    
    private UtilidadesTxt_ _txtNombre;
    private UtilidadesTxt_ _txtBusqueda;
    
    private SeccionDeMaquinaVO idActual;
    
//    HashMap<MaquinaModeloVo, List<RefaccionVo>> mapaDeRelaciones;
    
    
    
    /**
     * Creates new form PanelSeccionMaquinaRelacionModeloMaquina
     */
    public PanelSeccionMaquinaRelacionModeloMaquina() {
        initComponents();
        configuracionesDialogo = new ConfiguracionDePanel();
        configuracionesDialogo.setModal(false);
        configuracionesDialogo.setResizable(false);
        configuracionesDialogo.setTitle(CoordinadorPaneles.PANEL_SECCION_DE_MAQUINAS);
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

        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        etiquetaNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        etiquetaNombreDeLaRefaccion1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaSecciones = new javax.swing.JList<>();
        btnGuardar = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        listaModelosMaquinaAsignados = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        listaModelosMaquinaDisponibles = new javax.swing.JList<>();
        etiquetaNombreDeLaRefaccion = new javax.swing.JLabel();
        etiquetaNombreDeLaRefaccion3 = new javax.swing.JLabel();
        etiquetaNombreDeLaRefaccion4 = new javax.swing.JLabel();
        etiquetaNombreDeLaRefaccion5 = new javax.swing.JLabel();
        etiquetaNombreDeLaRefaccion6 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        listaRefaccionesAsignadas = new javax.swing.JList<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        listaRefaccionesDisponibles = new javax.swing.JList<>();
        btnLimpiar = new javax.swing.JButton();
        txtBusqueda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        etiquetaNombreDeLaRefaccion7 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_tache.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(737, 835, -1, -1));

        btnEliminar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_tache.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(744, 83, -1, -1));

        etiquetaNombre.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaNombre.setText("Nombre.");
        add(etiquetaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 93, -1, -1));

        txtNombre.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setMaximumSize(new java.awt.Dimension(395, 2147483647));
        txtNombre.setMinimumSize(new java.awt.Dimension(395, 35));
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 122, 562, 35));

        etiquetaNombreDeLaRefaccion1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaNombreDeLaRefaccion1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_titulo_SeccionMaquina Registro y asignacion de secciones.png"))); // NOI18N
        etiquetaNombreDeLaRefaccion1.setText("Registrar/modificar seccion");
        add(etiquetaNombreDeLaRefaccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 6, 361, 42));

        listaSecciones.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        listaSecciones.setFocusable(false);
        jScrollPane5.setViewportView(listaSecciones);

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 359, 147));

        btnGuardar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_palomita.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(842, 835, -1, -1));

        listaModelosMaquinaAsignados.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        listaModelosMaquinaAsignados.setFocusable(false);
        jScrollPane6.setViewportView(listaModelosMaquinaAsignados);

        add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 215, 569, -1));

        listaModelosMaquinaDisponibles.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        listaModelosMaquinaDisponibles.setFocusable(false);
        jScrollPane7.setViewportView(listaModelosMaquinaDisponibles);

        add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 215, 358, -1));

        etiquetaNombreDeLaRefaccion.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        etiquetaNombreDeLaRefaccion.setText("Modelos disponibles.");
        add(etiquetaNombreDeLaRefaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 192, 270, -1));

        etiquetaNombreDeLaRefaccion3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        etiquetaNombreDeLaRefaccion3.setText("Modelos asignados.");
        add(etiquetaNombreDeLaRefaccion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 192, 270, -1));

        etiquetaNombreDeLaRefaccion4.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaNombreDeLaRefaccion4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaNombreDeLaRefaccion4.setText("Selecciona un modelo de máquina de la lista de \"Modelos asignados\" para relacionarlo con una o varias refacciones. ");
        etiquetaNombreDeLaRefaccion4.setOpaque(true);
        add(etiquetaNombreDeLaRefaccion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 354, 933, -1));

        etiquetaNombreDeLaRefaccion5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        etiquetaNombreDeLaRefaccion5.setText("Refacciones disponibles.");
        add(etiquetaNombreDeLaRefaccion5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 404, 270, -1));

        etiquetaNombreDeLaRefaccion6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        etiquetaNombreDeLaRefaccion6.setText("Refacciones asignadas.");
        add(etiquetaNombreDeLaRefaccion6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 623, 270, -1));

        listaRefaccionesAsignadas.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        listaRefaccionesAsignadas.setFocusable(false);
        jScrollPane8.setViewportView(listaRefaccionesAsignadas);

        add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 643, 933, 185));

        listaRefaccionesDisponibles.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        listaRefaccionesDisponibles.setFocusable(false);
        jScrollPane9.setViewportView(listaRefaccionesDisponibles);

        add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 427, 933, 185));

        btnLimpiar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(846, 83, -1, -1));

        txtBusqueda.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtBusqueda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBusqueda.setMaximumSize(new java.awt.Dimension(395, 2147483647));
        txtBusqueda.setMinimumSize(new java.awt.Dimension(395, 35));
        add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 386, 539, 35));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_buscar.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 386, -1, 31));

        etiquetaNombreDeLaRefaccion7.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaNombreDeLaRefaccion7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaNombreDeLaRefaccion7.setText("Asignar sección a modelo de máquina.");
        etiquetaNombreDeLaRefaccion7.setOpaque(true);
        add(etiquetaNombreDeLaRefaccion7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 163, 933, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarSeccion();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (idActual==null) {
            guardarNuevaSeccion();
        }else{
            modificarSeccion();
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaNombreDeLaRefaccion;
    private javax.swing.JLabel etiquetaNombreDeLaRefaccion1;
    private javax.swing.JLabel etiquetaNombreDeLaRefaccion3;
    private javax.swing.JLabel etiquetaNombreDeLaRefaccion4;
    private javax.swing.JLabel etiquetaNombreDeLaRefaccion5;
    private javax.swing.JLabel etiquetaNombreDeLaRefaccion6;
    private javax.swing.JLabel etiquetaNombreDeLaRefaccion7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JList<String> listaModelosMaquinaAsignados;
    private javax.swing.JList<String> listaModelosMaquinaDisponibles;
    private javax.swing.JList<String> listaRefaccionesAsignadas;
    private javax.swing.JList<String> listaRefaccionesDisponibles;
    private javax.swing.JList<String> listaSecciones;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public void initConfig() {
           /*
        =======================================================================
            INICIO SETEO NOMBRES DE ETIQUETA
        ///////////////////////////////////////////////////////////////////////
        */
        etiquetaNombre.setText(SeccionDeMaquinaIT.getNOMBRE_SECCION().getNombreParaMostrar());
        
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
        _listaModelosMaquinaAsignados = new UtilidadesListas_(getCoordinador());
        _listaModelosMaquinaDisponibles = new UtilidadesListas_(getCoordinador());
        _listaRefaccionesAsignadas = new UtilidadesListas_(getCoordinador());
        _listaRefaccionesDisponibles = new UtilidadesListas_(getCoordinador());
        _listaSecciones = new UtilidadesListas_(getCoordinador());
        
        _txtNombre = new UtilidadesTxt_(getCoordinador());
        _txtBusqueda = new UtilidadesTxt_(getCoordinador());
        
        //SETEAMOS LOS COMPONENTES DENTRO DE LA UTILIDAD.
        
       _listaModelosMaquinaDisponibles.setComponente(listaModelosMaquinaDisponibles);
       _listaModelosMaquinaAsignados.setComponente(listaModelosMaquinaAsignados);
       _listaModelosMaquinaDisponibles.setComponenteListaAAgregar(_listaModelosMaquinaAsignados);
       
       _listaRefaccionesDisponibles.setComponente(listaRefaccionesDisponibles);
       _listaRefaccionesAsignadas.setComponente(listaRefaccionesAsignadas);
       
       _listaSecciones.setComponente(listaSecciones);
       
       _txtNombre.setComponente(txtNombre);
       _txtBusqueda.setComponente(txtBusqueda);
              
        
        //ASIGNAMOS EL TAMAÑO DE CAMPO
        
        _txtNombre.setTamanoDeCampo(SeccionDeMaquinaIT.getNOMBRE_SECCION().getLongitudDeCaracteres());
        _txtBusqueda.setTamanoDeCampo(200);
        
        //CAMPOS QUE REQUIEREN TEXTO EN MAYUSCULAS.
        _txtNombre.setPermitirSoloMayusculas();
        _txtBusqueda.setPermitirSoloMayusculas();
        
        //CAMPOS NUMÉRICOS
        
        
        //QUITAMOS LOS ESPACIOS SOBRANTES DESPUES DE DEJAR EL CAMPO.
        _txtNombre.setEspaciosEnBlanco();
        _txtBusqueda.setEspaciosEnBlanco();

        //TRAVEL POLICY
        
        _txtNombre.setNextFocusableComponent(btnGuardar);
        btnGuardar.setNextFocusableComponent(btnCancelar);
        btnCancelar.setNextFocusableComponent(btnEliminar);
        btnEliminar.setNextFocusableComponent(btnLimpiar);
        btnLimpiar.setNextFocusableComponent(_txtNombre.getThis());
        
        //ACCIONES ESPECELIALES.            /*Cargar las secciones seleccionadas*/
        _listaSecciones.setValueChange(this::cargarDatosDeListaParaModificar);
        
        _listaModelosMaquinaDisponibles.setValueChange(()->_listaModelosMaquinaDisponibles.cambioEntreListas(false));
        _listaModelosMaquinaAsignados.setValueChange(()->_listaModelosMaquinaDisponibles.cambioEntreListas(true));
        
        _listaRefaccionesDisponibles.setValueChange(this::seleccionarRefaccionCompatible);
        _listaRefaccionesAsignadas.setValueChange(this::quitarRefaccionCompatible);
        
            /*Carga las refacciones compatibles o las quita*/
            
        RetrasarEjecucionDeOperacion tempCargaAgregar = new RetrasarEjecucionDeOperacion(this);
        tempCargaAgregar.setTiempoDeRetraso(500);
        tempCargaAgregar.setOperacion(this::cargarListaDeRefaccionesParaSeleccionar);
        
        RetrasarEjecucionDeOperacion tempCargaEliminar = new RetrasarEjecucionDeOperacion(this);
        tempCargaEliminar.setTiempoDeRetraso(500);
        tempCargaEliminar.setOperacion(this::quitarDeLaListaDeRefacciones);
            
        _listaModelosMaquinaDisponibles.addOperacionAlIntercambiarItem(tempCargaAgregar::ejecutar, false);
        _listaModelosMaquinaDisponibles.addOperacionAlIntercambiarItem(tempCargaEliminar::ejecutar, true);
        
        
        RetrasarEjecucionDeOperacion tempBusqueda = new RetrasarEjecucionDeOperacion(this);
        tempBusqueda.setTiempoDeRetraso(400);
        tempBusqueda.setOperacion(this::filtrarRefaccionesDisponibles);
        
        
            /*Filtra las refacciones*/
        _txtBusqueda.setKeyRelease(tempBusqueda::ejecutar, OperacionesBasicasPorDefinir.TECLA_CUALQUIERA);

            /**/
        
        
        //ACCIONES DE BOTONES
        UtilidadesBotones_.setEnterYEspacio(btnCancelar);
        UtilidadesBotones_.setEnterYEspacio(btnEliminar);
        UtilidadesBotones_.setEnterYEspacio(btnGuardar);
        UtilidadesBotones_.setEnterYEspacio(btnLimpiar);
        
        //OPERACIONES DE ACTUALIZACION
        
        opAct.add(SeccionDeMaquinaIT.NOMBRE_TABLA, this::cargarListaSecciones);
        opAct.add(SeccionDeMaquinaIT.NOMBRE_TABLA, this::cargarListaMaqModelo);
        
        /* 
        ////////////////////////////////////////////////////////////////////////
            FIN SETEO DE UTILIDADES
        ========================================================================
        */
        
    }

    @Override
    public void configurar() {

    }

    private void cancelar() {
        limpiar();
        dispose();
    }

    private void cargarListaSecciones() {
        _listaSecciones.limpiar();
        List<SeccionDeMaquinaVO> listVO = getCoordinador().seccionDeMaquinaConsultar();
        HashMap<String, Object> mapa = new HashMap<>();
        
        for (SeccionDeMaquinaVO v : listVO) {
            mapa.put(v.getNombreSeccion(), v);
        }
        
        _listaSecciones.cargarLista(mapa);

    }
    
    /**
     * Carga los datos para modificarlos de la sección que se seleccione de la
     * lista.  
     */
    @SuppressWarnings("unchecked")
    private void cargarDatosDeListaParaModificar(){
        limpiar();
        Object o = _listaSecciones.getSelectValueObject();
        if (!o.equals(-1)) {
            SeccionDeMaquinaVO v = (SeccionDeMaquinaVO)o;
            _txtNombre.setText(v.getNombreSeccion());
            idActual = v;
            
            //OBTENEMOS LA LISTA DE LOS MODELOS RELACCIONADOS C
            //QUE YA ESTABAN ASGINADOS.
            List<MaquinaModeloVo> listVOQuitar = getCoordinador().maquinaModeloRelacionSeccion(idActual);
            //CARGAMOS LA LISTA DE MODELOS DE MÁQUINA. 
            cargarListaMaqModelo(listVOQuitar);
        }else{
            cargarListaRefacciones();
        }
    }
     
    /**
     * Esta operación carga todas los modelos de máquina.  
     */
    private void cargarListaMaqModelo() {
        cargarListaMaqModelo(null);
    }
    
    /**
     * Con esta operacion cargamos la lista de máquinas modelos para guardar una
     * nueva o para modificarla. Si se le pasa el parametro en null se cargaran
     * todas los modelos de maquina disponibles. 
     */
    private void cargarListaMaqModelo(List<MaquinaModeloVo>listMaquinaModeloAsigandos) {
        //LIMPIAMOS LA LISTA MAQUINAS MODELO DISPONIBLES. 
        _listaModelosMaquinaDisponibles.limpiar();
        
        //EN ESTA LISTA ALAMACENAREMOS TODAS LOS MODELOS DE MÁQUINA EXISTENTES. 
        List<MaquinaModeloVo> listMMVOdisponibles ;
        
        //SI NO LE PASAMOS NINGÚNA REFACCIÓN QUIERE DECIR QUE NO SE HA SELECCIONADO
        // NADA DE LA LISTA DE SECCIÓNES Y ES UNA NUEVA SEECCION
        if (listMaquinaModeloAsigandos==null) {
            //CARGAMOS TODOS LOS MODELOS DISPONIBLES. 
            listMMVOdisponibles = getCoordinador().maquinaModeloConsultar();
            //EL MAPA CON EL CARGAREMOS LOS DATOS
            HashMap<String, Object> mapa = new HashMap<>();
            //PASAMO LOS DATOS AL MAPA. 
            listMMVOdisponibles.forEach(vo->{
                mapa.put(vo.getModelo()+" "+vo.getAnio(), vo);
            });
            //CARGAMOS LA LISTA
            _listaModelosMaquinaDisponibles.cargarLista(mapa);
            
        } else {
            //LA LISTA listMaquinaModeloAsignados CONTENIA ELEMENTOS Y PORTANDO
            //QUIERE DECIR QUE ES UNA SECCIÓN QUE SE VA A MODIFICAR. 
            
            //CARGAMOS LOS MODELOS DE MAQUINA DISPONIBLES. 
            listMMVOdisponibles = getCoordinador().maquinaModeloConsultar();
            //CARGAMOS LAS MAQUINAS QUE YA HABIAN SIDO ASIGNADAS A ESTA SECCION.

            //ELIMINAMOS LOS MODELOS DE MAQUINA YA SELECCIONADOS DE LOS DISPONIBLES. 
            listMaquinaModeloAsigandos.forEach(vo->{
                if (listMMVOdisponibles.contains(vo)) {
                    listMMVOdisponibles.remove(vo);
                }
            });
            
            //LOS MAPAS PARA CARGAR LAS LISTAS
            HashMap<String, Object> mapaAsignados = new HashMap<>();
            HashMap<String, Object> mapaDisponibles = new HashMap<>();
            
            //PASAMOS LOS DATOS DE LA LISTA A LOS MAPAS
            listMMVOdisponibles.forEach(vo->{
                mapaDisponibles.put(vo.getModelo()+" "+vo.getAnio(), vo);
            });
            
            listMaquinaModeloAsigandos.forEach(vo->{
                mapaAsignados.put(vo.getModelo()+" "+vo.getAnio(), vo);
            });
            
            //CARGAMOS LAS LISTAS. 
            _listaModelosMaquinaDisponibles.cargarLista(mapaDisponibles);
            _listaModelosMaquinaAsignados.cargarLista(mapaAsignados);
            
        }
    }    
    
    /**
     *Carga en la lista de refacciones disponibles las refacciones que son
     * compatibles con el modelo y si ya hay algúna relación con la sección  
     * (modificar una seccion) carga las refacciones ya seleccionadas. 
     *
     */
    private void cargarListaRefacciones(){
        if (idActual== null) {
            cargarListaDeRefaccionesParaGuardarNuevo();
        }else{
            cargarListaDeRefaccionesParaSeleccionar();
        }
    }
    
    private void eliminarSeccion() {
        Object a = _listaSecciones.getSelectValueObject();
        if (!a.equals(-1)) {
            SeccionDeMaquinaVO seccionDeMaquinaVO = (SeccionDeMaquinaVO)a;
            
            String m1 = "¿Estas segúro que quieres eliminar esta sección?";
            String m2 = "¿Estas muy segúro que quieres eliminar esta sección? Esta acción no se puede deshacer y perjudicara "
                    + " los registros que tienen relación con esta sección \n"
                    + " independientemente del modelo o refacción.¿Aun así quieres hacerlo?";
            int r = ConfirmacionExahustiva.confirmarEliminacionPeligrosa(m1, m2);
            if (r==ConfirmacionExahustiva.SI_ELIMINAR) {
                if (getCoordinador().seccionDeMaquinaEliminar(seccionDeMaquinaVO)) {
                    getCoordinador().actualizarTodoLoVisible();
                    JOptionPane.showMessageDialog(this, "Se eliminó la sección.");
                }else{
                    JOptionPane.showMessageDialog(this, "Álgo paso y no se pudo eliminar la sección.");
                }
            }
        }
    }

    /**
     * Guarda las nuevas relaciones entre las secciones y las refacciones.  
     */
    private void guardarNuevaSeccion(){
        JOptionPane.showMessageDialog(null, "pendiente!! guardar nueva seccion");
    }
    
    private void modificarSeccion(){
        
        JOptionPane.showMessageDialog(null, "pendiente!! modificar seccion");
    }
    
    @Override
    public void limpiar(){
        mapaDeRefaccionesSeleccionadas.clear();
        idActual = null;
        cargarListaMaqModelo();
        _listaRefaccionesAsignadas.limpiar();
        _listaRefaccionesDisponibles.limpiar();
    }

    
    
    private void cargarListaDeRefaccionesParaSeleccionar() {
        HiloConPrecarga h = 
                new HiloConPrecarga(
                        this::cargarListaDeRefaccionesParaSeleccionar_operacion, 
                        getCoordinador().getPanelCarga());
        h.start();
    }
    
    private void cargarListaDeRefaccionesParaSeleccionar_operacion() {
        //SELECCIONAMOS LA LISTA DE REFACCIONES QUE ESTAN ASIGNADAS Y LAS
        //UTILIZAMOS PARA FILTRAR LAS REFACCIONES QUE SERAN COMPATIBLES CON
        // ESTA SECCIÓN.
        
        
        // OBTENEMOS LOS MODELOS SELECCIONADOS. 
        @SuppressWarnings("unchecked")
        List<MaquinaModeloVo> listMMVOAsignados =
                (List<MaquinaModeloVo>)(List<?>) _listaModelosMaquinaAsignados.getItems_ObjectsRelacionados();
        if (!listMMVOAsignados.isEmpty()) {
            filtrarRefaccionesDisponibles();
        }else{
            _listaRefaccionesDisponibles.limpiar();
        }
    }
    
    /**
     * Carga las refacciones en la lista de refacciones disponibles con el formato
     * que ya se definio. 
     */
    private void cargarRefaccioneEnListaDisponibles(List<RefaccionVo> listRVO){
        
        //CARGAMOS LA LISTA DE DISPONIBLES.
        _listaRefaccionesDisponibles.limpiar();
        HashMap<String, Object> mapaDisponibles = new HashMap<>();

        listRVO.forEach(
                rvo->{
                    String a  = Textos.formatearEspacios(
                            RefaccionIT.getCODIGO_PROVEEDOR().getLongitudDeCaracteres(), 
                            rvo.getCodigoProveedor(), "|");
                    String b  = Textos.formatearEspacios(
                            RefaccionIT.getCODIGO_INTERNO().getLongitudDeCaracteres(), 
                            rvo.getCodigoInterno(), "|");
                    String c  = Textos.formatearEspacios(45, rvo.getNombre(), "|");
                    
                    //SI LA REFACCIÓN YA LA TENEMOS SELECCIONADA ENTONCES NO LA MOSTRAMOS
                    if(!mapaDeRefaccionesSeleccionadas.containsKey(a+b+c)){
                        mapaDisponibles.put(c+a+b, rvo);
                    }
                });
        

        _listaRefaccionesDisponibles.cargarLista(mapaDisponibles);
    }

    private void cargarListaDeRefaccionesParaGuardarNuevo() {
        JOptionPane.showMessageDialog(null, "pendiente cargar lista de refacciones para guardar nuevo");
    }
    
    
    /**
     * Filtra las refacciones tomando en cuenta la lista de maquinas modelos 
     * asignadas. 
     * 
     * @param agregandoLimpiando True cuando se este agregando, false cuando se este limpiando.
     */
    @SuppressWarnings("unchecked")
    private void filtrarRefaccionesDisponibles() {
        if (!_listaModelosMaquinaAsignados.isEmpty()) {
            //HAY MAQUINAS MODELO ASIGNADAS.
            if (!_txtBusqueda.equals("")) {
                //EL CAMPO DE BUSQUEDA NO ESTA VACIO.
                List<MaquinaModeloVo> listMMVo = 
                        (List<MaquinaModeloVo>)(List<?>)_listaModelosMaquinaAsignados.getItems_ObjectsRelacionados();

                List<RefaccionVo> listRVO = 
                        getCoordinador().refaccionConsultarCompatiblesConMaquinaModelo(
                                listMMVo, _txtBusqueda.getText());
                
                listRVO = filtrarRefaccionesYaAsignadas_Agregando(listRVO);
                cargarRefaccioneEnListaDisponibles(listRVO);
            }else{
                //EL CAMPO DE BUSQUEDA ESTA VACIO. CARGAMOS TODO. 
                List<MaquinaModeloVo> listMMVo = 
                        (List<MaquinaModeloVo>)(List<?>)_listaModelosMaquinaAsignados.getItems_ObjectsRelacionados();

                List<RefaccionVo> listRVO = 
                        getCoordinador().refaccionConsultarCompatiblesConMaquinaModelo(
                                listMMVo);
                
                listRVO = filtrarRefaccionesYaAsignadas_Agregando(listRVO);
                cargarRefaccioneEnListaDisponibles(listRVO);
            }
        }else{
            //SI NO HAY MAQUINAS MODELO SELECCIONADAS ENTONCES LIMPIAMOS LAS 
            //REFACCIONES.
            _listaRefaccionesDisponibles.limpiar();
        }
    }
    
    /**
     * Esta operación se encarga de filtrar las refacciones existentes cuando se 
     * ejecuta una busqueda. 
     */
    private List<RefaccionVo> filtrarRefaccionesYaAsignadas_Agregando(List<RefaccionVo> listRVO){
        // BUSCAMOS SI LA LISTA CONTIENE ELEMENTOS REPETIDOS QUE YA FUERON AGREGADOS EL MAPA
        // DE REFACCIONES SELECCIONADAS.
        List<RefaccionVo> listaRemover = new ArrayList<>();
        mapaDeRefaccionesSeleccionadas.forEach((String t, Object o)->{
            listRVO.forEach((rvo)->{
                RefaccionVo vo = (RefaccionVo)o;
                if (rvo.getId()== vo.getId()) {
                    listaRemover.add(rvo);
                }
            });
        });
        
        listRVO.removeAll(listaRemover);
        
        return listRVO;
        
    }
    
    
    HashMap<String, Object>mapaDeRefaccionesSeleccionadas = new HashMap<>();
    /**
     * Esta función pasa el item que se seleccione a la lista de refacciones 
     * asignadas y la elimina de la otra. Tambien revisa que este limpia de
     * las refacciones ya asignadas. 
     */ 
    private void seleccionarRefaccionCompatible() {
        //PRIMERO OBTENEMOS EL VALOR SELECCIONADO QUE DESENCADEMO EL CAMBIO 
        // A LA OTRA LISTA.
        Object a = _listaRefaccionesDisponibles.getSelectValueObject();
        if (!a.equals(-1)) {
            
            RefaccionVo rvoSeleccionado = (RefaccionVo) a;
            String nombre = _listaRefaccionesDisponibles.getText();

            //LO CARGAMOS AL MAPA.
            mapaDeRefaccionesSeleccionadas.put(nombre, rvoSeleccionado);

            _listaRefaccionesAsignadas.limpiar();
            _listaRefaccionesAsignadas.cargarLista(mapaDeRefaccionesSeleccionadas);

            //AHORA LO QUITAMOS DE LA OTRA LISTA.
            _listaRefaccionesDisponibles.removeElement(nombre);
        }
    }

    /**
     *Esta función quita el item que estaba seleccionado de la lista de refacciones
     * asignadas y lo devuelve a las disponibles.
     */
    private void quitarRefaccionCompatible() {
        //OBTENEMOS EL VALOR QUE VAMOS A QUITAR. 
        Object a = _listaRefaccionesAsignadas.getSelectValueObject();
        if (!a.equals(-1)) {
            RefaccionVo rvoSeleccionado = (RefaccionVo) a;
            String nombre = _listaRefaccionesAsignadas.getText();
                        
            //LO QUITAMOS DEL MAPA. 
            mapaDeRefaccionesSeleccionadas.remove(nombre);
            
            
            //QUITAMOS DE LA LISTA DE ASIGNADOS.
            _listaRefaccionesAsignadas.removeElement(nombre);
            
            //OBTENEMOS LA LISTA TEMP.
            @SuppressWarnings("unchecked")
            HashMap<String, Object> mapaTem = new HashMap<>();
            _listaRefaccionesDisponibles.getRelacionDatoId().forEach((Object key, Object value) -> {
                mapaTem.put(key.toString(), value);
            });
            
            
            //AÑADIMOS EL ELEMENTO QUE HABIAMOS QUITADO.
            mapaTem.put(nombre, rvoSeleccionado);

            //CARGAMOS LA LISTA DE DISPONIBLES CON EL MAPA TEMP.
            _listaRefaccionesDisponibles.limpiar(); 
            _listaRefaccionesDisponibles.cargarLista(mapaTem);
            
            
        }
        
    }

    /**
     * Elimina la maquina seleccionada y revisa que las refacciones que esten
     * seleccionadas no contengan refacciones que no correspondan contra la lista
     * de las que si estan seleccionadas. 
     */
    @SuppressWarnings("unchecked")
    private void quitarDeLaListaDeRefacciones() {
        HiloConPrecarga h = new HiloConPrecarga(
                this::quitarDeLaListaDeRefacciones_Operaciones, 
                getCoordinador().getPanelCarga());
        h.start();
    }
    @SuppressWarnings("unchecked")
    private void quitarDeLaListaDeRefacciones_Operaciones() {
        
        //SI LA LISTA DE ASIGNADOS CONTIENE ALGO CONTINUAMOS, SI NO LIMPIAMOS.
        if (!_listaModelosMaquinaAsignados.isEmpty()) {
            
            List<RefaccionVo> listRVOCompatibles;
            _txtBusqueda.setText();
            //OBTENEMOS LOS MODELOS ASIGNADOS.
            List<MaquinaModeloVo> listMMVO = 
                    (List<MaquinaModeloVo>)(List<?>)
                    _listaModelosMaquinaAsignados.getItems_ObjectsRelacionados();

//            OBTENEMOS TODAS LAS REFACCIONES COMPATIBLES. 
            listRVOCompatibles = 
                    getCoordinador().refaccionConsultarCompatiblesConMaquinaModelo(listMMVO);

                //AHORA REVISAMOS LAS REFACCIONES QUE YA NO SON COMPATIBLES Y
                // QUE ESTAN EN EL MAPA. LAS FILTRAMOS AQUI.
            listRVOCompatibles = filtrarRefaccionesYaAsignadas_Limpiando(listRVOCompatibles);
            cargarRefaccioneEnListaDisponibles(listRVOCompatibles);
            filtrarRefaccionesDisponibles();
        }else{
            mapaDeRefaccionesSeleccionadas.clear();
            _listaRefaccionesDisponibles.limpiar();
            _listaRefaccionesAsignadas.limpiar();
        }
    }

    /**
     * Filtra las refacciones que ya no son compatibles y quita de la 
     * lista las que ya no deben estar. 
     */
    private List<RefaccionVo> filtrarRefaccionesYaAsignadas_Limpiando(List<RefaccionVo> listRVOCompatibles) {
        List<String> dejarEnElMapa = new ArrayList<>();
        mapaDeRefaccionesSeleccionadas.forEach((String t, Object o)->{
            RefaccionVo vo = (RefaccionVo)o;
            listRVOCompatibles.forEach((RefaccionVo rvo) -> {
                if (rvo.getId()==vo.getId()) {
                    dejarEnElMapa.add(t);
                    return;
                }
            });
        });
        
        HashMap<String,Object> mapaTemp = new HashMap<>();
        dejarEnElMapa.forEach(t->{
            
            if (mapaDeRefaccionesSeleccionadas.containsKey(t)) {
                mapaTemp.put(t, mapaDeRefaccionesSeleccionadas.get(t));
            }
        });
        
        mapaDeRefaccionesSeleccionadas.clear();
        mapaDeRefaccionesSeleccionadas.putAll(mapaTemp);
        
        _listaRefaccionesAsignadas.limpiar();
        _listaRefaccionesAsignadas.cargarLista(mapaDeRefaccionesSeleccionadas);
        
               
        return filtrarRefaccionesYaAsignadas_Agregando(listRVOCompatibles);

    }
    

}

