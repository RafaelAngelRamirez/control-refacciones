/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.panels;

import controlador.CoordinadorPaneles;
import controlador.RetrasarEjecucionDeOperacion;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JTextField;
import modelo.InfoTabla.EntradaLoteIT;
import modelo.InfoTabla.ImportanciaIT;
import modelo.InfoTabla.RefaccionIT;
import modelo.InfoTabla.UnidadIT;
import modelo.vo.RefaccionVo;
import vista.UtilidadesIntefaz.ConfiguracionDePanel;
import vista.UtilidadesIntefaz.JPanelBase;
import vista.UtilidadesIntefaz.OperacionesBasicasPorDefinir;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesModeloDeTabla_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesTabla_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesTxt_;

/**
 *
 * @author Particular
 */
public class PanelRefaccionesConsulta extends JPanelBase {

    private static final long serialVersionUID = 1L;
    
    UtilidadesTxt_ _TxtFiltrarRefaccion;
    UtilidadesTabla_ _TablaRefacciones;
    
    
    /**
     * Creates new form GestionDeRefacciones
     */
    public PanelRefaccionesConsulta() {
        initComponents();
        configuracionesDialogo = new ConfiguracionDePanel();
        configuracionesDialogo.setModal(true);
        configuracionesDialogo.setResizable(false);
        configuracionesDialogo.setTitle(CoordinadorPaneles.PANEL_REFACCION_CONSULTAR);
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
        _TxtFiltrarRefaccion = new UtilidadesTxt_(getCoordinador());
        _TablaRefacciones = new UtilidadesTabla_(getCoordinador());
        
        
        //SETEAMOS LOS COMPONENTES DENTRO DE LA UTILIDAD.
        
        _TxtFiltrarRefaccion.setComponente(getTxtBusqueda());
        _TablaRefacciones.setComponente(getTablaRefacciones());
        
       
        //ASIGNAMOS EL TAMAÑO DE CAMPO
        
        _TxtFiltrarRefaccion.setTamanoDeCampo(200);
        
        //CAMPOS QUE REQUIEREN TEXTO EN MAYUSCULAS.
        
        _TxtFiltrarRefaccion.setPermitirSoloMayusculas();
        
        //CAMPOS NUMÉRICOS
        
        //QUITAMOS LOS ESPACIOS SOBRANTES DESPUES DE DEJAR EL CAMPO.
               
        
        //TRAVEL POLICY
        

        //ACCIONES ESPECIALES.
        
        RetrasarEjecucionDeOperacion retrasarBusqueda = new RetrasarEjecucionDeOperacion(this);
        retrasarBusqueda.setOperacion(this::busqueda);
        
            _TxtFiltrarRefaccion.setKeyRelease(retrasarBusqueda::ejecutar, OperacionesBasicasPorDefinir.TECLA_CUALQUIERA);
            _TablaRefacciones.setDobleClick(()->this.mostrarDetalleRefaccion());
        
        
        //ACCIONES DE BOTONES
        
        //ACTUALIZACIONES DE TABLA. 
         opAct.add(RefaccionIT.NOMBRE_TABLA, this::cargarRefaccionesInicio);
         opAct.add(EntradaLoteIT.NOMBRE_TABLA, this::cargarRefaccionesInicio);
         
        
        /*
        ////////////////////////////////////////////////////////////////////////
        FIN SETEO DE UTILIDADES
        ========================================================================
         */
    }
    
    

    public void configurar(){
    }
    public void cargarRefaccionesInicio(){
        this.cargarRefacciones("");
    }
   
    public void busqueda(){
        cargarRefacciones(_TxtFiltrarRefaccion.getText());
    
    }
    
    public void cargarRefacciones(String busqueda){
        List<RefaccionVo> listaVo = this.getCoordinador().refaccionConsultarTodoBusqueda(busqueda);
        RefaccionIT rit = new RefaccionIT();
        UnidadIT uit = new UnidadIT();
        ImportanciaIT iit = new ImportanciaIT();
      
    
        String[] titulos = {
            rit.getIdPDC().getNombreParaMostrar(),
            rit.getCodigoInternoPDC().getNombreParaMostrar(),
            rit.getCodigoProveedorPDC().getNombreParaMostrar(),
            rit.getNombrePDC().getNombreParaMostrar(),
            rit.getDescripcionPDC().getNombreParaMostrar(),
            iit.getImportanciaPDC().getNombreParaMostrar(),
            rit.getStockMaximoPDC().getNombreParaMostrar(),
            rit.getStockMinimoPDC().getNombreParaMostrar(),
            "Existencia",
            uit.getUnidadPDC().getNombreParaMostrar()
            
        };
        UtilidadesModeloDeTabla_ mt = new UtilidadesModeloDeTabla_();
        mt.setTitulosDeLaTabla(titulos);
        
        for (RefaccionVo vo : listaVo) {
            float existencia = getCoordinador().entradaLoteExistencia(vo.getId());
            HashMap<Integer, Object> mapaDatos = new HashMap<>();
            mapaDatos.put(1, vo.getId()+"");
            mapaDatos.put(2, vo.getCodigoInterno());
            mapaDatos.put(3, vo.getCodigoProveedor());
            mapaDatos.put(4, vo.getNombre());
            mapaDatos.put(5, vo.getDescripcion());
            mapaDatos.put(6, (String)vo.getImportancia());
            mapaDatos.put(7, vo.getStockMaximo()+"");
            mapaDatos.put(8, vo.getStockMinimo()+"");
            mapaDatos.put(9, existencia);
            mapaDatos.put(10, (String)vo.getUnidad());
            
            mt.addDatos(mapaDatos);
        }
        _TablaRefacciones.setTamanoMinimoDeColumna(new int[]{      0,   0,   0,   0,   0,   0,   0, 0  ,   0,   0});
        _TablaRefacciones.setTamanoMaximoDeColumna(new int[]{     50, 200, 200,1000,1000, 200, 200, 200, 200, 200});
        _TablaRefacciones.setTamanoPreferidoDeColumna(new int[]{  20, 100, 200,0600,0600,  80, 100, 100, 120, 100});
        _TablaRefacciones.setTableModel(mt);
        
    }
    
    public void mostrarDetalleRefaccion(){
        getCoordinador().refaccionAbrirDetalleRefaccion(_TablaRefacciones.getDatoDeTabla(0)+"");
    }
   
   
    public JTextField getTxtBusqueda() {
        return txtFiltrarRefacciones;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRefacciones = new javax.swing.JTable();
        txtFiltrarRefacciones = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tablaRefacciones.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tablaRefacciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Nueva Refaccion", "Esta tiene que ser una descripcion bastante larga", "IUSSI", "5"},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Descripcion", "Proveedor", "Existencia"
            }
        ));
        tablaRefacciones.setEditingColumn(1);
        tablaRefacciones.setEditingRow(1);
        tablaRefacciones.setRowHeight(27);
        tablaRefacciones.setRowMargin(2);
        tablaRefacciones.setSelectionBackground(new java.awt.Color(0, 153, 255));
        tablaRefacciones.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablaRefacciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tablaRefacciones.setShowVerticalLines(false);
        tablaRefacciones.setSurrendersFocusOnKeystroke(true);
        jScrollPane1.setViewportView(tablaRefacciones);
        tablaRefacciones.getAccessibleContext().setAccessibleDescription("");

        txtFiltrarRefacciones.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtFiltrarRefacciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltrarRefaccionesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_buscar.png"))); // NOI18N
        jLabel1.setText("Filtrar refacciones");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFiltrarRefacciones, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFiltrarRefacciones)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtFiltrarRefacciones.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void txtFiltrarRefaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltrarRefaccionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltrarRefaccionesActionPerformed

    public JTable getTablaRefacciones() {
        return tablaRefacciones;
    }

    /**
     * Retorna todos los id seleccionados.
     */
    public Deque<Integer> getIdSeleccionados(){
        Deque<Integer> i = new ArrayDeque<>();
        List<Object> a = this._TablaRefacciones.getDatoDeTabla_Seleccionados(0);
         for (Object o : a) {
            i.add(Integer.parseInt((String)o));
        }
         return i;
    }
    
    /**
     * Retorna el 1er id seleccionado. 
     * @return Numero de id guadarado en la columna id. 
     */ 
    public int getIdSeleccionado(){
        int a = Integer.parseInt(this._TablaRefacciones.getDatoDeTabla(0)+"");
        return a;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaRefacciones;
    private javax.swing.JTextField txtFiltrarRefacciones;
    // End of variables declaration//GEN-END:variables
}
