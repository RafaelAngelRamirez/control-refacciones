/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.panels;

import javax.swing.JPanel;

/**
 *
 * @author Particular
 */
public class PanelCarga extends JPanel{

    private static final long serialVersionUID = 1L;
    /**
     * Creates new form JPanelCarga
     */
    public PanelCarga() {
        initComponents();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaTexto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiquetaTexto.setBackground(new java.awt.Color(0, 67, 115));
        etiquetaTexto.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        etiquetaTexto.setForeground(new java.awt.Color(255, 255, 255));
        etiquetaTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaTexto.setText("CARGANDO");
        add(etiquetaTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 420, 20));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/precarga.gif"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 180));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etiquetaTexto;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    
}