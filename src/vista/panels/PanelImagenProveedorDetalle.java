/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.panels;

import controlador.Coordinador;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.vo.ImagenRefaccionVo;
import org.jdesktop.swingx.JXImageView;
import vista.UtilidadesIntefaz.JPanelBase;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesBotones_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesJXViewImage_;

/**
 *
 * @author Particular
 */
public class PanelImagenProveedorDetalle extends JPanelBase {
    private Coordinador coordinador;
    private int idRefaccion;
    
    
    
    UtilidadesJXViewImage_ _ImagenesRefacciones;
    
    
    /**
     * Creates new form DialogoDetalleRefaccion
     */
    public PanelImagenProveedorDetalle() {
        initComponents();
    }

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public int getIdRefaccion() {
        return idRefaccion;
    }

    public void setIdRefaccion(int idRefaccion) {
        this.idRefaccion = idRefaccion;
    }

    
    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    
    
    public void configurar(){
     /*
        =======================================================================
            INICIO CONFIGURACIONES DIALOGO
        ///////////////////////////////////////////////////////////////////////

        Los dialogos nos los estoy configurando de manera complicada. Solo lo
        básico para que funcionen en modal.
        
        */ 
//        setModal(true);
        
        
        
        

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
        
        _ImagenesRefacciones = new UtilidadesJXViewImage_(coordinador);
        
        
        //SETEAMOS LOS COMPONENTES DENTRO DE LA UTILIDAD.
        _ImagenesRefacciones.setComponente(this.imagenView);
        _ImagenesRefacciones.setjLabelContador(getEtiquetaContadorImagenes());
    
     
        //ASIGNAMOS EL TAMAÑO DE CAMPO
        
        //CAMPOS QUE REQUIEREN TEXTO EN MAYUSCULAS.
        
        //CAMPOS NUMÉRICOS
        
        //QUITAMOS LOS ESPACIOS SOBRANTES DESPUES DE DEJAR EL CAMPO.
        
        //TRAVEL POLICY
        
        
        
        //ACCIONES ESPECELIALES.
        
        //ACCIONES DE BOTONES
        UtilidadesBotones_.setEnterYEspacio(getBtnSiguienteImagen());
        UtilidadesBotones_.setEnterYEspacio(getBtnRegresarImagen());
        UtilidadesBotones_.setEnterYEspacio(getBtnAgregarImagen());
        UtilidadesBotones_.setEnterYEspacio(getBtnEliminarImagen());
            
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
        cargarImagenes();
        /* 
        ////////////////////////////////////////////////////////////////////////
            FIN CARGA DE ELEMENTOS 
        ========================================================================
        */
    }
    
    /**
     * Carga las imágenes jalando el vo desde DialogoDetellaRefaccion a travez
     * del coordinador.
     */
    public void cargarImagenes(){
        List<ImagenRefaccionVo> livo = this.getCoordinador().refaccionListaDeImagenesDetalles();
        int i = this.getCoordinador().getDialogoRefaccionDetalle().getIdRefaccion();
        setIdRefaccion(i);
        if (livo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Esta refacción no tiene imágenes.");
        }else{
            _ImagenesRefacciones.limpiarComponenteURL();
            for (ImagenRefaccionVo vo : livo) {

                UtilidadesJXViewImage_.TransporteImagenesURL t;
                t = new UtilidadesJXViewImage_.TransporteImagenesURL();
                    t.setIdImagen(HEIGHT);
                t.setIdImagen(vo.getIdRefaccion());
                t.setNombreImagen(vo.getNombreParaMostrar());
                t.setNombreImagenServidor(vo.getNombreServidor());
                t.setUrl(vo.getUrlImagen());

                _ImagenesRefacciones.addIMagenes(t);

            }
            _ImagenesRefacciones.cargarPrimeraImagen();
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

        imagenView = new org.jdesktop.swingx.JXImageView();
        etiquetaContadorImagenes = new javax.swing.JLabel();
        btnSiguienteImagen = new javax.swing.JButton();
        btnRegresarImagen = new javax.swing.JButton();
        btnAgregarImagen = new javax.swing.JButton();
        btnEliminarImagen = new javax.swing.JButton();

       






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
                .addComponent(btnRegresarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSiguienteImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarImagen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarImagen)
                .addGap(18, 18, 18)
                .addComponent(etiquetaContadorImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        imagenViewLayout.setVerticalGroup(
            imagenViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagenViewLayout.createSequentialGroup()
                .addContainerGap(518, Short.MAX_VALUE)
                .addGroup(imagenViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etiquetaContadorImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(imagenViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSiguienteImagen)
                        .addComponent(btnRegresarImagen)
                        .addGroup(imagenViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarImagen)
                            .addComponent(btnEliminarImagen))))
                .addContainerGap())
        );

        imagenViewLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAgregarImagen, btnEliminarImagen, btnRegresarImagen, btnSiguienteImagen, etiquetaContadorImagenes});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(imagenView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(imagenView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        
    }// </editor-fold>//GEN-END:initComponents
    
    public JButton getBtnAgregarImagen() {
        return btnAgregarImagen;
    }

    public void setBtnAgregarImagen(JButton btnAgregarImagen) {
        this.btnAgregarImagen = btnAgregarImagen;
    }

    public JButton getBtnEliminarImagen() {
        return btnEliminarImagen;
    }

    public void setBtnEliminarImagen(JButton btnEliminarImagen) {
        this.btnEliminarImagen = btnEliminarImagen;
    }

    public JButton getBtnRegresarImagen() {
        return btnRegresarImagen;
    }

    public void setBtnRegresarImagen(JButton btnRegresarImagen) {
        this.btnRegresarImagen = btnRegresarImagen;
    }

    public JButton getBtnSiguienteImagen() {
        return btnSiguienteImagen;
    }

    public void setBtnSiguienteImagen(JButton btnSiguienteImagen) {
        this.btnSiguienteImagen = btnSiguienteImagen;
    }

    public JLabel getEtiquetaContadorImagenes() {
        return etiquetaContadorImagenes;
    }

    public void setEtiquetaContadorImagenes(JLabel etiquetaContadorImagenes) {
        this.etiquetaContadorImagenes = etiquetaContadorImagenes;
    }

    public JXImageView getImagenView() {
        return imagenView;
    }

    public void setImagenView(JXImageView imagenView) {
        this.imagenView = imagenView;
    }
    
    private void btnSiguienteImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteImagenActionPerformed
        _ImagenesRefacciones.imagenSiguiente();
    }//GEN-LAST:event_btnSiguienteImagenActionPerformed

    private void btnRegresarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarImagenActionPerformed
        _ImagenesRefacciones.imagenAnterior();
    }//GEN-LAST:event_btnRegresarImagenActionPerformed

    private void btnEliminarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarImagenActionPerformed
        UtilidadesJXViewImage_.TransporteImagenesURL imagenEliminar = _ImagenesRefacciones.obtenerImagenActual();
        if (imagenEliminar!=null) {
            int r = JOptionPane.showConfirmDialog(
                    this, 
                    "¿Estas segúro que quieres eliminar la imágen?"
                            + "\n Esta acción no se puede deshacer.",
                    "Eliminar imagen.", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE);
            if (r==JOptionPane.YES_OPTION) {
                ImagenRefaccionVo vo = new ImagenRefaccionVo();
                vo.setIdRefaccion(imagenEliminar.getIdImagen());
                vo.setNombreServidor(imagenEliminar.getNombreImagenServidor());
                this.getCoordinador().imagenRefaccionEliminar(vo);
            }
        }
    }//GEN-LAST:event_btnEliminarImagenActionPerformed

    private void btnAgregarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarImagenActionPerformed
        _ImagenesRefacciones.setFiltros(new FileNameExtensionFilter("Imagenes", "jpg", "gif", "png", "tiff", "jpeg"));
        _ImagenesRefacciones.cargarImagenes();
        List<ImagenRefaccionVo> listaiVo = new ArrayList<>();
        List<File> file = _ImagenesRefacciones.getImagenesPorCargar();
        for (File f : file) {
            ImagenRefaccionVo vo = new ImagenRefaccionVo();
            vo.setIdRefaccion(getIdRefaccion());
            vo.setFicheroImagen(f);
            vo.setNombreParaMostrar(f.getName());
            listaiVo.add(vo);
            
        }
        String errorImg = this.getCoordinador().imagenRefaccionGuardarLista(listaiVo);
        if (errorImg!=null) {
               JOptionPane.showMessageDialog(
                            null,
                            "No se cargaron las siguientes imagenes: \n\n" + errorImg,
                            "Error cargando imagenes", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btnAgregarImagenActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cerrar();
    }
    private void cerrar(){
        setVisible(false);
        dispose();
    }//GEN-LAST:event_formWindowClosing

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarImagen;
    private javax.swing.JButton btnEliminarImagen;
    private javax.swing.JButton btnRegresarImagen;
    private javax.swing.JButton btnSiguienteImagen;
    private javax.swing.JLabel etiquetaContadorImagenes;
    private org.jdesktop.swingx.JXImageView imagenView;
    // End of variables declaration//GEN-END:variables
}
