/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.panels;

import controlador.CoordinadorPaneles;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.HyperlinkEvent;
import modelo.InfoTabla.EntradaLoteIT;
import modelo.Textos;
import modelo.logica.ComparacionLotes;
import vista.UtilidadesIntefaz.ConfiguracionDePanel;
import vista.UtilidadesIntefaz.JPanelBase;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.ColoresYFuentes;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesTxt_;

/**
 *
 * @author Particular
 */
@SuppressWarnings("serial")
public class PanelSalidaDeLoteCantidadADescontarDeLote extends JPanelBase {
    
    BigDecimal cantidadTotalSalida;
    List<ContenedorDeFila> listContenedorFila = new ArrayList<>();
    
    /**
     * Creates new form PanelSalidaDeLoteCantidadADescontarDeLote
     */
    public PanelSalidaDeLoteCantidadADescontarDeLote() {
        initComponents();
        configuracionesDialogo = new ConfiguracionDePanel();
        configuracionesDialogo.setModal(true);
        configuracionesDialogo.setResizable(false);
        configuracionesDialogo.setTitle(CoordinadorPaneles.PANEL_SALIDA_LOTE_SELECCION_DE_LOTES);
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        panelContenedor = new javax.swing.JPanel();
        etiquetaExistencia = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        etiquetaSalidaRestante = new javax.swing.JLabel();

        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        panelContenedor.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 102, 102), new java.awt.Color(51, 51, 51)));

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        etiquetaExistencia.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaExistencia.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaExistencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaExistencia.setText("Existencia");
        etiquetaExistencia.setOpaque(true);
        etiquetaExistencia.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lote");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Salida");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Modifcar salida por lote.");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Salida restante:");

        etiquetaSalidaRestante.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaSalidaRestante.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaSalidaRestante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaSalidaRestante.setText("  200.00");
        etiquetaSalidaRestante.setOpaque(true);
        etiquetaSalidaRestante.setPreferredSize(new java.awt.Dimension(100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etiquetaExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etiquetaSalidaRestante, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaSalidaRestante, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(33, 33, 33))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(null, "no se ha definido la accion.");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    @Override
    public void configurar() {
        panelContenedor.removeAll();
    }
    
    public void cargarLotes(List<ComparacionLotes>comparacionLotes,float cantidadSalida){
        cantidadTotalSalida = new BigDecimal(cantidadSalida);
        panelContenedor.setLayout(new FlowLayout(FlowLayout.LEADING));
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
        for (ComparacionLotes cl : comparacionLotes) {
            ContenedorDeFila f = new ContenedorDeFila(cl);
            f.setR(()->sumarTodo());
            listContenedorFila.add(f);
            subPanel.add(f);
            subPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }
        JScrollPane jScrollPane = new JScrollPane(subPanel);
        jScrollPane.setPreferredSize(new Dimension(panelContenedor.getSize()));
        panelContenedor.add(jScrollPane);
                
        panelContenedor.validate();
        this.validate();
        etiquetaSalidaRestante.setText(cantidadTotalSalida+"");
        sumarTodo();
        
    
    }
    
    class ContenedorDeFila extends JPanel{
        
        ComparacionLotes cl;
        JLabel etiquetaLote;
        JLabel etiquetaExistencia;
        JTextField recuadroEntrada;
        Runnable r;
        BigDecimal cantidadAgreadaPorUsuario;
        
        UtilidadesTxt_ _txtRecuadroEntrada;

        public ContenedorDeFila(ComparacionLotes cl) {
            this.cl = cl;
            generarFila();
        }

        private void generarFila() {
            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            etiquetaLote = new JLabel();
            etiquetaExistencia = new JLabel();
            recuadroEntrada = new JTextField();
            
            Dimension dimRec = new Dimension(110, 30);
            Dimension dimEti = new Dimension(100, 30);
            
            recuadroEntrada.setPreferredSize(dimRec);
            recuadroEntrada.setMinimumSize(dimRec);
            recuadroEntrada.setMaximumSize(dimRec);
            
            etiquetaExistencia.setPreferredSize(dimEti);
            etiquetaExistencia.setMinimumSize(dimEti);
            etiquetaExistencia.setMaximumSize(dimEti);
            
            etiquetaLote.setAlignmentX(Component.CENTER_ALIGNMENT);
            etiquetaExistencia.setAlignmentX(Component.CENTER_ALIGNMENT);
            recuadroEntrada.setAlignmentX(Component.CENTER_ALIGNMENT);
            
            etiquetaLote.setVerticalAlignment(SwingConstants.CENTER);
            etiquetaExistencia.setHorizontalAlignment(SwingConstants.CENTER);
            etiquetaExistencia.setVerticalAlignment(SwingConstants.CENTER);
            etiquetaLote.setHorizontalAlignment(SwingConstants.CENTER);
            

            etiquetaLote.setOpaque(true);
            etiquetaExistencia.setOpaque(true);
            etiquetaExistencia.setBackground(ColoresYFuentes.TEMA_FONDO_ETIQUETAS_OSCURO);
            
            etiquetaLote.setFont(ColoresYFuentes.FUENTE_ALINEADA);
            etiquetaExistencia.setFont(ColoresYFuentes.FUENTE_ALINEADA);
            recuadroEntrada.setFont(ColoresYFuentes.FUENTE_CUADRO_TEXTO_NORMAL);
            
            EntradaLoteIT eit = new EntradaLoteIT();
            _txtRecuadroEntrada = new UtilidadesTxt_(getCoordinador());
            _txtRecuadroEntrada.setComponente(recuadroEntrada);
            _txtRecuadroEntrada.setTamanoDeCampo(
                    eit.getCantidadPDC().getLongitudDeCaracteres(), 
                    eit.getCantidadPDC().getLongitudDeDecimales());
            _txtRecuadroEntrada.setPermitirSoloNumeros();
            _txtRecuadroEntrada.getThis().setHorizontalAlignment(JTextField.CENTER);
            
            // ASIGNAMOS LOS VALORES PARA LAS ETIQUETAS.
            etiquetaLote.setText(cl.getLote().getNombreParaMostrarLote());
            
            String tExistencia = (cl.getLote().getCantidad()-cl.getExistenciaPreFinal())+"";
            
            etiquetaExistencia.setText(tExistencia);
            recuadroEntrada.setText(cl.getExistenciaPreFinal()+"");
            
            
            add(etiquetaLote);
            add(Box.createRigidArea(new Dimension(10, 0)));
            add(etiquetaExistencia);
            add(Box.createRigidArea(new Dimension(10, 0)));
            add(recuadroEntrada);
                
            validate();
            
            KeyAdapter k = new KeyAdapter() {
                @Override
                // DEFINIMOS LAS ACCIONES PARA CUANDO SE INGRESEN DATOS EN LAS
                // CASILLAS DE CANTIDAD.
                public void keyReleased(KeyEvent e) {
                    //RETORNAMOS EL CAMPO AL QUE ESTAMOS DANDO LA ACCIÓN.
                    JTextField t = (JTextField)e.getComponent();
                    //OBTENEMOS EL TEXTO ESCRITO. 
                    String texto = t.getText();
                    //SI HAY TEXTO HACEMOS LAS SIGUIENTES ACCIONES. 
                    if (!texto.isEmpty()) {
                        //CREAMOS EL NUEVO BIGDECIMAL QUE CONTEDRA LA CANTIDAD
                        // ESCRITA POR EL USUARIO. 
                        cantidadAgreadaPorUsuario = new BigDecimal(texto);
                        //CREAMOS UN NUEVO BIGDECIMAL CON LA EXISTENCIA ACTUAL
                        BigDecimal big = new BigDecimal(cl.getLote().getCantidad());
                        //RESTAMOS LA CANTIDAD INGRESADA POR EL USUARIO 
                        //A LA EXISTECIA ACTUAL.
                        big = big.subtract(cantidadAgreadaPorUsuario);
                        //COLOREAMOS SEGÚN EL CASO. 
                        if (big.signum()==-1) {
                            etiquetaExistencia.setBackground(ColoresYFuentes.ERROR_TXT_RESALTAR_BG);
                            etiquetaExistencia.setForeground(ColoresYFuentes.ERROR_TXT_RESALTAR_FG);
                        }else{
                            etiquetaExistencia.setBackground(ColoresYFuentes.TEMA_FONDO_ETIQUETAS_OSCURO);
                            etiquetaExistencia.setForeground(ColoresYFuentes.TEMA_TXT_FG);
                        }
                        //SETEAMOS LA ETIQUETA. 
                        etiquetaExistencia.setText(big.toString());
                    }else{
                        //SI EL CAMPO ESTA VACIO ENTONCES PONEMOS LA CANTIDAD
                        //AGREGADA POR EL USUARIO EN 0 Y LA ETIQUETA DE EXISTENCIA
                        //LA DEVOLVEMOS A SU
                        cantidadAgreadaPorUsuario = new BigDecimal(0);
                        etiquetaExistencia.setText(0+"");
                    }
                    r.run();
                }
            };
            //AÑADIMOS EL CUADRO AL LISTENER. 
            recuadroEntrada.addKeyListener(k);
        }

        public void setR(Runnable r) {
            this.r = r;
        }

        public BigDecimal getCantidadAgreadaPorUsuario() {
            if (cantidadAgreadaPorUsuario==null) {
                cantidadAgreadaPorUsuario = new BigDecimal(0);
            }
            return cantidadAgreadaPorUsuario;
        }

        public void setCantidadAgreadaPorUsuario(BigDecimal cantidadAgreadaPorUsuario) {
            this.cantidadAgreadaPorUsuario = cantidadAgreadaPorUsuario;
        }
               
        
    }
    
    public void sumarTodo(){
        BigDecimal totalCuadros = new BigDecimal(0);
        for (ContenedorDeFila cF : listContenedorFila) {
//            totalCuadros = totalCuadros.add(cF.);
        }
        
        totalCuadros = cantidadTotalSalida.subtract(totalCuadros);
        if (totalCuadros.signum()==-1) {
            etiquetaSalidaRestante.setBackground(ColoresYFuentes.ERROR_TXT_RESALTAR_BG);
            etiquetaSalidaRestante.setForeground(ColoresYFuentes.ERROR_TXT_RESALTAR_FG);
        }else{
            etiquetaSalidaRestante.setBackground(ColoresYFuentes.TEMA_FONDO_ETIQUETAS_OSCURO);
            etiquetaSalidaRestante.setForeground(ColoresYFuentes.TEMA_TXT_FG);
        }
        etiquetaSalidaRestante.setText( totalCuadros.toString());
        
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etiquetaExistencia;
    private javax.swing.JLabel etiquetaSalidaRestante;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel panelContenedor;
    // End of variables declaration//GEN-END:variables
   
}